/*
 * File: MKLIndexedList.java
 */

package zystructures;

import java.util.*;

/**
 * Interface for a list accessed by element index (0 .. size-1). 
 * Represents a simplified List
 * 
 * @author J. Andrew Holey & Imad M. Rahal
 * @version February 20, 2015
 */
public interface ZYIndexedList<ElementType> extends Iterable<ElementType>  {
  
  /**
   * Returns true if this list contains no elements.
   * 
   * @return true if this list contains no elements
   */
  public boolean isEmpty();
  
  /**
   * Returns true if this list contains an element equal to the specified element 
   * under the "equals" method.
   * 
   * @param  element the ElementType object to test for presence in this collection
   * @return true if this list contains the specified element
   */
  public boolean contains(ElementType element);
  
  /* (non-Javadoc)
   * @see java.lang.Iterable#iterator()
   */
  public Iterator<ElementType> iterator();
  
  /**
   * Returns the number of elements in this list.
   * 
   * @return the number of elements in this list
   */
  public int size();
  
  /**
   * Gets the element at the specified index in the list (0 .. size-1).
   * Pre: index >= 0 and index < size
   * 
   * @param index the position to get the element from (0 .. size-1), inclusive
   * @return the element at the specified index
   * @throws IndexOutOfBoundsException if precondition is false
   */
  public ElementType get(int index);
  
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
  public ElementType set(int index, ElementType newValue);
  
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
  public void addElementAt(int index, ElementType element);
  
  /**
   * Removes and returns the element at the specified index (0 .. size-1)
   * in the list and decrements the index of any following elements.
   * Pre: index >= 0 and index < size
   * 
   * @param index the position from which to remove the element (0 .. size-1), inclusive
   * @return the element removed from the specified position
   * @throws IndexOutOfBoundsException if precondition is false
   */
  public ElementType removeElementAt(int index);
  
  /**
   * Returns the lowest (i.e. first) index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present. 
   * 
   * @param element the element to be searched for
   * @return the lowest index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present
   */
  public int indexOf(ElementType element);
  
  
  /**
   * Returns the highest (i.e. last) index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present. 
   * 
   * @param element the element to be searched for
   * @return the highest index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present
   */ 
  public int lastIndexOf(ElementType element);
  
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
  public ZYIndexedList<ElementType> subList(int fromIndex, int toIndex);
  
  /** 
   * Returns true if this list contains duplicate elements as 
   * defined by the equals() method; false otherwise. 
   * 
   * @return true if this list contains duplicates; false otherwise
   */
  public boolean containsDuplicates();
  
}
