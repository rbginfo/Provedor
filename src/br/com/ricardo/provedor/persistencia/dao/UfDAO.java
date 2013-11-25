/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ricardo.provedor.persistencia.dao;

import br.com.ricardo.provedor.model.Uf;
import java.util.List;

/**
 *
 * @author guest01
 */
public interface UfDAO {
    
    
    List<Uf> listAll();
    Uf listById (int id);
    Uf listaNome (String nome);
    
    
}
