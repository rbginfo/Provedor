package br.com.ricardo.provedor.model;

import br.com.ricardo.provedor.implement.ValidacaoImplements;
import java.util.Date;
import javax.swing.JOptionPane;

public abstract class PessoaPF {

    private String nome;
    private String sobreNome;
    private String cpf;
    private String rg;
    private String sexo;
    private Date dataNascimento;
    private Endereco end;
    private Contato contato;
    
   
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        
            this.cpf = cpf;
        
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    

    @Override
    public String toString() {
        return "PessoaPF{" + "nome=" + nome + ", sobreNome=" + sobreNome + ", cpf=" + cpf + ", rg=" + rg + ", sexo=" + sexo + '}';
    }

    
    
}
