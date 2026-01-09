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
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_6;
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
public class Tmp_ple_meds1_6_CSV {

    public static String impErro = "", RutaT = "", NuevaRuta = "";
    public static int TotalRegistros = 0;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    DaoConexion conexion = new DaoConexion();
    Conver_Utf8 conUTF8 = new Conver_Utf8();

    public void Meds1_6_CSV(String Ruta, String Entidad, String Envio, String Legislatura, String Estatus) throws Exception {
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
                System.out.println("El archivo 1_6 parece estar en UTF-8.");
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                    int numeroColumnas = 0;
                    int fila = 0;
                    int periodos = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("Núm de col esperado: Mayor a 0, número de col real:  " + numeroColumnas);
                    if (numeroColumnas > 0) {
                        ArrayList<BeanTMP_PLE_MEDS1_6 > ad = new ArrayList<>();
                        System.out.println("llenado de csv");
                        for (CSVRecord record : csvParser) {
                            fila++;
                            if (fila > 7) {
                                
                                TotalRegistros++;

                                BeanTMP_PLE_MEDS1_6 a = new BeanTMP_PLE_MEDS1_6();

                                a.SetID_ENTIDAD_TMP(Entidad);
                                a.SetENTIDAD(Entid);

                                a.SetP1_6_1(record.get(1));
                                a.SetP1_6_2(record.get(2));
                                a.SetP1_6_3(record.get(3));
                                a.SetP1_6_4(record.get(4));
                                a.SetP1_6_5(record.get(5));
                                a.SetP1_6_6(record.get(6));
                                a.SetP1_6_7(record.get(7));
                                a.SetP1_6_8(record.get(8));
                                a.SetP1_6_9(record.get(9));
                                a.SetP1_6_10(record.get(10));
                                a.SetP1_6_11(record.get(11));
                                a.SetP1_6_12(record.get(12));
                                a.SetP1_6_13(record.get(13));
                                a.SetP1_6_14(record.get(14));
                                a.SetP1_6_15(record.get(15));
                                a.SetP1_6_16(record.get(16));
                                a.SetP1_6_17(record.get(17));
                                a.SetP1_6_18(record.get(18));
                                a.SetP1_6_19(record.get(19));
                                a.SetP1_6_20(record.get(20));
                                a.SetP1_6_21(record.get(21));
                                a.SetP1_6_22(record.get(22));
                                a.SetP1_6_23(record.get(23));
                                a.SetP1_6_24(record.get(24));
                                a.SetP1_6_25(record.get(25));
                                a.SetP1_6_26(record.get(26));
                                a.SetP1_6_27(record.get(27));
                                a.SetP1_6_28(record.get(28));
                                a.SetP1_6_29(record.get(29));
                                a.SetP1_6_30(record.get(30));
                                a.SetP1_6_31(record.get(31));
                                a.SetP1_6_32(record.get(32));
                                a.SetP1_6_33(record.get(33));
                                a.SetP1_6_34(record.get(34));
                                a.SetP1_6_35(record.get(35));
                                a.SetP1_6_36(record.get(36));
                                a.SetP1_6_37(record.get(37));
                                a.SetP1_6_38(record.get(38));
                                a.SetP1_6_39(record.get(39));
                                a.SetP1_6_40(record.get(40));
                                a.SetP1_6_41(record.get(41));
                                a.SetP1_6_42(record.get(42));
                                a.SetP1_6_43(record.get(43));
                                a.SetP1_6_44(record.get(44));
                                a.SetP1_6_45(record.get(45));
                                a.SetP1_6_46(record.get(46));
                                a.SetP1_6_47(record.get(47));
                                a.SetP1_6_48(record.get(48));
                                a.SetP1_6_49(record.get(49));
                                a.SetP1_6_50(record.get(50));
                                a.SetP1_6_51(record.get(51));
                                a.SetP1_6_52(record.get(52));
                                a.SetP1_6_53(record.get(53));
                                a.SetP1_6_54(record.get(54));
                                a.SetP1_6_55(record.get(55));
                                a.SetP1_6_56(record.get(56));
                                a.SetP1_6_57(record.get(57));
                                a.SetP1_6_58(record.get(58));
                                a.SetP1_6_59(record.get(59));
                                a.SetP1_6_60(record.get(60));
                                a.SetP1_6_61(record.get(61));
                                a.SetP1_6_62(record.get(62));
                                a.SetP1_6_63(record.get(63));
                                a.SetP1_6_64(record.get(64));
                                a.SetP1_6_65(record.get(65));
                                a.SetP1_6_66(record.get(66));
                                a.SetP1_6_67(record.get(67));
                                a.SetP1_6_68(record.get(68));
                                a.SetP1_6_69(record.get(69));
                                a.SetP1_6_70(record.get(70));
                                a.SetP1_6_71(record.get(71));
                                a.SetP1_6_72(record.get(72));
                                a.SetP1_6_73(record.get(73));
                                a.SetP1_6_74(record.get(74));

                                a.SetLEGISLATURA_TMP(Legislatura);
                                a.SetC1_6_ID_TMP(Envio);

                                ad.add(a);
                            }
                        }

                        System.out.println("===== CONTENIDO ad (BeanTMP_PLE_MEDS1_6) =====");
                        System.out.println("Total en ad: " + ad.size());

                        for (int i = 0; i < ad.size(); i++) {
                            BeanTMP_PLE_MEDS1_6 x = ad.get(i);

                            System.out.println("[" + i + "] "
                                    + "ENTIDAD=" + x.GetID_ENTIDAD_TMP()
                                    + ", P1_6_1=" + x.GetP1_6_1()
                                    + ", P1_6_2=" + x.GetP1_6_2()
                                    + ", P1_6_3=" + x.GetP1_6_3()
                                    + ", P1_6_4=" + x.GetP1_6_4()
                                    + ", P1_6_5=" + x.GetP1_6_5()
                                    + ", P1_6_6=" + x.GetP1_6_6()
                                    + ", P1_6_7=" + x.GetP1_6_7()
                                    + ", P1_6_8=" + x.GetP1_6_8()
                                    + ", P1_6_9=" + x.GetP1_6_9()
                                    + ", P1_6_10=" + x.GetP1_6_10()
                                    + ", P1_6_11=" + x.GetP1_6_11()
                                    + ", P1_6_12=" + x.GetP1_6_12()
                                    + ", P1_6_13=" + x.GetP1_6_13()
                                    + ", P1_6_14=" + x.GetP1_6_14()
                                    + ", P1_6_15=" + x.GetP1_6_15()
                                    + ", P1_6_16=" + x.GetP1_6_16()
                                    + ", P1_6_17=" + x.GetP1_6_17()
                                    + ", P1_6_18=" + x.GetP1_6_18()
                                    + ", P1_6_19=" + x.GetP1_6_19()
                                    + ", P1_6_20=" + x.GetP1_6_20()
                                    + ", P1_6_21=" + x.GetP1_6_21()
                                    + ", P1_6_22=" + x.GetP1_6_22()
                                    + ", P1_6_23=" + x.GetP1_6_23()
                                    + ", P1_6_24=" + x.GetP1_6_24()
                                    + ", P1_6_25=" + x.GetP1_6_25()
                                    + ", P1_6_26=" + x.GetP1_6_26()
                                    + ", P1_6_27=" + x.GetP1_6_27()
                                    + ", P1_6_28=" + x.GetP1_6_28()
                                    + ", P1_6_29=" + x.GetP1_6_29()
                                    + ", P1_6_30=" + x.GetP1_6_30()
                                    + ", P1_6_31=" + x.GetP1_6_31()
                                    + ", P1_6_32=" + x.GetP1_6_32()
                                    + ", P1_6_33=" + x.GetP1_6_33()
                                    + ", P1_6_34=" + x.GetP1_6_34()
                                    + ", P1_6_35=" + x.GetP1_6_35()
                                    + ", P1_6_36=" + x.GetP1_6_36()
                                    + ", P1_6_37=" + x.GetP1_6_37()
                                    + ", P1_6_38=" + x.GetP1_6_38()
                                    + ", P1_6_39=" + x.GetP1_6_39()
                                    + ", P1_6_40=" + x.GetP1_6_40()
                                    + ", P1_6_41=" + x.GetP1_6_41()
                                    + ", P1_6_42=" + x.GetP1_6_42()
                                    + ", P1_6_43=" + x.GetP1_6_43()
                                    + ", P1_6_44=" + x.GetP1_6_44()
                                    + ", P1_6_45=" + x.GetP1_6_45()
                                    + ", P1_6_46=" + x.GetP1_6_46()
                                    + ", P1_6_47=" + x.GetP1_6_47()
                                    + ", P1_6_48=" + x.GetP1_6_48()
                                    + ", P1_6_49=" + x.GetP1_6_49()
                                    + ", P1_6_50=" + x.GetP1_6_50()
                                    + ", P1_6_51=" + x.GetP1_6_51()
                                    + ", P1_6_52=" + x.GetP1_6_52()
                                    + ", P1_6_53=" + x.GetP1_6_53()
                                    + ", P1_6_54=" + x.GetP1_6_54()
                                    + ", P1_6_55=" + x.GetP1_6_55()
                                    + ", P1_6_56=" + x.GetP1_6_56()
                                    + ", P1_6_57=" + x.GetP1_6_57()
                                    + ", P1_6_58=" + x.GetP1_6_58()
                                    + ", P1_6_59=" + x.GetP1_6_59()
                                    + ", P1_6_60=" + x.GetP1_6_60()
                                    + ", P1_6_61=" + x.GetP1_6_61()
                                    + ", P1_6_62=" + x.GetP1_6_62()
                                    + ", P1_6_63=" + x.GetP1_6_63()
                                    + ", P1_6_64=" + x.GetP1_6_64()
                                    + ", P1_6_65=" + x.GetP1_6_65()
                                    + ", P1_6_66=" + x.GetP1_6_66()
                                    + ", P1_6_67=" + x.GetP1_6_67()
                                    + ", P1_6_68=" + x.GetP1_6_68()
                                    + ", P1_6_69=" + x.GetP1_6_69()
                                    + ", P1_6_70=" + x.GetP1_6_70()
                                    + ", P1_6_71=" + x.GetP1_6_71()
                                    + ", P1_6_72=" + x.GetP1_6_72()
                                    + ", P1_6_73=" + x.GetP1_6_73()
                                    + ", P1_6_74=" + x.GetP1_6_74()
                            );
                        }

                        System.out.println("entro 1");
                        if (TotalRegistros > 0) {
                            con = OracleDAOFactory.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_6", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_6", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_6(?))}");
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
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros-Iniciativas Urgente Obvia");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El total de número de columnas en el archivo “Iniciativas Urgente Obvia”.CSV no coincide con la bd Oracle");
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
                JOptionPane.showMessageDialog(null, "El archivo de la pestaña “Iniciativas Urgente Obvia” no está en formato UTF-8." + Ruta);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al leer el archivo “Iniciativas Urgente Obvia”" + e);
            e.printStackTrace();
        }
    }
}
