

package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.ClienteLogin;
import br.com.ricardo.provedor.persistencia.ClienteLoginDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.ClienteLoginDAO;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public class ClienteLoginController {
    
    public int salvar(ClienteLogin clienteLogin) {
        ClienteLoginDAO dao = new ClienteLoginDaoJDBC();
        return dao.salvar(clienteLogin);
    }

}
