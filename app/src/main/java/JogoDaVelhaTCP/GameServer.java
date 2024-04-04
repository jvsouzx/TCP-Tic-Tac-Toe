/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JogoDaVelhaTCP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author jvsx
 */
public class GameServer extends javax.swing.JFrame {

    public volatile String turn = "O";
    public volatile String str_matrix = "";

    /**
     * Creates new form GameServer
     */
    public GameServer() {

        initComponents();

        JToggleButton[][] GameMatrix = {
            {b11, b12, b13},
            {b21, b22, b23},
            {b31, b32, b33},};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameMatrix[i][j].setEnabled(false);
                GameMatrix[i][j].setText("_");
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                str_matrix = str_matrix + GameMatrix[i][j].getText() + ",";
            }
            str_matrix = str_matrix + "/";
        }

        Thread t1 = new Thread(() -> {
            try {
                ServerSocket servidor = new ServerSocket(4040);
                while (true) {
                    Socket cliente = servidor.accept();
                    ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                    str_matrix = entrada.readUTF();
                    turn = entrada.readUTF();
                    entrada.close();
                    cliente.close();
//                    System.out.println("Matriz:" + str_matrix + " turno:" + turn);
//                    String[] str = str_matrix.split("/");
//                    for (int i = 0; i < 3; i++) {
//                        for (int j = 0; j < 3; j++) {
//                            System.out.println(str[i].split(",")[j]);
//                        }
//                    }
                    String[] str = str_matrix.split("/");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            GameMatrix[i][j].setText(str[i].split(",")[j]);
                        }
                    }
                    Socket servToPlayer = new Socket("localhost", 8888);

                    ObjectOutputStream out = new ObjectOutputStream(servToPlayer.getOutputStream());
                    out.flush();
                    out.writeUTF(str_matrix);
                    out.writeUTF(turn);
                    out.close();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Deu ruim: " + e.getMessage());
            }
        });

        t1.start();

        if (b11.getText().equals("O") && b12.getText().equals("O") && b13.getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Jogador O ganhou a partida!");
        } else if (b11.getText().equals("X") && b12.getText().equals("X") && b13.getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Jogador X ganhou a partida!");
        } else if (b21.getText().equals("O") && b22.getText().equals("O") && b23.getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Jogador O ganhou a partida!");
        } else if (b21.getText().equals("X") && b22.getText().equals("X") && b23.getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Jogador X ganhou a partida!");
        } else if (b31.getText().equals("O") && b32.getText().equals("O") && b33.getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Jogador O ganhou a partida!");
        } else if (b31.getText().equals("X") && b32.getText().equals("X") && b33.getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Jogador X ganhou a partida!");
        } else if (b11.getText().equals("O") && b21.getText().equals("O") && b31.getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Jogador O ganhou a partida!");
        } else if (b11.getText().equals("X") && b21.getText().equals("X") && b31.getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Jogador X ganhou a partida!");
        } else if (b12.getText().equals("O") && b22.getText().equals("O") && b32.getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Jogador O ganhou a partida!");
        } else if (b12.getText().equals("X") && b22.getText().equals("X") && b32.getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Jogador X ganhou a partida!");
        } else if (b13.getText().equals("O") && b23.getText().equals("O") && b33.getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Jogador O ganhou a partida!");
        } else if (b13.getText().equals("X") && b23.getText().equals("X") && b33.getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Jogador X ganhou a partida!");
        } else if (b11.getText().equals("O") && b22.getText().equals("O") && b33.getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Jogador O ganhou a partida!");
        } else if (b11.getText().equals("X") && b22.getText().equals("X") && b33.getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Jogador X ganhou a partida!");
        } else if (b31.getText().equals("O") && b22.getText().equals("O") && b13.getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Jogador O ganhou a partida!");
        } else if (b31.getText().equals("X") && b22.getText().equals("X") && b13.getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Jogador X ganhou a partida!");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b11 = new javax.swing.JToggleButton();
        b12 = new javax.swing.JToggleButton();
        b13 = new javax.swing.JToggleButton();
        b21 = new javax.swing.JToggleButton();
        b22 = new javax.swing.JToggleButton();
        b23 = new javax.swing.JToggleButton();
        b31 = new javax.swing.JToggleButton();
        b32 = new javax.swing.JToggleButton();
        b33 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Jogo Da Velha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b31, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b32, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b33, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b22, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b23, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(335, 335, 335))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton b11;
    private javax.swing.JToggleButton b12;
    private javax.swing.JToggleButton b13;
    private javax.swing.JToggleButton b21;
    private javax.swing.JToggleButton b22;
    private javax.swing.JToggleButton b23;
    private javax.swing.JToggleButton b31;
    private javax.swing.JToggleButton b32;
    private javax.swing.JToggleButton b33;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
