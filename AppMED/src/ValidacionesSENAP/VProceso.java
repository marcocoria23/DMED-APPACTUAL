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
 * @author ANDREA.HERNANDEZL
 */
public class VProceso {
    ConOracle conexion=new ConOracle();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    public static String Query="";
    
    
    
    //La FECHAINICIO (Fecha de ingreso de la causa penal) No debe de ser mayor a la fecha actual.
    public ArrayList FECHAINICIOMayor(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ENTIDADID,PROCESOID,IMPUTADOID,PERIODO\n" +
"FROM TR_SENAP_PROCESO\n" +
"WHERE FECHAINICIO > SYSDATE AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
    //La FECHAAUDIENCIAINICIAL (Fecha de la audiencia inicial) No debe de ser mayor a la fecha actual.
    public ArrayList FECHAAUDIENCIAINICIALMayor(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ENTIDADID,PROCESOID,IMPUTADOID,PERIODO\n" +
"FROM TR_SENAP_PROCESO\n" +
"WHERE FECHAAUDIENCIAINICIAL > SYSDATE AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      
    //La FECHAULTIMOESTATUSPROCESO (Fecha ultimo estatus proceso) No debe de ser mayor a la fecha actual.
    public ArrayList FECHAULTIMOESTATUSPROCESOMayor(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ENTIDADID,PROCESOID,IMPUTADOID,PERIODO\n" +
"FROM TR_SENAP_PROCESO\n" +
"WHERE FECHAULTIMOESTATUSPROCESO > SYSDATE AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E) es requisitado con la opcion “Etapa de investigación inicial” (1) entonces la plantilla Determinación debe ser requisitado.
    public ArrayList CATETAPAPROCESALID(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, D.TABLA_DETERMINACION\n" +
"FROM TR_SENAP_PROCESO P\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,\n" +
"	COUNT (CARPETAID) AS TABLA_DETERMINACION\n" +
"	FROM TR_SENAP_DETERMINACION\n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, DETERMINACIONID\n" +
"	) D \n" +
"	on P.ENTIDADID = D.ENTIDADID and P.PERIODO = D.PERIODO and P.CARPETAID = D.CARPETAID\n" +
"WHERE P.CATETAPAPROCESALID = 1\n" +
"AND D.TABLA_DETERMINACION IS NULL AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E) es requisitado con la opcion “Etapa de investigación inicial” (1) entonces la plantillas Investigación complementaria, Medidas cautelares, Etapa intermedia, Suspensión condicional, Sobreseimiento y Sentencia deben ser requisitadas.
    public ArrayList CATETAPAPROCESALID1(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, IC.TABLA_INVESTIGACIONCOMPLEMENTARIA, MC.TABLA_MEDIDASCAUTELARES, EI.TABLA_ETAPAINTERMEDIA, SC.TABLA_SUSPENSIONCONDICIONAL, SB.TABLA_SOBRESEIMIENTO, S.TABLA_SENTENCIA\n" +
"FROM TR_SENAP_PROCESO P\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	COUNT (PROCESOID) AS TABLA_INVESTIGACIONCOMPLEMENTARIA \n" +
"	FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID\n" +
"	) IC \n" +
"	on P.ENTIDADID = IC.ENTIDADID and P.PERIODO = IC.PERIODO and P.CARPETAID = IC.CARPETAID\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	COUNT (PROCESOID) AS TABLA_MEDIDASCAUTELARES \n" +
"	FROM TR_SENAP_MEDIDASCAUTELARES \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID\n" +
"	) MC\n" +
"	on IC.ENTIDADID = MC.ENTIDADID and IC.PERIODO = MC.PERIODO and IC.CARPETAID = MC.CARPETAID and IC.PROCESOID = MC.PROCESOID\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	COUNT (PROCESOID) AS TABLA_ETAPAINTERMEDIA \n" +
"	FROM TR_SENAP_ETAPAINTERMEDIA \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID\n" +
"	) EI \n" +
"	on MC.ENTIDADID = EI.ENTIDADID and MC.PERIODO = EI.PERIODO and MC.CARPETAID = EI.CARPETAID and MC.PROCESOID = EI.PROCESOID\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	COUNT (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	FROM TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID\n" +
"	) SC\n" +
"	on EI.ENTIDADID = SC.ENTIDADID and EI.PERIODO = SC.PERIODO and EI.CARPETAID = SC.CARPETAID and EI.PROCESOID = SC.PROCESOID\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	COUNT (PROCESOID) AS TABLA_SOBRESEIMIENTO \n" +
"	FROM TR_SENAP_SOBRESEIMIENTO \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID\n" +
"	) SB \n" +
"	on SC.ENTIDADID = SB.ENTIDADID and SC.PERIODO = SB.PERIODO and SC.CARPETAID = SB.CARPETAID and SC.PROCESOID = SB.PROCESOID\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	COUNT (PROCESOID) AS TABLA_SENTENCIA \n" +
"	FROM TR_SENAP_SENTENCIA \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID\n" +
"	) S\n" +
"	on SB.ENTIDADID = S.ENTIDADID and SB.PERIODO = S.PERIODO and SB.CARPETAID = S.CARPETAID and SB.PROCESOID = S.PROCESOID\n" +
"WHERE P.CATETAPAPROCESALID = 1\n" +
"AND (IC.TABLA_INVESTIGACIONCOMPLEMENTARIA IS NOT NULL\n" +
"	or MC.TABLA_MEDIDASCAUTELARES IS NOT NULL\n" +
"	or EI.TABLA_ETAPAINTERMEDIA IS NOT NULL\n" +
"	or SC.TABLA_SUSPENSIONCONDICIONAL IS NOT NULL\n" +
"	or SB.TABLA_SOBRESEIMIENTO IS NOT NULL\n" +
"	or S.TABLA_SENTENCIA IS NOT NULL\n" +
"	) AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E) es “Etapa de investigación inicial” (1), entonces los campos Estatus de la carpeta de investigación (columna D) y Sentido de la determinación (columna E) de la plantilla Determinación deberán ser requisitados.
    public ArrayList CATESTATUSCARPETAID(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, D.CATESTATUSCARPETAID, D.CATSENDETID\n" +
"from TR_SENAP_PROCESO P\n" +
"left join TR_SENAP_DETERMINACION D\n" +
"	on P.ENTIDADID = D.ENTIDADID\n" +
"	and P.PERIODO = D.PERIODO\n" +
"	and P.CARPETAID = D.CARPETAID\n" +
"WHERE P.CATETAPAPROCESALID = 1\n" +
"and (D.CATESTATUSCARPETAID IS NULL or D.CATSENDETID IS NULL) AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E) es requisitado con la opción “Etapa de investigación complementaria” (2) entonces la plantillas Determinación, Mandamientos judiciales e Investigación complementaria deben ser requisitadas.
    public ArrayList CATETAPAPROCESALID2(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, D.TABLA_DETERMINACION, MJ.TABLA_MANDAMIENTOSJUDICIALES, IC.TABLA_INVESTIGACIONCOMPLEMENTARIA\n" +
"FROM TR_SENAP_PROCESO P\n" +
"LEFT JOIN ( \n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,  \n" +
"	COUNT (CARPETAID) AS TABLA_DETERMINACION \n" +
"	FROM TR_SENAP_DETERMINACION \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, DETERMINACIONID\n" +
"	) D \n" +
"on P.ENTIDADID = D.ENTIDADID and P.PERIODO = D.PERIODO and P.CARPETAID = D.CARPETAID \n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, MANDAMIENTOJUDICIALID, IMPUTADOID, \n" +
"	COUNT (IMPUTADOID) AS TABLA_MANDAMIENTOSJUDICIALES \n" +
"	FROM TR_SENAP_MANDAMIENTOSJUDICIALES \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, MANDAMIENTOJUDICIALID, IMPUTADOID\n" +
"	) MJ\n" +
"on D.ENTIDADID = MJ.ENTIDADID and D.PERIODO = MJ.PERIODO and D.CARPETAID = MJ.CARPETAID\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, IMPUTADOID,\n" +
"	COUNT (IMPUTADOID) AS TABLA_INVESTIGACIONCOMPLEMENTARIA \n" +
"	FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, IMPUTADOID\n" +
"	) IC\n" +
"on MJ.ENTIDADID = IC.ENTIDADID and MJ.PERIODO = IC.PERIODO and MJ.CARPETAID = IC.CARPETAID and MJ.PROCESOID = IC.PROCESOID\n" +
"WHERE P.CATETAPAPROCESALID = 2\n" +
"AND (TABLA_DETERMINACION IS NULL\n" +
"  OR MJ.TABLA_MANDAMIENTOSJUDICIALES IS NULL\n" +
"  OR IC.TABLA_INVESTIGACIONCOMPLEMENTARIA IS NULL) AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E) corresponde a la opción “Etapa intermedia” (3), entonces las plantillas Determinación, Proceso, Mandamientos judiciales, Investigación complementaria y Etapa intermedia deben ser requisitadas. 
    public ArrayList CATETAPAPROCESALID3(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, D.TABLA_DETERMINACION, IC.TABLA_INVESTIGACIONCOMPLEMENTARIA, EI.TABLA_ETAPAINTERMEDIA \n" +
"from TR_SENAP_PROCESO P\n" +
"LEFT JOIN ( \n" +
"   SELECT ENTIDADID, PERIODO, CARPETAID,  \n" +
"   COUNT (CARPETAID) AS TABLA_DETERMINACION \n" +
"   FROM TR_SENAP_DETERMINACION \n" +
"   GROUP BY ENTIDADID, PERIODO, CARPETAID, DETERMINACIONID\n" +
"   ) D \n" +
"on P.ENTIDADID = D.ENTIDADID and P.PERIODO = D.PERIODO and P.CARPETAID = D.CARPETAID \n" +
"LEFT JOIN (\n" +
"   SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, IMPUTADOID,\n" +
"   COUNT (IMPUTADOID) AS TABLA_INVESTIGACIONCOMPLEMENTARIA \n" +
"   FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA \n" +
"   GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, IMPUTADOID\n" +
"   ) IC\n" +
"on P.ENTIDADID = IC.ENTIDADID and P.PERIODO = IC.PERIODO and P.CARPETAID = IC.CARPETAID and P.IMPUTADOID = IC.IMPUTADOID and P.PROCESOID = IC.PROCESOID\n" +
"left join (\n" +
"   select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID,\n" +
"   count (IMPUTADOID) AS TABLA_ETAPAINTERMEDIA \n" +
"   from TR_SENAP_ETAPAINTERMEDIA \n" +
"   group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID\n" +
"   ) EI\n" +
"on IC.ENTIDADID = EI.ENTIDADID and IC.PERIODO = EI.PERIODO and IC.CARPETAID = EI.CARPETAID and IC.IMPUTADOID = EI.IMPUTADOID and IC.PROCESOID = EI.PROCESOID\n" +
"where P.ENTIDADID='+Entidad+' AND P.PERIODO='+Periodo+'  \n" +
"and( CATETAPAPROCESALID = 3\n" +
"and D.TABLA_DETERMINACION IS NULL \n" +
"   or TABLA_INVESTIGACIONCOMPLEMENTARIA IS NULL\n" +
"   or TABLA_ETAPAINTERMEDIA IS NULL )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E) es requisitado con la opción “Etapa intermedia” (3), entonces el campo ¿Se formuló acusación? (columna K) de la plantilla Investigación complementaria debe ser requisitada la opción "Si" (1).
    public ArrayList ACUSACION(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, IC.ACUSACION\n" +
"from TR_SENAP_PROCESO P\n" +
"left join TR_SENAP_INVESTIGACIONCOMPLEMENTARIA IC\n" +
"	on P.ENTIDADID = IC.ENTIDADID and P.PERIODO = IC.PERIODO and P.CARPETAID = IC.CARPETAID and P.PROCESOID = IC.PROCESOID\n" +
"where P.CATETAPAPROCESALID = 3\n" +
"and IC.ACUSACION <> 1 AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E), corresponde a la opción “Etapa de juicio” (4), entonces el campo ¿Se dictó auto de apertura a juicio oral? (columna K) debe ser requisitado la opción “Sí” (1) de la plantilla Etapa Intermedia.
    public ArrayList DICTAUTAPERJUICIO(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, EI.DICTAUTAPERJUICIO\n" +
"from TR_SENAP_PROCESO P\n" +
"left join TR_SENAP_ETAPAINTERMEDIA EI\n" +
"	on P.ENTIDADID = EI.ENTIDADID and P.PERIODO = EI.PERIODO and P.CARPETAID = EI.CARPETAID and P.PROCESOID = EI.PROCESOID\n" +
"where P.CATETAPAPROCESALID = 4\n" +
"and EI.DICTAUTAPERJUICIO <> 1 AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E), corresponde a la opción “Etapa de juicio” (4), entonces las plantillas  Determinación, Mandamientos judiciales e Investigación complementaria deben ser requisitadas.
    public ArrayList CATETAPAPROCESALID4(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, D.TABLA_DETERMINACION, MJ.TABLA_MANDAMIENTOSJUDICIALES, IC.TABLA_INVESTIGACIONCOMPLEMENTARIA\n" +
"from TR_SENAP_PROCESO P\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADODELITOID, DETERMINACIONID,\n" +
"	count (CARPETAID) AS TABLA_DETERMINACION \n" +
"	from TR_SENAP_DETERMINACION \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADODELITOID, DETERMINACIONID\n" +
"	) D\n" +
"	on P.ENTIDADID = D.ENTIDADID and P.PERIODO = D.PERIODO and P.CARPETAID = D.CARPETAID\n" +
"left join(\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MANDAMIENTOJUDICIALID,\n" +
"	count (IMPUTADOID) AS TABLA_MANDAMIENTOSJUDICIALES \n" +
"	from TR_SENAP_MANDAMIENTOSJUDICIALES \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MANDAMIENTOJUDICIALID\n" +
"	) MJ\n" +
"	on D.ENTIDADID = MJ.ENTIDADID and D.PERIODO = MJ.PERIODO and D.CARPETAID = MJ.CARPETAID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID,\n" +
"	count (IMPUTADOID) AS TABLA_INVESTIGACIONCOMPLEMENTARIA \n" +
"	from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID\n" +
"	) IC\n" +
"	on MJ.ENTIDADID = IC.ENTIDADID and MJ.PERIODO = IC.PERIODO and MJ.CARPETAID = IC.CARPETAID and MJ.PROCESOID = IC.PROCESOID\n" +
"where P.CATETAPAPROCESALID = 4\n" +
"and (D.TABLA_DETERMINACION is null\n" +
"	or MJ.TABLA_MANDAMIENTOSJUDICIALES is null\n" +
"	or IC.TABLA_INVESTIGACIONCOMPLEMENTARIA is null\n" +
") AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E), corresponde a la opción “Etapa de juicio” (4), entonces el campo Sentido de la determinación (columna E) de la plantilla Determinación deberá ser requisitado con una de las siguientes opciones “Ejercicio de la acción penal” (1) o “No identificado” (99).
    public ArrayList CATSENDETID(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, D.CATSENDETID\n" +
"from TR_SENAP_PROCESO P\n" +
"left join TR_SENAP_DETERMINACION D\n" +
"	on P.ENTIDADID = D.ENTIDADID and P.PERIODO = D.PERIODO and P.CARPETAID = D.CARPETAID \n" +
"where P.CATETAPAPROCESALID = 4\n" +
"and D.CATSENDETID not in (1,99) AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Etapa procesal en la que se encuentra el imputado (columna E), corresponde a la opción “Etapa de juicio” (4) y el campo Estatus de la carpeta de investigación (columna D) de la plantilla Determinación tiene el valor “Concluida” (1), no debe existir información en las plantillas Suspensión condicional (cumplimentada), MASC y Sobreseimiento.
    public ArrayList CATESTATUSCARPETAID1(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATETAPAPROCESALID, D.CATESTATUSCARPETAID, SC.TABLA_SUSPENSIONCONDICIONAL, MASC.TABLA_MASC, SB.TABLA_SOBRESEIMIENTO\n" +
"from TR_SENAP_PROCESO P\n" +
"left join TR_SENAP_DETERMINACION D\n" +
"	on P.ENTIDADID = D.ENTIDADID and P.PERIODO = D.PERIODO and P.CARPETAID = D.CARPETAID \n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID,\n" +
"	count (CARPETAID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	from TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID\n" +
"	) SC\n" +
"	on D.ENTIDADID = SC.ENTIDADID and D.PERIODO = SC.PERIODO and D.CARPETAID = SC.CARPETAID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n" +
"	count (CARPETAID) AS TABLA_MASC \n" +
"	from TR_SENAP_MASC \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n" +
"	) MASC\n" +
"	on SC.ENTIDADID = MASC.ENTIDADID and SC.PERIODO = MASC.PERIODO and SC.CARPETAID = MASC.CARPETAID and SC.PROCESOID = MASC.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID,\n" +
"	count (CARPETAID) AS TABLA_SOBRESEIMIENTO \n" +
"	from TR_SENAP_SOBRESEIMIENTO \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID\n" +
"	) SB\n" +
"	on MASC.ENTIDADID = SB.ENTIDADID and MASC.PERIODO = SB.PERIODO and MASC.CARPETAID = SB.CARPETAID and MASC.PROCESOID = SB.PROCESOID\n" +
"where P.CATETAPAPROCESALID = 4\n" +
"and D.CATESTATUSCARPETAID = 1\n" +
"and (SC.TABLA_SUSPENSIONCONDICIONAL is not null\n" +
"	or MASC.TABLA_MASC is not null\n" +
"	or SB.TABLA_SOBRESEIMIENTO is not null) AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //ReglaNegocio 10.1. El campo Fecha de ingreso de la causa penal (columna F) debe ser mayor a la Fecha de apertura de la carpeta de investigación (columna X).
    public ArrayList FECHAINICIO(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.FECHAINICIO, CI.FECHACARINVE\n" +
"from TR_SENAP_PROCESO P\n" +
"left join TR_SENAP_CARPETAINVESTIGACION CI\n" +
"	on P.ENTIDADID = CI.ENTIDADID\n" +
"	and P.PERIODO = CI.PERIODO\n" +
"	and P.CARPETAID = CI.CARPETAID\n" +
"where P.FECHAINICIO <= CI.FECHACARINVE AND (P.FECHAINICIO<>'01/01/1900') and (CI.FECHACARINVE<>'01/01/1900') AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo ¿Hubo celebración de audiencia inicial? (columna G) es requisitado con la opción “Si” (1), entonces el campo Fecha de la audiencia inicial (columna I) debera ser requisitado. 
    public ArrayList HUBOCELEBRACIONAUDIENCIAINICIAL(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, HUBOCELEBRACIONAUDIENCIAINICIAL, FECHAAUDIENCIAINICIAL\n" +
"from TR_SENAP_PROCESO\n" +
"where HUBOCELEBRACIONAUDIENCIAINICIAL = 1\n" +
"and FECHAAUDIENCIAINICIAL is null AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo ¿Hubo celebración de audiencia inicial? (columna G) es requisitado con la opción "Sí" (1) debe permitir el registro de las plantillas Mandamientos judiciales e Investigación complementaria.
    public ArrayList HUBOCELEBRACIONAUDIENCIAINICIAL1(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.HUBOCELEBRACIONAUDIENCIAINICIAL, count(MJ.TABLA_MANDAMIENTOSJUDICIALES) AS INFO_EN_MANDAMIENTOSJUDICIALES, count(IC.TABLA_INVESTIGACIONCOMPLEMENTARIA) AS INFO_EN_INVESTIGACIONCOMPLEMENTARIA\n" +
"from TR_SENAP_PROCESO P\n" +
"left join(\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MANDAMIENTOJUDICIALID,\n" +
"	count (CARPETAID) AS TABLA_MANDAMIENTOSJUDICIALES \n" +
"	from TR_SENAP_MANDAMIENTOSJUDICIALES \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MANDAMIENTOJUDICIALID\n" +
"	) MJ\n" +
"	on P.ENTIDADID = MJ.ENTIDADID and P.PERIODO = MJ.PERIODO and P.CARPETAID = MJ.CARPETAID and P.PROCESOID = MJ.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID,\n" +
"	count (CARPETAID) AS TABLA_INVESTIGACIONCOMPLEMENTARIA \n" +
"	from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID\n" +
"	) IC\n" +
"	on P.ENTIDADID = IC.ENTIDADID and P.PERIODO = IC.PERIODO and P.CARPETAID = IC.CARPETAID and P.PROCESOID = IC.PROCESOID\n" +
"where P.HUBOCELEBRACIONAUDIENCIAINICIAL = 1\n" +
"and (MJ.TABLA_MANDAMIENTOSJUDICIALES is null\n" +
"	or IC.TABLA_INVESTIGACIONCOMPLEMENTARIA is null) AND (P.ENTIDADID='07' AND P.PERIODO='1-07-10/2024'  )\n" +
"    group by P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.HUBOCELEBRACIONAUDIENCIAINICIAL, MJ.TABLA_MANDAMIENTOSJUDICIALES, IC.TABLA_INVESTIGACIONCOMPLEMENTARIA";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo ¿Hubo celebración de audiencia inicial? (columna G) es requisitado con la opción "Sí" (1) no debe ser requistado el campo Motivo por el que no se celebró la audiencia inicial.
    public ArrayList CATMOTIVOAUDIENCIAINICIALID(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, HUBOCELEBRACIONAUDIENCIAINICIAL, CATMOTIVOAUDIENCIAINICIALID\n" +
"from TR_SENAP_PROCESO\n" +
"where HUBOCELEBRACIONAUDIENCIAINICIAL = 1\n" +
"and CATMOTIVOAUDIENCIAINICIALID is not null AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo ¿Hubo celebración de audiencia inicial? (columna G) es requisitado con la opción "No" (2) y el campo Motivo por el que no se celebró la audiencia inicial (columna H) es requistado, entonces los campos Fecha de la audiencia inicial (columna I) , Otro motivo, Identificador único UltimoEstatusProceso, Fecha ultimo estatus proceso, Identificador  EstatusProceso , ¿Se dictó suspensión condicional del proceso? (columna K) y ¿El asunto fue derivado a MASC? (columna J) no deberan ser requisitados.
    public ArrayList OTROMOTIVO(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, HUBOCELEBRACIONAUDIENCIAINICIAL, CATMOTIVOAUDIENCIAINICIALID, FECHAAUDIENCIAINICIAL, OTROMOTIVO,\n" +
"ULTIMOESTATUSPROCESOID, FECHAULTIMOESTATUSPROCESO, CATESTATUSCARPETAID, FECHACORTE, TIENESUSPENSIONCONDICIONAL, DERIVOMASC\n" +
"from TR_SENAP_PROCESO\n" +
"where HUBOCELEBRACIONAUDIENCIAINICIAL = 2\n" +
"and CATMOTIVOAUDIENCIAINICIALID is not null\n" +
"and (FECHAAUDIENCIAINICIAL is not null\n" +
"	or OTROMOTIVO is not null\n" +
"	or ULTIMOESTATUSPROCESOID is not null\n" +
"	or FECHAULTIMOESTATUSPROCESO is not null\n" +
"	or CATESTATUSCARPETAID is not null\n" +
"	or FECHACORTE is not null\n" +
"	or TIENESUSPENSIONCONDICIONAL is not null\n" +
"	or DERIVOMASC is not null) AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo ¿Hubo celebración de audiencia inicial? (columna G) es requisitado con la opcion "No" (2) entonces los campos Motivo por el que no se celebró la audiencia inicial (columna H) debe ser requisitado y el campo Fecha de la audiencia inicial (columna I) no debe ser requisitado.
    public ArrayList FECHAAUDIENCIAINICIAL(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, HUBOCELEBRACIONAUDIENCIAINICIAL, CATMOTIVOAUDIENCIAINICIALID, FECHAAUDIENCIAINICIAL\n" +
"from TR_SENAP_PROCESO\n" +
"where HUBOCELEBRACIONAUDIENCIAINICIAL = 2\n" +
"and CATMOTIVOAUDIENCIAINICIALID is null \n" +
"and FECHAAUDIENCIAINICIAL is not null AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Fecha de audiencia inicial (columna I) debe ser mayor o igual a la Fecha de ingreso de la causa penal (columna F).
    public ArrayList FECHAINICIO1(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, FECHAAUDIENCIAINICIAL, FECHAINICIO\n" +
"from TR_SENAP_PROCESO\n" +
"where FECHAAUDIENCIAINICIAL < FECHAINICIO AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo ¿El asunto fue derivado a MASC? (columna J) es requisitado con la opcion "Si" (1) debe ser requisitada la plantilla MASC.
    public ArrayList DERIVOMASC(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID,  P.DERIVOMASC, MASC.TABLA_MASC\n" +
"FROM TR_SENAP_PROCESO P\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	COUNT (PROCESOID) AS TABLA_MASC \n" +
"	FROM TR_SENAP_MASC \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, MASCID\n" +
"	) MASC \n" +
"on P.ENTIDADID = MASC.ENTIDADID\n" +
"and P.PERIODO = MASC.PERIODO\n" +
"and P.CARPETAID = MASC.CARPETAID\n" +
"and P.PROCESOID = MASC.PROCESOID\n" +
"WHERE P.DERIVOMASC = 1\n" +
"AND TABLA_MASC IS NULL AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo ¿Se dictó suspensión condicional del proceso? (columna K) es requisitado con la opcion "Si" (1) debe ser requisitada la plantilla Suspensión Condicional.
    public ArrayList TIENESUSPENSIONCONDICIONAL(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID,  P.TIENESUSPENSIONCONDICIONAL, SC.TABLA_SUSPENSIONCONDICIONAL\n" +
"FROM TR_SENAP_PROCESO P\n" +
"LEFT JOIN (\n" +
"	SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n" +
"	COUNT (IMPUTADOID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	FROM TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n" +
"	) SC \n" +
"on P.ENTIDADID = SC.ENTIDADID\n" +
"and P.PERIODO = SC.PERIODO\n" +
"and P.CARPETAID = SC.CARPETAID\n" +
"and P.PROCESOID = SC.PROCESOID\n" +
"WHERE P.TIENESUSPENSIONCONDICIONAL = 1\n" +
"AND TABLA_SUSPENSIONCONDICIONAL IS NULL AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Estatus de carpeta CATESTATUSCARPETAID es requisitado con la opción “No identificado” (9) no debe existir información en las plantillas MASC, Sobreseimiento, Suspension condicional y Semtencia.
    public ArrayList CATESTATUSCARPETAID2(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATESTATUSCARPETAID, MASC.TABLA_MASC, SB.TABLA_SOBRESEIMIENTO, SC.TABLA_SUSPENSIONCONDICIONAL, SEN.TABLA_SENTENCIA\n" +
"from TR_SENAP_PROCESO P\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n" +
"	count (IMPUTADOID) AS TABLA_MASC \n" +
"	from TR_SENAP_MASC \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n" +
"	) MASC\n" +
"	on P.ENTIDADID = MASC.ENTIDADID and P.PERIODO = MASC.PERIODO and P.CARPETAID = MASC.CARPETAID and P.PROCESOID = MASC.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID,\n" +
"	count (IMPUTADOID) AS TABLA_SOBRESEIMIENTO \n" +
"	from TR_SENAP_SOBRESEIMIENTO \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID\n" +
"	) SB\n" +
"	on MASC.ENTIDADID = SB.ENTIDADID and MASC.PERIODO = SB.PERIODO and MASC.CARPETAID = SB.CARPETAID and MASC.PROCESOID = SB.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID,\n" +
"	count (IMPUTADOID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	from TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID\n" +
"	) SC\n" +
"	on SB.ENTIDADID = SC.ENTIDADID and SB.PERIODO = SC.PERIODO and SB.CARPETAID = SC.CARPETAID and SB.PROCESOID = SC.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n" +
"	count (IMPUTADOID) AS TABLA_SENTENCIA \n" +
"	from TR_SENAP_SENTENCIA \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n" +
"	) SEN\n" +
"	on SC.ENTIDADID = SEN.ENTIDADID and SC.PERIODO = SEN.PERIODO and SC.CARPETAID = SEN.CARPETAID and SC.PROCESOID = SEN.PROCESOID\n" +
"where P.CATESTATUSCARPETAID = 9\n" +
"and (MASC.TABLA_MASC is not null\n" +
"	or SB.TABLA_SOBRESEIMIENTO is not null\n" +
"	or SC.TABLA_SUSPENSIONCONDICIONAL is not null\n" +
"	or SEN.TABLA_SENTENCIA is not null) AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Estatus de carpeta  es requisitado con la opción “Trámite” (2) para cualquier etapa del campo Etapa procesal en la que se encuentra la determinacion  no debe existir información en las plantillas MASC, Sobreseimiento, Suspensión condicional y Sentencia.
    public ArrayList CATESTATUSCARPETAID3(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select P.ENTIDADID, P.PERIODO, P.CARPETAID, P.IMPUTADOID, P.PROCESOID, P.CATESTATUSCARPETAID, P.CATETAPAPROCESALID, MASC.TABLA_MASC, SB.TABLA_SOBRESEIMIENTO, SC.TABLA_SUSPENSIONCONDICIONAL, SEN.TABLA_SENTENCIA\n" +
"from TR_SENAP_PROCESO P\n" +
"inner join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n" +
"	count (CARPETAID) AS TABLA_MASC \n" +
"	from TR_SENAP_MASC \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n" +
"	) MASC\n" +
"	on P.ENTIDADID = MASC.ENTIDADID and P.PERIODO = MASC.PERIODO and P.CARPETAID = MASC.CARPETAID and P.PROCESOID = MASC.PROCESOID\n" +
"inner join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID,\n" +
"	count (CARPETAID) AS TABLA_SOBRESEIMIENTO \n" +
"	from TR_SENAP_SOBRESEIMIENTO \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID\n" +
"	) SB\n" +
"	on MASC.ENTIDADID = SB.ENTIDADID and MASC.PERIODO = SB.PERIODO and MASC.CARPETAID = SB.CARPETAID and MASC.PROCESOID = SB.PROCESOID\n" +
"inner join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID,\n" +
"	count (CARPETAID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	from TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID\n" +
"	) SC\n" +
"	on SB.ENTIDADID = SC.ENTIDADID and SB.PERIODO = SC.PERIODO and SB.CARPETAID = SC.CARPETAID and SB.PROCESOID = SC.PROCESOID\n" +
"inner join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	count (PROCESOID) AS TABLA_SENTENCIA \n" +
"	from TR_SENAP_SENTENCIA \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID\n" +
"	) SEN\n" +
"	on SC.ENTIDADID = SEN.ENTIDADID and SC.PERIODO = SEN.PERIODO and SC.CARPETAID = SEN.CARPETAID and SC.PROCESOID = SEN.PROCESOID\n" +
"where P.CATESTATUSCARPETAID = 2\n" +
"and P.CATETAPAPROCESALID in (1,2,3,4)\n" +
"and (MASC.TABLA_MASC is not null\n" +
"	or SB.TABLA_SOBRESEIMIENTO is not null\n" +
"	or SC.TABLA_SUSPENSIONCONDICIONAL is not null\n" +
"	or SEN.TABLA_SENTENCIA is not null) AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo  Estatus de la carpeta  es requisitado con el valor “Concluido”, en la etapa de investigación inicial, debe existir información en alguna de las siguientes plantillas MASC o Sobreseimiento.
    public ArrayList CATESTATUSCARPETAID4(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select p.ENTIDADID,p.PROCESOID,p.CARPETAID,p.IMPUTADOID,p.PERIODO,p.CATESTATUSCARPETAID,p.CATETAPAPROCESALID,\n" +
"masc.num_reg as num_reg_masc,s.num_reg as num_reg_s from tr_senap_proceso p \n" +
" left join (select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO,case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"from (select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO,count (PERIODO) as num_reg\n" +
"from tr_senap_masc group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO\n" +
") ) masc on masc.ENTIDADID=p.ENTIDADID and masc.CARPETAID=p.CARPETAID and masc.PROCESOID=p.PROCESOID and masc.PERIODO=p.PERIODO\n" +
"left join (select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO, case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"from (select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,count (PERIODO) as num_reg\n" +
"from tr_senap_sobreseimiento group by ENTIDADID,\n" +
"CARPETAID,IMPUTADOID,PROCESOID,PERIODO\n" +
"))s on s.ENTIDADID=p.ENTIDADID and s.CARPETAID=p.CARPETAID and s.PROCESOID=p.PROCESOID and s.PERIODO=p.PERIODO where p.CATESTATUSCARPETAID=1 and p.CATETAPAPROCESALID=1 AND (P.ENTIDADID='"+Entidad+"' AND P.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //Si el campo Estatus del proceso  es requisitado con el valor “Concluido”, en la etapa de investigación complementaria, se deberá verificar que exista información en alguna de las siguientes plantillas. MASC, Suspensión condicional o Sobreseimiento 
    public ArrayList CATESTATUSCARPETAID5(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (\n" +
"select p.ENTIDADID,p.PROCESOID,p.CARPETAID,p.IMPUTADOID,p.PERIODO,p.CATESTATUSCARPETAID,p.CATETAPAPROCESALID,\n" +
"masc.num_reg as num_reg_masc,s.num_reg as num_reg_s , sc.num_reg as num_reg_sc, masc.num_reg+s.num_reg+sc.num_reg as suma\n" +
"from tr_senap_proceso p \n" +
"  left join (\n" +
"    select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO,\n" +
"      case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"    from (\n" +
"      select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO,count (PERIODO) as num_reg\n" +
"      from tr_senap_masc group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO)) masc \n" +
"      on masc.ENTIDADID=p.ENTIDADID and masc.CARPETAID=p.CARPETAID and masc.PROCESOID=p.PROCESOID and masc.PERIODO=p.PERIODO\n" +
"left join (\n" +
"  select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO, case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"  from (\n" +
"    select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,count (PERIODO) as num_reg\n" +
"    from tr_senap_sobreseimiento \n" +
"    group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO))s \n" +
"    on s.ENTIDADID=p.ENTIDADID and s.CARPETAID=p.CARPETAID and s.PROCESOID=p.PROCESOID and s.PERIODO=p.PERIODO\n" +
"left join (\n" +
"  select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO, case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"  from (\n" +
"    select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,count (PERIODO) as num_reg\n" +
"    from tr_senap_suspensioncondicional \n" +
"    group by ENTIDADID, CARPETAID,IMPUTADOID,PROCESOID,PERIODO))sc \n" +
"    on sc.ENTIDADID=p.ENTIDADID and sc.CARPETAID=p.CARPETAID and sc.PROCESOID=p.PROCESOID and sc.PERIODO=p.PERIODO\n" +
"where p.CATESTATUSCARPETAID=1 and p.CATETAPAPROCESALID=2) where suma>1 AND (ENTIDADID='01' AND PERIODO='ENE/24')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //Si el campo Estatus del proceso  es requisitado con el valor “Concluido”, en la etapa intermedia, se deberá verificar que exista información en alguna de las siguientes plantillas: MASC, Suspensión condicional, Sobreseimiento o Sentencia.
    public ArrayList CATESTATUSCARPETAID6(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (\n" +
"select p.ENTIDADID,p.PROCESOID,p.CARPETAID,p.IMPUTADOID,p.PERIODO,p.CATESTATUSCARPETAID,p.CATETAPAPROCESALID,\n" +
"masc.num_reg as num_reg_masc,s.num_reg as num_reg_s , sc.num_reg as num_reg_sc,sen.num_reg as num_reg_sen, sen.num_reg+masc.num_reg+s.num_reg+sc.num_reg as suma\n" +
"from tr_senap_proceso p \n" +
" left join (select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO,case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"from (select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO,count (PERIODO) as num_reg\n" +
"from tr_senap_masc group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO\n" +
") ) masc on masc.ENTIDADID=p.ENTIDADID and masc.CARPETAID=p.CARPETAID and masc.PROCESOID=p.PROCESOID and masc.PERIODO=p.PERIODO\n" +
"\n" +
"left join (select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO, case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"from (select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,count (PERIODO) as num_reg\n" +
"from tr_senap_sobreseimiento group by ENTIDADID,\n" +
"CARPETAID,IMPUTADOID,PROCESOID,PERIODO\n" +
"))s on s.ENTIDADID=p.ENTIDADID and s.CARPETAID=p.CARPETAID and s.PROCESOID=p.PROCESOID and s.PERIODO=p.PERIODO\n" +
"left join (\n" +
"select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO, case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"from (\n" +
"	select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,count (PERIODO) as num_reg\n" +
"from tr_senap_suspensioncondicional group by ENTIDADID,\n" +
"CARPETAID,IMPUTADOID,PROCESOID,PERIODO\n" +
"))sc on sc.ENTIDADID=p.ENTIDADID and sc.CARPETAID=p.CARPETAID and sc.PROCESOID=p.PROCESOID and sc.PERIODO=p.PERIODO\n" +
"left join (\n" +
"select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO, case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"from (\n" +
"	select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,count (PERIODO) as num_reg\n" +
"from tr_senap_sentencia group by ENTIDADID,\n" +
"CARPETAID,IMPUTADOID,PROCESOID,PERIODO\n" +
"))sen on sen.ENTIDADID=p.ENTIDADID and sen.CARPETAID=p.CARPETAID and sen.PROCESOID=p.PROCESOID and sen.PERIODO=p.PERIODO\n" +
"where p.CATESTATUSCARPETAID=1 and p.CATETAPAPROCESALID=3) where suma>1 AND (ENTIDADID='01' AND PERIODO='ENE/24')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //Si el campo Estatus del proceso  es requisitado con el valor “Concluido”, en la etapa de juicio, se deberá verificar que exista información en alguna de las siguientes plantillas: Sobreseimiento o Sentencia.
    public ArrayList CATESTATUSCARPETAID7(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select * from (\n" +
"select p.ENTIDADID,p.PROCESOID,p.CARPETAID,p.IMPUTADOID,p.PERIODO,p.CATESTATUSCARPETAID,p.CATETAPAPROCESALID,\n" +
"s.num_reg as num_reg_s , sen.num_reg as num_reg_sen, sen.num_reg+s.num_reg as suma\n" +
"from tr_senap_proceso p \n" +
"left join (select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO, case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"from (select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,count (PERIODO) as num_reg\n" +
"from tr_senap_sobreseimiento group by ENTIDADID,\n" +
"CARPETAID,IMPUTADOID,PROCESOID,PERIODO\n" +
"))s on s.ENTIDADID=p.ENTIDADID and s.CARPETAID=p.CARPETAID and s.PROCESOID=p.PROCESOID and s.PERIODO=p.PERIODO\n" +
"left join (\n" +
"select ENTIDADID,CARPETAID,PROCESOID,IMPUTADOID,PERIODO, case when num_reg is null then 0 else num_Reg end as num_reg\n" +
"from (\n" +
"	select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,count (PERIODO) as num_reg\n" +
"from tr_senap_sentencia group by ENTIDADID,\n" +
"CARPETAID,IMPUTADOID,PROCESOID,PERIODO\n" +
"))sen on sen.ENTIDADID=p.ENTIDADID and sen.CARPETAID=p.CARPETAID and sen.PROCESOID=p.PROCESOID and sen.PERIODO=p.PERIODO\n" +
" where p.CATESTATUSCARPETAID=1 and p.CATETAPAPROCESALID=4) where suma>1 AND (ENTIDADID='01' AND PERIODO='ENE/24')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("PROCESOID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
    
}