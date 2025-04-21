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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Obtener_ultima_Fila {
    
    public int obtenerUltimaFilaConDatos(String nombreHoja) {
    Integrar_TMP Integra = new Integrar_TMP();
    String filePath = Integra.RutaAr;

    int ultimaFila = -1; // Inicializar con un valor que indique que no se encontraron filas con datos

    try (FileInputStream fis = new FileInputStream(filePath);
         Workbook workbook = WorkbookFactory.create(fis)) {

        Sheet sheet = workbook.getSheet(nombreHoja); // Obtener la hoja especificada

        if (sheet != null) {
            ultimaFila = sheet.getLastRowNum(); // Obtener el índice de la última fila con datos
        } else {
            System.out.println("La hoja '" + nombreHoja + "' no existe.");
        }

    } catch (FileNotFoundException e) {
        System.out.println("No se encontró el archivo: " + filePath);
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }

    return ultimaFila;
}
    
    
}
