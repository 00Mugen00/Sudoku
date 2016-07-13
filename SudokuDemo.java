package prSudoku;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SudokuDemo {
	public static void main(String[] args) {
		SudokuView sudokuView = new SudokuPanel1();
		// Puzzle to solve. Can have more and pick one in random.
		int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, 
				{ 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, 
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
				{ 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, 
				{ 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		// Mask for puzzle should be generated randomly
		boolean[][] visibility = { { false, false, false, false, false, true, false, false, false },
				{ false, false, false, false, false, false, false, false, true },
				{ false, false, true, false, false, false, false, false, false },
				{ true, false, false, false, false, false, false, false, false },
				{ false, false, false, true, false, false, false, false, false },
				{ false, false, false, false, false, false, true, false, false },
				{ false, false, false, false, false, false, false, true, false },
				{ false, true, false, false, false, false, false, false, false },
				{ false, false, false, false, true, false, false, false, false } };
		Sudoku sudoku=new Sudoku(puzzle,visibility);
		sudokuView.makeSudokuBoard(sudoku);
		
		SudokuCtr sudokuCtr = new SudokuCtr(sudokuView);
		sudokuView.controller(sudokuCtr);
		
		JFrame window = new JFrame("Sudoku");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane((JPanel) sudokuView);
		window.pack();
		window.setVisible(true);
	}
}
