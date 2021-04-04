package SWINGS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BrickGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    public Image image;

    public BrickGenerator(int row, int col) {
        map = new int[row][col];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length-i; j++) {
                map[i][j] = 1;
            }
        }
        brickWidth = 600 / col;
        brickHeight = 250 / row;
    }

    public void draw(Graphics2D graphics2d, Color colorName) {
    	ImageIcon k = new ImageIcon("SWINGS/hi.gif");
    	image = k.getImage();
    	graphics2d.drawImage(image, 0, 0, null);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length-i; j++) {
                if (map[i][j] > 0) {
                    graphics2d.setColor(colorName);
                    graphics2d.fillRect(j * brickWidth + 80+i*20, i * brickHeight + 50, brickWidth, brickHeight);

                    graphics2d.setStroke(new BasicStroke(5));
                    graphics2d.setColor(Color.white);
                    graphics2d.drawRect(j * brickWidth + 80+i*20, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;
    }
}
