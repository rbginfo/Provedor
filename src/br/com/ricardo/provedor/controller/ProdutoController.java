package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Produto;
import br.com.ricardo.provedor.persistencia.ProdutoDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.ProdutoDAO;
import java.util.List;

/**
 *
 * @author Ricardo Benedet Garcia
 */
public class ProdutoController {
    
    public int salvar(Produto produto) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.salve(produto);
    }

    public List<Produto> listarTodos() {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.listAll();
    }

    public List<Produto> listByNome(String nome) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.listByNome(nome);
    }

    public Produto listById(int id) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.remove(id);
    }
    
}
