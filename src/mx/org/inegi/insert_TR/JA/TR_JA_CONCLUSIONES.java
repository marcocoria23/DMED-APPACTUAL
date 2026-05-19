package mx.org.inegi.insert_TR.JA;

import static Pantallas_JA.IntegraJA_TR.RutaAr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.JA_TR.BeanTR_JA_CONCLUSIONES;
import mx.org.inegi.conexion.JA.OracleDAOFactoryJA;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author LAURA.MEDINAJ
 */
public class TR_JA_CONCLUSIONES {

    public static int CFilas2 = 0;

    public void TR_JA_CONCLUSIONES() throws Exception {
        Connection con = null;
        int CFilas = 0;
        System.out.println("==============================");
        System.out.println("Leyendo CONCLUSIONES: " + RutaAr);
        System.out.println("==============================");
        ArrayList<BeanTR_JA_CONCLUSIONES> ad = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(RutaAr);
             Workbook workbook = new XSSFWorkbook(fis)) {
            con = OracleDAOFactoryJA.creaConexion();      
            Sheet sheet = workbook.getSheet("Conclusiones");
            if (sheet == null) {
                JOptionPane.showMessageDialog(null, "No existe la hoja CONCLUSIONES");
                return;
            }
            
            boolean datosEncontrados = false;           
            for (Row row : sheet) {
                Cell nombreCell = row.getCell(0);
                if (nombreCell == null) continue;
                
                String nombreOrgano = formatter.formatCellValue(nombreCell).trim();               
                
                // Empezar cuando encuentre "Tribunal"
                if (!datosEncontrados && nombreOrgano.toUpperCase().startsWith("TRIBUNAL")) {
                    datosEncontrados = true;
                    System.out.println("Datos encontrados. Iniciando lectura desde fila: " + row.getRowNum());
                }               
                
                // Si no hemos encontrado "Tribunal" aún, saltar
                if (!datosEncontrados) continue;              
                
                // Si es una fila vacía o no comienza con "Tribunal", saltar
                if (nombreOrgano.isEmpty() || !nombreOrgano.toUpperCase().startsWith("TRIBUNAL")) continue;  
                
                try {
                    BeanTR_JA_CONCLUSIONES c = new BeanTR_JA_CONCLUSIONES();
                    
                    System.out.println("Fila " + row.getRowNum() + ": " + nombreOrgano);
                    
                    c.SetNOMBRE_ORGANO_JURIS(formatter.formatCellValue(row.getCell(0)));
                    c.SetCLAVE_ORGANO(formatter.formatCellValue(row.getCell(1)));
                    c.SetPERIODO(formatter.formatCellValue(row.getCell(2)));
                    c.SetTOTAL_RESOLUCIONES(formatter.formatCellValue(row.getCell(3)));
                    c.SetSENTENCIAS_DEF(formatter.formatCellValue(row.getCell(4)));
                    c.SetSENTENCIAS_CUMPL_EJEC(formatter.formatCellValue(row.getCell(5)));
                    c.SetSENTENCIAS_CUMP_RR(formatter.formatCellValue(row.getCell(6)));
                    c.SetLAUDOS(formatter.formatCellValue(row.getCell(7)));
                    c.SetCONVENIOS(formatter.formatCellValue(row.getCell(8)));
                    c.SetDESISTIMIENTOS(formatter.formatCellValue(row.getCell(9)));
                    c.SetCADUCIDADES(formatter.formatCellValue(row.getCell(10)));
                    c.SetJURISDICCION_VOLUNTARIA(formatter.formatCellValue(row.getCell(11)));
                    c.SetOTRO_RESOL(formatter.formatCellValue(row.getCell(12)));
                    c.SetSD_TOTAL_SENTENCIAS(formatter.formatCellValue(row.getCell(13)));
                    c.SetSD_SUB_CONTROV_TERR(formatter.formatCellValue(row.getCell(14)));
                    c.SetSD_CONTROV_TERR_NUC(formatter.formatCellValue(row.getCell(15)));
                    c.SetSD_CONTROV_TERR_PROPIE(formatter.formatCellValue(row.getCell(16)));
                    c.SetSD_CONTROV_TERR_SOCI(formatter.formatCellValue(row.getCell(17)));
                    c.SetSD_CONTROV_TERR_COL(formatter.formatCellValue(row.getCell(18)));
                    c.SetSD_SUBTOTAL_ASUNTOS_RES(formatter.formatCellValue(row.getCell(19)));
                    c.SetSD_RESTIT_AUTORID(formatter.formatCellValue(row.getCell(20)));
                    c.SetSD_RESTIT_PARTIC(formatter.formatCellValue(row.getCell(21)));
                    c.SetSD_RECON(formatter.formatCellValue(row.getCell(22)));
                    c.SetSD_NULIDADES(formatter.formatCellValue(row.getCell(23)));
                    c.SetSD_TENENCIA(formatter.formatCellValue(row.getCell(24)));
                    c.SetSD_SUB_ASUNTOS_CON_MA(formatter.formatCellValue(row.getCell(25)));
                    c.SetSD_CONTROV_MA_EJID(formatter.formatCellValue(row.getCell(26)));
                    c.SetSD_CONTROV_MA_NUCLEO(formatter.formatCellValue(row.getCell(27)));
                    c.SetSD_SUCESION_DA(formatter.formatCellValue(row.getCell(28)));
                    c.SetSD_SUBTOTAL_JN(formatter.formatCellValue(row.getCell(29)));
                    c.SetSD_JN_PROMOVIDOS(formatter.formatCellValue(row.getCell(30)));
                    c.SetSD_JN_ACTOS(formatter.formatCellValue(row.getCell(31)));
                    c.SetSD_OMISIONES(formatter.formatCellValue(row.getCell(32)));
                    c.SetSD_CONTROV_TERR(formatter.formatCellValue(row.getCell(33)));
                    c.SetSD_REVERSION(formatter.formatCellValue(row.getCell(34)));
                    c.SetSD_SUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(35)));
                    c.SetSD_EJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(36)));
                    c.SetSD_EJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(37)));
                    c.SetSD_RRT(formatter.formatCellValue(row.getCell(38)));
                    c.SetSD_PRIVACION(formatter.formatCellValue(row.getCell(39)));
                    c.SetSD_INCONFORMIDADES(formatter.formatCellValue(row.getCell(40)));
                    c.SetSD_ASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(41)));
                    c.SetSD_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(42)));
                    c.SetSCE_TOTAL_SENTENCIAS(formatter.formatCellValue(row.getCell(43)));
                    c.SetSCE_SUBTOTAL_CON_TERR(formatter.formatCellValue(row.getCell(44)));
                    c.SetSCE_CONTROV_TERR_NUCLEO(formatter.formatCellValue(row.getCell(45)));
                    c.SetSCE_CONTROV_TERR_PROPIE(formatter.formatCellValue(row.getCell(46)));
                    c.SetSCE_CONTROV_TERR_SOCIEDADE(formatter.formatCellValue(row.getCell(47)));
                    c.SetSCE_CONTROV_TERR_COL(formatter.formatCellValue(row.getCell(48)));
                    c.SetSCE_SUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(49)));
                    c.SetSCE_RESTIT_AUTORID(formatter.formatCellValue(row.getCell(50)));
                    c.SetSCE_RESTIT_PARTIC(formatter.formatCellValue(row.getCell(51)));
                    c.SetSCE_RECON(formatter.formatCellValue(row.getCell(52)));
                    c.SetSCE_NULIDADES(formatter.formatCellValue(row.getCell(53)));
                    c.SetSCE_TENENCIA(formatter.formatCellValue(row.getCell(54)));
                    c.SetSCE_SUB_ASUNTOS_CONT_MA(formatter.formatCellValue(row.getCell(55)));
                    c.SetSCE_CONTROV_MA_EJID(formatter.formatCellValue(row.getCell(56)));
                    c.SetSCE_CONTROV_MA_NUCLEO(formatter.formatCellValue(row.getCell(57)));
                    c.SetSCE_SUCESION_DA(formatter.formatCellValue(row.getCell(58)));
                    c.SetSCE_SUBTOTAL_JN(formatter.formatCellValue(row.getCell(59)));
                    c.SetSCE_JN_PROMOVIDOS(formatter.formatCellValue(row.getCell(60)));
                    c.SetSCE_JN_ACTOS(formatter.formatCellValue(row.getCell(61)));
                    c.SetSCE_OMISIONES(formatter.formatCellValue(row.getCell(62)));
                    c.SetSCE_ASUNTOS_JV(formatter.formatCellValue(row.getCell(63)));
                    c.SetSCE_CONTROV_TERR(formatter.formatCellValue(row.getCell(64)));
                    c.SetSCE_REVERSION(formatter.formatCellValue(row.getCell(65)));
                    c.SetSCE_SUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(66)));
                    c.SetSCE_EJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(67)));
                    c.SetSCE_EJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(68)));
                    c.SetSCE_RRT(formatter.formatCellValue(row.getCell(69)));
                    c.SetSCE_PRIVACION(formatter.formatCellValue(row.getCell(70)));
                    c.SetSCE_INCONFORMIDADES(formatter.formatCellValue(row.getCell(71)));
                    c.SetSCE_ASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(72)));
                    c.SetSCE_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(73)));
                    c.SetSCR_TOTAL_SENTENCIAS(formatter.formatCellValue(row.getCell(74)));
                    c.SetSCR_SUBTOTAL_CONTROV_TERR(formatter.formatCellValue(row.getCell(75)));
                    c.SetSCR_CONTROV_TERR_NUCLEO(formatter.formatCellValue(row.getCell(76)));
                    c.SetSCR_CONTROV_TERR_PROPIE(formatter.formatCellValue(row.getCell(77)));
                    c.SetSCR_CONTROV_TERR_SOCIEDADE(formatter.formatCellValue(row.getCell(78)));
                    c.SetSCR_CONTROV_TERR_COL(formatter.formatCellValue(row.getCell(79)));
                    c.SetSCR_SUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(80)));
                    c.SetSCR_RESTIT_AUTORID(formatter.formatCellValue(row.getCell(81)));
                    c.SetSCR_RESTIT_PARTIC(formatter.formatCellValue(row.getCell(82)));
                    c.SetSCR_RECON(formatter.formatCellValue(row.getCell(83)));
                    c.SetSCR_NULIDADES(formatter.formatCellValue(row.getCell(84)));
                    c.SetSCR_TENENCIA(formatter.formatCellValue(row.getCell(85)));
                    c.SetSCR_SUB_ASUNTOS_CONT_MA(formatter.formatCellValue(row.getCell(86)));
                    c.SetSCR_CONTROV_MA_EJID(formatter.formatCellValue(row.getCell(87)));
                    c.SetSCR_CONTROV_MA_NUCLEO(formatter.formatCellValue(row.getCell(88)));
                    c.SetSCR_SUCESION_DA(formatter.formatCellValue(row.getCell(89)));
                    c.SetSCR_SUBTOTAL_JN(formatter.formatCellValue(row.getCell(90)));
                    c.SetSCR_JN_PROMOVIDOS(formatter.formatCellValue(row.getCell(91)));
                    c.SetSCR_JN_ACTOS(formatter.formatCellValue(row.getCell(92)));
                    c.SetSCR_OMISIONES(formatter.formatCellValue(row.getCell(93)));
                    c.SetSCR_ASUNTOS_JV(formatter.formatCellValue(row.getCell(94)));
                    c.SetSCR_CONTROV_TERR(formatter.formatCellValue(row.getCell(95)));
                    c.SetSCR_REVERSION(formatter.formatCellValue(row.getCell(96)));
                    c.SetSCR_SUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(97)));
                    c.SetSCR_EJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(98)));
                    c.SetSCR_EJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(99)));
                    c.SetSCR_RRT(formatter.formatCellValue(row.getCell(100)));
                    c.SetSCR_PRIVACION(formatter.formatCellValue(row.getCell(101)));
                    c.SetSCR_INCONFORMIDADES(formatter.formatCellValue(row.getCell(102)));
                    c.SetSCR_ASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(103)));
                    c.SetSCR_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(104)));
                    c.SetLH_TOTAL_LAUDOS(formatter.formatCellValue(row.getCell(105)));
                    c.SetLH_SUBTOTAL_CONTROV_TERR(formatter.formatCellValue(row.getCell(106)));
                    c.SetLH_CONTROV_TERR_NUCLEO(formatter.formatCellValue(row.getCell(107)));
                    c.SetLH_CONTROV_TERR_PROPIE(formatter.formatCellValue(row.getCell(108)));
                    c.SetLH_CONTROV_TERR_SOCIEDADE(formatter.formatCellValue(row.getCell(109)));
                    c.SetLH_CONTROV_TERR_COL(formatter.formatCellValue(row.getCell(110)));
                    c.SetLH_SUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(111)));
                    c.SetLH_RESTIT_AUTORID(formatter.formatCellValue(row.getCell(112)));
                    c.SetLH_RESTIT_PARTIC(formatter.formatCellValue(row.getCell(113)));
                    c.SetLH_RECON(formatter.formatCellValue(row.getCell(114)));
                    c.SetLH_NULIDADES(formatter.formatCellValue(row.getCell(115)));
                    c.SetLH_TENENCIA(formatter.formatCellValue(row.getCell(116)));
                    c.SetLH_SUB_ASUNTOS_CONT_MA(formatter.formatCellValue(row.getCell(117)));
                    c.SetLH_CONTROV_MA_EJID(formatter.formatCellValue(row.getCell(118)));
                    c.SetLH_CONTROV_MA_NUCLEO(formatter.formatCellValue(row.getCell(119)));
                    c.SetLH_SUCESION_DA(formatter.formatCellValue(row.getCell(120)));
                    c.SetLH_SUBTOTAL_JN(formatter.formatCellValue(row.getCell(121)));
                    c.SetLH_JN_PROMOVIDOS(formatter.formatCellValue(row.getCell(122)));
                    c.SetLH_JN_ACTOS(formatter.formatCellValue(row.getCell(123)));
                    c.SetLH_OMISIONES(formatter.formatCellValue(row.getCell(124)));
                    c.SetLH_CONTROV_TERR(formatter.formatCellValue(row.getCell(125)));
                    c.SetLH_REVERSION(formatter.formatCellValue(row.getCell(126)));
                    c.SetLH_SUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(127)));
                    c.SetLH_EJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(128)));
                    c.SetLH_EJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(129)));
                    c.SetLH_RRT(formatter.formatCellValue(row.getCell(130)));
                    c.SetLH_PRIVACION(formatter.formatCellValue(row.getCell(131)));
                    c.SetLH_INCONFORMIDADES(formatter.formatCellValue(row.getCell(132)));
                    c.SetLH_ASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(133)));
                    c.SetLH_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(134)));
                    c.SetCSS_TOTAL_CONVENIOS(formatter.formatCellValue(row.getCell(135)));
                    c.SetCSS_SUBTOTAL_CONTROV_TERR(formatter.formatCellValue(row.getCell(136)));
                    c.SetCSS_CONTROV_TERR_NUCLEO(formatter.formatCellValue(row.getCell(137)));
                    c.SetCSS_CONTROV_TERR_PROPIE(formatter.formatCellValue(row.getCell(138)));
                    c.SetCSS_CONTROV_TERR_SOCIEDADE(formatter.formatCellValue(row.getCell(139)));
                    c.SetCSS_CONTROV_TERR_COL(formatter.formatCellValue(row.getCell(140)));
                    c.SetCSS_SUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(141)));
                    c.SetCSS_RESTIT_AUTORID(formatter.formatCellValue(row.getCell(142)));
                    c.SetCSS_RESTIT_PARTIC(formatter.formatCellValue(row.getCell(143)));
                    c.SetCSS_RECON(formatter.formatCellValue(row.getCell(144)));
                    c.SetCSS_NULIDADES(formatter.formatCellValue(row.getCell(145)));
                    c.SetCSS_TENENCIA(formatter.formatCellValue(row.getCell(146)));
                    c.SetCSS_SUB_ASUNTOS_CONT_MA(formatter.formatCellValue(row.getCell(147)));
                    c.SetCSS_CONTROV_MA_EJID(formatter.formatCellValue(row.getCell(148)));
                    c.SetCSS_CONTROV_MA_NUCLEO(formatter.formatCellValue(row.getCell(149)));
                    c.SetCSS_SUCESION_DA(formatter.formatCellValue(row.getCell(150)));
                    c.SetCSS_SUBTOTAL_JN_(formatter.formatCellValue(row.getCell(151)));
                    c.SetCSS_JN_PROMOVIDOS(formatter.formatCellValue(row.getCell(152)));
                    c.SetCSS_JN_ACTOS(formatter.formatCellValue(row.getCell(153)));
                    c.SetCSS_OMISIONES(formatter.formatCellValue(row.getCell(154)));
                    c.SetCSS_ASUNTOS_JV(formatter.formatCellValue(row.getCell(155)));
                    c.SetCSS_CONTROV_TERR(formatter.formatCellValue(row.getCell(156)));
                    c.SetCSS_REVERSION(formatter.formatCellValue(row.getCell(157)));
                    c.SetCSS_SUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(158)));
                    c.SetCSS_EJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(159)));
                    c.SetCSS_EJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(160)));
                    c.SetCSS_RRT(formatter.formatCellValue(row.getCell(161)));
                    c.SetCSS_PRIVACION(formatter.formatCellValue(row.getCell(162)));
                    c.SetCSS_INCONFORMIDADES(formatter.formatCellValue(row.getCell(163)));
                    c.SetCSS_ASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(164)));
                    c.SetCSS_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(165)));
                    c.SetDES_TOTAL_DESMENTIMIENTOS(formatter.formatCellValue(row.getCell(166)));
                    c.SetDES_SUBTOTAL_CONTROV_TERR(formatter.formatCellValue(row.getCell(167)));
                    c.SetDES_CONTROV_TERR_NUCLEO(formatter.formatCellValue(row.getCell(168)));
                    c.SetDES_CONTROV_TERR_PROPIE(formatter.formatCellValue(row.getCell(169)));
                    c.SetDES_CONTROV_TERR_SOCIEDADE(formatter.formatCellValue(row.getCell(170)));
                    c.SetDES_CONTROV_TERR_COL(formatter.formatCellValue(row.getCell(171)));
                    c.SetDES_SUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(172)));
                    c.SetDES_RESTIT_AUTORID(formatter.formatCellValue(row.getCell(173)));
                    c.SetDES_RESTIT_PARTIC(formatter.formatCellValue(row.getCell(174)));
                    c.SetDES_RECON(formatter.formatCellValue(row.getCell(175)));
                    c.SetDES_NULIDADES(formatter.formatCellValue(row.getCell(176)));
                    c.SetDES_TENENCIA(formatter.formatCellValue(row.getCell(177)));
                    c.SetDES_SUB_ASUNTOS_CONT_MA(formatter.formatCellValue(row.getCell(178)));
                    c.SetDES_CONTROV_MA_EJID(formatter.formatCellValue(row.getCell(179)));
                    c.SetDES_CONTROV_MA_NUCLEO(formatter.formatCellValue(row.getCell(180)));
                    c.SetDES_SUCESION_DA(formatter.formatCellValue(row.getCell(181)));
                    c.SetDES_SUBTOTAL_JN(formatter.formatCellValue(row.getCell(182)));
                    c.SetDES_JN_PROMOVIDOS(formatter.formatCellValue(row.getCell(183)));
                    c.SetDES_JN_ACTOS(formatter.formatCellValue(row.getCell(184)));
                    c.SetDES_OMISIONES(formatter.formatCellValue(row.getCell(185)));
                    c.SetDES_ASUNTOS_JV(formatter.formatCellValue(row.getCell(186)));
                    c.SetDES_CONTROV_TERR(formatter.formatCellValue(row.getCell(187)));
                    c.SetDES_REVERSION(formatter.formatCellValue(row.getCell(188)));
                    c.SetDES_SUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(189)));
                    c.SetDES_EJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(190)));
                    c.SetDES_EJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(191)));
                    c.SetDES_RRT(formatter.formatCellValue(row.getCell(192)));
                    c.SetDES_PRIVACION(formatter.formatCellValue(row.getCell(193)));
                    c.SetDES_INCONFORMIDADES(formatter.formatCellValue(row.getCell(194)));
                    c.SetDES_ASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(195)));
                    c.SetDES_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(196)));
                    c.SetCAD_TOTAL_CADUCIDADES(formatter.formatCellValue(row.getCell(197)));
                    c.SetCAD_SUBTOTAL_CONTROV_TERR(formatter.formatCellValue(row.getCell(198)));
                    c.SetCAD_CONTROV_TERR_NUCLEO(formatter.formatCellValue(row.getCell(199)));
                    c.SetCAD_CONTROV_TERR_PROPIE(formatter.formatCellValue(row.getCell(200)));
                    c.SetCAD_CONTROV_TERR_SOCIEDADE(formatter.formatCellValue(row.getCell(201)));
                    c.SetCAD_CONTROV_TERR_COL(formatter.formatCellValue(row.getCell(202)));
                    c.SetCAD_SUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(203)));
                    c.SetCAD_RESTIT_AUTORID(formatter.formatCellValue(row.getCell(204)));
                    c.SetCAD_RESTIT_PARTIC(formatter.formatCellValue(row.getCell(205)));
                    c.SetCAD_RECON(formatter.formatCellValue(row.getCell(206)));
                    c.SetCAD_NULIDADES(formatter.formatCellValue(row.getCell(207)));
                    c.SetCAD_TENENCIA(formatter.formatCellValue(row.getCell(208)));
                    c.SetCAD_SUB_ASUNTOS_CONT_MA(formatter.formatCellValue(row.getCell(209)));
                    c.SetCAD_CONTROV_MA_EJID(formatter.formatCellValue(row.getCell(210)));
                    c.SetCAD_CONTROV_MA_NUCLEO(formatter.formatCellValue(row.getCell(211)));
                    c.SetCAD_SUCESION_DA(formatter.formatCellValue(row.getCell(212)));
                    c.SetCAD_SUBTOTAL_JN(formatter.formatCellValue(row.getCell(213)));
                    c.SetCAD_JN_PROMOVIDOS(formatter.formatCellValue(row.getCell(214)));
                    c.SetCAD_JN_ACTOS(formatter.formatCellValue(row.getCell(215)));
                    c.SetCAD_OMISIONES(formatter.formatCellValue(row.getCell(216)));
                    c.SetCAD_ASUNTOS_JV(formatter.formatCellValue(row.getCell(217)));
                    c.SetCAD_CONTROV_TERR(formatter.formatCellValue(row.getCell(218)));
                    c.SetCAD_REVERSION(formatter.formatCellValue(row.getCell(219)));
                    c.SetCAD_SUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(220)));
                    c.SetCAD_EJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(221)));
                    c.SetCAD_EJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(222)));
                    c.SetCAD_RRT(formatter.formatCellValue(row.getCell(223)));
                    c.SetCAD_PRIVACION(formatter.formatCellValue(row.getCell(224)));
                    c.SetCAD_INCONFORMIDADES(formatter.formatCellValue(row.getCell(225)));
                    c.SetCAD_ASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(226)));
                    c.SetCAD_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(227)));
                    c.SetOTRO_TOTAL_OTRO_TIPO(formatter.formatCellValue(row.getCell(228)));
                    c.SetOTRO_SUBTOTAL_CONTROV_TERR(formatter.formatCellValue(row.getCell(229)));
                    c.SetOTRO_CONTROV_TERR_NUCLEO(formatter.formatCellValue(row.getCell(230)));
                    c.SetOTRO_CONTROV_TERR_PROPIE(formatter.formatCellValue(row.getCell(231)));
                    c.SetOTRO_CONTROV_TERR_SOCIEDADE(formatter.formatCellValue(row.getCell(232)));
                    c.SetOTRO_CONTROV_TERR_COL(formatter.formatCellValue(row.getCell(233)));
                    c.SetOTRO_SUBTOTAL_ASUNTOS_RESTIT(formatter.formatCellValue(row.getCell(234)));
                    c.SetOTRO_RESTIT_AUTORID(formatter.formatCellValue(row.getCell(235)));
                    c.SetOTRO_RESTIT_PARTIC(formatter.formatCellValue(row.getCell(236)));
                    c.SetOTRO_RECON(formatter.formatCellValue(row.getCell(237)));
                    c.SetOTRO_NULIDADES(formatter.formatCellValue(row.getCell(238)));
                    c.SetOTRO_TENENCIA(formatter.formatCellValue(row.getCell(239)));
                    c.SetOTRO_SUB_ASUNTOS_CONT_MA(formatter.formatCellValue(row.getCell(240)));
                    c.SetOTRO_CONTROV_MA_EJID(formatter.formatCellValue(row.getCell(241)));
                    c.SetOTRO_CONTROV_MA_NUCLEO(formatter.formatCellValue(row.getCell(242)));
                    c.SetOTRO_SUCESION_DA(formatter.formatCellValue(row.getCell(243)));
                    c.SetOTRO_SUBTOTAL_JN(formatter.formatCellValue(row.getCell(244)));
                    c.SetOTRO_JN_PROMOVIDOS(formatter.formatCellValue(row.getCell(245)));
                    c.SetOTRO_JN_ACTOS(formatter.formatCellValue(row.getCell(246)));
                    c.SetOTRO_OMISIONES(formatter.formatCellValue(row.getCell(247)));
                    c.SetOTRO_ASUNTOS_JV(formatter.formatCellValue(row.getCell(248)));
                    c.SetOTRO_CONTROV_TERR(formatter.formatCellValue(row.getCell(249)));
                    c.SetOTRO_REVERSION(formatter.formatCellValue(row.getCell(250)));
                    c.SetOTRO_SUBTOTAL_EJECUCION(formatter.formatCellValue(row.getCell(251)));
                    c.SetOTRO_EJECUCION_CONVENIOS(formatter.formatCellValue(row.getCell(252)));
                    c.SetOTRO_EJECUCION_LAUDOS(formatter.formatCellValue(row.getCell(253)));
                    c.SetOTRO_RRT(formatter.formatCellValue(row.getCell(254)));
                    c.SetOTRO_PRIVACION(formatter.formatCellValue(row.getCell(255)));
                    c.SetOTRO_INCONFORMIDADES(formatter.formatCellValue(row.getCell(256)));
                    c.SetOTRO_ASUNTOS_LEGIS(formatter.formatCellValue(row.getCell(257)));
                    c.SetOTRO_OTROS_ASUNTOS(formatter.formatCellValue(row.getCell(258)));
                    c.SetSD_TOTAL_ESTAT(formatter.formatCellValue(row.getCell(259)));
                    c.SetSD_ESTAT_NOTIFICAR(formatter.formatCellValue(row.getCell(260)));
                    c.SetSD_ESTAT_TRANSCURSO(formatter.formatCellValue(row.getCell(261)));
                    c.SetSD_ESTAT_IMPUGN_RR(formatter.formatCellValue(row.getCell(262)));
                    c.SetSD_ESTAT_IMPUGN_JA(formatter.formatCellValue(row.getCell(263)));
                    c.SetSD_ESTAT_EJECUCION(formatter.formatCellValue(row.getCell(264)));
                    c.SetSDE_TOTAL_TIPO(formatter.formatCellValue(row.getCell(265)));
                    c.SetSDE_EJECUCION(formatter.formatCellValue(row.getCell(266)));
                    c.SetSDE_CONVENIOS(formatter.formatCellValue(row.getCell(267)));
                    c.SetTOTAL_ASUNTOS_CONCL(formatter.formatCellValue(row.getCell(268)));
                    c.SetCOMENTARIOS(formatter.formatCellValue(row.getCell(269)));
                    
                    ad.add(c);
                    CFilas++;
                    
                } catch (Exception e) {
                    System.err.println("❌ Error fila " + row.getRowNum() + ": " + e.getMessage());
                    e.printStackTrace();
                    continue;
                }
            }
            
            System.out.println("========Total de filas leídas: " + CFilas + "========");
            CFilas2 = CFilas;
            
            if (!ad.isEmpty()) {
                sendToOracle(ad, con);
            } else {
                JOptionPane.showMessageDialog(null, "Pestaña Conclusiones sin registros");
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error leyendo archivo Excel:\n" + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        System.out.println("Fin de la clase");
    }

    private void sendToOracle(ArrayList<BeanTR_JA_CONCLUSIONES> datos, Connection con) throws SQLException {
        CallableStatement st = null;
        try {
            System.out.println("=== INICIANDO INSERCIÓN ===");
            System.out.println("Registros a insertar: " + datos.size());
            
            if (datos.size() > 0) {
                BeanTR_JA_CONCLUSIONES primerBean = datos.get(0);
                System.out.println("Primer registro:");
                System.out.println("  CLAVE_ORGANO: " + primerBean.GetCLAVE_ORGANO());
                System.out.println("  NOMBRE: " + primerBean.GetNOMBRE_ORGANO_JURIS());
                System.out.println("  PERIODO: " + primerBean.GetPERIODO());
            }
            
            STRUCT[] structs = new STRUCT[datos.size()];
            StructDescriptor sd = StructDescriptor.createDescriptor(
                "RAF_2022.OBJ_TR_JA_CONCLUSIONES_GEN", con
            );
            
            for (int i = 0; i < datos.size(); i++) {
                BeanTR_JA_CONCLUSIONES bean = datos.get(i);
                Object[] obj = bean.toArray();
                structs[i] = new STRUCT(sd, con, obj);
            }
            
            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
                "RAF_2022.ARR_OBJ_TR_JA_CONCLUSIONES_GEN", con
            );
            ARRAY array_to_pass = new ARRAY(descriptor, con, structs);
            
            st = con.prepareCall("{? = call RAF_2022.PKG_INTEGRADOR_JA.TR_JA_CONCLUSIONES_GEN(?)}");
            st.registerOutParameter(1, java.sql.Types.INTEGER);
            st.setArray(2, array_to_pass);
            st.execute();
            
            int resultado = st.getInt(1);
            System.out.println("✓ Función retornó: " + resultado);
            System.out.println("✓ " + datos.size() + " registros procesados");
            System.out.println("=== INSERCIÓN COMPLETADA ===");
            
        } catch (SQLException e) {
            System.err.println("Error en sendToOracle: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            if (st != null) st.close();
        }
    }
}