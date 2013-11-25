package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Endereco;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface EnderecoDAO {
    
    int salvar (Endereco e);
    boolean remove (int id);
    List<Endereco> listAll();
    Endereco listById (int id);
    
}
