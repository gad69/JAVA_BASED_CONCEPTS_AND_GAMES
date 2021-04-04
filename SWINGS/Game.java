package SWINGS;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.Label;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Game  extends Application implements ActionListener  {
	
	static JProgressBar jb;    
	 static int i=0;
		int num=0;   
		 static Label l5;
		 static JButton b1;
		static JButton b2;
		static JButton b3;
		static JButton b4;
    public Boolean play = false;

	public static void main(String[] args) {
	
	
   	   JFrame ob = new JFrame();
   
	
   
   	
	
       ob.getContentPane().add(new JLabel(new ImageIcon("SWINGS/w.gif")));
      ob.getContentPane().setBackground(Color.green);
       ob.setLayout(new FlowLayout());
       ob.setBounds(10, 10, 2000, 1200);
       ob.setTitle("Brick Breaker");
       ob.setResizable(false);
    
       ob.setLocation(0, 0);
       Timer t = new Timer(60, new Game()); // set a timer
       t.start();
   l5 = new Label("WELCOME TO DISTUCTOID PLATFORM FOR GAMES ");
   l5.setFont(new Font("Verdana", Font.PLAIN, 70));
   ob.add(l5);
     
	b1 = new JButton(new ImageIcon("SWINGS/ba.gif"));
	b2 = new JButton(new ImageIcon("SWINGS/tt.gif"));
	b3 = new JButton(new ImageIcon("SWINGS/mus.gif"));
	b4 = new JButton(new ImageIcon("SWINGS/si.gif"));
	
      jb=new JProgressBar(0,1000);    
	  	jb.setBounds(50,50,500,50);         
	  	jb.setValue(0);    
	  	jb.setStringPainted(true); 
	  	ob.add(jb); 
	  	ob.add(b2);
	  	ob.add(b1);
	  	ob.add(b4);
	  	ob.add(b3);
	  	b1.addActionListener(new Game());
		b2.addActionListener(new Game());
		b3.addActionListener(new Game());
		b4.addActionListener(new Game());
       ob.setVisible(true);
       iterate(); 
       ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       launch();
	}
	public static void iterate(){    
		while(i<=2000){    
		  jb.setValue(i);    
		  i=i+20;    
		  try{Thread.sleep(150);}catch(Exception e){}    
		}    
		}    
	@Override
	public void start (Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub  
      
		 
    }

	
	@Override
	
	public void actionPerformed(ActionEvent ee) {
		String oldText = l5.getText();
	    String newText= oldText.substring(1)+ oldText.substring(0,1);
	    l5.setText(newText);
	    if(ee.getSource()==b1) {
			
		        new BRK();
		       
		        
		       }
		if(ee.getSource()==b2) {
			
			
			
	
	        new Pong();
	      
	   
	       
		
	
		}
		
		if(ee.getSource()==b3){
Media m = new Media(new File("/C:/Users/hp/Downloads/mario.mp3").toURI().toString());  
	        
	        //Instantiating MediaPlayer class   
	        MediaPlayer k = new MediaPlayer(m);  
	          
	        //by setting this property to true, the audio will be played   
	        k.play();
	       
			
		}
		if(ee.getSource()==b4) {
			
			
			
			
	       new MyFrame();
	      
	   
	       
		
	
		}
		
	}
	    
		
		
	}
		
		
	

