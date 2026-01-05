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
public class Tmp_ple_meds1_1_CSV {
 
    public static String impErro = "", RutaT = "", NuevaRuta = "";
    public static int TotalRegistros = 0;
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
                        System.out.println("+hellooou+" + numeroColumnas);
                        ArrayList<BeanTMP_PLE_MEDS1_1> ad = new ArrayList<>();
                        ArrayList<BeanTMP_PLE_MEDS1_1A> ad1 = new ArrayList<>();
                        for (CSVRecord record : csvParser) {
                            fila++;
                            if (fila == 8) {
                                System.out.println("llenado de csv");
                                TotalRegistros++;
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
                                System.out.println("segunda tabla");
                                int varx = 13;
                                int n = 14;
                               for  (int i=0;i<6;i++)
                               {
                                if (record.get(varx).equalsIgnoreCase("X")) {
                                        BeanTMP_PLE_MEDS1_1A b = new BeanTMP_PLE_MEDS1_1A();
                                        b.SetID_ENTIDAD_TMP(Entidad);
                                        b.SetENTIDAD(Entid);
                                        b.SetC1_1A(String.valueOf(periodos + 1));
                                        b.SetP1_1A_1(("1"));
                                        b.SetP1_1A_2(record.get(n));
                                        b.SetP1_1A_3(record.get(n + 1));
                                        b.SetP1_1A_4(record.get(n + 2));
                                       // n = n + 4;
                                         ad1.add(b);  
                                }
                                varx=varx+5;
                                n=n+5;
                                periodos=periodos+1;
                               }
                            }
                        }
 
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
 
                    }
                }
            }
 
        }
    }
}