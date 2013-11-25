package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.ClientePF;
import br.com.ricardo.provedor.persistencia.ClientePFDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.ClientePFDAO;
import java.util.List;

public class ClientePFController {

    public int salvar(ClientePF clientePF) {
        ClientePFDAO dao = new ClientePFDaoJDBC();
        return dao.salve(clientePF);
    }

    public List<ClientePF> listarTodos() {
        ClientePFDAO dao = new ClientePFDaoJDBC();
        return dao.listAll();
    }

    public List<ClientePF> listByNome(String nome) {
        ClientePFDAO dao = new ClientePFDaoJDBC();
        return dao.listByNome(nome);
    }

    public ClientePF listById(int id) {
        ClientePFDAO dao = new ClientePFDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        ClientePFDAO dao = new ClientePFDaoJDBC();
        return dao.remove(id);
    }

    
}
