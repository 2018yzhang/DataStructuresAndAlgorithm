/**
 * File: Times.java
 */
package expressions;
public class Times extends Operator{
  Operand times;
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
   */
  
  public Operand evaluate(Operand op, Operand er){
   return new IntegerLiteral (op.getValue()*er.getValue());
  }
  
  public String toString(){
    return "*";
  } 
}
