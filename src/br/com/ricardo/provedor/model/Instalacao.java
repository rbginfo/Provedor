package br.com.ricardo.provedor.model;

/**
 *
 * @author Ricardo Benedet Garcia
 */
public class Instalacao {
    
    private int id;
    private int idCliente;
    private int idPlano;
    private int idClienteLogin;
    private String status;
    private ClienteLogin clienteLogin;
    private PlanoAcesso planoAcesso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public int getIdClienteLogin() {
        return idClienteLogin;
    }

    public void setIdClienteLogin(int idClienteLogin) {
        this.idClienteLogin = idClienteLogin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClienteLogin getClienteLogin() {
        return clienteLogin;
    }

    public void setClienteLogin(ClienteLogin clienteLogin) {
        this.clienteLogin = clienteLogin;
    }

    public PlanoAcesso getPlanoAcesso() {
        return planoAcesso;
    }

    public void setPlanoAcesso(PlanoAcesso planoAcesso) {
        this.planoAcesso = planoAcesso;
    }
   
    
    
    
    
}
