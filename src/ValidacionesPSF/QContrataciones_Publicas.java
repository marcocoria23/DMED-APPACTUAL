/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidacionesPSF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.PSF.DaoConexionPSF;

/**
 *
 * @author ANTONIO.CORIA
 */
public class QContrataciones_Publicas {

    DaoConexionPSF conexion = new DaoConexionPSF();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;

    //Debe de capturar otro_tipo_procedimiento_especifique ya que tipo_procedimiento='Otro tipo (especifique)'
    public ArrayList otro_tipo_procedimiento_especifique() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_CONTRATO,otro_tipo_procedimiento_especifique,tipo_procedimiento,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_CONTRATACIONES_PUBLICAS_GEN\n"
                + "where tipo_procedimiento= '4' and otro_tipo_procedimiento_especifique is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No debe de capturar otro_tipo_procedimiento_especifique ya que tipo_procedimiento es diferente a 'Otro tipo (especifique)'
    public ArrayList otro_tipo_procedimiento_especifiqueNDC() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_CONTRATO,otro_tipo_procedimiento_especifique,tipo_procedimiento,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_CONTRATACIONES_PUBLICAS_GEN\n"
                + "where tipo_procedimiento<> '4' and otro_tipo_procedimiento_especifique is not null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe ser igual o mayor a la fecha registrada en el campo fecha_publicacion_convocatoria. En caso de este criterio no le aplique, debe justificarlo en el campo ""Comentarios"".
    public ArrayList fecha_publicacion_fallo() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_CONTRATO,FECHA_PUBLICACION_CONVOCATORIA, fecha_publicacion_fallo,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_CONTRATACIONES_PUBLICAS_GEN\n"
                + "where FECHA_PUBLICACION_FALLO< FECHA_PUBLICACION_CONVOCATORIA and \n"
                + "comentarios is null and FECHA_PUBLICACION_FALLO not like '09/09/99'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe ser igual o mayor a la fecha registrada en el campo fecha_publicacion_fallo. En caso de este criterio no le aplique, debe justificarlo en el campo ""Comentarios""..
    public ArrayList fecha_firma_contrato() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_CONTRATO,fecha_publicacion_fallo,fecha_firma_contrato,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_CONTRATACIONES_PUBLICAS_GEN\n"
                + "where fecha_firma_contrato< FECHA_PUBLICACION_FALLO and \n"
                + "comentarios is null and FECHA_PUBLICACION_FALLO not like '09/09/99' and  fecha_firma_contrato not like '09/09/99'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe ser igual o mayor a la fecha registrada en el campo fecha_firma_contrato.En caso de este criterio no le aplique, debe justificarlo en el campo ""Comentarios"".
    public ArrayList fecha_inicio_contrato() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_CONTRATO,fecha_publicacion_fallo,fecha_firma_contrato,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_CONTRATACIONES_PUBLICAS_GEN\n"
                + "where fecha_firma_contrato< FECHA_PUBLICACION_FALLO and \n"
                + "comentarios is null and FECHA_PUBLICACION_FALLO not like '09/09/99' and  fecha_firma_contrato not like '09/09/99'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe ser igual o mayor a la fecha registrada en el campo fecha_inicio_contrato.En caso de este criterio no le aplique, debe justificarlo en el campo ""Comentarios"".
    public ArrayList fecha_conclusion_contrato() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_CONTRATO,fecha_inicio_contrato,fecha_conclusion_contrato,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_CONTRATACIONES_PUBLICAS_GEN\n"
                + "where fecha_conclusion_contrato< fecha_inicio_contrato and \n"
                + "comentarios is null and fecha_inicio_contrato not like '09/09/99' and  fecha_conclusion_contrato not like '09/09/99'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe de capturar tipo_garantia_presentada_1 ya que campo cond_presentacion_garantia =Sí.
    public ArrayList tipo_garantia_presentada_1() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_CONTRATO,tipo_procedimiento,tipo_garantia_presentada_1,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_CONTRATACIONES_PUBLICAS_GEN\n"
                + "where cond_presentacion_garantia= '1' and tipo_garantia_presentada_1 is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No debe de capturar tipo_garantia_presentada_1 ya que campo cond_presentacion_garantia =No.
    public ArrayList tipo_garantia_presentada_1_ND() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_CONTRATO,tipo_procedimiento,tipo_garantia_presentada_1,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_CONTRATACIONES_PUBLICAS_GEN\n"
                + "where cond_presentacion_garantia<> '1' and tipo_garantia_presentada_1 is not null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
