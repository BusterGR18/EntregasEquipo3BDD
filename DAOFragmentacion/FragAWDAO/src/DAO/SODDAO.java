package DAO;

public interface SODDAO {
    public void registrar (sod sodetail) throws Exception;
    public void modificar (sod sodetail) throws Exception;
    public void eliminar (sod sodetail) throws Exception;
    public void listar (sod sodetail) throws Exception;
}
