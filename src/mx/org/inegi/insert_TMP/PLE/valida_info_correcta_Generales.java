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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Pantallas_PLE.Integrar_TMP;
import java.util.LinkedHashMap;
import mx.org.inegi.xlsm.DatosGenerales_xlsm;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * Valida que los datos generales del archivo coincidan con los capturados en la aplicación
 * @author LAURA.MEDINAJ
 */
public class valida_info_correcta_Generales {

    private boolean correcto;
    public boolean AñoOk, PeriodosOk, LegisOk, EntidadOk;
    private int año, legislatura, entidad;
    private List<Periodo> periodosExcel = new ArrayList<>();

    /**
     * Valida la información general según el tipo de archivo
     */
    public boolean valida_info_correcta_Generales(int anioApp, List<Periodo> periodosApp, String rutaArchivo,String tipo_archivo) throws Exception {
        String RutaCSV = Integrar_TMP.getDirectorio() + "BD_datos_generales.csv";
        System.out.println("═══════════════════════════════════════════");
        System.out.println("VALIDANDO INFORMACIÓN GENERAL");
        System.out.println("Tipo: " + tipo_archivo);
        System.out.println("Ruta: " + RutaCSV);
        System.out.println("═══════════════════════════════════════════");

        try {
            if (tipo_archivo.equals("XLSX")) {
                leerXLSX();
            } else if (tipo_archivo.equals("CSV")) {
                leerCSV(RutaCSV);
            }

            // Validar Legislatura
            LegisOk = validarLegislatura();

            // Validar año
            AñoOk = validarAño(anioApp);

            // Validar Entidad
            EntidadOk = validarEntidad();

            // Validar periodos
            PeriodosOk = validarPeriodos(periodosApp);

            // Resultado final
            correcto = AñoOk && PeriodosOk && LegisOk && EntidadOk;

            System.out.println("\n═══════════════════════════════════════════");
            System.out.println("RESULTADO VALIDACIÓN:");
            System.out.println("  Entidad:    " + (EntidadOk ? "sí" : "no"));
            System.out.println("  Legislatura: " + (LegisOk ? "sí" : "no"));
            System.out.println("  Año:        " + (AñoOk ? "sí" : "no"));
            System.out.println("  Periodos:   " + (PeriodosOk ? "sí" : "no"));
            System.out.println("  GENERAL:    " + (correcto ? "CORRECTO" : "ERROR"));
            System.out.println("═══════════════════════════════════════════\n");

            return correcto;

        } catch (Exception ex) {
            System.err.println("Error en validación: " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * Valida que la legislatura coincida
     */
    private boolean validarLegislatura() {
        int legisApp = Integer.parseInt(Integrar_TMP.Legislatura);
        boolean ok = (legislatura == legisApp);

        System.out.println("\n▶ VALIDANDO LEGISLATURA:");
        System.out.println("  Excel:      " + legislatura);
        System.out.println("  Aplicación: " + legisApp);
        System.out.println("  Resultado:  " + (ok ? "SÍ COINCIDEN" : "NO COINCIDEN"));

        return ok;
    }

    /**
     * Valida que el año coincida
     */
    private boolean validarAño(int anioApp) {
        boolean ok = (año == anioApp);

        System.out.println("\n▶ VALIDANDO AÑO:");
        System.out.println("  Excel:      " + año);
        System.out.println("  Aplicación: " + anioApp);
        System.out.println("  Resultado:  " + (ok ? "SÍ COINCIDEN" : "  NO COINCIDEN"));

        return ok;
    }

    /**
     * Valida que la entidad coincida
     */
    private boolean validarEntidad() {
        int entidadApp = Integer.parseInt(Integrar_TMP.Entidad);
        boolean ok = (entidad == entidadApp);

        System.out.println("\n▶ VALIDANDO ENTIDAD:");
        System.out.println("  Excel:      " + entidad);
        System.out.println("  Aplicación: " + entidadApp);
        System.out.println("  Resultado:  " + (ok ? "SÍ COINCIDEN" : "  NO COINCIDEN"));

        return ok;
    }

    /**
     * Valida que los periodos coincidan exactamente
     */
    private boolean validarPeriodos(List<Periodo> periodosApp) {
        boolean ok = periodosApp.equals(periodosExcel);

        System.out.println("\n▶ VALIDANDO PERIODOS:");
        System.out.println("  Excel:      " + periodosExcel);
        System.out.println("  Aplicación: " + periodosApp);
        System.out.println("  Resultado:  " + (ok ? "SÍ COINCIDEN" : "  NO COINCIDEN"));

        return ok;
    }

    /**
     * Lee datos del archivo XLSX
     */
    private void leerXLSX() throws Exception {
        System.out.println("\n📊 Leyendo datos de XLSX...");

        DatosGenerales_xlsm xlsm = new DatosGenerales_xlsm();

        // Leer Entidad (fila 9, col 29)
        String valorEntidad = xlsm.LeerExcel(9, 29);
        entidad = Integer.parseInt(valorEntidad.trim());
        System.out.println("  Entidad: " + entidad);

        // Leer Año (fila 22, col 12)
        String valorAño = xlsm.LeerExcel(22, 12);
        año = parsearAño(valorAño);
        System.out.println("  Año: " + año);

        // Leer Legislatura (fila 13, col 4)
        String Legis = xlsm.LeerExcel(13, 4);
        legislatura = parsearLegislatura(Legis);
        System.out.println("  Legislatura: " + legislatura);

        // Leer Periodos (filas 25-30, col 12)
        leerPeriodosXLSX(xlsm);
    }

    /**
     * Lee los periodos del XLSX
     */
    private void leerPeriodosXLSX(DatosGenerales_xlsm xlsm) throws Exception {
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
            String celda = xlsm.LeerExcel(filasXLSX[i], colMarcador).trim();
            if (celda.equalsIgnoreCase("x")) {
                periodosExcel.add(orden[i]);
                System.out.println("  Periodo detectado: " + orden[i]);
            }
        }

        if (periodosExcel.isEmpty()) {
            System.out.println(" ADVERTENCIA: No se detectaron periodos en XLSX");
        }
    }

    /**
 * Lee datos del archivo CSV
 * ESTRUCTURA CORRECTA:
 * Fila 1: Headers originales
 * Fila 2-5: Vacías
 * Fila 6: Números (1,2,3,4,5...)
 * Fila 7: Headers simplificados (id_control, var1, var2...)
 * Fila 8: Datos vacíos (0, -, -, ...) ⚠️ IGNORAR
 * Fila 9: DATOS REALES (1, Aguascalientes, 1, LXVI, ...) ✓ LEER ESTA
 */
private void leerCSV(String ruta) throws Exception {
    System.out.println("\n📄 Leyendo datos de CSV...");

   convertirAUTF8(ruta);
   String nuevaRuta = ruta.replace(".csv", "UTF8.csv");

    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream(nuevaRuta),
                    StandardCharsets.UTF_8));
         CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withQuote('"'))) {

        int fila = 0;
        for (CSVRecord record : csvParser) {
            fila++;
            
            // DEBUG: Mostrar contenido de filas importantes
            if (fila >= 6 && fila <= 10) {
                System.out.println("\n  [Fila " + fila + "] Primeras 5 columnas:");
                for (int i = 0; i < Math.min(5, record.size()); i++) {
                    System.out.println("    Col " + i + ": '" + record.get(i) + "'");
                }
            }

            // ✅ FILA 9 ES LA CORRECTA (no fila 8)
            if (fila == 9) {
                System.out.println("\n Procesando fila 9 (datos reales)...");
                try {
                    procesarDatosCSV(record);
                    leerPeriodosCSV(record);
                } catch (Exception ex) {
                    System.err.println(" Error procesando fila 9: " + ex.getMessage());
                    throw ex;
                }
                break;
            }
        }
        
        // Verificar que se leyó la fila
        if (fila < 9) {
            throw new Exception(" El archivo CSV no tiene suficientes filas. Se leyeron: " + fila);
        }
    }
}

/**
 * Procesa los datos principales del CSV (FILA 9)
 * Según el archivo:
 * Columna 0: Id_control = 1
 * Columna 1: entidad_federativa = Aguascalientes
 * Columna 2: AGEE = 1
 * Columna 3: numero_legislatura = LXVI
 * Columna 9: ejercicio_constitucional_informacion_reportada = Segundo año
 */
private void procesarDatosCSV(CSVRecord record) throws Exception {
    try {
        System.out.println("\n  Leyendo valores principales...");
        
        // Mostrar primeros valores para debug
        System.out.println("    Col 0 (Id_control): '" + obtenerColumna(record, 0) + "'");
        System.out.println("    Col 1 (entidad): '" + obtenerColumna(record, 1) + "'");
        System.out.println("    Col 2 (AGEE): '" + obtenerColumna(record, 2) + "'");
        System.out.println("    Col 3 (legislatura): '" + obtenerColumna(record, 3) + "'");
        System.out.println("    Col 9 (año): '" + obtenerColumna(record, 9) + "'");

        // Entidad (columna 2 = AGEE)
        String valEntidad = obtenerColumna(record, 2);
        if (valEntidad.isEmpty() || valEntidad.equals("-")) {
            throw new NumberFormatException("Entidad vacía o inválida en columna 2: '" + valEntidad + "'");
        }
        entidad = Integer.parseInt(valEntidad);
        System.out.println(" Entidad: " + entidad);

        // Legislatura (columna 3 = numero_legislatura)
        String valLegis = obtenerColumna(record, 3);
        if (valLegis.isEmpty() || valLegis.equals("-")) {
            throw new NumberFormatException("Legislatura vacía o inválida en columna 3: '" + valLegis + "'");
        }
        legislatura = parsearLegislatura(valLegis);
        System.out.println(" Legislatura: " + legislatura);

        // Año (columna 9 = ejercicio_constitucional_informacion_reportada)
        String valAño = obtenerColumna(record, 9);
        if (valAño.isEmpty() || valAño.equals("-")) {
            throw new NumberFormatException("Año vacío o inválido en columna 9: '" + valAño + "'");
        }
        año = parsearAño(valAño);
        System.out.println(" Año: " + año);

    } catch (NumberFormatException ex) {
        System.err.println(" Error al parsear datos CSV:");
        System.err.println("   Entidad (col 2): '" + obtenerColumna(record, 2) + "'");
        System.err.println("   Legislatura (col 3): '" + obtenerColumna(record, 3) + "'");
        System.err.println("   Año (col 9): '" + obtenerColumna(record, 9) + "'");
        System.err.println("   Error: " + ex.getMessage());
        throw ex;
    }
}

/**
 * Obtiene el valor de una columna del CSV, manejando vacíos y guiones
 */
private String obtenerColumna(CSVRecord record, int indice) {
    try {
        if (indice < record.size()) {
            String valor = record.get(indice);
            if (valor != null) {
                valor = valor.trim();
                // Convertir "-" a vacío
                if (valor.equals("-")) {
                    return "";
                }
                return valor;
            }
        }
        return "";
    } catch (Exception ex) {
        System.out.println("  Error accediendo columna " + indice + ": " + ex.getMessage());
        return "";
    }
}

/**
 * Lee los periodos del CSV (FILA 9)
 * Periodos marcados con "X" en columnas específicas
 */
/**
 * Lee los periodos del CSV (FILA 9) - VERSIÓN AUTOMÁTICA
 * Busca "X" en las columnas de periodos de forma inteligente
 */
private void leerPeriodosCSV(CSVRecord record) {
    periodosExcel.clear();

    System.out.println("\n  Leyendo periodos...");
    
    // Estructura de columnas: cada período ocupa 5 columnas
    // Primera serie: columnas 13-17 (ordinarios: 13, recesos: 18)
    // Segunda serie: columnas 23-27 (ordinarios: 23, recesos: 28)
    // Tercera serie: columnas 33-37 (ordinarios: 33, recesos: 38)
    
    int[][] periodosColumnas = {
        {13, 18},  // Primer ordinario (col 13), Primer receso (col 18)
        {23, 28},  // Segundo ordinario (col 23), Segundo receso (col 28)
        {33, 38}   // Tercer ordinario (col 33), Tercer receso (col 38)
    };
    
    Periodo[][] periodos = {
        {Periodo.PRIMER_ORDINARIO, Periodo.PRIMER_RECESO},
        {Periodo.SEGUNDO_ORDINARIO, Periodo.SEGUNDO_RECESO},
        {Periodo.TERCER_ORDINARIO, Periodo.TERCER_RECESO}
    };
    
    System.out.println("  Buscando periodos marcados con 'X':");
    
    for (int serie = 0; serie < periodosColumnas.length; serie++) {
        for (int tipo = 0; tipo < periodosColumnas[serie].length; tipo++) {
            int col = periodosColumnas[serie][tipo];
            Periodo periodo = periodos[serie][tipo];
            
            try {
                String valor = obtenerColumna(record, col);
                String tipoPeriodo = (tipo == 0) ? "Ordinario" : "Receso";
                System.out.println("    Col " + col + " - " + periodo + ": '" + valor + "'");
                
                if (valor.equalsIgnoreCase("X")) {
                    periodosExcel.add(periodo);
                    System.out.println(" DETECTADO: " + periodo);
                }
            } catch (Exception ex) {
                System.out.println("  Error en columna " + col + ": " + ex.getMessage());
            }
        }
    }

    if (periodosExcel.isEmpty()) {
        System.out.println("    ADVERTENCIA: No se detectaron periodos en CSV");
    } else {
        System.out.println("\n   Total periodos encontrados: " + periodosExcel.size());
        System.out.println("  Periodos: " + periodosExcel);
    }
}
/**
 * Convierte texto de año a número - CON VALIDACIÓN
 */
private int parsearAño(String valorAño) {
    if (valorAño == null || valorAño.isEmpty() || valorAño.equals("-")) {
        System.out.println("  Año vacío o inválido");
        return 0;
    }

    valorAño = valorAño.trim().toLowerCase();
    System.out.println("    → Parseando año: '" + valorAño + "'");

    if (valorAño.contains("primer")) {
        System.out.println("    → Convertido: Primer año = 1");
        return 1;
    }
    if (valorAño.contains("segundo")) {
        System.out.println("    → Convertido: Segundo año = 2");
        return 2;
    }
    if (valorAño.contains("tercer")) {
        System.out.println("    → Convertido: Tercer año = 3");
        return 3;
    }

    System.out.println("    Año no reconocido: " + valorAño);
    return 0;
}

/**
 * Convierte números romanos a arábigos
 */
private int parsearLegislatura(String valorLegis) {
    if (valorLegis == null || valorLegis.isEmpty() || valorLegis.equals("-")) {
        System.out.println("  Legislatura vacía o inválida");
        return 0;
    }

    valorLegis = valorLegis.trim().toUpperCase();
    System.out.println("    → Parseando legislatura: '" + valorLegis + "'");
    
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
        char charActual = valorLegis.charAt(i);

        if (!mapa.containsKey(charActual)) {
            System.out.println(" Carácter romano inválido: " + charActual);
            return 0;
        }

        int valorActual = mapa.get(charActual);

        if (i + 1 < valorLegis.length()) {
            int valorSiguiente = mapa.get(valorLegis.charAt(i + 1));
            if (valorActual < valorSiguiente) {
                resultado += (valorSiguiente - valorActual);
                i++;
            } else {
                resultado += valorActual;
            }
        } else {
            resultado += valorActual;
        }
    }

    System.out.println("    → Convertido: " + valorLegis + " = " + resultado);
    return resultado;
}

    // ===== GETTERS =====
    public boolean Correcto() {
        return correcto;
    }

    public List<Periodo> getPeriodosExcel() {
        return periodosExcel;
    }
private void convertirAUTF8(String ruta) throws Exception {
        try {
            Convertir_UTF8.Conver_Utf8 conUTF8 = new Convertir_UTF8.Conver_Utf8();
            conUTF8.Convertir_utf8_EBaseDatos(ruta);
            System.out.println(" Archivo convertido a UTF-8");
        } catch (Exception ex) {
            System.out.println(" Advertencia conversión UTF-8: " + ex.getMessage());
        }
    }
    public int getAño() {
        return año;
    }

    public int getEntidad() {
        return entidad;
    }

    public int getLegislatura() {
        return legislatura;
    }
}