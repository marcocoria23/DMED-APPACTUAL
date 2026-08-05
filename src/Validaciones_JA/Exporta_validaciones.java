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
import java.sql.SQLException;
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

        
        XSSFSheet hojaControl = libro.createSheet("Observaciones Control"); // Crea una nueva hoja 
        hojaControl.setColumnWidth(0, 4000); // Anchi de las columnas 
        hojaControl.setColumnWidth(1, 40000);
        hojaControl.setColumnWidth(2, 4000);
        hojaControl.setColumnWidth(3, 4000);
        hojaControl.setColumnWidth(4, 4000);


        Despliega_Control(libro, hojaControl, estiloCeldaConteos, ResulestiloCeldaConteos, estiloCeldabordes0, progressBar);
        
        
        
        XSSFSheet hojaObs = libro.createSheet("Observaciones Campos vacíos");
        hojaObs.setColumnWidth(0, 7000);   // TABLA
        hojaObs.setColumnWidth(1, 12000);  // NOMBRE_ORGANO_JURIS
        hojaObs.setColumnWidth(2, 4500);   // CLAVE_ORGANO
        hojaObs.setColumnWidth(3, 4000);   // PERIODO
        hojaObs.setColumnWidth(4, 8000);   // CAMPO
        hojaObs.setColumnWidth(5, 20000);  // OBSERVACIÓN
        Despliega_Observaciones(libro, hojaObs, estiloCelda0, estiloCelda1, estiloCeldabordes0, progressBar);
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
        Valida_JA VC = new Valida_JA();

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
    
      public void Despliega_Observaciones(XSSFWorkbook libro, XSSFSheet hojaObs,
            XSSFCellStyle estiloTitulo, XSSFCellStyle estiloEncabezado,
            XSSFCellStyle estiloDatos, JProgressBar progressBar) throws SQLException {
        Border border = BorderFactory.createTitledBorder("Cargando...Observaciones JA");
        progressBar.setBorder(border);
        progressBar.setValue(10);
        Valida_JA VC = new Valida_JA();
        // ── Fila 0: título principal combinado A-F ──────────────────────────
        XSSFRow rowTitulo = hojaObs.createRow(0);
        rowTitulo.setHeight((short) 700);
        XSSFCell celdaTitulo = rowTitulo.createCell(0);
        celdaTitulo.setCellStyle(estiloTitulo);
        celdaTitulo.setCellType(CellType.STRING);
        celdaTitulo.setCellValue(new XSSFRichTextString("OBSERVACIONES JA"));
        hojaObs.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        // ── Fila 1: encabezados de columnas ────────────────────────────────
        String[] headers = {"TABLA", "NOMBRE_ORGANO_JURIS", "CLAVE_ORGANO", "PERIODO", "CAMPO", "OBSERVACIÓN"};
        XSSFRow rowHeaders = hojaObs.createRow(1);
        rowHeaders.setHeight((short) 600);
        for (int col = 0; col < headers.length; col++) {
            XSSFCell cell = rowHeaders.createCell(col);
            cell.setCellStyle(estiloEncabezado);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(new XSSFRichTextString(headers[col]));
        }
        int filaActual = 2; // empezamos a escribir datos desde la fila 3 (índice 2)
        // ── Estructura auxiliar: nombre tabla → método NULL + mensaje Control ─
        // Cada entrada: { nombreTabla, tablaBD, mensajeControlClave }
        // Para filas de tipo NULL (columna vacía):  OBSERVACIÓN = "La columna se encuentra vacía. Favor de completar con dato válido."
        // Para filas de tipo Control (clave no existe): OBSERVACIÓN = mensajeControlClave
        // ── 1. NULOS POR TABLA ──────────────────────────────────────────────
        // Los métodos NULL_* devuelven: [NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO]
        // 1a. ACTOS_PROCESALES
        filaActual = escribirFilasNull(VC.NULL_ACTOS_PROCESALES(), hojaObs, estiloDatos, filaActual,
                "ACTOS_PROCESALES", "La columna se encuentra vacía. Favor de completar con dato válido.");
        progressBar.setValue(20);
        // 1b. CONCLUSIONES
        filaActual = escribirFilasNull(VC.NULL_Conclusiones(), hojaObs, estiloDatos, filaActual,
                "CONCLUSIONES", "La columna se encuentra vacía. Favor de completar con dato válido.");
        progressBar.setValue(30);
        // 1c. TRAMITE
        filaActual = escribirFilasNull(VC.NULL_TRAMITE(), hojaObs, estiloDatos, filaActual,
                "TR_JA_TRAMITE_GEN", "La columna se encuentra vacía. Favor de completar con dato válido.");
        progressBar.setValue(40);
        // 1d. INGRESOS
        filaActual = escribirFilasNull(VC.NULL_INGRESOS(), hojaObs, estiloDatos, filaActual,
                "TR_JA_INGRESOS_GEN", "La columna se encuentra vacía. Favor de completar con dato válido.");
        progressBar.setValue(50);
        // 1e. ASUNTOS HIDROCARBUROS
        filaActual = escribirFilasNull(VC.ASUNTOS_HIDROCARBUROS(), hojaObs, estiloDatos, filaActual,
                "TR_JA_ASUNTOS_HIDROCARBUROS_GEN", "La columna se encuentra vacía. Favor de completar con dato válido.");
        progressBar.setValue(60);
        // ── 2. ERRORES DE CLAVE_ORGANO (Control_*) ─────────────────────────
        // Los métodos Control_* devuelven: [CLAVE_ORGANO, COMENTARIOS]
        // Para estas filas: NOMBRE_ORGANO_JURIS = "" (no disponible en el query),
        // CAMPO = "CLAVE_ORGANO",
        // OBSERVACIÓN = "Registro Clave_organo en tabla <TABLA> no existe en tabla TR_JA_CONTROL_GEN"
        filaActual = escribirFilasControl(VC.Control_Ingreso(), hojaObs, estiloDatos, filaActual,
                "TR_JA_INGRESOS_GEN",
                "Registro Clave_organo en tabla TR_JA_INGRESOS_GEN no existe en tabla TR_JA_CONTROL_GEN");
        progressBar.setValue(70);
        filaActual = escribirFilasControl(VC.Control_Tramite(), hojaObs, estiloDatos, filaActual,
                "TR_JA_TRAMITE_GEN",
                "Registro Clave_organo en tabla TR_JA_TRAMITE_GEN no existe en tabla TR_JA_CONTROL_GEN");
        filaActual = escribirFilasControl(VC.Control_Conclusiones(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN",
                "Registro Clave_organo en tabla TR_JA_CONCLUSIONES_GEN no existe en tabla TR_JA_CONTROL_GEN");
        filaActual = escribirFilasControl(VC.Control_Actos_Procesales(), hojaObs, estiloDatos, filaActual,
                "ACTOS_PROCESALES",
                "Registro Clave_organo en tabla TR_JA_ACTOS_PROCESALES_GEN no existe en tabla TR_JA_CONTROL_GEN");
        progressBar.setValue(80);
        filaActual = escribirFilasControl(VC.Control_Cumplim_Ejecutorias(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CUMPLIM_EJECUTORIAS",
                "Registro Clave_organo en tabla TR_JA_CUMPLIM_EJECUTORIAS_GEN no existe en tabla TR_JA_CONTROL_GEN");
        filaActual = escribirFilasControl(VC.Control_Exhorto(), hojaObs, estiloDatos, filaActual,
                "TR_JA_EXHORTOS_DESPACHOS_GEN",
                "Registro Clave_organo en tabla TR_JA_EXHORTOS_DESPACHOS_GEN no existe en tabla TR_JA_CONTROL_GEN");
        filaActual = escribirFilasControl(VC.Control_Asuntos_Hidrocarburos(), hojaObs, estiloDatos, filaActual,
                "TR_JA_ASUNTOS_HIDROCARBUROS_GEN",
                "Registro Clave_organo en tabla TR_JA_ASUNTOS_HIDROCARBUROS_GEN no existe en tabla TR_JA_CONTROL_GEN");
        progressBar.setValue(90);

        // ── 3. NUEVAS VALIDACIONES DE CONSISTENCIA ──────────────────────────
        // Los métodos Query_Conclusiones_* devuelven:
        // [CLAVE_ORGANO, NOMBRE_ORGANO_JURIS, PERIODO]
        //
        // Se agrega una fila por cada registro que incumple la regla.

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_1(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "SD_TOTAL_SENTENCIAS",
                "El campo SD_TOTAL_SENTENCIAS debe ser igual a la suma de SD_SUB_CONTROV_TERR + SD_SUBTOTAL_ASUNTOS_RES + SD_RECON + SD_NULIDADES + SD_TENENCIA + SD_SUB_ASUNTOS_CON_MA + SD_SUCESION_DA + SD_SUBTOTAL_JN + SD_OMISIONES + SD_CONTROV_TERR + SD_REVERSION + SD_SUBTOTAL_EJECUCION + SD_RRT + SD_PRIVACION + SD_INCONFORMIDADES + SD_ASUNTOS_LEGIS + SD_OTROS_ASUNTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_2(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "SCE_TOTAL_SENTENCIAS",
                "El campo SCE_TOTAL_SENTENCIAS debe ser igual a la suma de SCE_SUBTOTAL_CON_TERR + SCE_SUBTOTAL_ASUNTOS_RESTIT + SCE_RECON + SCE_NULIDADES + SCE_TENENCIA + SCE_SUB_ASUNTOS_CONT_MA + SCE_SUCESION_DA + SCE_SUBTOTAL_JN + SCE_OMISIONES + SCE_ASUNTOS_JV + SCE_CONTROV_TERR + SCE_REVERSION + SCE_SUBTOTAL_EJECUCION + SCE_RRT + SCE_PRIVACION + SCE_INCONFORMIDADES + SCE_ASUNTOS_LEGIS + SCE_OTROS_ASUNTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_3(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "SCR_TOTAL_SENTENCIAS",
                "El campo SCR_TOTAL_SENTENCIAS debe ser igual a la suma de SCR_SUBTOTAL_CONTROV_TERR + SCR_SUBTOTAL_ASUNTOS_RESTIT + SCR_RECON + SCR_NULIDADES + SCR_TENENCIA + SCR_SUB_ASUNTOS_CONT_MA + SCR_SUCESION_DA + SCR_SUBTOTAL_JN + SCR_OMISIONES + SCR_ASUNTOS_JV + SCR_CONTROV_TERR + SCR_REVERSION + SCR_SUBTOTAL_EJECUCION + SCR_RRT + SCR_PRIVACION + SCR_INCONFORMIDADES + SCR_ASUNTOS_LEGIS + SCR_OTROS_ASUNTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_4(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "LH_TOTAL_LAUDOS",
                "El campo LH_TOTAL_LAUDOS debe ser igual a la suma de LH_SUBTOTAL_CONTROV_TERR + LH_SUBTOTAL_ASUNTOS_RESTIT + LH_RECON + LH_NULIDADES + LH_TENENCIA + LH_SUB_ASUNTOS_CONT_MA + LH_SUCESION_DA + LH_SUBTOTAL_JN + LH_OMISIONES + LH_CONTROV_TERR + LH_REVERSION + LH_SUBTOTAL_EJECUCION + LH_RRT + LH_PRIVACION + LH_INCONFORMIDADES + LH_ASUNTOS_LEGIS + LH_OTROS_ASUNTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_5(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "CSS_TOTAL_CONVENIOS",
                "El campo CSS_TOTAL_CONVENIOS debe ser igual a la suma de CSS_SUBTOTAL_CONTROV_TERR + CSS_SUBTOTAL_ASUNTOS_RESTIT + CSS_RECON + CSS_NULIDADES + CSS_TENENCIA + CSS_SUB_ASUNTOS_CONT_MA + CSS_SUCESION_DA + CSS_SUBTOTAL_JN_ + CSS_OMISIONES + CSS_ASUNTOS_JV + CSS_CONTROV_TERR + CSS_REVERSION + CSS_SUBTOTAL_EJECUCION + CSS_RRT + CSS_PRIVACION + CSS_INCONFORMIDADES + CSS_ASUNTOS_LEGIS + CSS_OTROS_ASUNTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_6(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "DES_TOTAL_DESMENTIMIENTOS",
                "El campo DES_TOTAL_DESMENTIMIENTOS debe ser igual a la suma de DES_SUBTOTAL_CONTROV_TERR + DES_SUBTOTAL_ASUNTOS_RESTIT + DES_RECON + DES_NULIDADES + DES_TENENCIA + DES_SUB_ASUNTOS_CONT_MA + DES_SUCESION_DA + DES_SUBTOTAL_JN + DES_OMISIONES + DES_ASUNTOS_JV + DES_CONTROV_TERR + DES_REVERSION + DES_SUBTOTAL_EJECUCION + DES_RRT + DES_PRIVACION + DES_INCONFORMIDADES + DES_ASUNTOS_LEGIS + DES_OTROS_ASUNTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_7(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "CAD_TOTAL_CADUCIDADES",
                "El campo CAD_TOTAL_CADUCIDADES debe ser igual a la suma de CAD_SUBTOTAL_CONTROV_TERR + CAD_SUBTOTAL_ASUNTOS_RESTIT + CAD_RECON + CAD_NULIDADES + CAD_TENENCIA + CAD_SUB_ASUNTOS_CONT_MA + CAD_SUCESION_DA + CAD_SUBTOTAL_JN + CAD_OMISIONES + CAD_ASUNTOS_JV + CAD_CONTROV_TERR + CAD_REVERSION + CAD_SUBTOTAL_EJECUCION + CAD_RRT + CAD_PRIVACION + CAD_INCONFORMIDADES + CAD_ASUNTOS_LEGIS + CAD_OTROS_ASUNTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_8(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "OTRO_TOTAL_OTRO_TIPO",
                "El campo OTRO_TOTAL_OTRO_TIPO debe ser igual a la suma de OTRO_SUBTOTAL_CONTROV_TERR + OTRO_SUBTOTAL_ASUNTOS_RESTIT + OTRO_RECON + OTRO_NULIDADES + OTRO_TENENCIA + OTRO_SUB_ASUNTOS_CONT_MA + OTRO_SUCESION_DA + OTRO_SUBTOTAL_JN + OTRO_OMISIONES + OTRO_ASUNTOS_JV + OTRO_CONTROV_TERR + OTRO_REVERSION + OTRO_SUBTOTAL_EJECUCION + OTRO_RRT + OTRO_PRIVACION + OTRO_INCONFORMIDADES + OTRO_ASUNTOS_LEGIS + OTRO_OTROS_ASUNTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_9(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "SENTENCIAS_DEF",
                "El campo SENTENCIAS_DEF debe ser igual al campo SD_TOTAL_SENTENCIAS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_10(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "SENTENCIAS_CUMPL_EJEC",
                "El campo SENTENCIAS_CUMPL_EJEC debe ser igual al campo SCE_TOTAL_SENTENCIAS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_11(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "SENTENCIAS_CUMP_RR",
                "El campo SENTENCIAS_CUMP_RR debe ser igual al campo SCR_TOTAL_SENTENCIAS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_12(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "LAUDOS",
                "El campo LAUDOS debe ser igual al campo LH_TOTAL_LAUDOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_13(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "CONVENIOS",
                "El campo CONVENIOS debe ser igual al campo CSS_TOTAL_CONVENIOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_14(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "DESISTIMIENTOS",
                "El campo DESISTIMIENTOS debe ser igual al campo DES_TOTAL_DESMENTIMIENTOS.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_15(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "CADUCIDADES",
                "El campo CADUCIDADES debe ser igual al campo CAD_TOTAL_CADUCIDADES.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_16(), hojaObs, estiloDatos, filaActual,
                "TR_JA_CONCLUSIONES_GEN", "OTRO_RESOL",
                "El campo OTRO_RESOL debe ser igual al campo OTRO_TOTAL_OTRO_TIPO.");

        filaActual = escribirFilasValidacion(VC.Query_Conclusiones_17(), hojaObs, estiloDatos, filaActual,
                "TR_JA_TRAMITE_GEN", "TOTAL_ASUNTOS_TRAMITE",
                "El campo TOTAL_ASUNTOS_TRAMITE debe ser igual a TOTAL_ASUNTOS_PEND + TOTAL_ASUNTOS_INSTRUC.");

        progressBar.setValue(100);
    }
    // ── Helper: escribe una fila por cada registro NULL ──────────────────────
    // datos: [NOMBRE_ORGANO_JURIS, CLAVE_ORGANO, PERIODO, CAMPO_VACIO]
    private int escribirFilasNull(ArrayList<String[]> datos, XSSFSheet hoja,
            XSSFCellStyle estilo, int filaInicio, String nombreTabla, String observacion) {
        int fila = filaInicio;
        for (String[] registro : datos) {
            String nombreOrgano = registro[0] != null ? registro[0] : "";
            String claveOrgano  = registro[1] != null ? registro[1] : "";
            String periodo      = registro[2] != null ? registro[2] : "";
            String campo        = registro[3] != null ? registro[3] : "";
            XSSFRow row = hoja.createRow(fila++);
            row.setHeight((short) 400);
            crearCelda(row, 0, nombreTabla, estilo);
            crearCelda(row, 1, nombreOrgano, estilo);
            crearCelda(row, 2, claveOrgano, estilo);
            crearCelda(row, 3, periodo, estilo);
            crearCelda(row, 4, campo, estilo);
            crearCelda(row, 5, observacion, estilo);
        }
        return fila;
    }
    // ── Helper: escribe una fila por cada error de CLAVE_ORGANO ─────────────
    // datos: [CLAVE_ORGANO, COMENTARIOS]  (resultado de Control_*)
    private int escribirFilasControl(ArrayList<String[]> datos, XSSFSheet hoja,
            XSSFCellStyle estilo, int filaInicio, String nombreTabla, String observacion) {
        int fila = filaInicio;
        for (String[] registro : datos) {
            // Parsea el array String[] que viene de Arrays.toString(...)
            String txtD = Arrays.toString(registro)
                    .replace("[", "").replace("]", "").replace(" 00:00:00.0", "");
            String[] parts = txtD.split(",");
            String claveOrgano = parts.length > 0 ? parts[0].trim() : "";
           XSSFRow row = hoja.createRow(fila++);
            row.setHeight((short) 400);
            crearCelda(row, 0, nombreTabla, estilo);
            crearCelda(row, 1, "", estilo);          // NOMBRE_ORGANO_JURIS no disponible en Control_*
            crearCelda(row, 2, claveOrgano, estilo);
            crearCelda(row, 3, "", estilo);          // PERIODO no disponible en Control_*
            crearCelda(row, 4, "CLAVE_ORGANO", estilo);
            crearCelda(row, 5, observacion, estilo);
        }
        return fila;
    }

    // ── Helper: escribe una fila por cada nueva validación incumplida ────────
    // datos: [CLAVE_ORGANO, NOMBRE_ORGANO_JURIS, PERIODO]
    private int escribirFilasValidacion(ArrayList<String[]> datos, XSSFSheet hoja,
            XSSFCellStyle estilo, int filaInicio, String nombreTabla,
            String campo, String observacion) {
        int fila = filaInicio;
        for (String[] registro : datos) {
            String claveOrgano  = registro.length > 0 && registro[0] != null ? registro[0] : "";
            String nombreOrgano = registro.length > 1 && registro[1] != null ? registro[1] : "";
            String periodo      = registro.length > 2 && registro[2] != null ? registro[2] : "";

            XSSFRow row = hoja.createRow(fila++);
            row.setHeight((short) 500);

            crearCelda(row, 0, nombreTabla, estilo);
            crearCelda(row, 1, nombreOrgano, estilo);
            crearCelda(row, 2, claveOrgano, estilo);
            crearCelda(row, 3, periodo, estilo);
            crearCelda(row, 4, campo, estilo);
            crearCelda(row, 5, observacion, estilo);
        }
        return fila;
    }

    // ── Helper: crea una celda con texto y estilo ────────────────────────────
    private void crearCelda(XSSFRow row, int col, String valor, XSSFCellStyle estilo) {
        XSSFCell cell = row.createCell(col);
        cell.setCellStyle(estilo);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(new XSSFRichTextString(valor != null ? valor : ""));
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