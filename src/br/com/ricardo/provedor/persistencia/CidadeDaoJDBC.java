package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Cidade;
import br.com.ricardo.provedor.persistencia.dao.CidadeDAO;
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
public class CidadeDaoJDBC implements CidadeDAO {

    private static final String INSERT = "insert into cidade (nome, id_estado) values (?, ?);";
    private static final String LIST = "select * from cidade, estados where cidade.id_estado = estados.id ;";
    private static final String REMOVE = "delete from cidade where id = ?;";
    private static final String UPDATE = "update cidade set nome = ?,  id_estado = ? where id = ?;";
    private static final String LISTBYID = "select * from cidade where id = ?;";
    private static final String LISTBYNOME = "select * from cidade where nome like ?;";
    private static final String LISTANOME = "select * from cidade where nome = ?;";

    private int insert(Cidade cidade) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, cidade.getNome());
            pstm.setInt(2, cidade.getUf().getId());

            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir os dados da cidade: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + ex.getMessage());
            }
            return retorno;
        }
    }

    private int update(Cidade cidade) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, cidade.getNome());
            pstm.setInt(2, cidade.getUf().getId());
            pstm.setInt(3, cidade.getId());
            pstm.execute();
            retorno = cidade.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar os dados da Cidade " + e.getMessage());
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
    public int salve(Cidade cidade) {
        if (cidade.getId() == 0) {
            return insert(cidade);
        } else {
            return update(cidade);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir a cidade" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return status;
    }

    @Override
    public List<Cidade> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cidade> cidades = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {

                Cidade cidade = new Cidade();

                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                cidade.setIdUf(rs.getInt("id_estado"));

                cidades.add(cidade);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar a cidade" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return cidades;
    }

    @Override
    public Cidade listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cidade cidade = new Cidade();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                cidade.setIdUf(rs.getInt("id_estado"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar a cidade " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return cidade;
    }

    @Override
    public List<Cidade> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cidade> cidades = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                cidades.add(cidade);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar a cidade" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return cidades;
    }

    @Override
    public Cidade listaNome(String nome) {
         Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cidade cidade = new Cidade();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTANOME);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o estado " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + e.getMessage());
            }
        }
        return cidade;
    
    }
}
