package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Uf;
import br.com.ricardo.provedor.persistencia.UfDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.UfDAO;
import java.util.List;


public class UfController {

    
    
    public List<Uf> listarTodos() {
        UfDAO dao = new UfDaoJDBC();
        return dao.listAll();
    }

    

    public Uf listById(int id) {
        UfDAO dao = new UfDaoJDBC();
        return dao.listById(id);
    }
    
    public Uf listaNome(String nome) {
        UfDAO dao = new UfDaoJDBC();
        return dao.listaNome(nome);
    }

   
    
}
