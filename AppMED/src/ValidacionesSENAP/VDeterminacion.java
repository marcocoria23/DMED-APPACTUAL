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
public class VDeterminacion {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";
    
    //ReglaAdicional 9.2.1.7. Si el sentido de la determinación es requisitado con la opción  "Ejercicio de la acción penal" se deberá permitir el registro del campo "Fecha de la determinación" (columna H) y se continuará con el registros de la plantilla Proceso".
 public ArrayList sentidodeter_accionpenal(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DET.ENTIDADID, DET.PERIODO, DET.CARPETAID, DET.IMPUTADOID, DET.DETERMINACIONID, DET.CATSENDETID, DET.FECHADETERMINACION, P.TABLA_PROCESO\n" +
"FROM TR_SENAP_DETERMINACION DET\n" +
"LEFT JOIN (                                                                                             \n" +
"	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n" +
"	count (PROCESOID) AS TABLA_PROCESO\n" +
"	from TR_SENAP_PROCESO\n" +
"	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n" +
"	) P\n" +
"ON DET.ENTIDADID = P.ENTIDADID AND DET.PERIODO = P.PERIODO AND DET.CARPETAID = P.CARPETAID\n" +
"WHERE DET.CATSENDETID = 1\n" +
"AND (DET.FECHADETERMINACION IS NULL\n" +
"  AND P.TABLA_PROCESO IS NULL)\n" +
"AND (DET.ENTIDADID='" + Entidad + "' AND DET.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    

    //La FECHADETERMINACION (Fecha de la determinación ) No debe de ser mayor a la fecha actual.
    public ArrayList FECHADETERMINACIONMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,DETERMINACIONID,IMPUTADOID,PERIODO\n"
                + "FROM TR_SENAP_DETERMINACION\n"
                + "WHERE FECHADETERMINACION > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ReglaAdicional 1.1.1. El campo Estatus de la carpeta de investigación (columna C) es requisitado con el valor “Concluida” (1) entonces en el campo Sentido de la determinación (columna D) solo se pueden seleccionar las opciones “No ejercicio de la acción penal por la actualización de alguna causal de sobreseimiento”; “Abstenerse de investigar cuando se encuentre extinguida la acción penal o la responsabilidad penal de la persona imputada”; “Abstenerse de investigar cuando las conductas no constituyan delito”; “Abstenerse de investigar no identificado”; “Criterios de oportunidad en los que se decretó la extinción de la acción penal”, “Incompetencia”, “Acuerdos reparatorios aprobados por el Ministerio Público en los que se decretó la extinción de la acción penal” y “Acumulación”.    
        public ArrayList ESTATUS_SENTIDO_DETERMINACION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, DETERMINACIONID, CARPETAID, IMPUTADOID, PERIODO, CATESTATUSCARPETAID, CATSENDETID\n" +
"from TR_SENAP_DETERMINACION\n" +
"where CATESTATUSCARPETAID = 1\n" +
"and CATSENDETID IN (1,3,11,99)\n" +
"AND (ENTIDADID='"+Entidad+"' AND PERIODO='"+Periodo+"'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
        
        
    //ReglaAdicional 9.2.5. Si el campo Estatus de la carpeta de investigación   (columna D), es requisitado con la opción “No identificado”, entonces en el campo Sentido de la determinación (columna E) únicamente deberá contar con el valor “No identificado
    public ArrayList ESTATUSCARPETA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO,IMPUTADODELITOID, IMPUTADOID, DETERMINACIONID, CATESTATUSCARPETAID, CATSENDETID\n"
                + "from TR_SENAP_DETERMINACION\n"
                + "where CATESTATUSCARPETAID = 9\n"
                + "and CATSENDETID <> 99 AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 9.2.6. Si  el campo Estatus de la carpeta de investigación” (columna D), corresponde a “Trámite”, entonces las determinaciones válidas en el campo Sentido de determinación (columna E) a las cuales podrá ser actualizada son: “Ejercicio de la Acción Penal”, “Archivo temporal”, “Otro” y “No identificado”; este último para el caso de las carpetas de investigación que al inicio de su apertura aún no cuenten con un sentido de determinación
    public ArrayList ESTATUSCARPETADET(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,\n"
                + "DETERMINACIONID,\n"
                + "CARPETAID,\n"
                + "IMPUTADOID,\n"
                + "PERIODO,\n"
                + "CATESTATUSCARPETAID,\n"
                + "CATSENDETID\n"
                + "from TR_SENAP_DETERMINACION\n"
                + "where CATESTATUSCARPETAID =2\n"
                + "and CATSENDETID  NOT IN (1,3,11,99) AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 1.1. Si el campo Estatus de la carpeta de investigación (columna D) es requisitado con el valor “Concluida”, en el campo Sentido de la determinación (columna E), podrán registrarse únicamente las opciones: “No ejercicio de la acción penal por la actualización de alguna causal de sobreseimiento”; “Abstenerse de investigar cuando se encuentre extinguida la acción penal o la responsabilidad penal de la persona imputada”; “Abstenerse de investigar cuando las conductas no constituyan delito”; “Abstenerse de investigar no identificado”; “Criterios de oportunidad en los que se decretó la extinción de la acción penal”, “Incompetencia”, “Acuerdos reparatorios aprobados por el Ministerio Público en los que se decretó la extinción de la acción penal” y “Acumulación”
    public ArrayList CONCLUIDO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CI.ENTIDADID, CI.PERIODO, CI.CARPETAID, CI.NOTICIACRIMINALID, CI.DIRECCIONUBICACIONID, D.DETERMINACIONID, D.IMPUTADOID, CI.DETERMINACIONID_ULTIMO, CI.CATETAPAPROCESALID, D.CATESTATUSCARPETAID, D.CATSENDETID\n"
                + "FROM(\n"
                + "	select *\n"
                + "	from  TR_SENAP_CARPETAINVESTIGACION\n"
                + "	where CATETAPAPROCESALID = 1)CI, TR_SENAP_DETERMINACION D\n"
                + "WHERE CI.CARPETAID = D.CARPETAID\n"
                + "AND CATESTATUSCARPETAID = 1\n"
                + "and CATSENDETID not in (2,4,5,6,7,8,9,10) AND (CI.ENTIDADID='" + Entidad + "' AND CI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 1.2. Si el campo Estatus de la carpeta de investigación (columna D) es requisitado con la opción “En proceso de conclusión (trámite)”, el campo Sentido de la determinación (columna E) podrá registrar las opciones “Ejercicio de la acción penal”; “Archivo temporal” u “Otro”.
    public ArrayList PROCESOCONCLUSION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CI.ENTIDADID, CI.PERIODO, CI.CARPETAID, CI.NOTICIACRIMINALID, CI.DIRECCIONUBICACIONID, CI.DETERMINACIONID_ULTIMO, CI.CATETAPAPROCESALID, D.CATESTATUSCARPETAID, D.CATSENDETID,D.IMPUTADOID,DETERMINACIONID\n"
                + "FROM(\n"
                + "	select *\n"
                + "	from  TR_SENAP_CARPETAINVESTIGACION\n"
                + "	where CATETAPAPROCESALID = 1)CI, TR_SENAP_DETERMINACION D\n"
                + "WHERE CI.CARPETAID = D.CARPETAID\n"
                + "AND CATESTATUSCARPETAID = 2\n"
                + "and CATSENDETID not in (1,3,11) AND (CI.ENTIDADID='" + Entidad + "' AND CI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Si en el campo Estatus de la carpeta de investigación (columna D) se especifica la opción “Concluida”, se deberá corroborar la existencia de información en la plantilla MASC
   /* public ArrayList MASCEXISTE(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select d.ENTIDADID,\n"
                + "d.DETERMINACIONID,\n"
                + "d.CARPETAID,\n"
                + "d.IMPUTADOID,\n"
                + "d.PERIODO,\n"
                + "d.CATESTATUSCARPETAID,\n"
                + "d.CATSENDETID,\n"
                + "d.fechadeterminacion,\n"
                + "MASC.num_reg\n"
                + "from TR_SENAP_DETERMINACION d left join (\n"
                + "select ENTIDADID,\n"
                + "CARPETAID,\n"
                + "IMPUTADOID,\n"
                + "PROCESOID,\n"
                + "PERIODo,\n"
                + "count (PERIODO) as num_reg\n"
                + "\n"
                + "from tr_senap_masc group by ENTIDADID,\n"
                + "CARPETAID,\n"
                + "IMPUTADOID,\n"
                + "PROCESOID,\n"
                + "PERIODO\n"
                + ") MASC on MASC.entidadid=d.entidadid \n"
                + "and MASC.carpetaid=d.carpetaid  and MASC.PERIODO=d.PERIODO\n"
                + "where CATESTATUSCARPETAID=1 and CATSENDETID IN (9) and MASC.num_reg is null AND (D.ENTIDADID='" + Entidad + "' AND D.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }*/

    //Si en el campo Estatus de la carpeta de investigación (columna D) se especifica la opción “Concluida”, se deberá corroborar la existencia de información en la plantilla sobreseimiento
    public ArrayList CONCLUIDA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select d.ENTIDADID, d.DETERMINACIONID,\n"
                + "d.CARPETAID, d.IMPUTADOID,\n"
                + "d.PERIODO, d.CATESTATUSCARPETAID,\n"
                + "d.CATSENDETID, d.fechadeterminacion,\n"
                + "s.num_reg from TR_SENAP_DETERMINACION d left join (\n"
                + "select ENTIDADID, CARPETAID,\n"
                + "IMPUTADOID, PROCESOID,\n"
                + "PERIODO, count (PERIODO) as num_reg\n"
                + "from tr_senap_sobreseimiento group by ENTIDADID, CARPETAID,\n"
                + "IMPUTADOID, PROCESOID, PERIODO\n"
                + ") s on s.entidadid=d.entidadid \n"
                + "and s.carpetaid=d.carpetaid  and s.PERIODO=d.PERIODO\n"
                + "where CATESTATUSCARPETAID=1 and CATSENDETID IN (2,3,5,6) and s.num_reg is null AND (d.ENTIDADID='" + Entidad + "' AND d.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 9.2. Para el campo Sentido de la determinación (columna E) si este campo es llenado, la Fecha de la determinación (columna H) no puede venir vacia.
    public ArrayList SENTIDODETERMINACION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,\n"
                + "DETERMINACIONID,\n"
                + "CARPETAID,\n"
                + "IMPUTADOID,\n"
                + "PERIODO,\n"
                + "CATESTATUSCARPETAID,\n"
                + "CATSENDETID,\n"
                + "fechadeterminacion\n"
                + "from TR_SENAP_DETERMINACION\n"
                + "where CATSENDETID  IS NOT NULL AND fechadeterminacion IS NULL AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 9.2.1.1. Si el sentido de la determinación es requisitado con la opción “Acuerdos reparatorios aprobados por el Ministerio Público en los que se decretó la extinción de la acción penal”  los campos "En caso de acuerdos reparatorios, ¿tipo de acuerdos reparatorios?" (columna F)  y "Fecha de la determinación" (columna H) no pueden venir vacios
    public ArrayList SENTIDODACUERDOS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,\n"
                + "DETERMINACIONID,\n"
                + "CARPETAID,\n"
                + "IMPUTADOID,\n"
                + "PERIODO,\n"
                + "CATESTATUSCARPETAID,\n"
                + "CATSENDETID,\n"
                + "fechadeterminacion\n"
                + "from TR_SENAP_DETERMINACION\n"
                + "where \n"
                + "CATSENDETID=9 AND (CATACURECID IS NULL OR fechadeterminacion IS NULL) AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 9.2.1.2. Si el sentido de la determinación es requisitado con la opción “Acuerdos reparatorios aprobados por el Ministerio Público en los que se decretó la extinción de la acción penal”  los campos "En caso de acuerdos reparatorios, ¿tipo de acuerdos reparatorios?" (columna F)  y "Fecha de la determinación" (columna H) no pueden venir vacios
    public ArrayList SENTIDOARCHIVO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADODELITOID, IMPUTADODELITOID, DETERMINACIONID, CATSENDETID, HUBOREACTCARPETAINVEST\n"
                + "from TR_SENAP_DETERMINACION\n"
                + "where CATSENDETID =3\n"
                + "and HUBOREACTCARPETAINVEST is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 9.2.1.3. Si el sentido de la determinación es requisitado con la opción  "Ejercicio de la acción penal" el campo "Fecha de la determinación" (columna H) no puede venir vacio
    public ArrayList SENTIDOEJERCICIOAP(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,\n"
                + "DETERMINACIONID,\n"
                + "CARPETAID,\n"
                + "IMPUTADOID,\n"
                + "PERIODO,\n"
                + "CATESTATUSCARPETAID,\n"
                + "CATSENDETID,\n"
                + "fechadeterminacion\n"
                + "from TR_SENAP_DETERMINACION\n"
                + "WHERE CATSENDETID=1 AND fechadeterminacion IS NULL AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 9.2.1.4. Si el sentido de la determinación es requisitado con las opciones "No ejercicio de la acción penal por la actualización de alguna causal de sobreseimiento", "Abstenerse de investigar cuando se encuentre extinguida la acción penal o la responsabilidad penal de la persona imputada" “Abstenerse de investigar cuando las conductas no constituyan delito”, “Abstenerse de investigar no identificado”, “ Criterios de oportunidad en los que se decretó la extinción de la acción penal”, “Incompetencia”, “Acumulación” u “Otro”, únicamente se deberá permitir el registro del campo Fecha de la determinación (columna H) y se requisitará la plantilla Sobreseimiento.
    public ArrayList FECHADETERMINACION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = sql = "select DET.ENTIDADID, DET.DETERMINACIONID, DET.CARPETAID, DET.IMPUTADOID, DET.CATESTATUSCARPETAID, DET.CATSENDETID, DET.PERIODO, DET.FECHADETERMINACION, SB.TABLA_SOBRESEIMIENTO\n"
                + "from tr_senap_determinacion DET\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SOBRESEIMIENTOID,\n"
                + "	count (CARPETAID) AS TABLA_SOBRESEIMIENTO\n"
                + "	from TR_SENAP_SOBRESEIMIENTO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, SOBRESEIMIENTOID\n"
                + "	) SB\n"
                + "ON DET.ENTIDADID = SB.ENTIDADID AND DET.PERIODO = SB.PERIODO AND DET.CARPETAID = SB.CARPETAID\n"
                + "where DET.CATESTATUSCARPETAID = 1 and DET.CATSENDETID in (2,4,5,6,7,8,10,11) \n"
                + "and DET.FECHADETERMINACION is null \n"
                + "and SB.TABLA_SOBRESEIMIENTO IS NULL\n"
                + " AND (DET.ENTIDADID=' + Entidad + ' AND DET.PERIODO=' + Periodo + ')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 9.2.1.5. Sí es requisitada la plantilla "Sobreseimiento", el campo Sentido de la determinación debe ser requisitado con las opciones: "No ejercicio de la acción penal por la actualización de alguna causal de sobreseimiento", "Abstenerse de investigar cuando se encuentre extinguida la acción penal o la responsabilidad penal de la persona imputada", "Abstenerse de investigar cuando las conductas no constituyan delito”, “Abstenerse de investigar no identificado”, “ Criterios de oportunidad en los que se decretó la extinción de la acción penal”, “Incompetencia”, “Acumulación” u “Otro”.
    public ArrayList SOBRESEIMIENTO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM(\n"
                + "    SELECT D.ENTIDADID,D.DETERMINACIONID,D.CARPETAID,D.IMPUTADOID,D.IMPUTADODELITOID,D.PERIODO,D.CATSENDETID, D.CATESTATUSCARPETAID,S.SOBRESEIMIENTOID \n"
                + "    FROM (\n"
                + "        SELECT ENTIDADID,DETERMINACIONID,CARPETAID,IMPUTADOID,IMPUTADODELITOID,PERIODO,CATSENDETID,CATESTATUSCARPETAID\n"
                + "        FROM TR_SENAP_DETERMINACION\n"
                + "        WHERE CATSENDETID in (2,4,5,6,7,8,10,11) \n"
                + "        AND CATESTATUSCARPETAID=1)D LEFT JOIN TR_SENAP_SOBRESEIMIENTO S\n"
                + "        ON D.ENTIDADID=S.ENTIDADID \n"
                + "        AND D.CARPETAID=S.CARPETAID \n"
                + "        AND D.PERIODO=S.PERIODO )  WHERE SOBRESEIMIENTOID IS NULL AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 9.2.1.6. Si el sentido de la determinación es diferente a la opción "Ejercicio de la acción penal" no debe registrar en el campo "Fecha de la determinación" (columna H) y no debe existir registros en la plantilla Proceso.
    public ArrayList SENTDETNO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DET.ENTIDADID, DET.PERIODO, DET.CARPETAID, DET.IMPUTADOID, DET.DETERMINACIONID, DET.CATSENDETID, DET.FECHADETERMINACION, P.TABLA_PROCESO\n"
                + "FROM TR_SENAP_DETERMINACION DET\n"
                + "LEFT JOIN (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n"
                + "	count (PROCESOID) AS TABLA_PROCESO\n"
                + "	from TR_SENAP_PROCESO\n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n"
                + "	) P\n"
                + "ON DET.ENTIDADID = P.ENTIDADID AND DET.PERIODO = P.PERIODO AND DET.CARPETAID = P.CARPETAID\n"
                + "WHERE DET.CATSENDETID <> 1\n"
                + "AND (DET.FECHADETERMINACION IS NOT NULL\n"
                + "  AND P.TABLA_PROCESO IS NOT NULL) AND (DET.ENTIDADID='" + Entidad + "' AND DET.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 9.2.2. Si el Sentido de la determinación (columna E) se ingresó con la opción de “Reactivación” (columna G), su estatus subsecuente solo podrá ser: “Ejercicio de la Acción Penal”, “No ejercicio de la acción penal”, “Archivo Temporal”, “Abstenerse de investigar cuando se encuentre extinguida la acción penal o la responsabilidad penal de la persona imputada”, “Abstenerse de investigar cuando las conductas no constituyan algún delito”, “Abstenerse de investigar no identificado”, “Criterio de oportunidad en los que se decretó la extinción de la acción penal”, “Incompetencia”, “Acuerdos reparatorios aprobados por el Ministerio Público en los que se decretó la extinción de la acción penal”, “Acumulación”, “Otro”
    public ArrayList REactivacion(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID, DETERMINACIONID, CARPETAID,\n"
                + "IMPUTADOID, IMPUTADODELITOID, PERIODO, HUBOREACTCARPETAINVEST \n"
                + "FROM TR_SENAP_DETERMINACION WHERE HUBOREACTCARPETAINVEST=1 AND CATSENDETID = 99 AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 3. Si el valor del campo Etapa procesal en que se encuentra la carpeta de investigación (columna AG) de la plantilla Carpeta de investigación es “Etapa de investigación complementaria”, el campo Sentido de la determinación (columna E), deberá ser requisitado con una de las siguientes opciones: “Ejercicio de la acción penal”; “Criterios de oportunidad en los que se decretó la extinción de la acción penal”; “Incompetencia”; “Acuerdos reparatorios aprobados por el Ministerio Público en los que se decretó la extinción de la acción penal”; o “No identificado”.
    public ArrayList ETAPAPROCESAL(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT D.DETERMINACIONID,D.IMPUTADOID,CI.ENTIDADID, CI.PERIODO, CI.CARPETAID, CI.NOTICIACRIMINALID, CI.DIRECCIONUBICACIONID, CI.DETERMINACIONID_ULTIMO, CI.CATETAPAPROCESALID, D.CATSENDETID\n"
                + "FROM(\n"
                + "	select *\n"
                + "	from  TR_SENAP_CARPETAINVESTIGACION\n"
                + "	where CATETAPAPROCESALID = 2)CI, TR_SENAP_DETERMINACION D\n"
                + "WHERE CI.CARPETAID = D.CARPETAID\n"
                + "and CATSENDETID not in (1,7,8,9,99) AND (CI.ENTIDADID='" + Entidad + "' AND CI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //Regla Adicional -- Favor de verificar el campo Estatus de la carpeta de investigación CATESTATUSCARPETAID no puede seleccionar una opción diferente a "Concluida" (1), "En proceso de conclusión (trámite)" (2) y "No identificado" (3)..
    public ArrayList CATTIPOPERSONAIMPUTADAID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, DETERMINACIONID, CATESTATUSCARPETAID\n" +
"from TR_SENAP_DETERMINACION\n" +
"where CATESTATUSCARPETAID not in (1,2,9) or CATESTATUSCARPETAID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 
 
//Regla Adicional -- Favor de verificar el campo Sentido de la determinación	CATSENDETID no puede venir nulo.
    public ArrayList SENTIDODETERMINACION122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, DETERMINACIONID, CATSENDETID\n" +
"from TR_SENAP_DETERMINACION\n" +
"where CATSENDETID not in (1,2,3,4,5,6,7,8,9,10,11,99) or CATSENDETID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

  
//Regla Adicional -- Favor de verificar el campo Fecha de la determinación (aplica también para fecha de reactivación en caso de archivo temporal y criterio de oportunidad)	FECHADETERMINACION debido a que no puede venir nulo.
    public ArrayList FECHADETERMINACION122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, DETERMINACIONID, FECHADETERMINACION\n" +
"from TR_SENAP_DETERMINACION\n" +
"where FECHADETERMINACION is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 

}
