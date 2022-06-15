package Demos;

import java.util.Scanner;

import DAO.SOFFERDAO;
import DAO.soffer;
import ImpDAO.ImplSalesOffer;

public class DemoSpecialOff {
    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");
        System.out.println("1. R");
        System.out.println("2. U");
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                listsoff();
            break;
            case 2: 
                //actsoff();
            break;
        }
    }


    public static void listsoff(){
        soffer SpecialOProduct = new soffer();
        SpecialOProduct.setSpecialOfferID(1);
        try{
            SOFFERDAO dao = new ImplSalesOffer();
            dao.listar(SpecialOProduct);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
