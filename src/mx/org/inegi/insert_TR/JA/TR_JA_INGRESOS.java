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
import mx.org.inegi.bean.JA_TR.BeanTR_JA_INGRESOS;
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
public class TR_JA_INGRESOS {
    public static int CFilas2 =0;

    public void TR_JA_INGRESOS() throws Exception {

        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
        Conver_Utf8 conUTF8 = new Conver_Utf8();
        String NuevaRuta = directorio+"Ingresos.csv";
        conUTF8.Convertir_utf8_EBaseDatos(NuevaRuta);
        NuevaRuta = NuevaRuta.replace(".csv", "UTF8.csv");
        System.out.println("Leyendo: " + NuevaRuta);
        try ( BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);
            if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                    ArrayList<BeanTR_JA_INGRESOS> ad = new ArrayList<>();
                    int numeroColumnas = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("Número de columnas: " + numeroColumnas+"---->if (numeroColumnas <= 43) continúa...");
                    if (numeroColumnas <= 43) { // Cambiar el valor según el número de columnas esperado
                        for (CSVRecord record : csvParser) {
                            if (record.get(0).isEmpty()) {
                                break; // Ignorar registros vacíos
                            }

                            BeanTR_JA_INGRESOS c = new BeanTR_JA_INGRESOS();
                            c.SetNOMBRE_ORGANO_JURIS(record.get(0));
                            c.SetCLAVE_ORGANO(record.get(1));
                            c.SetPERIODO(record.get(2));
                            c.SetTOTAL_INGRESOS(record.get(3));
                            c.SetSUBTOTAL_EXPED_RECIBIDOS(record.get(4));
                            c.SetEXPED_COMISION_MIXTA(record.get(5));
                            c.SetEXPED_TRIBUNAL_SUPERIOR_AG(record.get(6));
                            c.SetEXPED_OTRAS(record.get(7));
                            c.SetSUBTOTAL_DEMANDAS(record.get(8));
                            c.SetDEMANDAS_ESCRITO(record.get(9));
                            c.SetDEMANDAS_COMPARECENCIA(record.get(10));
                            c.SetTOTAL_ASUNTOS_ADMIT_MATERIA(record.get(11));
                            c.SetSUBTOTAL_ASUNTOS_TERRENOS(record.get(12));
                            c.SetCONTROVER_TERR_NUCLEOS(record.get(13));
                            c.SetCONTROVER_TERR_PROPIETARIOS(record.get(14));
                            c.SetCONTROVER_TERR_SOCIEDAD(record.get(15));
                            c.SetSUBTOTAL_ASUNTOS_RESTIT(record.get(16));
                            c.SetRESTIT_ACTOS_AUTORIDAD(record.get(17));
                            c.SetRESTIT_ACTOS_PARTICULAR(record.get(18));
                            c.SetRECON_REG_COMUNAL(record.get(19));
                            c.SetNULIDADES_CONTRA_RESOL(record.get(20));
                            c.SetCONFLICTOS_TENENCIA(record.get(21));
                            c.SetSUBTOTAL_ASUNTOS_MA(record.get(22));
                            c.SetCONTROVER_MA_ENTRE_SI(record.get(23));
                            c.SetCONTROVER_MA_ORGANOS(record.get(24));
                            c.SetSUCESION_DERECHOS(record.get(25));
                            c.SetSUBTOTAL_ASUNTOS_JN(record.get(26));
                            c.SetJN_PROMOVIDOS(record.get(27));
                            c.SetJN_CONTRAVIE(record.get(28));
                            c.SetOMISIONES_PROCUR_PERJUICIO(record.get(29));
                            c.SetASUNTOS_JV(record.get(30));
                            c.SetCONTROVERSIAS_APROVECHAMIENTO(record.get(31));
                            c.SetREVERSION(record.get(32));
                            c.SetSUBTOTAL_ASUNTOS_EJECUCION(record.get(33));
                            c.SetEJECUCION_CONVENIOS(record.get(34));
                            c.SetEJECUCION_LAUDOS(record.get(35));
                            c.SetRRT(record.get(36));
                            c.SetPRIVACION(record.get(37));
                            c.SetINCONFORM(record.get(38));
                            c.SetASUNTOS_LEGIS(record.get(39));
                            c.SetOTROS_ASUNTOS(record.get(40));
                            c.SetTOTAL_DEMANDAS_NO_INTERPUESTAS(record.get(41));
                            c.SetCOMENTARIOS(record.get(42));
                            ad.add(c);
                            CFilas++;
                        }
                        CFilas2 = CFilas;
                        if (CFilas > 0) {
                            con = OracleDAOFactoryJA.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TR_JA_INGRESOS_GEN", con);
                            structs = new STRUCT[ad.size()];

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_JA_INGRESOS_GEN", con);
                            array_to_pass = new ARRAY(descriptor, con, structs);

                            st = con.prepareCall("{? = call(PKG_INTEGRADOR_JA.TR_JA_INGRESOS_GEN(?))}");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            st.setArray(2, array_to_pass);
                            st.execute();
                            System.out.println("Se ejecutó paquete integrador Ingresos, filas: "+CFilas+" \n");
                        } else {
                            JOptionPane.showMessageDialog(null, "Pestaña Ingresos sin registros");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El número de columnas en la pestaña Ingresos no es el esperado.");
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
