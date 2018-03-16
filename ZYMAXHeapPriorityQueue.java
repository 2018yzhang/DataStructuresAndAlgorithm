/*
 * File: <ZYHeapPriorityQueue.java
 */

package zystructures;
import zhstructures.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that implements a ZHQueue as heap-based priority queue
 * using an extensible internal array structure.
 * 
 * @author J. Andrew Holey and Yidan Zhang
 * @version 11/5/2016
 */
public class ZYMAXHeapPriorityQueue<ElementType extends Comparable<ElementType>> implements ZHQueue<ElementType> {
  
  private ZHExtensibleArrayStructure<ElementType> elements;
  
  /**
   * Creates a new empty queue with a default capacity.
   */
  public ZYMAXHeapPriorityQueue() {
    // your code here
    elements = new ZHExtensibleArrayStructure<ElementType>();
  }
  
  /**
   * Creates a new empty queue with the specified capacity.
   * 
   * @param capacity the initial capacity of the queue
   * @throws IllegalArgumentException if capacity <=0
   */
  public ZYMAXHeapPriorityQueue(int capacity) {
    if(capacity <= 0){
    throw new IllegalArgumentException("capacity can not be less than or equal to 0.");
    }
    elements = new ZHExtensibleArrayStructure<ElementType>(capacity);
    
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#contains()
   */
  public boolean contains(ElementType element) {
    // your code here
    if(element==null)
      throw new IllegalArgumentException("Target element cannot be null");
    else
      return elements.contains(element);
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#isEmpty()
   */
  public boolean isEmpty() {
    // your code here
        return size()==0;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#size()
   */
  public int size() {
    // your code here
        return elements.size();
  }
    
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#iterator()
   */
  public Iterator<ElementType> iterator() {
    // your code here
    return elements.iterator();
  }
//  
//  /* (non-Javadoc)
//   * @see zhstructures.ZHQueue#peek()
//   */
  public ElementType peek() {
    if(this.isEmpty()){
       throw new NoSuchElementException("elements can't be empty");
    }
    return this.elements.get(0);  
  }
//  
  /* (non-Javadoc)
//   * @see zhstructures.ZHQueue#dequeue()
//   */
  public ElementType dequeue() {
    if(this.isEmpty()){
       throw new NoSuchElementException("elements can't be empty");
    }
   ElementType oldElement = this.elements.get(0);
 
    if (size()==1){
     return elements.removeLast();
    }
    else{
   
    ElementType move = elements.removeLast();
    elements.set(0,move);
    checkDownward(0); 
    
    }
    return oldElement;
  }
  /*
   * the method to find parent of a child
   * 
   * @param childPositioin the position of child
   * @return parent position
   */
  protected int parentPosition (int childPosition){
    if(childPosition==0){
      return -1;
    }
    int parent = (childPosition-1)/2;
    return parent;
  }
  /*
   * the method to find left child of parent
   * 
   * @param parentPositioin the position of parent 
   * @return left child position
   */
  protected int leftChildPosition(int parentPosition ){
    int leftChildPosition=parentPosition*2+1;
  
    return leftChildPosition;
  }
   /*
   * the method to find right child of parent
   * 
   * @param parentPositioin the position of parent 
   * @return right child position
   */
  protected int rightChildPosition (int parentPosition){
    int rightChildPosition=parentPosition*2+2;
  
    return rightChildPosition;
    }
  /*
   * the method to find the most element of the queue
   * 
   * @param currentPosition the index of current position
   * @return leastPosition the position of the least element
   */
  protected int mostPosition (int currentPositon){
    if(leftChildPosition(currentPositon)>=size()){
      return currentPositon;
    }
   
      int comp = elements.get(currentPositon).compareTo(elements.get(leftChildPosition(currentPositon)));
      int max;
      if(comp>=0){
        max=currentPositon;
      }
      else {
        max=leftChildPosition(currentPositon);
      }
    if(rightChildPosition(currentPositon)<size()){
   
            int diff =elements.get(max).compareTo(elements.get(rightChildPosition(currentPositon)));
            if(diff>=0){
              return max;
            }
            else{
              max= rightChildPosition(currentPositon);
            }
      }
         return max;
    }
  
    
  
  /*
   * check its parent and compare child and parent and make sure the element to be placed at a right position
   * 
   * @currentPosition the position of the element
   * 
   */
  
  protected void checkUpward(int currentPosition){
    int parent = parentPosition(currentPosition);
    if(parent < 0){
      return;
    }
    int comp = elements.get(parent).compareTo(elements.get(currentPosition));
    if(comp>=0){
      return;
    }
    else{
      ElementType OldElt = elements.get(parent);
      elements.set(parent, elements.get(currentPosition));
      elements.set(currentPosition, OldElt);
      this.checkUpward(parent);
    }
    
  }
  
  /*
   * check two children, compare parent and children, and make sure put the element at the right position
   * 
   * @currentPosition the position of the element
   */
  
  protected void checkDownward(int currentPosition){
//    int left = leftChildPosition(currentPosition);
//    int right = rightChildPosition(currentPosition);
//    if(left>=this.size()){
//      return;
//    }
//    else{
//      int min = left;
//      int comp = elements.get(right).compareTo(elements.get(left));
//      if(right<this.size()&&comp<0){
//        min=right;
//      }
//      int diff = elements.get(min).compareTo(elements.get(currentPosition));
//      if(diff>0){
//        return;
//      }
//      else{
//        ElementType OldElt = elements.get(currentPosition);
//        elements.set(currentPosition,elements.get(min));
//        elements.set(min, OldElt);
//        this.checkUpward(min);
//      }
//    }
  
    
     if(mostPosition(currentPosition)==currentPosition){
     return;
     }
      else{
      int max = mostPosition(currentPosition);
      ElementType OldElt = elements.get(currentPosition);
        elements.set(currentPosition,elements.get(max));
        elements.set(max, OldElt);
         this.checkDownward(max);
      }
     
  }
  
  
//  
//  /* (non-Javadoc)
//   * @see zhstructures.ZHQueue#enqueue(java.lang.Object)
//   */
  public void enqueue(ElementType element) {
    // your code here
    if(element==null){
      throw new IllegalArgumentException("The element cannot be null");
    }
    else{
      elements.addLast(element);
      this.checkUpward(size()-1);
    }
    
  }
    
}