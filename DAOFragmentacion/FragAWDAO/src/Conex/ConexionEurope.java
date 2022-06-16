package Conex;
import java.sql.*;
public class ConexionEurope {
    protected Connection conexion;
    private final String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=IDEAPAD-GAMING-\\MSSQL2;databaseName=Europe;user=sa;password=cacas;encrypt=true;trustServerCertificate=true";
    public void conectar(){
        try  {
            conexion = DriverManager.getConnection(connectionUrl);             
        }
        // Handler para errores.
        catch (SQLException e) {
            e.printStackTrace();        
    }
    }

    public void cerrar() throws SQLException{
        if (conexion!= null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}
