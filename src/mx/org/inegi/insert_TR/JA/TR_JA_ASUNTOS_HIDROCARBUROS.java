package mx.org.inegi.insert_TR.JA;

import static Pantallas_JA.IntegraJA_TR.RutaAr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.JA_TR.BeanTR_JA_ASUNTOS_HIDROCARBUROS;
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
public class TR_JA_ASUNTOS_HIDROCARBUROS {
    
    public static int CFilas2 = 0;

    public void TR_JA_ASUNTOS_HIDROCARBUROS() throws Exception {
        Connection con = null;
        int CFilas = 0;
        System.out.println("==============================");
        System.out.println("Leyendo ASUNTOS_HIDROCARBUROS: " + RutaAr);
        System.out.println("==============================");
        ArrayList<BeanTR_JA_ASUNTOS_HIDROCARBUROS> ad = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(RutaAr);
             Workbook workbook = new XSSFWorkbook(fis)) {
            con = OracleDAOFactoryJA.creaConexion();      
            Sheet sheet = workbook.getSheet("Asuntos_hidrocarburos");
            if (sheet == null) {
                JOptionPane.showMessageDialog(null, "No existe la hoja ASUNTOS_HIDROCARBUROS");
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
                
                try {
                    BeanTR_JA_ASUNTOS_HIDROCARBUROS c = new BeanTR_JA_ASUNTOS_HIDROCARBUROS();
                    
                    System.out.println("Fila " + row.getRowNum() + ": " + nombreOrgano);
                    
                    c.SetNOMBRE_ORGANO_JURIS(formatter.formatCellValue(row.getCell(0)));
                    c.SetCLAVE_ORGANO(formatter.formatCellValue(row.getCell(1)));
                    c.SetPERIODO(formatter.formatCellValue(row.getCell(2)));
                    c.SetTOTAL_ASUNTOS(formatter.formatCellValue(row.getCell(3)));
                    c.SetVALIDACION_CONTRATOS(formatter.formatCellValue(row.getCell(4)));
                    c.SetSOLICITUD_DECLARACION(formatter.formatCellValue(row.getCell(5)));
                    c.SetNULIDAD_CONTRATOS(formatter.formatCellValue(row.getCell(6)));
                    c.SetOTRAS_CONTROV(formatter.formatCellValue(row.getCell(7)));
                    c.SetTOTAL_ASUNTOS_CONCLUIDOS(formatter.formatCellValue(row.getCell(8)));
                    c.SetRESOLUCION_VALIDA(formatter.formatCellValue(row.getCell(9)));
                    c.SetRESOLUCION_NOVALIDA(formatter.formatCellValue(row.getCell(10)));
                    c.SetACUERDO_CADUCIDAD(formatter.formatCellValue(row.getCell(11)));
                    c.SetOTRA_FORMA_CONCL(formatter.formatCellValue(row.getCell(12)));
                    c.SetCOMENTARIOS(formatter.formatCellValue(row.getCell(13)));
                    
                    ad.add(c);
                    CFilas++;
                    
                } catch (Exception e) {
                    System.err.println("❌ Error fila " + row.getRowNum() + ": " + e.getMessage());
                    e.printStackTrace();
                    continue;
                }
            }
            
            System.out.println("========Total de filas leídas: " + CFilas + "========");
            CFilas2 = CFilas;
            
            if (!ad.isEmpty()) {
                sendToOracle(ad, con);
            } else {
                JOptionPane.showMessageDialog(null, "Pestaña Asuntos_hidrocarburos sin registros");
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

    private void sendToOracle(ArrayList<BeanTR_JA_ASUNTOS_HIDROCARBUROS> datos, Connection con) throws SQLException {
        CallableStatement st = null;
        try {
            System.out.println("=== INICIANDO INSERCIÓN ===");
            System.out.println("Registros a insertar: " + datos.size());
            
            // Imprimir primer registro para verificar datos
            if (datos.size() > 0) {
                BeanTR_JA_ASUNTOS_HIDROCARBUROS primerBean = datos.get(0);
                System.out.println("Primer registro:");
                System.out.println("  CLAVE_ORGANO: " + primerBean.GetCLAVE_ORGANO());
                System.out.println("  NOMBRE: " + primerBean.GetNOMBRE_ORGANO_JURIS());
                System.out.println("  PERIODO: " + primerBean.GetPERIODO());
            }
            
            STRUCT[] structs = new STRUCT[datos.size()];
            StructDescriptor sd = StructDescriptor.createDescriptor(
                "RAF_2022.OBJ_TR_JA_ASUNTOS_HIDROCARBUROS_GEN", con
            );
            
            for (int i = 0; i < datos.size(); i++) {
                BeanTR_JA_ASUNTOS_HIDROCARBUROS bean = datos.get(i);
                Object[] obj = bean.toArray();
                structs[i] = new STRUCT(sd, con, obj);
            }
            
            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
                "RAF_2022.ARR_OBJ_TR_JA_ASUNTOS_HIDROCARBUROS_GEN", con
            );
            ARRAY array_to_pass = new ARRAY(descriptor, con, structs);
            
            st = con.prepareCall("{? = call RAF_2022.PKG_INTEGRADOR_JA.TR_JA_ASUNTOS_HIDROCARBUROS_GEN(?)}");
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