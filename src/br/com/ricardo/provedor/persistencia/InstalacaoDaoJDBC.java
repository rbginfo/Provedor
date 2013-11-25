package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Instalacao;
import br.com.ricardo.provedor.persistencia.dao.InstalacaoDAO;
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
 * @author Ricardo Benedet Garcia
 */
public class InstalacaoDaoJDBC implements InstalacaoDAO{
    
    private static final String INSERT = "insert into instalacao (id_cliente, id_plano, id_cliente_login, status) values (?, ?, ?, ?);";
    private static final String LIST = "select * from instalacao, cliente, planoAcesso where instalacao.id_cliente = cliente.id and instalacao.id_plano = plano.id and instalacao.id_cliente_login = clienteLogin.id;";
    private static final String REMOVE = "delete from instalacao where id = ?;";
    private static final String UPDATE = "update instalacao set id_cliente = ?, id_plano = ?, id_cliente_login = ?, status = ? where id = ?;";
    private static final String LISTBYID = "select * from instalacao where id = ?;";
    private static final String LISTBYNOME = "select * from instalacao where nome like ?;";
    
     private int insert(Instalacao instalacao) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, instalacao.getIdCliente());
            pstm.setInt(2, instalacao.getIdPlano());
            pstm.setInt(3, instalacao.getIdClienteLogin());
            pstm.setString(4, instalacao.getStatus());
            
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir o instalação " + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
            }
            return retorno;
        }
    }

    private int update(Instalacao instalacao) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setInt(1, instalacao.getIdCliente());
            pstm.setInt(2, instalacao.getIdPlano());
            pstm.setInt(3, instalacao.getIdClienteLogin());
            pstm.setString(4, instalacao.getStatus());
            pstm.setInt(4, instalacao.getId());
            pstm.execute();
            retorno = instalacao.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar o instalação " + e.getMessage());
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
    public int salve(Instalacao instalacao) {
        if (instalacao.getId() == 0) {
            return insert(instalacao);
        } else {
            return update(instalacao);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir a instalação" + e.getMessage());
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
    public List<Instalacao> listAll() {
         Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Instalacao> instalacoes = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {

                Instalacao instalacao = new Instalacao();

                instalacao.setId(rs.getInt("id"));
                instalacao.setIdCliente(rs.getInt("id_cliente"));
                instalacao.setIdPlano(rs.getInt("id_plano"));
                instalacao.setIdClienteLogin(rs.getInt("id_cliente_login"));
                instalacao.setStatus(rs.getString("status"));
                
                instalacoes.add(instalacao);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o Instalação" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return instalacoes;
    }

    @Override
    public Instalacao listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Instalacao instalacao = new Instalacao();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                instalacao.setId(rs.getInt("id"));
                instalacao.setIdCliente(rs.getInt("id_cliente"));
                instalacao.setIdPlano(rs.getInt("id_plano"));
                instalacao.setIdClienteLogin(rs.getInt("id_cliente_login"));
                instalacao.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o Instalação " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return instalacao;
    }

    @Override
    public List<Instalacao> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Instalacao> instalacoes = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Instalacao instalacao = new Instalacao();
                instalacao.setId(rs.getInt("id"));
                instalacao.setIdCliente(rs.getInt("id_cliente"));
                instalacao.setIdPlano(rs.getInt("id_plano"));
                instalacao.setIdClienteLogin(rs.getInt("id_cliente_login"));
                instalacao.setStatus(rs.getString("status"));
                
                instalacoes.add(instalacao);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o Instalacao" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return instalacoes;
    }

    
}
