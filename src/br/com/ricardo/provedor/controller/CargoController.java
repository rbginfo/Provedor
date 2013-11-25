package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Cargo;
import br.com.ricardo.provedor.persistencia.CargoDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.CargoDAO;
import java.util.List;

/**
 *
 * @author ricardo
 */
public class CargoController {

    public int salvar(Cargo c) {
        CargoDAO dao = new CargoDaoJDBC();
        return dao.salve(c);
    }

    public List<Cargo> listarTodos() {
        CargoDAO dao = new CargoDaoJDBC();
        return dao.listAll();
    }

    public List<Cargo> listByNome(String nome) {
        CargoDAO dao = new CargoDaoJDBC();
        return dao.listByNome(nome);
    }

    public Cargo listById(int id) {
        CargoDAO dao = new CargoDaoJDBC();
        return dao.listById(id);
    }
    
    public Cargo listaNome(String nome) {
        CargoDAO dao = new CargoDaoJDBC();
        return dao.listaNome(nome);
    }

    public boolean remove(int id) {
        CargoDAO dao = new CargoDaoJDBC();
        return dao.remove(id);
    }
}
