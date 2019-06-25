package interfaces;

import entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author BETHZY
 */
public interface IClientes {
    
    public abstract ArrayList<Cliente> listClientes ();
    
    public abstract boolean insertClientes (Cliente objClientes);
    
    public abstract boolean updateClientes (Cliente objClientes);
    
    public abstract boolean deleteClientes (Cliente objClientes);
    
}
