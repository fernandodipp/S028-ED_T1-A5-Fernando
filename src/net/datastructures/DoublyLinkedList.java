/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.datastructures;

import java.util.LinkedList.Node;

//import java.util.LinkedList.Node;

//import java.util.LinkedList;
//import java.util.LinkedList.Node;

/**
 * A basic doubly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DoublyLinkedList<E> {

  //---------------- nested Node class ----------------
  /**
   * Node of a doubly linked list, which stores a reference to its
   * element and to both the previous and next node in the list.
   */

  // instance variables of the DoublyLinkedList
  /** Sentinel node at the beginning of the list */
  private NodeDouble<E> header;                    // header sentinel

  /** Sentinel node at the end of the list */
  private NodeDouble<E> trailer;                   // trailer sentinel

  /** Number of elements in the list (not including sentinels) */
  private int size = 0;                      // number of elements in the list

  /** Constructs a new empty list. */
  public DoublyLinkedList() {
    header = new NodeDouble<>(null, null, null);      // create header
    trailer = new NodeDouble<>(null, header, null);   // trailer is preceded by header
    header.setNext(trailer);                    // header is followed by trailer
  }

  // public accessor methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list.
   * @return element at the front of the list (or null if empty)
   */
  public E first() {
    if (isEmpty()) return null;
    return header.getNext().getElement();   // first element is beyond header
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {
    if (isEmpty()) return null;
    return trailer.getPrev().getElement();    // last element is before trailer
  }

  // public update methods
  /**
   * Adds an element to the front of the list.
   * @param e   the new element to add
   */
  public void addFirst(E e) {
    addBetween(e, header, header.getNext());    // place just after the header
  }

  /**
   * Adds an element to the end of the list.
   * @param e   the new element to add
   */
  public void addLast(E e) {
    addBetween(e, trailer.getPrev(), trailer);  // place just before the trailer
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {
    if (isEmpty()) return null;                  // nothing to remove
    return remove(header.getNext());             // first element is beyond header
  }

  /**
   * Removes and returns the last element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeLast() {
    if (isEmpty()) return null;                  // nothing to remove
    return remove(trailer.getPrev());            // last element is before trailer
  }

  // private update methods
  /**
   * Adds an element to the linked list in between the given nodes.
   * The given predecessor and successor should be neighboring each
   * other prior to the call.
   *
   * @param predecessor   node just before the location where the new element is inserted
   * @param successor     node just after the location where the new element is inserted
   */
  private void addBetween(E e, NodeDouble<E> predecessor, NodeDouble<E> successor) {
    // create and link a new node
    NodeDouble<E> newest = new NodeDouble<>(e, predecessor, successor);
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
  }

  /**
   * Removes the given node from the list and returns its element.
   * @param node    the node to be removed (must not be a sentinel)
   */
  private E remove(NodeDouble<E> node) {
    NodeDouble<E> predecessor = node.getPrev();
    NodeDouble<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    return node.getElement();
  }
//Retorna o objeto E presente na posicao indicada por index ou null caso a posicao seja invalida
 public E get(int index) {
   int count = 0;
   if (index > size)
       return null;
   
   NodeDouble<E> walk = header.getNext();
   while (walk != trailer) {
     if (count == index) {
         return walk.getElement();
     }
     walk = walk.getNext();
     count++;
   }
   return null;
 }

 // TODO Retorna a posicao do elemento "e" dentro da lista ou -1 caso nao encontre
 public int indexOf(E e) {
     int index = 0;
     if (e == null) {
         for (NodeDouble<E> i = header; i != null; i = i.getNext()) {
             if (i.getElement() == null)
                 return index;
             index++;
         }
     } else {
         for (NodeDouble<E> i = header; i != null; i = i.getNext()) {
             if (e.equals(i.getElement()))
                 return index;
             index++;
         }
     }
     return -1;
}
	 
 

 // TODO Busca na lista e remove o elemento na posicao especificada pelo index
 public E remove(int index) {
	 int count = 0;
	   if (index > size)
	       return null;
	   
	   NodeDouble<E> walk = header.getNext();
	   while (walk != trailer) {
	     if (count == index) {
	         return walk.getElement();
	     }
	     walk = walk.getNext();
	     count++;
	   }
	   return null;
 }

 // TODO Busca na lista e remove o objeto. Retorna true/false
 public boolean remove(E o) { 
	 if (o == null) {
         for (NodeDouble<E> i = header; i != null; i = i.getNext()) {
             if (i.getElement() == null) {
                 remove(i);
                 return true;
             }
         }
     } else {
         for (NodeDouble<E> i = header; i != null; i = i.getNext()) {
             if (o.equals(i.getElement())) {
                 remove(i);
                 return true;
             }
         }
     }
     return false;
 }  

// TODO Insere o elemento E no posicao especificado por index
public void add(int index, E element) {
//     checkPositionIndex(index);
    NodeDouble<E> o;
    o = o.get(index);
	NodeDouble<E> predecessor = o.getPrev();
    NodeDouble<E> successor = o.getNext();
   if (index == size)
         addLast(element);
     else
         addBetween(element, predecessor, successor);
//     
 }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    NodeDouble<E> walk = header.getNext();
    while (walk != trailer) {
      sb.append(walk.getElement());
      walk = walk.getNext();
      if (walk != trailer)
        sb.append(", ");
    }
    sb.append(")");
    return sb.toString();
  }
} //----------- end of DoublyLinkedList class -----------
