package br.com.ricardo.provedor.model;

/**
 *
 * @author Ricardo Benedet Garcia
 */
public class Cidade {
    
    private int id;
    private String nome;
    private int idUf;
    private Uf uf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdUf() {
        return idUf;
    }

    public void setIdUf(int idUf) {
        this.idUf = idUf;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }
    
        
}
