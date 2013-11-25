

package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.ClientePJ;
import br.com.ricardo.provedor.persistencia.dao.ClientePJDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public class ClientePJDaoJDBC implements ClientePJDAO{
    
    private static final String INSERT = "insert into cliente(rasaoSocial, nomeFantasia, cnpj, ie, im, dataContrato, id_endereco, id_contato) values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String LIST = "select * from cliente, endereco, contato where cliente.id_endereco = endereco.id and cliente.id_contato = contato.id;";
    private static final String REMOVE = "delete from cliente where id = ?;";
    private static final String UPDATE = "update cliente set rasaoSocial = ?, nomeFantasia = ?, cnpj = ?, ie = ?, im = ?, dataContrato = ? where id = ?;";
    private static final String LISTBYID = "select * from cliente where id = ?;";
    private static final String LISTBYNOME = "select * from cliente where nome like ?;";
    
    private int insert(ClientePJ clientePJ) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, clientePJ.getNomeFantasia());
            pstm.setString(2, clientePJ.getRasaoSocial());
            pstm.setString(3, clientePJ.getCnpj());
            pstm.setString(4, clientePJ.getIe());
            pstm.setString(5, clientePJ.getiMunicipal());
            pstm.setDate(6, new java.sql.Date(clientePJ.getDataContrato().getTime()));
            pstm.setInt(7, clientePJ.getEnd().getId());
            pstm.setInt(8, clientePJ.getContato().getId());
            
            
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados do cliente Pessoa Jurídica " + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
            return retorno;
        }
    }

    private int update(ClientePJ clientePJ) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, clientePJ.getNomeFantasia());
            pstm.setString(2, clientePJ.getRasaoSocial());
            pstm.setString(3, clientePJ.getCnpj());
            pstm.setString(4, clientePJ.getIe());
            pstm.setString(5, clientePJ.getiMunicipal());
            pstm.setDate(6, new java.sql.Date(clientePJ.getDataContrato().getTime()));
            pstm.setInt(7, clientePJ.getId());
            pstm.execute();
            retorno = clientePJ.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar os dados do cliente Pessoa Jurídica " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }

        }
        return retorno;

    }
    
    @Override
    public int salve(ClientePJ clientePJ) {
        if (clientePJ.getId() == 0) {
            return insert(clientePJ);
        } else {
            return update(clientePJ);
        }
    }

    @Override
    public boolean remove(int id) {
        boolean status = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(REMOVE);
            pstm.setInt(1, id);
            pstm.execute();
            status = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente Pessoa Jurídica " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public List<ClientePJ> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ClientePJ> clientePJes = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if(rs.getString("nomeFantasia") != null){
                ClientePJ clientePJ = new ClientePJ();
                clientePJ.setId(rs.getInt("id"));
                clientePJ.setNomeFantasia(rs.getString("nomeFantasia"));
                clientePJ.setRasaoSocial(rs.getString("rasaoSocial"));
                clientePJ.setCnpj(rs.getString("cnpj"));
                clientePJ.setIe(rs.getString("ie"));
                clientePJ.setiMunicipal(rs.getString("im"));
                clientePJ.setDataContrato(rs.getDate("DataContrato"));
                clientePJ.setIdEndereco(rs.getInt("id_endereco"));
                clientePJ.setIdContato(rs.getInt("id_contato"));
                
                clientePJes.add(clientePJ);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cliente Pessoa Jurídica " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return clientePJes;
    }

    @Override
    public ClientePJ listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ClientePJ clientePJ = new ClientePJ();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                clientePJ.setId(rs.getInt("id"));
                clientePJ.setNomeFantasia(rs.getString("nomeFantasia"));
                clientePJ.setRasaoSocial(rs.getString("rasaoSocial"));
                clientePJ.setCnpj(rs.getString("cnpj"));
                clientePJ.setIe(rs.getString("ie"));
                clientePJ.setiMunicipal(rs.getString("im"));
                clientePJ.setDataContrato(rs.getDate("DataContrato"));
                clientePJ.setIdEndereco(rs.getInt("id_endereco"));
                clientePJ.setIdContato(rs.getInt("id_contato"));
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar a cliente Pessoa Jurídica " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return clientePJ;}

    @Override
    public List<ClientePJ> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ClientePJ> clientePJes = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientePJ clientePJ = new ClientePJ();
                clientePJ.setId(rs.getInt("id"));
                clientePJ.setNomeFantasia(rs.getString("nomeFantasia"));
                clientePJ.setRasaoSocial(rs.getString("rasaoSocial"));
                clientePJ.setCnpj(rs.getString("cnpj"));
                clientePJ.setIe(rs.getString("ie"));
                clientePJ.setiMunicipal(rs.getString("im"));
                clientePJ.setDataContrato(rs.getDate("DataContrato"));
                
                clientePJes.add(clientePJ);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar a cliente Pessoa Jurídica " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return clientePJes;
    }

}
