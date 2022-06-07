package Conex;

import java.sql.*;
public class ConexionI1SS {
    protected Connection cone;
    private final String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=IDEAPAD-GAMING-\\MSSQL1;databaseName=AdventureWorks2019;user=sa;password=cacas;encrypt=true;trustServerCertificate=true";
    public void conectar(){
        try (Connection cone = DriverManager.getConnection(connectionUrl); Statement stmt = cone.createStatement();) {
            
        }
        // Handler para errores.
        catch (SQLException e) {
            e.printStackTrace();        
    }
    }

    public void cerrar() throws SQLException{
        if (cone!= null){
            if(!cone.isClosed()){
                cone.close();
            }
        }
    }

}
