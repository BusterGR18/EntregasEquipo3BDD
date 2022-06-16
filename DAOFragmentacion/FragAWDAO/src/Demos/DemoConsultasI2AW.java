package Demos;

import java.sql.*;
import Conex.ConexionI2SS;
import ImpDAO.ImplConsultasAW;
import DAO.CAWDAO;

public class DemoConsultasI2AW extends ConexionI2SS{    

    public static void listcon5(){                
        try{
            CAWDAO dao = new ImplConsultasAW();
            dao.consulta_5();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void listcon7(){                
        try{
            CAWDAO dao = new ImplConsultasAW();
            dao.consulta_7();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void listcon8(){                
        try{
            CAWDAO dao = new ImplConsultasAW();
            dao.consulta_8();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
