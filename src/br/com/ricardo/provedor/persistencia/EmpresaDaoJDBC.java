

package br.com.ricardo.provedor.persistencia;

import br.com.ricardo.provedor.model.Empresa;
import br.com.ricardo.provedor.persistencia.dao.EmpresaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *www.tecnokernel.com.br
 * @author Ricardo Benedet Garcia
 * rbg_info@hotmail.com
 */
public class EmpresaDaoJDBC implements EmpresaDAO{
    
    private static final String INSERT = "insert into Empresa (rasaoSocial, nomeFantasia, cnpj, ie, im, codAnatel, id_endereco, id_contato) values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "update Empresa set nomeFantasia = ?, rasaoSocial = ?, cnpj = ?, ie = ?, im = ?, codAnatel = ? where id = ?;";
    private static final String LISTBYID = "select * from Empresa where id = ?;";
    
    
    private int insert(Empresa empresa) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, empresa.getNomeFantasia());
            pstm.setString(2, empresa.getRasaoSocial());
            pstm.setString(3, empresa.getCnpj());
            pstm.setString(4, empresa.getIe());
            pstm.setString(5, empresa.getiMunicipal());
            pstm.setString(6, empresa.getCodAnatel());
            pstm.setInt(7, empresa.getEnd().getId());
            pstm.setInt(8, empresa.getContato().getId());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir os dados da Empresa " + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
            }
            return retorno;
        }
    }

    private int update(Empresa empresa) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, empresa.getNomeFantasia());
            pstm.setString(2, empresa.getRasaoSocial());
            pstm.setString(3, empresa.getCnpj());
            pstm.setString(4, empresa.getIe());
            pstm.setString(5, empresa.getiMunicipal());
            pstm.setString(6, empresa.getCodAnatel());
            pstm.setInt(7, empresa.getId());
            
            pstm.execute();
            retorno = empresa.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar os dados da Empresa " + e.getMessage());
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
    public int salve(Empresa empresa) {
        if (empresa.getId() == 0) {
            return insert(empresa);
        } else {
            return update(empresa);
        }
    }

    
    @Override
    public Empresa listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Empresa empresa = new Empresa();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                empresa.setId(rs.getInt("id"));
                empresa.setNomeFantasia(rs.getString("nomeFantasia"));
                empresa.setRasaoSocial(rs.getString("rasaoSocial"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setIe(rs.getString("ie"));
                empresa.setiMunicipal(rs.getString("im"));
                empresa.setCodAnatel(rs.getString("codAnatel"));
                empresa.setIdEndereco(rs.getInt("id_endereco"));
                empresa.setIdContato(rs.getInt("id_contato"));
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar a empresa " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return empresa;
    }

   
    
}



