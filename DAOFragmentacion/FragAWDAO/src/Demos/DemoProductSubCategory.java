package Demos;

import java.util.Scanner;

import DAO.PPSubCatDAO;
import DAO.ppsubcat;
import ImpDAO.ImplProductSubCategory;

public class DemoProductSubCategory {
    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");        
        System.out.println("1. R");              
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                listproductsub();
            break;
            case 2: 
                
            break;
        }
    }    
    public static void listproductsub(){
        ppsubcat ppsubcategory = new ppsubcat();
        ppsubcategory.setProductSubcategoryID(1);
        try{
            PPSubCatDAO dao = new ImplProductSubCategory();
            dao.listar(ppsubcategory);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
