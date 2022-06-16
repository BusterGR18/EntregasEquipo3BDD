package ImpDAO;

import java.sql.*;

import Conex.ConexionEurope;
import DAO.CEUDAO;

public class ImplConsultasEU extends ConexionEurope implements CEUDAO{

    @Override
    public void consulta_2() throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void consulta_4() throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("Select TOP 1 WITH TIES ProductID, SUM(SalesOrderDetail.OrderQty) as Unidades_vendidas from Sales.SalesOrderDetail Group by SalesOrderDetail.ProductID Order by Unidades_vendidas desc");            
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
