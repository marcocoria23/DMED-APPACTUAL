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
import mx.org.inegi.bean.JA_TR.BeanTR_JA_TRAMITE;
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
public class TR_JA_TRAMITE {
    public static int CFilas2 =0;

    public void TR_JA_TRAMITE() throws Exception {

        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
        Conver_Utf8 conUTF8 = new Conver_Utf8();
        String NuevaRuta = directorio+"Trámite.csv";
        conUTF8.Convertir_utf8_EBaseDatos(NuevaRuta);
        NuevaRuta = NuevaRuta.replace(".csv", "UTF8.csv");
        System.out.println("Leyendo " + NuevaRuta);
        try ( BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);

            if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                    ArrayList<BeanTR_JA_TRAMITE> ad = new ArrayList<>();
                    int numeroColumnas = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("Número de columnas: " + numeroColumnas+"---->if (numeroColumnas <= 79) continúa...");

                    if (numeroColumnas <= 79) { // Cambiar el valor según el número de columnas esperado
                        for (CSVRecord record : csvParser) {
                            if (record.get(0).isEmpty()) {
                                break; // Ignorar registros vacíos
                            }

                            BeanTR_JA_TRAMITE c = new BeanTR_JA_TRAMITE();
                            c.SetNOMBRE_ORGANO_JURI(record.get(0));
                            c.SetCLAVE_ORGANO(record.get(1));
                            c.SetPERIODO(record.get(2));
                            c.SetTOTAL_ASUNTOS_PEND(record.get(3));
                            c.SetASUNTOS_PEND_PREV(record.get(4));
                            c.SetASUNTOS_PEND_TERM(record.get(5));
                            c.SetASUNTOS_PEND_ADMI(record.get(6));
                            c.SetTOTAL_ASUNTOS_INSTRUCCION(record.get(7));
                            c.SetASUNTOS_JA(record.get(8));
                            c.SetASUNTOS_JV(record.get(9));
                            c.SetTOTAL_ASUNTOS_MATERIA(record.get(10));
                            c.SetSUBTOTAL_ASUNTOS_CONTROV(record.get(11));
                            c.SetCONTROV_NUCLEOS_MENOS20(record.get(12));
                            c.SetCONTROV_PROPIE_MENOS20(record.get(13));
                            c.SetCONTROV_SOCIEDADES_MENOS20(record.get(14));
                            c.SetCONTROV_NUCLEOS_MAS20(record.get(15));
                            c.SetCONTROV_PROPIE_MAS20(record.get(16));
                            c.SetCONTROV_SOCIEDADES_MAS20(record.get(17));
                            c.SetSUBTOTAL_ASUNTOS_RESTIT(record.get(18));
                            c.SetRESTIT_AUTORID_MENOS20(record.get(19));
                            c.SetRESTIT_PARTIC_MENOS20(record.get(20));
                            c.SetRESTIT_AUTORID_MAS20(record.get(21));
                            c.SetRESTIT_PARTIC_MAS20(record.get(22));
                            c.SetSUBTOTAL_RECON(record.get(23));
                            c.SetRECON_MENOS20(record.get(24));
                            c.SetRECON_MAS20(record.get(25));
                            c.SetSUBTOTAL_NULIDADES(record.get(26));
                            c.SetNULIDADES_MENOS20(record.get(27));
                            c.SetNULIDADES_MAS20(record.get(28));
                            c.SetSUBTOTAL_TENENCIA(record.get(29));
                            c.SetTENENCIA_MENOS20(record.get(30));
                            c.SetTENENCIA_MAS20(record.get(31));
                            c.SetSUBTOTAL_ASUNTOS_CONTROV_MA(record.get(32));
                            c.SetCONTROV_MA_EJID_MENOS20(record.get(33));
                            c.SetCONTROV_MA_NUCLEO_MENOS20(record.get(34));
                            c.SetCONTROV_MA_EJID_MASS20(record.get(35));
                            c.SetCONTROV_MA_NUCLEO_MASS20(record.get(36));
                            c.SetSUBTOTAL_ASUNTOS_DERECHOS(record.get(37));
                            c.SetDERECHOS_MENOS20(record.get(38));
                            c.SetDERECHOS_MAS20(record.get(39));
                            c.SetSUBTOTAL_JN(record.get(40));
                            c.SetJN_PROMOVIDOS_MENOS20(record.get(41));
                            c.SetJN_ACTOS_MENOS20(record.get(42));
                            c.SetJN_PROMOVIDOS_MAS20(record.get(43));
                            c.SetJN_ACTOS_MAS20(record.get(44));
                            c.SetSUBTOTAL_OMISIONES(record.get(45));
                            c.SetOMISIONES_MENOS20(record.get(46));
                            c.SetOMISIONES_MAS20(record.get(47));
                            c.SetSUBTOTAL_ASUNTOS_JV(record.get(48));
                            c.SetJV_MENOS20(record.get(49));
                            c.SetJV_MAS20(record.get(50));
                            c.SetSUBTOTAL_CONTROV_TERR(record.get(51));
                            c.SetCONTROV_TERR_MENOS20(record.get(52));
                            c.SetCONTROV_TERR_MAS20(record.get(53));
                            c.SetSUBTOTAL_REVERSION(record.get(54));
                            c.SetREVERSION_MENOS20(record.get(55));
                            c.SetREVERSION_MAS20(record.get(56));
                            c.SetSUBTOTAL_EJECUCION(record.get(57));
                            c.SetEJECUCION_CONVENIOS_MENOS20(record.get(58));
                            c.SetEJECUCION_LAUDOS_MENOS20(record.get(59));
                            c.SetEJECUCION_CONVENIOS_MAS20(record.get(60));
                            c.SetEJECUCION_LAUDOS_MAS20(record.get(61));
                            c.SetSUBTOTAL_ASUNTOS_RRT(record.get(62));
                            c.SetRRT_MENOS20(record.get(63));
                            c.SetRRT_MAS20(record.get(64));
                            c.SetSUBTOTAL_ASUNTOS_DA(record.get(65));
                            c.SetDA_MENOS20(record.get(66));
                            c.SetDA_MAS20(record.get(67));
                            c.SetSUBTOTAL_ASUNTOS_INCONFOR(record.get(68));
                            c.SetINCONFOR_MENOS20(record.get(69));
                            c.SetINCONFOR_MAS20(record.get(70));
                            c.SetSUBTOTAL_ASUNTOS_LA(record.get(71));
                            c.SetLA_MENOS20(record.get(72));
                            c.SetLA_MAS20(record.get(73));
                            c.SetSUBTOTAL_OTROS_ASUNTOS(record.get(74));
                            c.SetOTROS_ASUNTOS_MENOS20(record.get(75));
                            c.SetOTROS_ASUNTOS_MAS20(record.get(76));
                            c.SetTOTAL_ASUNTOS(record.get(77));
                            c.SetCOMENTARIOS(record.get(78));
                            ad.add(c);
                            CFilas++;
                        }
                        
                        CFilas2 = CFilas;
                        if (CFilas > 0) {
                            con = OracleDAOFactoryJA.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TR_JA_TRAMITE_GEN", con);
                            structs = new STRUCT[ad.size()];

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_JA_TRAMITE_GEN", con);
                            array_to_pass = new ARRAY(descriptor, con, structs);

                            st = con.prepareCall("{? = call(PKG_INTEGRADOR_JA.TR_JA_TRAMITE_GEN(?))}");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            st.setArray(2, array_to_pass);
                            st.execute();
                            System.out.println("Se ejecutó paquete integrador Trámite, filas: "+CFilas+" \n");
                        } else {
                            JOptionPane.showMessageDialog(null, "Pestaña Trámite sin registros");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El número de columnas en la pestaña Trámite no es el esperado.");
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
                        throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
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
