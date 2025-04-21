/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Convertir_UTF8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Conver_Utf8 {

     public void Convertir_utf8_EBaseDatos(String ruta) {
        String rutaArchivo =ruta;
         // Ruta del nuevo archivo UTF-8
        String replace = ruta.replace(".csv", "UTF8.csv");
       if (ruta.endsWith(".csv")) { 
        try {   
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(rutaArchivo), "Cp1252")); // ANSI (Windows-1252)
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(replace), "UTF-8"));
            writer.write("\uFEFF");
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            // Leer y escribir línea por línea
            //int contadorLineas = 0;
            for (CSVRecord record : csvParser) {
              //  contadorLineas++;
                    // Construir una nueva línea excluyendo las columnas especificadas
                    List<String> nuevaLinea = new ArrayList<>();
                    for (int i = 0; i < record.size(); i++) {
                            nuevaLinea.add(record.get(i));
                    }
                    // Imprimir la nueva línea en el archivo de salida
                    csvPrinter.printRecord(nuevaLinea);
                }
            // Cerrar los recursos
            reader.close();
            csvPrinter.close();
            System.out.println("Archivo convertido a BD UTF-8 CON EXITO.");
        } catch (IOException e) {
            e.printStackTrace();
        }
       }else{
           JOptionPane.showMessageDialog(null, "la extension del archivo no esta en .csv"); 
       } 
    }
}
