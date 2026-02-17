/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones_JA;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FileDialog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import mx.org.inegi.conexion.JA.DaoConexionJA;
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
    JFrame f = new JFrame("Progreso Exporta JA.xlsx");

    public void ValidacionJA() throws IOException, SQLException {

       
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
        XSSFCellStyle estiloCeldaConteos = libro.createCellStyle();
        XSSFCellStyle ResulestiloCeldaConteos = libro.createCellStyle();

        XSSFFont fuente0 = libro.createFont();
        fuente0.setFontHeightInPoints((short) 12);
        fuente0.setColor(IndexedColors.WHITE.getIndex());
        fuente0.setFontName("Arial");
        fuente0.setBold(true);
        estiloCelda0.setFont(fuente0);
        estiloCelda0.setWrapText(true);
        estiloCelda0.setAlignment(HorizontalAlignment.CENTER);
        estiloCelda0.setVerticalAlignment(VerticalAlignment.CENTER);
        estiloCelda0.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        estiloCelda0.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        estiloCeldaConteos.setFont(fuente0);
        estiloCeldaConteos.setWrapText(true);
        estiloCeldaConteos.setAlignment(HorizontalAlignment.CENTER);
        estiloCeldaConteos.setVerticalAlignment(VerticalAlignment.CENTER);
        estiloCeldaConteos.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        estiloCeldaConteos.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estiloCeldaConteos.setBorderBottom(BorderStyle.THIN);
        estiloCeldaConteos.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        estiloCeldaConteos.setBorderLeft(BorderStyle.MEDIUM);
        estiloCeldaConteos.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        estiloCeldaConteos.setBorderRight(BorderStyle.MEDIUM);
        estiloCeldaConteos.setRightBorderColor(IndexedColors.BLACK.getIndex());
        estiloCeldaConteos.setBorderTop(BorderStyle.THIN);
        estiloCeldaConteos.setTopBorderColor(IndexedColors.BLACK.getIndex());

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
        estiloCeldabordes0.setVerticalAlignment(VerticalAlignment.TOP); // Alineación vertical
        estiloCeldabordes0.setWrapText(true); // Ajuste de texto
        XSSFFont fuente1 = libro.createFont();
        fuente1.setFontHeightInPoints((short) 11);
        fuente1.setFontName("Arial");
        estiloCeldabordes0.setFont(fuente1);
        //estiloCeldabordes0.setAlignment(HorizontalAlignment.CENTER);

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

        ResulestiloCeldaConteos.setFont(fuente1);
        ResulestiloCeldaConteos.setWrapText(true);
        ResulestiloCeldaConteos.setAlignment(HorizontalAlignment.CENTER);
        //estiloCelda2.setVerticalAlignment(VerticalAlignment.LEFT);
        ResulestiloCeldaConteos.setBorderBottom(BorderStyle.THIN);
        ResulestiloCeldaConteos.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        ResulestiloCeldaConteos.setBorderLeft(BorderStyle.MEDIUM);
        ResulestiloCeldaConteos.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        ResulestiloCeldaConteos.setBorderRight(BorderStyle.MEDIUM);
        ResulestiloCeldaConteos.setRightBorderColor(IndexedColors.BLACK.getIndex());
        ResulestiloCeldaConteos.setBorderTop(BorderStyle.THIN);
        ResulestiloCeldaConteos.setTopBorderColor(IndexedColors.BLACK.getIndex());

        
        XSSFSheet hojaControl = libro.createSheet("Control"); // Crea una nueva hoja 
        hojaControl.setColumnWidth(0, 4000); // Anchi de las columnas 
        hojaControl.setColumnWidth(1, 40000);
        hojaControl.setColumnWidth(2, 4000);
        hojaControl.setColumnWidth(3, 4000);
        hojaControl.setColumnWidth(4, 4000);


        Despliega_Control(libro, hojaControl, estiloCeldaConteos, ResulestiloCeldaConteos, estiloCeldabordes0, progressBar);
        SaveFileTo(libro, progressBar, f, dtf);

    }
   
      public void Despliega_Control(XSSFWorkbook libro, XSSFSheet hojaNC, XSSFCellStyle estiloCelda0, XSSFCellStyle estiloCelda1, XSSFCellStyle estiloCeldabordes0, JProgressBar progressBar) throws SQLException {

        String Texto = "";
        int conEnc = 1, conDat = 2, coni = 1; // hace el conteo de las filas que se agregan por cada ID 
        Border border = BorderFactory.createTitledBorder("Cargando...Control"); // crea el titulo de la ventana emergente
        progressBar.setBorder(border);
        progressBar.setValue(5); // porcentaje que se muestra en la ventana para saber el progreso

        XSSFRow row00 = hojaNC.createRow(0); // Fila
        XSSFCell celda00 = row00.createCell(0); // Columna
        celda00.setCellStyle(estiloCelda0);
        celda00.setCellType(CellType.STRING);
        String titulo00 = "Control ";
        XSSFRichTextString texto00 = new XSSFRichTextString(titulo00);
        hojaNC.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
        celda00.setCellValue(texto00);
        row00.setHeight((short) 600);
        Valida_Control VC = new Valida_Control();

        ArrayResult = VC.Control_Ingreso();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaNC.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "Clave_organo";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Regla";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE4 = filaEE1.createCell(2);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Total Casos";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);


            if (ArrayResult.size() < 5000) {
                for (int i = 0; i < ArrayResult.size(); i++) {
                    String txtD1 = Arrays.toString(ArrayResult.get(i));
                    txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                    String[] parts = txtD1.split(",");
                    String parts1 = parts[0].trim();
                    Texto = Texto + " , " + parts1;
                }
            } else {
                Texto = "General";
            }

            XSSFRow filaEE2 = hojaNC.createRow(conDat);
            XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
            celdaD1.setCellStyle(estiloCeldabordes0);
            celdaD1.setCellType(CellType.STRING);
            XSSFRichTextString textoD1 = new XSSFRichTextString(Texto);
            celdaD1.setCellValue(textoD1);

            XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
            celdaD2.setCellStyle(estiloCeldabordes0);
            celdaD2.setCellType(CellType.STRING);
            String txtD4 = "Registro Clave_organo en tabla TR_JA_INGRESOS_GEN no existe en tabla TR_JA_CONTROL_GEN";
            XSSFRichTextString textoD2 = new XSSFRichTextString(txtD4);
            celdaD2.setCellValue(textoD2);

            XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
            celdaD3.setCellStyle(estiloCeldabordes0);
            celdaD3.setCellType(CellType.STRING);
            String txtD3 = Integer.toString(ArrayResult.size());
            XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
            celdaD3.setCellValue(textoD3);

            Texto = "";
            coni++;
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
         ArrayResult = VC.Control_Tramite();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaNC.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "Clave_organo";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Regla";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE4 = filaEE1.createCell(2);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Total Casos";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);


            if (ArrayResult.size() < 5000) {
                for (int i = 0; i < ArrayResult.size(); i++) {
                    String txtD1 = Arrays.toString(ArrayResult.get(i));
                    txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                    String[] parts = txtD1.split(",");
                    String parts1 = parts[0].trim();
                    Texto = Texto + " , " + parts1;
                }
            } else {
                Texto = "General";
            }

            XSSFRow filaEE2 = hojaNC.createRow(conDat);
            XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
            celdaD1.setCellStyle(estiloCeldabordes0);
            celdaD1.setCellType(CellType.STRING);
            XSSFRichTextString textoD1 = new XSSFRichTextString(Texto);
            celdaD1.setCellValue(textoD1);

            XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
            celdaD2.setCellStyle(estiloCeldabordes0);
            celdaD2.setCellType(CellType.STRING);
            String txtD4 = "Registro Clave_organo en tabla TR_JA_TRAMITE_GEN no existe en tabla TR_JA_CONTROL_GEN";
            XSSFRichTextString textoD2 = new XSSFRichTextString(txtD4);
            celdaD2.setCellValue(textoD2);

            XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
            celdaD3.setCellStyle(estiloCeldabordes0);
            celdaD3.setCellType(CellType.STRING);
            String txtD3 = Integer.toString(ArrayResult.size());
            XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
            celdaD3.setCellValue(textoD3);

            Texto = "";
            coni++;
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
         ArrayResult = VC.Control_Conclusiones();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaNC.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "Clave_organo";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Regla";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE4 = filaEE1.createCell(2);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Total Casos";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);


            if (ArrayResult.size() < 5000) {
                for (int i = 0; i < ArrayResult.size(); i++) {
                    String txtD1 = Arrays.toString(ArrayResult.get(i));
                    txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                    String[] parts = txtD1.split(",");
                    String parts1 = parts[0].trim();
                    Texto = Texto + " , " + parts1;
                }
            } else {
                Texto = "General";
            }

            XSSFRow filaEE2 = hojaNC.createRow(conDat);
            XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
            celdaD1.setCellStyle(estiloCeldabordes0);
            celdaD1.setCellType(CellType.STRING);
            XSSFRichTextString textoD1 = new XSSFRichTextString(Texto);
            celdaD1.setCellValue(textoD1);

            XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
            celdaD2.setCellStyle(estiloCeldabordes0);
            celdaD2.setCellType(CellType.STRING);
            String txtD4 = "Registro Clave_organo en tabla TR_JA_CONCLUSIONES_GEN no existe en tabla TR_JA_CONTROL_GEN";
            XSSFRichTextString textoD2 = new XSSFRichTextString(txtD4);
            celdaD2.setCellValue(textoD2);

            XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
            celdaD3.setCellStyle(estiloCeldabordes0);
            celdaD3.setCellType(CellType.STRING);
            String txtD3 = Integer.toString(ArrayResult.size());
            XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
            celdaD3.setCellValue(textoD3);

            Texto = "";
            coni++;
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
         ArrayResult = VC.Control_Actos_Procesales();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaNC.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "Clave_organo";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Regla";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE4 = filaEE1.createCell(2);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Total Casos";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);


            if (ArrayResult.size() < 5000) {
                for (int i = 0; i < ArrayResult.size(); i++) {
                    String txtD1 = Arrays.toString(ArrayResult.get(i));
                    txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                    String[] parts = txtD1.split(",");
                    String parts1 = parts[0].trim();
                    Texto = Texto + " , " + parts1;
                }
            } else {
                Texto = "General";
            }

            XSSFRow filaEE2 = hojaNC.createRow(conDat);
            XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
            celdaD1.setCellStyle(estiloCeldabordes0);
            celdaD1.setCellType(CellType.STRING);
            XSSFRichTextString textoD1 = new XSSFRichTextString(Texto);
            celdaD1.setCellValue(textoD1);

            XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
            celdaD2.setCellStyle(estiloCeldabordes0);
            celdaD2.setCellType(CellType.STRING);
            String txtD4 = "Registro Clave_organo en tabla TR_JA_ACTOS_PROCESALES_GEN no existe en tabla TR_JA_CONTROL_GEN";
            XSSFRichTextString textoD2 = new XSSFRichTextString(txtD4);
            celdaD2.setCellValue(textoD2);

            XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
            celdaD3.setCellStyle(estiloCeldabordes0);
            celdaD3.setCellType(CellType.STRING);
            String txtD3 = Integer.toString(ArrayResult.size());
            XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
            celdaD3.setCellValue(textoD3);

            Texto = "";
            coni++;
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
         ArrayResult = VC.Control_Cumplim_Ejecutorias();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaNC.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "Clave_organo";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Regla";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE4 = filaEE1.createCell(2);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Total Casos";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);


            if (ArrayResult.size() < 5000) {
                for (int i = 0; i < ArrayResult.size(); i++) {
                    String txtD1 = Arrays.toString(ArrayResult.get(i));
                    txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                    String[] parts = txtD1.split(",");
                    String parts1 = parts[0].trim();
                    Texto = Texto + " , " + parts1;
                }
            } else {
                Texto = "General";
            }

            XSSFRow filaEE2 = hojaNC.createRow(conDat);
            XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
            celdaD1.setCellStyle(estiloCeldabordes0);
            celdaD1.setCellType(CellType.STRING);
            XSSFRichTextString textoD1 = new XSSFRichTextString(Texto);
            celdaD1.setCellValue(textoD1);

            XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
            celdaD2.setCellStyle(estiloCeldabordes0);
            celdaD2.setCellType(CellType.STRING);
            String txtD4 = "Registro Clave_organo en tabla TR_JA_CUMPLIM_EJECUTORIAS_GEN no existe en tabla TR_JA_CONTROL_GEN";
            XSSFRichTextString textoD2 = new XSSFRichTextString(txtD4);
            celdaD2.setCellValue(textoD2);

            XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
            celdaD3.setCellStyle(estiloCeldabordes0);
            celdaD3.setCellType(CellType.STRING);
            String txtD3 = Integer.toString(ArrayResult.size());
            XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
            celdaD3.setCellValue(textoD3);

            Texto = "";
            coni++;
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
         ArrayResult = VC.Control_Exhorto();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaNC.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "Clave_organo";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Regla";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE4 = filaEE1.createCell(2);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Total Casos";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);


            if (ArrayResult.size() < 5000) {
                for (int i = 0; i < ArrayResult.size(); i++) {
                    String txtD1 = Arrays.toString(ArrayResult.get(i));
                    txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                    String[] parts = txtD1.split(",");
                    String parts1 = parts[0].trim();
                    Texto = Texto + " , " + parts1;
                }
            } else {
                Texto = "General";
            }

            XSSFRow filaEE2 = hojaNC.createRow(conDat);
            XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
            celdaD1.setCellStyle(estiloCeldabordes0);
            celdaD1.setCellType(CellType.STRING);
            XSSFRichTextString textoD1 = new XSSFRichTextString(Texto);
            celdaD1.setCellValue(textoD1);

            XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
            celdaD2.setCellStyle(estiloCeldabordes0);
            celdaD2.setCellType(CellType.STRING);
            String txtD4 = "Registro Clave_organo en tabla TR_JA_EXHORTOS_DESPACHOS_GEN no existe en tabla TR_JA_CONTROL_GEN";
            XSSFRichTextString textoD2 = new XSSFRichTextString(txtD4);
            celdaD2.setCellValue(textoD2);

            XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
            celdaD3.setCellStyle(estiloCeldabordes0);
            celdaD3.setCellType(CellType.STRING);
            String txtD3 = Integer.toString(ArrayResult.size());
            XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
            celdaD3.setCellValue(textoD3);

            Texto = "";
            coni++;
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
         ArrayResult = VC.Control_Asuntos_Hidrocarburos();
        if (ArrayResult.size() > 0) {

            XSSFRow filaEE1 = hojaNC.createRow(conEnc);//FILA
            XSSFCell celdaE1 = filaEE1.createCell(0);//COLUMNA
            celdaE1.setCellStyle(estiloCelda1);
            celdaE1.setCellType(CellType.STRING);
            String txtE1 = "Clave_organo";
            XSSFRichTextString textoE1 = new XSSFRichTextString(txtE1);
            celdaE1.setCellValue(textoE1);

            XSSFCell celdaE2 = filaEE1.createCell(1);//COLUMNA
            celdaE2.setCellStyle(estiloCelda1);
            celdaE2.setCellType(CellType.STRING);
            String txtE2 = "Regla";
            XSSFRichTextString textoE2 = new XSSFRichTextString(txtE2);
            celdaE2.setCellValue(textoE2);

            XSSFCell celdaE4 = filaEE1.createCell(2);//COLUMNA
            celdaE4.setCellStyle(estiloCelda1);
            celdaE4.setCellType(CellType.STRING);
            String txtE4 = "Total Casos";
            XSSFRichTextString textoE4 = new XSSFRichTextString(txtE4);
            celdaE4.setCellValue(textoE4);


            if (ArrayResult.size() < 5000) {
                for (int i = 0; i < ArrayResult.size(); i++) {
                    String txtD1 = Arrays.toString(ArrayResult.get(i));
                    txtD1 = txtD1.replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
                    String[] parts = txtD1.split(",");
                    String parts1 = parts[0].trim();
                    Texto = Texto + " , " + parts1;
                }
            } else {
                Texto = "General";
            }

            XSSFRow filaEE2 = hojaNC.createRow(conDat);
            XSSFCell celdaD1 = filaEE2.createCell(0);//COLUMNA
            celdaD1.setCellStyle(estiloCeldabordes0);
            celdaD1.setCellType(CellType.STRING);
            XSSFRichTextString textoD1 = new XSSFRichTextString(Texto);
            celdaD1.setCellValue(textoD1);

            XSSFCell celdaD2 = filaEE2.createCell(1);//COLUMNA
            celdaD2.setCellStyle(estiloCeldabordes0);
            celdaD2.setCellType(CellType.STRING);
            String txtD4 = "Registro Clave_organo en tabla TR_JA_ASUNTOS_HIDROCARBUROS_GEN no existe en tabla TR_JA_CONTROL_GEN";
            XSSFRichTextString textoD2 = new XSSFRichTextString(txtD4);
            celdaD2.setCellValue(textoD2);

            XSSFCell celdaD3 = filaEE2.createCell(2);//COLUMNA
            celdaD3.setCellStyle(estiloCeldabordes0);
            celdaD3.setCellType(CellType.STRING);
            String txtD3 = Integer.toString(ArrayResult.size());
            XSSFRichTextString textoD3 = new XSSFRichTextString(txtD3);
            celdaD3.setCellValue(textoD3);

            Texto = "";
            coni++;
            conEnc = conEnc + coni;
            conDat = conDat + coni;
            coni = 1;
        }
        
         progressBar.setValue(100); // porcentaje que se muestra en la ventana para saber el progreso
        
      }
    
     public static void SaveFileTo(XSSFWorkbook libro, JProgressBar progressBar, JFrame frame, DateTimeFormatter dtf) throws FileNotFoundException, IOException {

        DataOutputStream h = null;
        FileDialog d = new FileDialog(new JFrame(), "Save", FileDialog.SAVE);
        d.setFile("CON_VAL_JA.xlsx");
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
            JOptionPane.showMessageDialog(null, "Archivo sin extensión .xlsx", "", JOptionPane.WARNING_MESSAGE);
        }

        progressBar.setValue(0);
        frame.setVisible(false);

    }

    
}
