/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TMP.PLE;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import Pantallas_PLE.Integrar_TMP;
import java.util.HashMap;
import java.util.Map;
import mx.org.inegi.xlsm.DatosGenerales_xlsm;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author LAURA.MEDINAJ
 */
public class valida_info_correcta_Generales {

    private boolean correcto;
    public boolean AñoOk,PeriodosOk,LegisOk,EntidadOk;
    private int año, legislatura, entidad;
    // Lista de periodos leídos del Excel (se llenan en leerXLSX / leerCSV)
    private List<Periodo> periodosExcel = new ArrayList<>();

   
    public boolean valida_info_correcta_Generales(int anioApp,
            List<Periodo> periodosApp,
            String rutaExcel,
            String tipo_archivo) throws Exception {

        // ✅ FIX 1: usar .equals() en lugar de == para comparar Strings
        if (tipo_archivo.equals("XLSX")) {
            leerXLSX();
        } else if (tipo_archivo.equals("CSV")) {
            leerCSV(rutaExcel);
        }
        // Validar Legilsatura
        LegisOk = (legislatura == Integer.parseInt(Integrar_TMP.Legislatura));
        System.out.println("Legislatura excel: " + legislatura
                + ", Legislatura capturado en app: " + Integrar_TMP.Legislatura
                + ", ¿Legislatura correcta?: " + LegisOk);
        // Validar año
        AñoOk = (año == anioApp);
        System.out.println("Año Excel: " + año
                + ", Año capturado en app: " + anioApp
                + ", ¿Año correcto?: " + AñoOk);
        // Validar Legilsatura
        EntidadOk = (entidad == Integer.parseInt(Integrar_TMP.Entidad));
        System.out.println("Entidad excel: " + entidad
                + ", Entidad capturado en app: " + Integrar_TMP.Legislatura
                + ", ¿Entidad correcta?: " + EntidadOk);
        // Validar periodos
        PeriodosOk = validarPeriodos(periodosApp);
        System.out.println("Periodos app:   " + periodosApp);
        System.out.println(", Periodos Excel: " + periodosExcel);
        System.out.println(", ¿Periodos correctos?: " + PeriodosOk);

        correcto = AñoOk && PeriodosOk && LegisOk && EntidadOk;
        return correcto;
    }

    
    private boolean validarPeriodos(List<Periodo> periodosApp) {
        if (periodosApp.size() != periodosExcel.size()) {
            return false;
        }
        // Verificar que todos los periodos del app estén en el Excel
        for (Periodo p : periodosApp) {
            if (!periodosExcel.contains(p)) {
                return false;
            }
        }
        // Verificar que todos los periodos del Excel estén en el app
        for (Periodo p : periodosExcel) {
            if (!periodosApp.contains(p)) {
                return false;
            }
        }
        return true;
    }

    
    public void leerXLSX() throws Exception {
        DatosGenerales_xlsm xlsm = new DatosGenerales_xlsm();
        String valorEntidad = xlsm.LeerExcel(9, 29);
        entidad = Integer.parseInt(valorEntidad);

        String valorAño = xlsm.LeerExcel(22, 12);
        año = parsearAño(valorAño);

        String Legis = xlsm.LeerExcel(13, 4);
        legislatura = parsearLegislatura(Legis);

        //Leer periodos
        int[] filasXLSX = {25, 26, 27, 28, 29, 30};
        int colMarcador = 12;
        Periodo[] orden = {
            Periodo.PRIMER_ORDINARIO,
            Periodo.PRIMER_RECESO,
            Periodo.SEGUNDO_ORDINARIO,
            Periodo.SEGUNDO_RECESO,
            Periodo.TERCER_ORDINARIO,
            Periodo.TERCER_RECESO
        };

        periodosExcel.clear();
        for (int i = 0; i < filasXLSX.length; i++) {
            String celda = xlsm.LeerExcel(filasXLSX[i], colMarcador);
            System.out.println("Fila " + filasXLSX[i] + " col " + colMarcador
                    + " = '" + celda + "'");
            if (celda != null && celda.trim().equalsIgnoreCase("x")) {
                periodosExcel.add(orden[i]);
                System.out.println("  → Periodo detectado en XLSX: " + orden[i]);
            }
        }
    }

    public void leerCSV(String ruta) throws Exception {
        // Convertir a UTF-8 igual que en Tmp_ple_meds1_1_CSV
        Convertir_UTF8.Conver_Utf8 conUTF8 = new Convertir_UTF8.Conver_Utf8();
        conUTF8.Convertir_utf8_EBaseDatos(ruta);
        String nuevaRuta = ruta.replace(".csv", "UTF8.csv");

        try (BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream(nuevaRuta))) {

            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);

            if (bytesRead >= 3
                    && bytes[0] == (byte) 0xEF
                    && bytes[1] == (byte) 0xBB
                    && bytes[2] == (byte) 0xBF) {

                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(nuevaRuta),
                                StandardCharsets.UTF_8)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

                    int fila = 0;
                    for (CSVRecord record : csvParser) {
                        fila++;
                        if (fila == 8) { // Fila 8 es TR_PLE_MEDS1_1 según Tmp_ple_meds1_1_CSV
                            // Leer año (columna 9, índice base 0)
                            String valorAño = record.get(9);
                            año = parsearAño(valorAño);
                            System.out.println("Año leído de CSV: '" + valorAño + "' → " + año);

                            // Leer periodos marcados con "x"
                            // Según Tmp_ple_meds1_1_CSV: varx empieza en col 13,
                            // avanza de 5 en 5 para los 6 periodos
                            int varx = 13;
                            Periodo[] orden = {
                                Periodo.PRIMER_ORDINARIO,
                                Periodo.PRIMER_RECESO,
                                Periodo.SEGUNDO_ORDINARIO,
                                Periodo.SEGUNDO_RECESO,
                                Periodo.TERCER_ORDINARIO,
                                Periodo.TERCER_RECESO
                            };
                            periodosExcel.clear();
                            for (int i = 0; i < 6; i++) {
                                String celda = record.get(varx);
                                System.out.println("Col " + varx + " = '" + celda + "'");
                                if (celda != null && celda.trim().equalsIgnoreCase("X")) {
                                    periodosExcel.add(orden[i]);
                                    System.out.println("  → Periodo detectado en CSV: " + orden[i]);
                                }
                                varx += 5;
                            }
                            break; // Ya leímos lo que necesitamos
                        }
                    }
                }
            }
        }
    }

    /**
     * Convierte el texto del año a su número equivalente. Mismo criterio que
     * getAño() en Tmp_ple_meds1_1 y Tmp_ple_meds1_1_CSV.
     */
    private int parsearAño(String valorAño) {
        if (valorAño == null) {
            return 0;
        }
        valorAño = valorAño.trim();
        if (valorAño.equals("Primer año")) {
            return 1;
        }
        if (valorAño.equals("Segundo año")) {
            return 2;
        }
        if (valorAño.equals("Tercer año")) {
            return 3;
        }
        return 0;
    }

    private int parsearLegislatura(String valorLegis) {
        Map<Character, Integer> mapa = new HashMap<>();
        mapa.put('I', 1);
        mapa.put('V', 5);
        mapa.put('X', 10);
        mapa.put('L', 50);
        mapa.put('C', 100);
        mapa.put('D', 500);
        mapa.put('M', 1000);

        int resultado = 0;

        for (int i = 0; i < valorLegis.length(); i++) {
            int valorActual = mapa.get(valorLegis.charAt(i));

            if (i + 1 < valorLegis.length()) {
                int valorSiguiente = mapa.get(valorLegis.charAt(i + 1));

                if (valorActual < valorSiguiente) {
                    resultado += (valorSiguiente - valorActual);
                    i++; // saltar el siguiente
                } else {
                    resultado += valorActual;
                }
            } else {
                resultado += valorActual;
            }
        }

        return resultado;

    }

    public boolean Correcto() {
        return correcto;
    }

    public List<Periodo> getPeriodosExcel() {
        return periodosExcel;
    }
}