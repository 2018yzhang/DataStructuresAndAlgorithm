/*
 * File: ZYLinkedIndexedList.java
 */

package zystructures;

import java.util.*;
import zhstructures.*;
import java.io.*;


/**
 * Class for a list accessed by element index (0 .. size-1). 
 * Represents a simplified List
 * 
 * @author J. Andrew Holey & Imad M. Rahal, Marcus Langley and Yidan Zhang
 * @version February 20, 2015, version 2: 10-14-2016
 */
public class ZYLinkedIndexedList<ElementType> implements ZYIndexedList<ElementType>, Serializable {
  
  /**
   * The head Node of the List.
   */
  private ListNode head;
  
  
  /**
   * The size of the MKLLinkedIndexedList
   */
  private int size;
  
  /**
   * Default constructor to create an empty MKLLinkedIndexedList
   */
  public ZYLinkedIndexedList()
  {
    this.size = 0;
    head = new ListNode();
  }
  
  /**
   * Returns true if this list contains no elements.
   * 
   * @return true if this list contains no elements
   */
  public boolean isEmpty(){
    return size==0;
  }
  
  /**
   * Returns true if this list contains an element equal to the specified element 
   * under the "equals" method.
   * 
   * @param  element the ElementType object to test for presence in this collection
   * @return true if this list contains the specified element
   */
  public boolean contains(ElementType element){
    return head.contains(element);
  }
  
  /* (non-Javadoc)
   * @see java.lang.Iterable#iterator()
   */
  public Iterator<ElementType> iterator(){
    return head.iterator();
  }
  
  /**
   * Returns the number of elements in this list.
   * 
   * @return the number of elements in this list
   */
  public int size(){
    return this.size;
  }
  
  /**
   * Gets the element at the specified index in the list (0 .. size-1).
   * Pre: index >= 0 and index < size
   * 
   * @param index the position to get the element from (0 .. size-1), inclusive
   * @return the element at the specified index
   * @throws IndexOutOfBoundsException if precondition is false
   */
  public ElementType get(int index){
    if(index<0||index>=size)
      throw new IndexOutOfBoundsException("The index is invalid");
    return head.get(index);
  }
  
  /**
   * Sets the element at the specified index in the list (0 .. size-1)
   * to the specified newValue and returns the previous value.
   * Pre: index >= 0 and index < size
   * 
   * @param index the position to set the element from (0 .. size-1), inclusive
   * @param newValue the new value to put at the specified position
   * @return the old value at the specified position
   * @throws IndexOutOfBoundsException if precondition is false
   */
  public ElementType set(int index, ElementType newValue){
     if(index<0||index>=size)
      throw new IndexOutOfBoundsException("The index is invalid");
    return head.set(index, newValue);
  }
  
  /**
   * Inserts the specified element at the specified index (0 .. size)
   * and increments the indices of any following elements. An index of 0
   * inserts the element at the beginning of the list; an index of size
   * appends the element to the end of the list.
   * Pre: index >= 0 and index <= size
   * 
   * @param index the position at which to insert the element (0 .. size), inclusive
   * @param element the element to be inserted
   * @throws IndexOutOfBoundsException if precondition is false
   */
  public void addElementAt(int index, ElementType element){
     if(index<0||index>size)
      throw new IndexOutOfBoundsException("The index is invalid");
     head.addElementAt(index, element);
     size++;
  }
  
  /**
   * Removes and returns the element at the specified index (0 .. size-1)
   * in the list and decrements the index of any following elements.
   * Pre: index >= 0 and index < size
   * 
   * @param index the position from which to remove the element (0 .. size-1), inclusive
   * @return the element removed from the specified position
   * @throws IndexOutOfBoundsException if precondition is false
   */
  public ElementType removeElementAt(int index){
     if(index<0||index>=size)
      throw new IndexOutOfBoundsException("The index is invalid");
     
     return head.removeElementAt(index);
  }
  
  /**
   * Returns the lowest (i.e. first) index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present. 
   * 
   * @param element the element to be searched for
   * @return the lowest index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present
   */
  public int indexOf(ElementType element){
    return head.indexOf(element);
  }
  
  
  /**
   * Returns the highest (i.e. last) index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present. 
   * 
   * @param element the element to be searched for
   * @return the highest index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present
   */ 
  public int lastIndexOf(ElementType element){
    return head.lastIndexOf(element);
  }
  
  /** 
   * Returns a sub-list containing a the portion of this list between the specified 
   * fromIndex and toIndex, inclusive of both. 
   * Pre: fromIndex >= 0  and fromIndex<=toIndex and toIndex<size
   * 
   * @param fromIndex low endpoint (inclusive) of the subList
   * @param toIndex high endpoint (inclusive) of the subList
   * @return a sub-list containing elements in specified range within this list
   * @throws IndexOutOfBoundsException if precondition is false
   */
  public ZYLinkedIndexedList<ElementType> subList(int fromIndex, int toIndex){
    if(fromIndex < 0 || fromIndex > toIndex || toIndex >= size)
      throw new IndexOutOfBoundsException("The index is invalid");
    ZYLinkedIndexedList<ElementType> result = new ZYLinkedIndexedList<ElementType>();
    int counter = 0;
    for(int i = fromIndex; i <= toIndex; i++)
    {
      ElementType e = this.get(i);
      result.addElementAt(counter, e);
      counter++;
    }
    return result;
  }
  
  /** 
   * Returns true if this list contains duplicate elements as 
   * defined by the equals() method; false otherwise. 
   * 
   * @return true if this list contains duplicates; false otherwise
   */
  public boolean containsDuplicates(){
    for(ElementType e: this)
    {
      int firstIndex = this.indexOf(e);
      int lastIndex = this.lastIndexOf(e);
      if(firstIndex != lastIndex)
        return true;
    } 
    return false;
  }
  
  /**
   * Class implementing nodes for this stack.
   * 
   * Inherited methods:
   *   boolean contains()
   *   boolean isEmpty()
   *   int size()
   *   Iterator<ElementType> iterator()
   *   ElementType getElement()
   *   void setElement(ElementType element)
   *   StackNode getNext()
   *   void setNext(StackNode next)
   */
  protected class ListNode
    extends ZHOneWayListNode<ElementType, ListNode> implements Serializable{
    
    /**
     * Creates a new empty node.
     */
    protected ListNode() {
      super();
    }
    
    /**
     * Creates a new list node with the specified data element and next node.
     * 
     * @param element the data element for the new node
     * @param next the next node for the new node
     */
    protected ListNode(ElementType element, ListNode next) {
      super(element, next);
    }
     /**
   * Gets the element at the specified index in the list (0 .. size-1).
   * 
   * @param index the position to get the element from (0 .. size-1), inclusive
   * @return the element at the specified index
   * */
    protected ElementType get(int index){
      if(this.isTerminal())
        return null;
      else if (index == 0)
        return this.element;
      else
        return this.next.get(index-1);
    }
    /*
     * the method to set the new value to specific index
     * 
     * @param index the specific index the user want to insert
     * @param element the value element the user wants to assign
     * 
     * @return the old element we set
     */
    protected ElementType set(int index, ElementType newValue){
      if(this.isTerminal()){
        return null;
      }
       else if(index==0){
         ElementType e=this.element;
         this.element=newValue;
         return e;
       }
       else{
         return this.next.set(index-1,newValue);
       }
    }
    /*
     * the method for add element at the specific index
     * 
     * @param index the specific index the user want to insert
     * @param element the value element the user wants to assign
     */
    protected void addElementAt(int index, ElementType element){
      if(this.isTerminal()){
        this.element = element;
        this.next=new ListNode();
      }
      else if(index==0){
        ListNode newNode = new ListNode(this.element, this.next);
        this.element=element;
        this.next=newNode;
        
      }
      else{
        this.next.addElementAt(index-1,element);
      }
    }
    /**
     * Removes and returns the element at the specified index (0 .. size-1)
     * in the list and decrements the index of any following elements.
     * 
     * @param index the position from which to remove the element (0 .. size-1), inclusive
     * @return the element removed from the specified position
     */
    protected ElementType removeElementAt (int index){
      if(this.isTerminal()){
        return null;
      }
      else if(index==0){
        ElementType e = this.element;
        this.element = this.next.element;
        this.next = this.next.next;
        size--;
        return e;
      }
      else{
        return this.next.removeElementAt(index-1);
      }
    }
    
    /**
     * Searches for parameter element starting at a given index in the list.
     * Returns index of first match or -1 if no match is found.
     *
     * @param index to identify where to start the search and our current
     * location in the list (PS: condition index == size tells us that we've
     * exhausted the list without finding a match so we need to return -1
     * indicating a failed search)
     * @param element to search for
     * @return index of element searched or -1 if element is not in list
     */
    protected int indexOfHelper(int index,ElementType element){
      if(this.isTerminal()){
        return -1;
      }
      else if(this.element.equals(element)){
        return index;
      }
      else
        return this.next.indexOfHelper(index + 1, element);
    }
    /**
     * Returns the lowest (i.e. first) index at which the specified element is found
     * in the list (0 .. size-1) or -1 if the element is not present. 
     * 
     * @param element the element to be searched for
     * @return the lowest index at which the specified element is found
     * in the list (0 .. size-1) or -1 if the element is not present
     */
    protected int indexOf( ElementType element){
      return this.indexOfHelper(0, element);
    }
    /**
     * Searches for parameter element starting at a given index in the list.
     * Returns index of last match or -1 if no match is found.
     *
     * @param index to identify where to start the search and our current
     * location in the list (PS: condition index == size tells us that we've
     * exhausted the list without finding a match so we need to return
     * indexOfLastMatch)
     * @param indexOfLastMatch stores the current index whenever we encounter an element
     * equal to parameter element
     * @param element to search for
     * @return last index of element searched or -1 if element is not in list
     * (i.e. return the value of indexOfLastMatch)
     */
    protected int lastIndexOfHelper(int index, int indexOfLastMatch, ElementType element){
      if(this.isTerminal()){
        return indexOfLastMatch;
      }
      else if(this.element.equals(element)){
        indexOfLastMatch=index;
        return this.next.lastIndexOfHelper(index+1,indexOfLastMatch,element);
      }
      else
        return this.next.lastIndexOfHelper(index+1,indexOfLastMatch,element);
    }
    
    /**
     * Returns the highest (i.e. last) index at which the specified element is found
     * in the list (0 .. size-1) or -1 if the element is not present. 
     * 
     * @param element the element to be searched for
     * @return the highest index at which the specified element is found
     * in the list (0 .. size-1) or -1 if the element is not present
     */ 
    protected int lastIndexOf(ElementType element){
      return head.lastIndexOfHelper(0, -1, element);
    }
  }
}
