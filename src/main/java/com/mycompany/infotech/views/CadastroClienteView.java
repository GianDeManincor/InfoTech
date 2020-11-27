/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.views;

import com.mycompany.infotech.models.Cliente;
import com.mycompany.infotech.controller.ClienteController;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Icaro
 * @author ateos
 */
public class CadastroClienteView extends javax.swing.JFrame {

    /**
     * Creates new form CadastroCliente
     */
    public CadastroClienteView() {
        initComponents();
        
        Gbtn_sexo.add(rbtn_F);
        Gbtn_sexo.add(rbtn_M);
    }
    
    private int ID;
    private String modotela="ADD";
    
    public CadastroClienteView(Cliente cli){
        initComponents();
        
        modotela="Alterar";
        btn_cadastrar.setText("Alterar");
        lbl_text.setText("você está alterando os dados do cliente "+ID);
        
        ID=cli.getID();
        txt_nome.setText(cli.getNome());
        txt_email.setText(cli.getEmail());
        ftxt_CPF.setText(cli.getCPF());
        txt_cidade.setText(cli.getCidade());
        txt_endereco.setText(cli.getEndereco());
        cmb_estado.setSelectedItem(cli.getEstado());
        //jdata_nacimento.setDate(cli.getDatanaci());
        
        if (cli.getSexo()!=null) {
            if ("F".equals(cli.getSexo())) {
                rbtn_F.setSelected(true);
                rbtn_M.setSelected(false);
            }else{
                rbtn_M.setSelected(true);
                rbtn_F.setSelected(false);
            }
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked");
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Gbtn_sexo = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbtn_M = new javax.swing.JRadioButton();
        rbtn_F = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ftxt_CPF = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jdata_nacimento = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmb_estado = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btn_voltra = new javax.swing.JButton();
        btn_cadastrar = new javax.swing.JButton();
        lbl_text = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de cliente");
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Cliente"));

        jLabel2.setText("Nome e sobrenome");

        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Sexo (opcional)");

        Gbtn_sexo.add(rbtn_M);
        rbtn_M.setText("Masculino");

        Gbtn_sexo.add(rbtn_F);
        rbtn_F.setText("Feminino");
        rbtn_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_FActionPerformed(evt);
            }
        });

        jLabel5.setText("Email");

        jLabel7.setText("CPF");

        try {
            ftxt_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Data de nascimento");

        jdata_nacimento.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jdata_nacimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbtn_M)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbtn_F))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_email)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(ftxt_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbtn_M)
                    .addComponent(rbtn_F))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ftxt_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdata_nacimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do endereço"));

        jLabel8.setText("Cidada");

        jLabel9.setText("Endereço");

        txt_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enderecoActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado");

        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione seu estado", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_endereco))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_voltra.setText("Voltar");
        btn_voltra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltraActionPerformed(evt);
            }
        });

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_text, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btn_voltra, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_voltra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void rbtn_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_FActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_FActionPerformed

    private void txt_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enderecoActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        if ("ADD".equals(modotela)) {
            add();
        }else{
            Alterar();
        }
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void btn_voltraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltraActionPerformed
        ConsultaClienteView tela = new ConsultaClienteView();
        tela.setVisible(true);
        
        CadastroClienteView.this.dispose();
    }//GEN-LAST:event_btn_voltraActionPerformed

    public void ToClean(){
        txt_cidade.setText("");
        txt_email.setText("");
        txt_endereco.setText("");
        txt_nome.setText("");
        ftxt_CPF.setText("");
        jdata_nacimento.setDate(null);
        rbtn_F.setSelected(false);
        rbtn_M.setSelected(false);
    }
    
    public void Alterar(){
        String[] text = valida();
        Date data = jdata_nacimento.getDate();
        if (text!=null && data!=null) {
            if (ClienteController.Alterar(data, getSexo(), ID, text)) {
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                ToClean();
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao atualizar");
            }
        }
    }
    
    public void add(){
        String[] text = valida();
        Date data = jdata_nacimento.getDate();
        if (text!=null && data!=null) {
            if (ClienteController.salvar(data, getSexo(), text)) {
                JOptionPane.showMessageDialog(null, "Novo cliente cadastrado");
                ToClean();
            }else{
                JOptionPane.showMessageDialog(null, "Erro cadastrar");
            }
        }
    }
    
    public String[] valida(){
        String[] txt = new String[6];
        
        txt[0] = txt_nome.getText();
        txt[1] = txt_email.getText();
        txt[2] = ftxt_CPF.getText().replace(".", "").replace("/", "");;;
        txt[3] = txt_cidade.getText();
        txt[4] = cmb_estado.getSelectedItem().toString();
        txt[5] = txt_endereco.getText();
        
        for (int i = 0; i < txt.length; i++) {
            if (!fromato(txt[i], i)) {
                return txt=null;
            }
        }
        
        return txt;
    }
    
    public boolean fromato(String txt, int i){
        String[] linha = {"Nome e sobrenome","Email","CPF","Cidade","Estado","Endereço"};
        
        if (txt.trim().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo "+linha[i]);
            return false;
            
        }else{
            switch(i){
                case 0:
                case 1:
                    if (50 >= txt.length()) {
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "'"+linha[i]+"' excedeu o tamanho do campo");
                        return false;
                    }
                case 2:
                    if (14 >= txt.length()) {
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "'"+linha[i]+"' excedeu o tamanho do campo");
                        return false;
                    }
                case 3:
                    if (35 >= txt.length()) {
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "'"+linha[i]+"' excedeu o tamanho do campo");
                        return false;
                    }
                case 4:
                    if (2 >= txt.length()) {
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "selecione um "+linha[i]);
                        return false;
                    }
                case 5:
                    if (40 >= txt.length()) {
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "'"+linha[i]+"' excedeu o tamanho do campo");
                        return false;
                    }
            }
            return false;
        }
    }
    
    public String getSexo(){
        if (rbtn_F.getSelectedObjects()!=null || rbtn_M.getSelectedObjects()!=null) {
            if (rbtn_F.getSelectedObjects()!=null){
                return "F";
            }else{
                return "M";
            }
        }else{
            return "~";
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Gbtn_sexo;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_voltra;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JFormattedTextField ftxt_CPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jdata_nacimento;
    private javax.swing.JLabel lbl_text;
    private javax.swing.JRadioButton rbtn_F;
    private javax.swing.JRadioButton rbtn_M;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
}
