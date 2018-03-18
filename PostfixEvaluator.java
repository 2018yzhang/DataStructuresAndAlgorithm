package expressions;
import expressions.*;
import org.junit.*;
import java.util.*;
/** 
* operand is a  Class to evaluate postfix
* 
* @author Yidan Zhang
* @version Septemeber 23, 2016
*/

public class PostfixEvaluator{
  /**
   * the method to evaluate postfixQueue
   * 
   * @param postfixQueue
   */
  public static int evaluate(Queue<Token> postfixQueue){
    Operand result;
 // System.out.println(postfixQueue);
    if(postfixQueue.isEmpty()){
      throw new IllegalArgumentException("Empty postfix expression");
    }
    Stack<Operand> opStack = new Stack<Operand>();
    while (!postfixQueue.isEmpty()){
      Token nextTok = postfixQueue.remove();
      if(nextTok instanceof Operand){
        opStack.push((Operand)nextTok);
      }
      else{
        if(opStack.isEmpty()){
          throw new IllegalArgumentException ("Operator with no operands");
        }
         Operand right = opStack.pop();
        if(opStack.isEmpty()){
          throw new IllegalArgumentException("Operator with only one operand");
        }
        Operand left = opStack.pop();
        System.out.println(right);
        System.out.println(left);
         result =((Operator)nextTok).evaluate(left,right);
        opStack.push(result);
      }
    }
    result=opStack.pop();
    if(!opStack.isEmpty()){
      throw new IllegalArgumentException("Too many operands");
    }
    return result.getValue();
  }
}