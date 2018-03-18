/*
 * File: Tokenizer.java
 */

package expressions;

import java.util.*;
import zystructures.*;
/**
 * Class that encapsulates methods for extracting tokens from a String
 * that represents an arithmetic expression.
 * 
 * @author <your name here>, based on a template by J. Andrew Holey
 * @version September 25, 2008
 */
public class TokenizerV2 {

 /**
  * Returns a Token based on the supplied token string.
  * 
  * @param tokenStr the string the token is to be based on
  * @return a Token based on the supplied token string
  * @throws IllegalArgumentException if tokenStr doesn't represent a valid token
  */
 public static Token makeToken(String tokenStr) {
  Token result=null;
  // TODO: fill in method and replace return statement if need be
  
    char ope =tokenStr.charAt(0);
    if(!Character.isDigit(ope)&& tokenStr.length()!=1){
      throw new IllegalArgumentException("String cannot be more than a digit or native") ;
    }
   if (!Character.isDigit(ope)){
    switch(ope){
      case '+':
        result = new Plus();
        break;
        
      case '-':
        result = new Minus();
        break;
        
      case '/':
        result = new Divide();
        break;
        
      case '*':
        result = new Times();
        break;
        
      case '%':
        result=new Reminder();
        break;
        
      case '(':
        result = new LeftParenthesis();
        break;
      case ')':
        result = new RightParenthesis();
        break;
        
      default:
        throw new IllegalArgumentException("String does not match any token types");
    }
    
    }
   else{
      
      result = new IntegerLiteral(tokenStr);
    }
   
   
  return result;
 }
 
 /**
  * Parses the supplied token string and returns a queue of tokens.
  * 
  * @param tokensStr the string the tokens are to be parsed from
  * @return a queue of tokens in the same order they appeared in the original string
  * @throws IllegalArgumentException if tokensStr contains unparseable subsequences
  */
 public static ZYLinkedQueue<Token> parseString(String tokensStr) {
  ZYLinkedQueue<Token> result=null;
  // TODO: fill in method and replace return statement if need be
  ZYLinkedQueue<Token> de = new ZYLinkedQueue<Token>();
  int i=0;
  while(i<tokensStr.length()){
    if(tokensStr.charAt(i)=='+'||tokensStr.charAt(i)=='-'||tokensStr.charAt(i)=='*'||tokensStr.charAt(i)=='/'
         ||tokensStr.charAt(i)=='%'||tokensStr.charAt(i)=='('||tokensStr.charAt(i)==')'){
      Token t = makeToken(""+tokensStr.charAt(i));
      de.enqueue(t);
      i++;
    }
    else if(Character.isDigit(tokensStr.charAt(i))){
//      for(int j=i+1;j<=tokensStr.length();j++){
//        result.add(makeToken(tokensStr.substring(i,j-1)));
//        i=j;
//      }
      String num="";
      while(i<tokensStr.length()&& Character.isDigit(tokensStr.charAt(i))){
        num+=tokensStr.charAt(i);
        i++;
      }
      de.enqueue(makeToken(num));
    }
    else if(tokensStr.charAt(i)==' '){
      i++;
    }
    else{
        throw new IllegalArgumentException("It cannot match token");
    }
  }
  return de;
 }
}
