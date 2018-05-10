import java.util.*;
import java.lang.*;
public class ChessDriver2 {
    public static void main(String args[]) {
        boolean gameOn = true;
        int gameCounter = 0;
        Scanner scan = new Scanner(System.in);                        //Making the chess board and making a game counter
        ChessBoard board = new ChessBoard();                         // To decide whose turn it is
        ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();

        System.out.println("Welcome to Chess! The top part of the board is the black side, " +
                "and the bottom part is the white side. Per tradition, the white side gets the first move. Enter coords like so 2 4 1 9. Good luck players!");

        Pawn bp1 = new Pawn(0, 6, "Black");
        pieces.add(bp1);                                                     //Setting up all of the pieces and adding them to an arrayList
        Pawn bp2 = new Pawn(1, 6, "Black");
        pieces.add(bp2);
        Pawn bp3 = new Pawn(2, 6, "Black");
        pieces.add(bp3);
        Pawn bp4 = new Pawn(3, 6, "Black");
        pieces.add(bp4);
        Pawn bp5 = new Pawn(4, 6, "Black");
        pieces.add(bp5);
        Pawn bp6 = new Pawn(5, 6, "Black");
        pieces.add(bp6);
        Pawn bp7 = new Pawn(6, 6, "Black");
        pieces.add(bp7);
        Pawn bp8 = new Pawn(7, 6, "Black");
        pieces.add(bp8);
        Rook br1 = new Rook(0, 7, "Black");
        pieces.add(br1);
        Knight bh1 = new Knight(1, 7, "Black");
        pieces.add(bh1);
        Bishop bb1 = new Bishop(2, 7, "Black");
        pieces.add(bb1);
        Queen qb1 = new Queen(3, 7, "Black");
        pieces.add(qb1);
        King bk1 = new King(4, 7, "Black");
        pieces.add(bk1);
        Bishop bb2 = new Bishop(5, 7, "Black");
        pieces.add(bb2);
        Knight bk2 = new Knight(6, 7, "Black");
        pieces.add(bk2);
        Rook br2 = new Rook(7, 7, "Black");
        pieces.add(br2);

        Pawn wp1 = new Pawn(0, 1, "White");
        pieces.add(wp1);
        Pawn wp2 = new Pawn(1, 1, "White");
        pieces.add(wp2);
        Pawn wp3 = new Pawn(2, 1, "White");
        pieces.add(wp3);
        Pawn wp4 = new Pawn(3, 1, "White");
        pieces.add(wp4);
        Pawn wp5 = new Pawn(4, 1, "White");
        pieces.add(wp5);
        Pawn wp6 = new Pawn(5, 1, "White");
        pieces.add(wp6);
        Pawn wp7 = new Pawn(6, 1, "White");
        pieces.add(wp7);
        Pawn wp8 = new Pawn(7, 1, "White");
        pieces.add(wp8);
        Rook wr1 = new Rook(0, 0, "White");
        pieces.add(wr1);
        Knight wh1 = new Knight(1, 0, "White");
        pieces.add(wh1);
        Bishop wb1 = new Bishop(5, 0, "White");
        pieces.add(wb1);
        Queen wq1 = new Queen(3, 0, "White");
        pieces.add(wq1);
        King wk1 = new King(4, 0, "White");
        pieces.add(wk1);
        Bishop wb2 = new Bishop(2, 0, "White");
        pieces.add(wb2);
        Knight wh2 = new Knight(6, 0, "White");
        pieces.add(wh2);
        Rook wr2 = new Rook(7, 0, "White");
        pieces.add(wr2);
        System.out.println(board.toString());

        while (gameOn = true) {
            if (gameCounter % 2 == 0) {
                System.out.println("White turn: ");
                String line = scan.nextLine();                             //Deciding whether it's white turn or black turn and then taking in
                String[] strArray = line.split(" ");                //The input using scanner and seperating coordinates
                int[] coords = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    coords[i] = Integer.parseInt(strArray[i]);
                }
                if (!board.getBoardTile(coords[0], coords[1]).equals("---")) {
                    for (int i = 0; i < pieces.size(); i++) {
                        if (pieces.get(i).getRow() == coords[0] && pieces.get(i).getCol() == coords[1] && pieces.get(i).getPieceColor().equalsIgnoreCase("White")) {
                            pieces.get(i).move(coords[2], coords[3]);                   //Incrementing the game counter if the move is cast
                            gameCounter++;
                            System.out.println(board.toString());
                        }
                    }
                }
            }
            if (gameCounter % 2 == 1) {
                System.out.println("Black turn: ");
                String line = scan.nextLine();
                String[] strArray = line.split(" ");
                int[] coords = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    coords[i] = Integer.parseInt(strArray[i]);
                }
                if (!board.getBoardTile(coords[0], coords[1]).equals("---")) {
                    for (int i = 0; i < pieces.size(); i++) {
                        if (pieces.get(i).getRow() == coords[0] && pieces.get(i).getCol() == coords[1] && pieces.get(i).getPieceColor().equalsIgnoreCase("Black")) {
                            pieces.get(i).move(coords[2], coords[3]);
                            gameCounter++;
                            System.out.println(board.toString());
                        }
                    }
                } else {
                    System.out.println("Invalid movement");
                }
            }
            for(int i = 0; i < pieces.size();i++){
                if(pieces.get(i).getCol() == 7 || pieces.get(i).getCol() == 0){
                    if(pieces.get(i).getPieceName().equalsIgnoreCase("Pawn")){
                        if(pieces.get(i).getPieceColor().equalsIgnoreCase("Black") && pieces.get(i).getCol() == 0){
                            int tempRow = pieces.get(i).getRow();
                            int tempCol = pieces.get(i).getCol();
                            pieces.remove(i);                               //Upgrading the pawn if it reaches the other end of the board
                            Queen bq2 = new Queen(tempRow, tempCol, "Black");
                            pieces.add(bq2);
                        }
                        else if(pieces.get(i).getPieceColor().equalsIgnoreCase("White") && pieces.get(i).getCol() == 7){
                            int tempRow = pieces.get(i).getRow();
                            int tempCol = pieces.get(i).getCol();
                            pieces.remove(i);
                            Queen wq2 = new Queen(tempRow, tempCol, "White");
                            pieces.add(wq2);
                        }
                    }
                }
            }
        }
    }
}
