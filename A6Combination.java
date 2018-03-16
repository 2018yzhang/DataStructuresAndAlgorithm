/*
 * The class for combine two objects together
 * 
 * @Author: Yidan Zhang
 * @Version: Mar. 31, 2017
 */
public class Combination{
  //an array as integer type
  public int[][] arr1;
  
  // an array as string type
  public String[][] arr2;
  
  /**
   * constructor: assign two arrays
   */
  public Combination(int[][] arr1, String[][] arr2){
    this.arr1 = arr1;
    this.arr2 = arr2;
  }
  /**
   * get integer array
   * @return arr1
   */
  public int[][] getArr1(){
    return this.arr1;
  }
  
    /**
   * get integer array
   * @return arr1
   */
  public String[][] getArr2(){
    return this.arr2;
  }
}