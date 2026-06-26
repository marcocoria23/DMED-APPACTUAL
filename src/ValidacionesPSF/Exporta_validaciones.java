package ValidacionesPSF;

import Pantallas_PSF.Valida;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Exporta validaciones PSF/CPF a un archivo Excel (.xlsx).
 *
 * @author ANTONIO.CORIA 
 */
public class Exporta_validaciones {

    private final JFrame ventanaProgreso = new JFrame("Progreso Exporta TEPJF.xlsx");

    // =========================================================================
    // PUNTO DE ENTRADA PRINCIPAL
    // =========================================================================

    public void ValidacionPSF() throws IOException {

        JProgressBar progressBar = inicializarVentanaProgreso();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");
        XSSFWorkbook libro = new XSSFWorkbook();
        Estilos estilos = new Estilos(libro);

        // ── Hoja 1: Programas Sociales ───────────────────────────────────────
        XSSFSheet hojaPS = libro.createSheet("Programas_Sociales");
        hojaPS.setColumnWidth(0, 8000);
        hojaPS.setColumnWidth(1, 6000);
        hojaPS.setColumnWidth(2, 12000);
        hojaPS.setColumnWidth(3, 12000);
        hojaPS.setColumnWidth(4, 6000);

        // ── Hoja 2: Contrataciones Públicas ──────────────────────────────────
        XSSFSheet hojaCP = libro.createSheet("Contrataciones_Publicas");
        hojaCP.setColumnWidth(0, 6000);
        hojaCP.setColumnWidth(1, 6000);
        hojaCP.setColumnWidth(2, 12000);
        hojaCP.setColumnWidth(3, 12000);
        hojaCP.setColumnWidth(4, 6000);

         // ── Hoja 3: Municiíos ──────────────────────────────────
       XSSFSheet hojaMUN = libro.createSheet("Municipios");
       hojaMUN.setColumnWidth(0, 8000);
       hojaMUN.setColumnWidth(1, 18000);
       hojaMUN.setColumnWidth(2, 18000);
       
        desplegarProgramasSociales(hojaPS, estilos, progressBar);
        desplegarContratacionesPublicas(hojaCP, estilos, progressBar);
        desplegarMunicipios(hojaMUN, estilos, progressBar);
        guardarArchivo(libro, progressBar, ventanaProgreso, dtf);
    }
       
    
    
    // =========================================================================
    // HOJA 1 — PROGRAMAS SOCIALES
    // =========================================================================

    public void desplegarProgramasSociales(XSSFSheet hoja, Estilos estilos, JProgressBar progressBar) {

        actualizarProgreso(progressBar, 15, "Programas_Sociales");
        crearFilaTitulo(hoja, 0, "Programas Sociales", 5, estilos.titulo);

        QProgramas_sociales PS = new QProgramas_sociales();
        new Valida(); // instancia requerida por la lógica original

        // ── Declaración: proveedor de datos → mensaje de validación ──────────
        // Cada entrada: método que retorna datos, mensaje para columna "Validacion"
        Object[][] validaciones = {
            { PS.camposObligatoriosNull(),
              "Campo obligatorio sin información" },
            { PS.instituciones_encargadas_saltos(),
              "No debe dejar posiciones vacias antes de capturar una institucion encargada posterior" },
            { PS.derecho_social_atendido_saltos(),
              "No debe dejar posiciones vacias antes de capturar un derecho social atendido posterior" },
            { PS.tipo_apoyo_entregado_saltos(),
              "No debe dejar posiciones vacias antes de capturar un tipo de apoyo entregado posterior" },
            { PS.grupo_vulnerable_beneficiado_saltos(),
              "No debe dejar posiciones vacias antes de capturar un grupo vulnerable beneficiado posterior" },
            { PS.URL_REGLAS_LINEAMIENTOS_OPERACIONDC(),
              "Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a Sí" },
            { PS.URL_REGLAS_LINEAMIENTOS_OPERACIONNDC(),
              "No Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a No" },
            { PS.derecho_social_atendido_2(),
              "No Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a No" },
            { PS.derecho_social_atendido_3(),
              "No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1 o derecho_social_atendido_2." },
            { PS.derecho_social_atendido_4(),
              "No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1, derecho_social_atendido_2 o derecho_social_atendido_3" },
            { PS.derecho_social_atendido_5(),
              "No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1, derecho_social_atendido_2, derecho_social_atendido_3 o derecho_social_atendido_4." },
            { PS.tipo_apoyo_entregado_2(),
              "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1." },
            { PS.tipo_apoyo_entregado_2(),  // llamada duplicada conservada igual que el original
              "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1." },
            { PS.tipo_apoyo_entregado_3(),
              "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1 o tipo_apoyo_entregado_2." },
            { PS.tipo_apoyo_entregado_4(),
              "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1, tipo_apoyo_entregado_2 o tipo_apoyo_entregado_3." },
            { PS.tipo_apoyo_entregado_5(),
              "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3 o tipo_apoyo_entregado_4." },
            { PS.OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE(),
              "Favor de especificar en OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE ya que al menos una variable de Tipo_apoyo_entregado ='Otro tipo de apoyo (especifique)'" },
            { PS.OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUEND(),
              "No debe de especificar en OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE ya que las variable de Tipo_apoyo_entregado es diferente a'Otro tipo de apoyo (especifique)'" },
            { PS.poblacion_atendida_territorial_especifique(),
              "poblacion_atendida_territorial_especifique no debe de capturar  ya que hay un dato numérico en el campo poblacion_atendida_territorial." },
            { PS.poblacion_atendida_otro_tipo_especifique(),
              "poblacion_atendida_otro_tipo_especifique no debe de capturar  ya que no hay un dato numérico en el campo poblacion_atendida_otro_tipo." },
            { PS.poblacion_atendida_otro_tipo_especifiqueND(),
              "Debe de capturar en poblacion_atendida_otro_tipo_especifique   ya que  hay un dato numérico en el campo poblacion_atendida_otro_tipo." },
            { PS.grupo(),
              "No puede repetir el tipo de grupo vulnerable atendido  seleccionado en el campo grupo_vulnerable_beneficiado" },
            { PS.grupo_ESPECIFIQUE(),
              "No Debe de capturar otro_grupo_vulnerable_beneficiado_especifique  ya que grupo_vulnerable_beneficiado es diferente a \"Otro grupo vulnerable (especifique)\"" },
            { PS.grupo_ESPECIFIQUEND(),
              "Debe de capturar otro_grupo_vulnerable_beneficiado_especifique  ya que grupo_vulnerable_beneficiado es igual a \"Otro grupo vulnerable (especifique)\"" },
        };

        escribirBloques(hoja, estilos, validaciones);
    }

    // =========================================================================
    // HOJA 2 — CONTRATACIONES PÚBLICAS
    // =========================================================================

    public void desplegarContratacionesPublicas(XSSFSheet hoja, Estilos estilos, JProgressBar progressBar) {

        actualizarProgreso(progressBar, 50, "Contrataciones Publicas");
        crearFilaTitulo(hoja, 0, "Contrataciones Publicas", 5, estilos.titulo);

        QContrataciones_Publicas CP = new QContrataciones_Publicas();
        new Valida(); // instancia requerida por la lógica original

        Object[][] validaciones = {
            { CP.camposObligatoriosNull(),
              "Campo obligatorio sin información" },
            { CP.otro_tipo_procedimiento_especifique(),
              "Debe de capturar otro_tipo_procedimiento_especifique ya que tipo_procedimiento='Otro tipo (especifique)'" },
            { CP.otro_tipo_procedimiento_especifiqueNDC(),
              "No debe de capturar otro_tipo_procedimiento_especifique ya que tipo_procedimiento es diferente a 'Otro tipo (especifique)'" },
            { CP.NOTotra_institucion_especifique(),
              "NO Debe de capturar otra_institucion_especifique ya que institucion es diferente a  a OTRA INSTITUCION (especifique)" },
            { CP.otra_institucion_especifique(),
              "Debe de capturar otra_institucion_especifique ya que institucion es igual a OTRA INSTITUCION (especifique)" },
            { CP.fecha_publicacion_fallo(),
              "Debe ser igual o mayor a la fecha registrada en el campo fecha_publicacion_convocatoria. En caso de este criterio no le aplique, debe justificarlo en el campo \"\"Comentarios\"\"." },
            { CP.fecha_firma_contrato(),
              "Debe ser igual o mayor a la fecha registrada en el campo fecha_publicacion_fallo. En caso de este criterio no le aplique, debe justificarlo en el campo \"\"Comentarios\"\"." },
            { CP.fecha_inicio_contrato(),
              "Debe ser igual o mayor a la fecha registrada en el campo fecha_firma_contrato.En caso de este criterio no le aplique, debe justificarlo en el campo \"\"Comentarios\"\"." },
            { CP.fecha_conclusion_contrato(),
              "Debe ser igual o mayor a la fecha registrada en el campo fecha_inicio_contrato.En caso de este criterio no le aplique, debe justificarlo en el campo \"\"Comentarios\"\"" },
            { CP.tipo_garantia_presentada_1(),
              "Debe de capturar tipo_garantia_presentada_1 ya que campo cond_presentacion_garantia =Sí." },
            { CP.tipo_garantia_presentada_1_ND(),
              "No debe de capturar tipo_garantia_presentada_1 ya que campo cond_presentacion_garantia =No." },
            { CP.tipo_garantia_presentada_REPETIDA(),
              "No se debe repetir tipo_garantia_presentada_1." },
        };

        escribirBloques(hoja, estilos, validaciones);
        progressBar.setValue(80);
    }

    // =========================================================================
    // HOJA 3 — MUNICIPIOS
    // =========================================================================
    public void desplegarMunicipios(XSSFSheet hoja, Estilos estilos, JProgressBar progressBar) {

    actualizarProgreso(progressBar, 80, "Municipios");
    crearFilaTitulo(hoja, 0, "Municipios", 5, estilos.titulo);

    QMunicipios municipios = new QMunicipios();
    new Valida();

    Object[][] validaciones = {
        { municipios.poblacion_atendida_municipios(),
          "La suma de las cantidades registradas para el programa o accion de desarrollo social debe ser igual a la suma de poblacion_atendida_personas, poblacion_atendida_instituciones, poblacion_atendida_personas_morales, poblacion_atendida_territorial, poblacion_atendida_otro_tipo y poblacion_atendida_no_identificada" },
    };

    escribirBloques(hoja, estilos, validaciones);
    progressBar.setValue(100);
}
    
    
    // =========================================================================
    // HELPER PRINCIPAL: escribe todos los bloques de una hoja
    // =========================================================================

    /**
     * Itera sobre el arreglo de validaciones y escribe en la hoja
     * cada bloque (encabezado + filas de datos) solo si hay registros.
     *
     * @param validaciones arreglo de pares { ArrayList<String[]> datos, String mensaje }
     */
    @SuppressWarnings("unchecked")
    private void escribirBloques(XSSFSheet hoja, Estilos estilos, Object[][] validaciones) {
        int filaActual = 1; // fila 0 = título
        for (Object[] entrada : validaciones) {
            ArrayList<String[]> datos = (ArrayList<String[]>) entrada[0];
            String mensaje = (String) entrada[1];
            String observacionDefault = entrada.length > 2
                    ? (String) entrada[2]
                    : resolverObservacionDefault(mensaje);
            if (!datos.isEmpty()) {
                filaActual = escribirBloque(hoja, estilos, filaActual, datos, mensaje, observacionDefault);
            }
        }
    }

    /**
     * Escribe un bloque: fila de encabezado + una fila por cada registro.
     * Columnas: 0=ID_PROGRAMA_SOCIAL (parts[0]), 1=Observaciones (parts[1]), 2=Validacion (mensaje fijo).
     *
     * @return índice de la siguiente fila disponible
     */
    private int escribirBloque(XSSFSheet hoja, Estilos estilos,
                                int filaInicio, ArrayList<String[]> datos, String mensaje, String observacionDefault) {

        // ── Encabezado del bloque ────────────────────────────────────────────
        String idEncabezado = "Contrataciones_Publicas".equals(hoja.getSheetName())
                ? "ID_CONTRATO"
                : "ID_PROGRAMA_SOCIAL";
        String[] encabezados = {idEncabezado, "Observaciones", "Validacion"};
        XSSFRow rowEnc = hoja.createRow(filaInicio);
        for (int col = 0; col < encabezados.length; col++) {
            crearCelda(rowEnc, col, encabezados[col], estilos.encabezado);
        }

        // ── Filas de datos ───────────────────────────────────────────────────
        int filaDatos = filaInicio + 1;
        for (String[] registro : datos) {
            String col0 = limpiarValor(registro.length > 0 ? registro[0] : "");
            String col1 = limpiarValor(registro.length > 1 ? registro[1] : "");
            if (col1.isEmpty()) {
                col1 = observacionDefault;
            }

            XSSFRow row = hoja.createRow(filaDatos++);
            crearCelda(row, 0, col0,    estilos.datos);
            crearCelda(row, 1, col1,    estilos.datos);
            crearCelda(row, 2, mensaje, estilos.datos);
        }

        return filaDatos; // siguiente fila disponible
    }

    private String limpiarValor(String valor) {
        return valor == null ? "" : valor.replace(" 00:00:00.0", "").trim();
    }

    private String resolverObservacionDefault(String mensaje) {
        String texto = mensaje == null ? "" : mensaje.toUpperCase();
        String[] campos = {
            "URL_REGLAS_LINEAMIENTOS_OPERACION",
            "COND_REGLAS_LINEAMIENTOS_OPERACION",
            "DERECHO_SOCIAL_ATENDIDO",
            "TIPO_APOYO_ENTREGADO",
            "OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE",
            "POBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE",
            "POBLACION_ATENDIDA_TERRITORIAL",
            "POBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE",
            "POBLACION_ATENDIDA_OTRO_TIPO",
            "GRUPO_VULNERABLE_BENEFICIADO",
            "OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE",
            "OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE",
            "TIPO_PROCEDIMIENTO",
            "FECHA_FIRMA_CONTRATO",
            "FECHA_INICIO_CONTRATO",
            "FECHA_CONCLUSION_CONTRATO",
            "TIPO_GARANTIA_PRESENTADA_1",
            "COND_PRESENTACION_GARANTIA"
        };

        for (String campo : campos) {
            if (texto.contains(campo)) {
                return campo;
            }
        }
        return "";
    }

    
    /** Crea la fila de título combinando columnas desde 0 hasta {@code lastCol}. */
    private void crearFilaTitulo(XSSFSheet hoja, int numFila, String texto,
                                  int lastCol, XSSFCellStyle estilo) {
        XSSFRow row = hoja.createRow(numFila);
        row.setHeight((short) 600);
        XSSFCell celda = row.createCell(0);
        celda.setCellStyle(estilo);
        celda.setCellType(CellType.STRING);
        celda.setCellValue(new XSSFRichTextString(texto));
        hoja.addMergedRegion(new CellRangeAddress(numFila, numFila, 0, lastCol));
    }

    /** Crea una celda con texto y estilo dados. */
    private void crearCelda(XSSFRow row, int col, String valor, XSSFCellStyle estilo) {
        XSSFCell cell = row.createCell(col);
        cell.setCellStyle(estilo);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(new XSSFRichTextString(valor != null ? valor : ""));
    }


    private JProgressBar inicializarVentanaProgreso() {
        ventanaProgreso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBorder(BorderFactory.createTitledBorder("Cargando..."));

        Container content = ventanaProgreso.getContentPane();
        content.add(progressBar, BorderLayout.CENTER);

        ventanaProgreso.setSize(300, 100);
        ventanaProgreso.setResizable(false);
        ventanaProgreso.setLocationRelativeTo(null);
        ventanaProgreso.setVisible(true);
        return progressBar;
    }

    private void actualizarProgreso(JProgressBar bar, int valor, String etiqueta) {
        bar.setBorder(BorderFactory.createTitledBorder("Cargando..." + etiqueta));
        bar.setValue(valor);
    }

    // =========================================================================
    // GUARDADO DEL ARCHIVO
    // =========================================================================

    public static void guardarArchivo(XSSFWorkbook libro, JProgressBar progressBar,
                                       JFrame frame, DateTimeFormatter dtf)
            throws FileNotFoundException, IOException {

        FileDialog dialogo = new FileDialog(new JFrame(), "Save", FileDialog.SAVE);
        dialogo.setFile("Val_PSF_Y_CPF_" + " R " + "-" + dtf.format(LocalDateTime.now()) + ".xlsx");
        dialogo.setVisible(true);

        String directorio = dialogo.getDirectory();
        if (directorio == null) {
            JOptionPane.showMessageDialog(null,
                    "Archivo sin extensión .xlsx", "", JOptionPane.WARNING_MESSAGE);
            return;
        }

        File archivo = new File(directorio + dialogo.getFile() + ".xlsx");
        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            libro.write(fos);
        }

        JOptionPane.showMessageDialog(null,
                "Archivo Guardado Correctamente", "", JOptionPane.INFORMATION_MESSAGE);
        progressBar.setValue(0);
        frame.setVisible(false);
    }

    static class Estilos {

        final XSSFCellStyle titulo;
        final XSSFCellStyle encabezado;
        final XSSFCellStyle datos;

        Estilos(XSSFWorkbook libro) {
            XSSFFont fuenteGrande = crearFuente(libro, 12, true,  IndexedColors.WHITE);
            XSSFFont fuenteMedia  = crearFuente(libro, 10, true,  IndexedColors.WHITE);
            XSSFFont fuenteNormal = crearFuente(libro, 11, false, IndexedColors.BLACK);

            // ── Título: fondo amarillo oscuro ────────────────────────────────
            titulo = libro.createCellStyle();
            titulo.setFont(fuenteGrande);
            titulo.setWrapText(true);
            titulo.setAlignment(HorizontalAlignment.CENTER);
            titulo.setVerticalAlignment(VerticalAlignment.CENTER);
            titulo.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
            titulo.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // ── Encabezado: fondo amarillo con bordes ────────────────────────
            encabezado = libro.createCellStyle();
            encabezado.setFont(fuenteMedia);
            encabezado.setWrapText(true);
            encabezado.setAlignment(HorizontalAlignment.CENTER);
            encabezado.setVerticalAlignment(VerticalAlignment.CENTER);
            encabezado.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            encabezado.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            aplicarBordes(encabezado);

            // ── Datos: sin relleno, con bordes ───────────────────────────────
            datos = libro.createCellStyle();
            datos.setFont(fuenteNormal);
            datos.setWrapText(true);
            datos.setAlignment(HorizontalAlignment.CENTER);
            aplicarBordes(datos);
        }

        private static XSSFFont crearFuente(XSSFWorkbook libro, int tamanio,
                                             boolean negrita, IndexedColors color) {
            XSSFFont fuente = libro.createFont();
            fuente.setFontHeightInPoints((short) tamanio);
            fuente.setFontName("Arial");
            fuente.setBold(negrita);
            fuente.setColor(color.getIndex());
            return fuente;
        }

        private static void aplicarBordes(XSSFCellStyle estilo) {
            estilo.setBorderTop(BorderStyle.THIN);
            estilo.setTopBorderColor(IndexedColors.BLACK.getIndex());
            estilo.setBorderBottom(BorderStyle.THIN);
            estilo.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            estilo.setBorderLeft(BorderStyle.MEDIUM);
            estilo.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            estilo.setBorderRight(BorderStyle.MEDIUM);
            estilo.setRightBorderColor(IndexedColors.BLACK.getIndex());
        }
    }
}
