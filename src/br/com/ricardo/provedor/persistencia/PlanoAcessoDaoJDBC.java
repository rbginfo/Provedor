

package br.com.ricardo.provedor.persistencia;


import br.com.ricardo.provedor.model.PlanoAcesso;
import br.com.ricardo.provedor.persistencia.dao.PlanoAcessoDAO;
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
public class PlanoAcessoDaoJDBC implements PlanoAcessoDAO{

    private static final String INSERT = "insert into plano (nome, descricao, velocidade, download, upload) values (?, ?, ?, ?, ?);";
    private static final String LIST = "select * from plano;";
    private static final String REMOVE = "delete from plano where id = ?;";
    private static final String UPDATE = "update plano set nome = ?, descricao = ?, velocidade = ?, download = ?, upload = ? where id = ?;";
    private static final String LISTBYID = "select * from plano where id = ?;";
    private static final String LISTBYNOME = "select * from plano where nome like ?;";
    
     private int insert(PlanoAcesso plano) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, plano.getNome());
            pstm.setString(2, plano.getDescricao());
            pstm.setString(3, plano.getVelocidade());
            pstm.setString(4, plano.getDownload());
            pstm.setString(5, plano.getUpload());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir o plano " + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
            }
            return retorno;
        }
    }

    private int update(PlanoAcesso plano) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, plano.getNome());
            pstm.setString(2, plano.getDescricao());
            pstm.setString(3, plano.getVelocidade());
            pstm.setString(4, plano.getDownload());
            pstm.setString(5, plano.getUpload());
            pstm.setInt(6, plano.getId());
            pstm.execute();
            retorno = plano.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar o plano " + e.getMessage());
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
    public int salve(PlanoAcesso plano) {
        if (plano.getId() == 0) {
            return insert(plano);
        } else {
            return update(plano);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir o plano" + e.getMessage());
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
    public List<PlanoAcesso> listAll() {
         Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<PlanoAcesso> planos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                PlanoAcesso plano = new PlanoAcesso();
                plano.setId(rs.getInt("id"));
                plano.setNome(rs.getString("nome"));
                plano.setDescricao(rs.getString("descricao"));
                plano.setVelocidade(rs.getString("velocidade"));
                plano.setDownload(rs.getString("download"));
                plano.setUpload(rs.getString("upload"));
                                
                planos.add(plano);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o plano" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return planos;
    }

    @Override
    public PlanoAcesso listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        PlanoAcesso plano = new PlanoAcesso();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                plano.setId(rs.getInt("id"));
                plano.setNome(rs.getString("nome"));
                plano.setDescricao(rs.getString("descricao"));
                plano.setVelocidade(rs.getString("velocidade"));
                plano.setDownload(rs.getString("download"));
                plano.setUpload(rs.getString("upload"));
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o plano " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return plano;
    }

    @Override
    public List<PlanoAcesso> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<PlanoAcesso> planos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                PlanoAcesso plano = new PlanoAcesso();
                plano.setId(rs.getInt("id"));
                plano.setNome(rs.getString("nome"));
                plano.setDescricao(rs.getString("descricao"));
                plano.setVelocidade(rs.getString("velocidade"));
                plano.setDownload(rs.getString("download"));
                plano.setUpload(rs.getString("upload"));
                planos.add(plano);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o plano" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return planos;
    }

}
