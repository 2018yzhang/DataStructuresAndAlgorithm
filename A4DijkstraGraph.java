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

public class DijkstraGraph{
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
     Random rand = new Random();
     int k = rand.nextInt(n*(n-1)/2);
     for(int i=0; i<k;i++){
       undirUnconEdges(undir,k, maxWeight);
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
  public void undirUnconEdges(int[][] graph, int k,int maxWeight){
      Random rand = new Random();
      int p = rand.nextInt(graph.length-1);
      int q = rand.nextInt(graph.length-1);
      if((p==q)||(graph[p][q]<=maxWeight)||(graph[q][p]<=maxWeight)){
      p = rand.nextInt(graph.length-1);
      q = rand.nextInt(graph.length-1);
      }
      graph[p][q]=(1)+(int)(Math.random()*maxWeight);
      graph[q][p]=(1)+(int)(Math.random()*maxWeight);
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
    Random rand = new Random();
    int k= (n-1)+(int)(Math.random()*(n*(n-1)/2));
    undir[0][1]=(1)+(int)(Math.random()*maxWeight);
    undir[1][0]=(1)+(int)(Math.random()*maxWeight);
    for(int i =2; i<=n-1;i++){
      int p= rand.nextInt(i-1);
      undir[i][p]=(1)+(int)(Math.random()*maxWeight);
      undir[p][i]=(1)+(int)(Math.random()*maxWeight);
    }
    return undir;
  }

   public int[] shortPath(int[][] graph, int s){
     ZYHeapPriorityQueue<Integer> q= new ZYHeapPriorityQueue<Integer>(graph.length);
 
     int[] dist = new int[graph.length];
     int[] prev = new int[graph.length];
     for(int i =0; i<graph.length;i++){
       dist[i]=Integer.MAX_VALUE;
       prev[i]=-1;
     }
   //   System.out.println(Arrays.toString(dist));
     dist[s]=0;
     
     for(int j=0; j<graph.length;j++){
       q.enqueue(j);
     }
     
     while(!q.isEmpty()){
       int k = q.dequeue();
       for(int m =0; m<graph.length;m++){

           if(dist[m]>dist[k]+graph[k][m]){
             dist[m]=dist[k]+graph[k][m];
          
             prev[m]=k;
             q.enqueue(m);
           }
       }
     }
    System.out.println("Previsit List");
    System.out.println(Arrays.toString(prev));
     return dist;
   }
   
  
  /*
   * test every method
   */
  public static void main(String[] args) throws IOException{
    DijkstraGraph dg = new DijkstraGraph();
    int [][] graph =dg.init(5);
    for(int i=0;i<graph.length;i++){
      for(int j =0;j<graph.length;j++){
        System.out.print(graph[i][j]+" ");
      }
      System.out.println();
    }
    
    System.out.println("Undirected Unconnected Graph:");
    int [][] graph1 =dg.undirUnconGraph(10, 5);
    for(int i=0;i<graph1.length;i++){
      for(int j =0;j<graph1.length;j++){
        System.out.print(graph1[i][j]+" ");
      }
      System.out.println();
    }

   System.out.println("Undirected connected Graph:");
    int [][] graph2 =dg.undirConGraph(7,10);
    for(int i=0;i<graph2.length;i++){
      for(int j =0;j<graph2.length;j++){
        System.out.print(graph2[i][j]+" ");
      }
      System.out.println();
    }

    
      
     System.out.println("short path: "+Arrays.toString(dg.shortPath(graph2,5)));
    
}
}