package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Cargo;
import br.com.ricardo.provedor.persistencia.dao.CargoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardo
 */
public class CargoDaoJDBC implements CargoDAO{
    
    private static final String INSERT = "insert into cargo (nome, descricao, nivelAcesso) values (?, ?, ?);";
    private static final String LIST = "select * from cargo;";
    private static final String REMOVE = "delete from cargo where id = ?;";
    private static final String UPDATE = "update cargo set nome = ?, descricao = ?, nivelAcesso = ? where id = ?;";
    private static final String LISTBYID = "select * from cargo where id = ?;";
    private static final String LISTANOME = "select * from cargo where nome = ?;";
    private static final String LISTBYNOME = "select * from cargo where nome like ?;";
    
     private int insert(Cargo cargo) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, cargo.getNome());
            pstm.setString(2, cargo.getDescricao());
            pstm.setString(3, cargo.getNivelAcesso());
            
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir o cargo " + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
            }
            return retorno;
        }
    }

    private int update(Cargo cargo) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, cargo.getNome());
            pstm.setString(2, cargo.getDescricao());
            pstm.setString(3, cargo.getNivelAcesso());
            pstm.setInt(4, cargo.getId());
            pstm.execute();
            retorno = cargo.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar o cargo " + e.getMessage());
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
    public int salve(Cargo cargo) {
         if (cargo.getId() == 0) {
            return insert(cargo);
        } else {
            return update(cargo);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cargo" + e.getMessage());
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
    public List<Cargo> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cargo> cargos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt("id"));
                cargo.setNome(rs.getString("nome"));
                cargo.setDescricao(rs.getString("descricao"));
                cargo.setNivelAcesso(rs.getString("nivelAcesso"));
                                
                cargos.add(cargo);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cargo" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return cargos;
    }

    @Override
    public Cargo listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cargo cargo = new Cargo();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cargo.setId(rs.getInt("id"));
                cargo.setNome(rs.getString("nome"));
                cargo.setDescricao(rs.getString("descricao"));
                cargo.setNivelAcesso(rs.getString("nivelAcesso"));
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cargo " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return cargo;
    }

    @Override
    public List<Cargo> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cargo> cargos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt("id"));
                cargo.setNome(rs.getString("nome"));
                cargo.setDescricao(rs.getString("descricao"));
                cargo.setNivelAcesso(rs.getString("nivelAcesso"));
                cargos.add(cargo);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o cargo" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return cargos;
    }

    @Override
    public Cargo listaNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cargo cargo = new Cargo();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTANOME);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cargo.setId(rs.getInt("id"));
                cargo.setNome(rs.getString("nome"));
                cargo.setDescricao(rs.getString("descricao"));
                cargo.setNivelAcesso(rs.getString("nivelAcesso"));
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cargo " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return cargo;
    }

    
    
}
