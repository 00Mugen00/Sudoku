package prSudoku;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SudokuPanel1 extends JPanel implements SudokuView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField[][] tiles;
	private JLabel message;
	private JButton check;
	private int[][] puzzle;
	private boolean hasPuzzle;
	private static final String DEFAULT_STRING="";
	
	public SudokuPanel1(){
		tiles= new JTextField[9][9];
		puzzle = new int[9][9];
		message = new JLabel("No Puzzle");
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				tiles[i][j]=new JTextField(DEFAULT_STRING);
				tiles[i][j].setPreferredSize(new Dimension(30,30));
				puzzle[i][j]=0;
			}
		}
		
		BoardDesign();
		check = new JButton("CHECK");
		hasPuzzle=false;
		
		setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(9,9));
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				centerPanel.add(tiles[i][j]);
			}
		}
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2));
		southPanel.add(message);
		southPanel.add(check);
		
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
	}
	
	private void BoardDesign(){
		//Board Design
		for(int i=0; i<3; i++){
			for(int j=3;j<6;j++){
				if(!tiles[i][j].getBackground().equals(Color.cyan)){
					tiles[i][j].setBackground(Color.lightGray);
				}
				if(!tiles[j][i].getBackground().equals(Color.cyan)){
					tiles[j][i].setBackground(Color.lightGray);
				}
			}
		}
		for(int i=6; i<9; i++){
			for(int j=3; j<6;j++){
				if(!tiles[i][j].getBackground().equals(Color.cyan)){
					tiles[i][j].setBackground(Color.lightGray);
				}
				if(!tiles[j][i].getBackground().equals(Color.cyan)){
					tiles[j][i].setBackground(Color.lightGray);
				}
			}
		}		
	}
	
	public void controller(ActionListener ctr){
		check.addActionListener(ctr);
		check.setActionCommand(CHECK);
	}
	
	public void makeSudokuBoard(Sudoku sudoku){
		puzzle=sudoku.getPuzzle();
		boolean[][] visibility=sudoku.getVisibility();
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(visibility[i][j]==true){
					tiles[i][j].setText(Integer.toString(puzzle[i][j]));
					tiles[i][j].setEditable(false);
					tiles[i][j].setBackground(Color.cyan);
				}
			}
		}
		message.setText("Game In Progress");
		hasPuzzle=true;
	}

	public void check() {
		if(hasPuzzle){
			BoardDesign();
			boolean hasBeenSolved=true;
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					if(!tiles[i][j].getText().equals(DEFAULT_STRING)){
						if(!tiles[i][j].getText().equals(Integer.toString(puzzle[i][j]))){
							tiles[i][j].setForeground(Color.red);
						}else if(tiles[i][j].getText().equals(Integer.toString(puzzle[i][j]))&&!tiles[i][j].getBackground().equals(Color.cyan)){
							tiles[i][j].setForeground(Color.green);
						}
					}
					hasBeenSolved = hasBeenSolved && tiles[i][j].getText().equals(Integer.toString(puzzle[i][j]));
				}
			}
			
			if(hasBeenSolved){
				message.setText("Puzzle Solved");
			}
			
		}else{
			message.setText("No Puzzle to Check");
		}
	}
}
