/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JFrame;
public class Game extends JFrame { // we are extending our class with JFrame so we inherit all its methods

   public Game(){ // constructor
       setTitle("Pacman"); // set the tiele of the frame
       setResizable(false); // for not letting the user to resize the window
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // without it closing window is very difficult for user
       add(new Display()); //calls display class 
       setVisible(true); // to make display visible
       pack(); // to make the display fit in the window
       
       
   }
   
    public static void main(String[] args) {
        new Game();
    }
}