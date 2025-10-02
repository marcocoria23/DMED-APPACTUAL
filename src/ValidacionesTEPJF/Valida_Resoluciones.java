/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesTEPJF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.TEPJF.DaoConexionTEPJF;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Valida_Resoluciones {

    DaoConexionTEPJF conexion = new DaoConexionTEPJF();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
       
        //Id_Resoluciones se encuentra duplicado
     public ArrayList ID_RESOLUCIONES_DUP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(ID_RESOLUCIONES_EXTRACTED)ID_unico,ID_TEPJF_EXPEDIENTE FROM (\n" +
"SELECT \n" +
"    ID_TEPJF_EXPEDIENTE,\n" +
"    SUBSTR(\n" +
"        ID_TEPJF_RESOLUCIONES,\n" +
"        INSTR(ID_TEPJF_RESOLUCIONES, 'TEMP-') + 5,\n" +
"        INSTR(ID_TEPJF_RESOLUCIONES, '-', -1) - (INSTR(ID_TEPJF_RESOLUCIONES, 'TEMP-') + 5)\n" +
"    ) AS ID_RESOLUCIONES_EXTRACTED\n" +
"FROM \n" +
"    TR_TEPJF_RESOLUCIONES\n" +
"WHERE \n" +
"    ID_TEPJF_RESOLUCIONES LIKE '%TEMP%')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_RESOLUCIONES"),
                   resul.getString("ID_unico")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

    //EL ID_EXPEDIENTE NO SE ENCUENTRA EN TABLA EXPEDIENTES
    public ArrayList ID_EXPE_REL() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " select  ac.ID_TEPJF_EXPEDIENTE,ac.ID_TEPJF_resoluciones from tr_tepjf_expediente expe \n"
                + "        left join tr_tepjf_resoluciones ac on ac.ID_TEPJF_EXPEDIENTE=expe.ID_TEPJF_EXPEDIENTE\n"
                + "        where expe.ID_TEPJF_EXPEDIENTE is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ESTATUS_EXP de la tabla EXPEDIENTE debe estar como Concluido
    public ArrayList CONCLUIDO() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select reso.ID_TEPJF_EXPEDIENTE, reso.ID_TEPJF_RESOLUCIONES,expe.ID_ESTATUS_EXP,reso.OBSERVACIONES from TR_TEPJF_RESOLUCIONES reso \n"
                + "inner JOIN TR_TEPJF_EXPEDIENTE expe on expe.ID_TEPJF_EXPEDIENTE=reso.ID_TEPJF_EXPEDIENTE\n"
                + "where expe.ID_ESTATUS_EXP <>2";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //CAMPO FECHA_RESOL es obligatorio
    public ArrayList FECHA_RESOL() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,FECHA_RESOL,OBSERVACIONES  from TR_TEPJF_RESOLUCIONES   where FECHA_RESOL  is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //FECHA_RESOL_ENTRE Debe estar comprendida dentro del periodo transcurrido entre la fecha de ingreso del expediente y su fecha de ingreso a archivo, registradas en la tabla "Control_expediente"
    public ArrayList FECHA_RESOL_ENTRE() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select reso.ID_TEPJF_EXPEDIENTE, reso.ID_TEPJF_RESOLUCIONES, to_char(reso.FECHA_RESOL,'DD/MM/YYYY') FECHA_RESOL,\n"
                + "to_char(expe.FECHA_INGRESO,'DD/MM/YYYY')FECHA_INGRESO,to_char(expe.FECHA_ING_ARCHIVO,'DD/MM/YYYY')FECHA_ING_ARCHIVO,reso.OBSERVACIONES \n"
                + "from TR_TEPJF_RESOLUCIONES reso inner JOIN TR_TEPJF_EXPEDIENTE expe on expe.ID_TEPJF_EXPEDIENTE=reso.ID_TEPJF_EXPEDIENTE\n"
                + "where TO_DATE(reso.FECHA_RESOL) not BETWEEN  TO_DATE(expe.FECHA_INGRESO) and TO_DATE(expe.FECHA_ING_ARCHIVO)";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("FECHA_RESOL"),
                    resul.getString("FECHA_INGRESO"),
                    resul.getString("FECHA_ING_ARCHIVO"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //CAMPO TP_SESION es obligatorio
    public ArrayList TP_SESION() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES  from TR_TEPJF_RESOLUCIONES   where TP_SESION  is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //CAMPO TP_RESOLUCION es obligatorio
    public ArrayList TP_RESOLUCION() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES  from TR_TEPJF_RESOLUCIONES   where TP_RESOLUCION  is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede tener como valor 'Sentencia' si se seleccionó la categoría "Fuera de circunscripción" en la columna entidad_federativa de la tabla expediente
    public ArrayList TP_RESOLUCION_SENTENCIA() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select reso.ID_TEPJF_EXPEDIENTE, reso.ID_TEPJF_RESOLUCIONES, expe.ID_AGEE,expe.DES_AGEE, reso.tp_resolucion,reso.OBSERVACIONES---34 id agee y 1 tp resolucion\n"
                + "from TR_TEPJF_RESOLUCIONES reso inner JOIN TR_TEPJF_EXPEDIENTE expe on expe.ID_TEPJF_EXPEDIENTE=reso.ID_TEPJF_EXPEDIENTE\n"
                + "where reso.tp_resolucion=1 and expe.ID_AGEE=34";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe de capturar Campo OTRO_TP_RESOLUCION ya que TP_RESOLUCION es igual a 'Otra resolución (especifique)'
    public ArrayList OTRO_TP_RESOLUCION_CAP() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where TP_RESOLUCION=3 and OTRO_TP_RESOLUCION is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No Debe de capturar Campo OTRO_TP_RESOLUCION ya que TP_RESOLUCION es diferente a 'otra resolucion'
    public ArrayList OTRO_TP_RESOLUCION() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where TP_RESOLUCION<>3 and OTRO_TP_RESOLUCION is not null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Campo TP_RESOLUCION_F es obligatorio
    public ArrayList TP_RESOLUCION_F() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES  from TR_TEPJF_RESOLUCIONES   where TP_RESOLUCION_F  is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe de capturar Campo SENTIDO_RESOLUCION_F ya que TP_RESOLUCION_F es igual a 'Resuelto de fondo'
    public ArrayList SENTIDO_RESOLUCION_F_CAP() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where TP_RESOLUCION_F=1 and SENTIDO_RESOLUCION_F is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No Debe de capturar Campo SENTIDO_RESOLUCION_F ya que TP_RESOLUCION_F no es igual a 'Resuelto de fondo'
    public ArrayList SENTIDO_RESOLUCION_F() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where TP_RESOLUCION_F<>1 and SENTIDO_RESOLUCION_F is not null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe de capturar Campo OTRO_SENTIDO_RESOLUCION_F ya que SENTIDO_RESOLUCION_F es igual a 'otra resolucion de fondo'
    public ArrayList OTRO_SENTIDO_RESOLUCION_F_CAP() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
            + "where SENTIDO_RESOLUCION_F=5 and otro_sentido_resolucion_f is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No debe de capturar Campo OTRO_SENTIDO_RESOLUCION_F ya que SENTIDO_RESOLUCION_F es diferente a 'otra resolucion de fondo'
    public ArrayList OTRO_SENTIDO_RESOLUCION_F() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where SENTIDO_RESOLUCION_F<>5 and otro_sentido_resolucion_f is not null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe de capturar Campo SENTIDO_RESOLUCION_NF ya que TP_RESOLUCION_F es igual a 'No resuelto de fondo'
    public ArrayList SENTIDO_RESOLUCION_NF_CAP() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where TP_RESOLUCION_F=2 and SENTIDO_RESOLUCION_NF is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No debe de capturar Campo SENTIDO_RESOLUCION_NF ya que TP_RESOLUCION_F es diferente a 'No resuelto de fondo'
    public ArrayList SENTIDO_RESOLUCION_NF() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where TP_RESOLUCION_F<>2 and SENTIDO_RESOLUCION_NF is not  null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No puede tener como valor "Competencia de otra sala" si no se seleccionó la categoría "Fuera de circunscripción" en la columna entitdad federativa de la tabla Control_expediente.
    public ArrayList SENTIDO_RESOLUCION_NF_COM() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select reso.ID_TEPJF_EXPEDIENTE, reso.ID_TEPJF_RESOLUCIONES, reso.OBSERVACIONES---34 id agee y 7 sentido_resolucion_nf\n"
                + "from TR_TEPJF_RESOLUCIONES reso inner JOIN TR_TEPJF_EXPEDIENTE expe on expe.ID_TEPJF_EXPEDIENTE=reso.ID_TEPJF_EXPEDIENTE\n"
                + "where reso.sentido_resolucion_nf=7 and expe.ID_AGEE=34";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe de capturar Campo OTRO_SENTIDO_RESOLUCION_NF ya que SENTIDO_RESOLUCION_NF es igual a 'otra resolucion de no fondo'
    public ArrayList OTRO_SENTIDO_RESOLUCION_NF_CAP() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where sentido_resolucion_nf=8 and otro_sentido_resolucion_nf is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //No debe de capturar Campo OTRO_SENTIDO_RESOLUCION_NF ya que SENTIDO_RESOLUCION_NF es diferente a 'otra resolucion de no fondo'
    public ArrayList OTRO_SENTIDO_RESOLUCION_NF() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES from TR_TEPJF_RESOLUCIONES\n"
                + "where sentido_resolucion_nf<>8 and otro_sentido_resolucion_nf is not null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Campo DURACION_PROCESO Obligatorio
    public ArrayList DURACION_PROCESO() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES  from TR_TEPJF_RESOLUCIONES   where DURACION_PROCESO  is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Campo COND_IMPUGN Obligatorio
    public ArrayList COND_IMPUGN() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES  from TR_TEPJF_RESOLUCIONES   where COND_IMPUGN  is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // Campo FECHA_ACUERDO_CUMPL Obligatorio
    public ArrayList FECHA_ACUERDO_CUMPL() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESOLUCIONES,OBSERVACIONES  from TR_TEPJF_RESOLUCIONES   where FECHA_ACUERDO_CUMPL  is null";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("OBSERVACIONES")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // FECHA_ACUERDO_CUMPL Debe estar comprendida dentro del periodo transcurrido entre la fecha_Resol y su FECHA_ING_ARCHIVO, registradas en la tabla "resoluciones" y "Control_expediente", respectivamente.
    public ArrayList FECHA_ACUERDO_CUMPL_COMPREND() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " select reso.ID_TEPJF_EXPEDIENTE, reso.ID_TEPJF_RESOLUCIONES,\n"
                + "to_char(reso.FECHA_RESOL,'DD/MM/YYYY')FECHA_RESOL, \n"
                + "to_char(reso.FECHA_ACUERDO_CUMPL,'DD/MM/YYYY')FECHA_ACUERDO_CUMPL, \n"
                + "to_char(expe.FECHA_ING_ARCHIVO,'DD/MM/YYYY')FECHA_ING_ARCHIVO,\n"
                + "RESO.OBSERVACIONES\n"
                + "from tr_TEPJF_RESOLUCIONES \n"
                + " reso inner JOIN TR_TEPJF_EXPEDIENTE expe on expe.ID_TEPJF_EXPEDIENTE=reso.ID_TEPJF_EXPEDIENTE\n"
                + " where TO_DATE(reso.FECHA_ACUERDO_CUMPL)  BETWEEN  TO_DATE(reso.FECHA_RESOL) and TO_DATE(expe.FECHA_ING_ARCHIVO)";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_TEPJF_EXPEDIENTE"),
                    resul.getString("ID_TEPJF_resoluciones"),
                    resul.getString("FECHA_RESOL"),
                    resul.getString("FECHA_ACUERDO_CUMPL"),
                    resul.getString("FECHA_ING_ARCHIVO"),
                    resul.getString("OBSERVACIONES")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
