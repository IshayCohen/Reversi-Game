import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class GameFrame extends JFrame{

	
	private BoardPanel _p; 
	
	/**
	 * this class is for the menu on the top left in the game.
	 */
	
	public GameFrame()
	{
		_p = new BoardPanel();
		add(_p);
		buildMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1000);
		setVisible(true);
		

	}
	/**
	 * this method is for the restart in the menu, it uses the restart function. 
	 */
	public void restartGame()
	{
		_p.restart();
	}
	


	/**
	 * this method builds the menu on the top left
	 */
	private void buildMenu()
	{
		JMenuBar mb=new JMenuBar();
		JMenu file= new JMenu("Menu");
		mb.add(file);
		
		JMenuItem new_game = new JMenuItem("New Game");
		file.add(new_game);
		new_game.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				restartGame();
			}
		});
		
		JMenuItem instructions = new JMenuItem("Instructions");
		file.add(instructions);
		instructions.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				//InstructionsFrame ins_frame= new InstructionsFrame();
				InstructionsPanel ins = new InstructionsPanel();
				JFrame f = new JFrame();
				f.add(ins);
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setSize(445,600);
				f.setResizable(false);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		exit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		
		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		GameFrame g=new GameFrame();
	}
}
