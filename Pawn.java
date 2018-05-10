public class Pawn extends ChessPiece{

	public Pawn(int row, int column, String pieceColor){
	    super(row, column, "Pawn", pieceColor);
	}

	public void move(int co1, int co2){
        System.out.println(countMoves);
        boolean attack = false;
 		this.setCurrentMove(this.getPieceName()+": ("+(this.getRow())+","+(this.getCol())+") ("+co1+","+co2+")");		
		try{

            if(this.getPieceColor().equals("White")){
                for(int i = getCol();i < (co2 - 1);i++){
                    if (!board.getBoardTile(co1, i + 1).equals("---")) {
                        throw new PathwayException("Piece in the way");
                    }
                }
            }
            else if(this.getPieceColor().equals("Black")){
			    for(int g = getCol();g > (co2 + 1);g--){
                    if (!board.getBoardTile(co1, g - 1).equals("---")) {
			            throw new PathwayException("Piece in the way");
                    }
                }
            }

            if(ChessPiece.getBoardTile(co1, co2)!="---") {
                if (Character.isUpperCase((ChessPiece.getBoardTile(co1, co2).charAt(1))) && Character.isUpperCase(this.getPieceType())){
                    throw new PathwayException("You have a piece set here");
                }
                else if(Character.isLowerCase(ChessPiece.getBoardTile(co1, co2).charAt(1)) && Character.isLowerCase(this.getPieceType())){
                    throw new PathwayException("You have a piece set here");
                }
                else{
                    System.out.println("ATTACKING");
                    if(this.getPieceColor().equalsIgnoreCase("white") && (this.getCol() + 1 == co2) && (this.getRow() + 1 == co1))
                        {
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
                            this.setBoardLocation(co1, co2);
                            System.out.println(this.getCurrentMove() + "Valid Move!");
                        countMoves++;
                    }
                    else if(this.getPieceColor().equalsIgnoreCase("white") && (this.getCol() + 1 == co2) && (this.getRow() - 1 == co1))
                    {
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
                        this.setBoardLocation(co1, co2);
                        System.out.println(this.getCurrentMove() + "Valid Move!");
                        countMoves++;
                    }
                    else if(this.getPieceColor().equalsIgnoreCase("black") && (this.getCol() -1 == co2) && (this.getRow() - 1 == co1))
                    {
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
                        this.setBoardLocation(co1,co2);
                        System.out.println(this.getCurrentMove() + "Valid Move!");
                        countMoves++;
                    }
                    else if(getPieceColor().equalsIgnoreCase("black") && (this.getCol() - 1 == co2) && (this.getRow() + 1 == co1))
                    {
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
                        this.setBoardLocation(co1, co2);
                        System.out.println(this.getCurrentMove() + "Valid Move!");
                        countMoves++;
                    }
                }
            }

            else if(ChessPiece.getBoardTile(co1, co2)==("---")) {
                if(this.getRow() != co1){
                    throw new IllegalMovementException("Trying to shift rows");
                }
                if (countMoves == 0 && (this.getCol() + 2 == co2)) {
                    this.setBoardLocation(co1, co2);
                    System.out.println(this.getCurrentMove() + "Valid Move");
                    countMoves++;
                } else if (countMoves >= 0 && this.getCol() + 1 == co2) {
                    this.setBoardLocation(co1, co2);
                    System.out.println(this.getCurrentMove() + "Valid Move");
                    countMoves++;
                } else if (countMoves == 0 && (this.getCol() - 2 == co2)) {
                    this.setBoardLocation(co1, co2);
                    System.out.println(this.getCurrentMove() + "Valid Move");
                    countMoves++;
                } else if (countMoves >= 0 && this.getCol() - 1 == co2) {
                    this.setBoardLocation(co1, co2);
                    System.out.println(this.getCurrentMove() + "Valid Move");
                    countMoves++;
                }
            }

            else if (co1 > 8 || co1 < 0 || co2 > 8 || co2 < 0) {
                throw new OutOfBoardException("Invalid move, off board");
            }

            else{
                throw new IllegalMovementException("Invalid movement");
            }
        }
        catch(OutOfBoardException outBoard) {
            System.out.println(board.toString());
            System.out.println(this.getCurrentMove()+" "+outBoard.getMessage());
        }
        catch(IllegalMovementException illMove){
            System.out.println(this.getCurrentMove()+" "+illMove.getMessage());
        }
        catch(PathwayException pathW){
            System.out.println(this.getCurrentMove()+" "+pathW.getMessage());
        }
    }
}