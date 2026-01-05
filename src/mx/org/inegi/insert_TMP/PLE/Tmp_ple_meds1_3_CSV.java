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
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_3;
import mx.org.inegi.conexion.PLE.DaoConexion;
import mx.org.inegi.conexion.TEPJF.OracleDAOFactoryTEPJF;
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
public class Tmp_ple_meds1_3_CSV {
 
    public static String impErro = "", RutaT = "", NuevaRuta = "";
    public static int TotalRegistros = 0;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    DaoConexion conexion = new DaoConexion();
    Conver_Utf8 conUTF8 = new Conver_Utf8();
 
    public void Meds1_3_CSV(String Ruta, String Entidad, String Envio, String Legislatura, String Estatus) throws Exception {
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
                    if (numeroColumnas == 90) {
                        System.out.println("+número de columnas: " + numeroColumnas);
                        ArrayList<BeanTMP_PLE_MEDS1_3> ad = new ArrayList<>();
                        for (CSVRecord record : csvParser) {
                            fila++;
                            if (fila == 9) {
                                System.out.println("llenado de csv");
                                TotalRegistros++;
                                BeanTMP_PLE_MEDS1_3 a = new BeanTMP_PLE_MEDS1_3();
                                a.SetID_ENTIDAD_TMP(Entidad);
                                a.SetENTIDAD(Entid);                                
                                a.SetP1_3_1(record.get(1)); 
                                a.SetP1_3_2(record.get(2)); 
                                a.SetP1_3_3(record.get(3)); 
                                a.SetP1_3_4(record.get(4)); 
                                a.SetP1_3_5(record.get(5)); 
                                a.SetP1_3_6(record.get(6)); 
                                a.SetP1_3_7(record.get(7)); 
                                a.SetP1_3_8(record.get(8)); 
                                a.SetP1_3_9(record.get(9)); 
                                a.SetP1_3_10(record.get(10)); 
                                a.SetP1_3_11(record.get(11)); 
                                a.SetP1_3_12(record.get(12)); 
                                a.SetP1_3_13(record.get(13)); 
                                a.SetP1_3_14(record.get(14)); 
                                a.SetP1_3_15(record.get(15)); 
                                a.SetP1_3_16(record.get(16)); 
                                a.SetP1_3_17(record.get(17)); 
                                a.SetP1_3_18(record.get(18)); 
                                a.SetP1_3_19(record.get(19)); 
                                a.SetP1_3_20(record.get(20)); 
                                a.SetP1_3_21(record.get(21)); 
                                a.SetP1_3_22(record.get(22)); 
                                a.SetP1_3_23(record.get(23)); 
                                a.SetP1_3_24(record.get(24)); 
                                a.SetP1_3_25(record.get(25)); 
                                a.SetP1_3_26(record.get(26)); 
                                a.SetP1_3_27(record.get(27)); 
                                a.SetP1_3_28(record.get(28)); 
                                a.SetP1_3_29(record.get(29)); 
                                a.SetP1_3_30(record.get(30)); 
                                a.SetP1_3_31(record.get(31)); 
                                a.SetP1_3_32(record.get(32)); 
                                a.SetP1_3_33(record.get(33)); 
                                a.SetP1_3_34(record.get(34)); 
                                a.SetP1_3_35(record.get(35)); 
                                a.SetP1_3_36(record.get(36)); 
                                a.SetP1_3_37(record.get(37)); 
                                a.SetP1_3_38(record.get(38)); 
                                a.SetP1_3_39(record.get(39)); 
                                a.SetP1_3_40(record.get(40)); 
                                a.SetP1_3_41(record.get(41)); 
                                a.SetP1_3_42(record.get(42)); 
                                a.SetP1_3_43(record.get(43)); 
                                a.SetP1_3_44(record.get(44)); 
                                a.SetP1_3_45(record.get(45)); 
                                a.SetP1_3_46(record.get(46)); 
                                a.SetP1_3_47(record.get(47)); 
                                a.SetP1_3_48(record.get(48)); 
                                a.SetP1_3_49(record.get(49)); 
                                a.SetP1_3_50(record.get(50)); 
                                a.SetP1_3_51(record.get(51)); 
                                a.SetP1_3_52(record.get(52)); 
                                a.SetP1_3_53(record.get(53)); 
                                a.SetP1_3_54(record.get(54)); 
                                a.SetP1_3_55(record.get(55)); 
                                a.SetP1_3_56(record.get(56)); 
                                a.SetP1_3_57(record.get(57)); 
                                a.SetP1_3_58(record.get(58)); 
                                a.SetP1_3_59(record.get(59)); 
                                a.SetP1_3_60(record.get(60)); 
                                a.SetP1_3_61(record.get(61)); 
                                a.SetP1_3_62(record.get(62)); 
                                a.SetP1_3_63(record.get(63)); 
                                a.SetP1_3_64(record.get(64)); 
                                a.SetP1_3_65(record.get(65)); 
                                a.SetP1_3_66(record.get(66)); 
                                a.SetP1_3_67(record.get(67)); 
                                a.SetP1_3_68(record.get(68)); 
                                a.SetP1_3_69(record.get(69)); 
                                a.SetP1_3_70(record.get(70)); 
                                a.SetP1_3_71(record.get(71)); 
                                a.SetP1_3_72(record.get(72)); 
                                a.SetP1_3_73(record.get(73)); 
                                a.SetP1_3_74(record.get(74)); 
                                a.SetP1_3_75(record.get(75)); 
                                a.SetP1_3_76(record.get(76)); 
                                a.SetP1_3_77(record.get(77)); 
                                a.SetP1_3_78(record.get(78)); 
                                a.SetP1_3_79(record.get(79)); 
                                a.SetP1_3_80(record.get(80)); 
                                a.SetP1_3_81(record.get(81)); 
                                a.SetP1_3_82(record.get(82)); 
                                a.SetP1_3_83(record.get(83)); 
                                a.SetP1_3_84(record.get(84)); 
                                a.SetP1_3_85(record.get(85)); 
                                a.SetP1_3_86(record.get(86)); 
                                a.SetP1_3_87(record.get(87)); 
                                a.SetP1_3_88(record.get(88)); 
                                a.SetP1_3_89(record.get(89)); 
                                a.SetP1_3_90(record.get(90)); 
                                a.SetP1_3_91(record.get(91)); 
                                a.SetP1_3_92(record.get(92)); 
                                a.SetP1_3_93(record.get(93)); 
                                a.SetP1_3_94(record.get(94)); 
                                a.SetP1_3_95(record.get(95)); 
                                a.SetP1_3_96(record.get(96)); 
                                a.SetP1_3_97(record.get(97)); 
                                a.SetP1_3_98(record.get(98)); 
                                a.SetP1_3_99(record.get(99)); 
                                a.SetP1_3_100(record.get(100)); 
                                a.SetP1_3_101(record.get(101)); 
                                a.SetP1_3_102(record.get(102)); 
                                a.SetP1_3_103(record.get(103)); 
                                a.SetP1_3_104(record.get(104)); 
                                a.SetP1_3_105(record.get(105)); 
                                a.SetP1_3_106(record.get(106)); 
                                a.SetP1_3_107(record.get(107)); 
                                a.SetP1_3_108(record.get(108)); 
                                a.SetP1_3_109(record.get(109)); 
                                a.SetP1_3_110(record.get(110)); 
                                a.SetP1_3_111(record.get(111)); 
                                a.SetP1_3_112(record.get(112)); 
                                a.SetP1_3_113(record.get(113)); 
                                a.SetP1_3_114(record.get(114)); 
                                a.SetP1_3_115(record.get(115)); 
                                a.SetP1_3_116(record.get(116)); 
                                a.SetP1_3_117(record.get(117)); 
                                a.SetP1_3_118(record.get(118)); 
                                a.SetP1_3_119(record.get(119)); 
                                a.SetLEGISLATURA_TMP(Legislatura);
                                a.SetC1_3_ID_TMP(Envio);
                                ad.add(a);
                                
                            }
                        }
 
                        System.out.println("===== CONTENIDO ad (BeanTMP_PLE_MEDS1_1) =====");
                        System.out.println("Total en ad: " + ad.size());
 
                        for (int i = 0; i < ad.size(); i++) {
                            BeanTMP_PLE_MEDS1_3 x = ad.get(i);
 /*
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
                            );*/
                        }
 
                    
 
                    }
                }
            }
 
        }
    }
}