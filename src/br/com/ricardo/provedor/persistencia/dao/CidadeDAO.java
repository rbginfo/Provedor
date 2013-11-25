package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Cidade;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface CidadeDAO {
    
    int salve(Cidade cidade);
    boolean remove (int id);
    List<Cidade> listAll();
    Cidade listById (int id);
    List<Cidade> listByNome(String nome);

    Cidade listaNome(String nome);
    
    
}
