package ImpDAO;

import java.sql.*;

import Conex.ConexionI2SS;
import DAO.CAWDAO;

public class ImplConsultasAW extends ConexionI2SS implements CAWDAO {
    public void consulta_7() throws Exception{                    
        try{
            this.conectar();
            CallableStatement csisoh = conexion.prepareCall("{call sp_frag7(?,?)}");            
            csisoh.registerOutParameter(1, java.sql.Types.VARCHAR);
            csisoh.executeUpdate();
            String res =csisoh.getString(1);
            System.out.println(res);
        }catch (Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }    
    public void consulta_8() throws Exception{
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Production.Product where SellEndDate is not null");            
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
    public void consulta_5() throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("Select * from Sales.SpecialOfferProduct as sop inner join (Select ProductID from Production.Product as p inner join (Select *from Production.ProductSubcategory where ProductSubcategory.ProductCategoryID=1)as Cat on p.ProductSubcategoryID=Cat.ProductSubcategoryID) as psubid on sop.ProductID=psubid.ProductID");            
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
