package ImpDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import Conex.ConexionI2SS;
import DAO.SODDAO;
import DAO.sod;

public class ImplSOrderDetail extends ConexionI2SS implements SODDAO {
    @Override
    public void registrar(sod sodetail) throws Exception {
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("insert into "+"Sales.SalesOrderDetail (SalesOrderID,CarrierTrackingNumber,OrderQty,ProductID,SpecialOfferID,UnitPrice,UnitPriceDiscount,rowguid,ModifiedDate)"+"Values(?,?,?,?,?,NEWID(),SYSDATETIME())");            
            st.setInt(1, sodetail.getSalesOrderID());
            st.setString(2, sodetail.getCarrierTrackingNumber());
            st.setInt(3, sodetail.getOrderQty());
            st.setInt(4, sodetail.getProductID());
            st.setInt(5, sodetail.getSpecialOfferID());
            st.setString(6, sodetail.getUnitPrice());
            st.setString(7, sodetail.getUnitPriceDiscount());                        
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }        
    }

    @Override
    public void modificar(sod sodetail) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update Sales.SalesOrderDetail set CarrierTrackingNumber = ?, OrderQty = ?, ProductID = ?, SpecialOfferID= ?, UnitPrice = ?, UnitPriceDiscount = ?, rowguid = NEWID(), ModifiedDate = SYSDATETIME() where SalesOrderDetailID = ?");                                    
            st.setString(1, sodetail.getCarrierTrackingNumber());
            st.setInt(2, sodetail.getOrderQty());
            st.setInt(3, sodetail.getProductID());
            st.setInt(4, sodetail.getSpecialOfferID());
            st.setString(5, sodetail.getUnitPrice());
            st.setString(6, sodetail.getUnitPriceDiscount());                         
            st.setInt(7, sodetail.getSalesOrderDetailID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }        
    }

    @Override
    public void eliminar(sod sodetail) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("delete from Sales.SalesOrderDetail where SalesOrderDetailID = ?");
            st.setInt(1, sodetail.getSalesOrderDetailID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }        
    }
    

    @Override
    public void listar(sod sodetail) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("select * from Sales.SalesOrderDetail");            
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
            rs.close();
            st.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }        
    }        
}