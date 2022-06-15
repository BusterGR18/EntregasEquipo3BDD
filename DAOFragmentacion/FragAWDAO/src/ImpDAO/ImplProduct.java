package ImpDAO;

import Conex.ConexionI2SS;
import DAO.PPRODDAO;
import DAO.pprod;

import java.sql.*;
public class ImplProduct extends ConexionI2SS implements PPRODDAO {

    @Override
    public void registrar(pprod Producto) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("insert into Production.Product (Name,ProductNumber,MakeFlag,FinishedGoodsFlag,Color,SafetyStockLevel,ReorderPoint,ListPrice,Size,SizeUnitMeasureCode,WeightUnitMeasureCode,Weight,DaysToManufacture,ProductLine,Class,Style,ProductSubcategoryID,ProductModelID,SellStartDate,SellEndDate,rowguid,ModifiedDate)"+"Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,?,?,?,?,?,NEWID(),SYSDATETIME())");
            st.setString(1,Producto.getName());
            st.setString(2,Producto.getProductNumber());
            st.setInt(3,Producto.getMakeFlag());
            st.setInt(4,Producto.getFinishedGoodsFlag());
            st.setString(5,Producto.getColor());
            st.setInt(6,Producto.getSafetyStockLevel());
            st.setInt(7,Producto.getReorderPoint());
            st.setFloat(8,Producto.getListPrice());
            st.setString(9,Producto.getSize());
            st.setString(10,Producto.getSizeUnitMeasureCode());
            st.setString(11,Producto.getWeightUnitMeasureCode());
            st.setFloat(12,Producto.getWeight());
            st.setInt(13,Producto.getDaysToManufacture());
            st.setString(14,Producto.getProductLine());            
            st.setString(15,Producto.getStyle());
            st.setInt(16,Producto.getProductSubcategoryID());
            st.setInt(17,Producto.getProductModelID());
            st.setDate(18,Producto.getSellStartDate());
            st.setDate(19,Producto.getSellEndDate());        
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }     
        
    }

    @Override
    public void modificar(pprod Producto) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update Production.Product set Name=?, ProductNumber=?, rowguid = NEWID(), ModifiedDate = SYSDATETIME() where ProductID = ?");                                    
            st.setString(1, Producto.getName());
            st.setString(2, Producto.getProductNumber());
            st.setInt(3, Producto.getProductID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }       
        
        
    }

    @Override
    public void eliminar(pprod Producto) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("delete from Production.Product where ProductID = ?");
            st.setInt(1, Producto.getProductID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }     
        
    }

    @Override
    public void listar(pprod Producto) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Production.Product");            
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
