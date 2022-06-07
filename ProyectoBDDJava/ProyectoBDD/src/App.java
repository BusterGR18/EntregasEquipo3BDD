import java.util.Scanner;
import Demos.DemoCustomer;
import Demos.DemoNuevaOrden;
import Demos.DemoSalesOrderDetail;
import Demos.DemoSalesOrderHEader;
import Demos.DemoSpecialOffer;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Comprobacion de conexion:");
        System.out.println("");
        //Conectorv1.ins1();
        //Conectorv1.ins2();
        //Conectorv1.mysqlconn();
        //DemoCustomer.listcus();
        //DemoSalesOrderDetail.listsod();
        // Variable para la conexion 

        //SET DATEFORMAT 
        System.out.println("Seleccione un demo: \n");
        System.out.println("1. Customer");
        System.out.println("2. SalesOrderDetail");
        System.out.println("3. SalesOrderHeader");
        System.out.println("4. SpecialOfferProduct");
        System.out.println("5. Insercion final");
        Scanner scmain = new Scanner(System.in);
        int op = scmain.nextInt();
        switch(op){
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
                DemoNuevaOrden.iniciar_nuorden();
            break;
        }
    } 
}