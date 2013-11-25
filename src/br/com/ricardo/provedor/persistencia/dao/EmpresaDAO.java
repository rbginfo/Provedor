package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Empresa;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface EmpresaDAO {

    int salve(Empresa empresa);
    Empresa listById (int id);
    
    
}
