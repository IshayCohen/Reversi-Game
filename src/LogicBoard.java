import java.util.LinkedList;


public class LogicBoard {

	public enum player{Yellow,Red,Empty};
	private player _mat[][];
	private final static LogicBoard INSTANCE = new LogicBoard();
	
	/**
	 *  player = this parameter holds the player Color (Yellow,Red,Empty)
	 *  mat = this parameter holds the player  8*8 matrix (each cell is player type)
	 *  INSTANCE = the static parameter for the logicboard which can be used anywhere.
	 */

	
	
	/**
	 *  This method initializes the matrix and puts 4 "players" in the middle of the matrix.
	 */
	private LogicBoard()
	{
		_mat=new player[8][8];
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				_mat[i][j]=player.Empty;
				if(i==4&&j==3 || i==3 && j==4)
					_mat[i][j]=player.Red;
				if(i==j&&i==3 ||i==j&&i==4)
					_mat[i][j]=player.Yellow;
			}
	}
	
	/**
	 * 
	 * @return the logicboard
	 */
	public static LogicBoard getInstance() 
	{
		return INSTANCE;
	}
	/**
	 * 
	 * @return the player's matrix
	 */
	public player[][] getMat()
	{
		return _mat;
	}
	/**
	 * This method sets a player color in a cell
	 * @param i = Row
	 * @param j = Column
	 * @param p = Player type
	 */
	public void setPlayer(int i,int j,player p)
	{
		_mat[i][j]=p;
	}
	/**
	 * this method returns the player in the cell i,j
	 * @param i = Row
	 * @param j = Column
	 * @return the player in the cell i,j
	 */
	public player getPlayer(int i,int j)
	{
		return _mat[i][j];
	}
	/**
	 * This method checks if a cell is empty
	 * @param i = Row
	 * @param j = Column
	 * @return true if empty, else false.
	 */
	public boolean isEmpty(int i,int j)
	{
		if(_mat[i][j]==player.Empty)
			return true;
		return false;
	}
	/**
	 *  This method checks if it's  possible to put a player in a cell. (according to the rules).
	 * @param i = Row
	 * @param j = Column
	 * @param p = what type of player I want to put in the cell
	 * @return true if it's possible to put a player there, else false.
	 */
	public boolean isPossibleToPut(int i,int j,player p)
	{

		//J is to run on the ROWS.
		//I is to run on the COLS.

		boolean flag=false;// true if i found different color else false.
		int index=1; // index is to help check the DIAGONALS

		//ROWS
		//this for is to check rows TOWARDS RIGHT (so I can put my color on LEFT)
		for(int J=j+1;J<8;J++)
		{
			if(_mat[i][J]!=p && _mat[i][J]!=player.Empty) // if not my color && not empty cell
				flag=true;

			else if ((flag==true)&&(_mat[i][J]!=p)&& _mat[i][J]!=player.Empty) // if i found not my color and it is still not mine
				flag=true;

			else if((flag==true)&&(_mat[i][J]==p)) // if i found not my color and now it's mine
				return true;

			else if(_mat[i][J]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		//this for is to check rows TOWARDS LEFT (so I can put my color on RIGHT)

		for(int J=j-1;J>-1;J--)
		{
			if(_mat[i][J]!=p && _mat[i][J]!=player.Empty) // if not my color && not empty cell
				flag=true;

			else if ((flag==true)&&(_mat[i][J]!=p)&& _mat[i][J]!=player.Empty) // if i found not my color and it is still not mine
				flag=true;

			else if((flag==true)&&(_mat[i][J]==p)) // if i found not my color and now it's mine
				return true;

			else if(_mat[i][J]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		//COLS
		//this for is to check COLS TOWARDS BOTTOM (so I can put my color on TOP)

		for(int I=i+1;I<8;I++)
		{
			if(_mat[I][j]!=p && _mat[I][j]!=player.Empty)// if not my color && not empty cell
				flag=true;

			else if ((flag==true)&&(_mat[I][j]!=p)&& _mat[I][j]!=player.Empty) // if i found not my color and it is still not mine
				flag=true;

			else if((flag==true)&&(_mat[I][j]==p)) // if i found not my color and now it's mine
				return true;

			else if(_mat[I][j]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		//this for is to check COLS TOWARDS TOP (so I can put my color on BOTTOM)
		for(int I=i-1;I>-1;I--)
		{
			if(_mat[I][j]!=p && _mat[I][j]!=player.Empty) // if not my color && not empty cell
				flag=true;


			else if ((flag==true)&&(_mat[I][j]!=p)&& _mat[I][j]!=player.Empty)
				// if i found not my color and it is still not mine
				flag=true;	


			else if((flag==true)&&(_mat[I][j]==p)) // if i found not my color and now it's mine		
				return true;


			else if(_mat[I][j]==player.Empty) // if all of that and it's still nothing 
				break;	
			else  
				break;
		}
		flag=false;
		//DIAGONALS 
		//
		for(index=1;index<8;index++)
		{
			if(!(i-index>=0 && i-index<8 && j-index>=0 && j-index<8))
				break;

			if(_mat[i-index][j-index]!=p && _mat[i-index][j-index]!=player.Empty) // if not my color && not empty cell
				flag=true;

			else if ((flag==true)&&(_mat[i-index][j-index]!=p)&& (_mat[i-index][j-index]!=player.Empty)) // if i found not my color and it is still not mine
				flag=true;

			else if((flag==true)&&(_mat[i-index][j-index]==p)) // if i found not my color and now it's mine
				return true;

			else if(_mat[i-index][j-index]==player.Empty)
				// if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		for(index=1;index<8;index++)
		{
			if(!(i-index>=0 && i-index<8 && j+index>=0 && j+index<8))
				break;

			if(_mat[i-index][j+index]!=p && _mat[i-index][j+index]!=player.Empty) // if not my color && not empty cell
				flag=true;

			else if ((flag==true)&&(_mat[i-index][j+index]!=p)&& (_mat[i-index][j+index]!=player.Empty)) // if i found not my color and it is still not mine
				flag=true;

			else if((flag==true)&&(_mat[i-index][j+index]==p)) // if i found not my color and now it's mine
				return true;

			else if(_mat[i-index][j+index]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		for(index=1;index<8;index++)
		{

			if(!(i+index>=0 && i+index<8 && j+index>=0 && j+index<8))
				break;

			if(_mat[i+index][j+index]!=p && _mat[i+index][j+index]!=player.Empty)// if not my color && not empty cell
				flag=true;

			else if ((flag==true)&&(_mat[i+index][j+index]!=p)&& (_mat[i+index][j+index]!=player.Empty)) // if i found not my color and it is still not mine
				flag=true;

			else if((flag==true)&&(_mat[i+index][j+index]==p)) // if i found not my color and now it's mine
				return true;

			else if(_mat[i+index][j+index]==player.Empty)
				// if all of that and it's still nothing 	
				break;
			else  
				break;
		}
		flag=false;
		for(index=1;index<8;index++)
		{

			if(!(i+index>=0 && i+index<8 && j-index>=0 && j-index<8)) 
				break;

			if(_mat[i+index][j-index]!=p && _mat[i+index][j-index]!=player.Empty) // if not my color && not empty cell
				flag=true;


			else if ((flag==true)&&(_mat[i+index][j-index]!=p) && (_mat[i+index][j-index]!=player.Empty))// if i found not my color and it is still not mine
				flag=true;

			else if((flag==true)&&(_mat[i+index][j-index]==p)) // if i found not my color and now it's mine
				return true;

			else if(_mat[i+index][j-index]==player.Empty)
				// if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		return false;

	}


	//***************************************changeBetween Method*********************************************

/**
 * This method creates and returns a list of cells that should change to a certain player.
 * @param i = Row
 * @param j = Column
 * @param p = indicates the player
 * @return the list of the players that should change because a player was put
 */
	public LinkedList<Integer> changeBetween(int i,int j,player p)
	{
		int index;
		boolean flag=false;
		LinkedList<Integer> lst=new LinkedList<Integer>(); // the list that will return
		LinkedList<Integer> lst2=new LinkedList<Integer>(); // temp list that helps the list that should return.
		for(int J=j+1;J<8;J++)
		{
			if(_mat[i][J]!=p && _mat[i][J]!=player.Empty)
			{ // if not my color && not empty cell
				flag=true;
				lst2.add(i*8+J);
			}
			else if ((flag==true)&&(_mat[i][J]!=p) && _mat[i][J]!=player.Empty)
			{ // if i found not my color and it is still not mine
				flag=true;	
				lst2.add(i*8+J);

			}
			else if((flag==true)&&(_mat[i][J]==p)) // if i found not my color and now it's mine
			{
				for(int m=0;m<lst2.size();m++){
					lst.add(lst2.get(m));
					//System.out.println("adding1:  " +lst2.get(m));
				}
				lst2.clear();
				break;
			}
			else if(_mat[i][J]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		lst2.clear();
		//this for is to check rows TOWARDS LEFT (so I can put my color on RIGHT)
		for(int J=j-1;J>-1;J--)
		{
			if(_mat[i][J]!=p && _mat[i][J]!=player.Empty)
			{ // if not my color && not empty cell
				flag=true;
				lst2.add(i*8+J);
			}
			else if ((flag==true)&&(_mat[i][J]!=p) && _mat[i][J]!=player.Empty)
			{ // if i found not my color and it is still not mine
				flag=true;
				lst2.add(i*8+J);
			}
			else if((flag==true)&&(_mat[i][J]==p))
			{// if i found not my color and now it's mine
				for(int m=0;m<lst2.size();m++)
				{
					lst.add(lst2.get(m));
					//System.out.println("adding2:  " +lst2.get(m));
				}
				lst2.clear();
				break;
			}
			else if(_mat[i][J]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		lst2.clear();
		//COLS
		//this for is to check COLS TOWARDS BOTTOM (so I can put my color on TOP)
		for(int I=i+1;I<8;I++)
		{
			if(_mat[I][j]!=p && _mat[I][j]!=player.Empty)
			{ // if not my color && not empty cell
				flag=true;
				lst2.add(I*8+j);
			}
			else if ((flag==true)&&(_mat[I][j]!=p) && _mat[I][j]!=player.Empty)
			{ // if i found not my color and it is still not mine
				flag=true;
				lst2.add(I*8+j);
			}
			else if((flag==true)&&(_mat[I][j]==p))
			{// if i found not my color and now it's mine
				for(int m=0;m<lst2.size();m++)
				{
					lst.add(lst2.get(m));
					//System.out.println("adding3:  " +lst2.get(m));
				}
				lst2.clear();
				break;
			}

			else if(_mat[I][j]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}

		//this for is to check COLS TOWARDS TOP (so I can put my color on BOTTOM)
		flag=false;
		lst2.clear();
		for(int I=i-1;I>-1;I--)
		{
			if(_mat[I][j]!=p && _mat[I][j]!=player.Empty)
			{ // if not my color && not empty cell
				flag=true;
				lst2.add(I*8+j);
			}
			else if ((flag==true)&&(_mat[I][j]!=p) && _mat[I][j]!=player.Empty)
			{ // if i found not my color and it is still not mine
				flag=true;
				lst2.add(I*8+j);
			}
			else if((flag==true)&&(_mat[I][j]==p))
			{ // if i found not my color and now it's mine
				for(int m=0;m<lst2.size();m++)
				{
					lst.add(lst2.get(m));
					//System.out.println("adding4:  " +lst2.get(m));
				}
				lst2.clear();
				break;
			}
			else if(_mat[I][j]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		lst2.clear();
		//DIAGONALS 
		//
		for(index=1;index<8;index++)
		{
			//System.out.println("I = "+i+ "  j = "+j);
			if(!(i-index>=0 && i-index<8 && j-index>=0 && j-index<8))
				break;
			if(_mat[i-index][j-index]!=p && _mat[i-index][j-index]!=player.Empty) {// if not my color && not empty cell
				flag=true;
				lst2.add((i-index)*8+(j-index));

			}
			else if ((flag==true)&&(_mat[i-index][j-index]!=p) && (_mat[i-index][j-index]!=player.Empty))
			{ // if i found not my color and it is still not mine
				flag=true;
				lst2.add((i-index)*8+(j-index));
			}
			else if((flag==true)&&(_mat[i-index][j-index]==p))
			{ // if i found not my color and now it's mine
				for(int m=0;m<lst2.size();m++)
				{
					lst.add(lst2.get(m));
					//System.out.println("adding5:  " +lst2.get(m));
				}
				lst2.clear();
				break;
			}
			else if(_mat[i-index][j-index]==player.Empty)
			{
				// if all of that and it's still nothing 
				break;
			}
			else  
				break;
		}
		flag=false;
		lst2.clear();
		for(index=1;index<8;index++)
		{
			if(!(i-index>=0 && i-index<8 && j+index>=0 && j+index<8))
				break;
			if(_mat[i-index][j+index]!=p && _mat[i-index][j+index]!=player.Empty)
			{ // if not my color && not empty cell
				flag=true;
				lst2.add((i-index)*8+(j+index));
			}
			else if ((flag==true)&&(_mat[i-index][j+index]!=p)&& (_mat[i-index][j+index]!=player.Empty)){ // if i found not my color and it is still not mine
				flag=true;
				lst2.add((i-index)*8+(j+index));
			}
			else if((flag==true)&&(_mat[i-index][j+index]==p))
			{ // if i found not my color and now it's mine
				for(int m=0;m<lst2.size();m++)
				{
					lst.add(lst2.get(m));
					//System.out.println("adding6:  " +lst2.get(m));
				}
				lst2.clear();
				break;
			}
			else if(_mat[i-index][j+index]==player.Empty) // if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		lst2.clear();
		for(index=1;index<8;index++)
		{
			//System.out.println("I = "+i+ "  j = "+j);
			if(!(i+index>=0 && i+index<8 && j+index>=0 && j+index<8))
				break;
			if(_mat[i+index][j+index]!=p && _mat[i+index][j+index]!=player.Empty) {// if not my color && not empty cell
				flag=true;
				lst2.add((i+index)*8+(j+index));

			}
			else if ((flag==true)&&(_mat[i+index][j+index]!=p)&& _mat[i+index][j+index]!=player.Empty){ // if i found not my color and it is still not mine
				flag=true;
				lst2.add((i+index)*8+(j+index));

			}
			else if((flag==true)&&(_mat[i+index][j+index]==p)){ // if i found not my color and now it's mine
				for(int m=0;m<lst2.size();m++)
				{
					lst.add(lst2.get(m));
					//System.out.println("adding7:  " +lst2.get(m));
				}
				lst2.clear();
				break;
			}
			else if(_mat[i+index][j+index]==player.Empty)
				// if all of that and it's still nothing 
				break;
			else  
				break;
		}
		flag=false;
		lst2.clear();
		for(index=1;index<8;index++)
		{
			//System.out.println("I = "+i+ "  j = "+j);
			if(!(i+index>=0 && i+index<8 && j-index>=0 && j-index<8))
			{

				break;
			}
			if(_mat[i+index][j-index]!=p && _mat[i+index][j-index]!=player.Empty)
			{// if not my color && not empty cell
				flag=true;
				lst2.add((i+index)*8+(j-index));

			}
			else if ((flag==true)&&(_mat[i+index][j-index]!=p)&& (_mat[i+index][j-index]!=player.Empty))
			{ // if i found not my color and it is still not mine
				flag=true;
				lst2.add((i+index)*8+(j-index));

			}
			else if((flag==true)&&(_mat[i+index][j-index]==p))
			{ // if i found not my color and now it's mine
				for(int m=0;m<lst2.size();m++)
				{
					lst.add(lst2.get(m));
					//System.out.println("adding8:  " +lst2.get(m));
				}
				lst2.clear();
				break;
			}
			else if(_mat[i+index][j-index]==player.Empty){
				// if all of that and it's still nothing 
				break;
			}
			else  
				break;
		}
		lst2.clear();
		return lst;
	}
	
	/**
	 * This method changes the cells in the list to the player.
	 * @param list = the list that has the cells that should be swapped to the player.
	 * @param p = the player that the cells in the list should swap to.
	 */
	public void changeList(LinkedList<Integer> list,player p) // This function changes the color in the selected cells.
	{
		for(int k=0;k<list.size();k++){
			_mat[list.get(k)/8][list.get(k)%8] = p;
		}
	}
	/**
	 * A method that restarts the game.
	 */
	public void restart()
	{
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				_mat[i][j]=player.Empty;
				if(i==4&&j==3 || i==3 && j==4)
					_mat[i][j]=player.Red;
				else if(i==j&&i==3 ||i==j&&i==4)
					_mat[i][j]=player.Yellow;
				else
					_mat[i][j]=player.Empty;

			}

	}
}