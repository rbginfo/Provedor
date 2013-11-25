package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Endereco;
import br.com.ricardo.provedor.persistencia.dao.EnderecoDAO;
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
public class EnderecoDaoJDBC implements EnderecoDAO{

    private static final String INSERT = "insert into endereco ( bairro, rua, numero, complemento, cep) values (?, ?, ?, ?, ?);";
    private static final String LIST = "select * from endereco;";
    private static final String REMOVE = "delete from endereco where id = ?;";
    private static final String UPDATE = "update endereco set bairro = ?, rua = ?, numero = ?, complemento = ?, cep = ? where id = ?;";
    private static final String LISTBYID = "select * from endereco where id = ?;";
    
   @Override
    public int salvar(Endereco endereco) {
        
        if(endereco.getId() == 0){
            return inserir(endereco);
        }else {
            return update(endereco);
        }
        
    } 
    
    
    
    private int inserir(Endereco e){
        int status = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, e.getBairro());
            pstm.setString(2, e.getRua());
            pstm.setString(3, e.getNumero());
            pstm.setString(4, e.getComplemento());
            pstm.setString(5, e.getCep());
            //pstm.setInt(6, e.getCidade().getId());
            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()){
                rs.next();
                status = rs.getInt(1);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Endereço" + ex.getMessage());
        }finally{
            try{
                ConnectionFactory.closeConnection(con, pstm);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Erro ao fechar Conexao" + ex);
            }
        }
        return status;
    }
    
    private int update(Endereco endereco) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, endereco.getBairro());
            pstm.setString(2, endereco.getRua());
            pstm.setString(3, endereco.getNumero());
            pstm.setString(4, endereco.getComplemento());
            pstm.setString(5, endereco.getCep());
            //pstm.setInt(6, endereco.getCidade().getId());
            pstm.setInt(6, endereco.getId());
            pstm.execute();
            retorno = endereco.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar o endereco " + e.getMessage());
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
    public List<Endereco> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Endereco> enderecos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCep(rs.getString("cep"));
                endereco.setIdCidade(rs.getInt("id_cidade"));
                                
                enderecos.add(endereco);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o endereco" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return enderecos;
    }

    @Override
    public Endereco listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Endereco endereco = new Endereco();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                endereco.setId(rs.getInt("id"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCep(rs.getString("cep"));
                endereco.setIdCidade(rs.getInt("id_cidade"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o endereco " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
            }
        }
        return endereco;
    }
}
