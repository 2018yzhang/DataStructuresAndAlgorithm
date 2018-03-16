import java.util.*;
/*
 * The class for Function which generate a list of random number and do partition sorting and selection
 * 
 * @Author: Yidan Zhang
 * @Version: Feb.16, 2017
 */
public class Function{
  /*
   * the method generate a list of random values(which is less than 200)
   * 
   * @param size the size of list
   * @return the list
   */
  public ArrayList<Integer> generate(int size){
    ArrayList<Integer> arr = new ArrayList<Integer>();
    Random rand = new Random();
    for(int i=0;i<size;i++){
      arr.add(rand.nextInt(200));
    }
   
    return arr;
  }
  /*
   * the method to partition sort the list
   * 
   * @param list which user hopes to sort
   * 
   * @return the three lists after sorting
   */
  public ArrayList<ArrayList<Integer>> partition(ArrayList<Integer> list){
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> arrV = new ArrayList<Integer>();
    ArrayList<Integer> arrL = new ArrayList<Integer>();
    ArrayList<Integer> arrR = new ArrayList<Integer>();
    if(list.size()==0){
      throw new IllegalArgumentException("Error");
    }
    else if(list.size()==1){
      arrV = list;
    }
    else {
      Random rand = new Random();
      Integer p = rand.nextInt(list.size());
      Integer v = list.get(p);
      for(int i = 0; i<list.size();i++){
        if(list.get(i)<v){
          arrL.add(list.get(i));
        }
        else if(list.get(i)==v){
          arrV.add(list.get(i));
        }
        else{
          arrR.add(list.get(i));
        }
      }
    }
    arr.add(arrL);
    arr.add(arrV);
    arr.add(arrR);
    return arr;
  }
  /*
   * method do selection to return the smallest value
   * 
   * @param list which the user hope to use
   * @param k which makes sure the range you select
   * 
   * @return the kth smallest value
   */
  public Integer selection (ArrayList<Integer> list, int k){
    if((k<0)||(k>=list.size())||(list.size()<=0)){
      throw new IllegalArgumentException("Error");
    }
    Integer r =0;
    if(list.size()==1){
      r = list.get(0);
    }
    ArrayList<Integer> arrV = partition(list).get(1);
    ArrayList<Integer> arrL =partition(list).get(0);
    ArrayList<Integer> arrR = partition(list).get(2);
    if(k<arrL.size()){
      return selection (arrL,k);
    }
    else if(k<(arrL.size()+arrV.size())){
      r = arrV.get(0);
    }
    else{
      return selection (arrR,k-arrL.size()-arrV.size());
    }
    return r;
  }
  /*
   * the method to sorting the random list
   * 
   * @param list user hope to sort
   * @return the list after sorting
   */
  public  ArrayList<Integer> sortList (ArrayList<Integer> list){
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.addAll(list);
    Collections.sort(arr);

    return arr;
  }
  /*
   * the method to reversing the sorting
   * 
   * @param list which is needed to reverse
   * @return array after reverse
   */
  public ArrayList<Integer> reverseList(ArrayList<Integer>list){
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.addAll(list);
    Collections.reverse(arr);
    return arr;
  }
  /*
   * show the results by calling methods
   */
   public static void main(String[] args){
    Function f = new Function();
    ArrayList<Integer> arr = f.generate(15);
    System.out.println("Original list:");
    for(int i =0; i<arr.size();i++){
      System.out.print(arr.get(i)+" ");
    }
    System.out.println();
    System.out.println("Sorted list:");
    ArrayList<Integer> arr3 = f.sortList(arr);
    System.out.println(arr3);
    System.out.println();
    System.out.println("Reverse sorted list:");
    System.out.println(f.reverseList(arr3));
    System.out.println();
    System.out.println("Test for partition:");
    ArrayList<ArrayList<Integer>> arr2 = f.partition(arr);

    System.out.print(arr2);
    System.out.println();
    System.out.println("Test Selection:");
     Integer a = f.selection(arr,8);

     System.out.println(a);

  }
}
/*
 * comment: It usually shows "Error" when I run it. I think the reason is that every time when selection method call partition 
 * method which will generate a random value,which propabaly cause the parameter, k, of the selection method is equal 0.
 */