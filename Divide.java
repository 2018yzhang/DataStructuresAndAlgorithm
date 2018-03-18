/**
 * File: Divide.java
 */
package expressions;

/** 
* operand is a Abstract Class implementing Token
* to get predence and evaluate
* 
* @author Casey Zins and Yidan Zhang
* @version Septemeber 23, 2016
*/
public class Divide extends Operator{
 /**
   * method get predence
   */
  public  int getPredence(){
   return 2; 
  }
  
  /**
   * method to evaluate addition
   * 
   * @param op
   * @param er
   * @return return the value as operand type
   */
  
  public Operand evaluate(Operand op, Operand er){
   
    return  new IntegerLiteral(op.getValue()/er.getValue());
  }
  /**
   * return string representing division 
   */
  public String toString(){
    return "/";
  } 
}
