package ImpDAO;

import java.sql.*;

import Conex.ConexionAsiaPacific;
import DAO.CAPADAO;

public class ImplConsultasAsiaPacific extends ConexionAsiaPacific implements CAPADAO {

    @Override
    public void consulta_6() throws Exception {
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("Select TOP 3 WITH TIES SalesOrderDetail.ProductID, SUM(SalesOrderDetail.OrderQty) as Ventas from AsiaPacific.Sales.SalesOrderDetail Group by SalesOrderDetail.ProductID Order by Ventas asc");            
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

    @Override
    public void consulta_2() throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from (select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=9 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv inner join (select * from Sales.SalesPerson) sp on mv.IMV=sp.BusinessEntityID ");            
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
