package Demos;

import java.util.Scanner;

import DAO.PPCATDAO;
import DAO.ppcat;
import ImpDAO.ImplProductCategory;

public class DemoProductCategory {
    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");        
        System.out.println("1. R");              
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                listproductcategory();
            break;
            case 2: 
                
            break;
        }
    }
    public static void listproductcategory(){
        ppcat PCategory = new ppcat();
        PCategory.setProductCategoryID(1);        
        try{
            PPCATDAO dao = new ImplProductCategory();
           dao.listar(PCategory);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
