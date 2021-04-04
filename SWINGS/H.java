package SWINGS;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

 class H extends GamePlay
{
 H(String name, int score1,int score2,int score3)
{this.name = name;
this.score1 = score1;
this.score2 = score2;
this.score3 = score3;
    //headers for the table
    String[] columns = new String[] {
    		
        "Highscore", "Name"
    };

    //actual data for the table in a 2d array
    Object[][] data = new Object[][] {{score1, name },
        {score2, name },
        {score3, name },
    
    };
JFrame j = new JFrame();
    //create table with data
    JTable table = new JTable(data, columns);

    //add the table to the frame
    j.add(new JScrollPane(table));

    j.setTitle("High Score List ");
    j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
    j.pack();
    j.setVisible(true);
}


} 