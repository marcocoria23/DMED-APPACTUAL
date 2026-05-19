/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones_JA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.JA.DaoConexionJA;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Valida_JA {
    
      DaoConexionJA conexion=new DaoConexionJA();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    
    
    
    public ArrayList Control_Ingreso(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO)CLAVE_ORGANO,COMENTARIOS FROM TR_JA_INGRESOS_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
     public ArrayList Control_Tramite(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO)CLAVE_ORGANO,COMENTARIOS FROM TR_JA_TRAMITE_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")             
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      public ArrayList Control_Conclusiones(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO)CLAVE_ORGANO,COMENTARIOS FROM TR_JA_CONCLUSIONES_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")               
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      
      
      public ArrayList Control_Actos_Procesales(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO),COMENTARIOS FROM TR_JA_ACTOS_PROCESALES_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")              
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
      public ArrayList Control_Cumplim_Ejecutorias(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO),COMENTARIOS FROM TR_JA_CUMPLIM_EJECUTORIAS_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")               
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      
        public ArrayList Control_Exhorto(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO),COMENTARIOS FROM TR_JA_EXHORTOS_DESPACHOS_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")               
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
        
        
          public ArrayList Control_Asuntos_Hidrocarburos(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO),COMENTARIOS FROM TR_JA_ASUNTOS_HIDROCARBUROS_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")               
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      
          
   public ArrayList NULL_Conclusiones(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_RESOLUCIONES IS NULL THEN 'TOTAL_RESOLUCIONES' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE TOTAL_RESOLUCIONES IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SENTENCIAS_DEF IS NULL THEN 'SENTENCIAS_DEF' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE SENTENCIAS_DEF IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SENTENCIAS_CUMPL_EJEC IS NULL THEN 'SENTENCIAS_CUMPL_EJEC' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE SENTENCIAS_CUMPL_EJEC IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SENTENCIAS_CUMP_RR IS NULL THEN 'SENTENCIAS_CUMP_RR' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE SENTENCIAS_CUMP_RR IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN LAUDOS IS NULL THEN 'LAUDOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE LAUDOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONVENIOS IS NULL THEN 'CONVENIOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE CONVENIOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DESISTIMIENTOS IS NULL THEN 'DESISTIMIENTOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE DESISTIMIENTOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CADUCIDADES IS NULL THEN 'CADUCIDADES' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE CADUCIDADES IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JURISDICCION_VOLUNTARIA IS NULL THEN 'JURISDICCION_VOLUNTARIA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE JURISDICCION_VOLUNTARIA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OTRO_RESOL IS NULL THEN 'OTRO_RESOL' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONCLUSIONES_GEN\"\n" +
"    WHERE OTRO_RESOL IS NULL\n" +
")\n" +
"WHERE CAMPO_VACIO IS NOT NULL\n" +
"ORDER BY NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("PERIODO"),
                    resul.getString("CAMPO_VACIO"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
       
public ArrayList ASUNTOS_HIDROCARBUROS(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NOMBRE_ORGANO_JURIS IS NULL THEN 'NOMBRE_ORGANO_JURIS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE NOMBRE_ORGANO_JURIS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CLAVE_ORGANO IS NULL THEN 'CLAVE_ORGANO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE CLAVE_ORGANO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN PERIODO IS NULL THEN 'PERIODO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE PERIODO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS IS NULL THEN 'TOTAL_ASUNTOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN VALIDACION_CONTRATOS IS NULL THEN 'VALIDACION_CONTRATOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE VALIDACION_CONTRATOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SOLICITUD_DECLARACION IS NULL THEN 'SOLICITUD_DECLARACION' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE SOLICITUD_DECLARACION IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NULIDAD_CONTRATOS IS NULL THEN 'NULIDAD_CONTRATOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE NULIDAD_CONTRATOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OTRAS_CONTROV IS NULL THEN 'OTRAS_CONTROV' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE OTRAS_CONTROV IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_CONCL IS NULL THEN 'TOTAL_ASUNTOS_CONCL' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_CONCL IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RESOLUCION_VALIDA IS NULL THEN 'RESOLUCION_VALIDA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE RESOLUCION_VALIDA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RESOLUCION_NOVALIDA IS NULL THEN 'RESOLUCION_NOVALIDA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE RESOLUCION_NOVALIDA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ACUERDO_CADUCIDAD IS NULL THEN 'ACUERDO_CADUCIDAD' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE ACUERDO_CADUCIDAD IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OTRA_FORMA_CONCL IS NULL THEN 'OTRA_FORMA_CONCL' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_ASUNTOS_HIDROCARBUROS_GEN\"\n" +
"    WHERE OTRA_FORMA_CONCL IS NULL\n" +
")\n" +
"WHERE CAMPO_VACIO IS NOT NULL\n" +
"ORDER BY NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("PERIODO"),
                    resul.getString("CAMPO_VACIO"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 

     public ArrayList NULL_Control(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NOMBRE_ORGANO_JURIS IS NULL THEN 'NOMBRE_ORGANO_JURIS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE NOMBRE_ORGANO_JURIS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CLAVE_ORGANO IS NULL THEN 'CLAVE_ORGANO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE CLAVE_ORGANO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DISTRITO IS NULL THEN 'DISTRITO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE DISTRITO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SEDE IS NULL THEN 'SEDE' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE SEDE IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CLAVE_AGEE IS NULL THEN 'CLAVE_AGEE' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE CLAVE_AGEE IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ENTIDAD_FEDERATIVA IS NULL THEN 'ENTIDAD_FEDERATIVA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE ENTIDAD_FEDERATIVA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CLAVE_AGEM IS NULL THEN 'CLAVE_AGEM' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE CLAVE_AGEM IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN MUNICIPIO IS NULL THEN 'MUNICIPIO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE MUNICIPIO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN PERIODO IS NULL THEN 'PERIODO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE PERIODO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_INGRES IS NULL THEN 'TOTAL_ASUNTOS_INGRES' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_INGRES IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EXP_RECIBIDOS IS NULL THEN 'EXP_RECIBIDOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE EXP_RECIBIDOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DEMAN_INGRESADAS IS NULL THEN 'DEMAN_INGRESADAS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE DEMAN_INGRESADAS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_TRAMITE IS NULL THEN 'TOTAL_ASUNTOS_TRAMITE' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_TRAMITE IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_RESOLUCIONES IS NULL THEN 'TOTAL_RESOLUCIONES' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CONTROL_GEN\"\n" +
"    WHERE TOTAL_RESOLUCIONES IS NULL\n" +
")\n" +
"WHERE CAMPO_VACIO IS NOT NULL\n" +
"ORDER BY NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("PERIODO"),
                    resul.getString("CAMPO_VACIO"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
       public ArrayList NULL_CUMPLIM_EJECUTORIAS(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NOMBRE_ORGANO_JURIS IS NULL THEN 'NOMBRE_ORGANO_JURIS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CUMPLIM_EJECUTORIAS_GEN\"\n" +
"    WHERE NOMBRE_ORGANO_JURIS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CLAVE_ORGANO IS NULL THEN 'CLAVE_ORGANO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CUMPLIM_EJECUTORIAS_GEN\"\n" +
"    WHERE CLAVE_ORGANO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN PERIODO IS NULL THEN 'PERIODO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CUMPLIM_EJECUTORIAS_GEN\"\n" +
"    WHERE PERIODO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_CUMPL IS NULL THEN 'TOTAL_ASUNTOS_CUMPL' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CUMPLIM_EJECUTORIAS_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_CUMPL IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_CUMPL_AMPARO IS NULL THEN 'ASUNTOS_CUMPL_AMPARO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CUMPLIM_EJECUTORIAS_GEN\"\n" +
"    WHERE ASUNTOS_CUMPL_AMPARO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_CUMPL_RECURSO IS NULL THEN 'ASUNTOS_CUMPL_RECURSO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_CUMPLIM_EJECUTORIAS_GEN\"\n" +
"    WHERE ASUNTOS_CUMPL_RECURSO IS NULL\n" +
")\n" +
"WHERE CAMPO_VACIO IS NOT NULL\n" +
"ORDER BY NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("PERIODO"),
                    resul.getString("CAMPO_VACIO"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
       
       public ArrayList NULL_ACTOS_PROCESALES(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'NOMBRE_ORGANO_JURIS' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE NOMBRE_ORGANO_JURIS IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'CLAVE_ORGANO' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE CLAVE_ORGANO IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'PERIODO' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE PERIODO IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'TOTAL_AUTOS' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE TOTAL_AUTOS IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'AUTOS_EJECUCION' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE AUTOS_EJECUCION IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'OTROS_AUTOS' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE OTROS_AUTOS IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'TOTAL_DP' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE TOTAL_DP IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'DP_NOTIFICACIONES' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE DP_NOTIFICACIONES IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'DP_INSPECCIONES' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE DP_INSPECCIONES IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'DP_CITACIONES' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE DP_CITACIONES IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'DP_OTRO' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE DP_OTRO IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'TOTAL_EMPLAZAMIENTOS' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE TOTAL_EMPLAZAMIENTOS IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'TOTAL_AUDIENCIAS' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE TOTAL_AUDIENCIAS IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'AUDIENCIAS_PRESENCIAL' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE AUDIENCIAS_PRESENCIAL IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'AUDIENCIAS_REMOTO' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE AUDIENCIAS_REMOTO IS NULL\n" +
"\n" +
"    UNION ALL\n" +
"\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           'TOTAL_RESOLUCIONES' AS CAMPO_VACIO\n" +
"    FROM RAF_2022.TR_JA_ACTOS_PROCESALES_GEN\n" +
"    WHERE TOTAL_RESOLUCIONES IS NULL\n" +
")\n" +
"WHERE CAMPO_VACIO IS NOT NULL\n" +
"ORDER BY NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("PERIODO"),
                    resul.getString("CAMPO_VACIO"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
         public ArrayList NULL_EXHORTOS_DESPACHOS(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NOMBRE_ORGANO_JURIS IS NULL THEN 'NOMBRE_ORGANO_JURIS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE NOMBRE_ORGANO_JURIS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CLAVE_ORGANO IS NULL THEN 'CLAVE_ORGANO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE CLAVE_ORGANO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN PERIODO IS NULL THEN 'PERIODO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE PERIODO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EXH_RECIBIDOS IS NULL THEN 'EXH_RECIBIDOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE EXH_RECIBIDOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EXH_DILIGENCIADOS IS NULL THEN 'EXH_DILIGENCIADOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE EXH_DILIGENCIADOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EXH_FORMULADOS IS NULL THEN 'EXH_FORMULADOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE EXH_FORMULADOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EXH_DILIG_RECIBIDOS IS NULL THEN 'EXH_DILIG_RECIBIDOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE EXH_DILIG_RECIBIDOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DESPACH_RECIB_NOTI IS NULL THEN 'DESPACH_RECIB_NOTI' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE DESPACH_RECIB_NOTI IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DESPACH_RECIB_EJEC IS NULL THEN 'DESPACH_RECIB_EJEC' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE DESPACH_RECIB_EJEC IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DESPACH_RECIB_OTRAS IS NULL THEN 'DESPACH_RECIB_OTRAS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE DESPACH_RECIB_OTRAS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DESPACH_DILIG_NOTI IS NULL THEN 'DESPACH_DILIG_NOTI' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE DESPACH_DILIG_NOTI IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DESPACH_DILIG_EJEC IS NULL THEN 'DESPACH_DILIG_EJEC' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE DESPACH_DILIG_EJEC IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DESPACH_DILIG_OTRAS IS NULL THEN 'DESPACH_DILIG_OTRAS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_EXHORTOS_DESPACHOS_GEN\"\n" +
"    WHERE DESPACH_DILIG_OTRAS IS NULL\n" +
")\n" +
"WHERE CAMPO_VACIO IS NOT NULL\n" +
"ORDER BY NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("PERIODO"),
                    resul.getString("CAMPO_VACIO"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
         
 public ArrayList NULL_INGRESOS(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NOMBRE_ORGANO_JURIS IS NULL THEN 'NOMBRE_ORGANO_JURIS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE NOMBRE_ORGANO_JURIS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CLAVE_ORGANO IS NULL THEN 'CLAVE_ORGANO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CLAVE_ORGANO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN PERIODO IS NULL THEN 'PERIODO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE PERIODO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_INGRESOS IS NULL THEN 'TOTAL_INGRESOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE TOTAL_INGRESOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_EXPED_RECIBIDOS IS NULL THEN 'SUBTOTAL_EXPED_RECIBIDOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE SUBTOTAL_EXPED_RECIBIDOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EXPED_COMISION_MIXTA IS NULL THEN 'EXPED_COMISION_MIXTA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE EXPED_COMISION_MIXTA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EXPED_TRIBUNAL_SUPERIOR_AG IS NULL THEN 'EXPED_TRIBUNAL_SUPERIOR_AG' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE EXPED_TRIBUNAL_SUPERIOR_AG IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EXPED_OTRAS IS NULL THEN 'EXPED_OTRAS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE EXPED_OTRAS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_DEMANDAS IS NULL THEN 'SUBTOTAL_DEMANDAS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE SUBTOTAL_DEMANDAS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DEMANDAS_ESCRITO IS NULL THEN 'DEMANDAS_ESCRITO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE DEMANDAS_ESCRITO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DEMANDAS_COMPARECENCIA IS NULL THEN 'DEMANDAS_COMPARECENCIA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE DEMANDAS_COMPARECENCIA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_ADMIT_MAT IS NULL THEN 'TOTAL_ASUNTOS_ADMIT_MAT' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_ADMIT_MAT IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_TERRENOS IS NULL THEN 'SUBTOTAL_ASUNTOS_TERRENOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_TERRENOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROVER_TERR_NUCLEOS IS NULL THEN 'CONTROVER_TERR_NUCLEOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CONTROVER_TERR_NUCLEOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROVER_TERR_PROPIETARIOS IS NULL THEN 'CONTROVER_TERR_PROPIETARIOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CONTROVER_TERR_PROPIETARIOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROVER_TERR_SOCIEDAD IS NULL THEN 'CONTROVER_TERR_SOCIEDAD' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CONTROVER_TERR_SOCIEDAD IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROVER_TERR_POB_EJIDAL IS NULL THEN 'CONTROVER_TERR_POB_EJIDAL' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CONTROVER_TERR_POB_EJIDAL IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_RESTIT IS NULL THEN 'SUBTOTAL_ASUNTOS_RESTIT' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_RESTIT IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RESTIT_ACTOS_AUTORIDAD IS NULL THEN 'RESTIT_ACTOS_AUTORIDAD' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE RESTIT_ACTOS_AUTORIDAD IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RESTIT_ACTOS_PARTICULAR IS NULL THEN 'RESTIT_ACTOS_PARTICULAR' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE RESTIT_ACTOS_PARTICULAR IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RECON_REG_COMUNAL IS NULL THEN 'RECON_REG_COMUNAL' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE RECON_REG_COMUNAL IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NULIDADES_CONTRA_RESOL IS NULL THEN 'NULIDADES_CONTRA_RESOL' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE NULIDADES_CONTRA_RESOL IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONFLICTOS_TENENCIA IS NULL THEN 'CONFLICTOS_TENENCIA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CONFLICTOS_TENENCIA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_MA IS NULL THEN 'SUBTOTAL_ASUNTOS_MA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_MA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROVER_MA_ENTRE_SI IS NULL THEN 'CONTROVER_MA_ENTRE_SI' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CONTROVER_MA_ENTRE_SI IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROVER_MA_ORGANOS IS NULL THEN 'CONTROVER_MA_ORGANOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CONTROVER_MA_ORGANOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUCESION_DERECHOS IS NULL THEN 'SUCESION_DERECHOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE SUCESION_DERECHOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_JN IS NULL THEN 'SUBTOTAL_ASUNTOS_JN' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_JN IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JN_PROMOVIDOS IS NULL THEN 'JN_PROMOVIDOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE JN_PROMOVIDOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JN_CONTRAVIE IS NULL THEN 'JN_CONTRAVIE' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE JN_CONTRAVIE IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OMISIONES_PROCUR_PERJUICIO IS NULL THEN 'OMISIONES_PROCUR_PERJUICIO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE OMISIONES_PROCUR_PERJUICIO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_JV IS NULL THEN 'ASUNTOS_JV' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE ASUNTOS_JV IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROVERSIAS_APROVECHA IS NULL THEN 'CONTROVERSIAS_APROVECHA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE CONTROVERSIAS_APROVECHA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN REVERSION IS NULL THEN 'REVERSION' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE REVERSION IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_EJECUCION IS NULL THEN 'SUBTOTAL_ASUNTOS_EJECUCION' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_EJECUCION IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EJECUCION_CONVENIOS IS NULL THEN 'EJECUCION_CONVENIOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE EJECUCION_CONVENIOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EJECUCION_LAUDOS IS NULL THEN 'EJECUCION_LAUDOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE EJECUCION_LAUDOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RRT_INGRE IS NULL THEN 'RRT_INGRE' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE RRT_INGRE IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN PRIVACION IS NULL THEN 'PRIVACION' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE PRIVACION IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN INCONFORM IS NULL THEN 'INCONFORM' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE INCONFORM IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_LEGIS IS NULL THEN 'ASUNTOS_LEGIS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE ASUNTOS_LEGIS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OTROS_ASUNTOS IS NULL THEN 'OTROS_ASUNTOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE OTROS_ASUNTOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_DEMANDAS_NO_INTER IS NULL THEN 'TOTAL_DEMANDAS_NO_INTER' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_INGRESOS_GEN\"\n" +
"    WHERE TOTAL_DEMANDAS_NO_INTER IS NULL\n" +
")\n" +
"WHERE CAMPO_VACIO IS NOT NULL\n" +
"ORDER BY NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("PERIODO"),
                    resul.getString("CAMPO_VACIO"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
 
 public ArrayList NULL_TRAMITE(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM (\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NOMBRE_ORGANO_JURIS IS NULL THEN 'NOMBRE_ORGANO_JURIS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE NOMBRE_ORGANO_JURIS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CLAVE_ORGANO IS NULL THEN 'CLAVE_ORGANO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CLAVE_ORGANO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN PERIODO IS NULL THEN 'PERIODO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE PERIODO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_PEND IS NULL THEN 'TOTAL_ASUNTOS_PEND' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_PEND IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_PEND_PREV IS NULL THEN 'ASUNTOS_PEND_PREV' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE ASUNTOS_PEND_PREV IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_PEND_TERM IS NULL THEN 'ASUNTOS_PEND_TERM' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE ASUNTOS_PEND_TERM IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_PEND_ADMI IS NULL THEN 'ASUNTOS_PEND_ADMI' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE ASUNTOS_PEND_ADMI IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_INSTRUC IS NULL THEN 'TOTAL_ASUNTOS_INSTRUC' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_INSTRUC IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_JA IS NULL THEN 'ASUNTOS_JA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE ASUNTOS_JA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN ASUNTOS_JV IS NULL THEN 'ASUNTOS_JV' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE ASUNTOS_JV IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_MATERIA IS NULL THEN 'TOTAL_ASUNTOS_MATERIA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_MATERIA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_CONTROV IS NULL THEN 'SUBTOTAL_ASUNTOS_CONTROV' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_CONTROV IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_NUCLEOS_MENOS20 IS NULL THEN 'CONTROV_NUCLEOS_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_NUCLEOS_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_PROPIE_MENOS20 IS NULL THEN 'CONTROV_PROPIE_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_PROPIE_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_SOC_MENOS20 IS NULL THEN 'CONTROV_SOC_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_SOC_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_COL_MENOS20 IS NULL THEN 'CONTROV_COL_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_COL_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_NUCLEOS_MAS20 IS NULL THEN 'CONTROV_NUCLEOS_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_NUCLEOS_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_PROPIE_MAS20 IS NULL THEN 'CONTROV_PROPIE_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_PROPIE_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_SOC_MAS20 IS NULL THEN 'CONTROV_SOC_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_SOC_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_COL_MAS20 IS NULL THEN 'CONTROV_COL_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_COL_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_RESTIT IS NULL THEN 'SUBTOTAL_ASUNTOS_RESTIT' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_RESTIT IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RESTIT_AUTORID_MENOS20 IS NULL THEN 'RESTIT_AUTORID_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE RESTIT_AUTORID_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RESTIT_PARTIC_MENOS20 IS NULL THEN 'RESTIT_PARTIC_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE RESTIT_PARTIC_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RESTIT_AUTORID_MAS20 IS NULL THEN 'RESTIT_AUTORID_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE RESTIT_AUTORID_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RESTIT_PARTIC_MAS20 IS NULL THEN 'RESTIT_PARTIC_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE RESTIT_PARTIC_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_RECON IS NULL THEN 'SUBTOTAL_RECON' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_RECON IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RECON_MENOS20 IS NULL THEN 'RECON_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE RECON_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RECON_MAS20 IS NULL THEN 'RECON_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE RECON_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_NULIDADES IS NULL THEN 'SUBTOTAL_NULIDADES' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_NULIDADES IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NULIDADES_MENOS20 IS NULL THEN 'NULIDADES_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE NULIDADES_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN NULIDADES_MAS20 IS NULL THEN 'NULIDADES_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE NULIDADES_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_TENENCIA IS NULL THEN 'SUBTOTAL_TENENCIA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_TENENCIA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TENENCIA_MENOS20 IS NULL THEN 'TENENCIA_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE TENENCIA_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TENENCIA_MAS20 IS NULL THEN 'TENENCIA_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE TENENCIA_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_CONT_MA IS NULL THEN 'SUBTOTAL_ASUNTOS_CONT_MA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_CONT_MA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_MA_EJID_MENOS20 IS NULL THEN 'CONTROV_MA_EJID_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_MA_EJID_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_MA_NUCLEO_MENOS20 IS NULL THEN 'CONTROV_MA_NUCLEO_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_MA_NUCLEO_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_MA_EJID_MAS20 IS NULL THEN 'CONTROV_MA_EJID_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_MA_EJID_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_MA_NUCLEO_MAS20 IS NULL THEN 'CONTROV_MA_NUCLEO_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_MA_NUCLEO_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_DERECHOS IS NULL THEN 'SUBTOTAL_ASUNTOS_DERECHOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_DERECHOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DERECHOS_MENOS20 IS NULL THEN 'DERECHOS_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE DERECHOS_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DERECHOS_MAS20 IS NULL THEN 'DERECHOS_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE DERECHOS_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_JN IS NULL THEN 'SUBTOTAL_JN' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_JN IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JN_PROMOVIDOS_MENOS20 IS NULL THEN 'JN_PROMOVIDOS_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE JN_PROMOVIDOS_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JN_ACTOS_MENOS20 IS NULL THEN 'JN_ACTOS_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE JN_ACTOS_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JN_PROMOVIDOS_MAS20 IS NULL THEN 'JN_PROMOVIDOS_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE JN_PROMOVIDOS_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JN_ACTOS_MAS20 IS NULL THEN 'JN_ACTOS_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE JN_ACTOS_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_OMISIONES IS NULL THEN 'SUBTOTAL_OMISIONES' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_OMISIONES IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OMISIONES_MENOS20 IS NULL THEN 'OMISIONES_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE OMISIONES_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OMISIONES_MAS20 IS NULL THEN 'OMISIONES_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE OMISIONES_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_JV IS NULL THEN 'SUBTOTAL_ASUNTOS_JV' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_JV IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JV_MENOS20 IS NULL THEN 'JV_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE JV_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JV_MAS20 IS NULL THEN 'JV_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE JV_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_CONTROV_TERR IS NULL THEN 'SUBTOTAL_CONTROV_TERR' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_CONTROV_TERR IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_TERR_MENOS20 IS NULL THEN 'CONTROV_TERR_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_TERR_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN CONTROV_TERR_MAS20 IS NULL THEN 'CONTROV_TERR_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE CONTROV_TERR_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_REVERSION IS NULL THEN 'SUBTOTAL_REVERSION' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_REVERSION IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN REVERSION_MENOS20 IS NULL THEN 'REVERSION_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE REVERSION_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN REVERSION_MAS20 IS NULL THEN 'REVERSION_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE REVERSION_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_EJECUCION IS NULL THEN 'SUBTOTAL_EJECUCION' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_EJECUCION IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EJECUCION_CONV_MENOS20 IS NULL THEN 'EJECUCION_CONV_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE EJECUCION_CONV_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EJECUCION_LAUDOS_MENOS20 IS NULL THEN 'EJECUCION_LAUDOS_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE EJECUCION_LAUDOS_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EJECUCION_CONVENIOS_MAS20 IS NULL THEN 'EJECUCION_CONVENIOS_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE EJECUCION_CONVENIOS_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN EJECUCION_LAUDOS_MAS20 IS NULL THEN 'EJECUCION_LAUDOS_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE EJECUCION_LAUDOS_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_RRT IS NULL THEN 'SUBTOTAL_ASUNTOS_RRT' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_RRT IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RRT_MENOS20 IS NULL THEN 'RRT_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE RRT_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN RRT_MAS20 IS NULL THEN 'RRT_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE RRT_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_DA IS NULL THEN 'SUBTOTAL_ASUNTOS_DA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_DA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DA_MENOS20 IS NULL THEN 'DA_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE DA_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN DA_MAS20 IS NULL THEN 'DA_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE DA_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_INCONFOR IS NULL THEN 'SUBTOTAL_ASUNTOS_INCONFOR' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_INCONFOR IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN INCONFOR_MENOS20 IS NULL THEN 'INCONFOR_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE INCONFOR_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN INCONFOR_MAS20 IS NULL THEN 'INCONFOR_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE INCONFOR_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_ASUNTOS_LA IS NULL THEN 'SUBTOTAL_ASUNTOS_LA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_ASUNTOS_LA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN LA_MENOS20 IS NULL THEN 'LA_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE LA_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN LA_MAS20 IS NULL THEN 'LA_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE LA_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN SUBTOTAL_OTROS_ASUNTOS IS NULL THEN 'SUBTOTAL_OTROS_ASUNTOS' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE SUBTOTAL_OTROS_ASUNTOS IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OTROS_ASUNTOS_MENOS20 IS NULL THEN 'OTROS_ASUNTOS_MENOS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE OTROS_ASUNTOS_MENOS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN OTROS_ASUNTOS_MAS20 IS NULL THEN 'OTROS_ASUNTOS_MAS20' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE OTROS_ASUNTOS_MAS20 IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_PROYECTO IS NULL THEN 'TOTAL_ASUNTOS_PROYECTO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_PROYECTO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JUICIO_AGRARIO IS NULL THEN 'JUICIO_AGRARIO' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE JUICIO_AGRARIO IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN JURIS_VOLUNTARIA IS NULL THEN 'JURIS_VOLUNTARIA' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE JURIS_VOLUNTARIA IS NULL\n" +
"    UNION ALL\n" +
"    SELECT NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO,\n" +
"           CASE WHEN TOTAL_ASUNTOS_TRAMITE IS NULL THEN 'TOTAL_ASUNTOS_TRAMITE' END as CAMPO_VACIO\n" +
"    FROM \"RAF_2022\".\"TR_JA_TRAMITE_GEN\"\n" +
"    WHERE TOTAL_ASUNTOS_TRAMITE IS NULL\n" +
")\n" +
"WHERE CAMPO_VACIO IS NOT NULL\n" +
"ORDER BY NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("NOMBRE_ORGANO_JURIS"),
                    resul.getString("CLAVE_ORGANO"),
                    resul.getString("PERIODO"),
                    resul.getString("CAMPO_VACIO"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_JA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
}
