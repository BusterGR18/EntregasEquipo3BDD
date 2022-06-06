package ImpDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import Conex.ConexionI2SS;
import DAO.SOHDAO;
import DAO.soh;

public class ImplSOrderHeader extends ConexionI2SS implements SOHDAO {

    @Override
    public void registrar(soh soheader) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("insert into "+
            "Sales.SalesOrderHeader (RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag,CustomerID,BillToAddressID,ShipToAddressID,ShipMethodID,SubTotal,TaxAmt,Freight,rowguid,ModifiedDate) "+"Values(?,SYSDATETIME(),SYSDATETIME(),SYSDATETIME(),?,?,?,?,?,?,?,?,?,NEWID(),SYSDATETIME())");                                   
            st.setInt(1, soheader.getRevisionNumber());
            st.setDate(2,soheader.getOrderDate());
            st.setDate(3,soheader.getDueDate());
            st.setDate(4,soheader.getShipDate());
            st.setInt(5,soheader.getStatus());
            st.setBoolean(6,soheader.getOnlineOrderFlag());        
            st.setInt(7,soheader.getCustomerID());                        
            st.setInt(8,soheader.getBillToAddressID());
            st.setInt(9,soheader.getShipToAddressID());
            st.setInt(10,soheader.getShipMethodID());            
            st.setBigDecimal(11,soheader.getSubTotal());
            st.setBigDecimal(12,soheader.getTaxAmt());
            st.setBigDecimal(13,soheader.getFreight());                        
            st.setString(14,soheader.getRowguid());
            st.setDate(15,soheader.getModifiedDate());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        
        
    }


    @Override
    public void modificar(soh soheader) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update Sales.SalesOrderHeader set RevisionNumber= ?, OrderDate= SYSDATETIME(), DueDate = SYSDATETIME(), ShipDate = SYSDATETIME(), Status = ? , OnlineOrderFlag = ?,  CustomerID = ?, BillToAddressID = ?, ShipToAddressID = ?, ShipMethodID = ?,  SubTotal = ?, TaxAmt = ?, Freight = ?,Rowguid = NEWID(), ModifiedDate = SYSDATETIME() where SalesOrderID = ?");                                    
            st.setInt(1, soheader.getRevisionNumber());
            st.setDate(2,soheader.getOrderDate());
            st.setDate(3,soheader.getDueDate());
            st.setDate(4,soheader.getShipDate());
            st.setInt(5,soheader.getStatus());
            st.setBoolean(6,soheader.getOnlineOrderFlag());        
            st.setInt(7,soheader.getCustomerID());                        
            st.setInt(8,soheader.getBillToAddressID());
            st.setInt(9,soheader.getShipToAddressID());
            st.setInt(10,soheader.getShipMethodID());            
            st.setBigDecimal(11,soheader.getSubTotal());
            st.setBigDecimal(12,soheader.getTaxAmt());
            st.setBigDecimal(13,soheader.getFreight());                        
            st.setString(14,soheader.getRowguid());
            st.setDate(15,soheader.getModifiedDate());
            st.setInt(16, soheader.getSalesOrderID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }
        
    }

    @Override
    public void eliminar(soh soheader) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("delete from Sales.SalesOrderHeader where SalesOrderID = ?");
            st.setInt(1, soheader.getSalesOrderID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
    }


    @Override
    public void listar(soh soheader) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("select * from Sales.SalesOrderHeader");            
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
