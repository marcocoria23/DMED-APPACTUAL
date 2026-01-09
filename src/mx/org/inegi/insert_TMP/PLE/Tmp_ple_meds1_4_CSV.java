/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TMP.PLE;

import Convertir_UTF8.Conver_Utf8;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_4;
import mx.org.inegi.conexion.PLE.DaoConexion;
import mx.org.inegi.conexion.PLE.OracleDAOFactory;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class Tmp_ple_meds1_4_CSV {

    public static String impErro = "", RutaT = "", NuevaRuta = "";
    public static int TotalRegistros = 0;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    DaoConexion conexion = new DaoConexion();
    Conver_Utf8 conUTF8 = new Conver_Utf8();

    public void Meds1_4_CSV(String Ruta, String Entidad, String Envio, String Legislatura, String Estatus) throws Exception {
        ArrayList<String[]> Array;
        Array = new ArrayList();
        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        String Entid = "";
        int numero = Integer.parseInt(Entidad);
        if (numero >= 1 && numero <= 9) {
            Entid = "0" + Entidad;
        } else {
            Entid = Entidad;
        }
        TotalRegistros = 0;
        conUTF8.Convertir_utf8_EBaseDatos(Ruta);
        NuevaRuta = Ruta.replace(".csv", "UTF8.csv");
        try ( BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);
            if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
                System.out.println("El archivo parece estar en UTF-8.");
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                    int numeroColumnas = 0;
                    int fila = 0;
                    int periodos = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("numcol " + numeroColumnas);
                    if (numeroColumnas == 44) {
                        System.out.println("+hellooou+" + numeroColumnas);
                        ArrayList<BeanTMP_PLE_MEDS1_4> ad = new ArrayList<>();

                        for (CSVRecord record : csvParser) {
                            fila++;
                            if (fila > 7) {
                                System.out.println("llenado de csv");
                                TotalRegistros++;

                                BeanTMP_PLE_MEDS1_4 a = new BeanTMP_PLE_MEDS1_4();
                               
                                a.SetID_ENTIDAD_TMP(Entidad);
                                a.SetENTIDAD(Entid);

                                a.SetP1_4_1_TMP(record.get(1));
                                a.SetP1_4_2(record.get(2));
                                a.SetP1_4_3(record.get(3));
                                a.SetP1_4_4(record.get(4));
                                a.SetP1_4_5(record.get(5));
                                a.SetP1_4_6(record.get(6));
                                a.SetP1_4_7(record.get(7));
                                a.SetP1_4_8(record.get(8));
                                a.SetP1_4_9(record.get(9));
                                a.SetP1_4_10(record.get(10));
                                a.SetP1_4_11(record.get(11));
                                a.SetP1_4_12(record.get(12));
                                a.SetP1_4_13(record.get(13));
                                a.SetP1_4_14(record.get(14));
                                a.SetP1_4_15(record.get(15));
                                a.SetP1_4_16(record.get(16));
                                a.SetP1_4_17(record.get(17));
                                a.SetP1_4_18(record.get(18));
                                a.SetP1_4_19(record.get(19));
                                a.SetP1_4_20(record.get(20));
                                a.SetP1_4_21(record.get(21));
                                a.SetP1_4_22(record.get(22));
                                a.SetP1_4_23(record.get(23));
                                a.SetP1_4_24(record.get(24));
                                a.SetP1_4_25(record.get(25));
                                a.SetP1_4_26(record.get(26));
                                a.SetP1_4_27(record.get(27));
                                a.SetP1_4_28(record.get(28));
                                a.SetP1_4_29(record.get(29));
                                a.SetP1_4_30(record.get(30));
                                a.SetP1_4_31(record.get(31));
                                a.SetP1_4_32(record.get(32));
                                a.SetP1_4_33(record.get(33));
                                a.SetP1_4_34(record.get(34));
                                a.SetP1_4_35(record.get(35));
                                a.SetP1_4_36(record.get(36));

                                a.SetLEGISLATURA_TMP(Legislatura);
                                a.SetC1_4_ID_TMP(Envio);

                                ad.add(a);
                            }
                        }

                        System.out.println("===== CONTENIDO ad (BeanTMP_PLE_MEDS1_4) =====");
                        System.out.println("Total en ad: " + ad.size());

                        for (int i = 0; i < ad.size(); i++) {
                            BeanTMP_PLE_MEDS1_4 x = ad.get(i);

                            System.out.println("[" + i + "] "
                                    + "ENTIDAD=" + x.GetID_ENTIDAD_TMP()
                                    + ", P1_4_1=" + x.GetP1_4_1_TMP()
                                    + ", P1_4_2=" + x.GetP1_4_2()
                                    + ", P1_4_3=" + x.GetP1_4_3()
                                    + ", P1_4_4=" + x.GetP1_4_4()
                                    + ", P1_4_5=" + x.GetP1_4_5()
                                    + ", P1_4_6=" + x.GetP1_4_6()
                                    + ", P1_4_7=" + x.GetP1_4_7()
                                    + ", P1_4_8=" + x.GetP1_4_8()
                                    + ", P1_4_9=" + x.GetP1_4_9()
                                    + ", P1_4_10=" + x.GetP1_4_10()
                                    + ", P1_4_11=" + x.GetP1_4_11()
                                    + ", P1_4_12=" + x.GetP1_4_12()
                                    + ", P1_4_13=" + x.GetP1_4_13()
                                    + ", P1_4_14=" + x.GetP1_4_14()
                                    + ", P1_4_15=" + x.GetP1_4_15()
                                    + ", P1_4_16=" + x.GetP1_4_16()
                                    + ", P1_4_17=" + x.GetP1_4_17()
                                    + ", P1_4_18=" + x.GetP1_4_18()
                                    + ", P1_4_19=" + x.GetP1_4_19()
                                    + ", P1_4_20=" + x.GetP1_4_20()
                                    + ", P1_4_21=" + x.GetP1_4_21()
                                    + ", P1_4_22=" + x.GetP1_4_22()
                                    + ", P1_4_23=" + x.GetP1_4_23()
                                    + ", P1_4_24=" + x.GetP1_4_24()
                                    + ", P1_4_25=" + x.GetP1_4_25()
                                    + ", P1_4_26=" + x.GetP1_4_26()
                                    + ", P1_4_27=" + x.GetP1_4_27()
                                    + ", P1_4_28=" + x.GetP1_4_28()
                                    + ", P1_4_29=" + x.GetP1_4_29()
                                    + ", P1_4_30=" + x.GetP1_4_30()
                                    + ", P1_4_31=" + x.GetP1_4_31()
                                    + ", P1_4_32=" + x.GetP1_4_32()
                                    + ", P1_4_33=" + x.GetP1_4_33()
                                    + ", P1_4_34=" + x.GetP1_4_34()
                                    + ", P1_4_35=" + x.GetP1_4_35()
                                    + ", P1_4_36=" + x.GetP1_4_36()
                            );
                        }

                        System.out.println("entro 1");
                        if (TotalRegistros > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_4", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_4", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_4(?))}");
                            System.out.println("entro 6");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            System.out.println("entro 7");
                            st.setArray(2, array_to_pass);
                            System.out.println("entro 8");
                            st.execute();
                            System.out.println("entro 9");
                            // JOptionPane.showMessageDialog(null, "Registros insertados TEMP_TR_TEPJF_ACTORES"
                            //       + " Favor de revisar ventana -*Errores de insert*- Total registros en .CSV:" + TotalRegistros);

                        } else {
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros en “Personal de apoyo”");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El total de numero de columnas en el archivo “Personal de apoyo”.CSV no coincide con la bd Oracle");
                    }
                } catch (IOException e) {
                    System.out.println("++" + e);
                } finally {
                    try {
                        array_to_pass = null;
                        structs = null;
                        descriptor = null;
                        if (con != null) {
                            System.out.println("cierraaa");
                            // JOptionPane.showMessageDialog(null, "CONEXION CERRADA!!-ACTORES");
                            con.close();
                            con = null;
                        }
                    } catch (SQLException ex) {
                        throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo de la pestaña “Personal de apoyo” no está en formato UTF-8." + Ruta);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al leer el archivo “Personal de apoyo”" + e);
            e.printStackTrace();
        }
    }
}
