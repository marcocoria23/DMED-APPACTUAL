/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.xlsm;

import Pantallas_PLE.Integrar_TMP;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.Cell;
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
public class DatosGenerales_xlsm {

 public String LeerExcel(int fila,int columna) {
    Integrar_TMP Integra = new Integrar_TMP();
    String Valorleido="";
    double Num;
    int Num2;
    boolean Valor;
     
    //System.out.println("integra" + Integra.RutaAr);

    String filePath = Integra.RutaAr;

try (FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis)) {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Sheet sheet = workbook.getSheet("datos_generales"); // Obtener la primera hoja del libro

    // Iterar sobre las filas de la hoja
    Row row = sheet.getRow(fila); // Fila 9 (índice 8)
    if (row != null) {
        Cell cell = row.getCell(columna); // Columna 30 (índice 29)
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    Valorleido=cell.getStringCellValue();
                    //System.out.println(cell.getStringCellValue());
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                            // Si es una fecha, puedes leerla como un valor de tipo Date y luego formatearla como String
                            java.util.Date fecha = cell.getDateCellValue();
                            Valorleido = sdf.format(fecha); // Puedes cambiar este formato según tus necesidades
                           // System.out.println("Fecha: " + Valorleido);
                        } else {
                           Num = cell.getNumericCellValue();
                            if (String.valueOf(Num).length()>5){
                            Valorleido = String.valueOf(Num);     
                            }else{
                            Num2=(int) Num;
                            Valorleido = String.valueOf(Num2); 
                            }
                        }
                    break;
                case BOOLEAN:
                    Valor=cell.getBooleanCellValue();   
                    Valorleido=String.valueOf(Valor);
                   // System.out.println(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                    CellValue cellValue = evaluator.evaluate(cell);
                    switch (cellValue.getCellTypeEnum()) {
                        case STRING:
                            Valorleido=cell.getStringCellValue();
                           // System.out.println(cellValue.getStringValue());
                            break;
                        case NUMERIC:
                           if (DateUtil.isCellDateFormatted(cell)) {
                            // Si es una fecha, puedes leerla como un valor de tipo Date y luego formatearla como String
                            java.util.Date fecha = cell.getDateCellValue();
                           Valorleido = sdf.format(fecha);  // Puedes cambiar este formato según tus necesidades
                           //System.out.println("Fecha: " + Valorleido);
                        } else {
                            Num = cell.getNumericCellValue();
                            if (String.valueOf(Num).length()>5){
                            Valorleido = String.valueOf(Num);     
                            }else{
                            Num2=(int) Num;
                            Valorleido = String.valueOf(Num2); 
                            }
                            
                        }
                            break;
                        case BOOLEAN:
                           Valor=cell.getBooleanCellValue();   
                           Valorleido=String.valueOf(Valor);
                            //System.out.println(cellValue.getBooleanValue());
                            break;
                        case BLANK:
                            Valorleido="";
                            //System.out.println("");
                            break;
                        default:
                            Valorleido=""; 
                           // System.out.println("");
                            break;
                    }
                    break;
                case BLANK:
                    Valorleido="";
                    //System.out.println("");
                    break;
                default:
                    Valorleido=""; 
                    //System.out.println("");
                    break;
            }
        } else {
            System.out.println("COLUMNA vacía");
        }
    } else {
        System.out.println("FILA vacía");
    }
} catch (FileNotFoundException e) {
    System.out.println("No se encontró el archivo: " + filePath);
} catch (IOException e) {
    System.out.println("Error al leer el archivo: " + e.getMessage());
}
  return Valorleido;   
 }
}

    
       
    
        
    
    
    
