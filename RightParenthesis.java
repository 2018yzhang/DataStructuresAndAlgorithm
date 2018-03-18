/*
 * File: rightParenthesis.java
 */
package expressions;

public class RightParenthesis implements Token{
    public Token.Type getType(){
    return Type.RIGHT_PARENTHESIS;
  }
  public String toString(){
    return ")";
  }
}