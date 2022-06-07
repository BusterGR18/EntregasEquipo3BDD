package Demos;
import Conex.ConexionI2SS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.*;

import DAO.SODDAO;
import DAO.sod;
import ImpDAO.ImpNuevaOrden;
import ImpDAO.ImplSOrderDetail;
import java.util.Scanner;
import DAO.SOHDAO;
import DAO.soh;
import ImpDAO.ImplSOrderHeader;

public class DemoNuevaOrden extends ConexionI2SS {

    public static void iniciar_nuorden() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Iniciando nueva orden \n");
        //System.out.println("Ingrese ID del producto: ");
        //int prodid = sc.nextInt();
        //System.out.println("Ingrese cantidad: ");
        //int prodcant = sc.nextInt();       
        System.out.println("Insert en SOH \n");
        inssoh();
        System.out.println("Insert en SOD \n");
        inssod();
        
    }
    

    public static void inssoh(){
        Scanner scsoh = new Scanner(System.in);
        System.out.println("Ingresa RevisionNumber");
        int rn =scsoh.nextInt();
        System.out.println("Ingresa Status");
        int status =scsoh.nextInt();
        System.out.println("Ingresa OnlineOrderFlag");
        int oof =scsoh.nextInt();
        System.out.println("Ingresa CustomerID");
        int cid =scsoh.nextInt();
        System.out.println("Ingresa BillToAddressID");
        int bttid =scsoh.nextInt();
        System.out.println("Ingresa ShiplToAddressID");
        int staid =scsoh.nextInt();
        System.out.println("Ingresa ShipMethodID");
        int smid =scsoh.nextInt();

        String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=IDEAPAD-GAMING-\\MSSQL2;databaseName=AdventureWorks2019;user=sa;password=cacas;encrypt=true;trustServerCertificate=true";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            CallableStatement cs = con.prepareCall("{CALL sp_insercion_SOH(?,?,?,?,?,?,?,?)}");            
            cs.setInt(1, rn);
            cs.setInt(2, status);
            cs.setInt(3, oof);
            cs.setInt(4, cid);
            cs.setInt(5, bttid);
            cs.setInt(6, staid);
            cs.setInt(7, smid);
            cs.registerOutParameter(8, java.sql.Types.VARCHAR);

            cs.execute();
            String res =cs.getString(8);
            System.out.println(res);
        }
        // Handler para errores.
        catch (SQLException e) {
            e.printStackTrace();        
    }
    }

    public static void inssod(){
        Scanner scsod = new Scanner(System.in);
        System.out.println("Ingresa ID del Producto");
        int idpac =scsod.nextInt();
        System.out.println("Ingresa Cantidad a comprar");
        int cancomp =scsod.nextInt();

        String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=IDEAPAD-GAMING-\\MSSQL2;databaseName=AdventureWorks2019;user=sa;password=cacas;encrypt=true;trustServerCertificate=true";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            CallableStatement cs = con.prepareCall("{CALL sp_insercion_SOD_TEST(?,?.?)}");            
            cs.setInt(1, idpac);        
            cs.setInt(2,cancomp);
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);

            cs.execute();
            String res =cs.getString(3);
            System.out.println(res);
        }
        // Handler para errores.
        catch (SQLException e) {
            e.printStackTrace();        
    }
              
    }
}
