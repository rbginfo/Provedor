/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ricardo.provedor.view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guest01
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    
     private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jmInserirFuncionario = new javax.swing.JMenuItem();
        jmInserirCargo = new javax.swing.JMenuItem();
        jmInserirPlano = new javax.swing.JMenuItem();
        jmEmpresa = new javax.swing.JMenuItem();
        jmInserirFornecedor = new javax.swing.JMenuItem();
        jmInserirProduto = new javax.swing.JMenuItem();
        jmInserirClientePF = new javax.swing.JMenuItem();
        jmInserirClientePJ = new javax.swing.JMenuItem();
        jmInserirCidade = new javax.swing.JMenuItem();
        jmPesquisar = new javax.swing.JMenu();
        jmEditarFuncionario = new javax.swing.JMenuItem();
        jmEditarCargo = new javax.swing.JMenuItem();
        jmEditarPlano = new javax.swing.JMenuItem();
        jmEditarFornecedor = new javax.swing.JMenuItem();
        jmEditarProduto = new javax.swing.JMenuItem();
        jmEditarClientePF = new javax.swing.JMenuItem();
        jmEditarPJ = new javax.swing.JMenuItem();
        jmEditarCidade = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        jToolBar2.setRollover(true);

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Inserir");

        jmInserirFuncionario.setText("Inserir Funcionario");
        jmInserirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInserirFuncionarioActionPerformed(evt);
            }
        });
        jMenu2.add(jmInserirFuncionario);

        jmInserirCargo.setText("Inserir Cargo");
        jmInserirCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInserirCargoActionPerformed(evt);
            }
        });
        jMenu2.add(jmInserirCargo);

        jmInserirPlano.setText("Inserir Plano de Acesso");
        jmInserirPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInserirPlanoActionPerformed(evt);
            }
        });
        jMenu2.add(jmInserirPlano);

        jmEmpresa.setText("Inserir Dados da Empresa");
        jmEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEmpresaActionPerformed(evt);
            }
        });
        jMenu2.add(jmEmpresa);

        jmInserirFornecedor.setText("Inserir Fornecedor");
        jmInserirFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInserirFornecedorActionPerformed(evt);
            }
        });
        jMenu2.add(jmInserirFornecedor);

        jmInserirProduto.setText("Inserir Produto");
        jmInserirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInserirProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(jmInserirProduto);

        jmInserirClientePF.setText("Inserir Cliente Pessoa Física");
        jmInserirClientePF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInserirClientePFActionPerformed(evt);
            }
        });
        jMenu2.add(jmInserirClientePF);

        jmInserirClientePJ.setText("Inserir Cliente Pessoa Jurídica");
        jmInserirClientePJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInserirClientePJActionPerformed(evt);
            }
        });
        jMenu2.add(jmInserirClientePJ);

        jmInserirCidade.setText("Inserir Cidade");
        jmInserirCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInserirCidadeActionPerformed(evt);
            }
        });
        jMenu2.add(jmInserirCidade);

        jMenuBar1.add(jMenu2);

        jmPesquisar.setText("Editar");

        jmEditarFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmEditarFuncionario.setText("Editar Funcionario");
        jmEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarFuncionarioActionPerformed(evt);
            }
        });
        jmPesquisar.add(jmEditarFuncionario);

        jmEditarCargo.setText("Editar Cargo");
        jmEditarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarCargoActionPerformed(evt);
            }
        });
        jmPesquisar.add(jmEditarCargo);

        jmEditarPlano.setText("Editar Plano");
        jmEditarPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarPlanoActionPerformed(evt);
            }
        });
        jmPesquisar.add(jmEditarPlano);

        jmEditarFornecedor.setText("Editar Fornecedor");
        jmEditarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarFornecedorActionPerformed(evt);
            }
        });
        jmPesquisar.add(jmEditarFornecedor);

        jmEditarProduto.setText("Editar Produto");
        jmEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarProdutoActionPerformed(evt);
            }
        });
        jmPesquisar.add(jmEditarProduto);

        jmEditarClientePF.setText("Editar Cliente Pessoa Física");
        jmEditarClientePF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarClientePFActionPerformed(evt);
            }
        });
        jmPesquisar.add(jmEditarClientePF);

        jmEditarPJ.setText("Editar Cliente Pessoa Jurídica");
        jmEditarPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarPJActionPerformed(evt);
            }
        });
        jmPesquisar.add(jmEditarPJ);

        jmEditarCidade.setText("Editar Cidade");
        jmEditarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarCidadeActionPerformed(evt);
            }
        });
        jmPesquisar.add(jmEditarCidade);

        jMenuBar1.add(jmPesquisar);

        jMenu3.setText("Ajuda");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarFuncionarioActionPerformed
        FuncionarioListaGui fl = new FuncionarioListaGui();
        fl.setLocationRelativeTo(null);
        fl.setVisible(true);
    }//GEN-LAST:event_jmEditarFuncionarioActionPerformed

    private void jmInserirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInserirFuncionarioActionPerformed
        FuncionarioInserirGUI fi = new FuncionarioInserirGUI(modelo);
        fi.setLocationRelativeTo(null);
        fi.setVisible(true);
    }//GEN-LAST:event_jmInserirFuncionarioActionPerformed

    private void jmEditarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarCargoActionPerformed
        CargoListaGui cargoL = new CargoListaGui();
        cargoL.setLocationRelativeTo(null);
        cargoL.setVisible(true);
    }//GEN-LAST:event_jmEditarCargoActionPerformed

    private void jmInserirCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInserirCargoActionPerformed
        CargoInserirGUI cargoI = new CargoInserirGUI(modelo);
        cargoI.setLocationRelativeTo(null);
        cargoI.setVisible(true);
    }//GEN-LAST:event_jmInserirCargoActionPerformed

    private void jmInserirPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInserirPlanoActionPerformed
        PlanoAcessoInserirGUI planoI = new PlanoAcessoInserirGUI(modelo);
        planoI.setLocationRelativeTo(null);
        planoI.setVisible(true);
    }//GEN-LAST:event_jmInserirPlanoActionPerformed

    private void jmEditarPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarPlanoActionPerformed
        PlanoAcessoListaGui planoL = new PlanoAcessoListaGui();
        planoL.setLocationRelativeTo(null);
        planoL.setVisible(true);
    }//GEN-LAST:event_jmEditarPlanoActionPerformed

    private void jmEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEmpresaActionPerformed
        EmpresaInserirGUI empresaI = new EmpresaInserirGUI();
        empresaI.setLocationRelativeTo(null);
        empresaI.setVisible(true);
    }//GEN-LAST:event_jmEmpresaActionPerformed

    private void jmInserirFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInserirFornecedorActionPerformed
        FornecedorInserirGUI fornecedorI = new FornecedorInserirGUI(modelo);
        fornecedorI.setLocationRelativeTo(null);
        fornecedorI.setVisible(true);
    }//GEN-LAST:event_jmInserirFornecedorActionPerformed

    private void jmEditarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarFornecedorActionPerformed
        FornecedorListaGui fornecedorL = new FornecedorListaGui();
        fornecedorL.setLocationRelativeTo(null);
        fornecedorL.setVisible(true);
    }//GEN-LAST:event_jmEditarFornecedorActionPerformed

    private void jmInserirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInserirProdutoActionPerformed
        ProdutoInserirGUI produtoVi = new ProdutoInserirGUI(modelo);
        produtoVi.setLocationRelativeTo(null);
        produtoVi.setVisible(true);
    }//GEN-LAST:event_jmInserirProdutoActionPerformed

    private void jmEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarProdutoActionPerformed
        ProdutoListaGui produtoL = new ProdutoListaGui();
        produtoL.setLocationRelativeTo(null);
        produtoL.setVisible(true);
    }//GEN-LAST:event_jmEditarProdutoActionPerformed

    private void jmInserirClientePFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInserirClientePFActionPerformed
        ClientePFInserirGUI clientePFVi = new ClientePFInserirGUI(modelo);
        clientePFVi.setLocationRelativeTo(null);
        clientePFVi.setVisible(true);
    }//GEN-LAST:event_jmInserirClientePFActionPerformed

    private void jmEditarClientePFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarClientePFActionPerformed
        ClientePFListaGui clientePFL = new ClientePFListaGui();
        clientePFL.setLocationRelativeTo(null);
        clientePFL.setVisible(true);
    }//GEN-LAST:event_jmEditarClientePFActionPerformed

    private void jmInserirClientePJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInserirClientePJActionPerformed
       ClientePJInserirGUI clientePJI = new ClientePJInserirGUI(modelo);
        clientePJI.setLocationRelativeTo(null);
        clientePJI.setVisible(true);
    }//GEN-LAST:event_jmInserirClientePJActionPerformed

    private void jmEditarPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarPJActionPerformed
        ClientePJListaGui clientePJL = new ClientePJListaGui();
        clientePJL.setLocationRelativeTo(null);
        clientePJL.setVisible(true);
    }//GEN-LAST:event_jmEditarPJActionPerformed

    private void jmInserirCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInserirCidadeActionPerformed
        CidadeInserirGui cidadeInserirGui = new CidadeInserirGui(modelo);
        cidadeInserirGui.setLocationRelativeTo(null);
        cidadeInserirGui.setVisible(true);
    }//GEN-LAST:event_jmInserirCidadeActionPerformed

    private void jmEditarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarCidadeActionPerformed
        CidadeListaGui cidadeListaGui = new CidadeListaGui();
        cidadeListaGui.setLocationRelativeTo(null);
        cidadeListaGui.setVisible(true);
    }//GEN-LAST:event_jmEditarCidadeActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem jmEditarCargo;
    private javax.swing.JMenuItem jmEditarCidade;
    private javax.swing.JMenuItem jmEditarClientePF;
    private javax.swing.JMenuItem jmEditarFornecedor;
    private javax.swing.JMenuItem jmEditarFuncionario;
    private javax.swing.JMenuItem jmEditarPJ;
    private javax.swing.JMenuItem jmEditarPlano;
    private javax.swing.JMenuItem jmEditarProduto;
    private javax.swing.JMenuItem jmEmpresa;
    private javax.swing.JMenuItem jmInserirCargo;
    private javax.swing.JMenuItem jmInserirCidade;
    private javax.swing.JMenuItem jmInserirClientePF;
    private javax.swing.JMenuItem jmInserirClientePJ;
    private javax.swing.JMenuItem jmInserirFornecedor;
    private javax.swing.JMenuItem jmInserirFuncionario;
    private javax.swing.JMenuItem jmInserirPlano;
    private javax.swing.JMenuItem jmInserirProduto;
    private javax.swing.JMenu jmPesquisar;
    // End of variables declaration//GEN-END:variables
}
