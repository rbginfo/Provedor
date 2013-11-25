package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Funcionario;
import br.com.ricardo.provedor.persistencia.FuncionarioDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.FuncionarioDAO;
import java.util.List;

public class FuncionarioController {

    public int salvar(Funcionario f) {
        FuncionarioDAO dao = new FuncionarioDaoJDBC();
        return dao.salve(f);
    }

    public List<Funcionario> listarTodos() {
        FuncionarioDAO dao = new FuncionarioDaoJDBC();
        return dao.listAll();
    }

    public List<Funcionario> listByNome(String nome) {
        FuncionarioDAO dao = new FuncionarioDaoJDBC();
        return dao.listByNome(nome);
    }

    public Funcionario listById(int id) {
        FuncionarioDAO dao = new FuncionarioDaoJDBC();
        return dao.listById(id);
    }

    public boolean remove(int id) {
        FuncionarioDAO dao = new FuncionarioDaoJDBC();
        return dao.remove(id);
    }

    public boolean validaLogin(String login, String senha) {
        FuncionarioDAO dao = new FuncionarioDaoJDBC();
        return dao.validaLogin(login, senha);
    }
}
