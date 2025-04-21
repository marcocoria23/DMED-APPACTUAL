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
public class VMASC {
    ConOracle conexion=new ConOracle();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
     public static String Query="";
    
    
    
    
     //La FECHADERIVAMASC (Fecha en que se deriva a MASC) No debe de ser mayor a la fecha actual.
     public ArrayList FECHADERIVAMASCMayor(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ENTIDADID,MASCID,IMPUTADOID,PERIODO\n" +
"FROM TR_SENAP_MASC\n" +
"WHERE FECHADERIVAMASC > SYSDATE AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
      //La FECHACUMPLIMENTOMASC (Fecha en que se cumplimentó el MASC) No debe de ser mayor a la fecha actual.
     public ArrayList FECHACUMPLIMENTOMASCMayor(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ENTIDADID,MASCID,IMPUTADOID,PERIODO\n" +
"FROM TR_SENAP_MASC\n" +
"WHERE FECHACUMPLIMENTOMASC > SYSDATE AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
    //ReglaNegocio 15.3. La tabla TR_SENAP_MASC es requisitada, las plantillas Sobreseimiento, Suspensión condicional y Sentencia no deben ser requisitadas.
    public ArrayList TABLA_MASC(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select MASC.ENTIDADID, MASC.PERIODO, MASC.CARPETAID, MASC.IMPUTADOID, MASC.PROCESOID, MASC.MASCID, MASC.TABLA_MASC, SC.TABLA_SUSPENSIONCONDICIONAL, SB.TABLA_SOBRESEIMIENTO, S.TABLA_SENTENCIA\n" +
"from (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n" +
"	count (PROCESOID) AS TABLA_MASC \n" +
"	from TR_SENAP_MASC \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n" +
"	) MASC\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID,\n" +
"	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	from TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID\n" +
"	) SC\n" +
"		on MASC.PERIODO = SC.PERIODO and MASC.ENTIDADID = SC.ENTIDADID and MASC.CARPETAID = SC.CARPETAID and MASC.PROCESOID = SC.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID,\n" +
"	count (PROCESOID) AS TABLA_SOBRESEIMIENTO \n" +
"	from TR_SENAP_SOBRESEIMIENTO \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID\n" +
"	) SB\n" +
"	on SC.PERIODO = SB.PERIODO and SC.ENTIDADID = SB.ENTIDADID and SC.CARPETAID = SB.CARPETAID and SC.PROCESOID = SB.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	count (PROCESOID) AS TABLA_SENTENCIA \n" +
"	from TR_SENAP_SENTENCIA \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID\n" +
"	) S\n" +
"	on SB.PERIODO = S.PERIODO and SB.ENTIDADID = S.ENTIDADID and SB.CARPETAID = S.CARPETAID and SB.PROCESOID = S.PROCESOID\n" +
"where MASC.TABLA_MASC is not null\n" +
"and (SC.TABLA_SUSPENSIONCONDICIONAL is not null\n" +
"	or SB.TABLA_SOBRESEIMIENTO is not null\n" +
"	or S.TABLA_SENTENCIA is not null) AND (MASC.ENTIDADID='"+Entidad+"' AND MASC.PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VMASC.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //ReglaNegocio 15.4. El campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna H) es requisitada, no debe ser requisitada la plantilla MASC. 
    public ArrayList FECHACUMPSUSPENCONDIPROCESO(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select MASC.ENTIDADID, MASC.PERIODO, MASC.CARPETAID, MASC.IMPUTADOID, MASC.PROCESOID, MASC.MASCID, MASC.TABLA_MASC, SC.FECHACUMPSUSPENCONDIPROCESO\n" +
"from (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n" +
"	count (PROCESOID) AS TABLA_MASC \n" +
"	from TR_SENAP_MASC \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n" +
"	) MASC\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO,\n" +
"	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	from TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO\n" +
"	) SC\n" +
"		on MASC.PERIODO = SC.PERIODO and MASC.ENTIDADID = SC.ENTIDADID and MASC.CARPETAID = SC.CARPETAID and MASC.PROCESOID = SC.PROCESOID\n" +
"where SC.FECHACUMPSUSPENCONDIPROCESO is not null \n" +
"	and MASC.TABLA_MASC is not null AND (MASC.ENTIDADID='"+Entidad+"' AND MASC.PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VMASC.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //ReglaNegocio 15.4. El campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna H) no es requisitada, debe ser requisitada la plantilla MASC. 
    public ArrayList FECHACUMPSUSPENCONDIPROCESO1(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select MASC.ENTIDADID, MASC.PERIODO, MASC.CARPETAID, MASC.IMPUTADOID, MASC.PROCESOID, MASC.MASCID, MASC.TABLA_MASC, SC.FECHACUMPSUSPENCONDIPROCESO\n" +
"from (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n" +
"	count (PROCESOID) AS TABLA_MASC \n" +
"	from TR_SENAP_MASC \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n" +
"	) MASC\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO,\n" +
"	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	from TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO\n" +
"	) SC\n" +
"		on MASC.PERIODO = SC.PERIODO and MASC.ENTIDADID = SC.ENTIDADID and MASC.CARPETAID = SC.CARPETAID and MASC.PROCESOID = SC.PROCESOID\n" +
"where SC.FECHACUMPSUSPENCONDIPROCESO is null \n" +
"	and MASC.TABLA_MASC is null AND (MASC.ENTIDADID='"+Entidad+"' AND MASC.PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VMASC.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //ReglaNegocio 15.5. El campo Etapa procesal en la que se encuentra el imputado de la plantilla Proceso tiene el valor “Etapa intermedia” (3), el campo ¿Se dictó auto de apertura a juicio oral? (columna K) de la plantilla Etapa intermedia sea “No” (2) y el campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna H) es requisitada, entonces la plantilla MASC deberá ser requisitada y las plantillas Suspensión condicional, Sobreseimiento y Sentencia no deberán ser requisitadas.
    public ArrayList CATETAPAPROCESALID(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select MASC.ENTIDADID, MASC.PERIODO, MASC.CARPETAID, MASC.IMPUTADOID, MASC.PROCESOID, MASC.MASCID, P.CATETAPAPROCESALID, EI.DICTAUTAPERJUICIO, SC.FECHACUMPSUSPENCONDIPROCESO, MASC.TABLA_MASC, SC.TABLA_SUSPENSIONCONDICIONAL, SB.TABLA_SOBRESEIMIENTO, S.TABLA_SENTENCIA\n" +
"from (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID, \n" +
"	count (PROCESOID) AS TABLA_MASC \n" +
"	from TR_SENAP_MASC \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID \n" +
"	) MASC \n" +
"left join ( \n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO,\n" +
"	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n" +
"	from TR_SENAP_SUSPENSIONCONDICIONAL \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO\n" +
"	) SC\n" +
"		on MASC.PERIODO = SC.PERIODO and MASC.ENTIDADID = SC.ENTIDADID and MASC.CARPETAID = SC.CARPETAID and MASC.PROCESOID = SC.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID,\n" +
"	count (PROCESOID) AS TABLA_SOBRESEIMIENTO \n" +
"	from TR_SENAP_SOBRESEIMIENTO \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID\n" +
"	) SB\n" +
"		on SC.PERIODO = SB.PERIODO and SC.ENTIDADID = SB.ENTIDADID and SC.CARPETAID = SB.CARPETAID and SC.PROCESOID = SB.PROCESOID\n" +
"left join (\n" +
"	select ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n" +
"	count (PROCESOID) AS TABLA_SENTENCIA \n" +
"	from TR_SENAP_SENTENCIA \n" +
"	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID\n" +
"	) S\n" +
"	on SB.PERIODO = S.PERIODO and SB.ENTIDADID = S.ENTIDADID and SB.CARPETAID = S.CARPETAID and SB.PROCESOID = S.PROCESOID\n" +
"left join TR_SENAP_ETAPAINTERMEDIA EI\n" +
"	on S.PERIODO = EI.PERIODO and S.ENTIDADID = EI.ENTIDADID and S.CARPETAID = EI.CARPETAID and S.PROCESOID = EI.PROCESOID\n" +
"left join TR_SENAP_PROCESO P\n" +
"	on EI.PERIODO = P.PERIODO and EI.ENTIDADID = P.ENTIDADID and EI.CARPETAID = P.CARPETAID and EI.PROCESOID = P.PROCESOID\n" +
"where P.CATETAPAPROCESALID = 3\n" +
"and EI.DICTAUTAPERJUICIO = 2\n" +
"and SC.FECHACUMPSUSPENCONDIPROCESO is not null \n" +
"and (MASC.TABLA_MASC is null \n" +
"	OR SC.TABLA_SUSPENSIONCONDICIONAL is not null \n" +
"	OR SB.TABLA_SOBRESEIMIENTO is not null\n" +
"	OR S.TABLA_SENTENCIA is not null) AND (MASC.ENTIDADID='"+Entidad+"' AND MASC.PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VMASC.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Tipo de cumplimiento (columna G) es requisitado, entonces el campo Fecha en la que se cumplimentó el MASC (columna H) debe ser requisitado. 
    public ArrayList CATTIPOCUMPLIMIENTOID(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID, CATTIPOCUMPLIMIENTOID, FECHACUMPLIMENTOMASC\n" +
"from TR_SENAP_MASC\n" +
"where CATTIPOCUMPLIMIENTOID is not null\n" +
"and FECHACUMPLIMENTOMASC is null AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VMASC.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Tipo de cumplimiento (columna G) no es requisitado, entonces el campo Fecha en la que se cumplimentó el MASC (columna H) no debe ser requisitado. 
    public ArrayList FECHACUMPLIMENTOMASC(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID, CATTIPOCUMPLIMIENTOID, FECHACUMPLIMENTOMASC\n" +
"from TR_SENAP_MASC\n" +
"where CATTIPOCUMPLIMIENTOID is null\n" +
"and FECHACUMPLIMENTOMASC is not null AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VMASC.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //El campo Fecha en la que se cumplimentó el MASC (columna H) debera ser mayor al campo Fecha en que se deriva el MASC (columna E).
    public ArrayList FECHADERIVAMASC(String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID, FECHACUMPLIMENTOMASC, FECHADERIVAMASC\n" +
"from TR_SENAP_MASC\n" +
"where FECHACUMPLIMENTOMASC <= FECHADERIVAMASC AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"')";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("MASCID"),
                  resul.getString("IMPUTADOID")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VMASC.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
}