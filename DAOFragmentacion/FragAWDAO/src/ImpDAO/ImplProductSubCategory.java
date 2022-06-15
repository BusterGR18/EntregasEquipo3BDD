package ImpDAO;

import java.sql.*;

import Conex.ConexionI2SS;
import DAO.PPSubCatDAO;
import DAO.ppsubcat;

public class ImplProductSubCategory extends ConexionI2SS implements PPSubCatDAO {

    @Override
    public void modificar(ppsubcat ppsubcategory) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update Production.ProductCategory set ProductCategoryID=?,Name=?, rowguid = NEWID(), ModifiedDate = SYSDATETIME() where ProductSubCategoryID = ?");                                    
            st.setInt(1, ppsubcategory.getProductCategoryID());
            st.setString(2, ppsubcategory.getName());            
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }     
        
    }

    @Override
    public void listar(ppsubcat ppsubcategory) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Production.ProductSubCategory");            
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
