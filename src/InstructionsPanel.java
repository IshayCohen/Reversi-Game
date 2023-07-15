import java.awt.Graphics;
import javax.swing.JPanel;
import Images.*;

public class InstructionsPanel extends JPanel {
	Img _img;

	/**
	 * img parameter is the image of the instructions. 
	 * The instructions are in the menu on the top left.
	 */
	public InstructionsPanel() 
	{
		_img = new Img("\\Images\\inst.png",0,0, 474, 570); 
	}

	@Override
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		_img.drawImg(g);
	}
}
