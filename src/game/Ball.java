/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Aleksandra
 */
enum Direction
{
    up,left,right,down;
}
public class Ball
{

    int direction = 30;
    int mouth = 300;
    public static int pacmanRadius = 15;
    public static int square = 2*pacmanRadius;
    int speed = 30;
    Direction givenDirection = Direction.right; // using enum ( only 4 options)
    
    public static boolean[][] grid = new boolean[28][31];
    public static int columns = grid.length;
    public static int rows = grid[0].length;

    
    
    //boolean x = false, y = true;
   

    //boolean goRight = true;
    //boolean goUp = true;
   
    public Ball( int _columns, int _rows) // constructor
    {        
        columns = _columns;
        rows = _rows;
        
        
    }
    public void paint(Graphics graphics)
    {
       
        /*int diameter = 20;
        graphics.drawOval(axisX, axisY, diameter, diameter);
        graphics.fillOval(axisX, axisY, diameter, diameter);*/
        graphics.fillArc(columns, rows, 2*pacmanRadius, 2*pacmanRadius, direction, mouth); //(int x, int y, int width, int height, int startAngle, int arcAngle), it colors
        //the circle or oval based on angle
   
    }
    public void update()
    {
        
        myGrid();

        //making the mouth eat        
        if(mouth == 360)
        {
            mouth = 300;
        }
        else{
            mouth = 360;
        } 
      
        // setting up the movement and collision detection
        if(/*direction == 120*/  givenDirection == Direction.up && grid[columns/square][(rows - square)/square])
        {
            //axisX = axisX;
            rows = rows - speed;
        }
        else if(/*direction == 300*/ givenDirection == Direction.down && grid[columns/square][(rows + square)/square])
        {
            //axisX = axisX;
            rows = rows + speed;
        }
        else if(/*direction == 30*/givenDirection == Direction.right && grid[(columns+ square)/square][rows/square])
        {
            columns = columns + speed;
            //axisY = axisY;
        }
        else if(/*direction == 210*/ givenDirection == Direction.left && grid[(columns- square)/square][rows/square])
        {
            columns = columns - speed;
            //axisY = axisY;   
        }
        else{
            stop();
        }
        


        

    }
    
    public void setDirection(KeyEvent evt) // to change the direction of a packman
    {
        if(evt.getKeyCode()== KeyEvent.VK_UP)
        {
          direction = 120;
          givenDirection = Direction.up; 
          speed = square;
        }
        else if(evt.getKeyCode()== KeyEvent.VK_DOWN)
        {
          direction = 300;
          givenDirection = Direction.down;
          speed = square;
        }
        else if(evt.getKeyCode()== KeyEvent.VK_LEFT)
        {
          direction = 210;
          givenDirection = Direction.left;
          speed = square;
        }
        else if(evt.getKeyCode()== KeyEvent.VK_RIGHT)
        {
           direction = 30;
           givenDirection = Direction.right;
           speed = square;

        }
        
    }
    
    /*public void setDirection(MouseEvent evt1) // to change the direction of a packman
    {
        if(evt1.getYOnScreen() < axisY)
        {
          direction = 120;
          givenDirection = Direction.up; 
          speed = 10;
        }
        else if(evt1.getYOnScreen()> axisY)
        {
          direction = 300;
          givenDirection = Direction.down;
          speed = 10;
        }
        else if(evt1.getXOnScreen() < axisX)
        {
          direction = 210;
          givenDirection = Direction.left;
          speed = 10;
        }
        else if(evt1.getXOnScreen() > axisX)
        {
           direction = 30;
           givenDirection = Direction.right;
           speed = 10;

        }
        
    }*/
    
    public void stop()
    {
        speed = 0;
    }

    
    
    
    public static void myGrid ()
    {


        for(int i = 0; i < grid.length; i++ ) //feeling the array
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                grid [i][j] = true;
                  
            }
        }
        
        for(int i = 0; i < grid.length; i++) // setting the bariers - top
        {
            grid [i][0] = false;
        }
        for(int i = 0; i < grid[0].length; i++) // left
        {
            grid [0][i] = false;
        }
        for(int i = 0; i < grid[0].length; i++) //right
        {
            grid [grid.length-1][i] = false; 
        }
        for(int i = 0; i < grid.length; i++) // bottom
        {
            grid [i][grid[0].length-1] = false;
        }
        
        //obstacles
        grid[2][2]=false;
        grid[3][2]= false;
        grid[4][2]=false;
        grid[5][2]=false;
        grid[2][3]=false;
        grid[3][3]= false;
        grid[4][3]=false;
        grid[5][3]=false;
        grid[2][4]=false;
        grid[3][4]= false;
        grid[4][4]=false;
        grid[5][4]=false;
        
        grid[2][6]=false;
        grid[3][6]= false;
        grid[4][6]=false;
        grid[5][6]=false;
        grid[2][7]=false;
        grid[3][7]= false;
        grid[4][7]=false;
        grid[5][7]=false;
        
        for (int i = 1; i <= 5; i++ ){
            for(int j = 9; j <= 19; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 2; i <= 5; i++ ){
            for(int j = 21; j <= 22; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 4; i <= 5; i++ ){
            for(int j = 23; j <= 25; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 1; i <= 2; i++ ){
            for(int j = 24; j <= 25; j++){
                grid[i][j]= false;
            }
        }
        
        for (int i = 2; i <= 11; i++ ){
            for(int j = 27; j <= 28; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 7; i <= 8; i++ ){
            for(int j = 24; j <= 26; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 7; i <= 11; i++ ){
            for(int j = 2; j <= 4; j++){
                grid[i][j]= false;
            }
        }        
        for (int i = 13; i <= 14; i++ ){
            for(int j = 1; j <= 4; j++){
                grid[i][j]= false;
            }
        }        
        for (int i = 16; i <= 20; i++ ){
            for(int j = 2; j <= 4; j++){
                grid[i][j]= false;
            }
        }        
        for (int i = 22; i <= 25; i++ ){
            for(int j = 2; j <= 4; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 7; i <= 8; i++ ){
            for(int j = 6; j <= 13; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 9; i <= 11; i++ ){
            for(int j = 9; j <= 10; j++){
                grid[i][j]= false;
            }
        }        
        for (int i = 10; i <= 17; i++ ){
            for(int j = 6; j <= 7; j++){
                grid[i][j]= false;
            }
        } 
        for (int i = 13; i <= 14; i++ ){
            for(int j = 8; j <= 10; j++){
                grid[i][j]= false;
            }
        }        
        for (int i = 16; i <= 18; i++ ){
            for(int j = 9; j <= 10; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 19; i <= 20; i++ ){
            for(int j = 6; j <= 13; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 22; i <= 25; i++ ){
            for(int j = 6; j <= 7; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 22; i <= 26; i++ ){
            for(int j = 9; j <= 19; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 19; i <= 20; i++ ){
            for(int j = 15; j <= 19; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 16; i <= 20; i++ ){
            for(int j = 21; j <= 22; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 7; i <= 11; i++ ){
            for(int j = 21; j <= 22; j++){
                grid[i][j]= false;
            }
        }        
        for (int i = 7; i <= 8; i++ ){
            for(int j = 15; j <= 19; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 10; i <= 17; i++ ){
            for(int j = 18; j <= 19; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 13; i <= 14; i++ ){
            for(int j = 20; j <= 22; j++){
                grid[i][j]= false;
            }
        } 
        for (int i = 15; i <= 16; i++ ){
            for(int j = 13; j <= 15; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 22; i <= 25; i++ ){
            for(int j = 21; j <= 22; j++){
                grid[i][j]= false;
            }
        } 
        for (int i = 22; i <= 23; i++ ){
            for(int j = 23; j <= 25; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 10; i <= 17; i++ ){
            for(int j = 24; j <= 25; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 19; i <= 20; i++ ){
            for(int j = 24; j <= 26; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 16; i <= 25; i++ ){
            for(int j = 27; j <= 28; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 13; i <= 14; i++ ){
            for(int j = 26; j <= 28; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 25; i <= 26; i++ ){
            for(int j = 24; j <= 25; j++){
                grid[i][j]= false;
            }
        }
        for (int i = 10; i <= 12; i++ ){
            grid[i][12]= false;
        } 
        for (int i = 15; i <= 17; i++ ){
            grid[i][12]= false;
        } 
        for (int i = 10; i <= 17; i++ ){
            grid[i][16]= false;
        }
        for (int j = 12; j <= 16; j++ ){
            grid[10][j]= false;
        }
        for (int j = 12; j <= 16; j++ ){
            grid[17][j]= false;
        }        
    }
    

          

    
 
     
}
