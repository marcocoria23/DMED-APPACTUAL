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
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_2;
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
public class Tmp_ple_meds1_2_CSV {

    public static String impErro = "", RutaT = "", NuevaRuta = "";
    public static int TotalRegistros = 0;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    DaoConexion conexion = new DaoConexion();
    Conver_Utf8 conUTF8 = new Conver_Utf8();

    public void Meds1_2_CSV(String Ruta, String Entidad, String Envio, String Legislatura, String Estatus) throws Exception {
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
                    System.out.println("numcol" + numeroColumnas);
                    if (numeroColumnas == 26) {
                        System.out.println("+hellooou+" + numeroColumnas);
                        ArrayList<BeanTMP_PLE_MEDS1_2> ad = new ArrayList<>();

                        for (CSVRecord record : csvParser) {
                            fila++;
                            if (fila > 7) {
                                System.out.println("llenado de csv");
                                TotalRegistros++;
                                BeanTMP_PLE_MEDS1_2 a = new BeanTMP_PLE_MEDS1_2();
                                a.SetID_ENTIDAD_TMP(Entidad);
                                a.SetENTIDAD(Entid);  
                                a.SetP1_2_1(record.get(1)); //Columna
                                a.SetP1_2_2(record.get(2));
                                a.SetP1_2_3(record.get(3));
                                a.SetP1_2_4(record.get(4));
                                a.SetP1_2_5(record.get(5));
                                a.SetP1_2_6(record.get(6));
                                a.SetP1_2_7(record.get(7));
                                a.SetP1_2_8(record.get(8));
                                a.SetP1_2_9(record.get(9));
                                a.SetP1_2_10(record.get(10));
                                a.SetP1_2_11(record.get(11));
                                a.SetP1_2_12(record.get(12));
                                a.SetP1_2_13(record.get(13));
                                a.SetP1_2_14(record.get(14));
                                a.SetP1_2_15(record.get(15));
                                a.SetP1_2_16(record.get(16));
                                a.SetP1_2_17(record.get(17));
                                a.SetP1_2_18(record.get(18));
                                a.SetP1_2_19(record.get(19));
                                a.SetLEGISLATURA_TMP(Legislatura);
                                a.SetC1_2_ID_TMP(Envio);

                                ad.add(a);

                            }
                        }

                       System.out.println("===== CONTENIDO ad (BeanTMP_PLE_MEDS1_1) =====");
                        System.out.println("Total en ad: " + ad.size());

                        for (int i = 0; i < ad.size(); i++) {
                            BeanTMP_PLE_MEDS1_2 x = ad.get(i);

                            System.out.println("[" + i + "] "
                                    + "ENTIDAD=" + x.GetID_ENTIDAD_TMP()
                                    + ", P1_2_1=" + x.GetP1_2_1()
                                    + ", P1_2_2=" + x.GetP1_2_2()
                                    + ", P1_2_3=" + x.GetP1_2_3()
                                    + ", P1_2_4=" + x.GetP1_2_4()
                                    + ", P1_2_5=" + x.GetP1_2_5()
                                    + ", P1_2_6=" + x.GetP1_2_6()
                                    + ", P1_2_7=" + x.GetP1_2_7()
                                    + ", P1_2_8=" + x.GetP1_2_8()
                                    + ", P1_2_9=" + x.GetP1_2_9()
                                    + ", P1_2_10=" + x.GetP1_2_10()
                                    + ", P1_2_11=" + x.GetP1_2_11()
                                    + ", P1_2_12=" + x.GetP1_2_12()
                                    + ", P1_2_13=" + x.GetP1_2_13()
                                    + ", P1_2_14=" + x.GetP1_2_14()
                                    + ", P1_2_15=" + x.GetP1_2_15()
                                    + ", P1_2_16=" + x.GetP1_2_16()
                                    + ", P1_2_17=" + x.GetP1_2_17()
                                    + ", P1_2_18=" + x.GetP1_2_18()
                                    + ", P1_2_19=" + x.GetP1_2_19()
                            );
                        }
System.out.println("entro 1");
                        if (TotalRegistros > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_2", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_2", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_2(?))}");
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
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros-Comisiones Legislativas");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El total de número de columnas en el archivo “Comisiones Legislativas”.CSV no coincide con la bd Oracle");
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
                JOptionPane.showMessageDialog(null, "El archivo de la pestaña “Comisiones Legislativas”  no está en formato UTF-8." + Ruta);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al leer el archivo “Comisiones Legislativas” " + e);
            e.printStackTrace();
        }
    }
}
