/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.Reportes.PLE;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import mx.org.inegi.conexion.PLE.DaoConexion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author LAURA.MEDINAJ
 */
public class Genera_reporte_FechaTermino {

    public void exportarUltimosEnvios() throws IOException, SQLException {
        // Tu Query original
       String query = "SELECT ENTIDAD, P1_1_9 AS fecha_termino, LEGISLATURA, C1_1_ID AS ultimo_envio, ESTATUS " +
                       "FROM TR_PLE_MEDS1_1 t " +
                       "WHERE C1_1_ID = (SELECT MAX(C1_1_ID) FROM TR_PLE_MEDS1_1 WHERE ENTIDAD = t.ENTIDAD) ORDER BY ENTIDAD";

        DaoConexion dao = new DaoConexion();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte PLE");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
        fileChooser.setSelectedFile(new File("Reporte_FechaTermino_PLE.xlsx"));

        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // CORRECCIÓN 1: Obtener el archivo seleccionado del fileChooser
            File archivoDestino = fileChooser.getSelectedFile();
            
            // Asegurar que tenga la extensión .xlsx
            String ruta = archivoDestino.getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".xlsx")) {
                archivoDestino = new File(ruta + ".xlsx");
            }

            try {
                dao.Conectar();
                ResultSet rs = dao.consultar(query);

                if (rs == null) {
                    JOptionPane.showMessageDialog(null, "No se obtuvieron datos de la base de datos.");
                    return;
                }

                Workbook workbook = new XSSFWorkbook();
                Sheet hoja = workbook.createSheet("Reporte PLE");

                // --- ESTILOS ---
                CellStyle headerStyle = workbook.createCellStyle();
                headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerStyle.setAlignment(HorizontalAlignment.CENTER);
                headerStyle.setBorderBottom(BorderStyle.THIN);
                headerStyle.setBottomBorderColor(IndexedColors.WHITE.getIndex());

                Font headerFont = workbook.createFont();
                headerFont.setColor(IndexedColors.WHITE.getIndex());
                headerFont.setBold(true);
                headerStyle.setFont(headerFont);

                CellStyle dataStyle = workbook.createCellStyle();
                dataStyle.setBorderBottom(BorderStyle.THIN);
                dataStyle.setBottomBorderColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
                dataStyle.setBorderLeft(BorderStyle.THIN);
                dataStyle.setLeftBorderColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
                dataStyle.setBorderRight(BorderStyle.THIN);
                dataStyle.setRightBorderColor(IndexedColors.CORNFLOWER_BLUE.getIndex());

                // --- ENCABEZADOS ---
                String[] columnas = {"ENTIDAD", "FECHA TÉRMINO", "LEGISLATURA", "ÚLTIMO ENVÍO", "ESTATUS"};
                Row rowHeader = hoja.createRow(0);
                for (int i = 0; i < columnas.length; i++) {
                    Cell cell = rowHeader.createCell(i);
                    cell.setCellValue(columnas[i]);
                    cell.setCellStyle(headerStyle);
                }

                // --- DATOS ---
                int rowNum = 1;
                while (rs.next()) {
                    Row fila = hoja.createRow(rowNum++);
                    
                    // CORRECCIÓN 2: Crear celdas y aplicar dataStyle a cada una
                    Cell c0 = fila.createCell(0); c0.setCellValue(rs.getString("ENTIDAD")); c0.setCellStyle(dataStyle);
                    Cell c1 = fila.createCell(1); c1.setCellValue(rs.getString("fecha_termino")); c1.setCellStyle(dataStyle);
                    Cell c2 = fila.createCell(2); c2.setCellValue(rs.getString("LEGISLATURA")); c2.setCellStyle(dataStyle);
                    Cell c3 = fila.createCell(3); c3.setCellValue(rs.getLong("ultimo_envio")); c3.setCellStyle(dataStyle);
                    Cell c4 = fila.createCell(4); c4.setCellValue(rs.getString("ESTATUS")); c4.setCellStyle(dataStyle);
                }

                for (int i = 0; i < columnas.length; i++) {
                    hoja.autoSizeColumn(i);
                }
                
                // Activar Filtros (opcional, como en tu imagen)
                hoja.setAutoFilter(new CellRangeAddress(0, 0, 0, columnas.length - 1));

                // CORRECCIÓN 3: Guardar usando archivoDestino
                try (FileOutputStream fileOut = new FileOutputStream(archivoDestino)) {
                    workbook.write(fileOut);
                }
                
                // CORRECCIÓN 4: Cerrar el workbook para liberar memoria
                workbook.close();

                JOptionPane.showMessageDialog(null, "Reporte generado exitosamente en:\n" + archivoDestino.getAbsolutePath());
                
                rs.close();
                dao.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error General: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }}
}