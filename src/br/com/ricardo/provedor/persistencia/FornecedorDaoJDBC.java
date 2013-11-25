package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Fornecedor;
import br.com.ricardo.provedor.persistencia.dao.FornecedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * www.tecnokernel.com.br
 *
 * @author Ricardo Benedet Garcia rbg_info@hotmail.com
 */
public class FornecedorDaoJDBC implements FornecedorDAO {

    private static final String INSERT = "insert into fornecedor(rasaoSocial, nomeFantasia, cnpj, ie, im, nomeContato, id_endereco, id_contato) values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String LIST = "select * from fornecedor, endereco, contato where fornecedor.id_endereco = endereco.id and fornecedor.id_contato = contato.id;";
    private static final String REMOVE = "delete from fornecedor where id = ?;";
    private static final String UPDATE = "update fornecedor set rasaoSocial = ?, nomeFantasia = ?, cnpj = ?, ie = ?, im = ?, nomeContato = ? where id = ?;";
    private static final String LISTBYID = "select * from fornecedor where id = ?;";
    private static final String LISTBYNOME = "select * from fornecedor where nome like ?;";

    private int insert(Fornecedor fornecedor) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, fornecedor.getNomeFantasia());
            pstm.setString(2, fornecedor.getRasaoSocial());
            pstm.setString(3, fornecedor.getCnpj());
            pstm.setString(4, fornecedor.getIe());
            pstm.setString(5, fornecedor.getiMunicipal());
            pstm.setString(6, fornecedor.getNomeContato());
            pstm.setInt(7, fornecedor.getEnd().getId());
            pstm.setInt(8, fornecedor.getContato().getId());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados do fornecedor " + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
            return retorno;
        }
    }

    private int update(Fornecedor fornecedor) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, fornecedor.getNomeFantasia());
            pstm.setString(2, fornecedor.getRasaoSocial());
            pstm.setString(3, fornecedor.getCnpj());
            pstm.setString(4, fornecedor.getIe());
            pstm.setString(5, fornecedor.getiMunicipal());
            pstm.setString(6, fornecedor.getNomeContato());
            pstm.setInt(7, fornecedor.getId());
            pstm.execute();
            retorno = fornecedor.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar os dados do fornecedor" + e.getMessage());
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
    public int salve(Fornecedor fornecedor) {
        if (fornecedor.getId() == 0) {
            return insert(fornecedor);
        } else {
            return update(fornecedor);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir o fornecedor" + e.getMessage());
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
    public List<Fornecedor> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setRasaoSocial(rs.getString("rasaoSocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIe(rs.getString("ie"));
                fornecedor.setiMunicipal(rs.getString("im"));
                fornecedor.setNomeContato(rs.getString("nomeContato"));
                fornecedor.setIdEndereco(rs.getInt("id_endereco"));
                fornecedor.setIdContato(rs.getInt("id_contato"));

                fornecedores.add(fornecedor);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o fornecedor " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + e.getMessage());
            }
        }
        return fornecedores;
    }

    @Override
    public Fornecedor listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Fornecedor fornecedor = new Fornecedor();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setRasaoSocial(rs.getString("rasaoSocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIe(rs.getString("ie"));
                fornecedor.setiMunicipal(rs.getString("im"));
                fornecedor.setNomeContato(rs.getString("nomeContato"));
                fornecedor.setIdEndereco(rs.getInt("id_endereco"));
                fornecedor.setIdContato(rs.getInt("id_contato"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar a fornecedor " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + e.getMessage());
            }
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setRasaoSocial(rs.getString("rasaoSocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIe(rs.getString("ie"));
                fornecedor.setiMunicipal(rs.getString("im"));
                fornecedor.setNomeContato(rs.getString("nomeContato"));

                fornecedores.add(fornecedor);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar a fornecedor " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + e.getMessage());
            }
        }
        return fornecedores;
    }
}
