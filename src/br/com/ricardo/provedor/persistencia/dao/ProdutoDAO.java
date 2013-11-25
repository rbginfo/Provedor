package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Produto;
import java.util.List;

/**
 *
 * @author Ricardo Benedet Garcia
 */
public interface ProdutoDAO {
    
    int salve(Produto produto);
    boolean remove (int id);
    List<Produto> listAll();
    Produto listById (int id);
    List<Produto> listByNome(String nome);
    
}
