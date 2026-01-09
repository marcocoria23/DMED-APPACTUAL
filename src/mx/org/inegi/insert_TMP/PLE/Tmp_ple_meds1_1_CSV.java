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
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_1;
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_1A;
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_1B;
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_1C;
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_1D;
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
 * @author ANA.MENDEZ
 */
public class Tmp_ple_meds1_1_CSV {

    public static String impErro = "", RutaT = "", NuevaRuta = "";
    public static int TotalRegistros1 = 0,TotalRegistros1A = 0,TotalRegistros1B = 0,TotalRegistros1C = 0,TotalRegistros1D = 0;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    DaoConexion conexion = new DaoConexion();
    Conver_Utf8 conUTF8 = new Conver_Utf8();

    public void Meds1_1_CSV(String Ruta, String Entidad, String Envio, String Legislatura, String Estatus) throws Exception {
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
        TotalRegistros1 = 0;
        TotalRegistros1A = 0;
        TotalRegistros1B = 0;
        TotalRegistros1C = 0;
        TotalRegistros1D = 0;
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
                    System.out.println("núm de columnas esperado: 90, número de columnas real:" + numeroColumnas);
                    if (numeroColumnas == 90) {
                        ArrayList<BeanTMP_PLE_MEDS1_1> ad = new ArrayList<>();
                        ArrayList<BeanTMP_PLE_MEDS1_1A> ad1 = new ArrayList<>();
                        ArrayList<BeanTMP_PLE_MEDS1_1B> ad2 = new ArrayList<>();
                        ArrayList<BeanTMP_PLE_MEDS1_1C> ad3 = new ArrayList<>();
                        ArrayList<BeanTMP_PLE_MEDS1_1D> ad4 = new ArrayList<>();
                        for (CSVRecord record : csvParser) {
                            fila++;
                            if (fila == 8) {
                                System.out.println("TR_PLE_MEDS1_1");
                                TotalRegistros1++;
                                BeanTMP_PLE_MEDS1_1 a = new BeanTMP_PLE_MEDS1_1();
                                a.SetID_ENTIDAD_TMP(Entidad);
                                a.SetENTIDAD_TMP(Entid);
                                a.SetP1_1_1(record.get(3));
                                a.SetP1_1_2(record.get(4));
                                a.SetP1_1_3(record.get(5));
                                a.SetP1_1_4(record.get(6));
                                a.SetP1_1_5(record.get(7));
                                a.SetP1_1_6(record.get(8));
                                a.SetP1_1_7(record.get(9));
                                a.SetP1_1_8(record.get(10));
                                a.SetP1_1_9(record.get(11));
                                a.SetLEGISLATURA_TMP(Legislatura);
                                a.SetC1_1_ID_TMP(Envio);
                                a.SetESTATUS(Estatus);
                                ad.add(a);
                                System.out.println("TR_PLE_MEDS1_1A");
                                int varx = 13;
                                int n = 14;
                                for (int i = 0; i < 6; i++) {
                                    if (record.get(varx).equalsIgnoreCase("X")) {
                                        BeanTMP_PLE_MEDS1_1A b = new BeanTMP_PLE_MEDS1_1A();
                                        TotalRegistros1A++;
                                        b.SetID_ENTIDAD_TMP(Entidad);
                                        b.SetENTIDAD(Entid);
                                        b.SetC1_1A(String.valueOf(periodos + 1));
                                        b.SetP1_1A_1(("1"));
                                        b.SetP1_1A_2(record.get(n));
                                        b.SetP1_1A_3(record.get(n + 1));
                                        b.SetP1_1A_4(record.get(n + 2));
                                        b.SetLEGISLATURA_TMP(Legislatura);
                                        b.SetC1_1A_ID_TMP(Envio);
                                        // n = n + 4;
                                        ad1.add(b);
                                    }
                                    varx = varx + 5;
                                    n = n + 5;
                                    periodos = periodos + 1;
                                }
                                System.out.println("TR_PLE_MEDS1_1B");
                                BeanTMP_PLE_MEDS1_1B c = new BeanTMP_PLE_MEDS1_1B();
                                TotalRegistros1B++;
                                c.SetID_ENTIDAD_TMP(Entidad);
                                c.SetENTIDAD(Entid);
                                c.SetP1_1B_1(record.get(42));
                                c.SetP1_1B_2(record.get(43));
                                c.SetLEGISLATURA_TMP(Legislatura);
                                c.SetC1_IB_TMP(Envio);
                                ad2.add(c);
                                
                                System.out.println("TR_PLE_MEDS1_1C");
                                int n1 = 44;
                                int n2 = 1;
                                if (record.get(42).equalsIgnoreCase("Sí")) {
                                    int pext = Integer.parseInt(record.get(43));
                                    for (int i = 1; i <= pext; i++) {
                                        BeanTMP_PLE_MEDS1_1C d = new BeanTMP_PLE_MEDS1_1C();
                                        TotalRegistros1C++;
                                        d.SetID_ENTIDAD_TMP(Entidad);
                                        d.SetENTIDAD(Entid);
                                        d.SetC1_1C(String.valueOf(n2));
                                        d.SetP1_1C_1(record.get(n1 + 1));
                                        d.SetP1_1C_2(record.get(n1 + 2));
                                        d.SetP1_1C_3(record.get(n1 + 3));
                                        d.SetLEGISLATURA_TMP(Legislatura);
                                        d.SetC1_1C_ID_TMP(Envio);
                                        ad3.add(d);
                                        n2++;
                                        n1 = n1 + 4;
                                    }
                                }

                                System.out.println("TR_PLE_MEDS1_1D");
                                int loc = 84;
                                for (int i = 1; i < 6; i++) {
                                    BeanTMP_PLE_MEDS1_1D e = new BeanTMP_PLE_MEDS1_1D();
                                    TotalRegistros1D++;
                                    e.SetID_ENTIDAD_TMP(Entidad);
                                    e.SetENTIDAD(Entid);
                                    e.SetC1_1D(String.valueOf(i));
                                    e.SetP1_1D_1(record.get(loc));
                                    e.SetLEGISLATURA_TMP(Legislatura);
                                    e.SetC1_1D_ID_TMP(Envio);

                                    loc = loc + 1;
                                    ad4.add(e);
                                }

                            }
                        }

                       ////////Imprime resultado//////////
                        System.out.println("===== CONTENIDO ad (BeanTMP_PLE_MEDS1_1) =====");
                        System.out.println("Total en ad: " + ad.size());

                        for (int i = 0; i < ad.size(); i++) {
                            BeanTMP_PLE_MEDS1_1 x = ad.get(i);

                            System.out.println("[" + i + "] "
                                    + "ENTIDAD=" + x.GetENTIDAD_TMP()
                                    + ", P1_1_1=" + x.GetP1_1_1()
                                    + ", P1_1_2=" + x.GetP1_1_2()
                                    + ", P1_1_3=" + x.GetP1_1_3()
                                    + ", P1_1_4=" + x.GetP1_1_4()
                                    + ", P1_1_5=" + x.GetP1_1_5()
                                    + ", P1_1_6=" + x.GetP1_1_6()
                                    + ", P1_1_7=" + x.GetP1_1_7()
                                    + ", P1_1_8=" + x.GetP1_1_8()
                                    + ", P1_1_9=" + x.GetP1_1_9()
                                    + ", ESTATUS=" + x.GetESTATUS()
                            );
                        }

                        System.out.println("===== CONTENIDO ad1 (BeanTMP_PLE_MEDS1_1A) =====");
                        System.out.println("Total en ad1: " + ad1.size());

                        for (int i = 0; i < ad1.size(); i++) {
                            BeanTMP_PLE_MEDS1_1A x = ad1.get(i);

                            System.out.println("[" + i + "] "
                                    + "ENTIDAD=" + x.GetENTIDAD()
                                    + ", C1_1A=" + x.GetC1_1A()
                                    + ", P1_1A_1=" + x.GetP1_1A_1()
                                    + ", P1_1A_2=" + x.GetP1_1A_2()
                                    + ", P1_1A_3=" + x.GetP1_1A_3()
                                    + ", P1_1A_4=" + x.GetP1_1A_4()
                            );
                        }
                        System.out.println("===== CONTENIDO ad2 (BeanTMP_PLE_MEDS1_1B) =====");
                        System.out.println("Total en ad2: " + ad2.size());

                        for (int i = 0; i < ad2.size(); i++) {
                            BeanTMP_PLE_MEDS1_1B x = ad2.get(i);

                            System.out.println("[" + i + "] "
                                    + "ID_ENTIDAD_TMP=" + x.GetENTIDAD()
                                    + ", ENTIDAD=" + x.GetENTIDAD()
                                    + ", P1_1B_1=" + x.GetP1_1B_1()
                                    + ", P1_1B_2=" + x.GetP1_1B_2()
                                    + ", LEGISLATURA_TMP=" + x.GetLEGISLATURA_TMP()
                                    + ", C1_IB_TMP=" + x.GetC1_1B_ID_TMP()
                            );
                        }

                        System.out.println("===== CONTENIDO ad3 (BeanTMP_PLE_MEDS1_1C) =====");
                        System.out.println("Total en ad3: " + ad3.size());

                        for (int i = 0; i < ad3.size(); i++) {
                            BeanTMP_PLE_MEDS1_1C x = ad3.get(i);

                            System.out.println("[" + i + "] "
                                    + "ID_ENTIDAD_TMP=" + x.GetENTIDAD()
                                    + ", ENTIDAD=" + x.GetENTIDAD()
                                    + ", C1_1C=" + x.GetC1_1C()
                                    + ", P1_1C_1=" + x.GetP1_1C_1()
                                    + ", P1_1C_2=" + x.GetP1_1C_2()
                                    + ", P1_1C_3=" + x.GetP1_1C_3()
                                    + ", LEGISLATURA_TMP=" + x.GetLEGISLATURA_TMP()
                                    + ", C1_IB_TMP=" + x.GetC1_1C_ID_TMP()
                            );
                        }

                        System.out.println("===== CONTENIDO ad4 (BeanTMP_PLE_MEDS1_1D) =====");
                        System.out.println("Total en ad4: " + ad4.size());

                        for (int i = 0; i < ad4.size(); i++) {
                            BeanTMP_PLE_MEDS1_1D x = ad4.get(i);

                            System.out.println("[" + i + "] "
                                    + "ID_ENTIDAD_TMP=" + x.GetENTIDAD()
                                    + ", ENTIDAD=" + x.GetENTIDAD()
                                    + ", C1_1D=" + x.GetC1_1D()
                                    + ", P1_1D_1=" + x.GetP1_1D_1()
                                    + ", LEGISLATURA_TMP=" + x.GetLEGISLATURA_TMP()
                                    + ", C1_1D_ID_TMP=" + x.GetC1_1D_ID_TMP()
                            );
                        }


                        if (TotalRegistros1 > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_1", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());
                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_1", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_1(?))}");
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
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros-TMP_PLE_MEDS1_1");
                        }
                        
                         if (TotalRegistros1A > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_1A", con);
                            structs = new STRUCT[ad1.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad1.size());
                            for (int i = 0; i < ad1.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad1.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_1A", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_1A(?))}");
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
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros--TMP_PLE_MEDS1_1A");
                        }
                        
                         if (TotalRegistros1B > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_1B", con);
                            structs = new STRUCT[ad2.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad2.size());
                            for (int i = 0; i < ad2.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad2.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_1B", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_1B(?))}");
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
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros--TMP_PLE_MEDS1_1B");
                        }
                         
                         
                         if (TotalRegistros1C > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_1C", con);
                            structs = new STRUCT[ad3.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad3.size());
                            for (int i = 0; i < ad3.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad3.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_1C", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_1C(?))}");
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
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros--TMP_PLE_MEDS1_1C");
                        }
                         if (TotalRegistros1D > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_1D", con);
                            structs = new STRUCT[ad4.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad4.size());
                            for (int i = 0; i < ad4.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad4.get(i).toArray());
                            }
                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_1D", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_1D(?))}");
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
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros--TMP_PLE_MEDS1_1D");
                        }
                         
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "El total de número de columnas en el archivo “Datos generales”.CSV no coincide con la bd Oracle");
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
                JOptionPane.showMessageDialog(null, "El archivo de la pestaña “Datos generales” no está en formato UTF-8." + Ruta);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al leer el archivo “Datos generales”" + e);
            e.printStackTrace();
        }
    }
}
 