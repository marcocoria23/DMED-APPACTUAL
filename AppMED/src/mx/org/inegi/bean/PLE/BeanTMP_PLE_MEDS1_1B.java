/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.PLE;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANTONIO.CORIA
 */
public class BeanTMP_PLE_MEDS1_1B extends Bean implements SQLData{
 
    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD;
    private String P1_1B_1;
    private String P1_1B_2;
    private String LEGISLATURA_TMP;
    private String C1_IB_TMP;
    
     public BeanTMP_PLE_MEDS1_1B (){
     }
     
     public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public void SetID_ENTIDAD_TMP(String ID_ENTIDAD_TMP) {
        this.ID_ENTIDAD_TMP = ID_ENTIDAD_TMP;
    } 
      
   public String GetENTIDAD() {
        return ENTIDAD;
    }

    public void SetENTIDAD(String ENTIDAD) {
        this.ENTIDAD = ENTIDAD;
    }
    public String GetP1_1B_1() {
        return P1_1B_1;
    }

    public void SetP1_1B_1(String P1_1B_1) {
        this.P1_1B_1 = P1_1B_1;
    }
    public String GetP1_1B_2() {
        return P1_1B_2;
    }

    public void SetP1_1B_2(String P1_1B_2) {
        this.P1_1B_2 = P1_1B_2;
    }
     public String GetLEGISLATURA_TMP() {
        return LEGISLATURA_TMP;
    }

    public void SetLEGISLATURA_TMP(String LEGISLATURA_TMP) {
        this.LEGISLATURA_TMP = LEGISLATURA_TMP;
    }
     public String GetC1_1B_ID_TMP() {
        return C1_IB_TMP;
    }

    public void SetC1_IB_TMP(String C1_1A_ID_TMP) {
        this.C1_IB_TMP = C1_1A_ID_TMP;
    } 
     @Override
    public String getSQLTypeName() throws SQLException {
       return SQLTypeName;
         //throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getLlave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
     Object[] array = {
         GetID_ENTIDAD_TMP(),
         GetENTIDAD(),
         GetP1_1B_1(),
         GetP1_1B_2(),
         GetLEGISLATURA_TMP(),
         GetC1_1B_ID_TMP()
             
     };
     return array;
    }

    @Override
    public void setAtributos(Object[] obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaDesc(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
private String ots(Object obj) {
        String val = null;
        if (obj != null) {
            val = obj.toString();
        }
        return val;
    }

    private Integer oti(Object obj) {
        Integer num = null;
        if (obj != null) {
            try {
                num = (Integer) obj;
            } catch (Exception ex) {
                System.out.println("Error en casteo de numero [" + obj + "]");
            }
        }
        return num;    
    }
}
