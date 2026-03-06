/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TMP.PLE;

import java.util.ArrayList;
import java.util.List;
import Pantallas_PLE.Integrar_TMP;

/**
 *
 * @author LAURA.MEDINAJ
 */
public class valida_info_correcta_Generales {
   
    private boolean correcto;
    private int año;
    
      public boolean valida_info_correcta_Generales(int anioApp,List<Periodo> periodosApp,String rutaExcel,String tipo_archivo) throws Exception {
          if (tipo_archivo=="XLSX") { 
              leerXLSX();
              if (año==anioApp) correcto=true; else correcto=false;
              System.out.println("Año XLSX:"+año+", año capturado en app "+anioApp+", ¿año correcto?: "+correcto);
          }
          if (tipo_archivo=="CSV")  {
              leerCSV(rutaExcel);
              if (año==anioApp) correcto=true; else correcto=false;
              System.out.println("Año XLSX:"+año+", año capturado en app "+anioApp+", ¿año correcto?: "+correcto);
          }
        if (correcto)  return true; else return false;
    }

        public void leerXLSX() throws Exception {
        Tmp_ple_meds1_1 lector = new Tmp_ple_meds1_1();
        lector.In_Tmp_ple_meds1_1(Integrar_TMP.Entidad, Integrar_TMP.Envio, Integrar_TMP.Legislatura, Integrar_TMP.Estatus);
        año=lector.getAño();
       System.out.println("se obtuvo año de excel");
    }
       public void leerCSV (String ruta) throws Exception {
//String Ruta, String Entidad, String Envio, String Legislatura, String Estatus
        Tmp_ple_meds1_1_CSV lector = new Tmp_ple_meds1_1_CSV();
        lector.Meds1_1_CSV(ruta,Integrar_TMP.Entidad, Integrar_TMP.Envio, Integrar_TMP.Legislatura, Integrar_TMP.Estatus);
        año=lector.getAño();
       System.out.println("se obtuvo año de excel");
    }

    public boolean Correcto() {
        return correcto;
    }

    
}
