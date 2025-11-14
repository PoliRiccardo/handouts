/*

Copyright 2025 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e12;


/**
 * A <em>queue</em> is a mutable data structure that provides access to its elements in
 * first-in/first-out order.
 *
 * <p>A <em>bounded</em> queue has an upper bound, established when a queue is created, on the
 * number of elements that can be stored in the queue.
 */
public class BoundedIntQueue{

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification. Provide also the RI and AF.

  // Given the boundedness constraint, it is not allowed to use any Java
  // Collection Framework class. An array can be used to store the elements in a
  // circular buffer (see https://www.wikiwand.com/en/articles/Circular_buffer).

  /** array con dimensione che rappresenta la coda */
  private int[] buffer;
  /** indice del primo elemento in coda */
  private int tail;
  /** indice dell'ultimo elemento in coda */
  private int head;
  
  /*-
   * AF:
   *  
   *  AF(elements, head, tail) =
   *    [buffer[head] , buffer[head + 1], ... , buffer[tail - 1]] se  -1 < head <= tail 
   *    [buffer[head] , buffer[head + 1], ... , buffer[buffer.length - 1], buffer[0] , ... , buffer[tail - 1]] se tail < head
   *
   * RI:
   *  buffer non è null e ha una lunghezza pari alla capacity
   *  capacity > 0
   *  -1 <= head < capacity
   *   0 <= tail < capacity
   *  head = -1 => tail = 0
   *
   */

  /**
   * Creates a new bounded queue with the given capacity.
   *
   * @param capacity the capacity of the queue.
   * @throws IllegalArgumentException if {@code capacity} is negative.
   */
  public BoundedIntQueue(int capacity) {
    if (capacity <=0) throw new IllegalArgumentException("La capacità deve essere positiva");
    buffer = new int[capacity];
    head = -1;
    tail = 0;
    
  }
  /**
   * Adds an element to the queue.
   *
   * @param x the element to add.
   * @throws IllegalStateException if the queue is full.
   */
  public void enqueue(int x) {
    
    if (isFull()) throw new IllegalArgumentException("La coda è piena");
    if (head == -1) head = 0;
    buffer[tail] = x;
    tail = (tail + 1)%buffer.length;
  }

  /**
   * Removes the element at the head of the queue.
   *
   * @return the element at the head of the queue.
   * @throws IllegalStateException if the queue is empty.
   */
  public int dequeue() {
    
    if (isEmpty()) throw new IllegalArgumentException("La coda è vuota");
    int x = buffer[head];
    head = (head + 1) % buffer.length;
    if (head == tail){
      head = -1;
      tail = 0;
    }
    return x;    
  }
  /**
   * stabilisce se la coda è vuota 
   * @return vero se la coda è vuota , altrimenti falso
   */
  public boolean isEmpty(){
    return head == -1;
  }
  /**
   * stabilisce se la coda è piena 
   * @return vero sa la coda è piena , altrimenti falso
   */
  public boolean isFull(){
    return tail == head;
  }
  /**
   * ritorna quanti elementi sono presenti all'interno della coda 
   * @return il numero di elementi presenti all'interno della coda
   */
  public int size(){
    if (isEmpty()) return 0;
    if (isFull()) return buffer.length;
    return (tail-head+ buffer.length)%buffer.length;
  }

  @Override
  public String toString() {
    if (isEmpty()) return "BoundedIntQueue: []";
    final StringBuilder sb = new StringBuilder("BoundedIntQueue: [");
    int i = head, n = 0;
    while (n < size() - 1) {
      sb.append(buffer[i] + ", ");
      i = (i + 1) % buffer.length;
      n += 1;
    }
    sb.append(buffer[i] + "]");
    return sb.toString();
  }
  
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BoundedIntQueue other)) return false;
    if (size() != other.size()) return false;
    int i = head ; int j = other.head; int read = 0;
    while (read < size()) {
      if (buffer[i] != other.buffer[j]) return false;
      i = (i + 1)%buffer.length;
      j = (j + 1)%other.buffer.length;
      read ++;
    }
    return true;
  }
  @Override
  public int hashCode() {
      int result = 0;
      int i = head, n = 0;
      while (n < size()) {
        result = 31 * result + Integer.hashCode(buffer[i]);
        i = (i + 1) % buffer.length;
        n += 1;
    }
    return result;
  }
}
