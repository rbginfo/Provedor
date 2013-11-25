package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Contato;
import br.com.ricardo.provedor.persistencia.dao.ContatoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo
 */
public class ContatoDaoJDBC implements ContatoDAO {

    private static final String INSERT = "insert into contato (email, site, telefone1, telefone2, celular) values (?, ?, ?, ?, ?);";
    private static final String LIST = "select * from contato;";
    private static final String REMOVE = "delete from contato where id = ?;";
    private static final String UPDATE = "update contato set email = ?, site = ?, telefone1 = ?, telefone2 = ?, celular = ? where id = ?;";
    private static final String LISTBYID = "select * from contato where id = ?;";
        
    
    private int inserir(Contato c) {
        int status = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, c.getEmail());
            pstm.setString(2, c.getSite());
            pstm.setString(3, c.getTelefone1());
            pstm.setString(4, c.getTelefone2());
            pstm.setString(5, c.getCelular());
            pstm.execute();

            
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                rs.next();
                status = rs.getInt(1);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Contato" + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar Conexao" + ex);
            }
            return status;
        }


    }
    
    private int update(Contato contato) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, contato.getEmail());
            pstm.setString(2, contato.getSite());
            pstm.setString(3, contato.getTelefone1());
            pstm.setString(4, contato.getTelefone2());
            pstm.setString(5, contato.getCelular());
            pstm.setInt(6, contato.getId());
            pstm.execute();
            retorno = contato.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar o contato " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }

        }
        return retorno;

    }

    @Override
    public int salvar(Contato contato) {
        if (contato.getId() == 0) {
            return inserir(contato);
        }else {
            return update(contato);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir o endereço" + e.getMessage());
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
    public List<Contato> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Contato> contatos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setEmail(rs.getString("email"));
                contato.setSite(rs.getString("site"));
                contato.setTelefone1(rs.getString("telefone1"));
                contato.setTelefone2(rs.getString("telefone2"));
                contato.setCelular(rs.getString("celular"));
                                                
                contatos.add(contato);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o contato" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return contatos;
    }

    @Override
    public Contato listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Contato contato = new Contato();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setEmail(rs.getString("email"));
                contato.setSite(rs.getString("site"));
                contato.setTelefone1(rs.getString("telefone1"));
                contato.setTelefone2(rs.getString("telefone2"));
                contato.setCelular(rs.getString("celular"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o contato " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return contato;
    }
    
}
