package prSudoku;

public class Sudoku {
	private int[][] puzzle;
	private boolean[][] visibility;
	public Sudoku(int[][] puzzle,boolean[][] visibility){
		this.puzzle=puzzle;
		this.visibility=visibility;
	}
	public int[][] getPuzzle(){
		return puzzle;
	}
	public boolean[][] getVisibility(){
		return visibility;
	}
}
