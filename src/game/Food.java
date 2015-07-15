/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Ball.grid;
import static game.Ball.myGrid;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Aleksandra
 */
public class Food {
    

    public static boolean[][] foodGrid = new boolean[28][31];
    public static int columns = foodGrid.length;
    public static int rows = foodGrid[0].length;
    
    
    public static boolean isAllFoodEaten; 
    
    
    
    
    public Food() // constructor
    {        
        isAllFoodEaten = false;

        food();    
    }
        
        public void paint(Graphics graphics){

            //food array filling
            for(int i = 0; i < foodGrid.length; i++ ) //printing the array (and obstacles)
            {
                    for(int j = 0; j < foodGrid[0].length; j++)
                    {

                        if(foodGrid[i][j]== true)
                        {
                            graphics.setColor(Color.YELLOW); // first, set color
                            graphics.fillOval((i*Ball.square) + 10, (j*Ball.square) + 10, 10, 10); // then fill it with this color
                        }

                    }
            }
        }
        
        public void update(){
     
            if( Ball.grid[Ball.columns/Ball.square][Ball.rows/Ball.square] == foodGrid[Ball.columns/Ball.square][Ball.rows/Ball.square])
            {
                foodGrid[Ball.columns/Ball.square][Ball.rows/Ball.square]= false;
                
                Display.points += 10 * (Display.level);
                
                if (isFoodGridEmpty()) {
                    isAllFoodEaten = true;
                }
            }

        }
        public static boolean isFoodGridEmpty(){
        
            boolean isAllFalse = true;

            for(int i = 0; i < Food.foodGrid.length; i++ ) 
            {
                for(int j = 0; j < Food.foodGrid[0].length; j++)
                {
                    if(Food.foodGrid[i][j])
                    {
                        isAllFalse = false;
                        break;
                    }

                }
            }
            return isAllFalse;
       
        } 

        public void food()
        { 
            for(int i = 0; i < foodGrid.length; i++ ) //feeling thr array
            {
                for(int j = 0; j < foodGrid[0].length; j++)
                {
                    foodGrid [i][j] = true;

                }
            }

            for(int i = 0; i < foodGrid.length; i++) // setting the bariers - top
            {
                foodGrid [i][0] = false;
            }
            for(int i = 0; i < grid[0].length; i++) // left
            {
               foodGrid [0][i] = false;
            }
            for(int i = 0; i < foodGrid[0].length; i++) //right
            {
               foodGrid [foodGrid.length-1][i] = false; 
            }
            for(int i = 0; i < foodGrid.length; i++) // bottom
            {
                foodGrid [i][foodGrid[0].length-1] = false;
            }

            //obstacles
            foodGrid[2][2]=false;
            foodGrid[3][2]= false;
            foodGrid[4][2]=false;
            foodGrid[5][2]=false;
            foodGrid[2][3]=false;
            foodGrid[3][3]= false;
            foodGrid[4][3]=false;
            foodGrid[5][3]=false;
            foodGrid[2][4]=false;
            foodGrid[3][4]= false;
            foodGrid[4][4]=false;
            foodGrid[5][4]=false;

            foodGrid[2][6]=false;
            foodGrid[3][6]= false;
            foodGrid[4][6]=false;
            foodGrid[5][6]=false;
            foodGrid[2][7]=false;
            foodGrid[3][7]= false;
            foodGrid[4][7]=false;
            foodGrid[5][7]=false;

            for (int i = 1; i <= 5; i++ ){
                for(int j = 9; j <= 19; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 2; i <= 5; i++ ){
                for(int j = 21; j <= 22; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 4; i <= 5; i++ ){
                for(int j = 23; j <= 25; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 1; i <= 2; i++ ){
                for(int j = 24; j <= 25; j++){
                    foodGrid[i][j]= false;
                }
            }

            for (int i = 2; i <= 11; i++ ){
                for(int j = 27; j <= 28; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 7; i <= 8; i++ ){
                for(int j = 24; j <= 26; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 7; i <= 11; i++ ){
                for(int j = 2; j <= 4; j++){
                    foodGrid[i][j]= false;
                }
            }        
            for (int i = 13; i <= 14; i++ ){
                for(int j = 1; j <= 4; j++){
                    foodGrid[i][j]= false;
                }
            }        
            for (int i = 16; i <= 20; i++ ){
                for(int j = 2; j <= 4; j++){
                    foodGrid[i][j]= false;
                }
            }        
            for (int i = 22; i <= 25; i++ ){
                for(int j = 2; j <= 4; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 7; i <= 8; i++ ){
                for(int j = 6; j <= 13; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 9; i <= 11; i++ ){
                for(int j = 9; j <= 10; j++){
                    foodGrid[i][j]= false;
                }
            }        
            for (int i = 10; i <= 17; i++ ){
                for(int j = 6; j <= 7; j++){
                    foodGrid[i][j]= false;
                }
            } 
            for (int i = 13; i <= 14; i++ ){
                for(int j = 8; j <= 10; j++){
                    foodGrid[i][j]= false;
                }
            }        
            for (int i = 16; i <= 18; i++ ){
                for(int j = 9; j <= 10; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 19; i <= 20; i++ ){
                for(int j = 6; j <= 13; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 22; i <= 25; i++ ){
                for(int j = 6; j <= 7; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 22; i <= 26; i++ ){
                for(int j = 9; j <= 19; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 19; i <= 20; i++ ){
                for(int j = 15; j <= 19; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 16; i <= 20; i++ ){
                for(int j = 21; j <= 22; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 7; i <= 11; i++ ){
                for(int j = 21; j <= 22; j++){
                    foodGrid[i][j]= false;
                }
            }        
            for (int i = 7; i <= 8; i++ ){
                for(int j = 15; j <= 19; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 10; i <= 17; i++ ){
                for(int j = 18; j <= 19; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 13; i <= 14; i++ ){
                for(int j = 20; j <= 22; j++){
                    foodGrid[i][j]= false;
                }
            }        
            for (int i = 22; i <= 25; i++ ){
                for(int j = 21; j <= 22; j++){
                    foodGrid[i][j]= false;
                }
            } 
            for (int i = 22; i <= 23; i++ ){
                for(int j = 23; j <= 25; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 10; i <= 17; i++ ){
                for(int j = 24; j <= 25; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 19; i <= 20; i++ ){
                for(int j = 24; j <= 26; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 16; i <= 25; i++ ){
                for(int j = 27; j <= 28; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 13; i <= 14; i++ ){
                for(int j = 26; j <= 28; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 25; i <= 26; i++ ){
                for(int j = 24; j <= 25; j++){
                    foodGrid[i][j]= false;
                }
            }
            for (int i = 10; i <= 12; i++ ){
                foodGrid[i][12]= false;
            } 
            for (int i = 15; i <= 17; i++ ){
                foodGrid[i][12]= false;
            } 
            for (int i = 10; i <= 17; i++ ){
                foodGrid[i][16]= false;
            }
            for (int j = 12; j <= 16; j++ ){
                foodGrid[10][j]= false;
            }
            for (int j = 12; j <= 16; j++ ){
                foodGrid[17][j]= false;
            }        


            for (int i = 11; i <= 16; i++ ){
                for(int j = 13; j <= 15; j++){
                    foodGrid[i][j]= false;
                }
            }

            for (int i = 9; i <= 18; i++ ){
                foodGrid[i][11]= false;
            }  
            for (int i = 9; i <= 18; i++ ){
                foodGrid[i][17]= false;
            }
            for (int j = 11; j <= 19; j++ ){
                foodGrid[9][j]= false;
            }          
            for (int j = 11; j <= 19; j++ ){
                foodGrid[18][j]= false;
            } 
            for (int i = 7; i <= 8; i++ ){
                foodGrid[i][14]= false;
            }        
             for (int i = 19; i <= 20; i++ ){
                foodGrid[i][14]= false;
            } 
             for (int i = 13; i <= 14; i++ ){
                foodGrid[i][12]= false;
            }   
            for (int j = 9; j <= 10; j++ ){
                foodGrid[12][j]= false;
            } 
            for (int j = 9; j <= 10; j++ ){
                foodGrid[15][j]= false;
            }
        }    
}
