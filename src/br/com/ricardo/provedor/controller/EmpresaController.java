package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.model.Empresa;
import br.com.ricardo.provedor.persistencia.EmpresaDaoJDBC;
import br.com.ricardo.provedor.persistencia.dao.EmpresaDAO;
import java.util.List;

/**
 * www.tecnokernel.com.br
 *
 * @author Ricardo Benedet Garcia rbg_info@hotmail.com
 */
public class EmpresaController {

    public int salvar(Empresa empresa) {
        EmpresaDAO dao = new EmpresaDaoJDBC();
        return dao.salve(empresa);
    }

  
    public Empresa listById(int id) {
        EmpresaDAO dao = new EmpresaDaoJDBC();
        return dao.listById(id);
    }

}
