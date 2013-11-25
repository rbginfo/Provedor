package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Funcionario;
import br.com.ricardo.provedor.persistencia.dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDaoJDBC implements FuncionarioDAO {

    private static final String INSERT = "insert into funcionario (nome, sobrenome, cpf, rg, sexo, ctps, admissao, login, senha, id_endereco, id_contato, id_cargo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String LIST = "select * from funcionario, endereco, contato, cargo where funcionario.id_endereco = endereco.id and funcionario.id_contato = contato.id and funcionario.id_cargo = cargo.id;";
    private static final String REMOVE = "delete from funcionario where id = ?;";
    private static final String UPDATE = "update funcionario set nome = ?, sobrenome = ?, cpf = ?, rg = ?, sexo = ?,  ctps = ?, admissao = ?, login = ?, senha = ?, id_cargo = ? where id = ?;";
    private static final String LISTBYID = "select * from funcionario where id = ?;";
    private static final String LISTBYNOME = "select * from funcionario where nome like ?;";
    private static final String VERIFICARLOGIN = "select login, senha from funcionario where login = ? and senha = ? ";

    @Override
    public int salve(Funcionario funcionario) {
        if (funcionario.getId() == 0) {
            return insert(funcionario);
        } else {
            return update(funcionario);
        }
    }

    private int insert(Funcionario funcionario) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getSobreNome());
            pstm.setString(3, funcionario.getCpf());
            pstm.setString(4, funcionario.getRg());
            pstm.setString(5, funcionario.getSexo());
            pstm.setString(6, funcionario.getCtps());
            pstm.setDate(7, new java.sql.Date(funcionario.getAdmissao().getTime()));
            pstm.setString(8, funcionario.getLogin());
            pstm.setString(9, funcionario.getSenha());
            pstm.setInt(10, funcionario.getEnd().getId());
            pstm.setInt(11, funcionario.getContato().getId());
            pstm.setInt(12, funcionario.getCargo().getId());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir os dados do funcionario: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + ex.getMessage());
            }
            return retorno;
        }
    }

    private int update(Funcionario f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getSobreNome());
            pstm.setString(3, f.getCpf());
            pstm.setString(4, f.getRg());
            pstm.setString(5, f.getSexo());
            pstm.setString(6, f.getCtps());
            pstm.setDate(7, new java.sql.Date(f.getAdmissao().getTime()));
            pstm.setString(8, f.getLogin());
            pstm.setString(9, f.getSenha());
            pstm.setInt(10, f.getCargo().getId());
            pstm.setInt(11, f.getId());
            pstm.execute();
            retorno = f.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar os dados do Funcionario " + e.getMessage());
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir o funcionario" + e.getMessage());
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
    public List<Funcionario> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {

                Funcionario f = new Funcionario();

                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setSobreNome(rs.getString("sobrenome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setSexo(rs.getString("sexo"));
                f.setCtps(rs.getString("ctps"));
                f.setAdmissao(rs.getDate("admissao"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setIdEndereco(rs.getInt("id_endereco"));
                f.setIdContato(rs.getInt("id_contato"));
                f.setIdCargo(rs.getInt("id_cargo"));

                funcionarios.add(f);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o funcionario" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return funcionarios;

    }

    @Override
    public Funcionario listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Funcionario f = new Funcionario();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setSobreNome(rs.getString("sobrenome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setSexo(rs.getString("sexo"));
                f.setCtps(rs.getString("ctps"));
                f.setAdmissao(rs.getDate("admissao"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setIdEndereco(rs.getInt("id_endereco"));
                f.setIdContato(rs.getInt("id_contato"));
                f.setIdCargo(rs.getInt("id_cargo"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o funcionario " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return f;
    }

    @Override
    public List<Funcionario> listByNome(String nome) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setSobreNome(rs.getString("sobrenome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setSexo(rs.getString("sexo"));
                f.setCtps(rs.getString("ctps"));
                f.setAdmissao(rs.getDate("admissao"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o funcionario" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public boolean validaLogin(String login, String senha) {
        boolean autenticado = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        Funcionario f = new Funcionario();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(VERIFICARLOGIN);
            pstm.setString(1, login);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }

            ConnectionFactory.closeConnection(con, pstm, rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao validar login e senha: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return autenticado;
    }
}
