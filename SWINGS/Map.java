package SWINGS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JOptionPane;

 class Racket {
    private static final int WIDTH = 15, HEIGHT = 100;
    private Pong game;
    private int up, down;
    private int x;
    private int y, ya;
    private Random random = new Random();
	 private static final float MIN_SAT = 0.5f;

    public Racket(Pong game, int up, int down, int x) {
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.up = up;
        this.down = down;
    }

    public void update() {
        if (y > 0 && y < game.getHeight() - HEIGHT - 29)
            y += ya;
        else if (y == 0)
            y++;
        else if (y == game.getHeight() - HEIGHT - 29)
            y--;
    }

    public void pressed(int keyCode) {
        if (keyCode == up)
            ya = -1;
        else if (keyCode == down)
            ya = 1;
    }

    public void released(int keyCode) {
       
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
    	float hue = random.nextFloat();
        float saturation = MIN_SAT + random.nextFloat() * (1f - MIN_SAT);
        float brightness = MIN_SAT + random.nextFloat() * (1f - MIN_SAT);

        Color color = Color.getHSBColor(hue, saturation, brightness);
        g.setColor(color);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}

class Ball {
    private static final int WIDTH = 25, HEIGHT = 25;
    private Pong game;
    private int x, y, xa = 1, ya = 1;
    private Random random = new Random();
	 private static final float MIN_SAT = 0.5f;
    public Ball(Pong game) {
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }

    public void update() {
        x += xa;
        y += ya;
        if (x < 0) {
            game.getPanel().increaseScore(1);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (x > game.getWidth() - WIDTH - 7) {
            game.getPanel().increaseScore(2);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (y < 0 || y > game.getHeight() - HEIGHT - 29)
            ya = -ya;
        if (game.getPanel().getScore(1) == 10) {
            JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        else if (game.getPanel().getScore(2) == 10) {
            JOptionPane.showMessageDialog(null, "Player 2 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);}
        checkCollision();
        
        
    }

    public void checkCollision() {
        if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
            xa = -xa;
        
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
    	float hue = random.nextFloat();
        float saturation = MIN_SAT + random.nextFloat() * (1f - MIN_SAT);
        float brightness = MIN_SAT + random.nextFloat() * (1f - MIN_SAT);

        Color color = Color.getHSBColor(hue, saturation, brightness);
        g.setColor(color);
        
        g.fillOval(x, y, WIDTH, HEIGHT);
    }
}





















