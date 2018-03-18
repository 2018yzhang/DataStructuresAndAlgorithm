package expressions;
import expressions.*;
import org.junit.*;
import java.util.*;
import zystructures.*;
public class InfixToPostfixV2{
  /**
   * the method to convert infix to postfix
   * 
   * @ infixQueue the original content
   */
  public static ZYLinkedQueue<Token> convert(ZYLinkedQueue<Token> infixQueue){
    if(infixQueue.isEmpty()){
      throw new IllegalArgumentException("Empty infix expression");
    }
    ZYLinkedQueue<Token> postfixQueue = new ZYLinkedQueue<Token>();
    ZYLinkedStack<Token> opStack = new ZYLinkedStack<Token>();
    while(!infixQueue.isEmpty()){
 //     Token nextTok = infixQueue.remove();
   Token nextTok = infixQueue.dequeue();
//      for(int i=0; i<size-1;i++){
//        infixQueue[i]=infixQueue[i+1];
//      }
//      size--;
     
      if(nextTok instanceof Operand){
       postfixQueue.enqueue(nextTok);
      }
      else if(nextTok instanceof LeftParenthesis){
        opStack.push(nextTok);
      }
      else if(nextTok instanceof RightParenthesis){
        processRightParenthesis(opStack, postfixQueue);
      }
      else{
        processOperator(opStack,postfixQueue,(Operator)nextTok);
      }
    }
    while(!opStack.isEmpty()){
      Token nextOp=opStack.pop();
      if(nextOp instanceof LeftParenthesis){
        throw new IllegalArgumentException("Unmatched left parenthesis");
      }
       postfixQueue.enqueue(nextOp);
    }
    return postfixQueue;
  }
  /**
   * The method to process right parenthesis 
   * 
   * @parameter opstack stack as Token type 
   * @parameter postdixQueue the queue of result
   */
  private static void processRightParenthesis(ZYLinkedStack<Token> opStack, ZYLinkedQueue<Token> postfixQueue){
    while(!opStack.isEmpty() && (opStack.peek() instanceof LeftParenthesis==false)){
      postfixQueue.enqueue( opStack.pop());
    }
    if(opStack.isEmpty()){
      throw new IllegalArgumentException("Unmatched right parenthesis");
    }
    opStack.pop();
  }
  
  /**
   * the method to process Operator 
   * 
   * @param opstack 
   * @param postfixQueue
   * @param op
   */
  private static void processOperator(ZYLinkedStack<Token> opStack,ZYLinkedQueue<Token> postfixQueue, Operator op){
    Token topTok=null;
    if(!opStack.isEmpty()){
      topTok = opStack.peek();
    }
    while(!opStack.isEmpty() && (topTok instanceof LeftParenthesis==false)&& (op.getPredence()<=((Operator)topTok).getPredence())){
      postfixQueue.enqueue(opStack.pop());
      if(!opStack.isEmpty()){
        topTok = opStack.peek();
      }
    }
    opStack.push(op);
  }
}