package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Endereco;
import br.com.ricardo.provedor.persistencia.EnderecoDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.EnderecoDAO;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class EnderecoController {

    public int salvar(Endereco e) {
        EnderecoDAO dao = new EnderecoDaoJDBC();
        return dao.salvar(e);
    }
    
    public List<Endereco> listarTodos() {
        EnderecoDAO dao = new EnderecoDaoJDBC();
        return dao.listAll();
    }

    
    public Endereco listById(int id) {
        EnderecoDAO dao = new EnderecoDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        EnderecoDAO dao = new EnderecoDaoJDBC();
        return dao.remove(id);
    }
}
