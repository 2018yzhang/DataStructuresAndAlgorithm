/*
 * File: operator.java
 */
package expressions;


/** 
* operator is a Abstract Class implementing Token
* to get predence and evaluate
* 
* @author Casey Zins and Yidan Zhang
* @version Septemeber 23, 2016
*/
public abstract class Operator implements Token{
  
  /**
   * abstract method get predence
   */
  public abstract int getPredence();
  
  /**
   * abstract method evaluate
   * 
   * @param op
   * @param er
   */
  
  public abstract Operand evaluate(Operand op, Operand er);
   
   public Token.Type getType(){
     return Type.OPERATOR;
   }
 
}