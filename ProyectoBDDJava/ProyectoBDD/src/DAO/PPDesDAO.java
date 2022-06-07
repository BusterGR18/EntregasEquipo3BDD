package DAO;

public interface PPDesDAO {
    public void registrar(ppdes PDescription)throws Exception;
    public void modificar(ppdes PDescription)throws Exception;
    public void eliminar(ppdes PDescription)throws Exception;
    public void listar(ppdes PDescription)throws Exception;

}
