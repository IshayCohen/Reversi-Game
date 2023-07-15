import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JPanel;


public class Cell extends JPanel {

	
	private int _i;// row
	private int _j; //column
	private boolean _isUsed; // empty cell or not.
	public LogicBoard.player _p; // the current player
	private Img _img;  //the image of the player
	private LinkedList<CellPressedListener> _lst; //list of listeners
	
	/**
	 * this is the class for the cell in the matrix.
	 * @param i = Row
	 * @param j = Column
	 */
	public Cell(int i,int j)
	{
		_i=i;
		_j=j;
		_p=LogicBoard.player.Yellow;
		_isUsed=false;
		_img = null;	
		_lst= new LinkedList<CellPressedListener> ();
		addMouseListener(new MouseAdapter()
		{
			
			public void mousePressed(MouseEvent e)
			{
				
				super.mousePressed(e);
				for(int k=0;k<_lst.size();k++){
					_lst.get(k).cellPressed(_i,_j);
				}
				
			}
		});
	}
	/**
	 * this method draws the board to have black and white "squares".
	 */
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		if(_img!=null)
			_img.drawImg(g);
		if((_i+_j)%2==0)
			setBackground(Color.black);
		else
			setBackground(Color.white);
	}

	public int get_i() {
		return _i;
	}

	public void set_i(int _i) {
		this._i = _i;
	}

	public int get_j() {
		return _j;
	}

	public void set_j(int _j) {
		this._j = _j;
	}

	public boolean is_isUsed() {
		return _isUsed;
	}

	public void set_isUsed(boolean _isUsed) {
		this._isUsed = _isUsed;
	}

	public LogicBoard.player get_p() {
		return _p;
	}

	public void set_c(LogicBoard.player _p) {
		this._p = _p;
	}
	
	/**
	 * this method sets the image in the cell.
	 */
	public void set_img()
	{
		if(!_isUsed)
			_img=null;
		else
			if(_p==LogicBoard.player.Yellow)
				_img=new Img("\\Images\\yellow64.png", 25, 30, 64, 64); 
			else
				_img=new Img("\\Images\\red64.png", 25, 30, 64,64); 
	}
	public void addCellPressedListener (CellPressedListener l)
	{
		_lst.add(l);
	}
	/**
	 * this method sets the cell to have the player color inside.
	 * @param isused = to see if the cell is empty or not.
	 * @param c = the player I want to put in the cell.
	 */
	public void setCell(boolean isused,LogicBoard.player c)
	{
		_isUsed=isused;
		_p=c;
		if(_p==LogicBoard.player.Yellow)
			_img=new Img("\\Images\\yellow64.png", 25, 30, 64, 64); 
		else
			_img=new Img("\\Images\\red64.png", 25, 30, 64,64);
		repaint();
	}
	

	
}
