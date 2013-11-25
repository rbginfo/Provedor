package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Instalacao;
import java.util.List;

/**
 *
 * @author Ricardo Benedet Garcia
 */
public interface InstalacaoDAO {
    
    int salve(Instalacao instalacao);
    boolean remove (int id);
    List<Instalacao> listAll();
    Instalacao listById (int id);
    List<Instalacao> listByNome(String nome);
    
    
}
