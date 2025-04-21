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
public class VCarpetaInvetigacion {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";
    
    
    //ReglaNegocio Adicional: La relación entre los campos  CatEntidadFederativaID (Entidad) y CATMUNICIPIOID (Municipio) de la plantilla Carpeta Investigación, no coinciden con la relación de los campos CATENTIDADFEDERATIVAID y CATMUNICIPIODEMARCACIONTERRITORIALID del catálogo SENAP_MUNICIPIODEMARCACIONTERRITOR
public ArrayList RelacionMunicipio(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (\n" +
"select UBICACIONID,CATDEMARCACIONID, CATENTFEDID,CATSUBPROREFID, tc.CATMUNICIPIODEMARCACIONTERRITORIALID as catalogo, ub.periodo, ub.ENTIDADID from tr_senap_direccionubicacion ub\n" +
"left join TC_SENAP_MUNICIPIODEMARCACIONTERRITOR tc on tc.CATMUNICIPIODEMARCACIONTERRITORIALID=ub.CATDEMARCACIONID and tc.catentidadfederativaid=ub.CATENTFEDID)\n" +
"where catalogo is null and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "') and  CATSUBPROREFID=1";
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

    

    //ReglaNegocio GENERAL. La Fecha de presentación de la denuncia o querella (columna U) no puede ser mayor a la Fecha Actual.
    public ArrayList FECHACARINVEMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,CARPETAID,PERIODO\n"
                + "FROM TR_SENAP_CARPETAINVESTIGACION\n"
                + "WHERE FECHACARINVE > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.1. El campo NoticiaCriminalID (columna B) no existe en la plantilla Noticia Criminal.
    public ArrayList NOTICIACRIMINALID(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "ci.entidadid,ci.PERIODO, ci.CARPETAID, ci.CARPETAID_FISCALIA,ci.NOTICIACRIMINALID,ci.NOTICIACRIMINALID_FISCALIA,\n"
                + "ci.DIRECCIONUBICACIONID,ci.DETERMINACIONID_ULTIMO,nc.NOTICIACRIMINALID as otro from tr_senap_carpetainvestigacion CI inner join tr_senap_noticiacriminal nc\n"
                + "on  nc.NOTICIACRIMINALID=ci.NOTICIACRIMINALID where ci.NOTICIACRIMINALID is null AND (ci.ENTIDADID='" + Entidad + "' AND ci.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.10. Tipo de atención CATTIPOATENCIONID (TR_SENAP_ATENCIONES), Fecha de inicio de la atención FECHAINICIOATENCION (TR_SENAP_ATENCIONES), Fecha de conclusión de la atención FECHCONCLUATE (TR_SENAP_ATENCIONES) y Sentido de la conclusión de la atención CATSENTCONCLUATEID (TR_SENAP_ATENCIONES) no podrán estar vacías si el campo “En caso de no abrir carpeta de investigación, ¿Se brindó algún tipo de atención?” BRINDOALGUNTIPOATENCION es requisitado con la opción
    public ArrayList CATTIPOATENCIONID(String Entidad, String Periodo) throws SQLException {
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
                + "ATE.CATSENTCONCLUATEID IS NULL) AND (ate.ENTIDADID='" + Entidad + "' AND ate.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.10. Tipo de atención CATTIPOATENCIONID (TR_SENAP_ATENCIONES), Fecha de inicio de la atención FECHAINICIOATENCION (TR_SENAP_ATENCIONES), Fecha de conclusión de la atención FECHCONCLUATE (TR_SENAP_ATENCIONES) y Sentido de la conclusión de la atención CATSENTCONCLUATEID (TR_SENAP_ATENCIONES) no podrán traer valor si el campo “En caso de no abrir carpeta de investigación, ¿Se brindó algún tipo de atención?” BRINDOALGUNTIPOATENCION es la opción “No”
    public ArrayList FECHAINICIOATENCION(String Entidad, String Periodo) throws SQLException {
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
                + "ATE.CATSENTCONCLUATEID IS not NULL) AND (ate.ENTIDADID='" + Entidad + "' AND ate.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.11. El valor que contenga el campo Número de la carpeta de investigación (columna V), deberá ser único e irrepetible en una misma Fiscalía, tanto en la plantilla Carpeta de investigación o bien en la tabla correspondiente de la BD de producción.
    public ArrayList CARPETAINVE(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (\n"
                + "select \n"
                + "ENTIDADID, PERIODO,\n"
                + "NUMCARPINVE,count(NUMCARPINVE) as conteo\n"
                + "from TR_SENAP_CARPETAINVESTIGACION\n"
                + "group by ENTIDADID,PERIODO,\n"
                + "NUMCARPINVE)where conteo>1 AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.9. El campo Año de carpeta de investigación (columna W) no debe ser mayor al Año Actual.
    public ArrayList AÑOCARPETAINVE(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "select \n"
                + "ENTIDADID, PERIODO,\n"
                + "NOTICIACRIMINALID,CARPETAID,\n"
                + "DIRECCIONUBICACIONID,\n"
                + "NUMERICOANIOCARPETA,\n"
                + "EXTRACT (YEAR FROM SYSDATE) AS ANIO_ACTUAL\n"
                + "from TR_SENAP_CARPETAINVESTIGACION)\n"
                + "WHERE NUMERICOANIOCARPETA>ANIO_ACTUAL AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.2. La Fecha de apertura de la carpeta de investigación (columna Y) debe ser mayor o igual a la Fecha de presentación de la denuncia o querella (columna U)  de la plantilla Noticia Criminal, en caso de existir.
    public ArrayList FECAPECARINVE(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "ci.PERIODO,\n"
                + "ci.CARPETAID,\n"
                + "ci.CARPETAID_FISCALIA,\n"
                + "ci.NOTICIACRIMINALID,\n"
                + "ci.NOTICIACRIMINALID_FISCALIA,\n"
                + "ci.DIRECCIONUBICACIONID,\n"
                + "ci.DETERMINACIONID_ULTIMO,\n"
                + "ci.FECHACARINVE ,\n"
                + "nc.FECHAPRESDENUNQUERELLA \n"
                + "from tr_senap_carpetainvestigacion ci \n"
                + "inner join tr_senap_noticiacriminal nc\n"
                + "on  nc.NOTICIACRIMINALID=ci.NOTICIACRIMINALID\n"
                + "WHERE ci.FECHACARINVE <nc.fechapresdenunquerella AND (ci.FECHACARINVE<>'01/01/1900') AND (nc.fechapresdenunquerella<>'01/01/1900') and  (ci.ENTIDADID='" + Entidad + "' AND ci.PERIODO='" + Periodo + "') and (ci.FECHACARINVE<>'09/09/1899') AND (nc.fechapresdenunquerella<>'09/09/1899')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.3. En caso de que la Fecha de apertura de la carpeta de investigación FECHAPECARINVE sea igual a la Fecha de la presentación de la denuncia o querella FECHAPRESDENUNQUERELLA (TR_SENAP_NOTICIACRIMINAL), en caso de existir, la Hora de la apertura de la carpeta  HORAPECARINVE deberá ser mayor a la hora de la denuncia o querella HORAREPREDENUNQUERELLA de la plantilla de noticia criminal (TR_SENAP_NOTICIACRIMINAL).
    public ArrayList FECHAPECARINVEIgual(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "ci.PERIODO,\n"
                + "ci.CARPETAID,\n"
                + "ci.CARPETAID_FISCALIA,\n"
                + "ci.NOTICIACRIMINALID,\n"
                + "ci.NOTICIACRIMINALID_FISCALIA,\n"
                + "ci.FECHACARINVE ,\n"
                + "nc.FECHAPRESDENUNQUERELLA,\n"
                + "ci.HORAPECARINVE,\n"
                + "nc.HORAREPREDENUNQUERELLA \n"
                + "\n"
                + "from tr_senap_carpetainvestigacion ci \n"
                + "inner join tr_senap_noticiacriminal nc \n"
                + "on  nc.NOTICIACRIMINALID=ci.NOTICIACRIMINALID \n"
                + "where ci.FECHACARINVE =nc.FECHAPRESDENUNQUERELLA and ci.HORAPECARINVE<nc.HORAREPREDENUNQUERELLA AND (ci.FECHACARINVE<>'01/01/1900') AND (nc.fechapresdenunquerella<>'01/01/1900') AND (ci.ENTIDADID='" + Entidad + "' AND ci.PERIODO='" + Periodo + "') AND (ci.FECHACARINVE<>'09/09/1899') AND (nc.FECHAPRESDENUNQUERELLA<>'09/09/1899')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe existir registro en la plantilla Actos de Investigación, debido que en el campo ¿Se realizaron actos de investigación? (columna AA) se respondió con un “Sí” (1).
    public ArrayList ACTOS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "CI.ENTIDADID, CI.PERIODO,\n"
                + "CI.NOTICIACRIMINALID,CI.CARPETAID,\n"
                + "CI.DIRECCIONUBICACIONID,\n"
                + "CI.REALACTINVE,\n"
                + "AI.REG\n"
                + "from TR_SENAP_CARPETAINVESTIGACION CI\n"
                + "LEFT JOIN (SELECT ENTIDADID, PERIODO,CARPETAID, COUNT (CARPETAID) AS REG FROM TR_SENAP_ACTOSINVESTIGACION GROUP BY ENTIDADID, PERIODO,CARPETAID) AI ON  \n"
                + "ci.entidadid=ai.entidadid AND ci.periodo=ai.periodo AND ci.carpetaid=ai.carpetaid\n"
                + "WHERE CI.REALACTINVE=1 AND AI.REG IS NULL  AND (CI.ENTIDADID='" + Entidad + "' AND CI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No debe existir registro en la plantilla Actos de Investigación, debido que en el campo ¿Se realizaron actos de investigación? (columna AA) se respondió con una opción diferente a “Sí” (1).
    public ArrayList NSACTOS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "CI.ENTIDADID, CI.PERIODO,\n"
                + "CI.NOTICIACRIMINALID,CI.CARPETAID,\n"
                + "CI.DIRECCIONUBICACIONID,\n"
                + "CI.REALACTINVE,\n"
                + "AI.REG\n"
                + "from TR_SENAP_CARPETAINVESTIGACION CI\n"
                + "LEFT JOIN (SELECT ENTIDADID, PERIODO,CARPETAID, COUNT (CARPETAID) AS REG FROM TR_SENAP_ACTOSINVESTIGACION GROUP BY ENTIDADID, PERIODO,CARPETAID) AI ON  \n"
                + "ci.entidadid=ai.entidadid AND ci.periodo=ai.periodo AND ci.carpetaid=ai.carpetaid\n"
                + "WHERE CI.REALACTINVE<>1 AND AI.REG IS not NULL  AND (CI.ENTIDADID='" + Entidad + "' AND CI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.5. La cantidad de delitos registrados en la plantilla Delitos no coincide con la cantidad que se ingresó en la plantilla Carpeta de Investigación.
    public ArrayList DELITOS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT  ENTIDADID,PERIODO, CARPETAID, CARPETAID_FISCALIA,\n"
                + "NOTICIACRIMINALID, NOTICIACRIMINALID_FISCALIA, \n"
                + "CANTIDADDELITOS, CASE WHEN CANT_DEL IS NULL THEN 0 ELSE TO_NUMBER(CANT_DEL) END CANT_DEL\n"
                + "FROM(\n"
                + "select ci.ENTIDADID,ci.PERIODO,\n"
                + "ci.CARPETAID,\n"
                + "ci.CARPETAID_FISCALIA,\n"
                + "ci.NOTICIACRIMINALID,\n"
                + "ci.NOTICIACRIMINALID_FISCALIA,\n"
                + "ci.CANTIDADDELITOS,\n"
                + "deli.CANT_DEL\n"
                + "from TR_SENAP_CARPETAINVESTIGACION ci \n"
                + "left join (select ENTIDADID, CARPETAID, PERIODO, \n"
                + "count(periodo) as cant_del \n"
                + "from tr_senap_delitos group by ENTIDADID, CARPETAID, PERIODO) deli on deli.ENTIDADID=ci.ENTIDADID and deli.CARPETAID=ci.CARPETAID and deli.PERIODO=ci.PERIODO\n"
                + "))\n"
                + "WHERE  CANTIDADDELITOS<>CANT_DEL AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.6. La cantidad de víctimas registrados en la tabla Victimas no coincide con la cantidad que se ingresó en la plantilla Carpeta de investigación.
    public ArrayList VICTIMAS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT  ENTIDADID,PERIODO, CARPETAID, CARPETAID_FISCALIA,\n"
                + "NOTICIACRIMINALID, NOTICIACRIMINALID_FISCALIA, \n"
                + "CANTIDADvictimas, CASE WHEN CANT_vic IS NULL THEN 0 ELSE TO_NUMBER(CANT_vic) END CANT_vic\n"
                + "FROM(\n"
                + "select ci.ENTIDADID,ci.PERIODO,\n"
                + "ci.CARPETAID,\n"
                + "ci.CARPETAID_FISCALIA,\n"
                + "ci.NOTICIACRIMINALID,\n"
                + "ci.NOTICIACRIMINALID_FISCALIA,\n"
                + "ci.cantidadvictimas,\n"
                + "vic.cant_vic\n"
                + "from TR_SENAP_CARPETAINVESTIGACION ci \n"
                + "left join (select ENTIDADID, CARPETAID, PERIODO, \n"
                + "count(periodo) as cant_vic\n"
                + "from tr_senap_victimas group by ENTIDADID, CARPETAID, PERIODO) vic on vic.ENTIDADID=ci.ENTIDADID and vic.CARPETAID=ci.CARPETAID and vic.PERIODO=ci.PERIODO\n"
                + "))\n"
                + "WHERE  CANTIDADvictimas<>CANT_vic AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 2.11. La cantidad de imputados registrados en la tabla Imputado no coincide con la cantidad que se ingresó en la plantilla Carpeta de investigación.
    public ArrayList IMPUTADOS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM (\n"
                + "SELECT  ENTIDADID,PERIODO, CARPETAID, CARPETAID_FISCALIA,\n"
                + "NOTICIACRIMINALID, NOTICIACRIMINALID_FISCALIA, \n"
                + "CANTIDADimputados, CASE WHEN CANT_imp IS NULL THEN 0 ELSE TO_NUMBER(CANT_imp) END CANT_imp\n"
                + "FROM(\n"
                + "select ci.ENTIDADID,ci.PERIODO,\n"
                + "ci.CARPETAID,\n"
                + "ci.CARPETAID_FISCALIA,\n"
                + "ci.NOTICIACRIMINALID,\n"
                + "ci.NOTICIACRIMINALID_FISCALIA,\n"
                + "ci.cantidadimputados,\n"
                + "imp.cant_imp\n"
                + "from TR_SENAP_CARPETAINVESTIGACION ci \n"
                + "left join (select ENTIDADID, CARPETAID, PERIODO, \n"
                + "count(periodo) as cant_imp\n"
                + "from tr_senap_imputado group by ENTIDADID, CARPETAID, PERIODO) imp on imp.ENTIDADID=ci.ENTIDADID and imp.CARPETAID=ci.CARPETAID and imp.PERIODO=ci.PERIODO\n"
                + "))\n"
                + "WHERE  CANTIDADimputados<>CANT_imp AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //El campo Cantidad de personas imputadas (columna AD) de la tabla Imputado no coincide con la cantidad de registros de la plantilla Carpeta de investigación.
    public ArrayList NCDELITOS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "ci.ENTIDADID, ci.PERIODO,\n"
                + "ci.NOTICIACRIMINALID,ci.CARPETAID,\n"
                + "ci.DIRECCIONUBICACIONID,\n"
                + "ci.CATHECHOCIID,\n"
                + "de.reg\n"
                + "from TR_SENAP_CARPETAINVESTIGACION CI\n"
                + "LEFT JOIN (SELECT ENTIDADID, PERIODO,CARPETAID, COUNT (CARPETAID) AS REG FROM TR_SENAP_DELITOS GROUP BY ENTIDADID, PERIODO,CARPETAID) DE ON de.entidadid=ci.entidadid and de.periodo=ci.periodo and ci.CARPETAID=de.carpetaid\n"
                + "\n"
                + "where ci.CATHECHOCIID=2 and de.reg is not null AND (ci.ENTIDADID='" + Entidad + "' AND ci.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Si el campo ¿Tipo de hecho por el que se abrió la carpeta de investigación? se seleccionó una opción diferente a "Hecho no constitutivo de delito” (2), no deberá haber registros en la plantilla Delitos.
    public ArrayList DCDELITOS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "ci.ENTIDADID, ci.PERIODO,\n"
                + "ci.NOTICIACRIMINALID,ci.CARPETAID,\n"
                + "ci.DIRECCIONUBICACIONID,\n"
                + "ci.CATHECHOCIID,\n"
                + "de.reg\n"
                + "from TR_SENAP_CARPETAINVESTIGACION CI\n"
                + "LEFT JOIN (SELECT ENTIDADID, PERIODO,CARPETAID, COUNT (CARPETAID) AS REG FROM TR_SENAP_DELITOS GROUP BY ENTIDADID, PERIODO,CARPETAID) DE ON de.entidadid=ci.entidadid and de.periodo=ci.periodo and ci.CARPETAID=de.carpetaid\n"
                + "\n"
                + "where ci.CATHECHOCIID<>2 and de.reg is null AND (ci.ENTIDADID='" + Entidad + "' AND ci.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe existir registros en la plantilla Actos de Investigación ya que el campo ¿Se realizaron aseguramientos? (columna AF) se requisito la opción “Sí” (1).
    public ArrayList ACTOSINVESTIGACION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (\n"
                + "select \n"
                + "ci.ENTIDADID, ci.PERIODO,\n"
                + "ci.NOTICIACRIMINALID,ci.CARPETAID,\n"
                + "ci.DIRECCIONUBICACIONID,\n"
                + "ci.REALIZARONASEGURAMIENTOS,\n"
                + "ain.reg\n"
                + "from TR_SENAP_CARPETAINVESTIGACION  CI \n"
                + "left join(SELECT ENTIDADID, PERIODO,CARPETAID, COUNT (CARPETAID) AS REG FROM TR_SENAP_ACTOSINVESTIGACION GROUP BY ENTIDADID, PERIODO,CARPETAID) AIN\n"
                + "on ain.periodo=ci.periodo and ain.entidadid=ci.entidadid and ain.CARPETAID=ci.CARPETAID\n"
                + ")\n"
                + "where reg is null and REALIZARONASEGURAMIENTOS=1 AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No debe existir registros en la plantilla Actos de Investigación ya que el campo ¿Se realizaron aseguramientos? (columna AF) es diferente de la opción “Sí” (1).
    public ArrayList NCACTOSINVESTIGACION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (\n"
                + "select \n"
                + "ci.ENTIDADID, ci.PERIODO,\n"
                + "ci.NOTICIACRIMINALID,ci.CARPETAID,\n"
                + "ci.DIRECCIONUBICACIONID,\n"
                + "ci.REALIZARONASEGURAMIENTOS,\n"
                + "ain.reg\n"
                + "from TR_SENAP_CARPETAINVESTIGACION  CI \n"
                + "left join(SELECT ENTIDADID, PERIODO,CARPETAID, COUNT (CARPETAID) AS REG FROM TR_SENAP_ACTOSINVESTIGACION GROUP BY ENTIDADID, PERIODO,CARPETAID) AIN\n"
                + "on ain.periodo=ci.periodo and ain.entidadid=ci.entidadid and ain.CARPETAID=ci.CARPETAID\n"
                + ")\n"
                + "where reg is not null and REALIZARONASEGURAMIENTOS<>1 AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Favor de verificar variable CATFISCALIAID-IdentificadorFiscalia en su codigo diferente de 1 a 33 ya que la variable es de prioridad 1
//ReglaNegocio Adicional Favor de verificar variable CATFISCALIAID-IdentificadorFiscalia en su codigo diferente de 1 a 33 ya que la variable es de prioridad 1 
    public ArrayList CATFISCALIAID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CARPETAID,CATFISCALIAID \n" +
"FROM TR_SENAP_CARPETAINVESTIGACION\n" +
"WHERE  (CATFISCALIAID \n" +
"NOT IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33)) and (CATFISCALIAID is null)"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

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
        sql = "SELECT CARPETAID,NOMBREFISREGIOESPECIALIZADA \n" +
"FROM TR_SENAP_CARPETAINVESTIGACION\n" +
"WHERE  (NOMBREFISREGIOESPECIALIZADA IS NULL)"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

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
        sql = "SELECT CARPETAID,NOMBREAGEMINISTERIOPUBLICO \n" +
"FROM TR_SENAP_CARPETAINVESTIGACION\n" +
"WHERE  (NOMBREAGEMINISTERIOPUBLICO IS NULL)"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

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
        sql = "SELECT CARPETAID,CATMEDCONOCHECHOSID \n" +
"FROM TR_SENAP_CARPETAINVESTIGACION\n" +
"WHERE  CATMEDCONOCHECHOSID \n" +
"NOT IN (1,2,3,4,5,6,7,9) OR CATMEDCONOCHECHOSID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }



 //ReglaNegocio Adicional Favor de verificar variable FECHACARINVE-Fecha de apertura de la carpeta de investigación  ya que la variable es de prioridad 1 y no puede venir null 
    public ArrayList FECHACARINVE122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CARPETAID,FECHACARINVE \n" +
"FROM TR_SENAP_CARPETAINVESTIGACION\n" +
"WHERE  FECHACARINVE is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ReglaNegocio Adicional Favor de verificar variable HORAPECARINVE-Hora en la que el ministerio público abrió carpeta de investigación  ya que la variable es de prioridad 1 y no puede venir null
    public ArrayList HORAPECARINVE122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CARPETAID,HORAPECARINVE \n" +
"FROM TR_SENAP_CARPETAINVESTIGACION\n" +
"WHERE  HORAPECARINVE is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }


//ReglaNegocio Adicional Favor de verificar variable CATHECHOCIID-Tipo de hecho por el que se abrió la carpeta de investigación en su codigo diferente de 1 a 3 ya que la variable es de prioridad 1
    public ArrayList CATHECHOCIID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CARPETAID,CATHECHOCIID \n" +
"FROM TR_SENAP_CARPETAINVESTIGACION\n" +
"WHERE  CATHECHOCIID \n" +
"NOT IN (1,2,3) and CATHECHOCIID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }


//ReglaNegocio Adicional Favor de verificar variable CATETAPAPROCESALID-Etapa procesal en que se encuentra la carpeta de investigación en su codigo diferente de 1 a 5 ya que la variable es de prioridad 1
    public ArrayList CATETAPAPROCESALID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT CARPETAID,CATETAPAPROCESALID \n" +
"FROM TR_SENAP_CARPETAINVESTIGACION\n" +
"WHERE  CATETAPAPROCESALID \n" +
"NOT IN (1,2,3,4,9) or CATETAPAPROCESALID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("CARPETAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
