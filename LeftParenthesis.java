/*
 * File: leftParenthesis.java
 */
package expressions;

public class LeftParenthesis implements Token{
  public Token.Type getType(){
    return Type.LEFT_PARENTHESIS;
  }
  public String toString(){
    return "(";
  }
}