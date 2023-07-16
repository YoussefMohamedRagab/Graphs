/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Scanner;
import java.util.Queue;

/**
 *
 * @author Youssef
 */
public class Problem1 {
    
    
    public void run() throws InterruptedException{
        int temp1,temp2;
        String temp;
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("please enter number of vertices:");
        int v = scanner1.nextInt();
        System.out.println("please enter number of edges:");
        int E = scanner2.nextInt();
               
        Graph graph = new Graph(v, E);
        System.out.println("please enter edges in the form (u v):");
      
        for(int i=0;i<E;i++){            
            temp =scanner3.nextLine();
            String [] arr = temp.split(" ",0);
            temp1 = Integer.parseInt(arr[0]);
            temp2 = Integer.parseInt(arr[1]);            
            graph.AddEdge(temp1, temp2);                             
        }
        System.out.println("Please enter starting vertex");
        int source = scanner4.nextInt();
        System.out.println("Please enter value k");
        int k = scanner5.nextInt();
       
        BFS(graph, source, k);
                     
    }
    public  void BFS(Graph g , int source , int k) throws InterruptedException{
        Queue queue = new Queue();
        int count = 0;
        g.distance[source-1]=0;
        queue.enqueue(source);       
        while(!queue.isEmpty()){            
            int temp =(int) queue.dequeue();
            for(int x : g.Alist[temp-1]){
                if(g.distance[x-1] ==-1){
                    queue.enqueue(x);
                    g.predecessor[x-1]=temp;
                    g.distance[x-1]=g.distance[g.predecessor[x-1]-1]+1;                    
                }                
            }          
        }
        for(int i =0;i<g.Nvertix;i++){
                if(g.distance[i] == k)
                    count ++;
        }
        System.out.println("There are " + count +" people with "+ k +" connections away starting from " + source);   
    }
    
}
