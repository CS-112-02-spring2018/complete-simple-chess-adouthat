import java.lang.*;
import java.util.*;

public class ChessBoard{
    int turnCount = 0;

    public static String[][] board = new String[9][9];
    public ChessBoard(){
        for(int c = 8; c >= 0; c--){
            for (int r = 8; r >= 0; r--) {
                if(r == 8 && c == 0){
                    board[8][0] = "===";               //Making the chess board
                }
                else if (r == 8) {
                    board[8][c] = "=" + (c-1) + "=";
                }
                else if (c == 0) {
                    board[r][0] = "=" + (7-r) + "=";
                } else {
                    board[r][c] = "---";
                }
            }
        }
    }

    public void setBoardTile(String name, int row, int col){
        board[7 - col][row + 1] = name;
    }

    public String getBoardTile(int row, int col){
        return board[7 - col][row + 1];
    }

    public String toString(){
        String result = "";                       //Printing out the chess board
        for(int i = 0;i < board.length;i++){
            result+= "\n";
            for(int g = 0;g < board[0].length;g++){
                result += board[i][g] + " ";
            }
        }
        return result;
    }
}