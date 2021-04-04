
package SWINGS;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class BRK extends JFrame implements KeyListener  {	
	public BRK() {
	        UIManager UI=new UIManager();
	        UI.put("OptionPane.background", Color.GREEN);
	        UI.put("Panel.background", Color.orange);
	        JOptionPane.showMessageDialog(this,"Hello Welcome to DISTRUCTOID\t\t\t\t\t\t\t\nThe rules for the game \n1)use the left and the right arrows for sliding the platform and Hit each brick to get 5 points\nand HIT all the bricks to WIN the game\n the speed of the ball depends on the level u select\n\n\n2)higher the level yo select higher the speed of the ball and increse in no of bricks\n\n\n\n3)platform size decreses with respect to score\n\n\n4) As the level increses there will be increse in no of bricks\nLEVEL 1 -> 60 bricks \n LEVEL 2 -> 80 \n LEVEL 3 -> 100\n\n\n\n\n");
	        String name=JOptionPane.showInputDialog(this,"Enter the player name\n\n\n\n\n");
	        GamePlay gamePlay = new GamePlay(name);
	       setBounds(10, 10, 700, 600);
	        setTitle("Brick Breaker");
	     setResizable(false);
	       setVisible(true);
	       setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	       addKeyListener(this);
	       add(gamePlay);
	}

	public void keyPressed(KeyEvent e) {
		 if(e.getKeyCode() == KeyEvent.VK_ALT){
			 this.dispose();
			 
			 
		 }
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}



