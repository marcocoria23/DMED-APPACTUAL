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
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_7;
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
* @author LAURA.MDINAJ
*/
public class Tmp_ple_meds1_7_CSV {
 
    public static String impErro = "", RutaT = "", NuevaRuta = "";
    public static int TotalRegistros = 0;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    DaoConexion conexion = new DaoConexion();
    Conver_Utf8 conUTF8 = new Conver_Utf8();
 
    public void Meds1_7_CSV(String Ruta, String Entidad, String Envio, String Legislatura, String Estatus) throws Exception {
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
                    System.out.println("núm. de columnas: " + numeroColumnas);
                    if (numeroColumnas == 55) {
                        System.out.println("+número de columnas: " + numeroColumnas);
                        ArrayList<BeanTMP_PLE_MEDS1_7> ad = new ArrayList<>();
                        for (CSVRecord record : csvParser) {
                            fila++;
                            if (fila > 7) {
                                System.out.println("llenado de csv");
                                TotalRegistros++;
                                 BeanTMP_PLE_MEDS1_7 a = new BeanTMP_PLE_MEDS1_7();
                                a.SetID_ENTIDAD_TMP(Entidad);
                                a.SetENTIDAD(Entid);                                
                                a.SetP1_7_1(record.get(1)); 
                                a.SetP1_7_2(record.get(2)); 
                                a.SetP1_7_3(record.get(3)); 
                                a.SetP1_7_4(record.get(4)); 
                                a.SetP1_7_5(record.get(5)); 
                                a.SetP1_7_6(record.get(6)); 
                                a.SetP1_7_7(record.get(7)); 
                                a.SetP1_7_8(record.get(8)); 
                                a.SetP1_7_9(record.get(9)); 
                                a.SetP1_7_10(record.get(10)); 
                                a.SetP1_7_11(record.get(11)); 
                                a.SetP1_7_12(record.get(12)); 
                                a.SetP1_7_13(record.get(13)); 
                                a.SetP1_7_14(record.get(14)); 
                                a.SetP1_7_15(record.get(15)); 
                                a.SetP1_7_16(record.get(16)); 
                                a.SetP1_7_17(record.get(17)); 
                                a.SetP1_7_18(record.get(18)); 
                                a.SetP1_7_19(record.get(19)); 
                                a.SetP1_7_20(record.get(20)); 
                                a.SetP1_7_21(record.get(21)); 
                                a.SetP1_7_22(record.get(22)); 
                                a.SetP1_7_23(record.get(23)); 
                                a.SetP1_7_24(record.get(24)); 
                                a.SetP1_7_25(record.get(25)); 
                                a.SetP1_7_26(record.get(26)); 
                                a.SetP1_7_27(record.get(27)); 
                                a.SetP1_7_28(record.get(28)); 
                                a.SetP1_7_29(record.get(29)); 
                                a.SetP1_7_30(record.get(30)); 
                                a.SetP1_7_31(record.get(31)); 
                                a.SetP1_7_32(record.get(32)); 
                                a.SetP1_7_33(record.get(33)); 
                                a.SetP1_7_34(record.get(34)); 
                                a.SetP1_7_35(record.get(35)); 
                                a.SetP1_7_36(record.get(36)); 
                                a.SetP1_7_37(record.get(37)); 
                                a.SetLEGISLATURA_TMP(Legislatura);
                                a.SetC1_7_ID_TMP(Envio);
                                ad.add(a);
                                
                            }
                        }
 
                        System.out.println("===== CONTENIDO ad (BeanTMP_PLE_MEDS1_1) =====");
                        System.out.println("Total en ad: " + ad.size());
 
                        for (int i = 0; i < ad.size(); i++) {
                            BeanTMP_PLE_MEDS1_7 x = ad.get(i);
 
                            System.out.println("[" + i + "] "
                                + "ENTIDAD=" + x.GetID_ENTIDAD_TMP()
                                + ", P1_7_1=" + x.GetP1_7_1()
                                + ", P1_7_2=" + x.GetP1_7_2()
                                + ", P1_7_3=" + x.GetP1_7_3()
                                + ", P1_7_4=" + x.GetP1_7_4()
                                + ", P1_7_5=" + x.GetP1_7_5()
                                + ", P1_7_6=" + x.GetP1_7_6()
                                + ", P1_7_7=" + x.GetP1_7_7()
                                + ", P1_7_8=" + x.GetP1_7_8()
                                + ", P1_7_9=" + x.GetP1_7_9()
                                + ", P1_7_10=" + x.GetP1_7_10()
                                + ", P1_7_11=" + x.GetP1_7_11()
                                + ", P1_7_12=" + x.GetP1_7_12()
                                + ", P1_7_13=" + x.GetP1_7_13()
                                + ", P1_7_14=" + x.GetP1_7_14()
                                + ", P1_7_15=" + x.GetP1_7_15()
                                + ", P1_7_16=" + x.GetP1_7_16()
                                + ", P1_7_17=" + x.GetP1_7_17()
                                + ", P1_7_18=" + x.GetP1_7_18()
                                + ", P1_7_19=" + x.GetP1_7_19()
                                + ", P1_7_20=" + x.GetP1_7_20()
                                + ", P1_7_21=" + x.GetP1_7_21()
                                + ", P1_7_22=" + x.GetP1_7_22()
                                + ", P1_7_23=" + x.GetP1_7_23()
                                + ", P1_7_24=" + x.GetP1_7_24()
                                + ", P1_7_25=" + x.GetP1_7_25()
                                + ", P1_7_26=" + x.GetP1_7_26()
                                + ", P1_7_27=" + x.GetP1_7_27()
                                + ", P1_7_28=" + x.GetP1_7_28()
                                + ", P1_7_29=" + x.GetP1_7_29()
                                + ", P1_7_30=" + x.GetP1_7_30()
                                + ", P1_7_31=" + x.GetP1_7_31()
                                + ", P1_7_32=" + x.GetP1_7_32()
                                + ", P1_7_33=" + x.GetP1_7_33()
                                + ", P1_7_34=" + x.GetP1_7_34()
                                + ", P1_7_35=" + x.GetP1_7_35()
                                + ", P1_7_36=" + x.GetP1_7_36()
                                + ", P1_7_37=" + x.GetP1_7_37()
                            );
                        }
 
                    System.out.println("entro get");
                        if (TotalRegistros > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_7", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("Creo conexión");
                            System.out.println("tamaño " + ad.size());
                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }
                            System.out.println("llenar Structs");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_7", con);
                            System.out.println("crear descriptor");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("Crea array");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_7(?))}");
                            System.out.println("llama BD para integrar información");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            System.out.println("parámetro de salida");
                            st.setArray(2, array_to_pass);
                            System.out.println("asigna un parámetro de entrada");
                            st.execute();
                            System.out.println("ejecutar integración a BD");
                          
                        } else {
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros en Jucios Políticos");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El total de número de columnas en el archivo .CSV no coincide con la bd Oracle");
                    }
                } catch (IOException e) {
                    System.out.println("++" + e);
                } finally {
                    try {
                        array_to_pass = null;
                        structs = null;
                        descriptor = null;
                        if (con != null) {
                            System.out.println("cerrar conexión");
                           // JOptionPane.showMessageDialog(null, "CONEXION CERRADA!!-ACTORES");
                            con.close();
                            con = null;
                        }
                    } catch (SQLException ex) {
                        throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no está en formato UTF-8" + Ruta);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al leer el archivo" + e);
            e.printStackTrace();
        }
    }
}