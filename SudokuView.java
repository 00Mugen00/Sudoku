package prSudoku;

import java.awt.event.ActionListener;

public interface SudokuView {
	String CHECK = "CHECK";
	void controller(ActionListener ctr);
	void makeSudokuBoard(Sudoku sudoku);
	void check();
}
