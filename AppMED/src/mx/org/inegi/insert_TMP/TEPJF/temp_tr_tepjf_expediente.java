/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.insert_TMP.TEPJF;

import Convertir_UTF8.TEPJF.Conver_Utf8;
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
import mx.org.inegi.bean.TEPJF.BeanTEMP_TR_TEPJF_EXPEDIENTE;
import mx.org.inegi.conexion.TEPJF.DaoConexionTEPJF;
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
 * @author ANTONIO.CORIA
 */
public class temp_tr_tepjf_expediente {

    public static String impErro = "", RutaT = "",NuevaRuta="";
    public static int TotalRegistros = 0;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    DaoConexionTEPJF conexion = new DaoConexionTEPJF();
    Conver_Utf8 conUTF8 = new Conver_Utf8();

    public void IN_EXPEDIENTE(String Ruta) throws Exception {

      
        ArrayList<String[]> Array;
        Array = new ArrayList();
        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
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
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("numcol" + numeroColumnas);
                    if (numeroColumnas == 55) {
                        System.out.println("+hellooou+" + numeroColumnas);
                        ArrayList<BeanTEMP_TR_TEPJF_EXPEDIENTE> ad = new ArrayList<>();
                        for (CSVRecord record : csvParser) {
                            System.out.println("llenado de csv");
                            TotalRegistros++;
                            BeanTEMP_TR_TEPJF_EXPEDIENTE c = new BeanTEMP_TR_TEPJF_EXPEDIENTE();
                            c.SetID_TEMP_TEPJF_EXPEDIENTE(record.get(0));
                            c.SetID_EXP_ACUMULADO(record.get(1));
                            c.SetPERIODO(record.get(2));
                            c.SetID_SALA(record.get(3));
                            c.SetDES_SALA(record.get(4));
                            c.SetNOMBRE_MAGISTRADO(record.get(5));
                            c.SetFECHA_INGRESO(record.get(6));
                            c.SetID_ESTATUS_EXP(record.get(7));
                            c.SetFECHA_ING_ARCHIVO(record.get(8));
                            c.SetID_AMBITO_ASUNTO(record.get(9));
                            c.SetID_AGEE(record.get(10));
                            c.SetDES_AGEE(record.get(11));
                            c.SetID_AGEE_FUERA_CIRC(record.get(12));
                            c.SetDES_AGEE_FUERA_CIRC(record.get(13));
                            c.SetID_AGEE_FEDERAL(record.get(14));
                            c.SetDES_AGEE_FEDERAL(record.get(15));
                            c.SetID_AGEM(record.get(16));
                            c.SetDES_AGEM(record.get(17));
                            c.SetID_AGEM_FUERA_CIRC(record.get(18));
                            c.SetDES_AGEM_FUERA_CIRC(record.get(19));
                            c.SetID_AGEM_FEDERAL(record.get(20));
                            c.SetDES_AGEM_FEDERAL(record.get(21));
                            c.SetID_MEDIO_IMPUGNACION(record.get(22));
                            c.SetDES_MEDIO_IMPUGNACION(record.get(23));
                            c.SetID_MATERIA(record.get(24));
                            c.SetID_VINCULACION_PROCESO(record.get(25));
                            c.SetTEMA1_IMPUGNACION_N1(record.get(26));
                            c.SetTEMA1_IMPUGNACION_N2(record.get(27));
                            c.SetTEMA1_IMPUGNACION_N3(record.get(28));
                            c.SetTEMA1_IMPUGNACION_N4(record.get(29));
                            c.SetTEMA2_IMPUGNACION_N1(record.get(30));
                            c.SetTEMA2_IMPUGNACION_N2(record.get(31));
                            c.SetTEMA2_IMPUGNACION_N3(record.get(32));
                            c.SetTEMA2_IMPUGNACION_N4(record.get(33));
                            c.SetTEMA3_IMPUGNACION_N1(record.get(34));
                            c.SetTEMA3_IMPUGNACION_N2(record.get(35));
                            c.SetTEMA3_IMPUGNACION_N3(record.get(36));
                            c.SetTEMA3_IMPUGNACION_N4(record.get(37));
                            c.SetTEMA4_IMPUGNACION_N1(record.get(38));
                            c.SetTEMA4_IMPUGNACION_N2(record.get(39));
                            c.SetTEMA4_IMPUGNACION_N3(record.get(40));
                            c.SetTEMA4_IMPUGNACION_N4(record.get(41));
                            c.SetTEMA5_IMPUGNACION_N1(record.get(42));
                            c.SetTEMA5_IMPUGNACION_N2(record.get(43));
                            c.SetTEMA5_IMPUGNACION_N3(record.get(44));
                            c.SetTEMA5_IMPUGNACION_N4(record.get(45));
                            c.SetOTRO_TEMA1(record.get(46));
                            c.SetOTRO_TEMA2(record.get(47));
                            c.SetOTRO_TEMA3(record.get(48));
                            c.SetOTRO_TEMA4(record.get(49));
                            c.SetOTRO_TEMA5(record.get(50));
                            c.SetCANT_ACTORES(record.get(51));
                            c.SetCANT_RESPONSABLES(record.get(52));
                            c.SetCANT_TERCEROS_INTERESADOS(record.get(53));
                            c.SetOBSERVACIONES(record.get(54));
                            ad.add(c);
                        }

                        System.out.println("entro 1");
                        if (TotalRegistros > 0) {
                            con = OracleDAOFactoryTEPJF.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TEMP_TR_TEPJF_EXPEDIENTE", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TEMP_TR_TEPJF_EXPEDIENTE", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TEMP_TR_TEPJF_EXPEDIENTE(?))}");
                            System.out.println("entro 6");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            System.out.println("entro 7");
                            st.setArray(2, array_to_pass);
                            System.out.println("entro 8");
                            st.execute();
                            System.out.println("entro 9");
                          //  JOptionPane.showMessageDialog(null, "Registros insertados TEMP_TR_TEPJF_EXPEDIENTE"
                            //        + " Favor de revisar ventana -*Errores de insert*- Total registros en .CSV:" + TotalRegistros);

                        } else {
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros-EXPEDIENTES");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El total de numero de columnas en el archivo .CSV no coincide con la bd Oracle");
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
                         //   JOptionPane.showMessageDialog(null, "CONEXION CERRADA!!-EXPEDIENTES");
                            con.close();
                            con = null;
                        }
                    } catch (SQLException ex) {
                        throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no esta en formato UTF-8"+Ruta);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al leer el archivo" + e);
            e.printStackTrace();
        }

  
    }
}
