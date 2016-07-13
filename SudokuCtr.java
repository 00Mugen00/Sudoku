package prSudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuCtr implements ActionListener{
	
	private SudokuView view;
	public SudokuCtr(SudokuView view){
		this.view=view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("CHECK")){
			view.check();
		}
	}
	
}
