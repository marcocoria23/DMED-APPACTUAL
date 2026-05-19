/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import mx.org.inegi.bean.JA_TR.BeanTR_JA_TRAMITE;
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
 * @author ANDREA.HERNANDEZL
 */
public class TR_JA_TRAMITE {

    public static int CFilas2 = 0;

    public void TR_JA_TRAMITE() throws Exception {
        Connection con = null;
        int CFilas = 0;
        System.out.println("==============================");
        System.out.println("Leyendo TRAMITE: " + RutaAr);
        System.out.println("==============================");
        ArrayList<BeanTR_JA_TRAMITE> ad = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(RutaAr);
             Workbook workbook = new XSSFWorkbook(fis)) {
            con = OracleDAOFactoryJA.creaConexion();      
            Sheet sheet = workbook.getSheet("Trámite");
            if (sheet == null) {
                JOptionPane.showMessageDialog(null, "No existe la hoja TRAMITE");
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
                

                        BeanTR_JA_TRAMITE c = new BeanTR_JA_TRAMITE();
                        c.SetNOMBRE_ORGANO_JURIS(formatter.formatCellValue(row.getCell(0)));
                        c.SetCLAVE_ORGANO(formatter.formatCellValue(row.getCell(1)));
                        c.SetPERIODO(formatter.formatCellValue(row.getCell(2)));
                        c.SetTOTAL_ASUNTOS_PEND(formatter.formatCellValue(row.getCell(3)));
                        c.SetASUNTOS_PEND_PREV(formatter.formatCellValue(row.getCell(4)));
                        c.SetASUNTOS_PEND_TERM(formatter.formatCellValue(row.getCell(5)));
                        c.SetASUNTOS_PEND_ADMI(formatter.formatCellValue(row.getCell(6)));
                        c.SetTOTAL_ASUNTOS_INSTRUC(formatter.formatCellValue(row.getCell(7)));
                        c.SetASUNTOS_JA(formatter.formatCellValue(row.getCell(8)));
                        c.SetASUNTOS_JV(formatter.formatCellValue(row.getCell(9)));
                        c.SetTOTAL_ASUNTOS_MATERIA(formatter.formatCellValue(row.getCell(10)));
                        c.SetSUBTOTAL_ASUNTOS_CONTROV(formatter.formatCellValue(row.getCell(11)));
                        c.SetCONTROV_NUCLEOS_MENOS20(formatter.formatCellValue(row.getCell(12)));
                        c.SetCONTROV_PROPIE_MENOS20(formatter.formatCellValue(row.getCell(13)));
                        c.SetCONTROV_SOC_MENOS20(formatter.formatCellValue(row.getCell(14)));
                        c.SetCONTROV_AGRICOLA_MENOS20(formatter.formatCellValue(row.getCell(15)));
                        c.SetCONTROV_NUCLEOS_MAS20(formatter.formatCellValue(row.getCell(16)));
                        c.SetCONTROV_PROPIE_MAS20(formatter.formatCellValue(row.getCell(17)));
                        c.SetCONTROV_SOC_MAS20(formatter.formatCellValue(row.getCell(18)));
                        c.SetCONTROV_COL_MAS20(formatter.formatCellValue(row.getCell(19)));
                        c.SetSUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(20)));
                        c.SetRESTIT_AUTORID_MENOS20(formatter.formatCellValue(row.getCell(21)));
                        c.SetRESTIT_PARTIC_MENOS20(formatter.formatCellValue(row.getCell(22)));
                        c.SetRESTIT_AUTORID_MAS20(formatter.formatCellValue(row.getCell(23)));
                        c.SetRESTIT_PARTIC_MAS20(formatter.formatCellValue(row.getCell(24)));
                        c.SetSUBTOTAL_RECON(formatter.formatCellValue(row.getCell(25)));
                        c.SetRECON_MENOS20(formatter.formatCellValue(row.getCell(26)));
                        c.SetRECON_MAS20(formatter.formatCellValue(row.getCell(27)));
                        c.SetSUBTOTAL_NULIDADES(formatter.formatCellValue(row.getCell(28)));
                        c.SetNULIDADES_MENOS20(formatter.formatCellValue(row.getCell(29)));
                        c.SetNULIDADES_MAS20(formatter.formatCellValue(row.getCell(30)));
                        c.SetSUBTOTAL_TENENCIA(formatter.formatCellValue(row.getCell(31)));
                        c.SetTENENCIA_MENOS20(formatter.formatCellValue(row.getCell(32)));
                        c.SetTENENCIA_MAS20(formatter.formatCellValue(row.getCell(33)));
                        c.SetSUBTOTAL_ASUNTOS_CONT_MA(formatter.formatCellValue(row.getCell(34)));
                        c.SetCONTROV_MA_EJID_MENOS20(formatter.formatCellValue(row.getCell(35)));
                        c.SetCONTROV_MA_NUCLEO_MENOS20(formatter.formatCellValue(row.getCell(36)));
                        c.SetCONTROV_MA_EJID_MAS20(formatter.formatCellValue(row.getCell(37)));
                        c.SetCONTROV_MA_NUCLEO_MAS20(formatter.formatCellValue(row.getCell(38)));
                        c.SetSUBTOTAL_ASUNTOS_DERECHOS(formatter.formatCellValue(row.getCell(39)));
                        c.SetDERECHOS_MENOS20(formatter.formatCellValue(row.getCell(40)));
                        c.SetDERECHOS_MAS20(formatter.formatCellValue(row.getCell(41)));
                        c.SetSUBTOTAL_JN(formatter.formatCellValue(row.getCell(42)));
                        c.SetJN_PROMOVIDOS_MENOS20(formatter.formatCellValue(row.getCell(43)));
                        c.SetJN_ACTOS_MENOS20(formatter.formatCellValue(row.getCell(44)));
                        c.SetJN_PROMOVIDOS_MAS20(formatter.formatCellValue(row.getCell(45)));
                        c.SetJN_ACTOS_MAS20(formatter.formatCellValue(row.getCell(46)));
                        c.SetSUBTOTAL_OMISIONES(formatter.formatCellValue(row.getCell(47)));
                        c.SetOMISIONES_MENOS20(formatter.formatCellValue(row.getCell(48)));
                        c.SetOMISIONES_MAS20(formatter.formatCellValue(row.getCell(49)));
                        c.SetSUBTOTAL_ASUNTOS_JV(formatter.formatCellValue(row.getCell(50)));
                        c.SetJV_MENOS20(formatter.formatCellValue(row.getCell(51)));
                        c.SetJV_MAS20(formatter.formatCellValue(row.getCell(52)));
                        c.SetSUBTOTAL_CONTROV_TERR(formatter.formatCellValue(row.getCell(53)));
                        c.SetCONTROV_TERR_MENOS20(formatter.formatCellValue(row.getCell(54)));
                        c.SetCONTROV_TERR_MAS20(formatter.formatCellValue(row.getCell(55)));
                        c.SetSUBTOTAL_REVERSION(formatter.formatCellValue(row.getCell(56)));
                        c.SetREVERSION_MENOS20(formatter.formatCellValue(row.getCell(57)));
                        c.SetREVERSION_MAS20(formatter.formatCellValue(row.getCell(58)));
                        c.SetSUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(59)));
                        c.SetEJECUCION_CONV_MENOS20(formatter.formatCellValue(row.getCell(60)));
                        c.SetEJECUCION_LAUDOS_MENOS20(formatter.formatCellValue(row.getCell(61)));
                        c.SetEJECUCION_CONVENIOS_MAS20(formatter.formatCellValue(row.getCell(62)));
                        c.SetEJECUCION_LAUDOS_MAS20(formatter.formatCellValue(row.getCell(63)));
                        c.SetSUBTOTAL_ASUNTOS_RRT(formatter.formatCellValue(row.getCell(64)));
                        c.SetRRT_MENOS20(formatter.formatCellValue(row.getCell(65)));
                        c.SetRRT_MAS20(formatter.formatCellValue(row.getCell(66)));
                        c.SetSUBTOTAL_ASUNTOS_DA(formatter.formatCellValue(row.getCell(67)));
                        c.SetDA_MENOS20(formatter.formatCellValue(row.getCell(68)));
                        c.SetDA_MAS20(formatter.formatCellValue(row.getCell(69)));
                        c.SetSUBTOTAL_ASUNTOS_INCONFOR(formatter.formatCellValue(row.getCell(70)));
                        c.SetINCONFOR_MENOS20(formatter.formatCellValue(row.getCell(71)));
                        c.SetINCONFOR_MAS20(formatter.formatCellValue(row.getCell(72)));
                        c.SetSUBTOTAL_ASUNTOS_LA(formatter.formatCellValue(row.getCell(73)));
                        c.SetLA_MENOS20(formatter.formatCellValue(row.getCell(74)));
                        c.SetLA_MAS20(formatter.formatCellValue(row.getCell(75)));
                        c.SetSUBTOTAL_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(76)));
                        c.SetOTROS_ASUNTOS_MENOS20(formatter.formatCellValue(row.getCell(77)));
                        c.SetOTROS_ASUNTOS_MAS20(formatter.formatCellValue(row.getCell(78)));
                        c.SetTOTAL_ASUNTOS_PROYECTO(formatter.formatCellValue(row.getCell(79)));
                        c.SetJUICIO_AGRARIO(formatter.formatCellValue(row.getCell(80)));
                        c.SetJURIS_VOLUNTARIA(formatter.formatCellValue(row.getCell(81)));
                        c.SetTOTAL_ASUNTOS_TRAMITE(formatter.formatCellValue(row.getCell(82)));
                        c.SetCOMENTARIOS(formatter.formatCellValue(row.getCell(83)));
         ad.add(c);
            CFilas++;
        }

        System.out.println(
                "========Total de filas leídas: "
                + CFilas + "========");

        CFilas2 = CFilas;

        if (!ad.isEmpty()) {
            sendToOracle(ad, con);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Pestaña Trámite sin registros");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void sendToOracle(ArrayList<BeanTR_JA_TRAMITE> datos, Connection con) throws SQLException {
        CallableStatement st = null;
        try {
            System.out.println("=== INICIANDO INSERCIÓN ===");
            System.out.println("Registros a insertar: " + datos.size());
            
            STRUCT[] structs = new STRUCT[datos.size()];
            
            StructDescriptor sd = StructDescriptor.createDescriptor(
                "RAF_2022.OBJ_TR_JA_TRAMITE_GEN", con
            );
            
            // Imprimir primer registro para verificar datos
            if (datos.size() > 0) {
                BeanTR_JA_TRAMITE primerBean = datos.get(0);
                System.out.println("Primer registro:");
                System.out.println("  CLAVE_ORGANO: " + primerBean.GetCLAVE_ORGANO());
                System.out.println("  NOMBRE: " + primerBean.GetNOMBRE_ORGANO_JURIS());
                System.out.println("  PERIODO: " + primerBean.GetPERIODO());
            }
            
            for (int i = 0; i < datos.size(); i++) {
                BeanTR_JA_TRAMITE bean = datos.get(i);
                Object[] obj = bean.toArray();
                structs[i] = new STRUCT(sd, con, obj);
            }
            
            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
                "RAF_2022.ARR_OBJ_TR_JA_TRAMITE_GEN", con
            );
            ARRAY array_to_pass = new ARRAY(descriptor, con, structs);
            
            st = con.prepareCall("{? = call RAF_2022.PKG_INTEGRADOR_JA.TR_JA_TRAMITE_GEN(?)}");
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
