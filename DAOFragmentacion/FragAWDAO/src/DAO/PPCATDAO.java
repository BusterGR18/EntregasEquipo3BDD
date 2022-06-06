package DAO;

public interface PPCATDAO {
    public void registrar(ppcat PCategory)throws Exception;
    public void modificar(ppcat PCategory)throws Exception;
    public void eliminar(ppcat PCategory)throws Exception;
    public void listar(ppcat PCategory)throws Exception;
}
