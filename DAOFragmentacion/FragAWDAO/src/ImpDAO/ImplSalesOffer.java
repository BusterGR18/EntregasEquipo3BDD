package ImpDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import Conex.ConexionI2SS;

import DAO.SOFFERDAO;
import DAO.soffer;

public class ImplSalesOffer extends ConexionI2SS implements SOFFERDAO{
    @Override
    public void modificar (soffer specialoff) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update Sales.SpecialOffer set  Description= ?, MinQty = ?, ModifiedDate = SYSDATETIME() where SpecialOfferID= ?");
            st.setString(1, specialoff.getDescription());
            st.setInt(2, specialoff.getMinQty());
            st.setInt(3, specialoff.getSpecialOfferID());                        
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }
        
    }

    @Override
    public void listar(soffer specialoff) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Sales.SpecialOffer");            
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
