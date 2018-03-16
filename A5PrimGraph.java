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

public class PrimGraph{
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

   public void primSpanning(int[][] graph, int s){
    
  ZYHeapPriorityQueue< Integer> q= new ZYHeapPriorityQueue<Integer>();
  Stack<Integer> st = new Stack<Integer>();
     int[] cost = new int[graph.length];
     int[] prev = new int[graph.length];
     int[] visited = new int[graph.length];
     for(int i =0; i<graph.length;i++){
       cost[i]=Integer.MAX_VALUE;
       prev[i]=-1;
       visited[i]=-1;
     }
     for(int j=0; j<graph.length;j++){
       q.enqueue(cost[j]);
       st.push(j);
     }
          cost[s]=0;
  
        
        while((!q.isEmpty())&&(!st.empty())){
          int v = st.pop();
          for(int k =0; k<graph.length;k++){
            if(cost[k]>graph[v][k]){
              cost[k]=graph[v][k];
              prev[k]=v;
              q.enqueue(cost[k]);
              st.push(k);
            }
          }
        }
      //  while()
        
   System.out.println("The cost:");
   System.out.println(Arrays.toString(cost));
   System.out.println("The previst:");
   System.out.println(Arrays.toString(prev));
//  
//     int total =0;
//     int mincost=0;
//     s=0;
//     visited[s] =1;
//     cost[s]=0;
//     total=1;
//    
//     while(total!=graph.length){
//       for(int i =0;i<graph.length;i++){
//  
//         if(visited[s]!=1){
//         if(cost[i]>graph[s][i]){
//           cost[i]=graph[s][i];
//           prev[i]=s;
//           System.out.println("prev "+prev[i]);
//         }
//         
//       }
//     }
//     mincost = Integer.MAX_VALUE;
//     for(int j =0; j<graph.length;j++){
//       if(visited[j]!=1){
//         if(cost[j]<mincost){
//           mincost=cost[j];
//           s =j;
//         }
//       }
//     }
//     visited[s]=1;
//     total++;
//     }
//  //   mincost=0;
//     for(int k=0;k<graph.length;k++){
//       mincost = mincost+cost[k];
//       System.out.println("Minimum cost= "+mincost);
//        System.out.print("\n vertex "+k+" is connected to "+prev[k]);
//     }
     
   }
   
  
  /*
   * test every method
   */
  public static void main(String[] args) throws IOException{
    PrimGraph dg = new PrimGraph();
    int [][] graph =dg.init(5);
    for(int i=0;i<graph.length;i++){
      for(int j =0;j<graph.length;j++){
        System.out.print(graph[i][j]+" ");
      }
      System.out.println();
    }
    dg.primSpanning(graph, 0);
    
    System.out.println("Undirected Unconnected Graph:");
    int [][] graph1 =dg.undirUnconGraph(5, 8);
    for(int i=0;i<graph1.length;i++){
      for(int j =0;j<graph1.length;j++){
        System.out.print(graph1[i][j]+" ");
      }
      System.out.println();
    }
    dg.primSpanning(graph1, 0);
   System.out.println("Undirected connected Graph:");
    int [][] graph2 =dg.undirConGraph(7,10);
    for(int i=0;i<graph2.length;i++){
      for(int j =0;j<graph2.length;j++){
        System.out.print(graph2[i][j]+" ");
      }
      System.out.println();
    }

    
      
    dg.primSpanning(graph2, 0);
    
}
}