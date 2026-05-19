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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.JA_TR.BeanTR_JA_INGRESOS;
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
import java.sql.SQLException;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class TR_JA_INGRESOS {

    public static int CFilas2 = 0;

    public void TR_JA_INGRESOS() throws Exception {

    Connection con = null;
    int CFilas = 0;

    System.out.println("==============================");
    System.out.println("Leyendo INGRESOS : " + RutaAr);
    System.out.println("==============================");

    ArrayList<BeanTR_JA_INGRESOS> ad = new ArrayList<>();
    DataFormatter formatter = new DataFormatter();

    try (FileInputStream fis = new FileInputStream(RutaAr);
         Workbook workbook = new XSSFWorkbook(fis)) {

        con = OracleDAOFactoryJA.creaConexion();

        Sheet sheet = workbook.getSheet("Ingresos");

        if (sheet == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "No existe la hoja INGRESOS");
            return;
        }

        boolean datosEncontrados = false;

        for (Row row : sheet) {

            Cell nombreCell = row.getCell(0);

            if (nombreCell == null) {
                continue;
            }

            String nombreOrgano =
                    formatter.formatCellValue(nombreCell).trim();

            // Empezar cuando encuentre "TRIBUNAL"
            if (!datosEncontrados &&
                nombreOrgano.toUpperCase().startsWith("TRIBUNAL")) {

                datosEncontrados = true;

                System.out.println(
                        "Datos encontrados. Iniciando lectura desde fila: "
                        + row.getRowNum());
            }

            // Si aún no encuentra TRIBUNAL
            if (!datosEncontrados) {
                continue;
            }

            // Saltar filas inválidas
            if (nombreOrgano.isEmpty() ||
                !nombreOrgano.toUpperCase().startsWith("TRIBUNAL")) {

                continue;
            }

            BeanTR_JA_INGRESOS c = new BeanTR_JA_INGRESOS();

            c.SetNOMBRE_ORGANO_JURIS(formatter.formatCellValue(row.getCell(0)));
            c.SetCLAVE_ORGANO(formatter.formatCellValue(row.getCell(1)));
            c.SetPERIODO(formatter.formatCellValue(row.getCell(2)));
            c.SetTOTAL_INGRESOS(formatter.formatCellValue(row.getCell(3)));
            c.SetSUBTOTAL_EXPED_RECIBIDOS(formatter.formatCellValue(row.getCell(4)));
            c.SetEXPED_COMISION_MIXTA(formatter.formatCellValue(row.getCell(5)));
            c.SetEXPED_TRIBUNAL_SUPERIOR_AG(formatter.formatCellValue(row.getCell(6)));
            c.SetEXPED_OTRAS(formatter.formatCellValue(row.getCell(7)));
            c.SetSUBTOTAL_DEMANDAS(formatter.formatCellValue(row.getCell(8)));
            c.SetDEMANDAS_ESCRITO(formatter.formatCellValue(row.getCell(9)));
            c.SetDEMANDAS_COMPARECENCIA(formatter.formatCellValue(row.getCell(10)));
            c.SetTOTAL_ASUNTOS_ADMIT_MAT(formatter.formatCellValue(row.getCell(11)));
            c.SetSUBTOTAL_ASUNTOS_TERRENOS(formatter.formatCellValue(row.getCell(12)));
            c.SetCONTROVER_TERR_NUCLEOS(formatter.formatCellValue(row.getCell(13)));
            c.SetCONTROVER_TERR_PROPIETARIOS(formatter.formatCellValue(row.getCell(14)));
            c.SetCONTROVER_TERR_SOCIEDAD(formatter.formatCellValue(row.getCell(15)));
            c.SetCONTROVER_TERR_POB_EJIDAL(formatter.formatCellValue(row.getCell(16)));
            c.SetSUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(17)));
            c.SetRESTIT_ACTOS_AUTORIDAD(formatter.formatCellValue(row.getCell(18)));
            c.SetRESTIT_ACTOS_PARTICULAR(formatter.formatCellValue(row.getCell(19)));
            c.SetRECON_REG_COMUNAL(formatter.formatCellValue(row.getCell(20)));
            c.SetNULIDADES_CONTRA_RESOL(formatter.formatCellValue(row.getCell(21)));
            c.SetCONFLICTOS_TENENCIA(formatter.formatCellValue(row.getCell(22)));
            c.SetSUBTOTAL_ASUNTOS_MA(formatter.formatCellValue(row.getCell(23)));
            c.SetCONTROVER_MA_ENTRE_SI(formatter.formatCellValue(row.getCell(24)));
            c.SetCONTROVER_MA_ORGANOS(formatter.formatCellValue(row.getCell(25)));
            c.SetSUCESION_DERECHOS(formatter.formatCellValue(row.getCell(26)));
            c.SetSUBTOTAL_ASUNTOS_JN(formatter.formatCellValue(row.getCell(27)));
            c.SetJN_PROMOVIDOS(formatter.formatCellValue(row.getCell(28)));
            c.SetJN_CONTRAVIE(formatter.formatCellValue(row.getCell(29)));
            c.SetOMISIONES_PROCUR_PERJUICIO(formatter.formatCellValue(row.getCell(30)));
            c.SetASUNTOS_JV(formatter.formatCellValue(row.getCell(31)));
            c.SetCONTROVERSIAS_APROVECHA(formatter.formatCellValue(row.getCell(32)));
            c.SetREVERSION(formatter.formatCellValue(row.getCell(33)));
            c.SetSUBTOTAL_ASUNTOS_EJECUCION(formatter.formatCellValue(row.getCell(34)));
            c.SetEJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(35)));
            c.SetEJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(36)));
            c.SetRRT_INGRE(formatter.formatCellValue(row.getCell(37)));
            c.SetPRIVACION(formatter.formatCellValue(row.getCell(38)));
            c.SetINCONFORM(formatter.formatCellValue(row.getCell(39)));
            c.SetASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(40)));
            c.SetOTROS_ASUNTOS(formatter.formatCellValue(row.getCell(41)));
            c.SetTOTAL_DEMANDAS_NO_INTER(formatter.formatCellValue(row.getCell(42)));
            c.SetCOMENTARIOS(formatter.formatCellValue(row.getCell(43)));

            ad.add(c);
            CFilas++;
        }

        System.out.println(
                "========Total de filas leídas: "
                + CFilas + "========");

        CFilas2 = CFilas;

        if (!ad.isEmpty()) {
            sendToOracle(ad);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Pestaña Ingresos sin registros");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private void sendToOracle(ArrayList<BeanTR_JA_INGRESOS> datos) throws SQLException, IOException {
        Connection con = null;
        CallableStatement st = null;
        try {
            System.out.println("=== INICIANDO INSERCIÓN ===");
            System.out.println("Registros a insertar: " + datos.size());
            
            con = OracleDAOFactoryJA.creaConexion();
            
            // Imprimir primer registro para verificar datos
            if (datos.size() > 0) {
                BeanTR_JA_INGRESOS primerBean = datos.get(0);
                System.out.println("Primer registro:");
                System.out.println("  CLAVE_ORGANO: " + primerBean.GetCLAVE_ORGANO());
                System.out.println("  NOMBRE: " + primerBean.GetNOMBRE_ORGANO_JURIS());
                System.out.println("  PERIODO: " + primerBean.GetPERIODO());
            }
            
            STRUCT[] structs = new STRUCT[datos.size()];
            StructDescriptor sd = StructDescriptor.createDescriptor(
                "RAF_2022.OBJ_TR_JA_INGRESOS_GEN", con
            );
            
            for (int i = 0; i < datos.size(); i++) {
                BeanTR_JA_INGRESOS bean = datos.get(i);
                Object[] obj = bean.toArray();
                structs[i] = new STRUCT(sd, con, obj);
            }
            
            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
                "RAF_2022.ARR_OBJ_TR_JA_INGRESOS_GEN", con
            );
            ARRAY array_to_pass = new ARRAY(descriptor, con, structs);
            
            st = con.prepareCall("{? = call RAF_2022.PKG_INTEGRADOR_JA.TR_JA_INGRESOS_GEN(?)}");
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