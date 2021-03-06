
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mehdi Fll
 */
public class Game extends javax.swing.JFrame {

    int gametype;
    int niveau;
    String pioncolor;
    String player1;
    String player2;

    /**
     * Creates new form Game
     */

    public Game(int gametype, int niveau, String pioncolor, String player1, String player2) {
        this.gametype = gametype;
        this.niveau = niveau;
        this.pioncolor = pioncolor;
        this.player1 = player1;
        this.player2 = player2;
        initComponents();
        Color c = new Color(255, 255, 255);
        this.getContentPane().setBackground(c);

    }

    Game(GomokuPosition p, int gametype, int niveau, String pioncolor) {
        this.gametype = gametype;
        this.niveau = niveau;
        this.pioncolor = pioncolor;
        initComponents();
        this.getGrille2().setP(p);
    }

    public Grille getGrille2() {
        return grille2;
    }

    public void setGrille2(Grille grille2) {
        this.grille2 = grille2;
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        grille2 = new Grille(gametype,niveau, pioncolor,player1,player2);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(235, 200, 175));
        jPanel1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jButton1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(97, 64, 64));
        jButton1.setText("Save");
        jButton1.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton1.setOpaque(false);
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(97, 64, 64));
        jButton2.setText("Hint");
        jButton2.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorder(null);
        jButton2.setOpaque(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(97, 64, 64));
        jButton3.setText("Return");
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorder(null);
        jButton3.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton3.setOpaque(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(97, 64, 64));
        jButton4.setText("Menu");
        jButton4.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorder(null);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(grille2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grille2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        //int returnValue = jfc.showOpenDialog(null);
        int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            try {
                FileOutputStream fileOut = new FileOutputStream(selectedFile);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(getGrille2().getLinkedlist());
                out.writeObject(getGrille2().gametype);
                out.writeObject(getGrille2().niveau);
                out.writeObject(getGrille2().turn);
                out.writeObject(getGrille2().pioncolor);
                out.close();
                fileOut.close();
                System.out.println("\nSerialization Successful... Checkout your specified output file..\n");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 64, 64), 4, true));      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBorder(null);     }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 64, 64), 4, true));      // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBorder(null);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 64, 64), 4, true));      // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setBorder(null);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println(this.getGrille2().isReturnEnabled);
        if (this.getGrille2().isReturnEnabled) {
            int size = this.getGrille2().getLinkedlist().size();
            if (this.getGrille2().gametype == 1 && size > 2) {
                this.getGrille2().setP(this.getGrille2().getLinkedlist().get(size - 3));
                System.out.println(this.getGrille2().getLinkedlist().get(size - 3));
                this.getGrille2().getLinkedlist().removeLast();
                this.getGrille2().getLinkedlist().removeLast();
                this.getGrille2().drawBoardType1(this.getGrille2().getP());
            } else if (this.getGrille2().gametype == 1 && size == 2) {
                GomokuPosition p = new GomokuPosition();
                for (int i = 0; i < 256; i++) {
                    p.board[i] = 0;
                }
                this.getGrille2().setLinkedlist(new LinkedList<GomokuPosition>());
                this.getGrille2().setP(p);
                this.getGrille2().drawBoardType1(this.getGrille2().getP());

            } else if (this.getGrille2().gametype == 2 && size > 2) {

                this.getGrille2().setP(this.getGrille2().getLinkedlist().get(size - 2));
                this.getGrille2().getLinkedlist().removeLast();
                this.getGrille2().drawBoardType2(this.getGrille2().getP());
                this.getGrille2().turn = !this.getGrille2().turn;
            }
        }
        this.getGrille2().isReturnEnabled = false;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 64, 64), 4, true));      // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setBorder(null);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        Menu m = new Menu();
        m.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        grille2.hint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        grille2.hint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Grille grille2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
