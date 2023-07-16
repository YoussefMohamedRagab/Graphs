/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.LinkedList;

/**
 *
 * @author Youssef
 */
public class Graph {
    
    int Nvertix;
    int Nedges;
    int [] predecessor;
    int [] distance;
    LinkedList<Integer>[] Alist ;
    
    Graph(int data1,int data2){
        this.Nvertix = data1;
        this.Nedges = data2;
        Alist  = new LinkedList[this.Nvertix];
        predecessor = new int [this.Nvertix];
        distance = new int [this.Nvertix];
        for(int i =0;i<Nvertix;i++){
            Alist[i]=new LinkedList<>();
            distance[i]=-1; // assume -1 to be null
            
        }
    }
    
    
    public void AddEdge(int data1 , int data2){
        
            Alist[data1-1].add(data2);
            Alist[data2-1].add(data1);
        
    }
    
    public void getneighbours(int temp){
        
        while(! Alist[temp-1].isEmpty())
            System.out.println(Alist[temp-1].removeFirst());
        
    }
    
  
    
}
