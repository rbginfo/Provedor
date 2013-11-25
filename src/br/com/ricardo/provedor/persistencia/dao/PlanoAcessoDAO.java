

package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.PlanoAcesso;
import java.util.List;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public interface PlanoAcessoDAO {
    
    int salve(PlanoAcesso plano);
    boolean remove (int id);
    List<PlanoAcesso> listAll();
    PlanoAcesso listById (int id);
    List<PlanoAcesso> listByNome(String nome);

}
