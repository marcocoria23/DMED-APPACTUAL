/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.insert_TMP.TEPJF;

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
import mx.org.inegi.bean.TEPJF.BeanTEMP_TEPJF_RESPONSABLES;
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
public class temp_tepjf_responsables {

    public static String impErro = "", RutaT = "", NuevaRuta = "";
    public static int TotalRegistros = 0;
    ArrayList Array;
    public static String rutaCarpetaArchivos = "";
    DaoConexionTEPJF conexion = new DaoConexionTEPJF();
    Conver_Utf8 conUTF8 = new Conver_Utf8();

    public void IN_RESPONSABLES(String Ruta) throws Exception {
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
        NuevaRuta = Ruta.replace(".csv", "UTF8.csv");
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
                    if (numeroColumnas == 8) {
                        System.out.println("+hellooou+" + numeroColumnas);
                        ArrayList<BeanTEMP_TEPJF_RESPONSABLES> ad = new ArrayList<>();
                        for (CSVRecord record : csvParser) {
                            System.out.println("llenado de csv");
                            TotalRegistros++;
                            BeanTEMP_TEPJF_RESPONSABLES c = new BeanTEMP_TEPJF_RESPONSABLES();
                            c.setID_TEPJF_EXPEDIENTE(record.get(0));
                            c.setID_TEPJF_RESPONSABLES(record.get(1));
                            c.SetCLASE_RESPONSABLE(record.get(2));
                            c.SetOTRO_CLASE_RESPONSABLE(record.get(3));
                            c.SetPART_POLITICO_NAC_RESPONS(record.get(4));
                            c.SetPART_POLITICO_LOCAL_RESPONS(record.get(5));
                            c.SetSALA_RESPONSABLE(record.get(6));
                            c.SetOBSERVACIONES(record.get(7));

                            ad.add(c);
                        }

                        System.out.println("entro 1");
                        if (TotalRegistros > 0) {
                            con = OracleDAOFactoryTEPJF.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TEMP_TEPJF_RESPONSABLES", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TEMP_TEPJF_RESPONSABLES", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TEMP_TEPJF_RESPONSABLES(?))}");
                            System.out.println("entro 6");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            System.out.println("entro 7");
                            st.setArray(2, array_to_pass);
                            System.out.println("entro 8");
                            st.execute();
                            System.out.println("entro 9");
                           // JOptionPane.showMessageDialog(null, "Registros insertados V3_TMP_AUDIENCIASJL"
                             //       + " Favor de revisar ventana -*Errores de insert*- Total registros en .CSV:" + TotalRegistros);

                        } else {
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros-RESPONSABLES");
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
                           // JOptionPane.showMessageDialog(null, "CONEXION CERRADA!!-TEMP_TR_TEPJF_RESPONSABLES");
                            con.close();
                            con = null;
                        }
                    } catch (SQLException ex) {
                        throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no esta en formato UTF-8" + Ruta);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al leer el archivo" + e);
            e.printStackTrace();
        }
    }
}


