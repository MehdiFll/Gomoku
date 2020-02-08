
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class Gomoku extends GameSearch {

    public boolean drawnPosition(Position p) {
        if (GameSearch.DEBUG) {
            System.out.println("drawnPosition(" + p + ")");
        }
        boolean ret = true;
        GomokuPosition pos = (GomokuPosition) p;
        for (int i = 0; i < 256; i++) {
            if (pos.board[i] == GomokuPosition.BLANK) {
                ret = false;
                break;
            }
        }
        if (GameSearch.DEBUG) {
            System.out.println("     ret=" + ret);
        }
        return ret;
    }

    public boolean wonPosition(Position p, boolean player) {
        if (GameSearch.DEBUG) {
            System.out.println("wonPosition(" + p + "," + player + ")");
        }
        GomokuPosition pos = (GomokuPosition) p;
        int[] g = calcul(p, player);
        if (g[4] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] calcul(Position p, boolean player) {
        int count = 0, countligne = 0;
        int[] occ = new int[]{0, 0, 0, 0, 0};
        int t;
        if (player == HUMAN) {
            t = 1;
        } else {
            t = -1;
        }
        GomokuPosition pos = (GomokuPosition) p;

        //boucle lignes
        for (int i = 0; i < pos.board.length; i = i + 16) {
            while (countligne < 16) {
                for (int j = i; j < i + 16; j++) {
                    if (pos.board[j] == t) {
                        count++;
                    } else {
                        if (count > 0 && count < 6) {
                            occ[count - 1]++; // occ[0] b nbr de chaine de 1 etc...
                        }
                        count = 0;
                    }
                    countligne++;
                }

            }
            if (count > 0 && count < 6) {
                occ[count - 1]++;
            }
            count = 0;
            countligne = 0;
        }

        //boucle colonnes
        for (int i = 0; i < 16; i++) {
            while (countligne < 16) {
                for (int j = i; j < pos.board.length; j = j + 16) {
                    if (pos.board[j] == t) {
                        count++;
                    } else {
                        if (count > 1 && count < 6) {
                            occ[count - 1]++; // occ[0] b nbr de chaine de 1 etc...
                        }
                        count = 0;
                    }
                    countligne++;
                }

            }
            if (count > 1 && count < 6) {
                occ[count - 1]++;
            }
            count = 0;
            countligne = 0;

        }

        //boucle diagonale 1
        for (int i = 4; i < 16; i++) {

            //for (int j = i; j < pos.board.length; j=j+15)
            int diagonaleLength = 0;
            int j = i;
            while (diagonaleLength < i + 1) {

                if (pos.board[j] == t) {
                    count++;
                } else {
                    if (count > 1 && count < 6) {
                        occ[count - 1]++; // occ[0] b nbr de chaine de 1 etc...
                    }
                    count = 0;
                }
                j = j + 15;
                diagonaleLength++;
            }

            if (count > 1 && count < 6) {
                occ[count - 1]++;
            }
            count = 0;
        }

        //boucle diagonale 2
        int nbr = 4;
        for (int i = 191; i > 15; i = i - 16) {

            int diagonaleLength = 0;
            int j = i;
            while (diagonaleLength < nbr + 1) {

                if (pos.board[j] == t) {
                    count++;
                } else {
                    if (count > 1 && count < 6) {
                        occ[count - 1]++; // occ[0] b nbr de chaine de 1 etc...
                        diagonaleLength++;
                    }
                    count = 0;
                }
                j = j + 15;
                diagonaleLength++;
            }
            nbr = nbr + 1;

            if (count > 1 && count < 6) {
                occ[count - 1]++;
            }
            count = 0;
        }

        //diagonale 3
        int diagonaleLengthMax = 5;

        for (int i = 11; i >= 0; i--) {
            //for (int j = i; j < pos.board.length; j=j+15)
            int diagonaleLength = 0;
            int j = i;
            while (diagonaleLength < diagonaleLengthMax) {

                if (pos.board[j] == t) {
                    count++;
                } else {
                    if (count > 1 && count < 6) {
                        occ[count - 1]++; // occ[0] b nbr de chaine de 1 etc...
                    }
                    count = 0;
                }
                j = j + 17;
                diagonaleLength++;

            }
            diagonaleLengthMax++;

            if (count > 1 && count < 6) {
                occ[count - 1]++;
            }
            count = 0;
        }

        //diagonale 4
        diagonaleLengthMax = 5;

        for (int i = 176; i > 0; i = i - 16) {
            //for (int j = i; j < pos.board.length; j=j+15)
            int diagonaleLength = 0;
            int j = i;
            while (diagonaleLength < diagonaleLengthMax) {

                if (pos.board[j] == t) {
                    count++;
                } else {
                    if (count > 1 && count < 6) {
                        occ[count - 1]++; // occ[0] b nbr de chaine de 1 etc...
                    }
                    count = 0;
                }
                j = j + 17;
                diagonaleLength++;

            }
            diagonaleLengthMax++;

            if (count > 1 && count < 6) {
                occ[count - 1]++;
            }
            count = 0;
        }
        return occ;
    }

    @Override
    public float positionEvaluation(Position p, boolean player) {
        GomokuPosition pos = (GomokuPosition) p;
        int[] t1 = calcul(p, player);
        int[] t2 = calcul(p, !player);
        float ret;
//      ret = 0 * t1[0] + 5 * t1[1] + 10 * t1[2] + 17 * t1[3] - (0 * t2[0] + 5 * t2[1] + 12 * t2[2] + 15 * t2[3]);
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (pos.board[i] != 0) {
                count++;
            }
        }
        ret = 1 * t1[0] + 3 * t1[1] + 10 * t1[2] + 1000 * t1[3] - (1 * t2[0] + 3 * t2[1] + 10 * t2[2] + 1000 * t2[3]);
        // prefer the center square:
        if (wonPosition(p, player)) {
            return ret + 1000; //la plus grand valeur
        }
        if (wonPosition(p, !player)) {
            return -ret - 1000;
        }
        return ret;
    }

    @Override
    public void printPosition(Position p) {
        System.out.println("Board position:");
        GomokuPosition pos = (GomokuPosition) p;
        int count = 0;
        for (int row = 0; row < 16; row++) {
            System.out.println();
            for (int col = 0; col < 16; col++) {
                if (pos.board[count] == GomokuPosition.HUMAN) {
                    System.out.print("H");
                } else if (pos.board[count] == GomokuPosition.PROGRAM) {
                    System.out.print("P");
                } else {
                    System.out.print("0");
                }
                count++;
            }
        }
        System.out.println();
    }

    @Override
    public Position[] possibleMoves(Position p, boolean player) {
        if (GameSearch.DEBUG) {
            System.out.println("posibleMoves(" + p + "," + player + ")");
        }
        GomokuPosition pos = (GomokuPosition) p;
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (pos.board[i] == 0) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        Position[] ret = new Position[count];
        count = 0;
        for (int i = 0; i < 256; i++) {
            if (pos.board[i] == 0) {
                GomokuPosition pos2 = new GomokuPosition();
                for (int j = 0; j < 256; j++) {
                    pos2.board[j] = pos.board[j];
                }
                if (player) {
                    pos2.board[i] = 1;
                } else {
                    pos2.board[i] = -1;
                }
                ret[count++] = pos2;
                if (GameSearch.DEBUG) {
                    System.out.println("    " + pos2);
                }
            }
        }
        return ret;
    }

    public Position makeMove(Position p, boolean player, Move move) {
        if (GameSearch.DEBUG) {
            System.out.println("Entered Gomoku.makeMove");
        }
        GomokuMove m = (GomokuMove) move;
        GomokuPosition pos = (GomokuPosition) p;
        GomokuPosition pos2 = new GomokuPosition();
        for (int i = 0; i < 256; i++) {
            pos2.board[i] = pos.board[i];
        }
        int pp;
        if (player) {
            pp = 1;
        } else {
            pp = -1;
        }
        if (GameSearch.DEBUG) {
            System.out.println("makeMove: m.moveIndex = " + m.moveIndex);
        }
        pos2.board[m.moveIndex] = pp;
        return pos2;
    }

    public boolean reachedMaxDepth(Position p, int depth) {
        boolean ret = false;
        if (wonPosition(p, false)) {
            ret = true;
        } else if (wonPosition(p, true)) {
            ret = true;
        } else if (drawnPosition(p)) {
            ret = true;
        }
        if (GameSearch.DEBUG) {
            System.out.println("reachedMaxDepth: pos=" + p.toString() + ", depth=" + depth
                    + ", ret=" + ret);
        }
        return ret;
    }

    
    public Move createMove(Position startingPosition, int i) {
        if (GameSearch.DEBUG) {
            System.out.println("Enter blank square index [0,8]:");
        }
        GomokuPosition p = (GomokuPosition) startingPosition;
        GomokuMove mm = new GomokuMove();
        mm.moveIndex = -1;
        if (p.board[i] == 0) {
            mm.moveIndex = i;
        }

        return mm;
    }

    static public void main(String[] args) {

        int c = 0;
        for (int i = 0; i < 256; i++) {
            System.out.print(i + " ");
            c++;
            if (c % 16 == 0 && c != 0) {
                System.out.println(" ");
            }
        }
        GomokuPosition p = new GomokuPosition();

//        p.board[4] = -1;
//        p.board[19] = -1;
//        p.board[34] = -1;
//        p.board[49] = -1;
//        p.board[64] = -1;
//
//        p.board[31] = 1;
//        p.board[46] = 1;
//        p.board[61] = 1;
//        p.board[76] = 1;
//
//        p.board[11] = 1;
//        p.board[28] = 1;
//        p.board[45] = 1;
//        p.board[62] = 1;
//        
//        p.board[100] = 1;
//        p.board[117] = 1;
//        p.board[134] = 1;
//        p.board[151] = 1;
//        p.board[168] = 1;
//        int[] g = calcul(p, true);
//        System.out.println(g[1]+" "+g[2]+" "+g[3]+" "+ g[4]+" ");
       // java.awt.EventQueue.invokeLater(new Runnable() {
        //    public void run() {
                try {
                    //                WebLookAndFeel.install ();
//                WebLookAndFeel.setAllowLinuxTransparency(true);

                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Gomoku.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Gomoku.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Gomoku.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Gomoku.class.getName()).log(Level.SEVERE, null, ex);
                }

                Menu m = new Menu();
                m.setVisible(true);
            }

        //});

    }

