package zystructures;

import java.util.*;
import java.io.*;
import zhstructures.*;
/**
 * This class gives the methods for zyarrayset in zystructures
 * @author Yidan Zhang
 * @version 2016
 */

public class ZYArraySet<ElementType> implements ZYSet<ElementType>{
  /**
   * An array of elements
   */
  private ElementType[] elements;
  
  /**
   * the variable: size which shows how many elements in the set
   */
  private int size=0;
  
  /**
   * the current capacity
   */
  private int capacity =0;
  /**
   * the final capacity of set
   */
  public static final int DEFAULT_INIT_LENGTH =1024;
  
  /**
   * The first constructor without parameter
   * Construct an empty ZYArraySet with the defaul initial capacity
   */
  public ZYArraySet(){
    elements = (ElementType[])new Object[DEFAULT_INIT_LENGTH];
  }
  
  /**
   * The second constructor to create a new set with specific length
   */
  
  public ZYArraySet(int initLength){
    if(initLength<0)
      throw new IllegalArgumentException("The length cannot be nagative");
    elements = (ElementType[])new Object[initLength];
  }
   /**
  * Returns true if this collection contains no elements.
  * 
  * @return true if this collection contains no elements
  */
  public boolean isEmpty(){
    return size==0;
  }
 
 /**
  * Returns true if this collection contains the specified element,that is, if it contains an 
  * element equal to the specified element under the equals() method.
  * 
  * Note that unlike the Java Collection interface, only elements matching the template
  * type may be tested.
  * 
  * @param element element whose presence in this collection is to be tested 
  * @return true if this collection contains the specified element
  */
  public boolean contains(ElementType element){
    for(ElementType e:this){
      if(e.equals(element)){
        return true;
      }
    }
    return false;
  }
 
 /**
  * Returns an iterator over a set of elements of type ElementType.This method is needed because interface 
  * ZHCollection extends interface Iterable. As result, we can use the enhanced for-loop to iterate over the
  * elements in this set.
  * 
  * @return an iterator object
  */
  public Iterator<ElementType> iterator(){
   return new InnerIterator();
  }
 
 /**
  * Returns the number of elements in this set (its cardinality).
  * 
  * @return the number of elements in this set (its cardinality)
  */
 public int size(){
   return size;
 }
 
 /**
  * Adds the specified element to this set if it is not already
  * present as determined by the contains() method.
  * If this set already contains the element, the call leaves the
  * set unchanged and returns false.
  * 
  * @param element the element to be added to this set 
  * @return true if this set did not already contain the specified element
  */
 public boolean add(ElementType element){
   if(this.contains(element)){
     return false;
   }
   else{
     if(size==capacity){
       reallocate();
     }
     elements[size]=element;
     size++;
   }
   return true;
 }
 
  /** 
   * Allocate a new array to hold the directory
   */
 private  void reallocate() {
   capacity = 2 * capacity;
   ElementType[] newData = (ElementType[]) new Object[DEFAULT_INIT_LENGTH];
   System.arraycopy(elements, 0, newData, 0, size);
   elements = newData;
  }
 
 /**
  * Removes the specified element from this set if it is present,
  * that is, if an equal element is present as determined by the
  * contains() method.
  * 
  * @param element the element to be removed from this set, if present
  * @return true if this set previously contained the specified element 
  */
 public boolean remove(ElementType element){
   if(this.find(element)==-1){
     return false;
   }
   elements[this.find(element)]=elements[size-1];
   size--;
   return true;
 }
 
 /**
  * find a specific element in the set
  * @param: element which is wanted to be found
  * @return the index of this element
  */
 private int find(ElementType element){
   for(int i=0;i<size;i++){
     if(elements[i].equals(element)){
       return i;
     }
   }
   return -1;
 }
 
 /**
  * Returns a new set that is the intersection of this set and
  * otherSet.
  * That is, it returns a set that contains exactly those element
  * contained both in this set and otherSet.
  * It corresponds to the retainAll() method in the Java Set
  * specification, but creates a new set without modifying either
  * of its operands rather than modifying this set.
  * 
  * @param otherSet the set to be intersected with this set
  * @return a new set that is the intersection of this set and
  *         otherSet
  */
 public ZYSet<ElementType> intersection(ZYSet<ElementType> otherSet){
   ZYSet<ElementType> result = new ZYArraySet<ElementType>();
   for(ElementType e :this){
     if(otherSet.contains(e)){
       result.add(e);
     }
   }
   return result;
 }
 
 /**
  * Returns a new set that is the asymmetric difference of this set
  * and otherSet.
  * That is, it returns a set that contains the elements of this set
  * that are not contained in otherSet.
  * It corresponds to the removeAll() method in the Java Set
  * specification, but creates a new set without modifying either of
  * its operands rather than modifying this set.
  * 
  * @param otherSet the set to be subtracted from this set
  * @return a new set that is the asymmetric difference of this set
  *         and otherSet
  */
 public ZYSet<ElementType> difference(ZYSet<ElementType> otherSet){
   ZYSet<ElementType> result = new ZYArraySet<ElementType>();
   for(ElementType e :this){
     if(!otherSet.contains(e)){
       result.add(e);
     }
   }
   return result;
 }
 
 /**
  * Returns a new set that is the union of this set and otherSet.
  * That is, it returns a set that contains all elements contained
  * in this set, otherSet or both.
  * It corresponds to the addAll() method in the Java Set
  * specification, but creates a new set without modifying either of
  * its operands rather modifying this set.
  * 
  * @param otherSet the set to form the union with this set
  * @return a new set that is the union of this set and otherSet
  */
 public ZYSet<ElementType> union(ZYSet<ElementType> otherSet){
   ZYSet<ElementType> result = new ZYArraySet<ElementType>();
    for(ElementType e :this){
       result.add(e);
   }
   for(ElementType e :otherSet){
       result.add(e);
     }
   
   return result;
 }
 
 /**
  * Returns true if the specified potential subset is a subset of
  * this set.
  * It is equivalent to the containsAll() method in the Java Set
  * specification.
  * 
  * @param potentialSubset the set to check whether it is a subset
  *        of this set or not
  * @return true if the specified potential subset is a subset of
  *         this set
  */
 public boolean subset(ZYSet<ElementType> potentialSubset){
   for(ElementType e:potentialSubset){
     if(!this.contains(e)){
       return false;
     }
   }
   return true;
 }
 private class InnerIterator implements Iterator<ElementType>{
   private int nextPosition;
   public InnerIterator(){
     this.nextPosition=0;
   }
   public boolean hasNext(){
     return this.nextPosition<size;
   }
   public void remove(){
     throw new UnsupportedOperationException("Remove");
   }
   public ElementType next(){
     if(hasNext()){
       this.nextPosition++;
       return elements[this.nextPosition-1];
     }
     else{
       throw new NoSuchElementException();
     }
   }
 }
}