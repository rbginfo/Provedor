

package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.ClientePJ;
import br.com.ricardo.provedor.persistencia.ClientePJDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.ClientePJDAO;
import java.util.List;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public class ClientePJController {
    
    public int salvar(ClientePJ clientePJ) {
        ClientePJDAO dao = new ClientePJDaoJDBC();
        return dao.salve(clientePJ);
    }

    public List<ClientePJ> listarTodos() {
        ClientePJDAO dao = new ClientePJDaoJDBC();
        return dao.listAll();
    }

    public List<ClientePJ> listByNome(String nome) {
        ClientePJDAO dao = new ClientePJDaoJDBC();
        return dao.listByNome(nome);
    }

    public ClientePJ listById(int id) {
        ClientePJDAO dao = new ClientePJDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        ClientePJDAO dao = new ClientePJDaoJDBC();
        return dao.remove(id);
    }

}
