

package br.com.ricardo.provedor.controller;

import br.com.ricardo.provedor.implement.ValidacaoImplements;
import br.com.ricardo.provedor.persistencia.dao.ValidacaoDAO;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public class ValidacaoController {
    
     public boolean validaCPF(String cpf) {
        ValidacaoDAO dao = new ValidacaoImplements();
        return dao.validaCPF(cpf);
    }
     
     public boolean validaCTPS(String ctps) {
        ValidacaoDAO dao = new ValidacaoImplements();
        return dao.validaCPF(ctps);
    }
     
     public boolean validaCNPJ(String cnpj) {
        ValidacaoDAO dao = new ValidacaoImplements();
        return dao.validaCPF(cnpj);
    }

}
