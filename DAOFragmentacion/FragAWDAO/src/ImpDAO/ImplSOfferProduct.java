package ImpDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import Conex.ConexionI2SS;
import DAO.SOPDAO;
import DAO.sop;

public class ImplSOfferProduct extends ConexionI2SS implements SOPDAO{

    @Override
    public void modificar(sop soproduct) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update Sales.SpecialOfferProduct set  SpecialOfferID= ?, ProductID = ?, ModifiedDate = SYSDATETIME() where rowguid= '?'");
            st.setInt(1, soproduct.getSpecialOfferID());
            st.setInt(2, soproduct.getProductID());
            st.setString(3, soproduct.getRowguid());                        
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }
        
    }

    @Override
    public void listar(sop soproduct) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Sales.SpecialOfferProduct");            
            ResultSet rs = st.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            System.out.println(numberOfColumns);
            while (rs.next()) {                
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " );
            }
            System.out.println("\n");
        }
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
        
    }
    
}
