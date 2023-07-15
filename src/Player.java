
public class Player {

	private LogicBoard.player _p; 
	
	/**
	 * 
	 * @param p = a Logicboard parameter that holds the player Color (Yellow,Red,Empty).
	 */
	public Player(LogicBoard.player p)
	{
		_p=p;
	}
	public LogicBoard.player getPlayer(){
		return _p;
	}
	
	/**
	 *  A method that changes the current player to the other Color.
	 */
	public void changePlayer()
	{
		if(_p==LogicBoard.player.Red)
			_p=LogicBoard.player.Yellow;
		else
			_p=LogicBoard.player.Red;
	}
}
