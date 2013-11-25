package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.ClientePF;
import br.com.ricardo.provedor.persistencia.dao.ClientePFDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientePFDaoJDBC implements ClientePFDAO {

    private static final String INSERT = "insert into cliente (nome, sobrenome, cpf, rg, sexo, dataContrato, dataNascimento, id_endereco, id_contato) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String LIST = "select * from cliente, endereco, contato where cliente.id_endereco = endereco.id and cliente.id_contato = contato.id;";
    private static final String REMOVE = "delete from cliente where id = ?;";
    private static final String UPDATE = "update cliente set nome = ?, sobrenome = ?, cpf = ?, rg = ?, sexo = ?, dataContrato = ?, dataNascimento = ? where id = ?;";
    private static final String LISTBYID = "select * from cliente where id = ?;";
    private static final String LISTBYNOME = "select * from cliente where nome like ?;";
   
    @Override
    public int salve(ClientePF clientePF) {
        if (clientePF.getId() == 0) {
            return insert(clientePF);
        } else {
            return update(clientePF);
        }
    }

    private int insert(ClientePF clientePF) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, clientePF.getNome());
            pstm.setString(2, clientePF.getSobreNome());
            pstm.setString(3, clientePF.getCpf());
            pstm.setString(4, clientePF.getRg());
            pstm.setString(5, clientePF.getSexo());
            pstm.setDate(6, new java.sql.Date(clientePF.getDataContrato().getTime()));
            pstm.setDate(7, new java.sql.Date(clientePF.getDataNascimento().getTime()));
            pstm.setInt(8, clientePF.getEnd().getId());
            pstm.setInt(9, clientePF.getContato().getId());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados do cliente Pessoa Física  " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + ex.getMessage());
            }
            return retorno;
        }
    }

    private int update(ClientePF clientePF) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, clientePF.getNome());
            pstm.setString(2, clientePF.getSobreNome());
            pstm.setString(3, clientePF.getCpf());
            pstm.setString(4, clientePF.getRg());
            pstm.setString(5, clientePF.getSexo());
            pstm.setDate(6, new java.sql.Date(clientePF.getDataContrato().getTime()));
            pstm.setDate(7, new java.sql.Date(clientePF.getDataNascimento().getTime()));
            pstm.setInt(8, clientePF.getId());
            pstm.execute();
            retorno = clientePF.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar os dados do Cliente Pessoa Física " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + ex.getMessage());
            }

        }
        return retorno;

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
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente Pessoa Física " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + ex.getMessage());
            }
        }
        return status;
    }

    @Override
    public List<ClientePF> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ClientePF> clientePFs = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if(rs.getString("nome") != null){
                ClientePF clientePF = new ClientePF();
                clientePF.setId(rs.getInt("id"));
                clientePF.setNome(rs.getString("nome"));
                clientePF.setSobreNome(rs.getString("sobrenome"));
                clientePF.setCpf(rs.getString("cpf"));
                clientePF.setRg(rs.getString("rg"));
                clientePF.setSexo(rs.getString("sexo"));
                clientePF.setDataContrato(rs.getDate("dataContrato"));
                clientePF.setDataNascimento(rs.getDate("dataNascimento"));
                clientePF.setIdEndereco(rs.getInt("id_endereco"));
                clientePF.setIdContato(rs.getInt("id_contato"));

                clientePFs.add(clientePF);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cliente Pessoa Física " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + ex.getMessage());
            }
        }
        return clientePFs;

    }

    @Override
    public ClientePF listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ClientePF clientePF = new ClientePF();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                clientePF.setId(rs.getInt("id"));
                clientePF.setNome(rs.getString("nome"));
                clientePF.setSobreNome(rs.getString("sobrenome"));
                clientePF.setCpf(rs.getString("cpf"));
                clientePF.setRg(rs.getString("rg"));
                clientePF.setSexo(rs.getString("sexo"));
                clientePF.setDataContrato(rs.getDate("dataContrato"));
                clientePF.setDataNascimento(rs.getDate("dataNascimento"));
                clientePF.setIdEndereco(rs.getInt("id_endereco"));
                clientePF.setIdContato(rs.getInt("id_contato"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cliente Pessoa Física " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + ex.getMessage());
            }
        }
        return clientePF;
    }

    @Override
    public List<ClientePF> listByNome(String nome) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ClientePF> clientePFs = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                ClientePF clientePF = new ClientePF();
                clientePF.setId(rs.getInt("id"));
                clientePF.setNome(rs.getString("nome"));
                clientePF.setSobreNome(rs.getString("sobrenome"));
                clientePF.setCpf(rs.getString("cpf"));
                clientePF.setRg(rs.getString("rg"));
                clientePF.setSexo(rs.getString("sexo"));
                clientePF.setDataContrato(rs.getDate("dataContrato"));
                clientePF.setDataNascimento(rs.getDate("dataNascimento"));

                clientePFs.add(clientePF);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o cliente Pessoa Física " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + ex.getMessage());
            }
        }
        return clientePFs;
    }
}
