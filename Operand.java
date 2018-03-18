/*
 * File: Operand.java
 */
package expressions;

/** 
* operand is a Abstract Class implementing Token
* to get predence and evaluate
* 
* @author Casey Zins and Yidan Zhang
* @version Septemeber 23, 2016
*/
public abstract class Operand implements Token{
  public abstract int getValue();
  
  public Token.Type getType(){
    return Type.OPERAND;
  }    
}