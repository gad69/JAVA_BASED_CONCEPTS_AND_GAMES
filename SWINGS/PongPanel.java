package SWINGS;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
public class PongPanel extends JPanel implements ActionListener, KeyListener {
    public static Pong game;
    public boolean play=false;
    public Ball ball;
  Image image;
  private Timer timer;
    public Racket player1, player2;
    public int score1, score2;
    public Random random = new Random();
	 public static final float MIN_SAT = 0.5f;
    public PongPanel(Pong game) {
        setBackground(Color.BLACK);
        this.game = game;
        ball = new Ball(game);
        player1 = new Racket(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 36);
        player2 = new Racket(game, KeyEvent.VK_W, KeyEvent.VK_S, 20);
       timer= new Timer(5, this);
       timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public Racket getPlayer(int playerNo) {
        if (playerNo == 1)
            return player1;
        else
            return player2;
    }

    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            score1++;
        else
            score2++;
    }

    public int getScore(int playerNo) {
        if (playerNo == 1)
            return score1;
        else
            return score2;
    }

    private void update() {
        ball.update();
        player1.update();
        player2.update();
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
    	if(play==false) {
    		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
    		play=true;	
    		}
    		if(e.getKeyCode()==KeyEvent.VK_Q) {
    			System.exit(0);
        			
        		}
    		if(e.getKeyCode()==KeyEvent.VK_P) {
    			timer.stop();
        			
        		}
    		if(e.getKeyCode()==KeyEvent.VK_P) {
    			timer.start();
        			
        		}
    		
    		
    	}
        player1.pressed(e.getKeyCode());
        player2.pressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        player1.released(e.getKeyCode());
        player2.released(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(play==false) {
        	float hue = random.nextFloat();
            float saturation = MIN_SAT + random.nextFloat() * (1f - MIN_SAT);
            float brightness = MIN_SAT + random.nextFloat() * (1f - MIN_SAT);

            Color color = Color.getHSBColor(hue, saturation, brightness);
        	ImageIcon i = new ImageIcon("SWINGS/white.png");
        	image = i.getImage();
        	g.drawImage(image, 0, 0, null);
        g.setColor(color);
        
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("press space to play the game:",30,100);
        g.drawString("press Q to Quit the game:",30,200);
       }
        else {
        	ImageIcon i = new ImageIcon("SWINGS/white.png");
        	image = i.getImage();
        	g.drawImage(image, 0, 0, null);
        g.setFont(new Font("Arial",Font.BOLD,25));
        
        g.setColor(Color.black);
        g.drawString(game.getPanel().getScore(2) + "  " + game.getPanel().getScore(1), 328, 25);
        g.drawLine(350,0,350,450);
        g.drawOval(275, 150, 150, 150);
       
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
        }
    }  
}