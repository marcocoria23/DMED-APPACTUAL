/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesTEPJF;

import java.awt.FileDialog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Exporta_validaciones {

    ArrayList<String[]> ArrayResult;
    String[] parts;
    String parts0 = "", parts1 = "", parts2 = "", partsfechas = "";
    JFrame f = new JFrame("Progreso Exporta TEPJF.xlsx");

    public void ValidacionTEPJF() throws IOException {

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container content = f.getContentPane();
        JProgressBar progressBar = new JProgressBar();
        progressBar.removeAll();
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        Border border = BorderFactory.createTitledBorder("Cargando...");
        progressBar.setBorder(border);
        content.add(progressBar, BorderLayout.CENTER);

        f.setSize(300, 100);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");

        XSSFWorkbook libro = new XSSFWorkbook();

        XSSFCellStyle estiloCelda0 = libro.createCellStyle();
        XSSFCellStyle estiloCelda2 = libro.createCellStyle();

        XSSFFont fuente0 = libro.createFont();
        fuente0.setFontHeightInPoints((short) 12);
        fuente0.setColor(IndexedColors.WHITE.getIndex());
        fuente0.setFontName("Arial");
        fuente0.setBold(true);
        estiloCelda0.setFont(fuente0);
        estiloCelda0.setWrapText(true);
        estiloCelda0.setAlignment(HorizontalAlignment.CENTER);
        estiloCelda0.setVerticalAlignment(VerticalAlignment.CENTER);
        estiloCelda0.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        estiloCelda0.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFCellStyle estiloCelda1 = libro.createCellStyle();
        XSSFFont fuente2 = libro.createFont();
        fuente2.setFontHeightInPoints((short) 10);
        fuente2.setColor(IndexedColors.WHITE.getIndex());
        fuente2.setFontName("Arial");
        fuente2.setBold(true);
        estiloCelda1.setFont(fuente2);
        estiloCelda1.setWrapText(true);
        estiloCelda1.setAlignment(HorizontalAlignment.CENTER);
        estiloCelda1.setVerticalAlignment(VerticalAlignment.CENTER);
        estiloCelda1.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        estiloCelda1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estiloCelda1.setBorderBottom(BorderStyle.THIN);
        estiloCelda1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        estiloCelda1.setBorderLeft(BorderStyle.MEDIUM);
        estiloCelda1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        estiloCelda1.setBorderRight(BorderStyle.MEDIUM);
        estiloCelda1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        estiloCelda1.setBorderTop(BorderStyle.THIN);
        estiloCelda1.setTopBorderColor(IndexedColors.BLACK.getIndex());

        XSSFCellStyle PAmarillo = libro.createCellStyle();
        PAmarillo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        PAmarillo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        PAmarillo.setBorderBottom(BorderStyle.THIN);
        PAmarillo.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        PAmarillo.setBorderLeft(BorderStyle.MEDIUM);
        PAmarillo.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        PAmarillo.setBorderRight(BorderStyle.MEDIUM);
        PAmarillo.setRightBorderColor(IndexedColors.BLACK.getIndex());
        PAmarillo.setBorderTop(BorderStyle.THIN);
        PAmarillo.setTopBorderColor(IndexedColors.BLACK.getIndex());
        PAmarillo.setAlignment(HorizontalAlignment.CENTER);

        XSSFCellStyle estiloCeldabordes0 = libro.createCellStyle();
        estiloCeldabordes0.setBorderBottom(BorderStyle.THIN);
        estiloCeldabordes0.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        estiloCeldabordes0.setBorderLeft(BorderStyle.MEDIUM);
        estiloCeldabordes0.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        estiloCeldabordes0.setBorderRight(BorderStyle.MEDIUM);
        estiloCeldabordes0.setRightBorderColor(IndexedColors.BLACK.getIndex());
        estiloCeldabordes0.setBorderTop(BorderStyle.THIN);
        estiloCeldabordes0.setTopBorderColor(IndexedColors.BLACK.getIndex());
        estiloCeldabordes0.setAlignment(HorizontalAlignment.LEFT);
        XSSFFont fuente1 = libro.createFont();
        fuente1.setFontHeightInPoints((short) 11);
        fuente1.setFontName("Arial");
        estiloCeldabordes0.setFont(fuente1);
        estiloCeldabordes0.setAlignment(HorizontalAlignment.CENTER);

        estiloCelda2.setFont(fuente1);
        estiloCelda2.setWrapText(true);
        estiloCelda2.setAlignment(HorizontalAlignment.LEFT);
//estiloCelda2.setVerticalAlignment(VerticalAlignment.LEFT);
        estiloCelda2.setBorderBottom(BorderStyle.THIN);
        estiloCelda2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        estiloCelda2.setBorderLeft(BorderStyle.MEDIUM);
        estiloCelda2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        estiloCelda2.setBorderRight(BorderStyle.MEDIUM);
        estiloCelda2.setRightBorderColor(IndexedColors.BLACK.getIndex());
        estiloCelda2.setBorderTop(BorderStyle.THIN);
        estiloCelda2.setTopBorderColor(IndexedColors.BLACK.getIndex());

        XSSFSheet hojaExpedientes = libro.createSheet("Expedientes");
        hojaExpedientes.setColumnWidth(0, 8000);
        hojaExpedientes.setColumnWidth(1, 6000);
        hojaExpedientes.setColumnWidth(2, 12000);
        hojaExpedientes.setColumnWidth(3, 12000);
        hojaExpedientes.setColumnWidth(4, 6000);

        XSSFSheet hojaActores = libro.createSheet("Actores");
        hojaActores.setColumnWidth(0, 6000);
        hojaActores.setColumnWidth(1, 6000);
        hojaActores.setColumnWidth(2, 12000);
        hojaActores.setColumnWidth(3, 12000);
        hojaActores.setColumnWidth(4, 6000);

        XSSFSheet hojaResponsables = libro.createSheet("Responsables");
        hojaResponsables.setColumnWidth(0, 6000);
        hojaResponsables.setColumnWidth(1, 6000);
        hojaResponsables.setColumnWidth(2, 12000);
        hojaResponsables.setColumnWidth(3, 12000);
        hojaResponsables.setColumnWidth(4, 6000);
        hojaResponsables.setColumnWidth(5, 6000);

        XSSFSheet hojaResoluciones = libro.createSheet("Resoluciones");
        hojaResoluciones.setColumnWidth(0, 6000);
        hojaResoluciones.setColumnWidth(1, 6000);
        hojaResoluciones.setColumnWidth(2, 12000);
        hojaResoluciones.setColumnWidth(3, 12000);
        hojaResoluciones.setColumnWidth(4, 6000);
        hojaResoluciones.setColumnWidth(5, 12000);
        hojaResoluciones.setColumnWidth(6, 12000);

        Despliega_Expedientes(libro, hojaExpedientes, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);
        Despliega_Actores(libro, hojaActores, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);
        Despliega_Responsables(libro, hojaResponsables, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);
        Despliega_Resoluciones(libro, hojaResoluciones, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);

        SaveFileTo(libro, progressBar, f, dtf);

    }

    public void Despliega_Expedientes(XSSFWorkbook libro, XSSFSheet hojaExpedientes, XSSFCellStyle estiloCelda0, XSSFCellStyle estiloCelda1, XSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) {

        int conEnc = 1, conDat = 2, coni = 1;
        Border border = BorderFactory.createTitledBorder("Cargando...Expedientes");
        progressBar.setBorder(border);
        progressBar.setValue(15);

        XSSFRow row00 = hojaExpedientes.createRow(0); // Fila
        XSSFCell celda00 = row00.createCell(0); // Columna
        celda00.setCellStyle(estiloCelda0);
        celda00.setCellType(CellType.STRING);
        String titulo00 = "Expedientes ";
        XSSFRichTextString texto00 = new XSSFRichTextString(titulo00);
        hojaExpedientes.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        celda00.setCellValue(texto00);
        row00.setHeight((short) 600);
        Valida_Expedientes In = new Valida_Expedientes();

        
        ArrayResult = In.Cant_actores();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "campo Cant_Actores debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
        
        ArrayResult = In.Cant_responsables();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "campo CANT_RESPONSABLES debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
        ArrayResult = In.Cant_terceros_interesados();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "campo CANT_TERCEROS_INTERESADOS debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
        ArrayResult = In.Periodo();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "campo Periodo debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_SALA();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "campo DES_SALA(tp_sala) debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.NOMBRE_MAGISTRADO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "campo NOMBRE_MAGISTRADO debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.FECHA_INGRESO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "campo FECHA_INGRESO debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_ESTATUS_EXP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "campo ID_ESTATUS_EXP(estatus_expediente) debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.FECHA_ING_ARCHIVO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar FECHA_ING_ARCHIVO ya que ID_ESTATUS_EXP(ID_exp)='En instrucción o trámite'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.FECHA_ING_ARCHIVO_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor de capturar FECHA_ING_ARCHIVO ya que ID_ESTATUS_EXP(ID_exp)='Concluido'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.FECHA_ING_ARCHIVO_FECHA_INGRESO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "La FECHA_ING_ARCHIVO no debe ser menor a la FECHA_INGRESO";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AMBITO_ASUNTO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "ID_AMBITO_ASUNTO(amb_asunto) debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEE();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "DES_AGEE(entidad_federativa) debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEE_FUERA_CIRC();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar ID_AGEE_FUERA_CIRC(clave_AGEE_fuera_circunscripcion) ya que DES_AGEE(entidad_federativa)= es diferente a 'Fuera de circunscripción'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEE_FUERA_CIRC_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor  de capturar ID_AGEE_FUERA_CIRC(clave_AGEE_fuera_circunscripcion) ya que DES_AGEE(entidad_federativa)= 'Fuera de circunscripción'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEE_FUERA_CIRC();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar DES_AGEE_FUERA_CIRC(fuera_circunscripcion_entidad_federativa) ya que DES_AGEE(entidad_federativa)= es diferente a 'Fuera de circunscripción'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEE_FUERA_CIRC_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor  de capturar DES_AGEE_FUERA_CIRC(fuera_circunscripcion_entidad_federativa) ya que DES_AGEE(entidad_federativa)= 'Fuera de circunscripción'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEE_FEDERAL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar ID_AGEE_FEDERAL(clave_AGEE_federal) ya que DES_AGEE(entidad_federativa)= es diferente a 'Federal'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEE_FEDERAL_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor de capturar ID_AGEE_FEDERAL(clave_AGEE_federal) ya que DES_AGEE(entidad_federativa)= es igual a 'Federal'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEE_FEDERAL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar DES_AGEE_FEDERAL(federal_entidad federativa)  ya que DES_AGEE(entidad_federativa)= es diferente a 'Federal'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEE_FEDERAL_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor de capturar DES_AGEE_FEDERAL ya que DES_AGEE(entidad_federativa)= es igual a 'Federal'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEM();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar ID_AGEM ya que DES_AGEE es igual ('Fuera de circunscripción' o 'Federal')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEM_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor de capturar ID_AGEM(clave_AGEM) ya que DES_AGEE(entidad_federativa)= es diferente a  ('Fuera de circunscripción' o 'Federal')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEM_FUERA_CIRC();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar ID_AGEM_FUERA_CIRC(clave_AGEM_fuera_circunscripcion) ya que DES_AGEE(entidad_federativa)= es diferente a ('Fuera de circunscripción')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEM_FUERA_CIRC_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor debe de capturar ID_AGEM_FUERA_CIRC(clave_AGEM_fuera_circunscripcion) ya que DES_AGEE(entidad_federativa)= es igual a ('Fuera de circunscripción')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEM_FUERA_CIRC();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar DES_AGEM_FUERA_CIRC(fuera_circunscripcion_municipio) ya que DES_AGEE(entidad_federativa)= es diferente a ('Fuera de circunscripción')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEM_FUERA_CIRC_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor de capturar DES_AGEM_FUERA_CIRC(fuera_circunscripcion_municipio) ya que DES_AGEE(entidad_federativa)= es igual a ('Fuera de circunscripción')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEM_FEDERAL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar ID_AGEM_FEDERAL(clave_AGEM_federal) ya que DES_AGEE(entidad_federativa)= es diferente a ('Federal')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_AGEM_FEDERAL_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor  de capturar ID_AGEM_FEDERAL(clave_AGEM_federal) ya que DES_AGEE(entidad_federativa)= es igual a ('Federal')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEM_FEDERAL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar DES_AGEM_FEDERAL(federal_municipio) ya que DES_AGEE(entidad_federativa)= es diferente a ('Federal')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_AGEM_FEDERAL_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor de capturar DES_AGEM_FEDERAL(federal_municipio) ya que DES_AGEE(entidad_federativa)= es igual a ('Federal')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DES_MEDIO_IMPUGNACION();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "El campo DES_MEDIO_IMPUGNACION(tp_medio_impugnacion) debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_MATERIA();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "El campo ID_MATERIA(materia) debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_MATERIA();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "El campo ID_MATERIA(materia) debe ser obligatorio";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_VINCULACION_PROCESO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar ID_VINCULACION_PROCESO(cond_vinc_proceso_elec) ya que ID_MATERIA(materia)= es diferente a ('Electoral')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_VINCULACION_PROCESO_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor de capturar ID_VINCULACION_PROCESO(cond_vinc_proceso_elec) ya que ID_MATERIA(materia)= es igual a ('Electoral')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA1_IMPUGNACION_N1();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "ID_MATERIA (Materia) debe ser =Laboral ya que TEMA1_IMPUGNACION_N1(tm_impug_1_nivel_1) =26 \"Controversias laborales\"";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA1_IMPUGNACION_N1_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Favor de capturar TEMA1_IMPUGNACION_N1 ya que ID_MATERIA(materia)= es igual a ('Laboral')";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA1_IMPUGNACION_N2();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA1_IMPUGNACION_N2 ya que TEMA1_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA1_IMPUGNACION_N3();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA1_IMPUGNACION_N3 ya que TEMA1_IMPUGNACION_N2 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA1_IMPUGNACION_N4();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA1_IMPUGNACION_N4 ya que TEMA1_IMPUGNACION_N3 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA2_IMPUGNACION_N1();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA2_IMPUGNACION_N1 ya que TEMA1_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA2_IMPUGNACION_N2();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA2_IMPUGNACION_N2 ya que TEMA2_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA2_IMPUGNACION_N3();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA2_IMPUGNACION_N3 ya que TEMA2_IMPUGNACION_N2 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA2_IMPUGNACION_N4();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA2_IMPUGNACION_N4 ya que TEMA2_IMPUGNACION_N3 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA3_IMPUGNACION_N1();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA3_IMPUGNACION_N1 ya que TEMA2_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA3_IMPUGNACION_N2();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA3_IMPUGNACION_N2 ya que TEMA3_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA3_IMPUGNACION_N3();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA3_IMPUGNACION_N3 ya que TEMA3_IMPUGNACION_N2 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA3_IMPUGNACION_N4();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA3_IMPUGNACION_N4 ya que TEMA3_IMPUGNACION_N3 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA4_IMPUGNACION_N1();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA4_IMPUGNACION_N1 ya que TEMA3_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA4_IMPUGNACION_N2();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA4_IMPUGNACION_N2 ya que TEMA4_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA4_IMPUGNACION_N3();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA4_IMPUGNACION_N3 ya que TEMA4_IMPUGNACION_N2 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA4_IMPUGNACION_N4();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA4_IMPUGNACION_N4 ya que TEMA4_IMPUGNACION_N3 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA5_IMPUGNACION_N1();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA5_IMPUGNACION_N1 ya que TEMA4_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA5_IMPUGNACION_N2();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA5_IMPUGNACION_N2 ya que TEMA5_IMPUGNACION_N1 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA5_IMPUGNACION_N3();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA5_IMPUGNACION_N3 ya que TEMA5_IMPUGNACION_N2 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TEMA5_IMPUGNACION_N4();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar TEMA5_IMPUGNACION_N4 ya que TEMA5_IMPUGNACION_N3 es igual a null";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.Otro_Tema1();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar Otro_Tema1 ya que TEMA1_IMPUGNACION_N1 es diferente a 'Otro tema (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.Otro_Tema2();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar Otro_Tema2 ya que TEMA1_IMPUGNACION_N2 es diferente a 'Otro tema (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.Otro_Tema3();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar Otro_Tema3 ya que TEMA1_IMPUGNACION_N3 es diferente a 'Otro tema (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.Otro_Tema4();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar Otro_Tema4 ya que TEMA1_IMPUGNACION_N4 es diferente a 'Otro tema (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.Otro_Tema5();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Observaciones";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "No debe de capturar Otro_Tema5 ya que TEMA1_IMPUGNACION_N5 es diferente a 'Otro tema (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.CANT_DESGLOSE_ACTORES();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "CANT_ACTORES_EXPEDIENTE";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "CANTIDAD_ACTORES_DESGLOSE";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "La cantidad capturada en EXPEDIENTE no coincide con su desglose en Actor";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.CANT_DESGLOSE_RESPONSABLES();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "CANT_RESPONSABLES_EXPEDIENTE";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "CANTIDAD_RESPONSABLES_DESGLOSE";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaExpedientes.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "La cantidad capturada en EXPEDIENTE no coincide con su desglose en Responsables";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        progressBar.setValue(25);
    }

    public void Despliega_Actores(XSSFWorkbook libro, XSSFSheet hojaActores, XSSFCellStyle estiloCelda0, XSSFCellStyle estiloCelda1, XSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) {

        int conEnc = 1, conDat = 2, coni = 1;
        Border border = BorderFactory.createTitledBorder("Cargando...Actores");
        progressBar.setBorder(border);

        XSSFRow row00 = hojaActores.createRow(0); // Fila
        XSSFCell celda00 = row00.createCell(0); // Columna
        celda00.setCellStyle(estiloCelda0);
        celda00.setCellType(CellType.STRING);
        String titulo00 = "Actores ";
        XSSFRichTextString texto00 = new XSSFRichTextString(titulo00);
        hojaActores.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        celda00.setCellValue(texto00);
        row00.setHeight((short) 600);
        Valida_Actores In = new Valida_Actores();

        ArrayResult = In.ID_ACTOR_DUP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Id_actor se encuentra duplicado";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_EXPE_REL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "EL ID_EXPEDIENTE NO SE ENCUENTRA EN TABLA EXPEDIENTES";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.CLASE_ACTOR();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "CAMPO CLASE_ACTOR ES OBLIGATORIO";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_CLASE_ACTOR_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Favor de capturar OTRO_CLASE_ACTOR ya que CLASE_ACTOR es igual a 'Otro actor'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_CLASE_ACTOR();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe  de capturar OTRO_CLASE_ACTOR ya que CLASE_ACTOR es diferente a 'Otro actor'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_CLASE_SEXO_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe  de capturar OTRO_CLASE_ACTOR ya que CLASE_ACTOR es diferente a 'Otro actor'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_CLASE_SEXO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar SEXO ya que CLASE_ACTOR es difernete a  \"Ciudadano\" o \"Candidato\"";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.COND_REPRESENTACION_LEGAL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Campo COND_REPRES_ACTOR(cond_representacion_legal) es Obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.PART_POLITICO_NAC_ACTOR_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Favor de capturar PART_POLITICO_NAC_ACTOR ya que CLASE_ACTOR es igual a  \"Partido político nacional\"";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.PART_POLITICO_NAC_ACTOR();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar PART_POLITICO_NAC_ACTOR ya que CLASE_ACTOR es diferente a  \"Partido político nacional\"";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.PART_POLITICO_LOCAL_ACTOR_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Favor de capturar part_politico_local_actor ya que CLASE_ACTOR es igual a  \"Partido político local\"";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.PART_POLITICO_LOCAL_ACTOR();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar part_politico_local_actor ya que CLASE_ACTOR es diferente a  Partido político local";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SALA_ACTOR_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Favor de capturar sala_actor ya que CLASE_ACTOR es igual a Sala del Tribunal Electoral del Poder Judicial de la Federación.";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SALA_ACTOR();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar sala_actor ya que CLASE_ACTOR es diferente a Sala del Tribunal Electoral del Poder Judicial de la Federación";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SALA_ACTOR();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaActores.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_ACTOR(ID_actor)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaActores.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar sala_actor ya que CLASE_ACTOR es diferente a Sala del Tribunal Electoral del Poder Judicial de la Federación";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        progressBar.setValue(50);

    }

    public void Despliega_Responsables(XSSFWorkbook libro, XSSFSheet hojaResponsables, XSSFCellStyle estiloCelda0, XSSFCellStyle estiloCelda1, XSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) {

        int conEnc = 1, conDat = 2, coni = 1;
        Border border = BorderFactory.createTitledBorder("Cargando...Responsables");
        progressBar.setBorder(border);

        XSSFRow row00 = hojaResponsables.createRow(0); // Fila
        XSSFCell celda00 = row00.createCell(0); // Columna
        celda00.setCellStyle(estiloCelda0);
        celda00.setCellType(CellType.STRING);
        String titulo00 = "Responsables ";
        XSSFRichTextString texto00 = new XSSFRichTextString(titulo00);
        hojaResponsables.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        celda00.setCellValue(texto00);
        row00.setHeight((short) 600);
        Valida_Responsables In = new Valida_Responsables();

        ArrayResult = In.ID_RESPONSABLE_DUP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLE(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Id_Responsable se encuentra duplicado";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_EXPE_REL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "EL ID_EXPEDIENTE NO SE ENCUENTRA EN TABLA EXPEDIENTES";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.CLASE_RESPONSABLE();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Campo CLASE_RESPONSABLE es obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_CLASE_RESPONSABLE_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Favor de capturar campo OTRO_CLASE_RESPONSABLE ya que CLASE_RESPONSABLE='Otro responsable (especifique)'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_CLASE_RESPONSABLE();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar campo OTRO_CLASE_RESPONSABLE ya que CLASE_RESPONSABLE no es igual a 'Otro responsable (especifique)'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.PART_POLITICO_NAC_RESPONS_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Favor de capturar campo PART_POLITICO_NAC_RESPONS(part_politico_nac_responsable) ya que CLASE_RESPONSABLE='Partido político nacional'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.PART_POLITICO_NAC_RESPONS();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar campo PART_POLITICO_NAC_RESPONS(part_politico_nac_responsable) ya que CLASE_RESPONSABLE es diferente a 'Partido político nacional'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.PART_POLITICO_LOCAL_RESPONS_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Favor de capturar campo PART_POLITICO_LOCAL_RESPONS(part_politico_local_responsable) ya que CLASE_RESPONSABLE='Partido político local'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.PART_POLITICO_LOCAL_RESPONS();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar campo PART_POLITICO_LOCAL_RESPONS(part_politico_local_responsable) ya que CLASE_RESPONSABLE es diferente a 'Partido político local'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SALA_RESPONSABLE_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Favor de capturar campo SALA_RESPONSABLE ya que CLASE_RESPONSABLE='Sala del Tribunal Electoral del Poder Judicial de la Federación'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SALA_RESPONSABLE();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResponsables.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESPONSABLES(ID_responsable)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResponsables.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar campo SALA_RESPONSABLE ya que CLASE_RESPONSABLE es diferente a 'Sala del Tribunal Electoral del Poder Judicial de la Federación'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        progressBar.setValue(75);

    }

    public void Despliega_Resoluciones(XSSFWorkbook libro, XSSFSheet hojaResoluciones, XSSFCellStyle estiloCelda0, XSSFCellStyle estiloCelda1, XSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) {

        int conEnc = 1, conDat = 2, coni = 1;
        Border border = BorderFactory.createTitledBorder("Cargando...Resoluciones");
        progressBar.setBorder(border);

        XSSFRow row00 = hojaResoluciones.createRow(0); // Fila
        XSSFCell celda00 = row00.createCell(0); // Columna
        celda00.setCellStyle(estiloCelda0);
        celda00.setCellType(CellType.STRING);
        String titulo00 = "Resoluciones ";
        XSSFRichTextString texto00 = new XSSFRichTextString(titulo00);
        hojaResoluciones.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        celda00.setCellValue(texto00);
        row00.setHeight((short) 600);
        Valida_Resoluciones In = new Valida_Resoluciones();

        ArrayResult = In.ID_RESOLUCIONES_DUP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "Id_Resoluciones se encuentra duplicado";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.ID_EXPE_REL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Validacion";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = "EL ID_EXPEDIENTE NO SE ENCUENTRA EN TABLA EXPEDIENTES";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.CONCLUIDO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "ID_ESTATUS_EXP(estatus_expediente) de la tabla EXPEDIENTE debe estar como Concluido";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.FECHA_RESOL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "CAMPO FECHA_RESOL(fecha_resolucion) es obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.FECHA_RESOL_ENTRE();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "FECHA_RESOL(fecha_resolucion)";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "FECHA_INGRESO";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            XSSFCell celdaE5 = filaEE1.createCell(4);//COLUMNA
            celdaE5.setCellStyle(estiloCelda1);
            celdaE5.setCellType(CellType.STRING);
            String txtE5 = "FECHA_ING_ARCHIVO";
            XSSFRichTextString textoE5 = new XSSFRichTextString(txtE5);
            celdaE5.setCellValue(textoE5);

            XSSFCell celdaE6 = filaEE1.createCell(5);//COLUMNA
            celdaE6.setCellStyle(estiloCelda1);
            celdaE6.setCellType(CellType.STRING);
            String txtE6 = "Observaciones";
            XSSFRichTextString textoE6 = new XSSFRichTextString(txtE6);
            celdaE6.setCellValue(textoE6);

            XSSFCell celdaE7 = filaEE1.createCell(6);//COLUMNA
            celdaE7.setCellStyle(estiloCelda1);
            celdaE7.setCellType(CellType.STRING);
            String txtE7 = "Validacion";
            XSSFRichTextString textoE7 = new XSSFRichTextString(txtE7);
            celdaE7.setCellValue(textoE7);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = Arrays.toString(ArrayResult.get(i));
                txtD4 = txtD4.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts4 = parts[3].trim();
                XSSFRichTextString textoD4 = new XSSFRichTextString(parts4);
                celdaD4.setCellValue(textoD4);

                XSSFCell celdaD5 = filaEE2.createCell(4);//COLUMNA
                celdaD5.setCellStyle(estiloCeldabordes0);
                celdaD5.setCellType(CellType.STRING);
                String txtD5 = Arrays.toString(ArrayResult.get(i));
                txtD5 = txtD5.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts5 = parts[4].trim();
                XSSFRichTextString textoD5 = new XSSFRichTextString(parts5);
                celdaD5.setCellValue(textoD5);

                XSSFCell celdaD6 = filaEE2.createCell(5);//COLUMNA
                celdaD6.setCellStyle(estiloCeldabordes0);
                celdaD6.setCellType(CellType.STRING);
                String txtD6 = Arrays.toString(ArrayResult.get(i));
                txtD6 = txtD6.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts6 = parts[5].trim();
                XSSFRichTextString textoD6 = new XSSFRichTextString(parts6);
                celdaD6.setCellValue(textoD6);

                XSSFCell celdaD7 = filaEE2.createCell(6);//COLUMNA
                celdaD7.setCellStyle(estiloCeldabordes0);
                celdaD7.setCellType(CellType.STRING);
                String txtD7 = "FECHA_RESOL(fecha_resolucion) Debe estar comprendida dentro del periodo transcurrido entre la fecha de ingreso del expediente y su fecha de ingreso a archivo, registradas en la tabla \"Control_expediente\"";
                XSSFRichTextString textoD7 = new XSSFRichTextString(txtD7);
                celdaD7.setCellValue(textoD7);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TP_SESION();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "CAMPO TP_SESION es obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TP_RESOLUCION();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "CAMPO TP_RESOLUCION es obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TP_RESOLUCION_SENTENCIA();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No puede tener como valor 'Sentencia' si se seleccionó la categoría \"Fuera de circunscripción\" en la columna entidad_federativa de la tabla expediente";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_TP_RESOLUCION_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Debe de capturar Campo OTRO_TP_RESOLUCION ya que TP_RESOLUCION es igual a Otra resolución (especifique)";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_TP_RESOLUCION();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No Debe de capturar Campo OTRO_TP_RESOLUCION ya que TP_RESOLUCION es diferente a 'otra resolucion'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.TP_RESOLUCION_F();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Campo TP_RESOLUCION_F es obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SENTIDO_RESOLUCION_F_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Debe de capturar Campo SENTIDO_RESOLUCION_F(sentido_resolucion_fondo) ya que TP_RESOLUCION_F es igual a 'Resuelto de fondo'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SENTIDO_RESOLUCION_F();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No Debe de capturar Campo SENTIDO_RESOLUCION_F(sentido_resolucion_fondo) ya que TP_RESOLUCION_F no es igual a 'Resuelto de fondo'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_SENTIDO_RESOLUCION_F_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Debe de capturar Campo OTRO_SENTIDO_RESOLUCION_F(otro_sentido_resolucion_fondo) ya que SENTIDO_RESOLUCION_F(sentido_resolucion_fondo) es igual a 'otra resolucion de fondo'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_SENTIDO_RESOLUCION_F();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar Campo OTRO_SENTIDO_RESOLUCION_F(otro_sentido_resolucion_fondo) ya que SENTIDO_RESOLUCION_F(sentido_resolucion_fondo) es diferente a 'otra resolucion de fondo'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SENTIDO_RESOLUCION_NF_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Debe de capturar Campo SENTIDO_RESOLUCION_NF(sentido_resolucion_no_fondo) ya que TP_RESOLUCION_F es igual a 'No resuelto de fondo'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SENTIDO_RESOLUCION_NF();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar Campo SENTIDO_RESOLUCION_NF(sentido_resolucion_no_fondo) ya que TP_RESOLUCION_F es diferente a 'No resuelto de fondo'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.SENTIDO_RESOLUCION_NF_COM();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No puede tener como valor \"Competencia de otra sala\" si no se seleccionó la categoría \"Fuera de circunscripción\" en la columna entitdad federativa de la tabla Control_expediente.";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_SENTIDO_RESOLUCION_NF_CAP();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Debe de capturar Campo OTRO_SENTIDO_RESOLUCION_NF(otro_sentido_resolucion_no_fondo) ya que SENTIDO_RESOLUCION_NF(sentido_resolucion_no_fondo) es igual a 'otra resolucion de no fondo'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.OTRO_SENTIDO_RESOLUCION_NF();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "No debe de capturar Campo OTRO_SENTIDO_RESOLUCION_NF(otro_sentido_resolucion_no_fondo) ya que SENTIDO_RESOLUCION_NF(sentido_resolucion_no_fondo) es diferente a 'otra resolucion de no fondo'";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.DURACION_PROCESO();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Campo DURACION_PROCESO Obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.COND_IMPUGN();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Campo COND_IMPUGN(cond_impug) Obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.FECHA_ACUERDO_CUMPL();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "Observaciones";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Validacion";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = "Campo FECHA_ACUERDO_CUMPL Obligatorio";
                XSSFRichTextString textoD4 = new XSSFRichTextString(txtD4);
                celdaD4.setCellValue(textoD4);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = In.FECHA_ACUERDO_CUMPL_COMPREND();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaResoluciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_TEPJF_EXPEDIENTE(ID_exp)";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "ID_TEPJF_RESOLUCIONES(ID_resolucion)";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE3 = filaEE1.createCell(2);//COLUMNA
            celdaE3.setCellStyle(estiloCelda1);
            celdaE3.setCellType(CellType.STRING);
            String txtE3 = "FECHA_RESOL";
            XSSFRichTextString textoE3 = new XSSFRichTextString(txtE3);
            celdaE3.setCellValue(textoE3);

            XSSFCell celdaE4 = filaEE1.createCell(3);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "FECHA_ACUERDO_CUMPL";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);

            XSSFCell celdaE5 = filaEE1.createCell(4);//COLUMNA
            celdaE5.setCellStyle(estiloCelda1);
            celdaE5.setCellType(CellType.STRING);
            String txtE5 = "FECHA_ING_ARCHIVO";
            XSSFRichTextString textoE5 = new XSSFRichTextString(txtE5);
            celdaE5.setCellValue(textoE5);

            XSSFCell celdaE6 = filaEE1.createCell(5);//COLUMNA
            celdaE6.setCellStyle(estiloCelda1);
            celdaE6.setCellType(CellType.STRING);
            String txtE6 = "Observaciones";
            XSSFRichTextString textoE6 = new XSSFRichTextString(txtE6);
            celdaE6.setCellValue(textoE6);

            XSSFCell celdaE7 = filaEE1.createCell(6);//COLUMNA
            celdaE7.setCellStyle(estiloCelda1);
            celdaE7.setCellType(CellType.STRING);
            String txtE7 = "Validacion";
            XSSFRichTextString textoE7 = new XSSFRichTextString(txtE7);
            celdaE7.setCellValue(textoE7);

            for (int i = 0; i < ArrayResult.size(); i++) {
                XSSFRow filaEE2 = hojaResoluciones.createRow(conDat + i);

                XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
                celdaD1.setCellStyle(estiloCeldabordes0);
                celdaD1.setCellType(CellType.STRING);
                String txtD1 = Arrays.toString(ArrayResult.get(i));
                txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String[] parts = txtD1.split(",");
                String parts1 = parts[0].trim();
                XSSFRichTextString textoD1 = new XSSFRichTextString(parts1);
                celdaD1.setCellValue(textoD1);

                XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
                celdaD2.setCellStyle(estiloCeldabordes0);
                celdaD2.setCellType(CellType.STRING);
                String txtD2 = Arrays.toString(ArrayResult.get(i));
                txtD2 = txtD2.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts2 = parts[1].trim();
                XSSFRichTextString textoD2 = new XSSFRichTextString(parts2);
                celdaD2.setCellValue(textoD2);

                XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
                celdaD3.setCellStyle(estiloCeldabordes0);
                celdaD3.setCellType(CellType.STRING);
                String txtD3 = Arrays.toString(ArrayResult.get(i));
                txtD3 = txtD3.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts3 = parts[2].trim();
                XSSFRichTextString textoD3 = new XSSFRichTextString(parts3);
                celdaD3.setCellValue(textoD3);

                XSSFCell celdaD4 = filaEE2.createCell(3);//COLUMNA
                celdaD4.setCellStyle(estiloCeldabordes0);
                celdaD4.setCellType(CellType.STRING);
                String txtD4 = Arrays.toString(ArrayResult.get(i));
                txtD4 = txtD4.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts4 = parts[3].trim();
                XSSFRichTextString textoD4 = new XSSFRichTextString(parts4);
                celdaD4.setCellValue(textoD4);

                XSSFCell celdaD5 = filaEE2.createCell(4);//COLUMNA
                celdaD5.setCellStyle(estiloCeldabordes0);
                celdaD5.setCellType(CellType.STRING);
                String txtD5 = Arrays.toString(ArrayResult.get(i));
                txtD5 = txtD5.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts5 = parts[4].trim();
                XSSFRichTextString textoD5 = new XSSFRichTextString(parts5);
                celdaD5.setCellValue(textoD5);

                XSSFCell celdaD6 = filaEE2.createCell(5);//COLUMNA
                celdaD6.setCellStyle(estiloCeldabordes0);
                celdaD6.setCellType(CellType.STRING);
                String txtD6 = Arrays.toString(ArrayResult.get(i));
                txtD6 = txtD6.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                String parts6 = parts[5].trim();
                XSSFRichTextString textoD6 = new XSSFRichTextString(parts6);
                celdaD6.setCellValue(textoD6);

                XSSFCell celdaD7 = filaEE2.createCell(6);//COLUMNA
                celdaD7.setCellStyle(estiloCeldabordes0);
                celdaD7.setCellType(CellType.STRING);
                String txtD7 = "Debe estar comprendida dentro del periodo transcurrido entre la fecha_Resol y su FECHA_ING_ARCHIVO, registradas en la tabla \"resoluciones\" y \"Control_expediente\", respectivamente.";
                XSSFRichTextString textoD7 = new XSSFRichTextString(txtD7);
                celdaD7.setCellValue(textoD7);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        progressBar.setValue(100);

    }

    public static void SaveFileTo(XSSFWorkbook libro, JProgressBar progressBar, JFrame frame, DateTimeFormatter dtf) throws FileNotFoundException, IOException {

        DataOutputStream h = null;
        FileDialog d = new FileDialog(new JFrame(), "Save", FileDialog.SAVE);
        d.setFile("ValTEPJF_" + " R " + "-" + dtf.format(LocalDateTime.now()) + ".xlsx");
        d.setVisible(true);
        String dir;
        dir = d.getDirectory();
        String nomarchi = dir + d.getFile();
        int Pos = nomarchi.length();
        String Ext = nomarchi.substring(Pos - 5, Pos);
        File oneFile = new File(dir + d.getFile() + ".xlsx");
        System.out.println(Ext);
        if (dir != null) {
            FileOutputStream f = new FileOutputStream(oneFile);
            libro.write(f);
            f.close();
            JOptionPane.showMessageDialog(null, "Archivo Guardado Correctamente", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Archivo sin extencion .xlsx", "", JOptionPane.WARNING_MESSAGE);
        }
        progressBar.setValue(0);
        frame.setVisible(false);
    }
}
