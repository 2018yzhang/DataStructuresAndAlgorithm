import java.util.*;

/*
 * The class for assignment which get numbers from user and convert them to array
 * 
 * @Author: Yidan Zhang
 * @Version: Jan.23, 2017
 */
public class Demonstration{
  //a new instance of Assignment.class
  public Assignment a;
  
  /*
   * constructor of the class which get the numbers from user and convert them to array
   * and then call methods from Assignment.class
   */
  public Demonstration() throws IllegalArgumentException{
    a = new Assignment();
    //get numbers from the user
    String num1 = null;
    String num2 = null;
    System.out.println("Please enter two different positive integers: ");
    Scanner sc = new Scanner(System.in);
    num1 = sc.nextLine();
    num2 = sc.nextLine();
    sc.close();
    
    //convert to arrays
    int comp = (num1.length())-(num2.length());
    if(comp==0){
      String[] arr1 = new String[num1.length()];
      String[] arr2 = new String[num2.length()];
      String[] sum = new String[num1.length()];
      
      
      for(int i=0;i<num1.length();i++){
        arr1[i]=String.valueOf(num1.charAt(i));
        arr2[i]=String.valueOf(num2.charAt(i));
      }
      
      //call methods to get results
      System.out.println("The sum of two integers is:");
      sum= a.add(arr1,arr2);
      for(int i=0; i< arr1.length+1;i++){
        System.out.print(sum[i]);
      }
      System.out.println();
      System.out.println("The product of two integers is:");
      System.out.println(a.multiplication(arr1,arr2));
    }
    
    //for different numbers of digits of two numbers
    else if(comp>0){
      String[] array1 = new String[num1.length()];
      String[] array2 = new String[num1.length()];
      String[] sum = new String[num1.length()];
      
      for(int i=0;i<num1.length();i++){
        array1[i]=String.valueOf(num1.charAt(i));
      }
      int j=num2.length(); 
      for(int i=num1.length()-1;i>comp-1;i--){
        array2[i]=String.valueOf(num2.charAt(j-1));
        j--;
      }
      for(int i=0;i<comp;i++){
        array2[i]= "0";
      }
      System.out.println("The sum of two integers is:");
      sum = a.add(array1,array2);
      for(int i=0; i< array1.length+1;i++){
        System.out.print(sum[i]);
      }
      System.out.println();
      System.out.println("The product of two integers is:");
      System.out.println(a.multiplication(array1,array2));
      
    }
    else{
      int k=num2.length()-num1.length();
      String[] array1 = new String[num2.length()];
      String[] array2 = new String[num2.length()];
      String[] sum = new String[num2.length()];
      
      for(int i=0;i<num2.length();i++){
        array2[i]=String.valueOf(num2.charAt(i));
      }
      int j=num1.length(); 
      for(int i=num2.length()-1;i>k-1;i--){
        array1[i]=String.valueOf(num1.charAt(j-1));
        j--;
      }
      for(int i=0;i<k;i++){
        array1[i]= "0";
      }
      
      System.out.println("The sum of two integers is:");
      sum= a.add(array2,array1);
      for(int i=0; i< array2.length+1;i++){
        System.out.print(sum[i]);
      }     
      System.out.println();
      System.out.println("The product of two integers is:");
      System.out.println(a.multiplication(array1,array2));
    }
  }
  public static void main(String[] args){
    new Demonstration(); 
  }
}