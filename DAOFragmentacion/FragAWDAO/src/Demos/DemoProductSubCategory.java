package Demos;

import java.util.Scanner;

public class DemoProductSubCategory {
    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");        
        System.out.println("1. R");
        System.out.println("2. U");        
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                //listcus();
            break;
            case 2: 
                //actcus();
            break;
        }
    }    
}
