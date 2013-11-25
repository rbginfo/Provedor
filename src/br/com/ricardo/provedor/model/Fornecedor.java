package br.com.ricardo.provedor.model;

public class Fornecedor extends PessoaPJ{

    private int id;
    private String NomeContato;
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

    public String getNomeContato() {
        return NomeContato;
    }

    public void setNomeContato(String NomeContato) {
        this.NomeContato = NomeContato;
    }

    
    
    
    
}
