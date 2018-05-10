public class Knight extends ChessPiece {

    public Knight(int row, int column, String pieceColor) {
        super(row, column, "Knight", pieceColor);

    }

    public void move(int co1, int co2) {
        this.setCurrentMove(this.getPieceName() + ": (" + this.getCol() + "," + this.getRow() + ") (" + co1 + "," + co2 + ")");
        try {

            if (co1 > 7 || co1 < 0 || co2 > 7 || co2 < 0) {
                throw new OutOfBoardException("Off of the board");
            } else if (Character.isUpperCase((ChessPiece.getBoardTile(co1, co2).charAt(1))) && Character.isUpperCase(this.getPieceType())) {
                throw new PathwayException("You have a piece set here");
            } else if (Character.isLowerCase(ChessPiece.getBoardTile(co1, co2).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                throw new PathwayException("You have a piece set here");
            } else if (Math.abs(this.getCol() - co2) == 2 && Math.abs(this.getRow() - co1) == 1) {
                if (board.getBoardTile(co1, co2).substring(1, 2).equals("K")) {
                    System.out.println(this.getCurrentMove() + "Valid Move");
                    System.out.println("GAME OVER THE KING IS DEAD White Wins");
                    System.out.println(board.toString());
                    System.exit(0);
                } else if (board.getBoardTile(co1, co2).substring(1, 2).equals("k")) {
                    System.out.println(this.getCurrentMove() + "Valid Move");
                    System.out.println("GAME OVER THE KING IS DEAD Black Wins");
                    System.out.println(board.toString());
                    System.exit(0);
                }
                this.setBoardLocation(co1, co2);
                System.out.println(this.getCurrentMove() + "Valid Move!");
            } else if (Math.abs(this.getCol() - co2) == 1 && Math.abs(this.getRow() - co1) == 2) {
                if (board.getBoardTile(co1, co2).substring(1, 2).equals("K")) {
                    System.out.println(this.getCurrentMove() + "Valid Move");
                    System.out.println("GAME OVER THE KING IS DEAD White Wins");
                    System.out.println(board.toString());
                    System.exit(0);
                } else if (board.getBoardTile(co1, co2).substring(1, 2).equals("k")) {
                    System.out.println(this.getCurrentMove() + "Valid Move");
                    System.out.println("GAME OVER THE KING IS DEAD Black Wins");
                    System.out.println(board.toString());
                    System.exit(0);
                }

                this.setBoardLocation(co1, co2);
                System.out.println(this.getCurrentMove() + "Valid Move!");
            } else {
                throw new IllegalMovementException("Invalid movement");
            }
        }

        catch(OutOfBoardException outBoard){
            System.out.println(this.getCurrentMove()+" "+outBoard.getMessage());
        }
        catch(PathwayException pathW){
            System.out.println(this.getCurrentMove()+" "+pathW.getMessage());
        }
        catch(IllegalMovementException illMove){
            System.out.println(this.getCurrentMove()+" "+illMove.getMessage());
        }
    }
}
