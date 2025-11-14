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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A map from {@link String} to {@link Integer}.
 *
 * <p>A <em>map</em> is a collection that associates keys to values. In this case, the keys are
 * strings and the values are integers. The map cannot contain duplicate keys, which means that each
 * key can be associated to at most one value.
 */
public class StringToIntMap {

  // EXERCISE: provide an implementation (including the equals, hashCode, and toString
  // methods). Provide also the RI and AF.

  // Note: do not use the Map in Java Collections, the point is to implement it from scratch!

    /** A list containing the keys. */
   private final List<String> keys;

  /** A list containing the values. */
    private final List<Integer> values;

  /*-
   * AF:
   *
   * AF(Keys, values)=
   *   una mappa dove keys.get(i) è associato a values.get(i) per ogni i in [0,keys.size()]
   *   
   *
   * RI:
   *  Keys non è null e non contiene nulls
   *  Values non è null e non contiene nulls
   *  keys.size() == value.size()
   * 
   */



  /** Creates a new empty map. */
  public StringToIntMap() {
    keys = new ArrayList<>();
    values = new ArrayList<>();
  }

  /**
   * Returns the size of this map.
   *
   * @return the number of key-value mappings in this map.
   */
  public int size() {
    return keys.size();
  }

  /**
   * Returns if this map is empty.
   *
   * @return {@code true} iff this map contains no key-value mappings.
   */
  public boolean isEmpty() {
    return keys.isEmpty();
  }

  /**
   * Returns if this map contains the specified key.
   *
   * @param key the key to search for.
   * @return {@code true} iff this map contains a key-value mappings with the given {@code key}.
   */
  public boolean containsKey(String key) {
    return keys.contains(key);
  }

  /**
   * Returns if this map contains the specified value.
   *
   * @param value the value to search for.
   * @return {@code true} iff this map contains a key-value mappings with the given {@code value}.
   */
  public boolean containsValue(int value) {
    return values.contains(value);
  }

  /**
   * Returns the value to which the specified key is mapped.
   *
   * @param key the key whose associated value is to be returned.
   * @return the value to which the specified key is mapped.
   * @throws NoSuchElementException if this map contains no mapping for the key, or the key is
   *     {@code null}.
   */
  public int get(String key) throws NoSuchElementException {
    if (key == null) throw new NoSuchElementException("La chiave è nulla");
    int insertionPoint = keys.indexOf(key);
    if (insertionPoint < 0) throw new NoSuchElementException("La chiave non è presente nella mappa");
    return values.get(insertionPoint);
  }

  /**
   * Associates in this map the new key with the specified value.
   *
   * @param key the key with which the specified value is to be associated.
   * @param value the value to be associated with the specified key.
   * @throws IllegalArgumentException if the map already contain a mapping for the key.
   * @throws NullPointerException if the key is {@code null}.
   */
  public void put(String key, int value) {
    if (keys.contains(Objects.requireNonNull(key , "La chiave non deve essere null"))) throw new IllegalArgumentException("chiave già presente");
    keys.add(key);
    values.add(value);
  }
  /**
   * Removes the mapping for a key from this map if it is present.
   *
   * @param key the key whose mapping is to be removed from the map.
   * @return {@code true} iff this map contained a mapping for the specified key, and hence is
   *     modified by this operation.
   */
  public boolean remove(String key) {
    if (key == null) return false;
    if (!keys.contains(key)) return false;
    int insertionPoint = keys.indexOf(key);
    keys.remove(insertionPoint);
    values.remove(insertionPoint);
    return true;
  }

  /** Removes all of the mappings from this map. */
  public void clear() {
    keys.clear();
    values.clear();
  }
   @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof StringToIntMap other)) return false;
    return keys.equals(other.keys) && values.equals(other.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keys, values);
  }
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("StringToIntMap: {");
    for (int i = 0; i < keys.size(); i++) {
      sb.append(keys.get(i) + "->" + values.get(i));
      if (i < keys.size() - 1) sb.append(", ");
    }
    sb.append("}");
    return sb.toString();
  }
}
