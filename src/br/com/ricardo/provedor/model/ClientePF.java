package br.com.ricardo.provedor.model;

import java.util.Date;

public class ClientePF extends PessoaPF{

    private int id;
    private Date dataContrato;
    private ClienteLogin acess;
    private PlanoAcesso plano;
    private int idEndereco;
    private int idContato;
    private int idInstalacao;
    private int idPlanoAcesso;
    private int idEquipamentos;
    
    

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

    @Override
    public String toString() {
        return "ClientePF{" + "id=" + id + ", dataContrato=" + dataContrato + '}';
    }
    
          
    
}
