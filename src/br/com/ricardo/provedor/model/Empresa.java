package br.com.ricardo.provedor.model;

public class Empresa extends PessoaPJ{

    private int id;
    private String codAnatel;
    private int idEndereco;
    private int idContato;

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    
    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodAnatel() {
        return codAnatel;
    }

    public void setCodAnatel(String codAnatel) {
        this.codAnatel = codAnatel;
    }
    
    
    
}
