    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.LeeSQLSERVER_SENAP;

import Pantallas_SENAP.IntegraTMP;
import java.awt.Color;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import mx.org.inegi.conexion.SENAP.ConDinamicSQLSERVER;

/**
 *
 * @author ANTONIO.CORIA
 */
public class QueryTMPSENAP {

    ConDinamicSQLSERVER conexion = new ConDinamicSQLSERVER();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<ArrayList<String>> arrayList = new ArrayList<>();

    public ArrayList<ArrayList<String>> DBO_NoticiaCriminal() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_NoticiaCriminal'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) { ///MIENTRAS EXISTA EL NOMBRE DE LA TABLA EN BD
            sql = "SELECT * FROM SENAP_NoticiaCriminal";
            resul = conexion.consultar(sql);
            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_NoticiaCriminal" + ex);

            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {         
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla 'SENAP_NoticiaCriminal'</b></u></p> en base de datos origen</html>");
         
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Atenciones() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Atenciones'";
        resul = conexion.consultar(sql);
        if (resul.next()) { ///MIENTRAS EXISTA EL NOMBRE DE LA TABLA EN BD      
            sql = "SELECT * FROM SENAP_Atenciones";
            System.out.println(sql);
            resul = conexion.consultar(sql);
            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Atenciones" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {         
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Atenciones'</b></u></p> en base de datos origen</html>");
         
            try {
                if (resul != null) {
                    resul.close();
                }
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_CarpetaInvestigacion() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_CarpetaInvestigacion'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_CarpetaInvestigacion";
            System.out.println(sql);
            resul = conexion.consultar(sql);
            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(28)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(29)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(30)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(31)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(32)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(33)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(34)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_CarpetaInvestigacion" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_CarpetaInvestigacion'</b></u></p> en base de datos origen</html>");
            
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_DireccionUbicacion() throws SQLException {

        System.out.println("Integrando Dirección ubicación a BD TMP" + IntegraTMP.BDSQL);
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_DireccionUbicacion'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_DireccionUbicacion";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_DireccionUbicacion" + ex);
                
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_DireccionUbicacion'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Aseguramientos() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Aseguramientos'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Aseguramientos";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                   // fila.add(resul.getString(15)); // Añadir la quinceava columna
                   // fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                   // fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                   // fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                   // fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                  //  fila.add(resul.getString(20)); // Añadir la veinteava columna
                  //  fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Aseguramientos" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Aseguramientos'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Actosinvestigacion() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_ActosInvestigacion'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Actosinvestigacion";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Actosinvestigacion" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
           JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Actosinvestigacion'</b></u></p> en base de datos origen</html>");
           try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Delitos() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Delitos'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Delitos";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(28)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(29)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(30)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Delitos" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Delitos'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Victimas() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Victimas'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Victimas";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(28)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(29)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(30)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(31)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(32)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(33)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(34)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(35)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(36)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(37)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(38)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(39)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(40)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(41)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(42)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(43)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(44)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(45)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(46)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(47)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(48)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(49)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Victimas" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Victimas'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_VictimasDelito() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_VictimasDelito'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_VictimasDelito";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_VictimasDelito" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
           JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_VictimasDelito'</b></u></p> en base de datos origen</html>"); 
           try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Medidas_Proteccion() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Medidas_Proteccion'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Medidas_Proteccion";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Medidas_Proteccion" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Medidas_Proteccion'</b></u></p> en base de datos origen</html>"); 
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Imputado() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Imputado'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Imputado";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    fila.add(resul.getString(22)); // Añadir la veintidosava columna
                    fila.add(resul.getString(23)); // Añadir la veintitresava columna
                    fila.add(resul.getString(24)); // Añadir la veinticuatroava columna
                    fila.add(resul.getString(25)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(26)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(27)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(28)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(29)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(30)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(31)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(32)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(33)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(34)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(35)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(36)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(37)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(38)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(39)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(40)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(41)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(42)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(43)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(44)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(45)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(46)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(47)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(48)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(49)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(50)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(51)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(52)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(53)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(54)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(55)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(56)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(57)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(58)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(59)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(60)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(61)); // Añadir la veinticincoava columna
                    fila.add(resul.getString(62)); // Añadir la veinticincoava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Imputado" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Imputado'</b></u></p> en base de datos origen</html>"); 
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_ImputadoDelito() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_ImputadoDelito'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_ImputadoDelito";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_ImputadoDelito" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_ImputadoDelito'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_VictimaImputado() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_VictimaImputado'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_VictimaImputado";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la doceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_VictimaImputado" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_VictimaImputado'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Determinacion() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Determinacion'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Determinacion";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la doceava columna
                    fila.add(resul.getString(14));
                    fila.add(resul.getString(15));
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Determinacion" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Determinacion'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_PROCESO() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Proceso'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Proceso";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                    fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                    fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                    fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                    fila.add(resul.getString(20)); // Añadir la veinteava columna
                    fila.add(resul.getString(21)); // Añadir la veintiunava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Proceso" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Proceso'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_MandamientosJudiciales() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_MandamientosJudiciales'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_MandamientosJudiciales";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_MandamientosJudiciales" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_MandamientosJudiciales'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_InvestigacionComplementaria() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_InvestigacionComplementaria'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_InvestigacionComplementaria";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la quinceava columna
                    fila.add(resul.getString(17)); // Añadir la quinceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_InvestigacionComplementaria" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_InvestigacionComplementaria'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_MedidasCautelares() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_MedidasCautelares'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_MedidasCautelares";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_MedidasCautelares" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_MedidasCautelares'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_EtapaInvestigacion() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_EtapaInvestigacion'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_EtapaInvestigacion";
            System.out.println(sql);
            resul = conexion.consultar(sql);
            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_EtapaInvestigacion" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;

        } else {
         JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_EtapaInvestigacion'</b></u></p> en base de datos origen</html>");
         try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_EtapaIntermedia() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_EtapaIntermedia'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_EtapaIntermedia";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la quinceava columna
                    fila.add(resul.getString(17)); // Añadir la quinceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_EtapaIntermedia" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
           JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_EtapaIntermedia'</b></u></p> en base de datos origen</html>");
           try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Masc() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_MASC'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Masc";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la quinceava columna
                    fila.add(resul.getString(16)); // Añadir la quinceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Masc" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Masc'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Sobreseimiento() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Sobreseimiento'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Sobreseimiento";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Sobreseimiento" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Sobreseimiento'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_SuspensionCondicional() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_SuspensionCondicional'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_SuspensionCondicional";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la catorceava columna
                    fila.add(resul.getString(16)); // Añadir la catorceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_SuspensionCondicional" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_SuspensionCondicional'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_Sentencia() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_Sentencia'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_Sentencia";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    fila.add(resul.getString(7)); // Añadir la séptima columna
                    fila.add(resul.getString(8)); // Añadir la octava columna
                    fila.add(resul.getString(9)); // Añadir la novena columna
                    fila.add(resul.getString(10)); // Añadir la décima columna
                    fila.add(resul.getString(11)); // Añadir la onceava columna
                    fila.add(resul.getString(12)); // Añadir la doceava columna
                    fila.add(resul.getString(13)); // Añadir la treceava columna
                    fila.add(resul.getString(14)); // Añadir la catorceava columna
                    fila.add(resul.getString(15)); // Añadir la catorceava columna
                    fila.add(resul.getString(16)); // Añadir la catorceava columna
                    fila.add(resul.getString(17)); // Añadir la catorceava columna
                    fila.add(resul.getString(18)); // Añadir la catorceava columna
                    fila.add(resul.getString(19)); // Añadir la catorceava columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_Sentencia" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_Sentencia'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    public ArrayList<ArrayList<String>> DBO_DelitoRelacion() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_DelitoRelacion'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_DelitoRelacion";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    fila.add(resul.getString(5)); // Añadir la quinta columna
                    fila.add(resul.getString(6)); // Añadir la sexta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_DelitoRelacion" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_DelitoRelacion'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    }
        
    public ArrayList<ArrayList<String>> DBO_SentidoDeterminacionRelacion() throws SQLException {
        conexion.Conectar(IntegraTMP.BDSQL);
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SENAP_DelitoRelacion'";
        ResultSet resul = conexion.consultar(sql);
        if (resul.next()) {
            sql = "SELECT * FROM SENAP_SentidoDeterminacionRelacion";
            System.out.println(sql);
            resul = conexion.consultar(sql);

            try {
                while (resul.next()) {
                    ArrayList<String> fila = new ArrayList<>();
                    fila.add(resul.getString(1)); // Añadir la primera columna
                    fila.add(resul.getString(2)); // Añadir la segunda columna
                    fila.add(resul.getString(3)); // Añadir la tercera columna
                    fila.add(resul.getString(4)); // Añadir la cuarta columna
                    arrayList.add(fila); // Agregar la fila a la lista principal
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueryTMPSENAP.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al leer la tabla SENAP_SentidoDeterminacionRelacion" + ex);
            } finally {
                try {
                    if (resul != null) {
                        resul.close();
                    }
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:#FF0000\";><u><b>¡ALERTA!: NO EXISTE tabla "
                    + "'SENAP_SentidoDeterminacionRelacion'</b></u></p> en base de datos origen</html>");
            try {
                resul.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            return null;
        }
    
   

    }
        
    }