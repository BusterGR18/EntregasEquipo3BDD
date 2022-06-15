package ImpDAO;
import java.sql.*;
import Conex.ConexionI2SS;
import DAO.PPCATDAO;
import DAO.ppcat;

public class ImplProductCategory extends ConexionI2SS implements PPCATDAO {

    @Override
    public void registrar(ppcat PCategory) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("insert into Production.ProductCategory (Name,rowguid,ModifiedDate)"+" values (?,NEWID(),SYSDATETIME())");                                    
            st.setString(1, PCategory.getName());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }       
        
        
    }

    @Override
    public void modificar(ppcat PCategory) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update Production.ProductCategory set Name=?, rowguid = NEWID(), ModifiedDate = SYSDATETIME() where ProductCategoryID = ?");                                    
            st.setString(1, PCategory.getName());
            st.setInt(2, PCategory.getProductCategoryID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }       
        
        
    }

    @Override
    public void eliminar(ppcat PCategory) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("delete from Production.ProductCategory where ProductCategoryID = ?");                                    
            st.setInt(1, PCategory.getProductCategoryID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }       
        
        
    }

    @Override
    public void listar(ppcat PCategory) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Production.ProductCategory");            
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
