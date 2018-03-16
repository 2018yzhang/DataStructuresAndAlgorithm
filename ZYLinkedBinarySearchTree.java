/*
 * File: ZYLinkedSearchTree
 */
package zystructures;
import java.util.*;
import zhstructures.*;
/**
 * Class implementing a ZHBinarySearchTree and extends
 * Comparable
 * 
 * @author I. Rahal, J. A. Whitford Holey, and Yidan Zhang, Kyle Ronsberg
 * @version 10/28/2016
 */
public class ZYLinkedBinarySearchTree<ElementType extends Comparable<ElementType>> 
  implements ZHBinarySearchTree<ElementType>{
  //the root of the tree
  private BSTNode root;
  //the size of the tree
  private int size;
  
  public ZYLinkedBinarySearchTree(){
    root=new BSTNode();
    
  }
  public boolean add(ElementType element){ 
    if(this.root.add(element))
    {
      size++;
      return true;
    }
    else
    {
      return false;
    }
  }
  public boolean contains(ElementType element)
  {
    return root.contains(element);
  }
  
  public ElementType get(ElementType element)
  {
    return root.get(element);
  }
  public boolean isEmpty(){
    return size==0;
  }
  public Iterator<ElementType> iterator(){
    return root.iterator();
  }
  public boolean remove(ElementType element)
  {
    if(this.root.remove(element))
    {
      size--;
      return true;
    }
    else
    {
      return false;
    }
  }
  public int size()
  {
    return this.size;
  }
  protected class BSTNode extends ZHBinaryTreeNode<ElementType, BSTNode>
  {
    protected BSTNode(){
      super();
    }
    protected BSTNode(ElementType element){
      super(element);
    }
    protected BSTNode(BSTNode leftChild, ElementType element, BSTNode rightChild){
      super(leftChild, element, rightChild);
    }
    
    public Iterator<ElementType> iterator()
    {
      return this.inorderIterator();
    }
    public boolean contains(ElementType element){
      
      if(this.isEmpty()){
        return false;
      }
      int comp = this.element.compareTo(element);
      if (comp==0){
        return true;
      }
      else if(comp>0)
      {
        return this.leftChild.contains(element);
      }
      else
      {
        return this.rightChild.contains(element);
      }
    }
    public ElementType get(ElementType element)
    {
      
      if(this.isEmpty())
      {
        return null;
      }
      int comp = this.element.compareTo(element);
      if (comp==0)
      {
        return this.element;
      }
      else if(comp>0)
      {
        return this.leftChild.get(element);
      }
      else
      {
        return this.rightChild.get(element);
      }
    }
    public boolean add(ElementType element)
    {
      
      if(this.isEmpty())
      {
        this.element = element;
        this.leftChild = new BSTNode();
        this.rightChild = new BSTNode();
        return true;
      }
      int comp = this.element.compareTo(element);
      if(comp == 0)
      {
        return false;
      }
      else if(comp > 0)
      {
        return this.leftChild.add(element);
      }
      else
      {
        return this.rightChild.add(element);
      }
    }
    /**
     * remove method
     * @param ElementType element;
     * 
     */
    public boolean remove(ElementType element)
    {
      if(this.isEmpty())
      {
        return false;
      }
      int comp = this.element.compareTo(element);
      if(comp == 0)
      {
        if(this.leftChild.isEmpty())
        {
//          if(this.rightChild.isEmpty())
//          {
//            this.element = null;
//          }
//          else
//          {
          this.copyNodeToThis(this.rightChild);
          return true;
        }
        
        
        else if(this.rightChild.isEmpty())
        {
          this.copyNodeToThis(this.leftChild);
          
          return true;
          
        }
        else
        {
          this.element = this.rightChild.removeAndReturnLeftmost();
          
          return true;
        }
      }
      else if(comp > 0)
      {
        return this.leftChild.remove(element);
      }
      else if(comp < 0)
      {
        return this.rightChild.remove(element); 
      }
     return true;
    }
    /**
     * Replaces values of instance variables element, leftChild and rightChild
     * in this node with those from parameter otherNode.
     *
     * @param otherNode the node from which values of instance variables are
     * being copied into this node.
     */
    protected void copyNodeToThis(BSTNode otherNode)
    {
      this.element = otherNode.element;
      this.leftChild = otherNode.leftChild;
      this.rightChild = otherNode.rightChild;
    }
    /**
     * Removes and returns the leftmost element in this structure.
     *
     * @return the former leftmost element in this structure.
     * @throws NoSuchElementException if this structure is empty.
     */
    protected ElementType removeAndReturnLeftmost()
    {
      if(isEmpty())
      {
        throw new NoSuchElementException("Structure appears to be empty");
      } 
      else if(this.leftChild.isEmpty())
      {
        ElementType saved = this.element;
        this.copyNodeToThis(this.rightChild);
        return saved;
      }
      else
      {
        return this.leftChild.removeAndReturnLeftmost();
      }
    }
  }
}