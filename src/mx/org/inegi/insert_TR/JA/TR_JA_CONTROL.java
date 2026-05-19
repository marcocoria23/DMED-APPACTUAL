/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TR.JA;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import mx.org.inegi.bean.JA_TR.BeanTR_JA_CONTROL;
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
import static Pantallas_JA.IntegraJA_TR.RutaAr;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class TR_JA_CONTROL {
    public static int CFilas2 = 0;
    public void TR_JA_CONTROL() throws Exception {
        Connection con = null;
        int CFilas = 0;
        //String NuevaRuta = directorio  + "INTEGRA_TR.xlsx";
        System.out.println("==============================");
        System.out.println("Leyendo CONTROL: " + RutaAr);
        System.out.println("==============================");
        ArrayList<BeanTR_JA_CONTROL> ad = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(RutaAr);
             Workbook workbook = new XSSFWorkbook(fis)) {
            con = OracleDAOFactoryJA.creaConexion();      
            Sheet sheet = workbook.getSheet("Control");
            if (sheet == null) {
                JOptionPane.showMessageDialog(null, "No existe la hoja CONTROL");
                return;
            }

            boolean datosEncontrados = false;
            
            for (Row row : sheet) {
                Cell nombreCell = row.getCell(1);
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
                
                BeanTR_JA_CONTROL c = new BeanTR_JA_CONTROL();
                c.SetNOMBRE_ORGANO_JURIS( formatter.formatCellValue(row.getCell(1)));
                System.out.println( c.GetNOMBRE_ORGANO_JURIS() );
                c.SetCLAVE_ORGANO( formatter.formatCellValue(row.getCell(2)));
                c.SetDISTRITO( formatter.formatCellValue(row.getCell(3)));
                c.SetSEDE( formatter.formatCellValue(row.getCell(4)));
                c.SetCLAVE_AGEE(    formatter.formatCellValue(row.getCell(5)));   
                c.SetENTIDAD_FEDERATIVA( formatter.formatCellValue(row.getCell(6)));  
                c.SetCLAVE_AGEM(formatter.formatCellValue(row.getCell(7)));   
                c.SetMUNICIPIO_NOMBRE( formatter.formatCellValue(row.getCell(8)));  
                c.SetPERIODO( formatter.formatCellValue(row.getCell(9)));
                c.SetTOTAL_ASUNTOS_INGRES( formatter.formatCellValue(row.getCell(10)));
                c.SetEXPEDIENTES_RECIBIDOS( formatter.formatCellValue(row.getCell(11)));
                c.SetDEMANDAS_INGRESADAS( formatter.formatCellValue(row.getCell(12)));
                c.SetTOTAL_ASUNTOS_TRAMITE( formatter.formatCellValue(row.getCell(13)));
                c.SetTOTAL_RESOLUCIONES( formatter.formatCellValue(row.getCell(14)));
                ad.add(c);
                CFilas++;
            }
 if (!ad.isEmpty()) {
            sendToOracle(ad, con);
        }

    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error leyendo archivo Excel:\n" + e.getMessage());
    } finally {
        // CERRAR CONEXIÓN
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

private void sendToOracle(ArrayList<BeanTR_JA_CONTROL> datos, Connection con) throws SQLException {
    CallableStatement st = null;
    try {
        System.out.println("=== INICIANDO INSERCIÓN DE CONTROL===");
        System.out.println("Registros a insertar: " + datos.size());
        
        STRUCT[] structs = new STRUCT[datos.size()];
        
        StructDescriptor sd = StructDescriptor.createDescriptor( "RAF_2022.OBJ_TR_JA_CONTROL_GEN", con );
        
        // Imprimir primer registro para verificar datos
        if (datos.size() > 0) {
            BeanTR_JA_CONTROL primerBean = datos.get(0);
            System.out.println("Primer registro:");
            System.out.println("  CLAVE_ORGANO: " + primerBean.GetCLAVE_ORGANO());
            System.out.println("  NOMBRE: " + primerBean.GetNOMBRE_ORGANO_JURIS());
            System.out.println("  PERIODO: " + primerBean.GetPERIODO());
        }
        
        for (int i = 0; i < datos.size(); i++) {
            BeanTR_JA_CONTROL bean = datos.get(i);
            Object[] obj = bean.toArray();
            structs[i] = new STRUCT(sd, con, obj);
        }
        
        ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
            "RAF_2022.ARR_OBJ_TR_JA_CONTROL_GEN", con
        );
        ARRAY array_to_pass = new ARRAY(descriptor, con, structs);
        
        st = con.prepareCall("{? = call RAF_2022.PKG_INTEGRADOR_JA.TR_JA_CONTROL_GEN(?)}");
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
