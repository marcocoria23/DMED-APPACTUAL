package Convertir_CSV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author ANDREA.HERNANDEZL
 */
public class Convertir_CSV {

    public void Convierte(String Ruta) {

        try (FileInputStream fis = new FileInputStream(Ruta)) {
            File dir = new File(Ruta);
            String outputDirectory = dir.getParent();
            dir = new File(outputDirectory);

            Workbook workbook = new XSSFWorkbook(fis);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                //obtener nombre de pestaña
                String sheetName = sheet.getSheetName();
                String validSheetName = sheetName.replaceAll("[\\/:*?\"<>|]", "_");
                //crea CSV por pestaña
                File csvFile = new File(outputDirectory + File.separator + validSheetName + ".csv");

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                    int maxColumn = 0; // Inicializar a 0 para obtenerlo de la primera fila

                    // Obtener número de columnas de la pestaña (primera fila)
                    if (sheet.getRow(0) != null) {
                        maxColumn = sheet.getRow(0).getLastCellNum() != -1 ? sheet.getRow(0).getLastCellNum() : 0;                     
                    }
                    
                    for (Row row : sheet) {
                        StringBuilder rowData = new StringBuilder();
                         //completar la filas del archivo hasta el num de columnas
                        for (int columnIndex = 0; columnIndex < maxColumn; columnIndex++) {
                            Cell cell = row.getCell(columnIndex);
                            if (cell != null) {
                                CellType cellType = cell.getCellType();

                                if (cellType == CellType.STRING) {
                                    rowData.append(cell.getStringCellValue());
                                } else if (cellType == CellType.NUMERIC) {
                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                                        rowData.append(cell.getDateCellValue());
                                    } else {
                                        double numericValue = cell.getNumericCellValue();
                                        if (numericValue == (long) numericValue) {
                                            rowData.append((long) numericValue);
                                        } else {
                                            rowData.append(numericValue);
                                        }
                                    }
                                } else if (cellType == CellType.BOOLEAN) {
                                    rowData.append(cell.getBooleanCellValue());
                                } else {
                                    rowData.append("");
                                }
                            } else {
                                rowData.append(""); // Celda nula, agregar cadena vacía
                            }

                            if (columnIndex < maxColumn - 1) {
                                rowData.append(",");
                            }
                        }
                        writer.write(rowData.toString());
                        writer.newLine();
                    }

                } catch (IOException e) {
                    System.out.println("Error al escribir el archivo CSV para la hoja: " + validSheetName);
                    e.printStackTrace();
                }
            }
            System.out.println("CSV Creados en: " + outputDirectory);
            workbook.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo Excel.");
            e.printStackTrace();
        }
    }
}