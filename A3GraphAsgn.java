import java.util.*;
import java.io.*;

/*
 * The class for creating different types of graph and doing depth first search for these graph
 * 
 * @Author: Yidan Zhang
 * @Version: Feb.22, 2017
 */
public class GraphAsgn{
  
  public int n, compNum;
  //three list to record the order of visiting for search
  ArrayList<Integer> previsit = new ArrayList<Integer>();
  ArrayList<Integer> postvisit = new ArrayList<Integer>();
  ArrayList<Integer> visit = new ArrayList<Integer>();
   int[] visited;
   
   /*
    * the method to create a graph without edges
    * 
    * @param n the number of vertext
    * 
    * @return the graph without edges
    */
  public int[][] init(int n){

    int [][]adjMat;
    adjMat=new int[n][n];
    for(int i=0; i<n;i++){
      for(int j=0; j<n;j++){
        adjMat[i][j]=0;
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
  public int[][] undirUnconGraph(int n){

    int [][]undir=new int[n][n];
    Random rand = new Random();
    int k = rand.nextInt(n*(n-1)/2);
     for(int i=0; i<k;i++){
       undirUnconEdges(undir,k);
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
  public void undirUnconEdges(int[][] graph, int k){
      Random rand = new Random();
      int p = rand.nextInt(graph.length-1);
      int q = rand.nextInt(graph.length-1);
      if((p==q)||(graph[p][q]==1)||(graph[q][p]==1)){
       undirUnconEdges(graph,k);
      }
      graph[p][q]=1;
      graph[q][p]=1;
    }
  
       /*
    * the method to create a undirected and connected graph 
    * 
    * @param n the number of vertext
    * 
    * @return the graph which is undirected and connected 
    */
  public int[][] undirConGraph(int n){
    int [][]undir=new int[n][n];
    Random rand = new Random();
    int k= (n-1)+(int)(Math.random()*(n*(n-1)/2));
    undir[0][1]=1;
    undir[1][0]=1;
    for(int i =2; i<=n-1;i++){
      int p= rand.nextInt(i-1);
      undir[i][p]=1;
      undir[p][i]=1;
    }
    return undir;
  }
  
   /*
    * the method to read the matrix of the graph in a file
    * 
    * @param sc is the scanner the system use
    * 
    * @return the graph which is created from the file
    */
  public int[][] readGraph(Scanner sc) throws IOException{
      int [][]graph=null;
      while(sc.hasNext()){
        int n = sc.nextInt();
        graph = new int[n][n];
        for(int i =0; i<n;i++){
          for(int j =0; j<n;j++){
            graph[i][j]=sc.nextInt();
          }
        }
      }
      sc.close();
      return graph;
  }
  
       /*
    * the method to write the matrix of graph to a file
    * 
    * @param graph the user hopes to write
    * @param pw the printwriter the system use
    * 
    */
  public void writeGraph(PrintWriter pw,int[][] graph)throws IOException{
    int n = graph.length;
  
    pw.println(n);
    for(int i =0;i<n;i++){
      for(int j =0;j<n;j++){
        pw.print(graph[i][j]+" ");
      }
      pw.println();
    }
    pw.close();
  }
  

   /*
    * the method to explore the vertext to visit
    * 
    * @param graph need to visit
    * @param v the start point
    * 
    * @return visited list
    */
  
  public int[] explore(int[][] graph, int v){
    if(v<0||v>graph.length-1){
      throw new IllegalArgumentException("Error");
    }
    visited[v]=compNum;
    visit.add(v);
    previsit.add(v);

      for(int j =0;j<graph.length;j++){
        if((graph[v][j]==1)&&(visited[j]<0)){
          explore(graph,j);
          compNum++;
        }

    }
    postvisit.add(v);

    return visited;
  }
       /*
    * the method to do depth first search
    * 
    * @param graph need to visit
    * 
    * @return visited list
    */
  public int[] dfs2(int[][] graph){
    visited=new int[graph.length];
    for(int i =0;i<graph.length;i++){
      visited[i]=-1;
    }
    compNum=0;
    for(int i=0;i<graph.length;i++){
      if(visited[i]<0){
        explore(graph, i);
        compNum++;
      }
    }
    System.out.println("Previsit List");
    System.out.println(previsit);
    System.out.println("Visit List");
    System.out.println(visit);
    System.out.println("Postvisit List");
    System.out.println(postvisit);
    return visited;
  }
  
  /*
   * test every method
   */
  public static void main(String[] args) throws IOException{
    GraphAsgn ga = new GraphAsgn();
    int [][] graph =ga.init(5);
    for(int i=0;i<graph.length;i++){
      for(int j =0;j<graph.length;j++){
        System.out.print(graph[i][j]+" ");
      }
      System.out.println();
    }
    
    System.out.println("Undirected Unconnected Graph:");
    int [][] graph1 =ga.undirUnconGraph(10);
    for(int i=0;i<graph1.length;i++){
      for(int j =0;j<graph1.length;j++){
        System.out.print(graph1[i][j]+" ");
      }
      System.out.println();
    }
    
    System.out.println("Undirected connected Graph:");
    int [][] graph2 =ga.undirConGraph(7);
    for(int i=0;i<graph2.length;i++){
      for(int j =0;j<graph2.length;j++){
        System.out.print(graph2[i][j]+" ");
      }
      System.out.println();
    }
    
    System.out.println("Read from a file");
     File file = new File("graph");
    Scanner sc = new Scanner(file);
    int [][] graph3 =ga.readGraph(sc);
    for(int i=0;i<graph3.length;i++){
      for(int j =0;j<graph3.length;j++){
        System.out.print(graph3[i][j]+" ");
      }
      System.out.println();
    }
    
    
    File fileW = new File("graphW");
    PrintWriter pw = new PrintWriter(fileW);
    ga.writeGraph(pw, graph1);
    System.out.println("Finish to write to a file");
    
      System.out.println("Depth First Search:");
     ga.dfs2(graph2).toString();
    
  }
  

}