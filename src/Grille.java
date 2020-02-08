
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mehdi Fll
 */
public class Grille extends javax.swing.JPanel {

    JButton[] buttons;
    int gametype;
    int niveau;
    String pioncolor;
    Gomoku gomoku;
    public GomokuPosition p;
    public boolean PROGRAM = false;
    public boolean HUMAN = true;
    public boolean turn = true;
    String text;
    String player1;
    String player2;
    LinkedList<GomokuPosition> linkedlist;
    public boolean isReturnEnabled = false;

    /**
     * Creates new form Grille
     */
    public Grille() {

    }

    public void hint() {
        int hint = 0;
        if (gametype == 1) {
            Vector v = gomoku.alphaBeta(0, p, HUMAN, niveau);
            /* for(int i=0; i<v.size();i++){
                System.out.println("m");
                System.out.println(v.get(i));
            }*/
            Enumeration enum2 = v.elements();
            GomokuPosition phint = (GomokuPosition) v.elementAt(1);
            GomokuPosition old = (GomokuPosition) p;

            for (int i = 0; i < 257; i++) {
                if (phint.board[i] != old.board[i]) {
                    hint = i;
                    break;
                }
            }
        } else {

            if (turn) {
                Vector v = gomoku.alphaBeta(0, p, HUMAN, niveau);

                Enumeration enum2 = v.elements();
                GomokuPosition phint = (GomokuPosition) v.elementAt(1);
                GomokuPosition old = (GomokuPosition) p;

                for (int i = 0; i < 257; i++) {
                    if (phint.board[i] != old.board[i]) {
                        hint = i;
                        break;
                    }
                };
            } else {
                Vector v = gomoku.alphaBeta(0, p, PROGRAM, niveau);

                Enumeration enum2 = v.elements();
                GomokuPosition phint = (GomokuPosition) v.elementAt(1);
                GomokuPosition old = (GomokuPosition) p;

                for (int i = 0; i < 257; i++) {
                    if (phint.board[i] != old.board[i]) {
                        hint = i;
                        break;
                    }
                }
            }
        }
        System.out.println(hint);
        buttons[hint].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pion_rouge.png")));

    }

    public LinkedList<GomokuPosition> getLinkedlist() {
        return linkedlist;
    }

    public void setLinkedlist(LinkedList<GomokuPosition> linkedlist) {
        this.linkedlist = linkedlist;
    }

    public GomokuPosition getP() {
        return p;
    }

    public void setP(GomokuPosition p) {
        this.p = p;
    }

    public Grille(int gametype, int niveau, String pioncolor, String player1, String player2) {
        initComponents();
        gomoku = new Gomoku();
        this.gametype = gametype;
        this.niveau = niveau;
        this.pioncolor = pioncolor;
        this.player1=player1;
        this.player2=player2;
        p = new GomokuPosition();
        linkedlist = new LinkedList();
        System.out.println("gametype " + this.gametype + " pioncolor " + this.pioncolor + " niveau " + this.niveau);
        if (gametype == 1) {
            if (pioncolor.equals("white")) {
                turn = false;
                Vector v = gomoku.alphaBeta(0, p, PROGRAM, niveau);
                p = (GomokuPosition) (Position) v.elementAt(1);
                linkedlist.addLast(p);
                isReturnEnabled = true;
                drawBoardType1(p);
            }
        }
    }

    public int getGametype() {
        return gametype;
    }

    public void setGametype(int gametype) {
        this.gametype = gametype;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getPioncolor() {
        return pioncolor;
    }

    public void setPioncolor(String pioncolor) {
        this.pioncolor = pioncolor;
    }

    public void mouseClickedType1(JButton b) {

        GomokuMove m = (GomokuMove) gomoku.createMove(p, Integer.parseInt(b.getName()));
        if (m.moveIndex != -1) {

            if (gomoku.wonPosition(p, HUMAN)) {
                System.out.println("Human won");
                text = player1+" won";
                jPanel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setText(text);
                jLabel3.setVisible(true);
                jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel3.setVerticalAlignment(SwingConstants.CENTER);

            }
            if (gomoku.wonPosition(p, PROGRAM)) {
                System.out.println("Program won");
                text = "Program won";
                jPanel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setText(text);
                jLabel3.setVisible(true);
                jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel3.setVerticalAlignment(SwingConstants.CENTER);
            }
            if (gomoku.drawnPosition(p)) {
                System.out.println("Drawn game");
                text = "Drawn game";
            }

            p = (GomokuPosition) gomoku.makeMove(p, HUMAN, m);
            linkedlist.addLast(p);
            isReturnEnabled = true;
            drawBoardType1(p);
            if (gomoku.wonPosition(p, HUMAN)) {
                System.out.println("Human won");
                text = player1+" won";
                jPanel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setText(text);
                jLabel3.setVisible(true);
                jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel3.setVerticalAlignment(SwingConstants.CENTER);

            }
            if (gomoku.wonPosition(p, PROGRAM)) {
                System.out.println("Program won");
                text = "Program won";
                jPanel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setText(text);
                jLabel3.setVisible(true);
                jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel3.setVerticalAlignment(SwingConstants.CENTER);
            }
            if (gomoku.drawnPosition(p)) {
                System.out.println("Drawn game");
                text = "Drawn game";
                jPanel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setText(text);
                jLabel3.setVisible(true);
                jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel3.setVerticalAlignment(SwingConstants.CENTER);
            }

            Vector v = gomoku.alphaBeta(0, p, PROGRAM, niveau);
            p = (GomokuPosition) (Position) v.elementAt(1);
            linkedlist.addLast(p);
            isReturnEnabled = true;
            drawBoardType1(p);

        }
    }

    public void mouseClickedType2(JButton b) {

        System.out.println(b.getName());
        if (turn) {
            Move move = gomoku.createMove(p, Integer.parseInt(b.getName()));
            p = (GomokuPosition) gomoku.makeMove(p, HUMAN, move);
        } else {
            Move move = gomoku.createMove(p, Integer.parseInt(b.getName()));
            p = (GomokuPosition) gomoku.makeMove(p, PROGRAM, move);
        }
        linkedlist.addLast(p);
        isReturnEnabled = true;
        turn = !turn;
        drawBoardType2(p);
        if (gomoku.wonPosition(p, HUMAN)) {
            text = player1+" won";
            jPanel1.setVisible(false);
            jLabel2.setVisible(false);
            jLabel3.setText(text);
            jLabel3.setVisible(true);
            jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel3.setVerticalAlignment(SwingConstants.CENTER);

        }
        if (gomoku.wonPosition(p, PROGRAM)) {
            text = player2+" won";
            jPanel1.setVisible(false);
            jLabel2.setVisible(false);
            jLabel3.setText(text);
            jLabel3.setVisible(true);
            jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel3.setVerticalAlignment(SwingConstants.CENTER);
        }
        if (gomoku.drawnPosition(p)) {
            System.out.println("Drawn game");
            text = "Drawn game";
            jPanel1.setVisible(false);
            jLabel2.setVisible(false);
            jLabel3.setText(text);
            jLabel3.setVisible(true);
            jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel3.setVerticalAlignment(SwingConstants.CENTER);

        }
    }

    public void drawBoardType1(GomokuPosition gp) {
        for (int i = 0; i < 256; i++) {
            buttons[i].setIcon(null);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setBorder(null);
        }
        for (int i = 0; i < gp.board.length; i++) {
            if (turn) {
                if (gp.board[i] == -1) {

                    buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pion_blanc.png")));
                }
                if (gp.board[i] == 1) {

                    buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pion_noir.png")));
                }
                if (gp.board[i] == 0) {
                    buttons[i].setIcon(null);
                }
            } else {
                if (gp.board[i] == -1) {

                    buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pion_noir.png")));
                }
                if (gp.board[i] == 1) {

                    buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pion_blanc.png")));
                }
                if (gp.board[i] == 0) {
                    buttons[i].setIcon(null);
                }
            }
        }

    }

    public void drawBoardType2(GomokuPosition gp) {
        for (int i = 0; i < 256; i++) {
            buttons[i].setIcon(null);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setBorder(null);
        }
        for (int i = 0; i < gp.board.length; i++) {

            if (gp.board[i] == -1) {
                buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pion_blanc.png")));
            } else if (gp.board[i] == 1) {
                buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pion_noir.png")));
            } else if (gp.board[i] == 0) {
                buttons[i].setIcon(null);

            }
        }
    }

    public void mouseClickedSwitch(JButton b) {
        if (gametype == 1) {
            mouseClickedType1(b);
        }
        if (gametype == 2) {
            mouseClickedType2(b);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(16, 16));
        /*

        jPanel1.add(b);
        jPanel1.setOpaque(false);
        b.setBounds(5, 20, 20, 20);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);

        b.setBorder(null);
        */

        jPanel1.setLayout(new java.awt.GridLayout(16, 16,2,2));
        buttons = new JButton[256];
        int i=0;
        for(i =0; i<256; i++){
            JButton b = new JButton();
            b.setName(""+i);
            jPanel1.add(b);
            jPanel1.setOpaque(false);
            b.setBounds(0, 0, 18, 18);
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setBorder(null);
            buttons[i]=b;
            if(b.getIcon()==null){
                b.addMouseListener(new MouseAdapter(){

                    @Override
                    public void mouseExited(MouseEvent e)
                    {

                    }
                    @Override
                    public void mouseEntered(MouseEvent e)
                    {

                    }
                });
            }
            b.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    mouseClickedSwitch(b);
                }

            });

        }
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grille2.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(97, 64, 64));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        jLabel3.setVisible(false);

        for (int i = 0; i < 256; i++) {
            buttons[i].setIcon(null);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setBorder(null);
        }
        jPanel1.setVisible(true);
        jLabel2.setVisible(true);
        p = new GomokuPosition();
        if (gametype == 1) {
            drawBoardType1(p);
        } else {
            drawBoardType2(p);
        }
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
