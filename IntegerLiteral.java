/**
 * File: IntegerLiteral.java
 */
package expressions;
/** 
* IntegerLiteral is a  Class implementing operand
* to get value and return
* 
* @author Casey Zins and Yidan Zhang
* @version Septemeber 23, 2016
*/
public class IntegerLiteral extends Operand{
  /**
   * variable num which is the value of string param
   */
  private int num;
  
  /**
   * constructor with para String to convert string to integer
   * 
   * @param st the string represent the value
   */
  public IntegerLiteral(String st){
    try{
      num = Integer.parseInt(st);
    }  catch( IllegalArgumentException iae){
      return;
    }
  }
  
  
  /**
   * constructor with para int to pass para to num
   * 
   * @param i the int number represent the value
   */
  public IntegerLiteral(int i){
    this.num=i;
  }
  /**
   * method that return num
   */
  public int getValue(){
    return num;
  }
  
  /**
   * return num as a string
   */
  public String toString(){
    return ""+num;
  }
}