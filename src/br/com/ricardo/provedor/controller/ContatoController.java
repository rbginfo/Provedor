package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Contato;
import br.com.ricardo.provedor.persistencia.ContatoDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.ContatoDAO;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ContatoController {

    public int salvar(Contato c) {
        ContatoDAO dao = new ContatoDaoJDBC();
        return dao.salvar(c);
    }
    
     public List<Contato> listarTodos() {
        ContatoDAO dao = new ContatoDaoJDBC();
        return dao.listAll();
    }

    
    public Contato listById(int id) {
        ContatoDAO dao = new ContatoDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        ContatoDAO dao = new ContatoDaoJDBC();
        return dao.remove(id);
    }
}
