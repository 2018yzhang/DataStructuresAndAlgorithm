/**
 * File: Reminder.java
 */
package expressions;
public class Reminder extends Operator{
  Operand mod;
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
   return new IntegerLiteral (op.getValue()%er.getValue());
  }
  
  public String toString(){
    return "%";
  } 
}
