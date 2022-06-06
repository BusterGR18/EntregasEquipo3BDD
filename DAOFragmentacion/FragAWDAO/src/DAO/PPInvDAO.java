package DAO;

public interface PPInvDAO {
    public void registrar(ppinv PInventory)throws Exception;
    public void modificar(ppinv PInventory)throws Exception;
    public void eliminar(ppinv PInventory)throws Exception;
    public void listar(ppinv PInventory)throws Exception;
}
