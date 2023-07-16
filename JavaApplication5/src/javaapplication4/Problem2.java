/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Youssef
 */
public class Problem2 {
    
    int N,x,y;
    int [][] matrix ;
    boolean [][] visited;
    Stack stackX = new Stack();
    Stack stackY = new Stack();
    boolean end_reached;
    
   
    public void maze_start(){
       String temp;       
       System.out.println("Please enter N : ");
       Scanner scanner1 = new Scanner(System.in);
       Scanner scanner2 = new Scanner(System.in);
       int n = scanner1.nextInt();
       this.N = n;
       //initializing components 
       matrix = new int[n][n];
       visited = new boolean[n][n];  
       // ................
       System.out.println("Please enter Values for maze :");
       for(int i=0;i<n;i++){            
            temp =scanner2.nextLine();
            String [] arr = temp.split(" ",0);
            for(int j = 0 ;j<n;j++)
                matrix[i][j] = Integer.parseInt(arr[j]);                                       
        }
       this.x = this.y = 0;
       stackX.push(x);
       stackY.push(y);
       visited [0][0]=true;
        solve_maze();           
    }
    
    public void solve_maze(){
        
        while(!stackX.isEmpty() && !stackY.isEmpty()){   
            if(matrix[0][0]==1)
                break;
            x=(int) stackX.peek();
            y=(int) stackY.peek();
            if(end_reach(x,y)){
                System.out.println("Solution : ");
                while(!stackX.isEmpty()){                    
                    System.out.print("(" +(int)stackX.remove(0) + "," + (int)stackY.remove(0) +") ,");                    
                }
                System.out.println("");
                return;
            }           
            if(can_down(x, y)){
                    visited [x+1][y] = true;
                    x = x+1;
                    stackX.push(x);
                    stackY.push(y);             
            }
            else if(can_right(x, y)){
                    visited [x][y+1] = true;
                    y=y+1;
                    stackX.push(x);
                    stackY.push(y);                    
            }
            else if(can_top(x, y)){
                    visited [x-1][y] = true;
                    x=x-1;
                    stackX.push(x);
                    stackY.push(y);                   
            }
            else if(can_left(x, y)){
                    visited [x][y-1] = true;
                    y=y-1;
                    stackX.push(x);
                    stackY.push(y);                   
            }            
            else{
                stackX.pop();
                stackY.pop();
            }   
        }
        if(!end_reached)
            System.out.println("No Path Found");       
    }
    
    public boolean can_down(int datX , int datY){       
        if(datX== N-1)
            return false;
        else if(matrix [datX+1][datY]== 1 || visited[datX+1][datY] == true)
            return false;
        else
            return true;                    
    }
    public boolean can_right(int datX , int datY){       
        if(datY== N-1)
            return false;
        else if(matrix [datX][datY+1]== 1 || visited[datX][datY+1] == true)
            return false;
        else
            return true;                    
    }
    public boolean can_top(int datX , int datY){       
        if(datX== 0)
            return false;
        else if(matrix [datX-1][datY]== 1 || visited[datX-1][datY] == true)
            return false;
        else
            return true;                    
    }
    public boolean can_left(int datX , int datY){       
        if(datY== 0)
            return false;
        else if(matrix [datX][datY-1]== 1 || visited[datX][datY-1] == true)
            return false;
        else
            return true;                    
    }
    public boolean end_reach(int dat1 , int dat2){
        
        if(dat1 == N-1 && dat2 == N-1)
            return true;
        else
            return false;
        
    }
    
}
