public class King extends ChessPiece {

    public King(int row, int column, String pieceColor) {
        super(row, column, "King", pieceColor);

    }

    public void move(int co1, int co2) {
        int diffx = this.getRow() - co1;
        int diffy = this.getCol() - co2;

        try {
            if (diffx == 1 || diffx == -1 || diffx == 0 && diffy == 1 || diffy == -1 || diffy == 0) {
                if(!board.getBoardTile(co1, co2).equals("---")){
                    if(board.getBoardTile(co1, co2).substring(1, 2).equals("K")){
                        System.out.println(this.getCurrentMove() + "Valid Move");
                        System.out.println("GAME OVER THE KING IS DEAD White Wins");
                        System.out.println(board.toString());
                        System.exit(0);
                    }
                    else if(board.getBoardTile(co1, co2).substring(1, 2).equals("k")){
                        System.out.println(this.getCurrentMove() + "Valid Move");
                        System.out.println("GAME OVER THE KING IS DEAD Black Wins");
                        System.out.println(board.toString());
                        System.exit(0);
                    }
                    if (Character.isUpperCase((ChessPiece.getBoardTile(co1, co2).charAt(1))) && Character.isUpperCase(this.getPieceType())){
                        throw new PathwayException("You have a piece set here");
                    }
                    else if(Character.isLowerCase(ChessPiece.getBoardTile(co1, co2).charAt(1)) && Character.isLowerCase(this.getPieceType())){
                        throw new PathwayException("You have a piece set here");
                    }
                }
                this.setBoardLocation(co1, co2);
                System.out.println(this.getCurrentMove() + "Valid Move");
            }
            else if (co1 > 7 || co1 < 0 || co2 > 7 || co2 < 0){
                throw new OutOfBoardException("Invalid move, off board");
            }
            else if(ChessPiece.getBoardTile(co1, co2)!="---"){
                throw new PathwayException("Chess Piece blocking move");
            }

            else {
                throw new IllegalMovementException("Invalid move");
            }


        } catch (OutOfBoardException outBoard) {
            System.out.println(board.toString());
            System.out.println(this.getCurrentMove() + " " + outBoard.getMessage());
        } catch (IllegalMovementException illMove) {
            System.out.println(this.getCurrentMove() + " " + illMove.getMessage());
        } catch (PathwayException pathW) {
            System.out.println(this.getCurrentMove() + " " + pathW.getMessage());
        }
    }
}

