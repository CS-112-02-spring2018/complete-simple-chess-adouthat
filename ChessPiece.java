import java.util.*;
public abstract class ChessPiece{
	private int row;
	private int column;
	private String name;
	private char pType;
	private String currentMove;
	private String pieceColor;
	public static ArrayList<ChessPiece> cPieces = new ArrayList<ChessPiece>();
	protected int countMoves;
	public static ChessBoard board = new ChessBoard();

	public ChessPiece(int row, int column, String name, String pieceColor){
		this.row = row;
		this.column = column;
		this.name = name;
		this.pieceColor = pieceColor;

		if(name.equalsIgnoreCase("knight")) {
			if (this.getPieceColor().equals("White")) {
				this.pType = 'h';
			} else if (this.getPieceColor().equals("Black")) {           //Making the display for the piece on the ArrayList
				this.pType = 'H';										//And displaying h if it is a knight
			}
		}
		else if(this.getPieceColor().equals("White")){
			this.pType = name.toLowerCase().charAt(0);
		}
		else if(this.getPieceColor().equals("Black")){
			this.pType = name.toUpperCase().charAt(0);
		}
		board.setBoardTile("-" + pType + "-", this.row, this.column);
		cPieces.add(this);
		countMoves = 0;

	}


	public int getRow(){
		return this.row;
	}

	public int getCol(){
		return this.column;
	}

	public String getCurrentMove(){
		return currentMove;
	}

	public void setCurrentMove(String currMove){
		this.currentMove = currMove;
	}

	public String getPieceName(){
		return this.name;
	}

	public String getPieceColor(){
		return pieceColor;
	}

	public char getPieceType(){
		return this.pType;
	}

	public static String getBoardTile(int row, int col){
		return board.getBoardTile(row, col);
	}

	public void setBoardLocation(int row, int col){
		board.setBoardTile("---", this.row, this.column);
		board.setBoardTile("-" + pType + "-", row, col);
		this.row = row;
		this.column = col;
	}

	public abstract void move(int co1, int co2);


}