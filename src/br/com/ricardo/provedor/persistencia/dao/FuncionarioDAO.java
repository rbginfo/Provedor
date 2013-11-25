package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Funcionario;
import java.util.List;

public interface FuncionarioDAO {

    int salve(Funcionario f);
    boolean remove (int id);
    List<Funcionario> listAll();
    Funcionario listById (int id);
    List<Funcionario> listByNome(String nome);
    boolean validaLogin(String login, String senha);
    
}
