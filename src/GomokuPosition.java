
import java.io.Serializable;


public class GomokuPosition extends Position implements Serializable{

    final static public int BLANK = 0;
    final static public int HUMAN = 1;
    final static public int PROGRAM = -1;
    int[] board = new int[256];

    public GomokuPosition() {
        for (int i = 0; i < 256; i++) {
            this.board[i] = 0;
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < 256; i++) {
            sb.append("" + board[i] + ",");
        }
        sb.append("]");
        return sb.toString();
    }
}
