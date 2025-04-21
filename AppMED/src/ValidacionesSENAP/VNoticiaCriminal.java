/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidacionesSENAP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.SENAP.ConOracle;

/**
 *
 * @author ANTONIO.CORIA
 */
public class VNoticiaCriminal {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //  ReglaNegocio Adicional: La relación entre los campos  CatEntidadFederativaID (Entidad) y CATMUNICIPIOID (Municipio) de la tabla Noticia Criminal, no coinciden con la relación de los campos CATENTIDADFEDERATIVAID y CATMUNICIPIODEMARCACIONTERRITORIALID del catálogo  SENAP_MUNICIPIODEMARCACIONTERRITOR
    public ArrayList RelacionMunicipio(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (\n"
                + "select UBICACIONID,CATDEMARCACIONID, CATENTFEDID,CATSUBPROREFID, tc.CATMUNICIPIODEMARCACIONTERRITORIALID as catalogo, ub.periodo, ub.ENTIDADID from tr_senap_direccionubicacion ub\n"
                + "left join TC_SENAP_MUNICIPIODEMARCACIONTERRITOR tc on tc.CATMUNICIPIODEMARCACIONTERRITORIALID=ub.CATDEMARCACIONID and tc.catentidadfederativaid=ub.CATENTFEDID)\n"
                + "where catalogo is null and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "') and  CATSUBPROREFID=4";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("UBICACIONID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio GENERAL. El campo Fecha de presentación de la denuncia o querella (columna U) no puede ser mayor a la Fecha Actual.
    public ArrayList FECHAPRESDENUNQUERELLAMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,NOTICIACRIMINALID,PERIODO\n"
                + "FROM TR_SENAP_NOTICIACRIMINAL\n"
                + "WHERE FECHAPRESDENUNQUERELLA > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Los campos Tipo de atención (columna Y), Fecha de inicio de la atención (columna AA), Fecha de conclusión de la atención (columna AB) y Sentido de la conclusión de la atención (columna AC) de la tabla Atenciones no podrán estar vacías, si el campo “En caso de no abrir carpeta de investigación, ¿Se brindó algún tipo de atención?” (columna X) es requisitado con la opción “Si” (1). 
    public ArrayList BRINDOALGUNTIPOATENCION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ate.ENTIDADID,ate.ATENCIONID,ate.NOTICIACRIMINALID,ate.NOTICIACRIMINALID_FISCALIA,ate.PERIODO,\n"
                + "ate.CATTIPOATENCIONID,ate.FECHAINICIOATENCION,ate.FECHCONCLUATE ,ate.CATSENTCONCLUATEID ,nc.BRINDOALGUNTIPOATENCION \n"
                + " FROM TR_SENAP_ATENCIONES ATE INNER JOIN TR_SENAP_NOTICIACRIMINAL NC \n"
                + " ON nc.noticiacriminalid=ate.noticiacriminalid and nc.entidadid=ate.entidadid and nc.periodo=ate.periodo\n"
                + " WHERE NC.BRINDOALGUNTIPOATENCION =1 AND \n"
                + " (ATE.CATTIPOATENCIONID IS NULL OR\n"
                + "ATE.FECHAINICIOATENCION IS NULL OR\n"
                + "ATE.FECHCONCLUATE IS NULL OR\n"
                + "ATE.CATSENTCONCLUATEID IS NULL) AND (ate.ENTIDADID='" + Entidad + "' AND ate.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Los campos Tipo de atención (columna Y), Fecha de inicio de la atención (columna AA), Fecha de conclusión de la atención (columna AB) y Sentido de la conclusión de la atención (columna AC) de la tabla Atenciones, deben estar vacías debido al campo “En caso de no abrir carpeta de investigación, ¿Se brindó algún tipo de atención?” (columna X) es diferente de la opción “Si” (1). 
    public ArrayList BRINDOALGUNTIPOATENCION1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ate.ENTIDADID,ate.ATENCIONID,ate.NOTICIACRIMINALID,ate.NOTICIACRIMINALID_FISCALIA,ate.PERIODO,\n"
                + "ate.CATTIPOATENCIONID,ate.FECHAINICIOATENCION,ate.FECHCONCLUATE ,ate.CATSENTCONCLUATEID ,nc.BRINDOALGUNTIPOATENCION \n"
                + " FROM TR_SENAP_ATENCIONES ATE INNER JOIN TR_SENAP_NOTICIACRIMINAL NC \n"
                + " ON nc.noticiacriminalid=ate.noticiacriminalid and nc.entidadid=ate.entidadid and nc.periodo=ate.periodo\n"
                + " WHERE NC.BRINDOALGUNTIPOATENCION <>1 AND \n"
                + " (ATE.CATTIPOATENCIONID IS not NULL OR\n"
                + "ATE.FECHAINICIOATENCION IS not NULL OR\n"
                + "ATE.FECHCONCLUATE IS not NULL OR\n"
                + "ATE.CATSENTCONCLUATEID IS not NULL) AND (ate.ENTIDADID='" + Entidad + "' AND ate.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //El campo Fecha de conclusión de la atención FECHCONCLUATE (TR_SENAP_ATENCIONES) deberá ser mayor al campo Fecha de inicio de la atención FECHAINICIOATENCION (TR_SENAP_ATENCIONES).
    public ArrayList FECHCONCLUATE(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ate.ENTIDADID,ate.ATENCIONID,ate.NOTICIACRIMINALID,ate.NOTICIACRIMINALID_FISCALIA,ate.PERIODO,\n"
                + "ate.CATTIPOATENCIONID,ate.FECHAINICIOATENCION,ate.FECHCONCLUATE ,ate.CATSENTCONCLUATEID ,nc.BRINDOALGUNTIPOATENCION \n"
                + " FROM TR_SENAP_ATENCIONES ATE INNER JOIN TR_SENAP_NOTICIACRIMINAL NC \n"
                + " ON nc.noticiacriminalid=ate.noticiacriminalid and nc.entidadid=ate.entidadid and nc.periodo=ate.periodo\n"
                + " WHERE NC.BRINDOALGUNTIPOATENCION <>1 AND \n"
                + " (ATE.CATTIPOATENCIONID IS not NULL OR\n"
                + "ATE.FECHAINICIOATENCION IS not NULL OR\n"
                + "ATE.FECHCONCLUATE IS not NULL OR\n"
                + "ATE.CATSENTCONCLUATEID IS not NULL) AND (ate.ENTIDADID='" + Entidad + "' AND ate.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Si el campo "Sentido de la conclusión de la atención" es requisitado con la opción "Apertura de carpeta de investigación" (1) se deberá continuar con el registro de la siguiente plantilla Carpeta de investigación.
    public ArrayList CATSENTCONCLUATEID(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ATE.ENTIDADID, ATE.PERIODO, ATE.ATENCIONID, ATE.NOTICIACRIMINALID, ATE.CATSENTCONCLUATEID, CI.TABLA_CARPETAINVESTIGACION\n"
                + "FROM TR_SENAP_ATENCIONES ATE\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, NOTICIACRIMINALID,  \n"
                + "	count (CARPETAID) AS TABLA_CARPETAINVESTIGACION \n"
                + "	from TR_SENAP_CARPETAINVESTIGACION \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, NOTICIACRIMINALID\n"
                + "	) CI\n"
                + "ON ATE.ENTIDADID = CI.ENTIDADID AND ATE.PERIODO = CI.PERIODO AND ATE.NOTICIACRIMINALID = CI.NOTICIACRIMINALID\n"
                + "WHERE ATE.CATSENTCONCLUATEID = 1\n"
                + "AND CI.TABLA_CARPETAINVESTIGACION IS NULL AND (ATE.ENTIDADID='07' AND ATE.PERIODO='1-07-10/2024')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Si el campo "Sentido de la conclusión de la atención" es diferente de la opción "Apertura de carpeta de investigación" (1) no debe existir registro en la plantilla Carpeta de investigación.
    public ArrayList CATSENTCONCLUATEID_DIFERENTE(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ATE.ENTIDADID, ATE.PERIODO, ATE.ATENCIONID, ATE.NOTICIACRIMINALID, ATE.CATSENTCONCLUATEID, CI.TABLA_CARPETAINVESTIGACION\n"
                + "FROM TR_SENAP_ATENCIONES ATE\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, NOTICIACRIMINALID,  \n"
                + "	count (CARPETAID) AS TABLA_CARPETAINVESTIGACION \n"
                + "	from TR_SENAP_CARPETAINVESTIGACION \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, NOTICIACRIMINALID\n"
                + "	) CI\n"
                + "ON ATE.ENTIDADID = CI.ENTIDADID AND ATE.PERIODO = CI.PERIODO AND ATE.NOTICIACRIMINALID = CI.NOTICIACRIMINALID\n"
                + "WHERE ATE.CATSENTCONCLUATEID <> 1\n"
                + "AND CI.TABLA_CARPETAINVESTIGACION IS NOT NULL AND (ATE.ENTIDADID='+Entidad+' AND ATE.PERIODO='+Periodo+'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Si el campo "Sentido de la conclusión de la atención" se selecciona la opción "Conclusión" (2), "Vista a otra autoridad por incompetencia" (3) u "Otro" (4) se dará por concluido el registro y no se permitirá el llenado de ninguna otra plantilla.
    public ArrayList CATSENTCONCLUATEID_NOIDEN(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ATE.ENTIDADID, ATE.ATENCIONID, ATE.NOTICIACRIMINALID, ATE.PERIODO, ATE.CATSENTCONCLUATEID, CI.TABLA_CARPETAINVESTIGACION, DU.TABLA_DIRECCIONUBICACION, ASE.TABLA_ASEGURAMIENTOS, ACTI.TABLA_ACTOSINVESTIGACION, DEL.TABLA_DELITOS, V.TABLA_VICTIMAS, VD.TABLA_VICTIMASDELITO, MP.TABLA_MEDIDAS_PROTECCION, IMP.TABLA_IMPUTADO, MASC.TABLA_MASC, IMDEL.TABLA_IMPUTADODELITO, VICIM.TABLA_VICTIMAIMPUTADO, DET.TABLA_DETERMINACION, P.TABLA_PROCESO, EI.TABLA_ETAPAINVESTIGACION, MJ.TABLA_MANDAMIENTOSJUDICIALES, IC.TABLA_INVESTIGACIONCOMPLEMENTARIA, MC.TABLA_MEDIDASCAUTELARES, EIN.TABLA_ETAPAINTERMEDIA, SB.TABLA_SOBRESEIMIENTO, SC.TABLA_SUSPENSIONCONDICIONAL, SEN.TABLA_SENTENCIA\n"
                + "FROM TR_SENAP_ATENCIONES ATE\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, NOTICIACRIMINALID,  \n"
                + "	count (CARPETAID) AS TABLA_CARPETAINVESTIGACION \n"
                + "	from TR_SENAP_CARPETAINVESTIGACION \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, NOTICIACRIMINALID\n"
                + "	) CI\n"
                + "ON ATE.ENTIDADID = CI.ENTIDADID AND ATE.PERIODO = CI.PERIODO AND ATE.NOTICIACRIMINALID = CI.NOTICIACRIMINALID\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, UBICACIONID,\n"
                + "	count (UBICACIONID) AS TABLA_DIRECCIONUBICACION \n"
                + "	from TR_SENAP_DIRECCIONUBICACION \n"
                + "	group by ENTIDADID, PERIODO, UBICACIONID\n"
                + "	) DU\n"
                + "ON CI.ENTIDADID = DU.ENTIDADID AND CI.PERIODO = DU.PERIODO\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, ENTFISASEGID,\n"
                + "	count (CARPETAID) AS TABLA_ASEGURAMIENTOS \n"
                + "	from TR_SENAP_ASEGURAMIENTOS\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, ENTFISASEGID\n"
                + "	) ASE\n"
                + "ON CI.ENTIDADID = ASE.ENTIDADID AND CI.PERIODO = ASE.PERIODO AND CI.CARPETAID = ASE.CARPETAID\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, ACTOSID,\n"
                + "	count (CARPETAID) AS TABLA_ACTOSINVESTIGACION \n"
                + "	from TR_SENAP_ACTOSINVESTIGACION\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, ACTOSID\n"
                + "	) ACTI\n"
                + "ON ASE.ENTIDADID = ACTI.ENTIDADID AND ASE.PERIODO = ACTI.PERIODO AND ASE.CARPETAID = ACTI.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, DELITOID, DIRECCIONUBICACIONID,\n"
                + "	count (CARPETAID) AS TABLA_DELITOS\n"
                + "	from TR_SENAP_DELITOS\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, DELITOID, DIRECCIONUBICACIONID\n"
                + "	) DEL\n"
                + "ON ACTI.ENTIDADID = DEL.ENTIDADID AND ACTI.PERIODO = DEL.PERIODO AND ACTI.CARPETAID = DEL.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, VICTIMAID,\n"
                + "	count (CARPETAID) AS TABLA_VICTIMAS\n"
                + "	from TR_SENAP_VICTIMAS\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, VICTIMAID\n"
                + "	) V\n"
                + "ON DEL.ENTIDADID = V.ENTIDADID AND DEL.PERIODO = V.PERIODO AND DEL.CARPETAID = V.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, DELITOID, VICTIMAID, VICTIMASDELITOID,\n"
                + "	count (CARPETAID) AS TABLA_VICTIMASDELITO\n"
                + "	from TR_SENAP_VICTIMASDELITO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, DELITOID, VICTIMAID, VICTIMASDELITOID\n"
                + "	) VD\n"
                + "ON V.ENTIDADID = VD.ENTIDADID AND V.PERIODO = VD.PERIODO AND V.CARPETAID = VD.CARPETAID AND V.VICTIMAID = VD.VICTIMAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, VICTIMAID,\n"
                + "	count (CARPETAID) AS TABLA_MEDIDAS_PROTECCION\n"
                + "	from TR_SENAP_MEDIDAS_PROTECCION\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, VICTIMAID\n"
                + "	) MP\n"
                + "ON VD.ENTIDADID = MP.ENTIDADID AND VD.PERIODO = MP.PERIODO AND VD.CARPETAID = MP.CARPETAID AND VD.VICTIMAID = MP.VICTIMAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, UBICACIONID, DIRECCIONUBICACIONID,\n"
                + "	count (CARPETAID) AS TABLA_IMPUTADO\n"
                + "	from TR_SENAP_IMPUTADO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, UBICACIONID, DIRECCIONUBICACIONID\n"
                + "	) IMP\n"
                + "ON MP.ENTIDADID = IMP.ENTIDADID AND MP.PERIODO = IMP.PERIODO AND MP.CARPETAID = IMP.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n"
                + "	count (CARPETAID) AS TABLA_MASC\n"
                + "	from TR_SENAP_MASC\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n"
                + "	) MASC\n"
                + "ON IMP.ENTIDADID = MASC.ENTIDADID AND IMP.PERIODO = MASC.PERIODO AND IMP.CARPETAID = MASC.CARPETAID \n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, IMPUTADODELITOID, DELITOID,\n"
                + "	count (CARPETAID) AS TABLA_IMPUTADODELITO\n"
                + "	from TR_SENAP_IMPUTADODELITO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, IMPUTADODELITOID, DELITOID\n"
                + "	) IMDEL\n"
                + "ON MASC.ENTIDADID = IMDEL.ENTIDADID AND MASC.PERIODO = IMDEL.PERIODO AND MASC.CARPETAID = IMDEL.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, VICTIMAIMPUTADOID, VICTIMAID,\n"
                + "	count (CARPETAID) AS TABLA_VICTIMAIMPUTADO\n"
                + "	from TR_SENAP_VICTIMAIMPUTADO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, VICTIMAIMPUTADOID, VICTIMAID\n"
                + "	) VICIM\n"
                + "ON IMDEL.ENTIDADID = VICIM.ENTIDADID AND IMDEL.PERIODO = VICIM.PERIODO AND IMDEL.CARPETAID = VICIM.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, IMPUTADODELITOID, DETERMINACIONID,\n"
                + "	count (CARPETAID) AS TABLA_DETERMINACION\n"
                + "	from TR_SENAP_DETERMINACION\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, IMPUTADODELITOID, DETERMINACIONID\n"
                + "	) DET\n"
                + "ON VICIM.ENTIDADID = DET.ENTIDADID AND VICIM.PERIODO = DET.PERIODO AND VICIM.CARPETAID = DET.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n"
                + "	count (PROCESOID) AS TABLA_PROCESO\n"
                + "	from TR_SENAP_PROCESO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n"
                + "	) P\n"
                + "ON DET.ENTIDADID = P.ENTIDADID AND DET.PERIODO = P.PERIODO AND DET.CARPETAID = P.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINVESTIGACIONID,\n"
                + "	count (PROCESOID) AS TABLA_ETAPAINVESTIGACION\n"
                + "	from TR_SENAP_ETAPAINVESTIGACION\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINVESTIGACIONID\n"
                + "	) EI\n"
                + "ON P.ENTIDADID = EI.ENTIDADID AND P.PERIODO = EI.PERIODO AND P.CARPETAID = EI.CARPETAID AND P.PROCESOID = EI.PROCESOID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MANDAMIENTOJUDICIALID,\n"
                + "	count (PROCESOID) AS TABLA_MANDAMIENTOSJUDICIALES\n"
                + "	from TR_SENAP_MANDAMIENTOSJUDICIALES\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MANDAMIENTOJUDICIALID\n"
                + "	) MJ\n"
                + "ON EI.ENTIDADID = MJ.ENTIDADID AND EI.PERIODO = MJ.PERIODO AND EI.CARPETAID = MJ.CARPETAID AND EI.PROCESOID = MJ.PROCESOID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, INVESTIGACIONCOMPLEMENTARIAID,\n"
                + "	count (PROCESOID) AS TABLA_INVESTIGACIONCOMPLEMENTARIA\n"
                + "	from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, INVESTIGACIONCOMPLEMENTARIAID\n"
                + "	) IC\n"
                + "ON MJ.ENTIDADID = IC.ENTIDADID AND MJ.PERIODO = IC.PERIODO AND MJ.CARPETAID = IC.CARPETAID AND MJ.PROCESOID = IC.PROCESOID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MEDIDACAUTELARID,\n"
                + "	count (PROCESOID) AS TABLA_MEDIDASCAUTELARES\n"
                + "	from TR_SENAP_MEDIDASCAUTELARES\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MEDIDACAUTELARID\n"
                + "	) MC\n"
                + "ON IC.ENTIDADID = MC.ENTIDADID AND IC.PERIODO = MC.PERIODO AND IC.CARPETAID = MC.CARPETAID AND IC.PROCESOID = MC.PROCESOID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINTERMEDIAID,\n"
                + "	count (PROCESOID) AS TABLA_ETAPAINTERMEDIA\n"
                + "	from TR_SENAP_ETAPAINTERMEDIA\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINTERMEDIAID\n"
                + "	) EIN\n"
                + "ON MC.ENTIDADID = EIN.ENTIDADID AND MC.PERIODO = EIN.PERIODO AND MC.CARPETAID = EIN.CARPETAID AND MC.PROCESOID = EIN.PROCESOID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SOBRESEIMIENTOID,\n"
                + "	count (PROCESOID) AS TABLA_SOBRESEIMIENTO\n"
                + "	from TR_SENAP_SOBRESEIMIENTO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SOBRESEIMIENTOID\n"
                + "	) SB\n"
                + "ON EIN.ENTIDADID = SB.ENTIDADID AND EIN.PERIODO = SB.PERIODO AND EIN.CARPETAID = SB.CARPETAID AND EIN.PROCESOID = SB.PROCESOID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SUSPENSIONCONDICIONALID,\n"
                + "	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL\n"
                + "	from TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SUSPENSIONCONDICIONALID\n"
                + "	) SC\n"
                + "ON SB.ENTIDADID = SC.ENTIDADID AND SB.PERIODO = SC.PERIODO AND SB.CARPETAID = SC.CARPETAID AND SB.PROCESOID = SC.PROCESOID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SENTENCIAID,\n"
                + "	count (PROCESOID) AS TABLA_SENTENCIA\n"
                + "	from TR_SENAP_SENTENCIA\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SENTENCIAID\n"
                + "	) SEN\n"
                + "ON SC.ENTIDADID = SEN.ENTIDADID AND SC.PERIODO = SEN.PERIODO AND SC.CARPETAID = SEN.CARPETAID AND SC.PROCESOID = SEN.PROCESOID\n"
                + "WHERE ATE.CATSENTCONCLUATEID IN (2,3,4)\n"
                + "AND (\n"
                + "	CI.TABLA_CARPETAINVESTIGACION IS NOT NULL OR\n"
                + "	DU.TABLA_DIRECCIONUBICACION IS NOT NULL OR\n"
                + "  ASE.TABLA_ASEGURAMIENTOS IS NOT NULL OR \n"
                + "  ACTI.TABLA_ACTOSINVESTIGACION IS NOT NULL OR \n"
                + "  DEL.TABLA_DELITOS IS NOT NULL OR \n"
                + "  V.TABLA_VICTIMAS IS NOT NULL OR \n"
                + "  VD.TABLA_VICTIMASDELITO IS NOT NULL OR\n"
                + "  MP.TABLA_MEDIDAS_PROTECCION IS NOT NULL OR\n"
                + "	IMP.TABLA_IMPUTADO IS NOT NULL OR\n"
                + "	MASC.TABLA_MASC IS NOT NULL OR\n"
                + "	IMDEL.TABLA_IMPUTADODELITO IS NOT NULL OR\n"
                + "	VICIM.TABLA_VICTIMAIMPUTADO IS NOT NULL OR\n"
                + "	DET.TABLA_DETERMINACION IS NOT NULL OR\n"
                + "	P.TABLA_PROCESO IS NOT NULL OR\n"
                + "	EI.TABLA_ETAPAINVESTIGACION IS NOT NULL OR\n"
                + "	MJ.TABLA_MANDAMIENTOSJUDICIALES IS NOT NULL OR\n"
                + "	IC.TABLA_INVESTIGACIONCOMPLEMENTARIA IS NOT NULL OR\n"
                + "	MC.TABLA_MEDIDASCAUTELARES IS NOT NULL OR\n"
                + "	EIN.TABLA_ETAPAINTERMEDIA IS NOT NULL OR\n"
                + "	SB.TABLA_SOBRESEIMIENTO IS NOT NULL OR\n"
                + "	SC.TABLA_SUSPENSIONCONDICIONAL IS NOT NULL OR\n"
                + "	SEN.TABLA_SENTENCIA IS NOT NULL\n"
                + "	) AND (ATE.ENTIDADID='+Entidad+' AND ATE.PERIODO='+Periodo+'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Si el campo "Sentido de la conclusión de la atención" se selecciona la opción "No identificado" (9) se dará por concluido el registro y no se permitirá el llenado de ninguna otra plantilla.
    public ArrayList CATSENTCONCLUATEID_IDENT(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ATE.ENTIDADID, ATE.ATENCIONID, ATE.NOTICIACRIMINALID, ATE.PERIODO, ATE.CATSENTCONCLUATEID, CI.TABLA_CARPETAINVESTIGACION, DU.TABLA_DIRECCIONUBICACION, ASE.TABLA_ASEGURAMIENTOS, ACTI.TABLA_ACTOSINVESTIGACION, DEL.TABLA_DELITOS, V.TABLA_VICTIMAS, VD.TABLA_VICTIMASDELITO, MP.TABLA_MEDIDAS_PROTECCION, IMP.TABLA_IMPUTADO, MASC.TABLA_MASC, IMDEL.TABLA_IMPUTADODELITO, VICIM.TABLA_VICTIMAIMPUTADO, DET.TABLA_DETERMINACION, P.TABLA_PROCESO, EI.TABLA_ETAPAINVESTIGACION, MJ.TABLA_MANDAMIENTOSJUDICIALES, IC.TABLA_INVESTIGACIONCOMPLEMENTARIA, MC.TABLA_MEDIDASCAUTELARES, EIN.TABLA_ETAPAINTERMEDIA, SB.TABLA_SOBRESEIMIENTO, SC.TABLA_SUSPENSIONCONDICIONAL, SEN.TABLA_SENTENCIA\n"
                + "FROM TR_SENAP_ATENCIONES ATE\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, NOTICIACRIMINALID,  \n"
                + "	count (CARPETAID) AS TABLA_CARPETAINVESTIGACION \n"
                + "	from TR_SENAP_CARPETAINVESTIGACION \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, NOTICIACRIMINALID\n"
                + "	) CI\n"
                + "ON ATE.ENTIDADID = CI.ENTIDADID AND ATE.PERIODO = CI.PERIODO AND ATE.NOTICIACRIMINALID = CI.NOTICIACRIMINALID\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, UBICACIONID,\n"
                + "	count (UBICACIONID) AS TABLA_DIRECCIONUBICACION \n"
                + "	from TR_SENAP_DIRECCIONUBICACION \n"
                + "	group by ENTIDADID, PERIODO, UBICACIONID\n"
                + "	) DU\n"
                + "ON CI.ENTIDADID = DU.ENTIDADID AND CI.PERIODO = DU.PERIODO\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, ENTFISASEGID,\n"
                + "	count (CARPETAID) AS TABLA_ASEGURAMIENTOS \n"
                + "	from TR_SENAP_ASEGURAMIENTOS\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, ENTFISASEGID\n"
                + "	) ASE\n"
                + "ON CI.ENTIDADID = ASE.ENTIDADID AND CI.PERIODO = ASE.PERIODO AND CI.CARPETAID = ASE.CARPETAID\n"
                + "LEFT JOIN (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, ACTOSID,\n"
                + "	count (CARPETAID) AS TABLA_ACTOSINVESTIGACION \n"
                + "	from TR_SENAP_ACTOSINVESTIGACION\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, ACTOSID\n"
                + "	) ACTI\n"
                + "ON ASE.ENTIDADID = ACTI.ENTIDADID AND ASE.PERIODO = ACTI.PERIODO AND ASE.CARPETAID = ACTI.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, DELITOID, DIRECCIONUBICACIONID,\n"
                + "	count (CARPETAID) AS TABLA_DELITOS\n"
                + "	from TR_SENAP_DELITOS\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, DELITOID, DIRECCIONUBICACIONID\n"
                + "	) DEL\n"
                + "ON ACTI.ENTIDADID = DEL.ENTIDADID AND ACTI.PERIODO = DEL.PERIODO AND ACTI.CARPETAID = DEL.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, VICTIMAID,\n"
                + "	count (CARPETAID) AS TABLA_VICTIMAS\n"
                + "	from TR_SENAP_VICTIMAS\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, VICTIMAID\n"
                + "	) V\n"
                + "ON DEL.ENTIDADID = V.ENTIDADID AND DEL.PERIODO = V.PERIODO AND DEL.CARPETAID = V.CARPETAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, DELITOID, VICTIMAID, VICTIMASDELITOID,\n"
                + "	count (CARPETAID) AS TABLA_VICTIMASDELITO\n"
                + "	from TR_SENAP_VICTIMASDELITO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, DELITOID, VICTIMAID, VICTIMASDELITOID\n"
                + "	) VD\n"
                + "ON V.ENTIDADID = VD.ENTIDADID AND V.PERIODO = VD.PERIODO AND V.CARPETAID = VD.CARPETAID AND V.VICTIMAID = VD.VICTIMAID\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, VICTIMAID,\n"
                + "	count (CARPETAID) AS TABLA_MEDIDAS_PROTECCION\n"
                + "	from TR_SENAP_MEDIDAS_PROTECCION\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, VICTIMAID\n"
                + "	) MP\n"
                + "ON VD.ENTIDADID = MP.ENTIDADID AND VD.PERIODO = MP.PERIODO AND VD.CARPETAID = MP.CARPETAID AND VD.VICTIMAID = MP.VICTIMAID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, UBICACIONID, DIRECCIONUBICACIONID,\n"
                + "	count (CARPETAID) AS TABLA_IMPUTADO\n"
                + "	from TR_SENAP_IMPUTADO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, UBICACIONID, DIRECCIONUBICACIONID\n"
                + "	) IMP\n"
                + "ON MP.ENTIDADID = IMP.ENTIDADID AND MP.PERIODO = IMP.PERIODO AND MP.CARPETAID = IMP.CARPETAID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n"
                + "	count (CARPETAID) AS TABLA_MASC\n"
                + "	from TR_SENAP_MASC\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n"
                + "	) MASC\n"
                + "ON IMP.ENTIDADID = MASC.ENTIDADID AND IMP.PERIODO = MASC.PERIODO AND IMP.CARPETAID = MASC.CARPETAID \n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, IMPUTADODELITOID, DELITOID,\n"
                + "	count (CARPETAID) AS TABLA_IMPUTADODELITO\n"
                + "	from TR_SENAP_IMPUTADODELITO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, IMPUTADODELITOID, DELITOID\n"
                + "	) IMDEL\n"
                + "ON MASC.ENTIDADID = IMDEL.ENTIDADID AND MASC.PERIODO = IMDEL.PERIODO AND MASC.CARPETAID = IMDEL.CARPETAID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, VICTIMAIMPUTADOID, VICTIMAID,\n"
                + "	count (CARPETAID) AS TABLA_VICTIMAIMPUTADO\n"
                + "	from TR_SENAP_VICTIMAIMPUTADO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, VICTIMAIMPUTADOID, VICTIMAID\n"
                + "	) VICIM\n"
                + "ON IMDEL.ENTIDADID = VICIM.ENTIDADID AND IMDEL.PERIODO = VICIM.PERIODO AND IMDEL.CARPETAID = VICIM.CARPETAID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, IMPUTADODELITOID, DETERMINACIONID,\n"
                + "	count (CARPETAID) AS TABLA_DETERMINACION\n"
                + "	from TR_SENAP_DETERMINACION\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, IMPUTADODELITOID, DETERMINACIONID\n"
                + "	) DET\n"
                + "ON VICIM.ENTIDADID = DET.ENTIDADID AND VICIM.PERIODO = DET.PERIODO AND VICIM.CARPETAID = DET.CARPETAID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n"
                + "	count (PROCESOID) AS TABLA_PROCESO\n"
                + "	from TR_SENAP_PROCESO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n"
                + "	) P\n"
                + "ON DET.ENTIDADID = P.ENTIDADID AND DET.PERIODO = P.PERIODO AND DET.CARPETAID = P.CARPETAID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINVESTIGACIONID,\n"
                + "	count (PROCESOID) AS TABLA_ETAPAINVESTIGACION\n"
                + "	from TR_SENAP_ETAPAINVESTIGACION\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINVESTIGACIONID\n"
                + "	) EI\n"
                + "ON P.ENTIDADID = EI.ENTIDADID AND P.PERIODO = EI.PERIODO AND P.CARPETAID = EI.CARPETAID AND P.PROCESOID = EI.PROCESOID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MANDAMIENTOJUDICIALID,\n"
                + "	count (PROCESOID) AS TABLA_MANDAMIENTOSJUDICIALES\n"
                + "	from TR_SENAP_MANDAMIENTOSJUDICIALES\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MANDAMIENTOJUDICIALID\n"
                + "	) MJ\n"
                + "ON EI.ENTIDADID = MJ.ENTIDADID AND EI.PERIODO = MJ.PERIODO AND EI.CARPETAID = MJ.CARPETAID AND EI.PROCESOID = MJ.PROCESOID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, INVESTIGACIONCOMPLEMENTARIAID,\n"
                + "	count (PROCESOID) AS TABLA_INVESTIGACIONCOMPLEMENTARIA\n"
                + "	from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, INVESTIGACIONCOMPLEMENTARIAID\n"
                + "	) IC\n"
                + "ON MJ.ENTIDADID = IC.ENTIDADID AND MJ.PERIODO = IC.PERIODO AND MJ.CARPETAID = IC.CARPETAID AND MJ.PROCESOID = IC.PROCESOID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MEDIDACAUTELARID,\n"
                + "	count (PROCESOID) AS TABLA_MEDIDASCAUTELARES\n"
                + "	from TR_SENAP_MEDIDASCAUTELARES\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MEDIDACAUTELARID\n"
                + "	) MC\n"
                + "ON IC.ENTIDADID = MC.ENTIDADID AND IC.PERIODO = MC.PERIODO AND IC.CARPETAID = MC.CARPETAID AND IC.PROCESOID = MC.PROCESOID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINTERMEDIAID,\n"
                + "	count (PROCESOID) AS TABLA_ETAPAINTERMEDIA\n"
                + "	from TR_SENAP_ETAPAINTERMEDIA\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINTERMEDIAID\n"
                + "	) EIN\n"
                + "ON MC.ENTIDADID = EIN.ENTIDADID AND MC.PERIODO = EIN.PERIODO AND MC.CARPETAID = EIN.CARPETAID AND MC.PROCESOID = EIN.PROCESOID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SOBRESEIMIENTOID,\n"
                + "	count (PROCESOID) AS TABLA_SOBRESEIMIENTO\n"
                + "	from TR_SENAP_SOBRESEIMIENTO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SOBRESEIMIENTOID\n"
                + "	) SB\n"
                + "ON EIN.ENTIDADID = SB.ENTIDADID AND EIN.PERIODO = SB.PERIODO AND EIN.CARPETAID = SB.CARPETAID AND EIN.PROCESOID = SB.PROCESOID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SUSPENSIONCONDICIONALID,\n"
                + "	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL\n"
                + "	from TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SUSPENSIONCONDICIONALID\n"
                + "	) SC\n"
                + "ON SB.ENTIDADID = SC.ENTIDADID AND SB.PERIODO = SC.PERIODO AND SB.CARPETAID = SC.CARPETAID AND SB.PROCESOID = SC.PROCESOID\n"
                + "\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SENTENCIAID,\n"
                + "	count (PROCESOID) AS TABLA_SENTENCIA\n"
                + "	from TR_SENAP_SENTENCIA\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SENTENCIAID\n"
                + "	) SEN\n"
                + "ON SC.ENTIDADID = SEN.ENTIDADID AND SC.PERIODO = SEN.PERIODO AND SC.CARPETAID = SEN.CARPETAID AND SC.PROCESOID = SEN.PROCESOID\n"
                + "WHERE ATE.CATSENTCONCLUATEID = 9\n"
                + "AND (\n"
                + "	CI.TABLA_CARPETAINVESTIGACION IS NOT NULL OR\n"
                + "	DU.TABLA_DIRECCIONUBICACION IS NOT NULL OR\n"
                + "  ASE.TABLA_ASEGURAMIENTOS IS NOT NULL OR \n"
                + "  ACTI.TABLA_ACTOSINVESTIGACION IS NOT NULL OR \n"
                + "  DEL.TABLA_DELITOS IS NOT NULL OR \n"
                + "  V.TABLA_VICTIMAS IS NOT NULL OR \n"
                + "  VD.TABLA_VICTIMASDELITO IS NOT NULL OR\n"
                + "  MP.TABLA_MEDIDAS_PROTECCION IS NOT NULL OR\n"
                + "	IMP.TABLA_IMPUTADO IS NOT NULL OR\n"
                + "	MASC.TABLA_MASC IS NOT NULL OR\n"
                + "	IMDEL.TABLA_IMPUTADODELITO IS NOT NULL OR\n"
                + "	VICIM.TABLA_VICTIMAIMPUTADO IS NOT NULL OR\n"
                + "	DET.TABLA_DETERMINACION IS NOT NULL OR\n"
                + "	P.TABLA_PROCESO IS NOT NULL OR\n"
                + "	EI.TABLA_ETAPAINVESTIGACION IS NOT NULL OR\n"
                + "	MJ.TABLA_MANDAMIENTOSJUDICIALES IS NOT NULL OR\n"
                + "	IC.TABLA_INVESTIGACIONCOMPLEMENTARIA IS NOT NULL OR\n"
                + "	MC.TABLA_MEDIDASCAUTELARES IS NOT NULL OR\n"
                + "	EIN.TABLA_ETAPAINTERMEDIA IS NOT NULL OR\n"
                + "	SB.TABLA_SOBRESEIMIENTO IS NOT NULL OR\n"
                + "	SC.TABLA_SUSPENSIONCONDICIONAL IS NOT NULL OR\n"
                + "	SEN.TABLA_SENTENCIA IS NOT NULL\n"
                + "	) AND (ATE.ENTIDADID='+Entidad+' AND ATE.PERIODO='+Periodo+'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio Adicional Favor de verificar variable CATFISCALIAID-IdentificadorFiscalia en su codigo diferente de 1 a 33 ya que la variable es de prioridad 1
    public ArrayList CATFISCALIA122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT NOTICIACRIMINALID,CATFISCALIAID \n"
                + "FROM TR_SENAP_NOTICIACRIMINAL\n"
                + "WHERE  (CATFISCALIAID \n"
                + "NOT IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33)) and (CATFISCALIAID is null) and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio Adicional Favor de verificar variable CATMEDCONOCHECHOSID-Medio de conocimiento de los hechos en su codigo diferente de 1 a 8 ya que la variable es de prioridad 1
    public ArrayList CATMEDCONOCHECHOSID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT NOTICIACRIMINALID,CATMEDCONOCHECHOSID \n"
                + "FROM TR_SENAP_NOTICIACRIMINAL\n"
                + "WHERE  CATMEDCONOCHECHOSID \n"
                + "NOT IN (1,2,3,4,5,6,7,9) and CATMEDCONOCHECHOSID is null and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ReglaNegocio Adicional Favor de verificar variable NOMBREFISREGIOESPECIALIZADA-Nombre de la fiscalía regional o especializada ya que la variable es de prioridad 1 y no puede ser null
    public ArrayList NOMBREFISREGIOESPECIALIZADA122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT NOTICIACRIMINALID,NOMBREFISREGIOESPECIALIZADA \n"
                + "FROM TR_SENAP_NOTICIACRIMINAL\n"
                + "WHERE  (NOMBREFISREGIOESPECIALIZADA IS NULL) and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ReglaNegocio Adicional Favor de verificar variable NOMBREAGEMINISTERIOPUBLICO-Nombre y número de agencia del ministerio público ya que la variable es de prioridad 1 y no puede ser null
    public ArrayList NOMBREAGEMINISTERIOPUBLICO122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT NOTICIACRIMINALID,NOMBREAGEMINISTERIOPUBLICO \n"
                + "FROM TR_SENAP_NOTICIACRIMINAL\n"
                + "WHERE  (NOMBREAGEMINISTERIOPUBLICO IS NULL) and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio Adicional Favor de verificar variable FECHAPRESDENUNQUERELLA-Fecha de presentación de la denuncia o querella  ya que la variable es de prioridad 1 y no puede venir null
    public ArrayList FECHAPRESDENUNQUERELLA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT NOTICIACRIMINALID,FECHAPRESDENUNQUERELLA \n"
                + "FROM TR_SENAP_NOTICIACRIMINAL\n"
                + "WHERE  FECHAPRESDENUNQUERELLA is null and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio Adicional Favor de verificar variable HORAREPREDENUNQUERELLA-Hora de presentación de la denuncia o querella  ya que la variable es de prioridad 1 y no puede venir null
    public ArrayList HORAREPREDENUNQUERELLA122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT NOTICIACRIMINALID,FECHAPRESDENUNQUERELLA\n"
                + "FROM TR_SENAP_NOTICIACRIMINAL\n"
                + "WHERE  FECHAPRESDENUNQUERELLA is null  or FECHAPRESDENUNQUERELLA='09/09/1899' or FECHAPRESDENUNQUERELLA='01/01/1900'\n"
                + "and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ReglaNegocio Adicional Favor de verificar variable HORAREPREDENUNQUERELLA-Hora de presentación de la denuncia o querella  ya que la variable es de prioridad 1 y no puede venir null
    public ArrayList CATAUTORDENUNQUERELLAID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT NOTICIACRIMINALID,CATAUTORDENUNQUERELLAID \n"
                + "FROM TR_SENAP_NOTICIACRIMINAL\n"
                + "WHERE  CATAUTORDENUNQUERELLAID NOT IN (1,2,9) and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio Adicional favor de verificar variable INICIOCARPETAINVESTIGACION-Inicio carpeta de investigacion? ya que existe desglose en plantilla CarpetaInvestigacion 
    public ArrayList INICIOCARPETAINVESTIGACION122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM(\n"
                + "SELECT P.ENTIDADID,P.PERIODO,P.CARPETAID,P.NOTICIACRIMINALID AS NCCARPETA,\n"
                + "S.NOTICIACRIMINALID,S.INICIOCARPETAINVESTIGACION\n"
                + "FROM TR_SENAP_CARPETAINVESTIGACION P\n"
                + "LEFT JOIN \n"
                + "TR_SENAP_NOTICIACRIMINAL S\n"
                + "ON P.ENTIDADID=S.ENTIDADID AND P.PERIODO=S.PERIODO AND P.NOTICIACRIMINALID=S.NOTICIACRIMINALID)\n"
                + "WHERE INICIOCARPETAINVESTIGACION NOT IN (1,2) and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //La variable INICIOCARPETAINVESTIGACION es obligatoria, por lo tanto debe tener dato válido (1.Sí o 2.No)
    public ArrayList INICIOCARPETAINVESTIGACION_NOTNULL(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select NOTICIA.ENTIDADID, NOTICIA.NOTICIACRIMINALID, NOTICIA.INICIOCARPETAINVESTIGACION, NOTICIA.CARPETAID as carpeta_noticia\n"
                + "from TR_SENAP_NOTICIACRIMINAL NOTICIA \n"
                + "where NOTICIA.INICIOCARPETAINVESTIGACION=0 and  ( NOTICIA.CARPETAID is null or NOTICIA.CARPETAID=0)"
                + "AND  NOTICIA.ENTIDADID='" + Entidad + "' and NOTICIA.PERIODO ='" + Periodo + "' ";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //La variable INICIOCARPETAINVESTIGACION debería ser Sí(1) ya que la variable CARPETAID tiene un ID válido.
    public ArrayList INICIOCARPETAINVESTIGACION_IS1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select NOTICIA.ENTIDADID, NOTICIA.NOTICIACRIMINALID, NOTICIA.INICIOCARPETAINVESTIGACION, NOTICIA.CARPETAID as carpeta_noticia\n"
                + "from TR_SENAP_NOTICIACRIMINAL NOTICIA \n"
                + "where NOTICIA.INICIOCARPETAINVESTIGACION=0 and  ( NOTICIA.CARPETAID is not null and NOTICIA.CARPETAID<>0)\n"
                + "AND NOTICIA.ENTIDADID='" + Entidad + "' and NOTICIA.PERIODO ='" + Periodo + "'";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    //Se indicó que existe una carpeta de investigación para la noticia criminal ( Es decir  la variable INICIOCARPETAINVESTIGACION= 1.Sí), sin embargo no se encontró el desglose en la tabla SENAP_CARPETAINVESTIGACION

    public ArrayList DESGLOSE_CARPETA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select CARPETA.ENTIDADID,CARPETA.CARPETAID, NOTICIA.INICIOCARPETAINVESTIGACION, NOTICIA.CARPETAID as carpeta_noticia\n"
                + "from TR_SENAP_CARPETAINVESTIGACION CARPETA\n"
                + "left join TR_SENAP_NOTICIACRIMINAL NOTICIA \n"
                + "on  NOTICIA.ENTIDADID=CARPETA.ENTIDADID AND NOTICIA.CARPETAID=CARPETA.CARPETAID \n"
                + " AND  NOTICIA.PERIODO=CARPETA.PERIODO  \n"
                + "WHERE  INICIOCARPETAINVESTIGACION=1 AND CARPETA.ENTIDADID='" + Entidad + "'  and CARPETA.PERIODO ='" + Periodo + "'";

        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("NOTICIACRIMINALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
