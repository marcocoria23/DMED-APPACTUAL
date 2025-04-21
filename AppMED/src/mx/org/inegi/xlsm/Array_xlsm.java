/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.xlsm;

import Pantallas_PLE.Integrar_TMP;
import Pantallas_PSF.IntegraPSF_TMP;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Array_xlsm {

    boolean Valores;
    String valorLeido = "";
    double num;
    int Num2;
    boolean valor;

    public ArrayList<ArrayList<String>> LeerExcel(int filaInicio, int columnaInicio, int columnaFin, String Pestaña) {
        Integrar_TMP Integra = new Integrar_TMP();
        IntegraPSF_TMP in=new IntegraPSF_TMP();
        
        
        ArrayList<ArrayList<String>> valoresLeidos = new ArrayList<>();

        //System.out.println("integra" + Integra.RutaAr);
        String filePath = Integra.RutaAr;

        try (FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = WorkbookFactory.create(fis)) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Sheet sheet = workbook.getSheet(Pestaña); // Obtener la primera hoja del libro
            Obtener_ultima_Fila Fila = new Obtener_ultima_Fila();

            int filaFin = Fila.obtenerUltimaFilaConDatos(Pestaña);

            System.out.println("Numero de Filas+" + filaFin);
            if (filaFin > 0) {
                // Iterar sobre las filas del rango especificado
                for (int i = filaInicio; i <= filaFin; i++) {
                    Row row = sheet.getRow(i); // Obtener la fila i
                    if (row != null) {
                        ArrayList<String> filaValores = new ArrayList<>();
                        // Iterar sobre las columnas del rango especificado
                        for (int j = columnaInicio; j <= columnaFin; j++) {
                            Cell cell = row.getCell(j); // Obtener la celda en la fila i y columna j
                            if (cell != null) {
                                switch (cell.getCellTypeEnum()) {
                                    case STRING:
                                        valorLeido = cell.getStringCellValue().replaceAll("[\n\t]", "");
                                        break;
                                    case NUMERIC:
                                        if (DateUtil.isCellDateFormatted(cell)) {
                                            java.util.Date fecha = cell.getDateCellValue();
                                            valorLeido = sdf.format(fecha);
                                        } else {
                                            if (cell.getCellType() == CellType.NUMERIC) {
                                                double num = cell.getNumericCellValue();
                                                if (Math.floor(num) == num) {
                                                    // Es un número entero
                                                    valorLeido = String.valueOf((int) num).replaceAll("[\n\t]", "");
                                                } else {
                                                    // Es un número de punto flotante (double)
                                                    valorLeido = String.valueOf(num).replaceAll("[\n\t]", "");
                                                }
                                            }
                                        }
                                        break;
                                    case BOOLEAN:
                                        valor = cell.getBooleanCellValue();
                                        valorLeido = String.valueOf(valor).replaceAll("[\n\t]", "");
                                        break;

                                    case FORMULA:
                                        try {
                                            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                                            CellValue cellValue = evaluator.evaluate(cell);
                                            switch (cellValue.getCellTypeEnum()) {
                                                case STRING:
                                                    valorLeido = cell.getStringCellValue().replaceAll("[\n\t]", "");
                                                    break;
                                                case NUMERIC:
                                                    if (DateUtil.isCellDateFormatted(cell)) {
                                                        java.util.Date fecha = cell.getDateCellValue();
                                                        valorLeido = sdf.format(fecha);
                                                    } else {
                                                        if (cell.getCellType() == CellType.NUMERIC) {
                                                            double num = cell.getNumericCellValue();
                                                            if (Math.floor(num) == num) {
                                                                // Es un número entero
                                                                valorLeido = String.valueOf((int) num).replaceAll("[\n\t]", "");
                                                            } else {
                                                                // Es un número de punto flotante (double)
                                                                valorLeido = String.valueOf(num).replaceAll("[\n\t]", "");
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case BOOLEAN:
                                                    boolean val = cell.getBooleanCellValue();
                                                    valorLeido = String.valueOf(val).replaceAll("[\n\t]", "");
                                                    break;
                                                case BLANK:
                                                    valorLeido = "";
                                                    break;
                                                default:
                                                    valorLeido = "";
                                                    break;
                                            }
                                        } catch (FormulaParseException e) {
                                            // Si no se puede evaluar la fórmula, establece el contenido de la celda como texto
                                            valorLeido = "Error al evaluar la fórmula: " + e.getMessage();
                                        }
                                        break;
                                    case BLANK:
                                        valorLeido = "";
                                        break;
                                    default:
                                        valorLeido = "";
                                        break;
                                }
                            }
                            filaValores.add(valorLeido);
                        }
                        valoresLeidos.add(filaValores);
                    } else {
                        //System.out.println("FILA vacía");
                    }
                }

                for (ArrayList<String> fila : valoresLeidos) {
                    for (String valor : fila) {
                        System.out.print(valor + "\t"); // Imprimir el valor de la celda seguido de un tabulador
                    }
                    System.out.println(); // Nueva línea después de imprimir todos los valores de la fila
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return valoresLeidos;

    }

}
