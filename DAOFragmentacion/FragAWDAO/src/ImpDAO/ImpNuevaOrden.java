package ImpDAO;

import java.sql.CallableStatement;
import java.util.Scanner;

import Conex.ConexionI2SS;
import DAO.SODDAO;
import DAO.sod;
import ImpDAO.ImplSOrderDetail;
import java.util.Scanner;
import DAO.SOHDAO;
import DAO.soh;
import ImpDAO.ImplSOrderHeader;

public class ImpNuevaOrden extends ConexionI2SS {
    int vs;

    public static void inssoh(){
        
    }

    public static void inssod(){
        Scanner scd = new Scanner(System.in);
        sod sorderdetail = new sod();
        System.out.println("Demo C");        
        sorderdetail.setSalesOrderDetailID(75123);
        sorderdetail.setCarrierTrackingNumber("NULL");
        sorderdetail.setOrderQty(1);
        sorderdetail.setProductID(9891);
        sorderdetail.setSpecialOfferID(1);
        sorderdetail.setUnitPrice("69420");
        sorderdetail.setUnitPriceDiscount("0");
        try{
            SODDAO dao = new ImplSOrderDetail();
            dao.registrar(sorderdetail);
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    
    public void deminssoh() throws Exception{                    
        try{
            this.conectar();
            CallableStatement csisoh = conexion.prepareCall("{call sp_insert_OrderHeader(?,?)}");            
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

    public void valofer() throws Exception{
        try{
            this.conectar();
            CallableStatement cs = conexion.prepareCall("{CALL Oferta_Check_SP(?)}");            
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            String res =cs.getString(1);
            System.out.println(res);
        }catch (Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    
}
