/*
 * File: ZYLinkedQueue.java
 */
package zystructures;

import java.util.*;
import zhstructures.*;

/**
 * Class implementing a ZHQueue using an internal
 * one-way linked structure/node.
 * 
 * @author I. Rahal, J. A. Whitford Holey, and Yidan Zhang, Cortland Styles-Brown
 * @version 9/30/2016
 */
public class ZYLinkedQueue<ElementType> implements ZHQueue<ElementType> {
  
  //a reference to the front of the queue
  protected QueueNode front;
  
  //a reference to the back of the queue
  protected QueueNode rear;
  
  //the number of elements in the queue
  protected int size = 0;
    
  /**
   * Creates a new empty queue.
   */
  public ZYLinkedQueue() {
    this.front = new QueueNode();
    this.rear=front;  
  }  
  
  /**
   * check queue if it is empty
   *return true when it is empty
   */
  public boolean isEmpty(){
    return size==0;
  }
  
  /*
   * Method that determines whether the target element is in the queue
   * 
   * @parameter element the target element
   * @return true if it contains
   */
  public boolean contains(ElementType element){
    for(ElementType e:this){
      if(e.equals(element)){
        return true;
      }
    }
    return false;
  }
  public int size(){
    return size;
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
    return front.getElement();
  }
   /*
   * Method that look at the top of queue and remove
   * 
   * @return the top element of linkedqueue
   */
  public ElementType dequeue(){
     if(isEmpty()){
      throw new NoSuchElementException("Can't dequeue an empty queue");
    }
     ElementType e = front.getElement();
     front=front.getNext();
     size--;
     return e;
  }
   /*
   * Method that add element at the specific position
   * 
   * @parameter element which will be added on the queue
   */
  public void enqueue(ElementType element) {
    if(element == null) {
      throw new IllegalArgumentException("Can't enqueue a null into queue");
    }
    rear.setElement(element);
    QueueNode tempNode = new QueueNode();
    rear.setNext(tempNode);
    rear=tempNode;
    size++;
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#iterator()
   */
  public Iterator<ElementType> iterator() {
    return this.front.iterator();
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
  protected class QueueNode
    extends ZHOneWayListNode<ElementType, QueueNode> {
    
    /**
     * Creates a new empty node.
     */
    protected QueueNode() {
      super();
    }
    
    /**
     * Creates a new node with the specified data element and next node.
     * 
     * @param element the data element for the new node
     * @param next the next node for the new node
     */
    protected QueueNode(ElementType element, QueueNode next) {
      super(element, next);
    }
  }
}