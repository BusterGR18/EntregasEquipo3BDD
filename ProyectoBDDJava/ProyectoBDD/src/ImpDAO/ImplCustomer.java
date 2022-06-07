package ImpDAO;
import Conex.ConexionI2SS;
import DAO.CUSDAO;
import DAO.cus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ImplCustomer extends ConexionI2SS implements CUSDAO {

    @Override
    public void modificar(cus customer) throws Exception {
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update customer set PersonID = ?, StoreID = ?, TerritoryID = ?, ModifiedDate = SYSDATETIME(), where CustomerID = ?");            
            st.setInt(1, customer.getPersonID());
            st.setInt(2, customer.getStoreID());
            st.setInt(3, customer.getTerritoryID());                                    
            st.setInt(4, customer.getCustomerID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }
        
    }

    /*
    @Override
    public void eliminar (cus customer) throws Exception {
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("delete from Sales.Customer where id = ?");
            st.setInt(1, customer.getCustomerID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }        
    }*/

    @Override
    public void listar(cus customer) throws Exception {
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Sales.Customer");            
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
