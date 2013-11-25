package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Instalacao;
import br.com.ricardo.provedor.persistencia.InstalacaoDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.InstalacaoDAO;
import java.util.List;

/**
 *
 * @author Ricardo Benedet Garcia
 */
public class InstalacaoController {
    
     public int salvar(Instalacao instalacao) {
        InstalacaoDAO dao = new InstalacaoDaoJDBC();
        return dao.salve(instalacao);
    }

    public List<Instalacao> listarTodos() {
        InstalacaoDAO dao = new InstalacaoDaoJDBC();
        return dao.listAll();
    }

    public List<Instalacao> listByNome(String nome) {
        InstalacaoDAO dao = new InstalacaoDaoJDBC();
        return dao.listByNome(nome);
    }

    public Instalacao listById(int id) {
        InstalacaoDAO dao = new InstalacaoDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        InstalacaoDAO dao = new InstalacaoDaoJDBC();
        return dao.remove(id);
    }

    
    
}
