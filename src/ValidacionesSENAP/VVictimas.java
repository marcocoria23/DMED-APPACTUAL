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
public class VVictimas {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //ReglaDMED. EDADMOMENTOSUCEDIERONHECHOS-(Edad al momento que sucedieron los hechos) No debe ser Menor a -1
    public ArrayList EDADMENOR1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM RES_TR_SENAP_VICTIMAS\n"
                + "WHERE EDADMOMSUCHEC < -1  AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verificar EDADMOMENTOSUCEDIERONHECHOS-Edad al momento que sucedieron los hechos ya qye es mayor a 106 años
    public ArrayList EDADHECHOS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT VICTIMAID,EDADMOMSUCHEC FROM RES_TR_SENAP_VICTIMAS\n"
                + "WHERE EDADMOMSUCHEC>106 and (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La relación entre los campos  CatEntidadFederativaID (Entidad) y CATMUNICIPIOID (Municipio) de la plantilla Victimas, no coinciden con la relación de los campos CATENTIDADFEDERATIVAID y CATMUNICIPIODEMARCACIONTERRITORIALID del catálogo SENAP_MUNICIPIODEMARCACIONTERRITOR
    public ArrayList RelacionMunicipio(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (\n"
                + "select UBICACIONID,CATDEMARCACIONID, CATENTFEDID,CATSUBPROREFID, tc.CATMUNICIPIODEMARCACIONTERRITORIALID as catalogo, ub.periodo, ub.ENTIDADID from RES_tr_senap_direccionubicacion ub\n"
                + "left join TC_SENAP_MUNICIPIODEMARCACIONTERRITOR tc on tc.CATMUNICIPIODEMARCACIONTERRITORIALID=ub.CATDEMARCACIONID and tc.catentidadfederativaid=ub.CATENTFEDID)\n"
                + "where catalogo is null  AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "') and  CATSUBPROREFID=5";
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

    //ReglaDMED. La relación entre los campos  CatEntidadFederativa(Entidad DE NACIMIENTO) y CATMUNICIPIOID (Municipio DE NACIMIENTO) de la plantilla Victimas, no coinciden con la relación de los campos CATENTIDADFEDERATIVAID y CATMUNICIPIODEMARCACIONTERRITORIALID del catálogo SENAP_MUNICIPIODEMARCACIONTERRITOR
    public ArrayList RelacionMunicipioNacimiento(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select * from (\n"
                + "select victimaID, CARPETAID,DIRECCIONUBICACIONID,CATMUNICIPIOID, CATENTIDADNACIMIENTOID, tc.CATMUNICIPIODEMARCACIONTERRITORIALID as catalogo, vic.periodo, vic.ENTIDADID from RES_TR_SENAP_VICTIMAS vic\n"
                + "left join TC_SENAP_MUNICIPIODEMARCACIONTERRITOR tc on tc.CATMUNICIPIODEMARCACIONTERRITORIALID=vic.CATMUNICIPIOID and tc.catentidadfederativaid=vic.CATENTIDADNACIMIENTOID)\n"
                + "where catalogo is null and (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.10. Si en el campo Tipo de víctima (columna F), es requisitado con el valor “Persona moral del sector público, Persona moral del sector privado o Persona moral no identificado”, se deberá permitir únicamente el registro de los campos ¿Contó con asesor jurídico? (columna AY) y Tipo de asesor jurídico (columna AZ) no podran venir vacios
    public ArrayList CATTIPOVICTIMAID(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,\n"
                + "CATTIPOVICTIMAID,CONTOASESORJURIDICO,CATTIPOASESORJURIDICOID\n"
                + "from RES_tr_senap_victimas\n"
                + "where CATTIPOVICTIMAID in (2,3,4) and (CONTOASESORJURIDICO is null or CATTIPOASESORJURIDICOID is null) AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.11. Si el campo Tipo de víctima corresponde a Persona física (1), deberá estar inscrita información en todos los campos de esta plantilla.
    public ArrayList CATTIPOVICTIMAID1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,\n"
                + "CATTIPOVICTIMAID, CURP, FECHANACIMIENTO, EDADMOMSUCHEC, CATSEXOID, CATSITUACIONCONYUGALID, VESTIMENTARASGOSVISIBLES, CATNACIONALIDADID, CATSITUACIONMIGRATORIAID, CATPAISNACIMIENTOID, CATENTIDADNACIMIENTOID, CATMUNICIPIOID, CATPAISRESHAB, DIRECCIONUBICACIONID, NUMEROTELEFONICO, HABLAESPANIOL, HABLALENGUAEXTRANJERA, CATTIPLEGEXT, HABLALENGUAINDIGENA, CATTIPOLENGUAINDIGENAID, UTITRAINT, PRESENTADISCAPACIDAD, CATTIPODISCAPACIDADID, MEDIOTECDISCAPACIDAD, PERPOPIND, CATTIPPOPIND, PERPOBLGBTTTI, CATTIPOLGBTTTIID, PERPOBSITCALLE, SABELEERESCRIBIR, CATNIVELESCOLARIDADID, CATOCUPACIONID, RANINGMENNET, HECANTVICMANSUFVIOL, CONTOASESORJURIDICO, CATTIPOASESORJURIDICOID, RECIBIOATENCIONMEDICA, RECATEPSICO, CARPETAID_FISCALIA\n"
                + "from RES_tr_senap_victimas\n"
                + "where CATTIPOVICTIMAID in (1) and (\n"
                + "CURP is null or\n"
                + "FECHANACIMIENTO is null or\n"
                + "EDADMOMSUCHEC is null or\n"
                + "CATSEXOID is null or\n"
                + "CATSITUACIONCONYUGALID is null or\n"
                + "VESTIMENTARASGOSVISIBLES is null or\n"
                + "CATNACIONALIDADID is null or\n"
                + "CATSITUACIONMIGRATORIAID is null or\n"
                + "CATPAISNACIMIENTOID is null or\n"
                + "CATENTIDADNACIMIENTOID is null or\n"
                + "CATMUNICIPIOID is null or\n"
                + "CATPAISRESHAB is null or\n"
                + "DIRECCIONUBICACIONID is null or\n"
                + "NUMEROTELEFONICO is null or\n"
                + "HABLAESPANIOL is null or\n"
                + "HABLALENGUAEXTRANJERA is null or\n"
                + "CATTIPLEGEXT is null or\n"
                + "HABLALENGUAINDIGENA is null or\n"
                + "CATTIPOLENGUAINDIGENAID is null or\n"
                + "UTITRAINT is null or\n"
                + "PRESENTADISCAPACIDAD is null or\n"
                + "CATTIPODISCAPACIDADID is null or\n"
                + "MEDIOTECDISCAPACIDAD is null or\n"
                + "PERPOPIND is null or\n"
                + "CATTIPPOPIND is null or\n"
                + "PERPOBLGBTTTI is null or\n"
                + "CATTIPOLGBTTTIID is null or\n"
                + "PERPOBSITCALLE is null or\n"
                + "SABELEERESCRIBIR is null or\n"
                + "CATNIVELESCOLARIDADID is null or\n"
                + "CATOCUPACIONID is null or\n"
                + "RANINGMENNET is null or\n"
                + "HECANTVICMANSUFVIOL is null or\n"
                + "CONTOASESORJURIDICO is null or\n"
                + "CATTIPOASESORJURIDICOID is null or\n"
                + "RECIBIOATENCIONMEDICA is null or\n"
                + "RECATEPSICO is null or\n"
                + "CARPETAID_FISCALIA is null ) AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.4. Si el campo ¿Habla lengua extranjera? (columna AG) es requisitado con la opción “Si”, el campo Tipo de lengua extranjera (columna AH) no debera de venir vacia.
    public ArrayList HABLALENGUAEXTRANJERA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,HABLALENGUAEXTRANJERA,CATTIPLEGEXT\n"
                + "from RES_tr_senap_victimas\n"
                + "where HABLALENGUAEXTRANJERA=1 and CATTIPLEGEXT is null \n"
                + "AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.4. Si el campo ¿Habla lengua extranjera? (columna AG) es diferente de la opción “Si”, el campo Tipo de lengua extranjera (columna AH) no debera de venir con valor.
    public ArrayList CATTIPLEGEXT(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,HABLALENGUAEXTRANJERA,CATTIPLEGEXT\n"
                + "from RES_tr_senap_victimas\n"
                + "where HABLALENGUAEXTRANJERA<>1 and CATTIPLEGEXT is  not null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.5. Si el campo ¿Habla lengua indígena? (columna AI) es requisitado con la opción “Si”, el campo Tipo de lengua indígena (columna AJ) no debera venir vacio.
    public ArrayList CATTIPOLENGUAINDIGENAID(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,HABLALENGUAINDIGENA,CATTIPOLENGUAINDIGENAID\n"
                + "from RES_tr_senap_victimas\n"
                + "where HABLALENGUAINDIGENA=1 and CATTIPOLENGUAINDIGENAID is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.5. Si el campo ¿Habla lengua indígena? (columna AI) es diferente de la opción “Si”, el campo Tipo de lengua indígena (columna AJ) no debera venir con valor.
    public ArrayList CATTIPOLENGUAINDIGENAID1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,HABLALENGUAINDIGENA,CATTIPOLENGUAINDIGENAID\n"
                + "from RES_tr_senap_victimas\n"
                + "where HABLALENGUAINDIGENA<>1 and CATTIPOLENGUAINDIGENAID is  not null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.6. Si el campo ¿Presenta algún tipo de discapacidad? (columna AL) es requisitado con la opción “Si”, los campos Condición de discapacidad (columna AM) y ¿Utilizó intérprete y/o medio tecnológico por discapacidad? (columna AN) no pueden venir vacios
    public ArrayList PRESENTADISCAPACIDAD(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,PRESENTADISCAPACIDAD,CATTIPODISCAPACIDADID,MEDIOTECDISCAPACIDAD\n"
                + "from RES_tr_senap_victimas\n"
                + "where PRESENTADISCAPACIDAD=1 and (CATTIPODISCAPACIDADID is null or MEDIOTECDISCAPACIDAD is null) AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.6. Si el campo ¿Presenta algún tipo de discapacidad? (columna AL) es diferente de la opción “Si”, los campos Condición de discapacidad (columna AM) y ¿Utilizó intérprete y/o medio tecnológico por discapacidad? (columna AN) no pueden venir con valor
    public ArrayList CATTIPODISCAPACIDADID(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,PRESENTADISCAPACIDAD,CATTIPODISCAPACIDADID,MEDIOTECDISCAPACIDAD\n"
                + "from RES_tr_senap_victimas\n"
                + "where PRESENTADISCAPACIDAD<>1 and (CATTIPODISCAPACIDADID is not null or MEDIOTECDISCAPACIDAD is not null) AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.7. Si el campo ¿Pertenece a alguna población indígena? (columna AO) es requisitado con la opción “Si”, el campo Población indígena a la que pertenece (columna AP) no puede venir vacio.
    public ArrayList PERPOPIND(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,PERPOPIND,CATTIPPOPIND\n"
                + "from RES_tr_senap_victimas\n"
                + "where PERPOPIND=1 and CATTIPPOPIND is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.7. Si el campo ¿Pertenece a alguna población indígena? (columna AO) es diferente de la opción “Si”, el campo Población indígena a la que pertenece (columna AP) no puede venir con valor.
    public ArrayList CATTIPPOPIND(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,PERPOPIND,CATTIPPOPIND\n"
                + "from RES_tr_senap_victimas\n"
                + "where PERPOPIND<>1 and CATTIPPOPIND is not null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.8. Si el campo ¿Pertenece a alguna población LGBTTTI? (columna AQ) es requisitado con la opción “Si”, el campo Población LGBTTTI a la que pertenece (columna AR) no podra venir vacio.
    public ArrayList PERPOBLGBTTTI(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,PERPOBLGBTTTI,CATTIPOLGBTTTIID\n"
                + "from RES_tr_senap_victimas\n"
                + "where PERPOBLGBTTTI=1 and CATTIPOLGBTTTIID is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.8. Si el campo ¿Pertenece a alguna población LGBTTTI? (columna AQ) es diferente de  la opción “Si”, el campo Población LGBTTTI a la que pertenece (columna AR) no puede traer valor.
    public ArrayList CATTIPOLGBTTTIID(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,PERPOBLGBTTTI,CATTIPOLGBTTTIID\n"
                + "from RES_tr_senap_victimas\n"
                + "where PERPOBLGBTTTI<>1 and CATTIPOLGBTTTIID is not null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.9. Si el campo ¿Contó con asesor jurídico?  (columna AY) es requisitado con la opción “Si”, el campo Tipo de asesor jurídico (columna AZ) no podra venir vacio.
    public ArrayList CONTOASESORJURIDICO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,CONTOASESORJURIDICO,CATTIPOASESORJURIDICOID\n"
                + "from RES_tr_senap_victimas\n"
                + "where CONTOASESORJURIDICO=1 and CATTIPOASESORJURIDICOID is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.9. Si el campo ¿Contó con asesor jurídico?  (columna AY) es diferente de la opción “Si”, el campo Tipo de asesor jurídico (columna AZ) no podra venir con valor.
    public ArrayList CATTIPOASESORJURIDICOID(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO,CONTOASESORJURIDICO,CATTIPOASESORJURIDICOID\n"
                + "from RES_tr_senap_victimas\n"
                + "where CONTOASESORJURIDICO<>1 and CATTIPOASESORJURIDICOID is not null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHANACIMIENTO (Fecha de nacimiento) no debe ser mayor a la fecha Actual 
    public ArrayList FECHANACIMIENTOMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,VICTIMAID,PERIODO\n"
                + "FROM RES_TR_SENAP_VICTIMAS\n"
                + "WHERE FECHANACIMIENTO > SYSDATE  AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verificar la FECHANACIMIENTO (Fecha de nacimiento) ya que es mayor a 109 años de Edad. 6.3
    public ArrayList FECHANACIMIENTEDADOMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM(\n"
                + "SELECT ENTIDADID,VICTIMAID,PERIODO,\n"
                + "EXTRACT (YEAR FROM SYSDATE) \n"
                + "- \n"
                + "EXTRACT (YEAR FROM FECHANACIMIENTO)  as años_actual,FECHANACIMIENTO\n"
                + "FROM RES_TR_SENAP_VICTIMAS)\n"
                + "WHERE años_actual > 110 AND (FECHANACIMIENTO<>'01/01/1900')  AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 6.3. El campo Edad al momento que sucedieron los hechos (columna I), deberá ser menor o igual a la edad calculada a partir del campo Fecha de nacimiento (columna H), con respecto a la fecha actual. 
    public ArrayList EDADMOMSUCHEC(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, VICTIMAID, CARPETAID, PERIODO, EDADMOMSUCHEC, años_actual,FECHANACIMIENTO from (\n"
                + "SELECT\n"
                + "ENTIDADID, VICTIMAID, CARPETAID, PERIODO,\n"
                + "EDADMOMSUCHEC,\n"
                + "EXTRACT (YEAR FROM SYSDATE)\n"
                + "-\n"
                + "EXTRACT (YEAR FROM FECHANACIMIENTO)  as años_actual,FECHANACIMIENTO \n"
                + "FROM \n"
                + "RES_tr_senap_victimas) where EDADMOMSUCHEC>años_actual AND (FECHANACIMIENTO<>'01/01/1900')  AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VVictimas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDEMED. Favor de verificar el campo Tipo de víctima CATTIPOVICTIMAID debido a que no se puede seleccionar una opción diferente a "Persona física" (1), "Persona moral del sector público" (2), "Persona moral del sector privado" (3), "Persona moral no identificado" (4), "Otro" (5) y "No identificado" (6).
    public ArrayList TIPOVICTIMAnotnull(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,PERIODO, VICTIMAID, CARPETAID, CATTIPOVICTIMAID\n"
                + "from RES_TR_SENAP_VICTIMAS\n"
                + "where CATTIPOVICTIMAID not in (1,2,3,4,5,9) or CATTIPOVICTIMAID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verificar el campo Fecha de nacimiento FECHANACIMIENTO debido que a que no puede venir nulo.
    public ArrayList TIPOVICTIMA122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,PERIODO, VICTIMAID, CARPETAID, FECHANACIMIENTO\n"
                + "from RES_TR_SENAP_VICTIMAS\n"
                + "where FECHANACIMIENTO is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verificar el campo Edad al momento que sucedieron los hechos  EDADMOMSUCHEC debido que a que no puede venir nulo.
    public ArrayList Edad122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,PERIODO, VICTIMAID, CARPETAID, EDADMOMSUCHEC\n"
                + "from RES_TR_SENAP_VICTIMAS\n"
                + "where EDADMOMSUCHEC is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verificar el campo Sexo CATSEXOID debido a que no se puede seleccionar una opción diferente a "Hombre" (1), "Mujer" (2) y "No identificado" (3).
    public ArrayList Sexo122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,PERIODO, VICTIMAID, CARPETAID, CATSEXOID\n"
                + "from RES_TR_SENAP_VICTIMAS\n"
                + "where CATSEXOID not in (1,2,9) or CATSEXOID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verificar el campo Situación conyugal CATSITUACIONCONYUGALID debido a que no se puede seleccionar una opción diferente a "Casado(a)" (1), "Unión Libre" (2), "Divorciado(a)" (3), "Separado(a)" (4), "Soltero(a)" (5), "Concubinato" (6), "Sociedad de convivencia" (7), "Viudo(a)" (8), "Otro" (9) y "No identificado" (10).
    public ArrayList CATSITUACIONCONYUGALID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,PERIODO, VICTIMAID, CARPETAID, CATSITUACIONCONYUGALID\n"
                + "from RES_TR_SENAP_VICTIMAS\n"
                + "where CATSITUACIONCONYUGALID not in (1,2,3,4,5,6,7,8,9,99) or CATSITUACIONCONYUGALID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verificar el campo Nacionalidad CATNACIONALIDADID debido a que no se puede venir nulo.
    public ArrayList Nacionalida122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,PERIODO, VICTIMAID, CARPETAID, CATNACIONALIDADID\n"
                + "from RES_TR_SENAP_VICTIMAS\n"
                + "where CATNACIONALIDADID in (0) or CATNACIONALIDADID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verificar el campo Nivel de escolaridad CATNIVELESCOLARIDADID debido a que no se puede seleccionar una opción diferente a "Ninguno" (1), "Preescolar o primaria" (2), "Secundaria" (3), "Preparatoria" (4), "Carrera técnica o comercial" (5), "Licenciatura" (6), "Maestría" (7), "Doctorado" (8) y "No identificado" (9).
    public ArrayList CATNIVELESCOLARIDADID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,PERIODO, VICTIMAID, CARPETAID, CATNIVELESCOLARIDADID\n"
                + "from RES_TR_SENAP_VICTIMAS\n"
                + "where CATNIVELESCOLARIDADID not in (1,2,3,4,5,6,7,8,99) or CATNIVELESCOLARIDADID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("VICTIMAID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
