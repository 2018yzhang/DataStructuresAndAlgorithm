/*
 * The class for creating table to match the sequence
 * 
 * @Author: Yidan Zhang
 * @Version: Mar. 31, 2017
 */
public class SequenceAlignment{
  /**
   * sequence Alignment 
   * 
   * @param x the first string
   * @param y the second string
   * 
   * @return one object which contains two tables
   */
  public Combination editDistance(String x, String y) {
    int[][] dist=new int[x.length()][y.length()];
    String[][] direc=new String[x.length()][y.length()];
    
    dist[0][0] =0;
    direc[0][0]=null;
    
    for(int i =1; i<x.length();i++){
      dist[i][0]=i;
      direc[i][0]="^";
    }
    for(int j=1;j<y.length();j++){
      dist[0][j] = j;
      direc[0][j] ="<";
    }
    
    for(int i =1; i<x.length();i++){
      for(int j=1;j<y.length();j++){
        int distUp = dist[i-1][j]+1;
        int distLeft = dist[i][j-1]+1;
        int distDiag;
        if(x.charAt(i)==(y.charAt(j))){
           distDiag = dist[i-1][j-1]+0;
        }
        else{
           distDiag = dist[i-1][j-1]+1;
        }
        dist[i][j] =this.min(distUp, distLeft, distDiag);
        direc[i][j]=null;
        if(dist[i][j]==distUp){
          direc[i][j]="^";
        }
        if(dist[i][j]==distLeft){
          direc[i][j]="<";
        }
        if(dist[i][j]==distDiag){
          direc[i][j]="/";
        }
      }
    }
    return new Combination(dist, direc);
  }
  
  /**
   * find the minimum value of three numbers
   * @param i an integer needs to be compared
   * @param j an integer needs to be compared
   * @param k an integer needs to be compared
   * @return minimum value of these three params
   */
  public int min(int i, int j, int k){
    if(i<j){
      if(i<k){
        return i;
      }
      else{
        return k;
      }
    }
    else{
      if(j<k){
        return j;
      }
      else{
        return k;
      }
    }
  }
  /**
   * testing the method by using three different group words 
   */
  public static void main(String[] args){
    SequenceAlignment sa = new SequenceAlignment();
    System.out.println("Identical");
    int[][] arr1 = sa.editDistance("same", "same").getArr1();
    for(int row =0; row<arr1.length;row++){
      for(int j=0; j<arr1[row].length;j++){
        System.out.printf("%4d",arr1[row][j]);
      }
      System.out.println();
    }
    
    String[][] arr2= sa.editDistance("same", "same").getArr2();
     for(int row =0; row<arr2.length;row++){
      for(int j=0; j<arr2[row].length;j++){
        System.out.printf("%4s",arr2[row][j]);
      }
      System.out.println();
    }
     System.out.println("Similar");
    int[][] arr3 = sa.editDistance("difficult", "different").getArr1();
    for(int row =0; row<arr3.length;row++){
      for(int j=0; j<arr3[row].length;j++){
        System.out.printf("%4d",arr3[row][j]);
      }
      System.out.println();
    }
    
    String[][] arr4= sa.editDistance("difficult", "different").getArr2();
     for(int row =0; row<arr4.length;row++){
      for(int j=0; j<arr4[row].length;j++){
        System.out.printf("%4s",arr4[row][j]);
      }
      System.out.println();
    }
     System.out.println("Different");
         int[][] arr5 = sa.editDistance("mobile", "watch").getArr1();
    for(int row =0; row<arr5.length;row++){
      for(int j=0; j<arr5[row].length;j++){
        System.out.printf("%4d",arr5[row][j]);
      }
      System.out.println();
    }
    
    String[][] arr6= sa.editDistance("mobile", "watch").getArr2();
     for(int row =0; row<arr6.length;row++){
      for(int j=0; j<arr6[row].length;j++){
        System.out.printf("%4s",arr6[row][j]);
      }
      System.out.println();
    }
  }
  
}