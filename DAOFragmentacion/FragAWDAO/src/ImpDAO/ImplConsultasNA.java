package ImpDAO;

import java.sql.*;

import Conex.ConexionNA;
import DAO.CNADAO;

public class ImplConsultasNA extends ConexionNA implements CNADAO{

    @Override
    public void consulta_2() throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from (select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID between 1 and 6 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv inner join (select * from Sales.SalesPerson) sp on mv.IMV=sp.BusinessEntityID ");            
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
    public void consulta_3() throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from (select top 1 SalesPersonID IMV, count(SalesOrderID) TV from NorthAmerica.Sales.SalesOrderHeader group by SalesPersonID order by TV desc) mv inner join (select * from NorthAmerica.Sales.SalesPerson) sp on mv.IMV=sp.BusinessEntityID ");            
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
    public void consulta_9() throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM NorthAmerica.sales.CUSTOMER WHERE TerritoryID BETWEEN 1 AND 4 and TerritoryID!=2 and TerritoryID!=3 AND PersonID IS NULL");            
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
