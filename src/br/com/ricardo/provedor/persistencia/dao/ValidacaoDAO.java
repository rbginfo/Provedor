

package br.com.ricardo.provedor.persistencia.dao;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public interface ValidacaoDAO {
    
    boolean validaCPF(String cpf);
    boolean validaCNPJ(String cnpj);
    boolean validaCTPS(String ctps);

}
