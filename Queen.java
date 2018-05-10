public class Queen extends ChessPiece {

    public Queen(int row, int column, String pieceColor) {
        super(row, column, "Queen", pieceColor);
    }

    public void move(int co1, int co2) {
        int diffx = Math.abs(this.getRow() - co1);
        int diffy = Math.abs(this.getCol() - co2);
        this.setCurrentMove(this.getPieceName() + ": (" + (this.getRow()) + "," + (this.getCol()) + ") (" + co1 + "," + co2 + ")");
        try {
            if (!ChessPiece.getBoardTile(co1, co2).equals("---")) {
                if (Character.isUpperCase((ChessPiece.getBoardTile(co1, co2).charAt(1))) && Character.isUpperCase(this.getPieceType())) {
                    throw new PathwayException("You have a piece set here");
                } else if (Character.isLowerCase(ChessPiece.getBoardTile(co1, co2).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    throw new PathwayException("You have a piece set here");
                } else {
                    System.out.println("ATTACKING");
                }
            }
            if (this.getPieceColor().equals("White")) {
                for (int i = getCol(); i < (co2 - 1); i++) {
                    if (!board.getBoardTile(co1, i + 1).equals("---")) {
                        throw new PathwayException("Piece in the way");
                    }
                }
            }
            if (this.getPieceColor().equals("Black")) {
                for (int g = getCol(); g > (co2 + 1); g--) {
                    if (!board.getBoardTile(co1, g - 1).equals("---")) {
                        throw new PathwayException("Piece in the way");
                    }
                }
            }
            if (this.getRow() < co1) {
                for (int k = getRow(); k < (co1 - 1); k++) {
                    if (!board.getBoardTile(k + 1, co2).equals("---")) {
                        throw new PathwayException("Piece in the way");
                    }
                }
            }
            if (this.getRow() > co1) {
                for (int x = getRow(); x > (co1 + 1); x--) {
                    if (!board.getBoardTile(x - 1, co2).equals("---")) {
                        throw new PathwayException("Piece in the way");
                    }
                }
            }
            if (co1 >= 8 || co1 < 0 || co2 >= 8 || co2 < 0) {
                throw new OutOfBoardException("Invalid move, off board");
            }
            if (!board.getBoardTile(co1, co2).equals("---")) {
                if (Character.isUpperCase((ChessPiece.getBoardTile(co1, co2).charAt(1))) && Character.isUpperCase(this.getPieceType())) {
                    throw new IllegalMovementException("That is your piece");
                } else if (Character.isLowerCase(ChessPiece.getBoardTile(co1, co2).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    throw new IllegalMovementException("That is your piece");
                }
            }

            if (co1 < 8 && co1 >= 0 && co2 == this.getCol()) {
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
                System.out.println(this.getCurrentMove() + "Valid Move");
             }
            if (co2 < 8 && co2 >= 0 && co1 == this.getRow()) {
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
                System.out.println(this.getCurrentMove() + "Valid Move");
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

            if (diffx - diffy == 0) {
                if (co1 > this.getRow() && co2 > this.getCol()) {
                    int temp = this.getCol();
                    for (int i = this.getRow(); i < co1; i++) {
                        if (!board.getBoardTile(i + 1, temp + 1).equals("---") && this.getPieceType() == ChessPiece.getBoardTile(co1, co2).charAt(1)){
                            throw new PathwayException("Piece in the way");
                        }
                        temp++;
                    }
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


            else{
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
