import java.util.Scanner;

import Demos.DemoConsultasAPA;
import Demos.DemoConsultasEU;
import Demos.DemoConsultasI2AW;
import Demos.DemoConsultasNA;
import Demos.DemoCustomer;
import Demos.DemoProduct;
import Demos.DemoProductCategory;
import Demos.DemoProductSubCategory;
import Demos.DemoSpecialOff;
import Demos.DemoSalesOrderDetail;
import Demos.DemoSalesOrderHEader;
import Demos.DemoSpecialOffer;
import Conex.*;


public class App {
    public static void main(String[] args) throws Exception {
        
        
        System.out.println("DAO Para fragmentacion: \n");
        System.out.println("Selecciona una opcion:");        
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
                    DemoProduct.demogenerica();
                break;
                case 2: 
                    DemoProductCategory.demogenerica();
                break;
                case 3:
                    DemoProductSubCategory.demogenerica();
                break;                
                }                
            break;
            case 3:
            System.out.println("Seleccione una consulta: ");
            for (int xdi = 1;xdi<11; xdi++){
                System.out.println(xdi+") Consulta "+xdi);
            }
            Scanner scdcons = new Scanner(System.in);
            int vscons = scdcons.nextInt();      
            switch(vscons){
                case 1:
                    System.out.println("Consulta 1:");
                    System.out.println("La información de los clientes de almacenarse por región, considerando las regiones de acuerdo con el atributo group de SalesTerritory");
                    System.out.println("Consulta ya implementada para la fragmentacion de la base");
                break;
                case 2:

                break;
                case 3:
                    DemoConsultasNA.listcon3();
                break;
                case 4:
                    DemoConsultasEU.listcon4();
                break;
                case 5:
                    DemoConsultasI2AW.listcon5();
                break;
                case 6:
                    DemoConsultasAPA.listcon6();
                break;
                case 7:
                    DemoConsultasI2AW.listcon7();
                break;
                case 8:
                    DemoConsultasI2AW.listcon8();
                break;
                case 9:
                    DemoConsultasNA.listcon9();
                break;
                case 10:
                    System.out.println("Consulta 10: \n");
                break;
            }
            break;
        }
    } 
}