package Demos;
import java.util.Scanner;

import DAO.CUSDAO;
import DAO.cus;
import ImpDAO.ImplCustomer;

public class DemoCustomer {

    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");        
        System.out.println("1. R");
        System.out.println("2. U");        
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                listcus();
            break;
            case 2: 
                actcus();
            break;
        }
    }

    public static void listcus(){
        cus customer = new cus();
        customer.setCustomerID(1);
        try{
            CUSDAO dao = new ImplCustomer();
            dao.listar(customer);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void actcus(){
        cus customer = new cus();        
        System.out.println("Demo U");
        customer.setCustomerID(30121);
        customer.setPersonID(1999);
        customer.setStoreID(294);
        customer.setTerritoryID(4);
        try{
            CUSDAO dao = new ImplCustomer();
            dao.modificar(customer);
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
