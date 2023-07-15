import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class BoardPanel extends JPanel implements CellPressedListener{

	private Cell [][] _mat;
	private Player _p;

	/**
	 * this is the class of the board panel, it has a cell matrix and a player type.
	 * The constructor builds the matrix to it's start, so 4 players in the middle.
	 * (2 of each color).
	 * The class implements the CellPressedListener interface so the cells can "listen" to each other.
	 */
	public BoardPanel()
	{
		_p=new Player(LogicBoard.player.Yellow);
		setLayout(new GridLayout(8,8));
		_mat=new Cell[8][8];
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				_mat[i][j]= new Cell(i,j);
				add(_mat[i][j]);
				_mat[i][j].addCellPressedListener(this);
				if(i==j&&i==3 ||i==j&&i==4 ){
					_mat[i][j].set_isUsed(true);
					_mat[i][j].set_c(LogicBoard.player.Yellow);
					_mat[i][j].set_img();
				}
				if(i==4&&j==3 || i==3 && j==4){
					_mat[i][j].set_isUsed(true);
					_mat[i][j].set_c(LogicBoard.player.Red);
					_mat[i][j].set_img();
				}
			} 

	}

	/**
	 * this method is implementing the cellPressed method from the interface.
	 */
	@Override
	public void cellPressed(int i, int j) {
		// TODO Auto-generated method stub
		
		if(LogicBoard.getInstance().isEmpty(i, j) && LogicBoard.getInstance().isPossibleToPut(i,j,_p.getPlayer()))
		{
			
			LogicBoard.getInstance().setPlayer(i, j, _p.getPlayer());
			_mat[i][j].setCell(true, _p.getPlayer());
			LinkedList<Integer> list=LogicBoard.getInstance().changeBetween(i, j, _p.getPlayer());
			LogicBoard.getInstance().changeList(list, _p.getPlayer());
			for(int k=0;k<list.size();k++)
				_mat[list.get(k)/8][list.get(k)%8].setCell(true,_p.getPlayer());
			_p.changePlayer();
		}
	}
	/**
	 * this method restarts the game and puts it back to it's starting point.
	 * The yellow player always starts first.
	 */
	public void restart()
	{
		for(int i=0;i<8;i++)
		for(int j=0;j<8;j++)
		{
			_mat[i][j].addCellPressedListener(this);
			if(i==j&&i==3 ||i==j&&i==4){
				_mat[i][j].set_isUsed(true);
				_mat[i][j].set_c(LogicBoard.player.Yellow);
				_mat[i][j].set_img();
			}
			else if(i==4&&j==3 || i==3 && j==4){
				_mat[i][j].set_isUsed(true);
				_mat[i][j].set_c(LogicBoard.player.Red);
				_mat[i][j].set_img();
			}
			else
			{	_mat[i][j].set_isUsed(false);
				_mat[i][j].set_c(LogicBoard.player.Empty);
				_mat[i][j].set_img();
			}
		}
		if(_p.getPlayer()==LogicBoard.player.Red)
			_p.changePlayer();
		LogicBoard.getInstance().restart();
		repaint();
	}

}
