package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Contato;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface ContatoDAO {
    
    int salvar (Contato c);
    boolean remove (int id);
    List<Contato> listAll();
    Contato listById (int id);
    
}
