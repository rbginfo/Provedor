

package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Fornecedor;
import java.util.List;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public interface FornecedorDAO {
    
    int salve(Fornecedor fornecedor);
    boolean remove (int id);
    List<Fornecedor> listAll();
    Fornecedor listById (int id);
    List<Fornecedor> listByNome(String nome);

}
