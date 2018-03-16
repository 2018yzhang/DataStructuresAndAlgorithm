import java.util.*;
import java.io.*;
import zhstructures.*;
import zystructures.*;
/*
 * The class for creating different types of graph and doing depth first search for these graph
 * 
 * @Author: Yidan Zhang
 * @Version: Mar. 5, 2017
 */

public class FloydWarshall{
  int [][]adjMat;

   /*
    * the method to create a graph without edges
    * 
    * @param n the number of vertext
    * 
    * @return the graph without edges
    */
   public int[][] init(int n){
    adjMat=new int[n][n];
    for(int i=0; i<n;i++){
      for(int j=0; j<n;j++){
        adjMat[i][j]=Integer.MAX_VALUE;
      }
    }
    return adjMat;
  }
   
   /*
    * the method to create a undirected and unconnected graph 
    * 
    * @param n the number of vertext
    * 
    * @return the graph which is undirected and unconnected 
    */
   public int[][] undirUnconGraph(int n,int maxWeight){
     
       int [][]undir=init(n);
  //   int[][] undir = new int[n][n];
     Random rand = new Random();
     int k = rand.nextInt(n*(n-1)/2);
     for(int i=0; i<k;i++){
       undirUnconEdges(undir,maxWeight);
     }
     return undir;
  }
    /*
   * the method to help add edges to graph for unconnected
   * 
   * @param graph need to add the edges
   * @param k is the random number of edges
   *
   */
  public void undirUnconEdges(int[][] graph,int maxWeight){
      Random rand = new Random();
      int p = rand.nextInt(graph.length-1);
      int q = rand.nextInt(graph.length-1);
      if((p==q)||(graph[p][q]!=Integer.MAX_VALUE)||(graph[q][p]!=Integer.MAX_VALUE)){
        undirUnconEdges(graph,maxWeight);
      }
      else{
         int dist=(1)+(int)(Math.random()*maxWeight);
         graph[p][q]=dist;
      graph[q][p]=dist;
       }
    }
    /*
    * the method to create a undirected and connected graph 
    * 
    * @param n the number of vertext
    * 
    * @return the graph which is undirected and connected 
    */
  public int[][] undirConGraph(int n, int maxWeight){
     int [][]undir=init(n);
 //   int [][]undir=new int[n][n];
    Random rand = new Random();
    int k= (n-1)+(int)(Math.random()*(n*(n-1)/2));
    int d = (1)+(int)(Math.random()*maxWeight);
    undir[0][1]=d;
    undir[1][0]=d;
    for(int i =2; i<=n-1;i++){
      int p= rand.nextInt(i-1);
      int dist = (1)+(int)(Math.random()*maxWeight);
      undir[i][p]=dist;
      undir[p][i]=dist;
    }
    return undir;
  }

   public int[][] floysWarshall(int[][] graph){
     int[][] dis = new int[graph.length][graph.length];
     for(int k =0;k<graph.length;k++){
       for(int i=0;i<graph.length;i++){
         for(int j=0;j<graph.length;j++){
           if(graph[i][k]+graph[k][j]<graph[i][j]){
             graph[i][j]=graph[i][k]+graph[k][j];
             dis[i][j]=k;
           }
         }
       }
     }
     return dis;
   }
   
  
  /*
   * test every method
   */
  public static void main(String[] args) throws IOException{
    FloydWarshall fw = new FloydWarshall();
    int [][] graph =fw.init(5);
    for(int i=0;i<graph.length;i++){
      for(int j =0;j<graph.length;j++){
        System.out.print(graph[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println("FloydWarshall");
    
    int[][] result=fw.floysWarshall(graph);
    for(int i =0;i<result.length;i++){
      for(int j=0;j<result.length;j++){
        System.out.print(result[i][j]+" ");
      }
      System.out.println();
    }
    
    System.out.println("Undirected Unconnected Graph:");
    int [][] graph1 =fw.undirUnconGraph(5, 8);
    for(int i=0;i<graph1.length;i++){
      for(int j =0;j<graph1.length;j++){
        System.out.print(graph1[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println("FloydWarshall");
    
    int[][] result1=fw.floysWarshall(graph1);
    for(int i =0;i<result1.length;i++){
      for(int j=0;j<result1.length;j++){
        System.out.print(result1[i][j]+" ");
      }
      System.out.println();
    }
    
   System.out.println("Undirected connected Graph:");
    int [][] graph2 =fw.undirConGraph(7,10);
    for(int i=0;i<graph2.length;i++){
      for(int j =0;j<graph2.length;j++){
        System.out.print(graph2[i][j]+" ");
      }
      System.out.println();
    } 
    System.out.println("FloydWarshall");
    
    int[][] result2=fw.floysWarshall(graph2);
    for(int i =0;i<result2.length;i++){
      for(int j=0;j<result2.length;j++){
        System.out.print(result2[i][j]+" ");
      }
      System.out.println();
    }
    
    
}
}