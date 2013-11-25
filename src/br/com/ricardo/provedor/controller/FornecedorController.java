

package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Fornecedor;
import br.com.ricardo.provedor.persistencia.FornecedorDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.FornecedorDAO;
import java.util.List;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public class FornecedorController {
    
    public int salvar(Fornecedor fornecedor) {
        FornecedorDAO dao = new FornecedorDaoJDBC();
        return dao.salve(fornecedor);
    }

    public List<Fornecedor> listarTodos() {
        FornecedorDAO dao = new FornecedorDaoJDBC();
        return dao.listAll();
    }

    public List<Fornecedor> listByNome(String nome) {
        FornecedorDAO dao = new FornecedorDaoJDBC();
        return dao.listByNome(nome);
    }

    public Fornecedor listById(int id) {
        FornecedorDAO dao = new FornecedorDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        FornecedorDAO dao = new FornecedorDaoJDBC();
        return dao.remove(id);
    }

}
