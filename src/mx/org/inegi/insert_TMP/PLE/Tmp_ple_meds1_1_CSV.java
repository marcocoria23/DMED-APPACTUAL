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
    public static String impErro = "", RutaT = "",NuevaRuta="";
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
            if (numero >=1 && numero <=9) {
                Entid = "0" + Entidad;
            } else {
                Entid = Entidad;
            }
        TotalRegistros = 0;
        
         conUTF8.Convertir_utf8_EBaseDatos(Ruta);
         NuevaRuta=Ruta.replace(".csv", "UTF8.csv");
         try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);
          if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
                System.out.println("El archivo parece estar en UTF-8.");
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));
                        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                    int numeroColumnas = 0;
                    int fila = 0;
                    int periodos =0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("numcol" + numeroColumnas);
                    if (numeroColumnas == 90) {
                        System.out.println("+hellooou+" + numeroColumnas);
                        ArrayList<BeanTMP_PLE_MEDS1_1> ad = new ArrayList<>();
                        ArrayList<BeanTMP_PLE_MEDS1_1A> ad1 = new ArrayList<>();
                        ArrayList<BeanTMP_PLE_MEDS1_1B> ad2 = new ArrayList<>();
                        
                        for (CSVRecord record : csvParser) {
                            fila++;
                            if (fila<9){
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
                            
                            
                             System.out.println("segunda tabla");
                             int varx=13;
                             int n=14;
                             
                             BeanTMP_PLE_MEDS1_1A b = new BeanTMP_PLE_MEDS1_1A();
                             if (record.get(varx).equalsIgnoreCase("X")){
                            for(int j=14;j<42; j++){
                                
                            b.SetID_ENTIDAD_TMP(Entidad);
                            b.SetENTIDAD(Entid);
                            b.SetC1_1A(record.get(periodos+1));
                            b.SetP1_1A_1(record.get("1"));
                            b.SetP1_1A_2(record.get(n));
                            b.SetP1_1A_3(record.get(n+1));
                            b.SetP1_1A_4(record.get(n+2));
                            b.SetLEGISLATURA_TMP(Legislatura);
                            b.SetC1_1A_ID_TMP(Envio);

                            n=n+4;
                            
                             }
                            periodos++;
                            varx=varx+4;
                             }
                            
                            System.out.println("tercer tabla");
                             BeanTMP_PLE_MEDS1_1B c = new BeanTMP_PLE_MEDS1_1B();
                            c.SetID_ENTIDAD_TMP(Entidad);
                            c.SetENTIDAD(Entid);
                            c.SetP1_1B_1(Entid);
                            
                            
                            }
                        }
                    }
                }
                    }
         
         
         }
    }
}
