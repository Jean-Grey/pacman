/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Aleksandra
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class Ghost {
    
    public static int ghostRadius = 15;
    public static int square = 2*ghostRadius;
    public static int speed = 30;
    Direction givenDirection = Direction.up;
    
    
   

    public static int columns = Ball.grid.length;
    public static int rows = Ball.grid[0].length;
    
    
   
    
    public Ghost(int _columns, int _rows){ // constructor
        columns = _columns;
        rows = _rows;

    }
    public void paint(Graphics g){
        
        g.drawRect(columns, rows, square, square);
        g.fillRect(columns, rows, square, square);

        
    }
    
       public void update()
    {
        Random randomGen = new Random();// create a random number generator
    
        int theRandomNumber = randomGen.nextInt(3);// generate a random number, between 0 and n-1 (0,1,2 in this case)
        
        Ball.myGrid();

      
        // setting up the movement and collision detection
        if(givenDirection == Direction.up && Ball.grid[columns/square][(rows - square)/square])
        {
            rows = rows - speed;
        }
        else if(givenDirection == Direction.down && Ball.grid[columns/square][(rows + square)/square])
        {
            rows = rows + speed;
        }
        else if(givenDirection == Direction.right && Ball.grid[(columns+ square)/square][rows/square])
        {
            columns = columns + speed;
        }
        else if(givenDirection == Direction.left && Ball.grid[(columns- square)/square][rows/square])
        {
            columns = columns - speed;   
        }
        else{ // changing direction if there is an obstacle
            if(givenDirection == Direction.up){
                switch(theRandomNumber) {
                     case 0:
                         givenDirection = Direction.down;
                         break;
                     case 1:
                         givenDirection = Direction.right;
                         break;
                     case 2:
                         givenDirection = Direction.left;
                         break;

                     }
            }
            else if(givenDirection == Direction.down){
                switch(theRandomNumber) {
                     case 0:
                         givenDirection = Direction.up;
                         break;
                     case 1:
                         givenDirection = Direction.right;
                         break;
                     case 2:
                         givenDirection = Direction.left;
                         break;

                     }
            }
            else if(givenDirection == Direction.right){
                switch(theRandomNumber) {
                     case 0:
                         givenDirection = Direction.up;
                         break;
                     case 1:
                         givenDirection = Direction.down;
                         break;
                     case 2:
                         givenDirection = Direction.left;
                         break;

                     }
            } 
            else if(givenDirection == Direction.left){
                switch(theRandomNumber) {
                     case 0:
                         givenDirection = Direction.up;
                         break;
                     case 1:
                         givenDirection = Direction.down;
                         break;
                     case 2:
                         givenDirection = Direction.right;
                         break;

                     }
            }             
            
        }
        
        

    }
    
}
