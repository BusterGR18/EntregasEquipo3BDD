package Demos;

import java.util.Scanner;

import DAO.SODDAO;
import DAO.sod;
import ImpDAO.ImplSOrderDetail;

public class DemoSalesOrderDetail {

    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");
        System.out.println("1. C");
        System.out.println("2. R");
        System.out.println("3. U");
        System.out.println("4. D");
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                inssod();
            break;
            case 2: 
                listsod();
            break;
            case 3:
                actsod();
            break;
            case 4: 
                delsod();
            break;
        }
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

    public static void delsod(){
        Scanner scd= new Scanner(System.in);
        sod sorderdetail = new sod();
        System.out.println("Introduzca el ID a eliminar: ");
        int sodid = scd.nextInt();
        sorderdetail.setSalesOrderDetailID(sodid);
        try{   
            SODDAO dao = new ImplSOrderDetail();
            dao.eliminar(sorderdetail);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void listsod(){
        sod SaleorderDetail = new sod();
        SaleorderDetail.setSalesOrderDetailID(1);
        try{
            SODDAO dao = new ImplSOrderDetail();
            dao.listar(SaleorderDetail);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void actsod(){
        sod sorderdetail = new sod();
        System.out.println("Demo U");        
        sorderdetail.setSalesOrderDetailID(75124);
        sorderdetail.setCarrierTrackingNumber("NULL");
        sorderdetail.setOrderQty(2);
        sorderdetail.setProductID(9891);
        sorderdetail.setSpecialOfferID(2);
        sorderdetail.setUnitPrice("42069");
        sorderdetail.setUnitPriceDiscount("0");
        try{
            SODDAO dao = new ImplSOrderDetail();
            dao.modificar(sorderdetail);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
