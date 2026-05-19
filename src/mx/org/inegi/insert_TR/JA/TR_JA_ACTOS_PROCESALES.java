/*
 * Click nbfs://nbhost/SystemFileSchema/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSchema/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TR.JA;

import static Pantallas_JA.IntegraJA_TR.RutaAr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.JA_TR.BeanTR_JA_ACTOS_PROCESALES;
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

/**
 *
 * @author LAURA.MEDINAJ
 */
public class TR_JA_ACTOS_PROCESALES {
    
    public static int CFilas2 = 0;

    public void TR_JA_ACTOS_PROCESALES() throws Exception {
        Connection con = null;
        int CFilas = 0;
        System.out.println("==============================");
        System.out.println("Leyendo ACTOS_PROCESALES: " + RutaAr);
        System.out.println("==============================");
        ArrayList<BeanTR_JA_ACTOS_PROCESALES> ad = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(RutaAr);
             Workbook workbook = new XSSFWorkbook(fis)) {
            con = OracleDAOFactoryJA.creaConexion();      
            Sheet sheet = workbook.getSheet("Actos procesales");
            if (sheet == null) {
                JOptionPane.showMessageDialog(null, "No existe la hoja ACTOS_PROCESALES");
                return;
            }
            
            boolean datosEncontrados = false;           
            for (Row row : sheet) {
                Cell nombreCell = row.getCell(0);
                if (nombreCell == null) continue;
                String nombreOrgano = formatter.formatCellValue(nombreCell).trim();               
                // Empezar cuando encuentre "Tribunal"
                if (!datosEncontrados && nombreOrgano.toUpperCase().startsWith("TRIBUNAL")) {
                    datosEncontrados = true;
                    System.out.println("Datos encontrados. Iniciando lectura desde fila: " + row.getRowNum());
                }               
                // Si no hemos encontrado "Tribunal" aún, saltar
                if (!datosEncontrados) continue;              
                // Si es una fila vacía o no comienza con "Tribunal", saltar
                if (nombreOrgano.isEmpty() || !nombreOrgano.toUpperCase().startsWith("TRIBUNAL")) continue;  
                
                BeanTR_JA_ACTOS_PROCESALES c = new BeanTR_JA_ACTOS_PROCESALES();
                c.SetNOMBRE_ORGANO_JURIS(formatter.formatCellValue(row.getCell(0)));
                c.SetCLAVE_ORGANO(formatter.formatCellValue(row.getCell(1)));
                c.SetPERIODO(formatter.formatCellValue(row.getCell(2)));
                c.SetTOTAL_AUTOS(formatter.formatCellValue(row.getCell(3)));
                c.SetAUTOS_EJECUCION(formatter.formatCellValue(row.getCell(4)));
                c.SetOTROS_AUTOS(formatter.formatCellValue(row.getCell(5)));
                c.SetTOTAL_DP(formatter.formatCellValue(row.getCell(6)));
                c.SetDP_NOTIFICACIONES(formatter.formatCellValue(row.getCell(7)));
                c.SetDP_INSPECCIONES(formatter.formatCellValue(row.getCell(8)));
                c.SetDP_CITACIONES(formatter.formatCellValue(row.getCell(9)));
                c.SetDP_OTRO(formatter.formatCellValue(row.getCell(10)));
                c.SetTOTAL_EMPLAZAMIENTOS(formatter.formatCellValue(row.getCell(11)));
                c.SetTOTAL_AUDIENCIAS(formatter.formatCellValue(row.getCell(12)));
                c.SetAUDIENCIAS_PRESENCIAL(formatter.formatCellValue(row.getCell(13)));
                c.SetAUDIENCIAS_REMOTO(formatter.formatCellValue(row.getCell(14)));
                c.SetTOTAL_RESOLUCIONES(formatter.formatCellValue(row.getCell(15)));
                c.SetCOMENTARIOS(formatter.formatCellValue(row.getCell(16)));
                ad.add(c);
                CFilas++;
            }
            
            System.out.println("========Total de filas leídas: " + CFilas + "========");
            CFilas2 = CFilas;
            
            if (!ad.isEmpty()) {
                sendToOracle(ad, con);
            } else {
                JOptionPane.showMessageDialog(null, "Hoja Actos procesales sin registros");
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error leyendo archivo Excel:\n" + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Fin de la clase");
    }

    private void sendToOracle(ArrayList<BeanTR_JA_ACTOS_PROCESALES> datos, Connection con) throws SQLException {
        CallableStatement st = null;
        try {
            System.out.println("=== INICIANDO INSERCIÓN ===");
            System.out.println("Registros a insertar: " + datos.size());
            
            STRUCT[] structs = new STRUCT[datos.size()];
            
            StructDescriptor sd = StructDescriptor.createDescriptor(
                "RAF_2022.OBJ_TR_JA_ACTOS_PROCESALES_GEN", con
            );
            
            if (!datos.isEmpty()) {
                BeanTR_JA_ACTOS_PROCESALES primerBean = datos.get(0);
                System.out.println("Primer registro:");
                System.out.println("  CLAVE_ORGANO: " + primerBean.GetCLAVE_ORGANO());
                System.out.println("  NOMBRE: " + primerBean.GetNOMBRE_ORGANO_JURIS());
                System.out.println("  PERIODO: " + primerBean.GetPERIODO());
            }
            
            for (int i = 0; i < datos.size(); i++) {
                BeanTR_JA_ACTOS_PROCESALES bean = datos.get(i);
                Object[] obj = bean.toArray();
                structs[i] = new STRUCT(sd, con, obj);
            }
            
            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
                "RAF_2022.ARR_OBJ_TR_JA_ACTOS_PROCESALES_GEN", con
            );
            ARRAY array_to_pass = new ARRAY(descriptor, con, structs);
            
            st = con.prepareCall("{? = call RAF_2022.PKG_INTEGRADOR_JA.TR_JA_ACTOS_PROCESALES_GEN(?)}");
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
        }
    }
}