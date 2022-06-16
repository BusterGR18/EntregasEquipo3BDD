package Demos;

import java.util.Scanner;

import DAO.PPRODDAO;
import DAO.pprod;
import ImpDAO.ImplProduct;

public class DemoProduct {
    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");        
        System.out.println("1. R");  
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                listproduct();
            break;
            case 2: 
                
            break;
        }
    }

    public static void listproduct(){
        pprod Producto = new pprod();
        Producto.setProductID(1);
        try{
            PPRODDAO dao = new ImplProduct();
            dao.listar(Producto);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
