package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class Cliente extends javax.swing.JFrame {

    private static final String HOST  = "localhost";
    private static final int PORTA    = 11223;
    private static final int MSG_SIZE = 100;

    /**
     * Creates new form Cliente
     */
    public Cliente() {
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

        jLabel1 = new javax.swing.JLabel();
        txtNomeUser = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        chk1 = new javax.swing.JCheckBox();
        chk2 = new javax.swing.JCheckBox();
        chk3 = new javax.swing.JCheckBox();
        chk4 = new javax.swing.JCheckBox();
        chk5 = new javax.swing.JCheckBox();
        chk6 = new javax.swing.JCheckBox();
        chk7 = new javax.swing.JCheckBox();
        chk8 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do Usuário:");

        txtNomeUser.setName("txtNomeUser"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        chk1.setText("Eleições 2018");
        chk1.setName("chk1"); // NOI18N
        chk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk1ActionPerformed(evt);
            }
        });

        chk2.setText("Segurança Pública");
        chk2.setName("chk2"); // NOI18N

        chk3.setText("Preço da Gasolina");
        chk3.setName("chk3"); // NOI18N

        chk4.setText("Sistema Nacional de Saúde");
        chk4.setName("chk4"); // NOI18N

        chk5.setText("Aposentadoria");
        chk5.setName("chk5"); // NOI18N

        chk6.setText("Traição");
        chk6.setName("chk6"); // NOI18N

        chk7.setText("Multas de Trânsito");
        chk7.setName("chk7"); // NOI18N

        chk8.setText("Educação");
        chk8.setName("chk8"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk1)
                    .addComponent(chk2)
                    .addComponent(chk3)
                    .addComponent(chk4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk5)
                    .addComponent(chk6)
                    .addComponent(chk7)
                    .addComponent(chk8))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk1)
                    .addComponent(chk5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk2)
                    .addComponent(chk6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk3)
                    .addComponent(chk7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk4)
                    .addComponent(chk8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Tópicos:");

        btnOk.setLabel("OK");
        btnOk.setName("btnOk"); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeUser))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            byte msg[] = new byte[MSG_SIZE];
            InetAddress addr = InetAddress.getByName(HOST);
            
            DatagramSocket soc = new DatagramSocket();
            DatagramPacket pct;
            
            String nomeUser = txtNomeUser.getText();

            if (nomeUser.length() > MSG_SIZE) {
                JOptionPane.showMessageDialog(null, "O nome do usuário não pode ultrapassar " + MSG_SIZE + " caracteres!");
                return;
            }

            msg = nomeUser.getBytes();
            pct = new DatagramPacket(msg, msg.length, addr, PORTA);            
            soc.send(pct);

            if (chk1.isSelected()) {
                msg = "1".getBytes();
                pct = new DatagramPacket(msg, msg.length, addr, PORTA);
                soc.send(pct);
            }
            if (chk2.isSelected()){
                msg = "2".getBytes();
                pct = new DatagramPacket(msg, msg.length, addr, PORTA); 
                soc.send(pct);                
            }
            if (chk3.isSelected()){
                msg = "3".getBytes();
                pct = new DatagramPacket(msg, msg.length, addr, PORTA); 
                soc.send(pct);
            }
            if (chk4.isSelected()){
                msg = "4".getBytes();
                pct = new DatagramPacket(msg, msg.length, addr, PORTA); 
                soc.send(pct);                
            }
            if (chk5.isSelected()){
                msg = "5".getBytes();
                pct = new DatagramPacket(msg, msg.length, addr, PORTA); 
                soc.send(pct);                
            }
            if (chk6.isSelected()){
                msg = "6".getBytes();
                pct = new DatagramPacket(msg, msg.length, addr, PORTA); 
                soc.send(pct);                
            }
            if (chk7.isSelected()){
                msg = "7".getBytes();
                pct = new DatagramPacket(msg, msg.length, addr, PORTA); 
                soc.send(pct);                
            }
            if (chk8.isSelected()){
                msg = "8".getBytes();
                pct = new DatagramPacket(msg, msg.length, addr, PORTA); 
                soc.send(pct);
            }
            
            msg = "end".getBytes();
            pct = new DatagramPacket(msg, msg.length, addr, PORTA); 
            soc.send(pct);
            
            // recebe do server os users disponiveis para conversa nos topicos escolhidos
            
            soc.close();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer conexão com o servidor!");
        } catch (SocketException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na conexão com o servidor!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no envio das mensagens ao servidor!");
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void chk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk1ActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JCheckBox chk1;
    private javax.swing.JCheckBox chk2;
    private javax.swing.JCheckBox chk3;
    private javax.swing.JCheckBox chk4;
    private javax.swing.JCheckBox chk5;
    private javax.swing.JCheckBox chk6;
    private javax.swing.JCheckBox chk7;
    private javax.swing.JCheckBox chk8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNomeUser;
    // End of variables declaration//GEN-END:variables
}
