package SWINGS;
import java.awt.Color;
import java.util.Random;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePlay extends JPanel implements KeyListener, ActionListener {
	
    private boolean play = false;
    public int score = 0;
    public int  score1  = 0;
    public int  score2  = 0;
    public int  score3  = 0;

    private int totalBricks = 60;

    private Timer timer;
    private int delay;

    private int playerX = 300;
    private int a = 0;
    private int abc = -50;
    private int xyz = -50;
    private int ballPosX = 290;
    private int ballPosY = 350;
    private int ballPosX1 = 390;
    private int ballPosY1 = 350;
    private int ballDirX ;
    private int ballDirY ;
    private int ballDirX1 ;
    private int ballDirY1 ;
     public Image image;
    private BrickGenerator mapPlay;
	protected String name;
	public int lives = 3;
	private int pshape;
	int v = 2;
	private Random random = new Random();
	 private static final float MIN_SAT = 0.5f;
    public GamePlay(String name) {
    	
    	
        mapPlay = new BrickGenerator(8, 10);
        

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        
        timer.start();
       this.name = name;
    }

    public GamePlay() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void paint(Graphics graphics) {
    	float hue = random.nextFloat();
        float saturation = MIN_SAT + random.nextFloat() * (1f - MIN_SAT);
        float brightness = MIN_SAT + random.nextFloat() * (1f - MIN_SAT);

        Color color = Color.getHSBColor(hue, saturation, brightness);
       
        graphics.setColor(Color.darkGray);
        graphics.fillRect(1, 1, 692, 592);

       
        mapPlay.draw((Graphics2D) graphics, color);

        //border
        graphics.setColor(color);
        graphics.fillRect(0, 0, 3, 592);
        graphics.fillRect(0, 0, 692, 3);
        graphics.fillRect(691, 1, 3, 592);

        //score
        graphics.setColor(Color.white);
        graphics.setFont(new Font("serif", Font.BOLD, 11));
        
        graphics.drawString("Score: " + score + "/500", 550, 40);
        graphics.drawString("player: " + name, 550, 28);
        		                                        
        graphics.drawString("Lives: " + lives + "/3", 550, 15);
        


       
        if(a>0){
        	graphics.setColor(color);
        	
        	
        	ImageIcon i = new ImageIcon("SWINGS/dis.gif");
        	image = i.getImage();
        	graphics.drawImage(image, abc-150, xyz-40, null);
        	
        }
        if (play == false) {
        	lives = 3;
        	ImageIcon i = new ImageIcon("SWINGS/Al.png");
        	image = i.getImage();
        	graphics.drawImage(image, 0, 0, null);
            //game start message
            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
            graphics.drawString("Press S to Resume  the game", 250, 250);
            graphics.drawString("Press p to Pause the game ", 250, 300);
            graphics.drawString("Press Q to quit the game", 250, 350);
            graphics.drawString("Press A to play level 1!", 250, 400);
            
            graphics.drawString("Press B to play level 2!", 250, 450);
            graphics.drawString("Press C to play level 3!", 250, 500);
            graphics.drawString("Press H for High Score Information", 250, 550);
            
            //ball hiding
            graphics.setColor(Color.black);
            graphics.fillOval(ballPosX, ballPosY, 20, 20);
            graphics.fillOval(ballPosX1, ballPosY1, 20, 20);
            graphics.fillRect(playerX, 550,pshape, 8);
           
            
        } 
        
        else {

        	
            //ball showing
        	graphics.setColor(color);
            graphics.fillOval(ballPosX, ballPosY, 20, 20);
           
        }
        if(score<=50){
        
        	 pshape = 200;
        	 
        	 graphics.fillRect(playerX, 550,pshape, 8);
        	
        }

        if (score > 50 && score < 100) {
            //ball color & size change
        	graphics.setColor(color);
            graphics.fillOval(ballPosX, ballPosY, 21, 21);
            pshape = 150;
            graphics.fillRect(playerX, 550,pshape, 8);
            graphics.fillOval(ballPosX1, ballPosY1, 20, 20);
        }
            
          
            
          if (score >= 100 && score < 150) {
            //ball
        	  graphics.setColor(color);
            
            graphics.fillOval(ballPosX, ballPosY, 22, 22);
            pshape = 100;
            graphics.fillRect(playerX, 550,pshape, 8);
           
        }  
        if (score >= 150) {
            //ball
           
            graphics.fillOval(ballPosX, ballPosY, 23, 23);
            pshape = 50;
            graphics.fillRect(playerX, 550,pshape, 8);
            graphics.fillOval(ballPosX1, ballPosY1, 20, 20);
           
        }
      
        

        if (totalBricks <= 0) {
        	Highscore();
            play = false;
            ballDirX = 0;
            ballDirY = 0;

            //hiding the ball after game over
            graphics.setColor(Color.black);
            graphics.fillOval(ballPosX, ballPosY, 23, 23);

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("serif", Font.BOLD, 30));
            graphics.drawString("You Win! Score: " + score, 200, 300);

            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("serif", Font.BOLD, 20));
           

            //above score hiding
            graphics.setColor(Color.black);
            graphics.setFont(new Font("serif", Font.BOLD, 11));
            graphics.drawString("Score: " + score + "/500", 550, 30);
            graphics.drawString("Lives: " + lives + "/3", 550, 20);

            //hide remains bricks
            mapPlay.draw((Graphics2D) graphics, Color.BLACK);

            //paddle
            graphics.setColor(Color.black);
            graphics.fillRect(playerX, 550, 100, 8);

            //game start message
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
            graphics.drawString("Press Enter/Left/Right Arrow to start the game!", 90, 350);
        }
        if (ballPosY > 570) { // if ball fall in down
       	 ballPosX = playerX;
       	 ballPosY = 520;
       	 ballPosX = playerX+20;
       	 ballPosY = 520;
       	 
       	
       	 lives = lives - 1;
           
       }
       

        if (lives< 1) { // if ball fall in down
        	Highscore();
            ballDirX = 0;
            ballDirY = 0;
            ballDirX1 = 0;
            ballDirY1 = 0;

            //hiding the ball after game over
            graphics.setColor(Color.black);
            graphics.fillOval(ballPosX, ballPosY, 23, 23);
            graphics.fillOval(ballPosX1, ballPosY1, 20, 20);
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("serif", Font.BOLD, 11));
            graphics.drawString("Game over! Score: " + score, 200, 300);

            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("serif", Font.BOLD, 20));
            graphics.drawString("Press Enter to Restart..", 230, 330);

            //above score hiding
            graphics.setColor(Color.black);
            graphics.setFont(new Font("serif", Font.BOLD, 11));
            graphics.drawString("Score: " + score + "/500", 490, 30);
            graphics.drawString("Lives: " + lives + "/3", 120, 30);
            
            
            //hide remains bricks
            mapPlay.draw((Graphics2D) graphics, Color.BLACK);

            //paddle
            graphics.setColor(Color.black);
            graphics.fillOval(ballPosX, ballPosY, 20, 20);
            graphics.fillOval(ballPosX1, ballPosY1, 20, 20);
            graphics.fillRect(playerX, 550,pshape, 8);

            //game start message
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
            graphics.drawString("Press Enter/Left/Right Arrow to start the game!", 90, 350);
            play = false;
        }

        graphics.dispose();
    }


    public int Highscore(){
    	if(score<score1 && score>score2 ){
    		score3 = score2;
   		  score2 = score;
   	   }
 	   
 	  
 	 if(score>score1){
		  score2 = score1;
		  score1 = score;
	   }
 	 if(score<score1 && score<score2 ){
 		 
 		 score3 = score;
 	 }
 	   
	return ballDirX;
	
 	   
     	
     	
     }
    
    public void keyPressed(KeyEvent ke) {
    	
    	if(lives != 0){
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT && play == true) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT && play == true) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
        if(ke.getKeyCode() == KeyEvent.VK_Q){
        System.exit(10);
        }
        else if(ke.getKeyCode() == KeyEvent.VK_A){
        	 timer.setDelay(40);
        	 play = true;
             playerX = 310;
             ballPosX = 290;
             ballPosY = 350;
             ballPosX1 = 300;
             ballPosY1 = 400;
             ballDirX = 6;
             ballDirY = -6;
             ballDirX1 = 6;
             ballDirY1 = -6;
             totalBricks = 60;

             mapPlay = new BrickGenerator(6, 10);
             score = 0;
            
             
             if (ballPosY > 570 && ballPosY1>570) { // if ball fall in down
               	 
               	 
               	 ballDirX = 6;
               	 ballDirY = -6;
               	ballDirX1 = 6;
              	 ballDirY1= -6;
               	 lives = lives - 1;

                   
               }
             
             if(lives==0){
            	 
            	 play = false;
             }
             
        	
           
            }
       
        else if(ke.getKeyCode() == KeyEvent.VK_B){
        	
        	timer.setDelay(40);  
        	 play = true;
             playerX = 310;
             ballPosX = 290;
             ballPosY = 350;
             ballDirX = 10;
             ballDirY = -10;
             ballPosX1 = 290;
             ballPosY1= 350;
             ballDirX1 = 10;
             ballDirY1 = -10;
             totalBricks = 80;

             mapPlay = new BrickGenerator(8, 10);
             score = 0;
if (ballPosY > 570 && ballPosY1>570) { // if ball fall in down
               	 
               	 
               	 ballDirX = 8;
               	 ballDirY = -8;
               	ballDirX1 = 8;
              	 ballDirY1 = -8;
               	 lives = lives - 1;

                   
               }
if(lives==0){
	 
	 play = false;
}

        	
           
            }
        if(ke.getKeyCode() == KeyEvent.VK_C){
        	timer.setDelay(40);
        	 play = true;
             playerX = 310;
             ballPosX = 290;
             ballPosY = 350;
             ballDirX = 13;
             ballDirY = -13;
             totalBricks = 100;
             ballPosX1 = 290;
             ballPosY1= 350;
             ballDirX1 = 13;
             ballDirY1 = -13;
             totalBricks = 100;
             
             mapPlay = new BrickGenerator(10, 10);
             score = 0;

             
if (ballPosY > 570) { // if ball fall in down
               	 
               	 
               	 ballDirX = 13;
               	 ballDirY = -13;
             	ballDirX1 = 13;
             	 ballDirY1 = -13;
              	 lives = lives - 1;
               	 lives = lives - 1;

                   
               }
if(lives==0){
	 
	 play = false;
}

        	
        	
        	
        }
        else if(ke.getKeyCode() == KeyEvent.VK_P){
        	
        	timer.stop();
        }
else if(ke.getKeyCode() == KeyEvent.VK_S){
        	
        	timer.start();
        }
        
        else if(ke.getKeyCode() == KeyEvent.VK_H){
        	
        	Highscore();
        	  new H(name,score1,score2,score3); 
        	
        	
        	
        }
       
            }
        
    }
    
    

	public void moveRight() {
        play = true;
        playerX += 20;
    }

    public void moveLeft() {
        play = true;
        playerX -= 20;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();

        if (play) {
            if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8)) ) {
                ballDirY = -ballDirY;
                ballDirX = -ballDirX;
            }
            else if( new Rectangle(ballPosX1, ballPosY1, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))){
                ballDirY1 = -ballDirY1;
                ballDirX1 = -ballDirX1;
                
                
            }

            A:
            for (int i = 0; i < mapPlay.map.length; i++) {
                for (int j = 0; j < mapPlay.map[0].length; j++) {
                    if (mapPlay.map[i][j] > 0) {
                        int brickX = j * mapPlay.brickWidth+i*20 + 80;
                        int brickY = i * mapPlay.brickHeight  + 50;
                        int brickWidth = mapPlay.brickWidth;
                        int brickHeight = mapPlay.brickHeight;
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle ballRec = new Rectangle(ballPosX1, ballPosY1, 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)) {
                        	
                            mapPlay.setBrickValue(v, i, j);
                            if(v == 0){
                            totalBricks--;
                            v = 2;
                            score += 5;
                            }
                            
                            abc  = brickX+170;
                            xyz = brickY+50;
                            a= 1;
                            v--;

                            if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                ballDirX = -ballDirX;
                            } else {
                                ballDirY = -ballDirY;
                            }
                           
                        }
                     if (ballRec.intersects(brickRect)) {
                        	
                            mapPlay.setBrickValue(v, i, j);
                            if(v == 0){
                            totalBricks--;
                            v = 2;
                            score += 5;
                            }
                            
                            abc  = brickX+170;
                            xyz = brickY+50;
                            a= 1;
                            v--;

                            if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                ballDirX = -ballDirX;
                            } else {
                                ballDirY = -ballDirY;
                            }
                            break A;
                        }
                    }
                }
            }

            ballPosX += ballDirX;
            ballPosY += ballDirY;
            ballPosX1 += ballDirX1;
            ballPosY1 += ballDirY1;
            

            if (ballPosX < 0) {  //for left
                ballDirX = -ballDirX;
            }
            if (ballPosY < 0) { //for top
                ballDirY = -ballDirY;
            }
            if (ballPosX > 670) { //for right
                ballDirX = -ballDirX;
            }
            if (ballPosX1 < 0) {  //for left
                ballDirX1= -ballDirX1;
            }
            if (ballPosY1 < 0) { //for top
                ballDirY1 = -ballDirY1;
            }
            if (ballPosX1 > 670) { //for right
                ballDirX1 = -ballDirX1;
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

   
}
