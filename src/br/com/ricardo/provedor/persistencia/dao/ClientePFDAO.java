package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.ClientePF;
import java.util.List;

public interface ClientePFDAO {

    int salve(ClientePF clientePF);
    boolean remove (int id);
    List<ClientePF> listAll();
    ClientePF listById (int id);
    List<ClientePF> listByNome(String nome);
    
    
}
