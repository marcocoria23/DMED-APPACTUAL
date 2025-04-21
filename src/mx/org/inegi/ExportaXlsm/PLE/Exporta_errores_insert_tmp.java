/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.ExportaXlsm.PLE;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Exporta_errores_insert_tmp {

    public void exportarExcel(JTable tabla, String Entidad, String Envio, String Legislatura) throws FileNotFoundException, IOException {
        try (Workbook libroExcel = new XSSFWorkbook()) {
            Sheet hoja = libroExcel.createSheet("Datos");

            // Obtener el modelo de la tabla
            TableModel modelo = tabla.getModel();

            // Crear estilo para el encabezado
            CellStyle estiloEncabezado = libroExcel.createCellStyle();
            estiloEncabezado.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
            estiloEncabezado.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font font = libroExcel.createFont();
            font.setColor(IndexedColors.WHITE.getIndex());
            estiloEncabezado.setFont(font);
            // Establecer bordes para el encabezado
            estiloEncabezado.setBorderTop(BorderStyle.THIN);
            estiloEncabezado.setBorderBottom(BorderStyle.THIN);
            estiloEncabezado.setBorderLeft(BorderStyle.THIN);
            estiloEncabezado.setBorderRight(BorderStyle.THIN);

            // Crear estilo para Datos Jtable
            CellStyle estiloDatos = libroExcel.createCellStyle();
            // Establecer bordes Datos Jtable
            estiloDatos.setBorderTop(BorderStyle.THIN);
            estiloDatos.setBorderBottom(BorderStyle.THIN);
            estiloDatos.setBorderLeft(BorderStyle.THIN);
            estiloDatos.setBorderRight(BorderStyle.THIN);

            // Crear la fila para las cabeceras
            Row filaCabecera = hoja.createRow(0);
            for (int columna = 0; columna < modelo.getColumnCount(); columna++) {
                //filaCabecera.createCell(columna).setCellValue(modelo.getColumnName(columna));
                Cell celda = filaCabecera.createCell(columna);
                celda.setCellValue(modelo.getColumnName(columna));
                celda.setCellStyle(estiloEncabezado); // Aplicar el estilo al encabezado
            }

            filaCabecera.setHeightInPoints(25);
            // Crear filas para los datos
            for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                Row filaDatos = hoja.createRow(fila + 1); // +1 para dejar espacio para las cabeceras
                for (int columna = 0; columna < modelo.getColumnCount(); columna++) {
                    Cell celda = filaDatos.createCell(columna);
                    celda.setCellValue(modelo.getValueAt(fila, columna).toString());
                    celda.setCellStyle(estiloDatos); // Aplicar el estilo a los datos
                }
            }
            // Ajustar automáticamente el ancho de las columnas según el contenido
            for (int columna = 0; columna < modelo.getColumnCount(); columna++) {
                hoja.autoSizeColumn(columna);
            }

            // Escribir el libro a un archivo
            // JFrame frame;
            FileDialog d = new FileDialog(new JFrame(), "Guardar", FileDialog.SAVE);
            d.setFile("PLE_Exporta_Ent_" + Entidad + "_Env_" + Envio + "_Leg_" + Legislatura + ".xlsx");
            d.setVisible(true);

            String dir = d.getDirectory();
            String file = d.getFile();

            if (dir != null && file != null) {
                File outputFile = new File(dir + file + ".xlsx");
                try {
                    FileOutputStream fos = new FileOutputStream(outputFile);
                    libroExcel.write(fos);
                    fos.close();
                    JOptionPane.showMessageDialog(null, "Archivo guardado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Archivo Excel exportado correctamente.");
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // El usuario canceló el diálogo o no seleccionó un archivo.
                System.out.println("Operación de guardado cancelada por el usuario.");
            }
        }

    }

}
