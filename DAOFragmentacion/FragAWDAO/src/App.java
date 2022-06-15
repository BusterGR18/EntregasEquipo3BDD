import java.util.Scanner;
import Demos.DemoCustomer;
import Demos.DemoSpecialOff;
import Demos.DemoSalesOrderDetail;
import Demos.DemoSalesOrderHEader;
import Demos.DemoSpecialOffer;


public class App {
    public static void main(String[] args) throws Exception {
        
        
        System.out.println("DAO Para fragmentacion: \n");
        System.out.println("Selecciona una opcion:");
        System.out.println("Demos:");
        System.out.println("1.-Sales");
        System.out.println("2.-Production");
        System.out.println("3.-Consultas");
        Scanner scmain = new Scanner(System.in);
        int op = scmain.nextInt();
        switch(op){
            case 1:
                System.out.println("Seleccione un demo: \n");
                System.out.println("1. Customer");
                System.out.println("2. SalesOrderDetail");
                System.out.println("3. SalesOrderHeader");
                System.out.println("4. SpecialOfferProduct");
                System.out.println("5. SpecialOffer");
                Scanner scdsales = new Scanner(System.in);
                int vssales = scdsales.nextInt();
                switch(vssales){
                    case 1:
                        DemoCustomer.demogenerica();
                    break;
                    case 2: 
                        DemoSalesOrderDetail.demogenerica();
                    break;
                    case 3:
                        DemoSalesOrderHEader.demogenerica();
                    break;
                    case 4: 
                        DemoSpecialOffer.demogenerica();
                    break;
                    case 5: 
                        DemoSpecialOff.demogenerica();
                    break;
                    }
            break;
            case 2: 
            System.out.println("Seleccione un demo: \n");
            System.out.println("1. Product");
            System.out.println("2. ProductCategory");
            System.out.println("3. ProductSubCategory");
            Scanner scdproduction = new Scanner(System.in);
            int vsproduction = scdproduction.nextInt();
            switch(vsproduction){
                case 1:
                    DemoCustomer.demogenerica();
                break;
                case 2: 
                    DemoSalesOrderDetail.demogenerica();
                break;
                case 3:
                    DemoSalesOrderHEader.demogenerica();
                break;                
                }                
            break;
            case 3:

            break;
        }
    } 
}