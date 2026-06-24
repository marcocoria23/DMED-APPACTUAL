package Pantallas_PSF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelFileManager {
    
    /**
     * Encuentra el archivo Excel que contenga la palabra clave en su nombre
     * @param directorio Ruta del directorio
     * @param keyword Palabra a buscar en el nombre del archivo
     * @return Ruta completa del archivo encontrado, o null si no existe
     */
    public static String encontrarArchivoExcel(String directorio, String keyword) {
        File dir = new File(directorio);
        File[] archivos = dir.listFiles((d, name) -> 
            name.toLowerCase().contains(keyword.toLowerCase()) && 
            (name.endsWith(".xlsx") || name.endsWith(".xls"))
        );
        
        if (archivos != null && archivos.length > 0) {
            return archivos[0].getAbsolutePath();
        }
        return null;
    }
    
    /**
     * Convierte un archivo Excel a CSV
     * @param rutaExcel Ruta del archivo Excel
     * @param nombrePestaña Nombre de la pestaña a convertir
     * @param rutaSalida Ruta donde guardar el CSV
     * @throws IOException
     */
    public static void excelACSV(String rutaExcel, String nombrePestaña, String rutaSalida) throws IOException {
        try (FileInputStream fis = new FileInputStream(rutaExcel);
             Workbook workbook = WorkbookFactory.create(fis)) {
            
            Sheet sheet = workbook.getSheet(nombrePestaña);
            if (sheet == null) {
                throw new IOException("Pestaña '" + nombrePestaña + "' no encontrada en: " + rutaExcel);
            }
            
            StringBuilder csvContent = new StringBuilder();
            
            for (Row row : sheet) {
                for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                    Cell cell = row.getCell(i);
                    if (i > 0) csvContent.append(",");
                    
                    if (cell == null) {
                        csvContent.append("");
                    } else {
                        csvContent.append(formatCellValue(cell));
                    }
                }
                csvContent.append("\n");
            }
            
            // Guardar el archivo CSV
            java.nio.file.Files.write(
                java.nio.file.Paths.get(rutaSalida), 
                csvContent.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8)
            );
        }
    }
    
    /**
     * Formatea el valor de una celda según su tipo
     */
    private static String formatCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                String value = cell.getStringCellValue();
                // Escapar comillas y saltos de línea
                if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
                    return "\"" + value.replace("\"", "\"\"") + "\"";
                }
                return value;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                }
                return String.valueOf((long)cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}