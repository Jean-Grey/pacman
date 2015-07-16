/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener; // to get the input from the keyboard, it lisnens if any key was pressed
import java.awt.event.KeyEvent; // to get the input from keyboard, it detects which key was pressed.
//import java.awt.event.MouseListener; // to get input from  mouse
//import java.awt.event.MouseEvent; // the same as keyboard event\
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.awt.Font;

/**
 *
 * @author Aleksandra
 */
public class Display extends JPanel implements ActionListener, KeyListener //MouseListener
// this class should only take care of display, update and input.
{
    Ball ball;
    Timer time;
    Food food;
    Ghost ghost;
    
    public static int level;
    public static int points;
    public static int lives;
    
    
    
    
    public Display()
    {
        level = 1;
        points = 0;
        lives = 3;
        this.setPreferredSize(new Dimension(Ball.columns *Ball.square , Ball.rows * Ball.square)); // set the window size
        ball = new Ball ((Ball.columns - 15)*Ball.square ,(Ball.rows -8)*Ball.square);  // set the ball object and its position on the display     
        
        food = new Food(); // wez skumaj co ty tu robisz
        ghost = new Ghost((Ghost.columns - 14)*Ghost.square ,(Ghost.rows -17)*Ghost.square);
        
        //ball_1 = new Ball (400,400); // set second ball object and its position
        time = new Timer(200, this); // (interval ( in miliseconds), ActionListener) - becacuse I implemented
        //Action Listener to this class, this class is becoming ActionListener - which fire the actionPerformed method.
        time.start(); // starts this object - fire actionPerformed method every 50 miliseconds
        this.setFocusable(true);
        this.addKeyListener(this);
        //this.addMouseListener(this);
        
    }
    
    
    @Override
    public void paint(Graphics graphics)
    {


        // grid array filling
        for(int i = 0; i < Ball.grid.length; i++ ) //printing the array (and obstacles)
        {
            for(int j = 0; j < Ball.grid[0].length; j++)
            {
                if(Ball.grid[i][j]== true)
                {
                    graphics.setColor(Color.BLACK); // first, set color of the background
                    graphics.fillRect(i*Ball.square, j*Ball.square, Ball.square, Ball.square); // then fill it with this color
                    
                }
                else{
                    graphics.setColor(Color.BLUE); // first, set color of the background
                    graphics.fillRect(i*Ball.square, j*Ball.square, Ball.square, Ball.square);       
                }
                
            }
        }
      
        graphics.setColor(Color.YELLOW); // set the color of the ball
        ball.paint(graphics); // and fill it with this color
        //creating second ball and  paint it with different color
        //graphics.setColor(Color.RED);
        //ball_1.paint(graphics);

        
        food.paint(graphics);

        graphics.setColor(Color.MAGENTA);
        ghost.paint(graphics);
        
        // also check:
        // Display.java - line 106
        // Food.java - line 62
        displayStats(graphics);

       
    }

    public void displayStats(Graphics g) {
 
        //Save current colour
        Color c = g.getColor();
        
        // set new colour for stats
        g.setColor(Color.WHITE);
        
        // set font face, and size
        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        
        // draw stats
        g.drawString("Points:", 30, 300);   
        g.drawString(Integer.toString(points), 30, 330);
        g.drawString("Level:", 30, 380);
        g.drawString(Integer.toString(level), 30, 410);
        g.drawString("Lives:", 30, 460);
        g.drawString(Integer.toString(lives), 30, 490);
        
        // after drawing stats bring back previous colour
        g.setColor(c);
    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        if(Food.isAllFoodEaten){
            gameOver();
        }
        else{
            update();
            repaint();// repaint is a public method in the JPanel, becuse we inherit every methos from JPanel, we can use this method.

        }
    }
    public void update()
    {
        ball.update(); 
        food.update();

        if (Ghost.columns == Ball.columns && Ghost.rows == Ball.rows) { // checking if ball is at the same position as ghost
            if(lives > 0){
                die();
                
                
                
                //ale gra zaczyna sie od nowa - i jeszcze nie wiem jak
            }
            else{
            gameOver();                 
            }

        }
        ghost.update();
  


    }
    @Override
    public void keyReleased(KeyEvent evt)
    {
        
    }
    @Override
    public void keyPressed(KeyEvent evt)
    {
          ball.setDirection(evt);
 
    }
    @Override
    public void keyTyped(KeyEvent evt)
    {
        
    }
    /*
    public void mousePressed(MouseEvent evt1)
    {
        ball.setDirection(evt1);
    }
    public void mouseReleased(MouseEvent evt1)
    {
        `
    }
    public void mouseClicked(MouseEvent evt1)
    {
        
    }
    public void mouseEntered(MouseEvent evt1)
    {
        
    }
    public void mouseExited(MouseEvent evt1)
    {
        
    }*/
    public void die(){
        
        time.stop();
        lives -= 1;
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "You died\n Continue?", "You died",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
          System.out.println("No button clicked");
        } else if (response == JOptionPane.YES_OPTION) {
            
            time.start();

        
            
            
           
          
        } else if (response == JOptionPane.CLOSED_OPTION) {
          System.out.println("JOptionPane closed");
        }
    }
    
    
    
    public void gameOver(){
        
        time.stop();
       
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Your score is:\n" + points + "\n" + "Do you want to try again?", "Game Over",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
          System.out.println("No button clicked");
        } else if (response == JOptionPane.YES_OPTION) {
            new Game();
           
          
        } else if (response == JOptionPane.CLOSED_OPTION) {
          System.out.println("JOptionPane closed");
        }
  
   }


    
}
