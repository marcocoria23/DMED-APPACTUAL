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
import mx.org.inegi.bean.JA_TR.BeanTR_JA_CONCLUSIONES;
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
public class TR_JA_CONCLUSIONES {

    public static int CFilas2 = 0;

    public void TR_JA_CONCLUSIONES() throws Exception {

        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
        Conver_Utf8 conUTF8 = new Conver_Utf8();
        String NuevaRuta = directorio + "Conclusiones.csv";
        conUTF8.Convertir_utf8_EBaseDatos(NuevaRuta);
        NuevaRuta = NuevaRuta.replace(".csv", "UTF8.csv");
        System.out.println("Leyendo: " + NuevaRuta);
        try ( BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);

            if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

                    ArrayList<BeanTR_JA_CONCLUSIONES> ad = new ArrayList<>();

                    int numeroColumnas = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("Número de columnas: " + numeroColumnas + "---->if (numeroColumnas <= 262) continúa...");

                    if (numeroColumnas <= 270) { // Cambiar el valor según el número de columnas esperado
                        for (CSVRecord record : csvParser) {
                            if (record.get(0).isEmpty()) {
                                break; // Ignorar registros vacíos
                            }

                            BeanTR_JA_CONCLUSIONES c = new BeanTR_JA_CONCLUSIONES();
                            c.SetNOMBRE_ORGANO_JURIS(record.get(0));
                            c.SetCLAVE_ORGANO(record.get(1));
                            c.SetPERIODO(record.get(2));
                            c.SetTOTAL_RESOLUCIONES(record.get(3));
                            c.SetSENTENCIAS_DEF(record.get(4));
                            c.SetSENTENCIAS_CUMPL_EJEC(record.get(5));
                            c.SetSENTENCIAS_CUMP_RR(record.get(6));
                            c.SetLAUDOS(record.get(7));
                            c.SetCONVENIOS(record.get(8));
                            c.SetDESISTIMIENTOS(record.get(9));
                            c.SetCADUCIDADES(record.get(10));
                            c.SetJURISDICCION_VOLUNTARIA(record.get(11));
                            c.SetOTRO_RESOL(record.get(12));
                            c.SetSD_TOTAL_SENTENCIAS(record.get(13));
                            c.SetSD_SUB_CONTROV_TERR(record.get(14));
                            c.SetSD_CONTROV_TERR_NUC(record.get(15));
                            c.SetSD_CONTROV_TERR_PROPIE(record.get(16));
                            c.SetSD_CONTROV_TERR_SOCI(record.get(17));
                            c.SetSD_CONTROV_TERR_POB_EJIDAL(record.get(18));
                            c.SetSD_SUBTOTAL_ASUNTOS_RESTIT(record.get(19));
                            c.SetSD_RESTIT_AUTORID(record.get(20));
                            c.SetSD_RESTIT_PARTIC(record.get(21));
                            c.SetSD_RECON(record.get(22));
                            c.SetSD_NULIDADES(record.get(23));
                            c.SetSD_TENENCIA(record.get(24));
                            c.SetSD_SUB_ASUNTOS_CON_MA(record.get(25));
                            c.SetSD_CONTROV_MA_EJID(record.get(26));
                            c.SetSD_CONTROV_MA_NUCLEO(record.get(27));
                            c.SetSD_SUCESION_DA(record.get(28));
                            c.SetSD_SUBTOTAL_JN(record.get(29));
                            c.SetSD_JN_PROMOVIDOS(record.get(30));
                            c.SetSD_JN_ACTOS(record.get(31));
                            c.SetSD_OMISIONES(record.get(32));
                            c.SetSD_CONTROV_TERR(record.get(33));
                            c.SetSD_REVERSION(record.get(34));
                            c.SetSD_SUBTOTAL_EJECUCION(record.get(35));
                            c.SetSD_EJECUCION_CONVENIOS(record.get(36));
                            c.SetSD_EJECUCION_LAUDOS(record.get(37));
                            c.SetSD_RRT(record.get(38));
                            c.SetSD_PRIVACION(record.get(39));
                            c.SetSD_INCONFORMIDADES(record.get(40));
                            c.SetSD_ASUNTOS_LEGIS(record.get(41));
                            c.SetSD_OTROS_ASUNTOS(record.get(42));
                            c.SetSCE_TOTAL_SENTENCIAS(record.get(43));
                            c.SetSCE_SUBTOTAL_CON_TERR(record.get(44));
                            c.SetSCE_CONTROV_TERR_NUCLEO(record.get(45));
                            c.SetSCE_CONTROV_TERR_PROPIE(record.get(46));
                            c.SetSCE_CONTROV_TERR_SOCIEDADE(record.get(47));
                            c.SetSCE_CONTROV_TERR_POB_EJIDAL(record.get(48));
                            c.SetSCE_SUBTOTAL_ASUNTOS_RESTIT(record.get(49));
                            c.SetSCE_RESTIT_AUTORID(record.get(50));
                            c.SetSCE_RESTIT_PARTIC(record.get(51));
                            c.SetSCE_RECON(record.get(52));
                            c.SetSCE_NULIDADES(record.get(53));
                            c.SetSCE_TENENCIA(record.get(54));
                            c.SetSCE_SUB_ASUNTOS_CONT_MA(record.get(55));
                            c.SetSCE_CONTROV_MA_EJID(record.get(56));
                            c.SetSCE_CONTROV_MA_NUCLEO(record.get(57));
                            c.SetSCE_SUCESION_DA(record.get(58));
                            c.SetSCE_SUBTOTAL_JN(record.get(59));
                            c.SetSCE_JN_PROMOVIDOS(record.get(60));
                            c.SetSCE_JN_ACTOS(record.get(61));
                            c.SetSCE_OMISIONES(record.get(62));
                            c.SetSCE_ASUNTOS_JV(record.get(63));
                            c.SetSCE_CONTROV_TERR(record.get(64));
                            c.SetSCE_REVERSION(record.get(65));
                            c.SetSCE_SUBTOTAL_EJECUCION(record.get(66));
                            c.SetSCE_EJECUCION_CONVENIOS(record.get(67));
                            c.SetSCE_EJECUCION_LAUDOS(record.get(68));
                            c.SetSCE_RRT(record.get(69));
                            c.SetSCE_PRIVACION(record.get(70));
                            c.SetSCE_INCONFORMIDADES(record.get(71));
                            c.SetSCE_ASUNTOS_LEGIS(record.get(72));
                            c.SetSCE_OTROS_ASUNTOS(record.get(73));
                            c.SetSCR_TOTAL_SENTENCIAS(record.get(74));
                            c.SetSCR_SUBTOTAL_CONTROV_TERR(record.get(75));
                            c.SetSCR_CONTROV_TERR_NUCLEO(record.get(76));
                            c.SetSCR_CONTROV_TERR_PROPIE(record.get(77));
                            c.SetSCR_CONTROV_TERR_SOCIEDADE(record.get(78));
                            c.SetSCR_CONTROV_TERR_POB_EJIDAL(record.get(79));
                            c.SetSCR_SUBTOTAL_ASUNTOS_RESTIT(record.get(80));
                            c.SetSCR_RESTIT_AUTORID(record.get(81));
                            c.SetSCR_RESTIT_PARTIC(record.get(82));
                            c.SetSCR_RECON(record.get(83));
                            c.SetSCR_NULIDADES(record.get(84));
                            c.SetSCR_TENENCIA(record.get(85));
                            c.SetSCR_SUB_ASUNTOS_CONT_MA(record.get(86));
                            c.SetSCR_CONTROV_MA_EJID(record.get(87));
                            c.SetSCR_CONTROV_MA_NUCLEO(record.get(88));
                            c.SetSCR_SUCESION_DA(record.get(89));
                            c.SetSCR_SUBTOTAL_JN(record.get(90));
                            c.SetSCR_JN_PROMOVIDOS(record.get(91));
                            c.SetSCR_JN_ACTOS(record.get(92));
                            c.SetSCR_OMISIONES(record.get(93));
                            c.SetSCR_ASUNTOS_JV(record.get(94));
                            c.SetSCR_CONTROV_TERR(record.get(95));
                            c.SetSCR_REVERSION(record.get(96));
                            c.SetSCR_SUBTOTAL_EJECUCION(record.get(97));
                            c.SetSCR_EJECUCION_CONVENIOS(record.get(98));
                            c.SetSCR_EJECUCION_LAUDOS(record.get(99));
                            c.SetSCR_RRT(record.get(100));
                            c.SetSCR_PRIVACION(record.get(101));
                            c.SetSCR_INCONFORMIDADES(record.get(102));
                            c.SetSCR_ASUNTOS_LEGIS(record.get(103));
                            c.SetSCR_OTROS_ASUNTOS(record.get(104));
                            c.SetLH_TOTAL_LAUDOS(record.get(105));
                            c.SetLH_SUBTOTAL_CONTROV_TERR(record.get(106));
                            c.SetLH_CONTROV_TERR_NUCLEO(record.get(107));
                            c.SetLH_CONTROV_TERR_PROPIE(record.get(108));
                            c.SetLH_CONTROV_TERR_SOCIEDADE(record.get(109));
                            c.SetLH_CONTROV_TERR_POB_EJIDAL(record.get(110));
                            c.SetLH_SUBTOTAL_ASUNTOS_RESTIT(record.get(111));
                            c.SetLH_RESTIT_AUTORID(record.get(112));
                            c.SetLH_RESTIT_PARTIC(record.get(113));
                            c.SetLH_RECON(record.get(114));
                            c.SetLH_NULIDADES(record.get(115));
                            c.SetLH_TENENCIA(record.get(116));
                            c.SetLH_SUB_ASUNTOS_CONT_MA(record.get(117));
                            c.SetLH_CONTROV_MA_EJID(record.get(118));
                            c.SetLH_CONTROV_MA_NUCLEO(record.get(119));
                            c.SetLH_SUCESION_DA(record.get(120));
                            c.SetLH_SUBTOTAL_JN(record.get(121));
                            c.SetLH_JN_PROMOVIDOS(record.get(122));
                            c.SetLH_JN_ACTOS(record.get(123));
                            c.SetLH_OMISIONES(record.get(124));
                            c.SetLH_CONTROV_TERR(record.get(125));
                            c.SetLH_REVERSION(record.get(126));
                            c.SetLH_SUBTOTAL_EJECUCION(record.get(127));
                            c.SetLH_EJECUCION_CONVENIOS(record.get(128));
                            c.SetLH_EJECUCION_LAUDOS(record.get(129));
                            c.SetLH_RRT(record.get(130));
                            c.SetLH_PRIVACION(record.get(131));
                            c.SetLH_INCONFORMIDADES(record.get(132));
                            c.SetLH_ASUNTOS_LEGIS(record.get(133));
                            c.SetLH_OTROS_ASUNTOS(record.get(134));
                            c.SetCSS_TOTAL_CONVENIOS(record.get(135));
                            c.SetCSS_SUBTOTAL_CONTROV_TERR(record.get(136));
                            c.SetCSS_CONTROV_TERR_NUCLEO(record.get(137));
                            c.SetCSS_CONTROV_TERR_PROPIE(record.get(138));
                            c.SetCSS_CONTROV_TERR_SOCIEDADE(record.get(139));
                            c.SetCSS_CONTROV_TERR_POB_EJIDAL(record.get(140));
                            c.SetCSS_SUBTOTAL_ASUNTOS_RESTIT(record.get(141));
                            c.SetCSS_RESTIT_AUTORID(record.get(142));
                            c.SetCSS_RESTIT_PARTIC(record.get(143));
                            c.SetCSS_RECON(record.get(144));
                            c.SetCSS_NULIDADES(record.get(145));
                            c.SetCSS_TENENCIA(record.get(146));
                            c.SetCSS_SUB_ASUNTOS_CONT_MA(record.get(147));
                            c.SetCSS_CONTROV_MA_EJID(record.get(148));
                            c.SetCSS_CONTROV_MA_NUCLEO(record.get(149));
                            c.SetCSS_SUCESION_DA(record.get(150));
                            c.SetCSS_SUBTOTAL_JN_(record.get(151));
                            c.SetCSS_JN_PROMOVIDOS(record.get(152));
                            c.SetCSS_JN_ACTOS(record.get(153));
                            c.SetCSS_OMISIONES(record.get(154));
                            c.SetCSS_ASUNTOS_JV(record.get(155));
                            c.SetCSS_CONTROV_TERR(record.get(156));
                            c.SetCSS_REVERSION(record.get(157));
                            c.SetCSS_SUBTOTAL_EJECUCION(record.get(158));
                            c.SetCSS_EJECUCION_CONVENIOS(record.get(159));
                            c.SetCSS_EJECUCION_LAUDOS(record.get(160));
                            c.SetCSS_RRT(record.get(161));
                            c.SetCSS_PRIVACION(record.get(162));
                            c.SetCSS_INCONFORMIDADES(record.get(163));
                            c.SetCSS_ASUNTOS_LEGIS(record.get(164));
                            c.SetCSS_OTROS_ASUNTOS(record.get(165));
                            c.SetDES_TOTAL_DESMENTIMIENTOS(record.get(166));
                            c.SetDES_SUBTOTAL_CONTROV_TERR(record.get(167));
                            c.SetDES_CONTROV_TERR_NUCLEO(record.get(168));
                            c.SetDES_CONTROV_TERR_PROPIE(record.get(169));
                            c.SetDES_CONTROV_TERR_SOCIEDADE(record.get(170));
                            c.SetDES_CONTROV_TERR_POB_EJIDAL(record.get(171));
                            c.SetDES_SUBTOTAL_ASUNTOS_RESTIT(record.get(172));
                            c.SetDES_RESTIT_AUTORID(record.get(173));
                            c.SetDES_RESTIT_PARTIC(record.get(174));
                            c.SetDES_RECON(record.get(175));
                            c.SetDES_NULIDADES(record.get(176));
                            c.SetDES_TENENCIA(record.get(177));
                            c.SetDES_SUB_ASUNTOS_CONT_MA(record.get(178));
                            c.SetDES_CONTROV_MA_EJID(record.get(179));
                            c.SetDES_CONTROV_MA_NUCLEO(record.get(180));
                            c.SetDES_SUCESION_DA(record.get(181));
                            c.SetDES_SUBTOTAL_JN(record.get(182));
                            c.SetDES_JN_PROMOVIDOS(record.get(183));
                            c.SetDES_JN_ACTOS(record.get(184));
                            c.SetDES_OMISIONES(record.get(185));
                            c.SetDES_ASUNTOS_JV(record.get(186));
                            c.SetDES_CONTROV_TERR(record.get(187));
                            c.SetDES_REVERSION(record.get(188));
                            c.SetDES_SUBTOTAL_EJECUCION(record.get(189));
                            c.SetDES_EJECUCION_CONVENIOS(record.get(190));
                            c.SetDES_EJECUCION_LAUDOS(record.get(191));
                            c.SetDES_RRT(record.get(192));
                            c.SetDES_PRIVACION(record.get(193));
                            c.SetDES_INCONFORMIDADES(record.get(194));
                            c.SetDES_ASUNTOS_LEGIS(record.get(195));
                            c.SetDES_OTROS_ASUNTOS(record.get(196));
                            c.SetCAD_TOTAL_CADUCIDADES(record.get(197));
                            c.SetCAD_SUBTOTAL_CONTROV_TERR(record.get(198));
                            c.SetCAD_CONTROV_TERR_NUCLEO(record.get(199));
                            c.SetCAD_CONTROV_TERR_PROPIE(record.get(200));
                            c.SetCAD_CONTROV_TERR_SOCIEDADE(record.get(201));
                            c.SetCAD_CONTROV_TERR_POB_EJIDAL(record.get(202));
                            c.SetCAD_SUBTOTAL_ASUNTOS_RESTIT(record.get(203));
                            c.SetCAD_RESTIT_AUTORID(record.get(204));
                            c.SetCAD_RESTIT_PARTIC(record.get(205));
                            c.SetCAD_RECON(record.get(206));
                            c.SetCAD_NULIDADES(record.get(207));
                            c.SetCAD_TENENCIA(record.get(208));
                            c.SetCAD_SUB_ASUNTOS_CONT_MA(record.get(209));
                            c.SetCAD_CONTROV_MA_EJID(record.get(210));
                            c.SetCAD_CONTROV_MA_NUCLEO(record.get(211));
                            c.SetCAD_SUCESION_DA(record.get(212));
                            c.SetCAD_SUBTOTAL_JN(record.get(213));
                            c.SetCAD_JN_PROMOVIDOS(record.get(214));
                            c.SetCAD_JN_ACTOS(record.get(215));
                            c.SetCAD_OMISIONES(record.get(216));
                            c.SetCAD_ASUNTOS_JV(record.get(217));
                            c.SetCAD_CONTROV_TERR(record.get(218));
                            c.SetCAD_REVERSION(record.get(219));
                            c.SetCAD_SUBTOTAL_EJECUCION(record.get(220));
                            c.SetCAD_EJECUCION_CONVENIOS(record.get(221));
                            c.SetCAD_EJECUCION_LAUDOS(record.get(222));
                            c.SetCAD_RRT(record.get(223));
                            c.SetCAD_PRIVACION(record.get(224));
                            c.SetCAD_INCONFORMIDADES(record.get(225));
                            c.SetCAD_ASUNTOS_LEGIS(record.get(226));
                            c.SetCAD_OTROS_ASUNTOS(record.get(227));
                            c.SetOTRO_TOTAL_OTRO_TIPO(record.get(228));
                            c.SetOTRO_SUBTOTAL_CONTROV_TERR(record.get(229));
                            c.SetOTRO_CONTROV_TERR_NUCLEO(record.get(230));
                            c.SetOTRO_CONTROV_TERR_PROPIE(record.get(231));
                            c.SetOTRO_CONTROV_TERR_SOCIEDADE(record.get(232));
                            c.SetOTRO_CONTROV_POB_EJIDAL(record.get(233));
                            c.SetOTRO_SUBTOTAL_ASUNTOS_RESTIT(record.get(234));
                            c.SetOTRO_RESTIT_AUTORID(record.get(235));
                            c.SetOTRO_RESTIT_PARTIC(record.get(236));
                            c.SetOTRO_RECON(record.get(237));
                            c.SetOTRO_NULIDADES(record.get(238));
                            c.SetOTRO_TENENCIA(record.get(239));
                            c.SetOTRO_SUB_ASUNTOS_CONT_MA(record.get(240));
                            c.SetOTRO_CONTROV_MA_EJID(record.get(241));
                            c.SetOTRO_CONTROV_MA_NUCLEO(record.get(242));
                            c.SetOTRO_SUCESION_DA(record.get(243));
                            c.SetOTRO_SUBTOTAL_JN(record.get(244));
                            c.SetOTRO_JN_PROMOVIDOS(record.get(245));
                            c.SetOTRO_JN_ACTOS(record.get(246));
                            c.SetOTRO_OMISIONES(record.get(247));
                            c.SetOTRO_ASUNTOS_JV(record.get(248));
                            c.SetOTRO_CONTROV_TERR(record.get(249));
                            c.SetOTRO_REVERSION(record.get(250));
                            c.SetOTRO_SUBTOTAL_EJECUCION(record.get(251));
                            c.SetOTRO_EJECUCION_CONVENIOS(record.get(252));
                            c.SetOTRO_EJECUCION_LAUDOS(record.get(253));
                            c.SetOTRO_RRT(record.get(254));
                            c.SetOTRO_PRIVACION(record.get(255));
                            c.SetOTRO_INCONFORMIDADES(record.get(256));
                            c.SetOTRO_ASUNTOS_LEGIS(record.get(257));
                            c.SetOTRO_OTROS_ASUNTOS(record.get(258));
                            c.SetSD_TOTAL_ESTAT(record.get(259));
                            c.SetSD_ESTAT_NOTIFICAR(record.get(260));
                            c.SetSD_ESTAT_TRANSCURSO(record.get(261));
                            c.SetSD_ESTAT_IMPUGN_RR(record.get(262));
                            c.SetSD_ESTAT_IMPUGN_JA(record.get(263));
                            c.SetSD_ESTAT_EJECUCION(record.get(264));
                            c.SetSDE_TOTAL_TIPO(record.get(265));
                            c.SetSDE_EJECUCION(record.get(266));
                            c.SetSDE_CONVENIOS(record.get(267));
                            c.SetTOTAL_ASUNTOS_CONCL(record.get(268));
                            c.SetCOMENTARIOS(record.get(269));
                            ad.add(c);
                            CFilas++;
                        }
                        CFilas2 = CFilas;
                        if (CFilas > 0) {
                            con = OracleDAOFactoryJA.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TR_JA_CONCLUSIONES_GEN", con);
                            structs = new STRUCT[ad.size()];

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_JA_CONCLUSIONES_GEN", con);
                            array_to_pass = new ARRAY(descriptor, con, structs);

                            st = con.prepareCall("{? = call(PKG_INTEGRADOR_JA.TR_JA_CONCLUSIONES_GEN(?))}");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            st.setArray(2, array_to_pass);
                            st.execute();
                            System.out.println("Se ejecutó paquete integrador Conclusiones, filas: " + CFilas + " \n");
                        } else {
                            JOptionPane.showMessageDialog(null, "Pestaña Conclusiones sin registros");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El número de columnas en la pestaña Conclusiones no es el esperado.");
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
