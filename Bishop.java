public class Bishop extends ChessPiece {

	public Bishop(int row, int column, String pieceColor) {
		super(row, column, "Bishop", pieceColor);
	}

	public void move(int co1, int co2){
		int diffx = Math.abs(this.getRow() - co1);
		int diffy = Math.abs(this.getCol() - co2);
		this.setCurrentMove(this.getPieceName() + ": (" + (this.getRow()) + "," + (this.getCol()) + ") (" + co1 + "," + co2 + ")");

		try {

			if (diffx - diffy == 0) {
				if (co1 > this.getRow() && co2 > this.getCol()) {
					int temp = this.getCol();
					for (int i = this.getRow(); i < co1; i++) {
						if (!board.getBoardTile(i + 1, temp + 1).equals("---") && this.getPieceType() == ChessPiece.getBoardTile(co1, co2).charAt(1)){
							throw new PathwayException("Piece in the way");
						}
						temp++;
					}
					if (board.getBoardTile(co1, co2).substring(1, 2).equalsIgnoreCase("K")) {
						System.out.println(this.getCurrentMove() + "Valid Move");
						System.out.println("GAME OVER THE KING IS DEAD");
						System.out.println(board.toString());
						System.exit(0);
						this.setBoardLocation(co1, co2);
						System.out.println(this.getCurrentMove() + "Valid Move");
					}
					else{
						this.setBoardLocation(co1, co2);
						System.out.println(this.getCurrentMove() + "Valid Move");
					}
				}
			}

			if (diffx - diffy == 0) {
				if (co1 > this.getRow() && co2 < this.getCol()) {
					int temp = this.getCol();
					for (int i = this.getRow(); i < co1; i++) {
						if (!board.getBoardTile(i + 1, temp - 1).equals("---") && this.getPieceType() == ChessPiece.getBoardTile(co1, co2).charAt(1)){
							throw new PathwayException("Piece in the way");
						}
						temp--;
					}
					if (board.getBoardTile(co1, co2).substring(1, 2).equalsIgnoreCase("K")) {
						System.out.println(this.getCurrentMove() + "Valid Move");
						System.out.println("GAME OVER THE KING IS DEAD");
						System.out.println(board.toString());
						System.exit(0);
						this.setBoardLocation(co1, co2);
						System.out.println(this.getCurrentMove() + "Valid Move");
					}
					else{
						this.setBoardLocation(co1, co2);
						System.out.println(this.getCurrentMove() + "Valid Move");
					}
				}
			}

			if (diffx - diffy == 0) {
				if (co1 < this.getRow() && co2 > this.getCol()) {
					int temp = this.getCol();
					for (int i = this.getRow(); i > co1; i--) {
						if (!board.getBoardTile(i - 1, temp + 1).equals("---") && this.getPieceType() == ChessPiece.getBoardTile(co1, co2).charAt(1)){
							throw new PathwayException("Piece in the way");
						}
						temp++;
					}
					if (board.getBoardTile(co1, co2).substring(1, 2).equalsIgnoreCase("K")) {
						System.out.println(this.getCurrentMove() + "Valid Move");
						System.out.println("GAME OVER THE KING IS DEAD");
						System.out.println(board.toString());
						System.exit(0);
						this.setBoardLocation(co1, co2);
						System.out.println(this.getCurrentMove() + "Valid Move");
					}
					else{
						this.setBoardLocation(co1, co2);
						System.out.println(this.getCurrentMove() + "Valid Move");
					}
				}
			}
			if (diffx - diffy == 0) {
				if (co1 < this.getRow() && co2 < this.getCol()) {
					int temp = this.getCol();
					for (int i = this.getRow(); i > co1; i--) {
						if (!board.getBoardTile(i - 1, temp - 1).equals("---") && this.getPieceType() == ChessPiece.getBoardTile(co1, co2).charAt(1)){
							throw new PathwayException("Piece in the way");
						}
						temp--;
					}
					if (board.getBoardTile(co1, co2).substring(1, 2).equalsIgnoreCase("K")) {
						System.out.println(this.getCurrentMove() + "Valid Move");
						System.out.println("GAME OVER THE KING IS DEAD");
						System.out.println(board.toString());
						System.exit(0);
						this.setBoardLocation(co1, co2);
						System.out.println(this.getCurrentMove() + "Valid Move");
					}
					else{
						this.setBoardLocation(co1, co2);
						System.out.println(this.getCurrentMove() + "Valid Move");
					}
				}
			}
			if (!ChessPiece.getBoardTile(co1, co2).equals("---")) {
				if (Character.isUpperCase((ChessPiece.getBoardTile(co1, co2).charAt(1))) && Character.isUpperCase(this.getPieceType())) {
					throw new PathwayException("You have a piece set here");
				} else if (Character.isLowerCase(ChessPiece.getBoardTile(co1, co2).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
					throw new PathwayException("You have a piece set here");
				} else {
					System.out.println("ATTACKING");
				}
			}
			else if (co1 > 7 || co1 < 0 || co2 > 7 || co2 < 0) {
				throw new OutOfBoardException("Invalid move, off board");
			}
			else {
				throw new IllegalMovementException("Invalid movement");
			}

		}
      	catch(OutOfBoardException outBoard){
				System.out.println(board.toString());
				System.out.println(this.getCurrentMove() + " " + outBoard.getMessage());
			}
        catch(IllegalMovementException illMove){
				System.out.println(this.getCurrentMove() + " " + illMove.getMessage());
			}
        catch(PathwayException pathW){
				System.out.println(this.getCurrentMove() + " " + pathW.getMessage());
			}
		}
	}