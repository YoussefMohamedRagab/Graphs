/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Scanner;

/**
 *
 * @author Youssef
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        Problem1 prob1 = new Problem1();
        Problem2 prob2 = new Problem2();
        Problem3 prob3 = new Problem3();
        do{
            System.out.println("Please enter your choice\n1.Problem 1\n2.Problem 2\n3.Problem 3\n4.Exit");
            choice = scanner.nextInt();   
            System.out.println();
            switch(choice){
                case 1:
                    prob1.run();
                    break;
                case 2:
                    prob2.maze_start();
                    break;
                case 3:
                    prob3.run();
                    break;
                case 4:
                	System.out.println("See you soon");
                    break;
            }            
        
        }while (choice != 4);   
        
        scanner.close();
             
    }
}
