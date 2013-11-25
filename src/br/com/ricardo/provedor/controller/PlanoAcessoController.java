package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.PlanoAcesso;
import br.com.ricardo.provedor.persistencia.PlanoAcessoDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.PlanoAcessoDAO;
import java.util.List;

/**
 * www.tecnokernel.com.br
 *
 * @author Ricardo Benedet Garcia rbg_info@hotmail.com
 */
public class PlanoAcessoController {

    public int salvar(PlanoAcesso plano) {
        PlanoAcessoDAO dao = new PlanoAcessoDaoJDBC();
        return dao.salve(plano);
    }

    public List<PlanoAcesso> listarTodos() {
        PlanoAcessoDAO dao = new PlanoAcessoDaoJDBC();
        return dao.listAll();
    }

    public List<PlanoAcesso> listByNome(String nome) {
        PlanoAcessoDAO dao = new PlanoAcessoDaoJDBC();
        return dao.listByNome(nome);
    }

    public PlanoAcesso listById(int id) {
        PlanoAcessoDAO dao = new PlanoAcessoDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        PlanoAcessoDAO dao = new PlanoAcessoDaoJDBC();
        return dao.remove(id);
    }
}
