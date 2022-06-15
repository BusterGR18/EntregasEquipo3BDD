package Demos;

import java.util.Scanner;

import DAO.SOPDAO;
import DAO.sop;
import ImpDAO.ImplSOfferProduct;

public class DemoSpecialOffer {
    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");
        System.out.println("1. R");
        System.out.println("2. U");
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                listsop();
            break;
            case 2: 
                actsop();
            break;
        }
    }    

    public static void listsop(){
        sop SpecialOProduct = new sop();
        SpecialOProduct.setSpecialOfferID(1);
        try{
            SOPDAO dao = new ImplSOfferProduct();
            dao.listar(SpecialOProduct);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void actsop(){
        sop SpecialOProduct = new sop();
        SpecialOProduct.setSpecialOfferID(16);
        SpecialOProduct.setSpecialOfferID(16);
        SpecialOProduct.setProductID(990);
        SpecialOProduct.setRowguid("5B261ECC-BEAA-4DCC-ABDF-091C718656B0");
        try{
            SOPDAO dao = new ImplSOfferProduct();
            dao.modificar(SpecialOProduct);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
