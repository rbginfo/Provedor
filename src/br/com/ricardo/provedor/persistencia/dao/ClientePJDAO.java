

package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.ClientePJ;
import java.util.List;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public interface ClientePJDAO {
    
    int salve(ClientePJ clientePJ);
    boolean remove (int id);
    List<ClientePJ> listAll();
    ClientePJ listById (int id);
    List<ClientePJ> listByNome(String nome);

}
