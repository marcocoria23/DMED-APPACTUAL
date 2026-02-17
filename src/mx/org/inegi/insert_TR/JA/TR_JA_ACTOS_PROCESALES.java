
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TR.JA;

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
import mx.org.inegi.bean.JA_TR.BeanTR_JA_ACTOS_PROCESALES;
import mx.org.inegi.conexion.JA.OracleDAOFactoryJA;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import static Pantallas_JA.IntegraJA_TR.directorio;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class TR_JA_ACTOS_PROCESALES {
    public static int CFilas2 =0;

    public void TR_JA_ACTOS_PROCESALES() throws Exception {

        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
       int CFilas=0;
        Conver_Utf8 conUTF8 = new Conver_Utf8();
        String NuevaRuta = directorio+"Actos procesales.csv";
        conUTF8.Convertir_utf8_EBaseDatos(NuevaRuta);
        NuevaRuta = NuevaRuta.replace(".csv", "UTF8.csv");
        try ( BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);
            System.out.println("------------Leyendo ACTOS PROCESALES: " + NuevaRuta);
            if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                    ArrayList<BeanTR_JA_ACTOS_PROCESALES> ad = new ArrayList<>();
                    int numeroColumnas = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();                  
                    System.out.println("Número de columnas en archivo CSV: " + numeroColumnas +" Número de columnas esperado: <18." );

                    if (numeroColumnas <=18) { // Cambiar el valor según el número de columnas esperado
                        for (CSVRecord record : csvParser) {                           
                            // Saltar las primeras 6 filas
                            if (record.getRecordNumber() < 7) {
                                continue;
                            }
                            System.out.println("entró a leer fila "+record.getRecordNumber());

                            if (record.get(0).isEmpty()) {                               
                               break;
                            }
                            BeanTR_JA_ACTOS_PROCESALES c = new BeanTR_JA_ACTOS_PROCESALES();                           
                            c.SetNOMBRE_ORGANO_JURIS(record.get(0));
                            
                            c.SetCLAVE_ORGANO(record.get(1));
                            c.SetPERIODO(record.get(2));
                            c.SetTOTAL_AUTOS(record.get(3));
                            c.SetAUTOS_EJECUCION(record.get(4));
                            c.SetOTROS_AUTOS(record.get(5));
                            c.SetTOTAL_DP(record.get(6));
                            c.SetDP_NOTIFICACIONES(record.get(7));
                            c.SetDP_INSPECCIONES(record.get(8));
                            c.SetDP_CITACIONES(record.get(9));
                            c.SetDP_OTRO(record.get(10));
                            c.SetTOTAL_EMPLAZAMIENTOS(record.get(11));
                            c.SetTOTAL_AUDIENCIAS(record.get(12));
                            c.SetAUDIENCIAS_PRESENCIAL(record.get(13));
                            c.SetAUDIENCIAS_REMOTO(record.get(14));
                            c.SetTOTAL_RESOLUCIONES(record.get(15));
                            c.SetCOMENTARIOS(record.get(16));
                            ad.add(c);
                            CFilas++;
                            System.out.println("Valores capturados en Bean"+record);
                        }
                        
                        CFilas2=CFilas;
                        if (CFilas > 0) {
                            con = OracleDAOFactoryJA.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TR_JA_ACTOS_PROCESALES_GEN", con);
                            structs = new STRUCT[ad.size()];
                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_JA_ACTOS_PROCESALES_GEN", con);
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            st = con.prepareCall("{? = call(PKG_INTEGRADOR_JA.TR_JA_ACTOS_PROCESALES_GEN(?))}");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            st.setArray(2, array_to_pass);
                            st.execute();
                            System.out.println("Se ejecutó paquete integrador actos_procesales, filas: "+CFilas+" \n");
                        } else {
                            JOptionPane.showMessageDialog(null, "Pestaña Actos procesales sin registros");
                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El número de columnas de la pestaña ACTOS PROCESALES no es el esperado");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        array_to_pass = null;
                        structs = null;
                        descriptor = null;
                        if (con != null) {
                            con.close();
                            con = null;
                        }
                    } catch (SQLException ex) {
                        throw new SQLException("[error]: " + ex.getLocalizedMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no está en formato UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

