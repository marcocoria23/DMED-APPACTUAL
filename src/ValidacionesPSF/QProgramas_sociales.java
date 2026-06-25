/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidacionesPSF;

import java.sql.Array;
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
public class QProgramas_sociales {

    DaoConexionPSF conexion = new DaoConexionPSF();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;

    //Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a Sí
    public ArrayList URL_REGLAS_LINEAMIENTOS_OPERACIONDC() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL, 'URL_REGLAS_LINEAMIENTOS_OPERACION' COMENTARIOS from TR_GF_PROG_SOCIALES_GEN\n"
                + "where COND_REGLAS_LINEAMIENTOS_OPERACION ='1'\n"
                + "and URL_REGLAS_LINEAMIENTOS_OPERACION is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a No
    public ArrayList URL_REGLAS_LINEAMIENTOS_OPERACIONNDC() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL, 'URL_REGLAS_LINEAMIENTOS_OPERACION' COMENTARIOS from TR_GF_PROG_SOCIALES_GEN\n"
                + "where COND_REGLAS_LINEAMIENTOS_OPERACION <> '1'\n"
                + "and URL_REGLAS_LINEAMIENTOS_OPERACION is not null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a No
    public ArrayList derecho_social_atendido_2() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,derecho_social_atendido_1,derecho_social_atendido_2,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where derecho_social_atendido_1 = derecho_social_atendido_2";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1 o derecho_social_atendido_2.
    public ArrayList derecho_social_atendido_3() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,derecho_social_atendido_1,derecho_social_atendido_2,derecho_social_atendido_3,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where derecho_social_atendido_1 = derecho_social_atendido_2 or\n"
                + "derecho_social_atendido_1 = derecho_social_atendido_3 or \n"
                + "derecho_social_atendido_2= derecho_social_atendido_3 ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1, derecho_social_atendido_2 o derecho_social_atendido_3
    public ArrayList derecho_social_atendido_4() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,derecho_social_atendido_1,derecho_social_atendido_2,derecho_social_atendido_3,derecho_social_atendido_4,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where derecho_social_atendido_1 = derecho_social_atendido_2 or\n"
                + "derecho_social_atendido_1 = derecho_social_atendido_3 or \n"
                + "derecho_social_atendido_1 = derecho_social_atendido_4 or \n"
                + "derecho_social_atendido_2= derecho_social_atendido_3 or\n"
                + "derecho_social_atendido_2= derecho_social_atendido_4 or\n"
                + "derecho_social_atendido_3= derecho_social_atendido_4";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1, derecho_social_atendido_2, derecho_social_atendido_3 o derecho_social_atendido_4.
    public ArrayList derecho_social_atendido_5() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,derecho_social_atendido_1,derecho_social_atendido_2,derecho_social_atendido_3,derecho_social_atendido_4,derecho_social_atendido_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where derecho_social_atendido_1 = derecho_social_atendido_2 or\n"
                + "derecho_social_atendido_1 = derecho_social_atendido_3 or \n"
                + "derecho_social_atendido_1 = derecho_social_atendido_4 or \n"
                + "derecho_social_atendido_2= derecho_social_atendido_3 or\n"
                + "derecho_social_atendido_2= derecho_social_atendido_4 or\n"
                + "derecho_social_atendido_3= derecho_social_atendido_4 or\n"
                + "derecho_social_atendido_3= derecho_social_atendido_5 or\n"
                + "derecho_social_atendido_4= derecho_social_atendido_5";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1.
    public ArrayList tipo_apoyo_entregado_2() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL, tipo_apoyo_entregado_1, tipo_apoyo_entregado_2,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where tipo_apoyo_entregado_1 = tipo_apoyo_entregado_2";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1 o tipo_apoyo_entregado_2.
    public ArrayList tipo_apoyo_entregado_3() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL, tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where tipo_apoyo_entregado_1 = tipo_apoyo_entregado_2 or\n"
                + "tipo_apoyo_entregado_1 = tipo_apoyo_entregado_3 or \n"
                + "tipo_apoyo_entregado_2= tipo_apoyo_entregado_3";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1, tipo_apoyo_entregado_2 o tipo_apoyo_entregado_3.
    public ArrayList tipo_apoyo_entregado_4() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL, tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3, tipo_apoyo_entregado_4, REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where tipo_apoyo_entregado_1 = tipo_apoyo_entregado_2 or\n"
                + "tipo_apoyo_entregado_1 = tipo_apoyo_entregado_3 or \n"
                + "tipo_apoyo_entregado_1 = tipo_apoyo_entregado_4 or \n"
                + "tipo_apoyo_entregado_2= tipo_apoyo_entregado_3 or\n"
                + "tipo_apoyo_entregado_2= tipo_apoyo_entregado_4 or\n"
                + "tipo_apoyo_entregado_3= tipo_apoyo_entregado_4";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3 o tipo_apoyo_entregado_4.
    public ArrayList tipo_apoyo_entregado_5() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL, tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3, tipo_apoyo_entregado_4, tipo_apoyo_entregado_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where tipo_apoyo_entregado_1 = tipo_apoyo_entregado_2 or\n"
                + "tipo_apoyo_entregado_1 = tipo_apoyo_entregado_3 or \n"
                + "tipo_apoyo_entregado_1 = tipo_apoyo_entregado_4 or \n"
                + "tipo_apoyo_entregado_2= tipo_apoyo_entregado_3 or\n"
                + "tipo_apoyo_entregado_2= tipo_apoyo_entregado_4 or\n"
                + "tipo_apoyo_entregado_3= tipo_apoyo_entregado_4 or\n"
                + "tipo_apoyo_entregado_3= tipo_apoyo_entregado_5 or\n"
                + "tipo_apoyo_entregado_4= tipo_apoyo_entregado_5";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Favor de especificar en OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE ya que al menos una variable de Tipo_apoyo_entregado ='Otro tipo de apoyo (especifique)'
    public ArrayList OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE,tipo_apoyo_entregado_1,tipo_apoyo_entregado_2,tipo_apoyo_entregado_3,tipo_apoyo_entregado_4,tipo_apoyo_entregado_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN\n"
                + "where (tipo_apoyo_entregado_1 ='13' or tipo_apoyo_entregado_2 ='13' or tipo_apoyo_entregado_3 ='13' or tipo_apoyo_entregado_4 ='13' or tipo_apoyo_entregado_5 ='13')\n"
                + "and OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No debe de especificar en OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE ya que las variable de Tipo_apoyo_entregado es diferente a'Otro tipo de apoyo (especifique)'
    public ArrayList OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUEND() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE,tipo_apoyo_entregado_1,tipo_apoyo_entregado_2,tipo_apoyo_entregado_3,tipo_apoyo_entregado_4,tipo_apoyo_entregado_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN\n"
                + "where (tipo_apoyo_entregado_1 <> '13' AND tipo_apoyo_entregado_2 <> '13' AND tipo_apoyo_entregado_3 <> '13' AND tipo_apoyo_entregado_4 <> '13' AND tipo_apoyo_entregado_5 ='13')\n"
                + "and OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE is not null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //poblacion_atendida_territorial_especifique no debe de capturar  ya que hay un dato numérico en el campo poblacion_atendida_territorial.
    public ArrayList poblacion_atendida_territorial_especifique() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_PROGRAMA_SOCIAL,POBLACION_ATENDIDA_TERRITORIAL,poblacion_atendida_territorial_especifique,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_PROG_SOCIALES_GEN\n"
                + "where POBLACION_ATENDIDA_TERRITORIAL ='NA'\n"
                + "and poblacion_atendida_territorial_especifique is NOT null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //debe de capturar en poblacion_atendida_territorial_especifique ya que hay un dato numérico en el campo poblacion_atendida_territorial.
    public ArrayList poblacion_atendida_territorial_especifiqueND() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_PROGRAMA_SOCIAL,POBLACION_ATENDIDA_TERRITORIAL,poblacion_atendida_territorial_especifique,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_PROG_SOCIALES_GEN\n"
                + "where POBLACION_ATENDIDA_TERRITORIAL <>'NA'\n"
                + "and poblacion_atendida_territorial_especifique is  null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //poblacion_atendida_otro_tipo_especifique no debe de capturar  ya que no hay un dato numérico en el campo poblacion_atendida_otro_tipo.
    public ArrayList poblacion_atendida_otro_tipo_especifique() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_PROGRAMA_SOCIAL, poblacion_atendida_otro_tipo,poblacion_atendida_otro_tipo_especifique,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_PROG_SOCIALES_GEN\n"
                + "where  poblacion_atendida_otro_tipo ='NA'\n"
                + "and poblacion_atendida_otro_tipo_especifique is NOT null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe de capturar en poblacion_atendida_otro_tipo_especifique   ya que  hay un dato numérico en el campo poblacion_atendida_otro_tipo.
    public ArrayList poblacion_atendida_otro_tipo_especifiqueND() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_PROGRAMA_SOCIAL, poblacion_atendida_otro_tipo,poblacion_atendida_otro_tipo_especifique,REPLACE(COMENTARIOS,',','')COMENTARIOS\n"
                + "from TR_GF_PROG_SOCIALES_GEN\n"
                + "where  poblacion_atendida_otro_tipo <>'NA'\n"
                + "and poblacion_atendida_otro_tipo_especifique is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede repetir el tipo de grupo vulnerable atendido  seleccionado en el campo grupo_vulnerable_beneficiado
    public ArrayList grupo() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,GRUPO_VULNERABLE_BENEFICIADO_1,GRUPO_VULNERABLE_BENEFICIADO_2,GRUPO_VULNERABLE_BENEFICIADO_3,GRUPO_VULNERABLE_BENEFICIADO_4,GRUPO_VULNERABLE_BENEFICIADO_5,GRUPO_VULNERABLE_BENEFICIADO_6, GRUPO_VULNERABLE_BENEFICIADO_7,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN \n"
                + "where GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_2 or\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_2 or GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_3 or \n"
                + "GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_4 or \n"
                + "GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_5 or \n"
                + "GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_6 or \n"
                + "GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_7 or GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_8 OR\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_3 or\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_4 or\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_5 or\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_6 or\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_7 or GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_8 OR\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_4 or\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_5 or\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_6 or\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_7 or GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_8 OR\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_4= GRUPO_VULNERABLE_BENEFICIADO_5 OR\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_4= GRUPO_VULNERABLE_BENEFICIADO_6 OR\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_4= GRUPO_VULNERABLE_BENEFICIADO_7 OR GRUPO_VULNERABLE_BENEFICIADO_4= GRUPO_VULNERABLE_BENEFICIADO_8 OR\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_5= GRUPO_VULNERABLE_BENEFICIADO_6 OR\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_5= GRUPO_VULNERABLE_BENEFICIADO_7 OR GRUPO_VULNERABLE_BENEFICIADO_5= GRUPO_VULNERABLE_BENEFICIADO_8 OR\n"
                + "GRUPO_VULNERABLE_BENEFICIADO_6=GRUPO_VULNERABLE_BENEFICIADO_7 OR GRUPO_VULNERABLE_BENEFICIADO_6=GRUPO_VULNERABLE_BENEFICIADO_8";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No Debe de capturar otro_grupo_vulnerable_beneficiado_especifique  ya que grupo_vulnerable_beneficiado es diferente a "Otro grupo vulnerable (especifique)"
    public ArrayList grupo_ESPECIFIQUE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE,GRUPO_VULNERABLE_BENEFICIADO_1,GRUPO_VULNERABLE_BENEFICIADO_2,GRUPO_VULNERABLE_BENEFICIADO_3,GRUPO_VULNERABLE_BENEFICIADO_4,GRUPO_VULNERABLE_BENEFICIADO_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN\n"
                + "where (GRUPO_VULNERABLE_BENEFICIADO_1 <> '21' AND GRUPO_VULNERABLE_BENEFICIADO_2 <> '21' AND GRUPO_VULNERABLE_BENEFICIADO_3 <> '21' AND GRUPO_VULNERABLE_BENEFICIADO_4 <> '21' AND GRUPO_VULNERABLE_BENEFICIADO_5 ='21')\n"
                + "and OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE is NOT null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Debe de capturar otro_grupo_vulnerable_beneficiado_especifique  ya que grupo_vulnerable_beneficiado es igual a "Otro grupo vulnerable (especifique)"
    public ArrayList grupo_ESPECIFIQUEND() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_PROGRAMA_SOCIAL,OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE,GRUPO_VULNERABLE_BENEFICIADO_1,GRUPO_VULNERABLE_BENEFICIADO_2,GRUPO_VULNERABLE_BENEFICIADO_3,GRUPO_VULNERABLE_BENEFICIADO_4,GRUPO_VULNERABLE_BENEFICIADO_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_GEN\n"
                + "where (GRUPO_VULNERABLE_BENEFICIADO_1 = '21' AND GRUPO_VULNERABLE_BENEFICIADO_2 = '21' AND GRUPO_VULNERABLE_BENEFICIADO_3 = '21' AND GRUPO_VULNERABLE_BENEFICIADO_4 = '21' AND GRUPO_VULNERABLE_BENEFICIADO_5 ='21')\n"
                + "and OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

 public ArrayList camposObligatoriosNull() {
    String[] camposObligatorios = {
        "ID_PROGRAMA_SOCIAL",
        "NOMBRE_PROGRAMA_SOCIAL",
        "ID_INSTITUCION_ENCARGADA_1",
        "NOMBRE_INSTITUCION_ENCARGADA_1",
        "PRESUPUESTO_EJERCIDO",
        "COND_REGLAS_LINEAMIENTOS_OPERACION",
        "COND_PADRON_PERSONAS_BENEFICIARIAS",
        "DERECHO_SOCIAL_ATENDIDO_1",
        "AMBITO_ATENCION",
        "TIPO_APOYO_ENTREGADO_1",
        "POBLACION_ATENDIDA_PERSONAS",
        "POBLACION_ATENDIDA_INSTITUCIONES",
        "POBLACION_ATENDIDA_PERSONAS_MORALES",
        "POBLACION_ATENDIDA_TERRITORIAL",
        "POBLACION_ATENDIDA_OTRO_TIPO",
        "POBLACION_ATENDIDA_NO_IDENTIFICADA",
        "GRUPO_VULNERABLE_BENEFICIADO_1"
    };

    Array = new ArrayList();

    for (String campo : camposObligatorios) {
        ejecutarValidacionCampoObligatorio(campo, Array);
    }

    return Array;
}

private void ejecutarValidacionCampoObligatorio(String campo, ArrayList<String[]> resultado) {
    conexion.Conectar();

    sql = "SELECT ID_PROGRAMA_SOCIAL, '" + campo + "' AS CAMPO_NULL "
            + "FROM TR_GF_PROG_SOCIALES_GEN "
            + "WHERE " + campo + " IS NULL";

    System.out.println(sql);
    resul = conexion.consultar(sql);

    try {
        while (resul.next()) {
            resultado.add(new String[]{
                resul.getString("ID_PROGRAMA_SOCIAL"),
                resul.getString("CAMPO_NULL")
            });
        }
        conexion.close();
    } catch (SQLException ex) {
        Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    // Detecta saltos en Instituciones Encargadas: si capturan una posicion posterior,
    // no debe quedar vacia ninguna posicion anterior de la misma seccion.
    public ArrayList instituciones_encargadas_saltos() {
        sql = "SELECT ID_PROGRAMA_SOCIAL, 'INSTITUCION_ENCARGADA_2' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE (ID_INSTITUCION_ENCARGADA_2 IS NOT NULL OR NOMBRE_INSTITUCION_ENCARGADA_2 IS NOT NULL)\n"
                + "AND (ID_INSTITUCION_ENCARGADA_1 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_1 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'INSTITUCION_ENCARGADA_3' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE (ID_INSTITUCION_ENCARGADA_3 IS NOT NULL OR NOMBRE_INSTITUCION_ENCARGADA_3 IS NOT NULL)\n"
                + "AND ((ID_INSTITUCION_ENCARGADA_1 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_1 IS NULL)\n"
                + "OR (ID_INSTITUCION_ENCARGADA_2 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_2 IS NULL))\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'INSTITUCION_ENCARGADA_4' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE (ID_INSTITUCION_ENCARGADA_4 IS NOT NULL OR NOMBRE_INSTITUCION_ENCARGADA_4 IS NOT NULL)\n"
                + "AND ((ID_INSTITUCION_ENCARGADA_1 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_1 IS NULL)\n"
                + "OR (ID_INSTITUCION_ENCARGADA_2 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_2 IS NULL)\n"
                + "OR (ID_INSTITUCION_ENCARGADA_3 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_3 IS NULL))\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'INSTITUCION_ENCARGADA_5' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE (ID_INSTITUCION_ENCARGADA_5 IS NOT NULL OR NOMBRE_INSTITUCION_ENCARGADA_5 IS NOT NULL)\n"
                + "AND ((ID_INSTITUCION_ENCARGADA_1 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_1 IS NULL)\n"
                + "OR (ID_INSTITUCION_ENCARGADA_2 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_2 IS NULL)\n"
                + "OR (ID_INSTITUCION_ENCARGADA_3 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_3 IS NULL)\n"
                + "OR (ID_INSTITUCION_ENCARGADA_4 IS NULL AND NOMBRE_INSTITUCION_ENCARGADA_4 IS NULL))";
        return ejecutarValidacionSaltos(sql);
    }

    public ArrayList derecho_social_atendido_saltos() {
        sql = "SELECT ID_PROGRAMA_SOCIAL, 'DERECHO_SOCIAL_ATENDIDO_2' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE DERECHO_SOCIAL_ATENDIDO_2 IS NOT NULL\n"
                + "AND DERECHO_SOCIAL_ATENDIDO_1 IS NULL\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'DERECHO_SOCIAL_ATENDIDO_3' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE DERECHO_SOCIAL_ATENDIDO_3 IS NOT NULL\n"
                + "AND (DERECHO_SOCIAL_ATENDIDO_1 IS NULL OR DERECHO_SOCIAL_ATENDIDO_2 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'DERECHO_SOCIAL_ATENDIDO_4' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE DERECHO_SOCIAL_ATENDIDO_4 IS NOT NULL\n"
                + "AND (DERECHO_SOCIAL_ATENDIDO_1 IS NULL OR DERECHO_SOCIAL_ATENDIDO_2 IS NULL OR DERECHO_SOCIAL_ATENDIDO_3 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'DERECHO_SOCIAL_ATENDIDO_5' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE DERECHO_SOCIAL_ATENDIDO_5 IS NOT NULL\n"
                + "AND (DERECHO_SOCIAL_ATENDIDO_1 IS NULL OR DERECHO_SOCIAL_ATENDIDO_2 IS NULL OR DERECHO_SOCIAL_ATENDIDO_3 IS NULL OR DERECHO_SOCIAL_ATENDIDO_4 IS NULL)";
        return ejecutarValidacionSaltos(sql);
    }

    public ArrayList tipo_apoyo_entregado_saltos() {
        sql = "SELECT ID_PROGRAMA_SOCIAL, 'TIPO_APOYO_ENTREGADO_2' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE TIPO_APOYO_ENTREGADO_2 IS NOT NULL\n"
                + "AND TIPO_APOYO_ENTREGADO_1 IS NULL\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'TIPO_APOYO_ENTREGADO_3' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE TIPO_APOYO_ENTREGADO_3 IS NOT NULL\n"
                + "AND (TIPO_APOYO_ENTREGADO_1 IS NULL OR TIPO_APOYO_ENTREGADO_2 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'TIPO_APOYO_ENTREGADO_4' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE TIPO_APOYO_ENTREGADO_4 IS NOT NULL\n"
                + "AND (TIPO_APOYO_ENTREGADO_1 IS NULL OR TIPO_APOYO_ENTREGADO_2 IS NULL OR TIPO_APOYO_ENTREGADO_3 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'TIPO_APOYO_ENTREGADO_5' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE TIPO_APOYO_ENTREGADO_5 IS NOT NULL\n"
                + "AND (TIPO_APOYO_ENTREGADO_1 IS NULL OR TIPO_APOYO_ENTREGADO_2 IS NULL OR TIPO_APOYO_ENTREGADO_3 IS NULL OR TIPO_APOYO_ENTREGADO_4 IS NULL)";
        return ejecutarValidacionSaltos(sql);
    }

    public ArrayList grupo_vulnerable_beneficiado_saltos() {
        sql = "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_2' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_2 IS NOT NULL AND GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_3' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_3 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_4' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_4 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_5' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_5 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_6' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_6 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_5 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_7' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_7 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_5 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_6 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_8' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_8 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_5 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_6 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_7 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_9' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_9 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_5 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_6 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_7 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_8 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_10' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_10 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_5 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_6 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_7 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_8 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_9 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_11' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_11 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_5 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_6 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_7 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_8 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_9 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_10 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_12' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_12 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_5 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_6 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_7 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_8 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_9 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_10 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_11 IS NULL)\n"
                + "UNION ALL\n"
                + "SELECT ID_PROGRAMA_SOCIAL, 'GRUPO_VULNERABLE_BENEFICIADO_13' COMENTARIOS FROM TR_GF_PROG_SOCIALES_GEN\n"
                + "WHERE GRUPO_VULNERABLE_BENEFICIADO_13 IS NOT NULL AND (GRUPO_VULNERABLE_BENEFICIADO_1 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_2 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_3 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_4 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_5 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_6 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_7 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_8 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_9 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_10 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_11 IS NULL OR GRUPO_VULNERABLE_BENEFICIADO_12 IS NULL)";
        return ejecutarValidacionSaltos(sql);
    }

    private ArrayList ejecutarValidacionSaltos(String sql) {
        ArrayList<String[]> resultado = new ArrayList();
        conexion.Conectar();
        System.out.println(sql);
        resul = conexion.consultar(sql);

        try {
            while (resul.next()) {
                resultado.add(new String[]{
                    resul.getString("ID_PROGRAMA_SOCIAL"),
                    resul.getString("COMENTARIOS")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
}
