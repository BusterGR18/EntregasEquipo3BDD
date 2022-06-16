package Demos;
import DAO.CNADAO;
import ImpDAO.ImplConsultasNA;

public class DemoConsultasNA {
    public static void listcon3(){                
        try{
            CNADAO dao = new ImplConsultasNA();
            dao.consulta_3();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void listcon9(){                
        try{
            CNADAO dao = new ImplConsultasNA();
            dao.consulta_9();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
