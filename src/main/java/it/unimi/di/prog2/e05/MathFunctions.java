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

package it.unimi.di.prog2.e05;

/** Utility class for computing mathematical functions. */
public class MathFunctions {

  /** . */
  private MathFunctions() {}

  /* Specify and implement a method that given a positive number returns an approximation
   * of its square root.
   *
   * Hint: https://en.wikipedia.org/wiki/Bisection_method
   */

  /**
   * Calcola la radice quadrata di un valore in virgola mobile utilizzando il metodo della bisezione.
   *
   * <p>In particolare, restituisce la radice quadrata di {@code x} calcolata
   * tramite il metodo della bisezione.  
   * La precisione del risultato è tale che {@code |sqrt(x)^2 - x| < 10^-3}.
   *
   * @param x il valore di cui calcolare la radice quadrata; deve essere non negativo
   * @return un'approssimazione della radice quadrata di {@code x}
   */

  public static double sqrt(double x){
   double low = 0, high = Math.max(1, x), mid;
    do {
        mid = (low + high) / 2.0;
        if (mid * mid < x) {
            low = mid;
        } else {
            high = mid;
        }
    } while (Math.abs(mid * mid - x) > 0.001);

    return mid;
  }
}
