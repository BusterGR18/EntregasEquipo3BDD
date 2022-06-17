package Demos;

import DAO.CAPADAO;
import ImpDAO.ImplConsultasAsiaPacific;

public class DemoConsultasAPA {
    
    public static void listcon2(){                
        try{
            CAPADAO dao = new ImplConsultasAsiaPacific();
            dao.consulta_2();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void listcon6(){                
        try{
            CAPADAO dao = new ImplConsultasAsiaPacific();
            dao.consulta_6();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}