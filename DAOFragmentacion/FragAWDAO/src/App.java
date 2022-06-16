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
                    System.out.println("Consulta 2");
                    System.out.println("2. Listar datos ddel empleado que atendió mas ordenes por territorio");
                    System.out.println("Mas vendido en Norte America");
                    DemoConsultasNA.listcon2();
                    System.out.println("Mas vendido en Europa");
                    DemoConsultasEU.listcon2();
                    System.out.println("Mas vendido en Asia Pacifico");
                    DemoConsultasAPA.listcon2();

                break;
                case 3:
                    System.out.println("Consulta 3");
                    System.out.println("3. Listar los datos del cliente con mas ordenes solicitadas en la regón “North America”");
                    DemoConsultasNA.listcon3();
                break;
                case 4:
                    System.out.println("Consulta 4");
                    System.out.println("4. Listar el producto mas solicitado en la región “Europe”");
                    DemoConsultasEU.listcon4();
                break;
                case 5:
                    System.out.println("Consulta 5");
                    System.out.println("5. Listar las ofertas que tienen mas productos de la categoría “Bikes”");
                    DemoConsultasI2AW.listcon5();
                break;
                case 6:
                    System.out.println("Consulta 6");
                    System.out.println("6. Listar los 3 productos menos solicitados en la región “Pacific”");
                    DemoConsultasAPA.listcon6();
                break;
                case 7:
                    System.out.println("Consulta 7");
                    System.out.println("7. Actualizar la subcategoria de los productos con ProductID del 1 al 4 a la subcategoria válida para el tipo de producto.");
                    DemoConsultasI2AW.listcon7();
                break;
                case 8:
                    System.out.println("Consulta 8");
                    System.out.println("8. Listar los productos que no estén disponibles a la venta.");
                    DemoConsultasI2AW.listcon8();
                break;
                case 9:
                    System.out.println("Consulta 9");
                    System.out.println("9. Listar los clientes del territorio 1 al 4 que no tengas asociado un valor en PersonID");
                    DemoConsultasNA.listcon9();
                break;
                case 10:
                    System.out.println("Consulta 10: \n");
                    System.out.println("10. Listar los clientes del territorio 1 que tengan ordenes en otro territorio");
                break;
            }
            break;
        }
    } 
}