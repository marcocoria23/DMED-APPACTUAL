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
public class QMunicipios {

    DaoConexionPSF conexion = new DaoConexionPSF();
    ResultSet resul;
    String sql = "";
    ArrayList<String[]> Array;

    // La suma de TOTAL_POBLACION por programa debe coincidir con la suma de los campos de poblacion atendida.
    public ArrayList poblacion_atendida_municipios() {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "WITH poblacion_mpio AS (\n"
                + "    SELECT\n"
                + "        ID_PROGRAMA_SOCIAL,\n"
                + "        SUM(\n"
                + "            CASE\n"
                + "                WHEN REGEXP_LIKE(TRIM(REPLACE(TOTAL_POBLACION, ',', '')), '^[0-9]+$')\n"
                + "                THEN TO_NUMBER(TRIM(REPLACE(TOTAL_POBLACION, ',', '')))\n"
                + "                ELSE 0\n"
                + "            END\n"
                + "        ) AS TOTAL_REGISTRADO_MUNICIPIOS\n"
                + "    FROM TR_GF_POBLACION_ATEND_MPIO_GEN\n"
                + "    GROUP BY ID_PROGRAMA_SOCIAL\n"
                + "), programas AS (\n"
                + "    SELECT\n"
                + "        ID_PROGRAMA_SOCIAL,\n"
                + "        NOMBRE_PROGRAMA_SOCIAL,\n"
                + "        NVL(CASE WHEN REGEXP_LIKE(TRIM(REPLACE(POBLACION_ATENDIDA_PERSONAS, ',', '')), '^[0-9]+$') THEN TO_NUMBER(TRIM(REPLACE(POBLACION_ATENDIDA_PERSONAS, ',', ''))) END, 0) AS POBLACION_ATENDIDA_PERSONAS,\n"
                + "        NVL(CASE WHEN REGEXP_LIKE(TRIM(REPLACE(POBLACION_ATENDIDA_INSTITUCIONES, ',', '')), '^[0-9]+$') THEN TO_NUMBER(TRIM(REPLACE(POBLACION_ATENDIDA_INSTITUCIONES, ',', ''))) END, 0) AS POBLACION_ATENDIDA_INSTITUCIONES,\n"
                + "        NVL(CASE WHEN REGEXP_LIKE(TRIM(REPLACE(POBLACION_ATENDIDA_PERSONAS_MORALES, ',', '')), '^[0-9]+$') THEN TO_NUMBER(TRIM(REPLACE(POBLACION_ATENDIDA_PERSONAS_MORALES, ',', ''))) END, 0) AS POBLACION_ATENDIDA_PERSONAS_MORALES,\n"
                + "        NVL(CASE WHEN REGEXP_LIKE(TRIM(REPLACE(POBLACION_ATENDIDA_TERRITORIAL, ',', '')), '^[0-9]+$') THEN TO_NUMBER(TRIM(REPLACE(POBLACION_ATENDIDA_TERRITORIAL, ',', ''))) END, 0) AS POBLACION_ATENDIDA_TERRITORIAL,\n"
                + "        NVL(CASE WHEN REGEXP_LIKE(TRIM(REPLACE(POBLACION_ATENDIDA_OTRO_TIPO, ',', '')), '^[0-9]+$') THEN TO_NUMBER(TRIM(REPLACE(POBLACION_ATENDIDA_OTRO_TIPO, ',', ''))) END, 0) AS POBLACION_ATENDIDA_OTRO_TIPO,\n"
                + "        NVL(CASE WHEN REGEXP_LIKE(TRIM(REPLACE(POBLACION_ATENDIDA_NO_IDENTIFICADA, ',', '')), '^[0-9]+$') THEN TO_NUMBER(TRIM(REPLACE(POBLACION_ATENDIDA_NO_IDENTIFICADA, ',', ''))) END, 0) AS POBLACION_ATENDIDA_NO_IDENTIFICADA\n"
                + "    FROM TR_GF_PROG_SOCIALES_GEN\n"
                + ")\n"
                + "SELECT\n"
                + "    p.ID_PROGRAMA_SOCIAL,\n"
                + "    'TOTAL_REGISTRADO_PROGRAMA=' || NVL(m.TOTAL_REGISTRADO_MUNICIPIOS, 0)\n"
                + "        || ' | TOTAL_REPORTADO_CAMPOS=' || (\n"
                + "            p.POBLACION_ATENDIDA_PERSONAS\n"
                + "            + p.POBLACION_ATENDIDA_INSTITUCIONES\n"
                + "            + p.POBLACION_ATENDIDA_PERSONAS_MORALES\n"
                + "            + p.POBLACION_ATENDIDA_TERRITORIAL\n"
                + "            + p.POBLACION_ATENDIDA_OTRO_TIPO\n"
                + "            + p.POBLACION_ATENDIDA_NO_IDENTIFICADA\n"
                + "        )\n"
                + "        || ' | DIFERENCIA=' || (\n"
                + "            NVL(m.TOTAL_REGISTRADO_MUNICIPIOS, 0)\n"
                + "            - (\n"
                + "                p.POBLACION_ATENDIDA_PERSONAS\n"
                + "                + p.POBLACION_ATENDIDA_INSTITUCIONES\n"
                + "                + p.POBLACION_ATENDIDA_PERSONAS_MORALES\n"
                + "                + p.POBLACION_ATENDIDA_TERRITORIAL\n"
                + "                + p.POBLACION_ATENDIDA_OTRO_TIPO\n"
                + "                + p.POBLACION_ATENDIDA_NO_IDENTIFICADA\n"
                + "            )\n"
                + "        ) AS COMENTARIOS\n"
                + "FROM programas p\n"
                + "LEFT JOIN poblacion_mpio m\n"
                + "    ON p.ID_PROGRAMA_SOCIAL = m.ID_PROGRAMA_SOCIAL\n"
                + "WHERE NVL(m.TOTAL_REGISTRADO_MUNICIPIOS, 0) <> (\n"
                + "    p.POBLACION_ATENDIDA_PERSONAS\n"
                + "    + p.POBLACION_ATENDIDA_INSTITUCIONES\n"
                + "    + p.POBLACION_ATENDIDA_PERSONAS_MORALES\n"
                + "    + p.POBLACION_ATENDIDA_TERRITORIAL\n"
                + "    + p.POBLACION_ATENDIDA_OTRO_TIPO\n"
                + "    + p.POBLACION_ATENDIDA_NO_IDENTIFICADA\n"
                + ")\n"
                + "ORDER BY p.ID_PROGRAMA_SOCIAL";
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
            Logger.getLogger(QMunicipios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
