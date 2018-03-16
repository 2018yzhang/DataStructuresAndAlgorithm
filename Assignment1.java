import java.util.*;
/*
 * The class for assignment which includes two method: add() and multiplication()
 * 
 * @Author: Yidan Zhang
 * @Version: Feb.23, 2017
 */
public class Assignment {
  /*
   * the method to add two positive different-digit integers
   * 
   * @param arr1 the first integer as string[]
   * @param arr2 the first integer as string[]
   * 
   * @throw IllegalArgumentException
   * @return the result of addtion
   */
  public static String[] add(String[] arr1, String[] arr2) throws IllegalArgumentException{
    int carry =0;
    int s=0;
    String[] sum = new String[arr1.length+1];
    for(int i =arr1.length-1; i>-1;i--){
      s=Integer.parseInt(arr1[i])+Integer.parseInt(arr2[i])+carry;
      carry = s/10;
      sum[i+1]=Integer.toString(s%10);
    }
    sum[0]=Integer.toString(carry);
    
    return sum;
  }
  
    /*
   * the method to multiplication two positive different-digit integers
   * 
   * @param arr1 the first integer as string[]
   * @param arr2 the first integer as string[]
   * 
   * @throw IllegalArgumentException
   * @return the result of multiplication
   */
  public static String multiplication(String[] arr1, String[] arr2) throws IllegalArgumentException{
    int j = arr2.length-1;
    String sumP="";
    
    //get result of one digit by one digit
    List<String> s = new ArrayList<String>();
    while(j>-1){
      s.add(multHelper(arr1, arr2[j]));
      j--;
    }
    
    //set 0;
    for(int i =0; i<s.size();i++){
      s.set(i,s.get(i)+Long.toString((long)Math.pow(10,i)).substring(1));
      int comp = arr1.length*2-s.get(i).length();
      s.set(i,Long.toString((long)Math.pow(10,comp)).substring(1)+s.get(i));
    }
   
    //sum all
    int carry =0;
    int sum=0;
    for(int u = arr1.length*2-1; u>-1;u--){
      sum=0;
      for(int w =0; w<s.size();w++){
        sum=sum+Integer.parseInt(String.valueOf(s.get(w).charAt(u)));
      }
      sum+=carry;
      carry=sum/10;
      sumP=Integer.toString(sum % 10) + sumP; 
    }
    sumP = Integer.toString(sum%10)+sumP;
    
    return sumP;
  }
  /*
   * the method to help multiplication one original integer and one digit of the second integer
   * 
   * @param arr1 the first integer as string[]
   * @param arr2 one of the digit of the second integer
   * 
   * @throw IllegalArgumentException
   * @return the result of multiplication
   */
  public static String multHelper(String[] arr1, String arr2) throws IllegalArgumentException{
    int carry =0;
    int prod;
    String[] mult = new String[arr1.length*2];
    String[] result = new String[arr1.length+1];
    
    for(int i =arr1.length-1; i>-1;i--){
      prod=Integer.parseInt(arr1[i])*Integer.parseInt(arr2)+carry;
      carry = prod/10;
      result[i+1]=Integer.toString(prod%10);
    }
    result[0]=Integer.toString(carry);
    
    
    StringBuffer sb = new StringBuffer();
    for(int i =0;i<result.length;i++){
      sb.append(result[i]);
    }
    String s = sb.toString();
    return s;
  }
}