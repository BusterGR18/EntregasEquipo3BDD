package Demos;

import DAO.CEUDAO;
import ImpDAO.ImplConsultasEU;

public class DemoConsultasEU {
    public static void listcon2(){                
        try{
            CEUDAO dao = new ImplConsultasEU();
            dao.consulta_2();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void listcon4(){                
        try{
            CEUDAO dao = new ImplConsultasEU();
            dao.consulta_4();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}