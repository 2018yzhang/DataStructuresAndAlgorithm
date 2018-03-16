/*
 * File: ZYLinkedIndexedList.java
 */

package zystructures;

import java.util.*;
import zhstructures.*;
import java.io.*;

/**
 * Class for a queue accessed by element index (0 .. size-1). 
 * Represents a simplified queue
 * 
 * @author J. Andrew Holey & Imad M. Rahal,and Yidan Zhang
 * @version February 20, 2015, version 2: 10-18-2016
 */

public class ZYLinkedQueueV2<ElementType> implements ZHQueue<ElementType>{
  
  /*
   * Create a indexedList which is called innerList
   */
  ZYIndexedList<ElementType> innerList;
  
    /**
   * Creates a new empty queue.
   */
  public ZYLinkedQueueV2() {
      innerList = new ZYLinkedIndexedList<ElementType>();
  }  
  
  /**
   * check queue if it is empty
   *return true when it is empty
   */
  public boolean isEmpty(){
    return innerList.size()==0;
  }
  
  /*
   * Method that determines whether the target element is in the queue
   * 
   * @parameter element the target element
   * @return true if it contains
   */
  public boolean contains(ElementType element){
//    for(ElementType e:this){
//      if(e.equals(element)){
//        return true;
//      }
//    }
//    return false;
    return innerList.contains(element);
  }
  
  /*
   *get the size of queue
   * 
   * @return the size of queue
   */
  public int size(){
    return innerList.size();
  }
    
  /*
   * Method that look at the top of queue without remove
   * 
   * @return the top element of linkedqueue
   */
  public ElementType peek(){
    if(isEmpty()){
      throw new NoSuchElementException("Can't Peek an empty queue");
    }
    return innerList.get(0);
  }
   /*
   * Method that look at the top of queue and remove
   * 
   * @return the top element of linkedqueue
   */
  public ElementType dequeue(){
//     if(isEmpty()){
//      throw new NoSuchElementException("Can't dequeue an empty queue");
//    }
//     ElementType e = front.getElement();
//     front=front.getNext();
//     size--;
//     return e;
    if(isEmpty()){
      throw new NoSuchElementException("Can't Dequeue an empty queue");
    }
    ElementType e = innerList.get(0);
    innerList.removeElementAt(0);
    return e;
  }
   /*
   * Method that add element
   * 
   * @parameter element which will be added on the queue
   */
  public void enqueue(ElementType element) {
//    if(element == null) {
//      throw new IllegalArgumentException("Can't enqueue a null into queue");
//    }
//    rear.setElement(element);
//    QueueNode tempNode = new QueueNode();
//    rear.setNext(tempNode);
//    rear=tempNode;
//    size++;
    innerList.addElementAt(innerList.size(),element);
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#iterator()
   */
  public Iterator<ElementType> iterator() {
    return innerList.iterator();
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
//  protected class QueueNode
//    extends ZHOneWayListNode<ElementType, QueueNode> {
//    
//    /**
//     * Creates a new empty node.
//     */
//    protected QueueNode() {
//      super();
//    }
//    
//    /**
//     * Creates a new node with the specified data element and next node.
//     * 
//     * @param element the data element for the new node
//     * @param next the next node for the new node
//     */
//    protected QueueNode(ElementType element, QueueNode next) {
//      super(element, next);
//    }
//  }
}