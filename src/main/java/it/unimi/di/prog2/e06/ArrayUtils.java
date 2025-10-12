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

package it.unimi.di.prog2.e06;

import java.util.Collections;
import java.util.List;

/** Classe di metodi di utilità per array. */
@SuppressWarnings(
    "doclint:missing") // this is because comments of methods to implement have yet to be added
public class ArrayUtils {

  /** . */
  private ArrayUtils() {}

  /**
   * Finds the index (or insertion point) of an integer in an array of integers in increasing order.
   *
   * <p>If the array contains the given integer, returns its index. Otherwise, returns {@code
   * -(insertion_point) - 1} where {@code insertion_point} is the index of the first integer greater
   * than {@code needle}; note that this implies that the return value is non-negative iff the array
   * contains the integer.
   *
   * @see Collections#binarySearch(List, Object)
   * @param haystack the not {@code null} array of integers in increasing order.
   * @param needle the integer to look for.
   * @return the index of the given integer, or {@code -insertion_point - 1} if none is present.
   */
  static int binarySearch(final int[] haystack, final int needle) {
    int lo = 0;
    int hi = haystack.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (needle < haystack[mid]) hi = mid - 1;
      else if (needle > haystack[mid]) lo = mid + 1;
      else return mid;
    }
    return -lo - 1;
  }

  /*
   * Specify and implement a method that shifts right all elements of the given array from {@code
   * insertionPoint} (inclusive) to the end of the array, and then inserts {@code value} at {@code
   * insertionPoint}.
   */

  /**
   * Inserisce un intero in una posizione specificata di un array, 
   * spostando tutti gli elementi dalla posizione indicata (inclusa) di una posizione verso destra.
   *
   * <p>In particolare, inserisce {@code value} nella posizione {@code insertionPoint} dell'array.  
   * Tutti gli elementi a partire da tale posizione vengono spostati in avanti di un indice.  
   * Se l'array è pieno (ovvero non ha capacità aggiuntiva), l'ultimo elemento viene scartato.
   *
   * @param array l'array di interi (non {@code null})
   * @param insertionPoint l'indice in cui inserire {@code value}; deve essere compreso tra {@code 0} (incluso) e {@code array.length} (escluso)
   * @param value il valore da inserire alla posizione {@code insertionPoint}
   */

  static void insertAt(int[] array, int insertionPoint, int value) {
    /*
     *  int previus , next = array[insertionPoint];
        array[insertionPoint] = value;
        for (int i = insertionPoint + 1; i < array.length ; i++) {
          previus = next;
          next = array[i];
          array[i] = previus;
        }
     */
    
    for (int i = array.length - 1; i > insertionPoint; i--) {
        array[i] = array[i - 1];
    }
    array[insertionPoint] = value;
  }

  /* Specify and implement a method that fills the given array with the given value. */

  /**
   * Riempie l'array specificato con il valore fornito.
   *
   * <p>In particolare, assegna {@code value} a ogni elemento di {@code array}.
   *
   * @param array l'array di interi da riempire (non {@code null})
   * @param value il valore da assegnare a ogni elemento dell'array
   */

  static void fill(int[] array, int value) {
    for (int i = 0; i < array.length; i++) { 
      array[i] = value;
    }
  }

  /* Specify and implement a method that prints the given array, one element per line. */

 /**
   * Stampa su standard output ogni elemento dell'array specificato.
   *
   * <p>In particolare, stampa ciascun elemento di {@code array} su una nuova riga.
   *
   * @param array l'array di interi da stampare (non {@code null})
   */


  static void print(int[] array) {
    for (int i : array) {
      System.out.println(i);
    }
  }
}
