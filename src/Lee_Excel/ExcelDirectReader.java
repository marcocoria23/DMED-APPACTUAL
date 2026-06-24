/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lee_Excel;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author LAURA.MEDINAJ
 */
public class ExcelDirectReader {
     /**
     * Lee directamente desde Excel sin pasar por CSV
     * @param rutaExcel Ruta del archivo Excel
     * @param nombrePestaña Nombre de la pestaña a leer
     * @return Lista de datos por fila
     */
    public static java.util.List<String[]> leerExcel(String rutaExcel, String nombrePestaña) throws IOException {
        java.util.List<String[]> datos = new java.util.ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(rutaExcel);
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            Sheet sheet = workbook.getSheet(nombrePestaña);
            if (sheet == null) {
                throw new IOException("Pestaña '" + nombrePestaña + "' no encontrada en: " + rutaExcel);
            }
            
            for (Row row : sheet) {
                int numCeldas = row.getPhysicalNumberOfCells();
                String[] datosRow = new String[numCeldas];
                
                for (int i = 0; i < numCeldas; i++) {
                    Cell cell = row.getCell(i);
                    datosRow[i] = formatCellValue(cell);
                }
                
                datos.add(datosRow);
            }
        }
        
        return datos;
    }
    
    /**
     * Formatea el valor de una celda preservando encoding UTF-8
     */
    private static String formatCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
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
    
    /**
     * Obtiene un valor específico de un array de datos
     * @param fila Array con los datos de la fila
     * @param indice Índice de la columna
     * @return Valor de la celda o vacío si está fuera de rango
     */
    public static String getValor(String[] fila, int indice) {
        if (indice >= 0 && indice < fila.length) {
            return fila[indice] != null ? fila[indice].trim() : "";
        }
        return "";
    }
}
