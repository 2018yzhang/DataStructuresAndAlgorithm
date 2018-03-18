/**
 * File: Minue.java
 */
package expressions;
public class Minus extends Operator{
   /**
   * method get predence
   */
  public  int getPredence(){
   return 1; 
  }
  
  /**
   * method to evaluate addition
   * 
   * @param op
   * @param er
   */
  
  public Operand evaluate(Operand op, Operand er){
    return new IntegerLiteral (op.getValue()-er.getValue());
  }
  
  public String toString(){
    return "-"; 
  }
}

