/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesSENAP;

import Pantallas_SENAP.IntegraTMP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.SENAP.ConOracle;

/**
 *
 * @author LAURA.MEDINAJ
 */

//VALIDACIONES DE LA TALA DELITOS
public class VDelitos { 
    ConOracle conexion=new ConOracle();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    public static String Query="";

    
    
     //ReglaNegocio Adicional: La relación entre los campos  CatEntidadFederativaID (Entidad) y CATMUNICIPIOID (Municipio) de la plantilla Delitos, no coinciden con la relación de los campos CATENTIDADFEDERATIVAID y CATMUNICIPIODEMARCACIONTERRITORIALID del catálogo SENAP_MUNICIPIODEMARCACIONTERRITOR
public ArrayList RelacionMunicipio(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (\n" +
"select UBICACIONID,CATDEMARCACIONID, CATENTFEDID,CATSUBPROREFID, tc.CATMUNICIPIODEMARCACIONTERRITORIALID as catalogo, ub.periodo, ub.ENTIDADID from tr_senap_direccionubicacion ub\n" +
"left join TC_SENAP_MUNICIPIODEMARCACIONTERRITOR tc on tc.CATMUNICIPIODEMARCACIONTERRITORIALID=ub.CATDEMARCACIONID and tc.catentidadfederativaid=ub.CATENTFEDID)\n" +
"where catalogo is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "') and  CATSUBPROREFID=2";
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
    
    //ReglaNegocio GENERAL. La FECHAOCURRENCIA(Fecha de ocurrencia (exacta/aproximada/continua))  no debe ser mayor a la fecha actual
public ArrayList FechaOcurrMayor (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ENTIDADID,DELITOID,PERIODO\n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE FECHAOCURRENCIA > SYSDATE and (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

   //La FECHARECLASIFICACION(Fecha de la reclasificación)  no debe ser mayor a la fecha actual
public ArrayList FechaReclasificacionMayor (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ENTIDADID,DELITOID,PERIODO\n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE FECHARECLASIFICACION > SYSDATE and (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
//-----campo:FechaOcurrencia ----------------***
//ReglaNegocio 4.1. El valor del campo Fecha de ocurrencia (exacta/aproximada/continua) (columna G) deberá ser menor o igual al campo Fecha de presentación de la denuncia o querella (columna U) de la plantilla Noticia criminal 
public ArrayList FechaOcurr_Presenta (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select \n" +
" DELI.entidadid,\n" +
" DELI.PERIODO,\n" +
" DELI.delitoid,\n" +
" DELI.CARPETAID,\n" +
" DELI.FECHAOCURRENCIA,\n" +
" nc.FECHAPRESDENUNQUERELLA\n" +
" \n" +
" from tr_senap_delitos deli left join\n" +
" TR_SENAP_noticiacriminal nc \n" +
" on DELI.entidadid=nc.entidadid and DELI.PERIODO=nc.PERIODO and DELI.CARPETAID=nc.CARPETAID\n" +
" where DELI.FECHAOCURRENCIA>  nc.FECHAPRESDENUNQUERELLA AND (DELI.FECHAOCURRENCIA<>'01/01/1900') and (nc.FECHAPRESDENUNQUERELLA<>'01/01/1900') and (DELI.ENTIDADID='"+Entidad+"' AND DELI.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//ReglaNegocio 4.1. Si no existe noticia criminal entonces esta fecha deberá ser menor o igual al campo Fecha de apertura de la carpeta de investigación (campo X) de la plantilla Carpeta de investigación.
public ArrayList FechaOcurr_Apertura (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select \n" +
" DELI.entidadid,\n" +
" DELI.PERIODO,\n" +
" DELI.delitoid,\n" +
" DELI.CARPETAID,\n" +
" DELI.FECHAOCURRENCIA,\n" +
" nc.FECHAPRESDENUNQUERELLA\n" +
" \n" +
" from tr_senap_delitos deli left join\n" +
" TR_SENAP_noticiacriminal nc \n" +
" on DELI.entidadid=nc.entidadid and DELI.PERIODO=nc.PERIODO and DELI.CARPETAID=nc.CARPETAID\n" +
" inner join tr_senap_carpetainvestigacion ci \n" +
" on ci.entidadid=nc.entidadid and ci.PERIODO=nc.PERIODO and ci.CARPETAID=nc.CARPETAID\n" +
" where nc.FECHAPRESDENUNQUERELLA is null and \n" +
" ci.FECHACARINVE >  nc.FECHAPRESDENUNQUERELLA AND (ci.FECHACARINVE<>'01/01/1900') and (nc.FECHAPRESDENUNQUERELLA<>'01/01/1900') AND (DELI.ENTIDADID='"+Entidad+"' AND DELI.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//-----campo:     HoraOcurrencia ----------------***
//El valor del campo Hora de ocurrencia (exacta/aproximada/continua) (columna H) deberá ser menor o igual al campo Hora de presentación de la denuncia o querella (columna V) de la plantilla Noticia Criminal
public ArrayList HoraOcurr_Presenta (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select \n" +
" DELI.entidadid,\n" +
" DELI.PERIODO,\n" +
" DELI.delitoid,\n" +
" DELI.CARPETAID,\n" +
" DELI.FECHAOCURRENCIA,\n" +
" deli.HORAOCURRENCIA,\n" +
" nc.FECHAPRESDENUNQUERELLA,\n" +
" nc.HORAREPREDENUNQUERELLA\n" +
" \n" +
" from tr_senap_delitos deli left join\n" +
" TR_SENAP_noticiacriminal nc \n" +
" on DELI.entidadid=nc.entidadid and DELI.PERIODO=nc.PERIODO and DELI.CARPETAID=nc.CARPETAID\n" +
"where deli.FECHAOCURRENCIA=nc.FECHAPRESDENUNQUERELLA and \n" +
" deli.HORAOCURRENCIA> nc.HORAREPREDENUNQUERELLA AND (DELI.ENTIDADID='"+Entidad+"' AND DELI.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//En el caso de no existir noticia criminal para la carpeta de investigación en cuestión, el campo Hora de ocurrencia del delito (columna H), deberá ser menor o igual al campo Hora de apertura de la carpeta de investigación (columna Y) de la plantilla Carpeta de investigación
public ArrayList HoraOcurr_Apertura (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql=" select \n" +
" DELI.entidadid,\n" +
" DELI.PERIODO,\n" +
" DELI.delitoid,\n" +
" DELI.CARPETAID,\n" +
" DELI.FECHAOCURRENCIA,\n" +
" deli.HORAOCURRENCIA,\n" +
"ci.FECHACARINVE,\n" +
" ci.HORAPECARINVE\n" +
" \n" +
" from tr_senap_delitos deli left join\n" +
" TR_SENAP_noticiacriminal nc \n" +
" on DELI.entidadid=nc.entidadid and DELI.PERIODO=nc.PERIODO and DELI.CARPETAID=nc.CARPETAID\n" +
" inner join tr_senap_carpetainvestigacion ci \n" +
" on ci.entidadid=nc.entidadid and ci.PERIODO=nc.PERIODO and ci.CARPETAID=nc.CARPETAID\n" +
" \n" +
" where nc.FECHAPRESDENUNQUERELLA is null and \n" +
" deli.FECHAOCURRENCIA=ci.fechacarinve and  deli.HORAOCURRENCIA>ci.HORAPECARINVE AND (DELI.ENTIDADID='"+Entidad+"' AND DELI.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//-----campo:     HuboReclasificacion  ----------------***
//En caso de que el campo ¿Hubo reclasificación del delito? (columna AC) sea requisitado con la opción “Si”, el campo Momento en el que se llevó a cabo la reclasificación (columna AD), Fecha de la reclasificación (columna AE) y DelitoID_Reclasificado (columna AF) no podrán estar vacías.
public ArrayList HuboReclasificacion_si (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  DELI.entidadid,  DELI.PERIODO,  DELI.delitoid,  DELI.CARPETAID,  DELI.HUBORECLASIFICACION, deli.fechareclasificacion, deli.DELITOID_RECLASIFICADO  \n" +
"from tr_senap_delitos deli   \n" +
"where DELI.HUBORECLASIFICACION=1 \n" +
" and(deli.fechareclasificacion is null or deli.DELITOID_RECLASIFICADO is null) AND  \n" +
              "(DELI.ENTIDADID='"+Entidad+"' AND DELI.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//El campo Fecha de la reclasificación (columna AE) deberá ser mayor al campo Fecha de ocurrencia (exacta/aproximada/continua) del delito que fue reclasificado (columna G).
public ArrayList HuboReclasificacion_Fecha (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select DELI.entidadid,  DELI.PERIODO, DELI.delitoid,  DELI.CARPETAID, DELI.HUBORECLASIFICACION,  deli.fechareclasificacion,  deli.FECHAOCURRENCIA\n" +
"from tr_senap_delitos deli\n" +
"where DELI.HUBORECLASIFICACION=1 and deli.fechareclasificacion<deli.FECHAOCURRENCIA AND (DELI.ENTIDADID='"+Entidad+"' AND DELI.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Si el campo ¿Hubo reclasificación del delito? (columna AC) es requisitado con la opción “Si”, entonces el campo DelitoID_Reclasificado (columna AF) deberá existir en algún reglón de la misma plantilla
        public ArrayList HuboReclasificacion_DelitoReclas (String Entidad,String Periodo) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select DELI.entidadid, DELI.PERIODO,  DELI.delitoid,\n" +
" DELI.CARPETAID, DELI.HUBORECLASIFICACION,  deli.fechareclasificacion, deli.DELITOID_RECLASIFICADO, x.DELITOID as reclasificado\n" +
" from tr_senap_delitos deli left join tr_senap_delitos x on  x.DELITOID_RECLASIFICADO=deli.DELITOID\n" +
"  where deli.DELITOID_RECLASIFICADO is not null and DELI.HUBORECLASIFICACION=1 and  x.DELITOID is null AND (DELI.ENTIDADID='"+Entidad+"' AND DELI.PERIODO='"+Periodo+"'  )";
      System.out.println(sql);
      Query=sql;
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("delitoid")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
        
       
 
 //Favor de especificar mas a detalle el Señalamiento normativo (artículo, fracción, párrafo, inciso, etc.) ya que no coincide con la variable Delito/Descripción del mapeo de Delitos o en su caso el articulo mencionado no existe dentro del mapeo.


//ReglaNegocio Adicional El Delito de acuerdo con la Norma Técnica (INEGI) no corresponde a Señalamiento normativo (artículo, fracción, párrafo, inciso, etc.)
 //ReglaNegocio Adicional variable SENALAMIENTONORMATIVO- señalamiento Normativo(artículo, fracción, párrafo, inciso, etc.) no coincide con el mapeo del catalogo de Delitos Norma tecnica INEGI  
 public ArrayList DELITONOENCO122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT UNIQUE(DELITOID) FROM (\n" +
"SELECT  \n" +
"    P.ENTIDADID,\n" +
"    P.DELITOID,\n" +
"    P.CATDELITONORMATECNICAID,\n" +
"    P.PERIODO,\n" +
"    P.SENALAMIENTONORMATIVO,\n" +
"    S.DELITO_DESCRIPCION,\n" +
"    P.CATDELITONORMATECNICAID AS DELITONORMATECNICA,\n" +
"    S.CATDELITONORMATECNICAID AS DELITONORMATECNICARELACION\n" +
"FROM TR_SENAP_DELITOS P\n" +
"LEFT JOIN TC_SENAP_RELACIONDELITOS S\n" +
"ON P.ENTIDADID = S.ENTIDADID\n" +
"   AND REGEXP_SUBSTR(UPPER(P.SENALAMIENTONORMATIVO), '\\d+') = REGEXP_SUBSTR(UPPER(S.DELITO_DESCRIPCION), '\\d+'))\n" +
"   WHERE DELITONORMATECNICARELACION IS NOT NULL AND DELITONORMATECNICA<>DELITONORMATECNICARELACION"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
 
//ReglaNegocio Adicional Favor de especificar mas a detalle el Señalamiento normativo (artículo, fracción, párrafo, inciso, etc.) ya que no coincide con la variable Delito/Descripción del mapeo de Delitos o en su caso el articulo mencionado no existe dentro del mapeo.
    public ArrayList DELITONE122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n" +
"SELECT  \n" +
"    P.ENTIDADID,\n" +
"    P.DELITOID,\n" +
"    P.CATDELITONORMATECNICAID,\n" +
"    P.PERIODO,\n" +
"    P.SENALAMIENTONORMATIVO,\n" +
"    S.DELITO_DESCRIPCION,\n" +
"    P.CATDELITONORMATECNICAID AS DELITONORMATECNICA,\n" +
"    S.CATDELITONORMATECNICAID AS DELITONORMATECNICARELACION\n" +
"FROM TR_SENAP_DELITOS P\n" +
"LEFT JOIN TC_SENAP_RELACIONDELITOS S\n" +
"ON P.ENTIDADID = S.ENTIDADID\n" +
"   AND REGEXP_SUBSTR(UPPER(P.SENALAMIENTONORMATIVO), '\\d+') = REGEXP_SUBSTR(UPPER(S.DELITO_DESCRIPCION), '\\d+'))\n" +
"   WHERE DELITONORMATECNICARELACION IS  NULL"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

 //ReglaNegocio Adicional DELITOID No es unico por entidadid se recomienda  concatenar ENTIDADID + DELITOID.
    public ArrayList DELITOID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DELITOID FROM(\n" +
"SELECT COUNT(DELITOID)CUENTA,DELITOID FROM TR_SENAP_DELITOS\n" +
"GROUP BY DELITOID) WHERE CUENTA>1";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

 
 //ReglaNegocio Adicional Favor de asignar un Delito valido en variable DELITOLEYPENAL -Delito de acuerdo con la ley penal ya que el valor es igual a 0.
    public ArrayList DELITOLEYPENAL122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,DELITOID,DELITOLEYPENAL,CATDELITONORMATECNICAID \n" +
"FROM TR_SENAP_DELITOS WHERE DELITOLEYPENAL=0"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

//ReglaNegocio Adicional Favor de verificar variable FECHAOCURRENCIA-Fecha de ocurrencia (exacta/aproximada/continua)  ya que la variable es de prioridad 1 y no puede venir null
    public ArrayList FECHAOCURRENCIA122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DELITOID,FECHAOCURRENCIA \n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE  FECHAOCURRENCIA is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

//ReglaNegocio Adicional Favor de verificar variable CATGRADOCONSUMACIONID-Grado de consumación  ya que la variable es de prioridad 1 y no puede venir 0 Sin referencia
    public ArrayList CATGRADOCONSUMACIONID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DELITOID,CATGRADOCONSUMACIONID \n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE  CATGRADOCONSUMACIONID =0"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

	
 //ReglaNegocio Adicional Favor de verificar variable CATCALIFICACIONDELITOID-Calificación del delito  ya que la variable es de prioridad 1 y no puede venir 0 Sin referencia O 4 Sin Dato
    public ArrayList CATCALIFICACIONDELITOID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DELITOID,CATGRADOCONSUMACIONID \n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE  CATGRADOCONSUMACIONID in (0,8)"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

 //ReglaNegocio Adicional Favor de verificar variable CATFORMAACCIONID-Forma de acción  ya que la variable es de prioridad 1 y no puede venir 0 Sin referencia
    public ArrayList CATFORMAACCIONID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DELITOID,CATFORMAACCIONID \n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE  CATFORMAACCIONID in (0)"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 


//Regla Adicional Favor de verificar variable CATINSTRUMENTOSCOMISIONID-Instrumentos para la comisión la variable es de prioridad 1 y no puede venir 0 Sin referencia
    public ArrayList CATINSTRUMENTOSCOMISIONID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DELITOID,CATINSTRUMENTOSCOMISIONID \n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE  CATINSTRUMENTOSCOMISIONID in (0)"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 
    
	
//Regla Adicional Favor de verificar el Variable Delito de acuerdo con la ley penal DELITOLEYPENAL debido a que no puede venir nulo.
    public ArrayList DLP122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, DELITOID, DELITOLEYPENAL\n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE DELITOLEYPENAL IS NULL"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

//Regla Adicional Favor de verificar el campo Señalamiento normativo (artículo, fracción, párrafo, inciso, etc.) SENALAMIENTONORMATIVO debido a que no puede venir nulo.
    public ArrayList SENALAMIENTONORMATIVO122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, DELITOID, SENALAMIENTONORMATIVO\n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE SENALAMIENTONORMATIVO IS NULL"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

 //Regla Adicional Favor de verificar el campo Fuero CATFUEROID debido a que solo se puede seleccionar la opción "Común" (1) y "Federal" (2).
    public ArrayList CATFUEROID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, DELITOID, CATFUEROID\n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE CATFUEROID IN (0)"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

//Regla Adicional Favor de verificar el campo Calificación del delito	CATCALIFICACIONDELITOID debido a que no se puede seleccionar una opcion diferente a "Grave" (1), "No grave" (2), "No identificado" (9).
    public ArrayList CLASIFICACIONDELITO122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, DELITOID, CATCALIFICACIONDELITOID\n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE CATCALIFICACIONDELITOID not in (1,2,9)"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 



 //Regla Adicional Favor de verificar el campo Forma de comisión	CATFORMACOMISIONID debido a que no debe seleccionar una opcion diferente a "Doloso" (1), "Culposo" (2) o "No identificado" (9).
    public ArrayList CATFORMACOMISIONID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, DELITOID, CATFORMACOMISIONID\n" +
"FROM TR_SENAP_DELITOS\n" +
"WHERE CATFORMACOMISIONID not in (1,2,9) OR CATFORMACOMISIONID IS NULL"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

    //Regla Adicional. Senalamiento normativo con siglas LGMDFP, lgpysdms, LGAMVLV y lgpsedmtp deben ser de tipo fuero Federal (2).
public ArrayList normativo_LGMDFP(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID, DELITOID, CATFISCALIAID, CARPETAID, DELITOLEYPENAL, SENALAMIENTONORMATIVO, CATFUEROID FROM TR_SENAP_DELITOS WHERE UPPER(SENALAMIENTONORMATIVO) LIKE '%LG%' AND UPPER(SENALAMIENTONORMATIVO) NOT LIKE '%ALG%' and CATFUEROID = 1";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

    //Senalamiento normativo con siglas diferentes a LGMDFP, lgpysdms, LGAMVLV y lgpsedmtp deben ser de tipo fuero Común (1).
public ArrayList normativo_LGMDFP_dif(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID, DELITOID, CATFISCALIAID, CARPETAID, DELITOLEYPENAL, SENALAMIENTONORMATIVO, CATFUEROID FROM TR_SENAP_DELITOS WHERE (UPPER(SENALAMIENTONORMATIVO) not LIKE '%LG%' AND UPPER(SENALAMIENTONORMATIVO) LIKE '%ALG%') or CATFUEROID not in (1,9) ";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 


}
