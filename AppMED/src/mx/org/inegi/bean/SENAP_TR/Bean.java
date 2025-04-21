package mx.org.inegi.bean.SENAP_TR;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Bean
{
    
    public abstract Object[] getLlave();
  
    public abstract Object[] toArray();
    
    public abstract void setAtributos(Object[] obj);       
    
    public abstract void actualizaDesc(Connection conn) throws SQLException ;
  
}