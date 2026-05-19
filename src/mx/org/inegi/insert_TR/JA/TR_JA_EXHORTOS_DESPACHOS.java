/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TR.JA;

import static Pantallas_JA.IntegraJA_TR.RutaAr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.JA_TR.BeanTR_JA_EXHORTOS_DESPACHOS;
import mx.org.inegi.conexion.JA.OracleDAOFactoryJA;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.CallableStatement;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class TR_JA_EXHORTOS_DESPACHOS {
    
    public static int CFilas2 = 0;

public void TR_JA_EXHORTOS_DESPACHOS() throws Exception {

    Connection con = null;
    int CFilas = 0;

    System.out.println("==============================");
    System.out.println("Leyendo EXHORTOS_DESPACHOS: " + RutaAr);
    System.out.println("==============================");

    ArrayList<BeanTR_JA_EXHORTOS_DESPACHOS> ad = new ArrayList<>();
    DataFormatter formatter = new DataFormatter();

    try (FileInputStream fis = new FileInputStream(RutaAr);
         Workbook workbook = new XSSFWorkbook(fis)) {
        con = OracleDAOFactoryJA.creaConexion();
        Sheet sheet = workbook.getSheet("Exhortos_despachos");
        if (sheet == null) {
            JOptionPane.showMessageDialog( null, "No existe la hoja EXHORTOS_DESPACHOS");
            return;
        }
        boolean datosEncontrados = false;
        for (Row row : sheet) {Cell nombreCell = row.getCell(0);if (nombreCell == null) {
                continue;
            }String nombreOrgano = formatter.formatCellValue(nombreCell).trim();// Empezar cuando encuentre "TRIBUNAL"
            if (!datosEncontrados && nombreOrgano.toUpperCase().startsWith("TRIBUNAL")) {   
                datosEncontrados = true;    
                System.out.println( "Datos encontrados. Iniciando lectura desde fila: " + row.getRowNum());
            }// Si aún no encuentra TRIBUNAL
            if (!datosEncontrados) {
                continue;
            }// Saltar filas vacías
            if (nombreOrgano.isEmpty() || !nombreOrgano.toUpperCase().startsWith("TRIBUNAL")) {    
                continue;
            }
            BeanTR_JA_EXHORTOS_DESPACHOS c = new BeanTR_JA_EXHORTOS_DESPACHOS();
            c.SetNOMBRE_ORGANO_JURIS( formatter.formatCellValue(row.getCell(0)));
            c.SetCLAVE_ORGANO(  formatter.formatCellValue(row.getCell(1)));
            c.SetPERIODO( formatter.formatCellValue(row.getCell(2)));
            c.SetEXH_RECIBIDOS( formatter.formatCellValue(row.getCell(3)));
            c.SetEXH_DILIGENCIADOS(  formatter.formatCellValue(row.getCell(4)));
            c.SetEXH_FORMULADOS( formatter.formatCellValue(row.getCell(5)));
            c.SetEXH_DILIG_RECIBIDOS( formatter.formatCellValue(row.getCell(6)));
            c.SetDESPACH_RECIB_NOTI( formatter.formatCellValue(row.getCell(7)));
            c.SetDESPACH_RECIB_EJEC( formatter.formatCellValue(row.getCell(8)));
            c.SetDESPACH_RECIB_OTRAS( formatter.formatCellValue(row.getCell(9)));
            c.SetDESPACH_DILIG_NOTI( formatter.formatCellValue(row.getCell(10)));
            c.SetDESPACH_DILIG_EJEC( formatter.formatCellValue(row.getCell(11)));
            c.SetDESPACH_DILIG_OTRAS( formatter.formatCellValue(row.getCell(12)));
            c.SetCOMENTARIOS( formatter.formatCellValue(row.getCell(13)));
            ad.add(c);
            CFilas++;
        }

        System.out.println( "========Total de filas leídas: " + CFilas + "========");
        CFilas2 = CFilas;

        if (!ad.isEmpty()) {
            sendToOracle(ad);
        } else {
            JOptionPane.showMessageDialog( null, "Pestaña Exhortos_despachos sin registros");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private void sendToOracle(ArrayList<BeanTR_JA_EXHORTOS_DESPACHOS> datos) throws SQLException, IOException {
        Connection con = null;
        CallableStatement st = null;
        try {
            System.out.println("=== INICIANDO INSERCIÓN ===");
            System.out.println("Registros a insertar: " + datos.size());
            
            con = OracleDAOFactoryJA.creaConexion();
            
            // Imprimir primer registro para verificar datos
            if (datos.size() > 0) {
                BeanTR_JA_EXHORTOS_DESPACHOS primerBean = datos.get(0);
                System.out.println("Primer registro:");
                System.out.println("  CLAVE_ORGANO: " + primerBean.GetCLAVE_ORGANO());
                System.out.println("  NOMBRE: " + primerBean.GetNOMBRE_ORGANO_JURIS());
                System.out.println("  PERIODO: " + primerBean.GetPERIODO());
            }
            
            STRUCT[] structs = new STRUCT[datos.size()];
            StructDescriptor sd = StructDescriptor.createDescriptor(
                "RAF_2022.OBJ_TR_JA_EXHORTOS_DESPACHOS_GEN", con
            );
            
            for (int i = 0; i < datos.size(); i++) {
                BeanTR_JA_EXHORTOS_DESPACHOS bean = datos.get(i);
                Object[] obj = bean.toArray();
                structs[i] = new STRUCT(sd, con, obj);
            }
            
            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
                "RAF_2022.ARR_OBJ_TR_JA_EXHORTOS_DESPACHOS_GEN", con
            );
            ARRAY array_to_pass = new ARRAY(descriptor, con, structs);
            
            st = con.prepareCall("{? = call RAF_2022.PKG_INTEGRADOR_JA.TR_JA_EXHORTOS_DESPACHOS_GEN(?)}");
            st.registerOutParameter(1, java.sql.Types.INTEGER);
            st.setArray(2, array_to_pass);
            st.execute();
            
            int resultado = st.getInt(1);
            System.out.println("✓ Función retornó: " + resultado);
            System.out.println("✓ " + datos.size() + " registros procesados");
            System.out.println("=== INSERCIÓN COMPLETADA ===");
            
        } catch (SQLException e) {
            System.err.println("Error en sendToOracle: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            if (st != null) st.close();
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}