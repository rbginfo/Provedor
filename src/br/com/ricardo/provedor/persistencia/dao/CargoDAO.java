package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Cargo;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface CargoDAO {
    
    int salve(Cargo c);
    boolean remove (int id);
    List<Cargo> listAll();
    Cargo listById (int id);
    Cargo listaNome (String nome);
    List<Cargo> listByNome(String nome);
    
}
