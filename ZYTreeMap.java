package zystructures;
import zhstructures.*;
import java.util.*;

/*
 * The class works as a tree rather than map
 * 
 * @author Yidan Zhang
 * @version 11/17/2016
 */
public class ZYTreeMap<KeyType extends Comparable<KeyType>,ValueType> implements ZHMap<KeyType, ValueType>{
  //a new binary tree
  public ZHBinarySearchTree<ZHComparableKeyPair<KeyType,ValueType>> innerTree;
  /*
   * contructor to create a new map
   */
  public ZYTreeMap(){
    innerTree = new ZYLinkedBinarySearchTree();
  }
  
  /*
   * check if is empty for innerTree
   * 
   * @return true if innerTree is empty
   */
  public boolean isEmpty(){
    return innerTree.isEmpty();
  }
  
  /*
   * the size of the innerTree
   * 
   * @return the size of the innerTree
   */
  public int size(){
    return innerTree.size();
  }
  
  /*
   * iterator of the innerTree
   * 
   * @return iterator of map
   */
  public java.util.Iterator<KeyType> iterator(){
    return new MapIterator();
  }
  
  /*
   * check if contains specific element
   * 
   * @param key needed to check
   * @return true if it contains
   * @throw if key is null
   */
  public boolean contains(KeyType key){
    if(key==null){
      throw new IllegalArgumentException("Key cannot be null");
    }
    return innerTree.contains(new ZHComparableKeyPair<KeyType,ValueType>(key,null));
  }
  
  /*
   * get the value for given specific key
   * 
   * @param key needed to get
   * @return the value of the specific key
   * @throw if key is null
   */
  public ValueType get(KeyType key){
    if(key==null){
      throw new IllegalArgumentException("Key cannot be null");
    }
    ZHComparableKeyPair<KeyType,ValueType> result =innerTree.get( new ZHComparableKeyPair<KeyType,ValueType>(key,null));
    if(result==null){
      return null;
    }
   return result.getValue();
  }
  /*
   * remove from the innerTree
   * 
   *@param key needed to remove
   * @return the value of the specific key
   * @throw if key is null
   */
  public ValueType remove(KeyType key){
   if(key==null){
      throw new IllegalArgumentException("Key cannot be null");
    }
   ZHComparableKeyPair<KeyType,ValueType> result =innerTree.get( new ZHComparableKeyPair<KeyType,ValueType>(key,null));
   if(result==null){
     return null;
   }
   innerTree.remove(result);
   return result.getValue();
  }
  
  /*
   * put a specific key and value in this map
   * 
   * @param the key for which the associated value in this map is to be set
   * @param the value to be associated with the key in this map
   * @return the former value associated with the key in this map, or null if this map contained no mapping for the key
   * @throw if key or value is null
   */
  public ValueType put(KeyType key, ValueType value){
    if((key==null)||(value==null)){
      throw new IllegalArgumentException("Key or value cannot be null");
    }
    ZHComparableKeyPair<KeyType,ValueType> n = new ZHComparableKeyPair<KeyType,ValueType>(key,value);
    ZHComparableKeyPair<KeyType,ValueType> result =innerTree.get(n );
    if(result==null){
   
      innerTree.add(n);
    
      return null;
    }
    ValueType old = result.getValue();
    result.setValue(value);
   
    return old;
  }
// This class should be an inner class in your <FOO>TreeMap class.
// The tree variable is an instance variable of the outer class
// of type ZHBinarySearchTree<ZHComparableKeyPair<KeyType, ValueType>>.

/**
 * An iterator that returns the keys of this map in order,
 * using a tree iterator.
 */
protected class MapIterator implements Iterator<KeyType> {
  
  protected Iterator<ZHComparableKeyPair<KeyType, ValueType>> iter;
    
  /**
   * Constructs a new inorder iterator
   * over the keys of this map.
   */
  public MapIterator() {
    iter = innerTree.iterator();
  }
  
  /* (non-Javadoc)
   * @see java.lang.Iterator#hasNext()
   */
  public boolean hasNext() {
    return iter.hasNext();
  }
  
  /* (non-Javadoc)
   * @see java.lang.Iterator#next()
   */
  public KeyType next() {
    return iter.next().getKey();
  }
  
  /**
   * Unsupported operation
   *
   * @throw UnsupportedOperationException
   * @see java.lang.Iterator#remove()
   */
  public void remove() {
    throw new UnsupportedOperationException();
  }
}}

