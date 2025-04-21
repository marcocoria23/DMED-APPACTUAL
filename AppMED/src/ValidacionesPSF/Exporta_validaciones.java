/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidacionesPSF;

import Pantallas_PSF.Valida;
import static ValidacionesTEPJF.Exporta_validaciones.SaveFileTo;
import ValidacionesTEPJF.Valida_Expedientes;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FileDialog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
        estiloCelda0.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
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
        estiloCelda1.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
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

        XSSFSheet hojaExpedientes = libro.createSheet("Programas_Sociales");
        hojaExpedientes.setColumnWidth(0, 8000);
        hojaExpedientes.setColumnWidth(1, 6000);
        hojaExpedientes.setColumnWidth(2, 12000);
        hojaExpedientes.setColumnWidth(3, 12000);
        hojaExpedientes.setColumnWidth(4, 6000);

        XSSFSheet hojaContrataciones = libro.createSheet("Contrataciones_Publicas");
        hojaContrataciones.setColumnWidth(0, 6000);
        hojaContrataciones.setColumnWidth(1, 6000);
        hojaContrataciones.setColumnWidth(2, 12000);
        hojaContrataciones.setColumnWidth(3, 12000);
        hojaContrataciones.setColumnWidth(4, 6000);

        Despliega_Programas_Sociales(libro, hojaExpedientes, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);
       Despliega_Contrataciones_Publicas(libro, hojaContrataciones, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);
        SaveFileTo(libro, progressBar, f, dtf);

    }

    public void Despliega_Programas_Sociales(XSSFWorkbook libro, XSSFSheet hojaExpedientes, XSSFCellStyle estiloCelda0, XSSFCellStyle estiloCelda1, XSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) {

        int conEnc = 1, conDat = 2, coni = 1;
        Border border = BorderFactory.createTitledBorder("Cargando...Programas_Sociales");
        progressBar.setBorder(border);
        progressBar.setValue(15);

        XSSFRow row00 = hojaExpedientes.createRow(0); // Fila
        XSSFCell celda00 = row00.createCell(0); // Columna
        celda00.setCellStyle(estiloCelda0);
        celda00.setCellType(CellType.STRING);
        String titulo00 = "Programas Sociales ";
        XSSFRichTextString texto00 = new XSSFRichTextString(titulo00);
        hojaExpedientes.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        celda00.setCellValue(texto00);
        row00.setHeight((short) 600);
        QProgramas_sociales PS = new QProgramas_sociales();
        Valida Val = new Valida();

        ArrayResult = PS.URL_REGLAS_LINEAMIENTOS_OPERACIONDC(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a Sí";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.URL_REGLAS_LINEAMIENTOS_OPERACIONNDC(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a No";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.derecho_social_atendido_2(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a No";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.derecho_social_atendido_3(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1 o derecho_social_atendido_2.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.derecho_social_atendido_4(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1, derecho_social_atendido_2 o derecho_social_atendido_3";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.derecho_social_atendido_5(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1, derecho_social_atendido_2, derecho_social_atendido_3 o derecho_social_atendido_4.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.tipo_apoyo_entregado_2(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.tipo_apoyo_entregado_2(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.tipo_apoyo_entregado_3(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1 o tipo_apoyo_entregado_2.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.tipo_apoyo_entregado_4(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1, tipo_apoyo_entregado_2 o tipo_apoyo_entregado_3.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.tipo_apoyo_entregado_5(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3 o tipo_apoyo_entregado_4.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "Favor de especificar en OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE ya que al menos una variable de Tipo_apoyo_entregado ='Otro tipo de apoyo (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUEND(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No debe de especificar en OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE ya que las variable de Tipo_apoyo_entregado es diferente a'Otro tipo de apoyo (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.poblacion_atendida_territorial_especifique(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "poblacion_atendida_territorial_especifique no debe de capturar  ya que hay un dato numérico en el campo poblacion_atendida_territorial.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.poblacion_atendida_otro_tipo_especifique(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "poblacion_atendida_otro_tipo_especifique no debe de capturar  ya que no hay un dato numérico en el campo poblacion_atendida_otro_tipo.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.poblacion_atendida_otro_tipo_especifiqueND(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "Debe de capturar en poblacion_atendida_otro_tipo_especifique   ya que  hay un dato numérico en el campo poblacion_atendida_otro_tipo.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.grupo(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No puede repetir el tipo de grupo vulnerable atendido  seleccionado en el campo grupo_vulnerable_beneficiado";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.grupo_ESPECIFIQUE(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "No Debe de capturar otro_grupo_vulnerable_beneficiado_especifique  ya que grupo_vulnerable_beneficiado es diferente a \"Otro grupo vulnerable (especifique)\"";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = PS.grupo_ESPECIFIQUEND(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaExpedientes.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                String txtD3 = "Debe de capturar otro_grupo_vulnerable_beneficiado_especifique  ya que grupo_vulnerable_beneficiado es igual a \"Otro grupo vulnerable (especifique)\"";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        
        
    }

    public void Despliega_Contrataciones_Publicas(XSSFWorkbook libro, XSSFSheet hojaContrataciones, XSSFCellStyle estiloCelda0, XSSFCellStyle estiloCelda1, XSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) {

        int conEnc = 1, conDat = 2, coni = 1;
        Border border = BorderFactory.createTitledBorder("Cargando...Contrataciones Publicas");
        progressBar.setBorder(border);
        progressBar.setValue(50);

        XSSFRow row00 = hojaContrataciones.createRow(0); // Fila
        XSSFCell celda00 = row00.createCell(0); // Columna
        celda00.setCellStyle(estiloCelda0);
        celda00.setCellType(CellType.STRING);
        String titulo00 = "Contrataciones Publicas ";
        XSSFRichTextString texto00 = new XSSFRichTextString(titulo00);
        hojaContrataciones.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        celda00.setCellValue(texto00);
        row00.setHeight((short) 600);
        QContrataciones_Publicas CP = new QContrataciones_Publicas();
        Valida Val = new Valida();

        ArrayResult = CP.otro_tipo_procedimiento_especifique(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaContrataciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                XSSFRow filaEE2 = hojaContrataciones.createRow(conDat + i);

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
                String txtD3 = "Debe de capturar otro_tipo_procedimiento_especifique ya que tipo_procedimiento='Otro tipo (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = CP.otro_tipo_procedimiento_especifiqueNDC(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaContrataciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                XSSFRow filaEE2 = hojaContrataciones.createRow(conDat + i);

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
                String txtD3 = "No debe de capturar otro_tipo_procedimiento_especifique ya que tipo_procedimiento es diferente a 'Otro tipo (especifique)'";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = CP.fecha_publicacion_fallo(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaContrataciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                XSSFRow filaEE2 = hojaContrataciones.createRow(conDat + i);

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
                String txtD3 = "Debe ser igual o mayor a la fecha registrada en el campo fecha_publicacion_convocatoria. En caso de este criterio no le aplique, debe justificarlo en el campo \"\"Comentarios\"\"";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = CP.fecha_firma_contrato(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaContrataciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                XSSFRow filaEE2 = hojaContrataciones.createRow(conDat + i);

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
                String txtD3 = "Debe ser igual o mayor a la fecha registrada en el campo fecha_publicacion_fallo. En caso de este criterio no le aplique, debe justificarlo en el campo \"\"Comentarios\"\".";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = CP.fecha_inicio_contrato(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaContrataciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                XSSFRow filaEE2 = hojaContrataciones.createRow(conDat + i);

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
                String txtD3 = "Debe ser igual o mayor a la fecha registrada en el campo fecha_firma_contrato.En caso de este criterio no le aplique, debe justificarlo en el campo \"\"Comentarios\"\".";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = CP.fecha_conclusion_contrato(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaContrataciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                XSSFRow filaEE2 = hojaContrataciones.createRow(conDat + i);

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
                String txtD3 = "Debe ser igual o mayor a la fecha registrada en el campo fecha_inicio_contrato.En caso de este criterio no le aplique, debe justificarlo en el campo \"\"Comentarios\"\"";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = CP.tipo_garantia_presentada_1(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaContrataciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                XSSFRow filaEE2 = hojaContrataciones.createRow(conDat + i);

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
                String txtD3 = "Debe de capturar tipo_garantia_presentada_1 ya que campo cond_presentacion_garantia =Sí.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

                coni++;
            }
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }

        ArrayResult = CP.tipo_garantia_presentada_1_ND(Val.Año);
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaContrataciones.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "ID_PROGRAMA_SOCIAL";
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
                XSSFRow filaEE2 = hojaContrataciones.createRow(conDat + i);

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
                String txtD3 = "No debe de capturar tipo_garantia_presentada_1 ya que campo cond_presentacion_garantia =No.";
                XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
                celdaD3.setCellValue(textoD3);

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
        d.setFile("Val_PSF_Y_CPF_" + " R " + "-" + dtf.format(LocalDateTime.now()) + ".xlsx");
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
