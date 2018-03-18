/*
 * File: Token.java
 */

package expressions;

/**
 * Root interface for expression tokens hierarchy
 * 
 * @author J. Andrew Holey
 * @version September 22, 2008
 */
public interface Token {

 /**
  * The type of token. You can now use Type.XXX as a data type in your code where XXX is any of the following  
  * { OPERATOR, OPERAND, LEFT_PARENTHESIS, RIGHT_PARENTHESIS }. This will be needed to implement method 
  * "+getType() : Token.Type" in classes that implement interface Token
  */
 public static enum Type { OPERATOR, OPERAND, LEFT_PARENTHESIS, RIGHT_PARENTHESIS }
 
 /**
  * Return the type of this token.
  * 
  * @return the type of this token
  */
 public Token.Type getType();
 
 /**
  * Return a string representation of this token.
  * 
  * @return a string representation of this token
  */
 public String toString();
 

}
