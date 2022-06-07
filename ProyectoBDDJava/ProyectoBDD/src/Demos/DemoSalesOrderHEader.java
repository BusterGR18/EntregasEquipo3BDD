package Demos;
import java.util.Scanner;
import DAO.SOHDAO;
import DAO.soh;
import ImpDAO.ImplSOrderHeader;

public class DemoSalesOrderHEader {

    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");
        System.out.println("1. C");
        System.out.println("2. R");
        System.out.println("3. U");
        System.out.println("4. D");
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                cresoh();
            break;
            case 2: 
                listsoh();
            break;
            case 3:
                actsoh();
            break;
            case 4: 
                delsoh();
            break;
        }
    }

    public static void cresoh(){
        Scanner sch = new Scanner(System.in);
        soh sorderheader = new soh();
        System.out.println("Demo C");  
        sorderheader.setRevisionNumber(3);
        try{
            SOHDAO dao = new ImplSOrderHeader();
            dao.registrar(sorderheader);
        }catch(Exception e){
            e.printStackTrace();
        }   

    }

    public static void listsoh(){
        soh SalOrderHead = new soh();
        SalOrderHead.setSalesOrderID(1);
        try{
            SOHDAO dao = new ImplSOrderHeader();
            dao.listar(SalOrderHead);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void actsoh(){
        Scanner sch = new Scanner(System.in);
        soh sorderheader = new soh();
        System.out.println("Demo U");     


        try{
            SOHDAO dao = new ImplSOrderHeader();
            dao.modificar(sorderheader);
        }catch(Exception e){
            e.printStackTrace();
        }   
    }

    public static void delsoh(){
        Scanner sc= new Scanner(System.in);
        soh sorderheader = new soh();
        System.out.println("Introduzca el ID a eliminar: ");
        int sohid = sc.nextInt();
        sorderheader.setSalesOrderID(sohid);
        try{   
            SOHDAO dao = new ImplSOrderHeader();
            dao.eliminar(sorderheader);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
