package br.com.ricardo.provedor.model;

import java.util.Date;

/**
 *
 * @author Ricardo Benedet Garcia
 */
public class ClientePJ extends PessoaPJ{
    
    private int id;
    private Date dataContrato;
    private ClienteLogin acess;
    private PlanoAcesso plano;
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

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public ClienteLogin getAcess() {
        return acess;
    }

    public void setAcess(ClienteLogin acess) {
        this.acess = acess;
    }

    public PlanoAcesso getPlano() {
        return plano;
    }

    public void setPlano(PlanoAcesso plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "ClientePJ{" + "id=" + id + ", dataContrato=" + dataContrato + '}';
    }
    
    
    
}
