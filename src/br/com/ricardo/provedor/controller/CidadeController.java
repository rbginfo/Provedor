

package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Cidade;
import br.com.ricardo.provedor.persistencia.CidadeDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.CidadeDAO;
import java.util.List;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public class CidadeController {
    
    public int salvar(Cidade cidade) {
        CidadeDAO dao = new CidadeDaoJDBC();
        return dao.salve(cidade);
    }

    public List<Cidade> listarTodos() {
        CidadeDAO dao = new CidadeDaoJDBC();
        return dao.listAll();
    }

    public List<Cidade> listByNome(String nome) {
        CidadeDAO dao = new CidadeDaoJDBC();
        return dao.listByNome(nome);
    }

    public Cidade listById(int id) {
        CidadeDAO dao = new CidadeDaoJDBC();
        return dao.listById(id);
    }
    
    public Cidade listaNome(String nome) {
        CidadeDAO dao = new CidadeDaoJDBC();
        return dao.listaNome(nome);
    }

    public boolean remove(int id) {
        CidadeDAO dao = new CidadeDaoJDBC();
        return dao.remove(id);
    }

}
