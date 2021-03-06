/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.pkgdo.barbeiro;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author root
 */
public class ViewProblemaBarbeiro extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form InterfaceGrafica
     */
    boolean controle = true;

    private Observable processor;
    ProblemaDoBarbeiro p1;

    public ViewProblemaBarbeiro() {
        initComponents();

        cadeiraBarbeiro.setBackground(Color.green);
        cadeira1.setBackground(Color.green);
        cadeira2.setBackground(Color.green);
        cadeira3.setBackground(Color.green);
        cadeira4.setBackground(Color.green);
        cadeira5.setBackground(Color.green);

        p1 = ProblemaDoBarbeiro.getInstance();

        registerObserver(p1);
    }

    public void registerObserver(Observable barbeiro) {
        this.processor = barbeiro;
        barbeiro.addObserver(this);
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
        cadeira1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cadeira2 = new javax.swing.JButton();
        cadeira3 = new javax.swing.JButton();
        cadeiraBarbeiro = new javax.swing.JButton();
        cadeira5 = new javax.swing.JButton();
        cadeira4 = new javax.swing.JButton();
        Start = new javax.swing.JButton();
        Stop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Problema do barbeiro");

        jLabel1.setText("Cadeira do barbeiro:");

        jLabel2.setText("Cadeiras para espera:");

        Start.setText("Começar");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Stop.setText("Parar");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadeira1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadeira2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadeira3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadeira4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadeira5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cadeiraBarbeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Stop)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadeiraBarbeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadeira1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadeira2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadeira3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadeira4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadeira5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start)
                    .addComponent(Stop))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        p1.setExecuta(true);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 200 && controle; i++) {
            executor.execute(() -> {
                try {
                    ProblemaDoBarbeiro.getInstance().connect();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ViewProblemaBarbeiro.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

        executor.shutdown();

    }//GEN-LAST:event_StartActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        // TODO add your handling code here:
        p1.setExecuta(false);

    }//GEN-LAST:event_StopActionPerformed

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
            java.util.logging.Logger.getLogger(ViewProblemaBarbeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProblemaBarbeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProblemaBarbeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProblemaBarbeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProblemaBarbeiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Start;
    private javax.swing.JButton Stop;
    private javax.swing.JButton cadeira1;
    private javax.swing.JButton cadeira2;
    private javax.swing.JButton cadeira3;
    private javax.swing.JButton cadeira4;
    private javax.swing.JButton cadeira5;
    private javax.swing.JButton cadeiraBarbeiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        Thread GUIThread = new Thread(() -> {
            synchronized (this) {
                int cadeiras;
                boolean barbeiro;
                if (o instanceof ProblemaDoBarbeiro) {
                    ProblemaDoBarbeiro p = (ProblemaDoBarbeiro) o;
                    cadeiras = p.getCadeirasOcupadas();
                    barbeiro = p.isCadeiraBarbeiroOcupada();

                    if (barbeiro) {
                        cadeiraBarbeiro.setBackground(Color.red);
                    } else {
                        cadeiraBarbeiro.setBackground(Color.green);
                    }

                    if (cadeiras > 0) {
                        cadeira1.setBackground(Color.red);
                    } else {
                        cadeira1.setBackground(Color.green);
                    }

                    if (cadeiras > 1) {
                        cadeira2.setBackground(Color.red);
                    } else {
                        cadeira2.setBackground(Color.green);
                    }

                    if (cadeiras > 2) {
                        cadeira3.setBackground(Color.red);
                    } else {
                        cadeira3.setBackground(Color.green);
                    }

                    if (cadeiras > 3) {
                        cadeira4.setBackground(Color.red);
                    } else {
                        cadeira4.setBackground(Color.green);
                    }

                    if (cadeiras > 4) {
                        cadeira5.setBackground(Color.red);
                    } else {
                        cadeira5.setBackground(Color.green);
                    }

                }
            }
        });
        GUIThread.start();
    }
}
