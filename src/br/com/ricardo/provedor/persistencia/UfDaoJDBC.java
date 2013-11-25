package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Uf;
import br.com.ricardo.provedor.persistencia.dao.UfDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo Benedet Garcia
 */
public class UfDaoJDBC implements UfDAO {

    private static final String LIST = "select * from estados";
    private static final String LISTANOME = "select * from estados where nome = ?;";
    private static final String LISTBYID = "select * from estados where id = ?;";

    @Override
    public List<Uf> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Uf> ufs = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {

                Uf uf = new Uf();
                uf.setId(rs.getInt("id"));
                uf.setNome(rs.getString("nome"));
                uf.setSigla(rs.getString("sigla"));


                ufs.add(uf);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o Estado " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + e.getMessage());
            }
        }
        return ufs;
    }

    @Override
    public Uf listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Uf uf = new Uf();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                uf.setId(rs.getInt("id"));
                uf.setNome(rs.getString("nome"));
                uf.setSigla(rs.getString("sigla"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o Estado " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + e.getMessage());
            }
        }
        return uf;
    }

    @Override
    public Uf listaNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Uf uf = new Uf();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTANOME);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            while (rs.next()) {
                uf.setId(rs.getInt("id"));
                uf.setNome(rs.getString("nome"));
                uf.setSigla(rs.getString("sigla"));

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
        return uf;
    }
}
