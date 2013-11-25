package br.com.ricardo.provedor.model;

public abstract class PessoaPJ {

    private String RasaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String ie;
    private String iMunicipal;
    private Endereco end;
    private Contato contato;

    public String getRasaoSocial() {
        return RasaoSocial;
    }

    public void setRasaoSocial(String RasaoSocial) {
        this.RasaoSocial = RasaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getiMunicipal() {
        return iMunicipal;
    }

    public void setiMunicipal(String iMunicipal) {
        this.iMunicipal = iMunicipal;
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
    
    
    
}
