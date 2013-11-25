

package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.ClienteLogin;
import br.com.ricardo.provedor.persistencia.dao.ClienteLoginDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public class ClienteLoginDaoJDBC implements ClienteLoginDAO{
    
    private static final String INSERT = "insert into clienteLogin (login, senha, ip, mac, tipoConexao) values (?, ?, ?, ?, ?);";

    private int inserir(ClienteLogin clienteLogin) {
        int status = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, clienteLogin.getLogin());
            pstm.setString(2, clienteLogin.getSenha());
            pstm.setString(3, clienteLogin.getIp());
            pstm.setString(4, clienteLogin.getMac());
            pstm.setString(5, clienteLogin.getTipoConexao());
            pstm.execute();

            
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                rs.next();
                status = rs.getInt(1);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Login do cliente" + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar Conexao" + ex);
            }
            return status;
        }


    }

    @Override
    public int salvar(ClienteLogin login) {
        if (login.getId() == 0) {
            return inserir(login);
        }
        return -1;
    }
}

    


