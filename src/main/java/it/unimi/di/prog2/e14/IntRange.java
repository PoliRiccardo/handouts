package it.unimi.di.prog2.e14;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Rappresenta un intervallo di numeri interi da {@code from} (incluso)
 * a {@code to} (escluso) con incremento costante {@code step},
 * che può essere positivo o negativo.
 *
 * <p>Esempi:
 * <ul>
 *   <li>{@code new IntRange(2, 10, 2)} genera 2, 4, 6, 8</li>
 *   <li>{@code new IntRange(10, 2, -2)} genera 10, 8, 6, 4</li>
 * </ul>
 */
public class IntRange implements Iterable<Integer> {

    /**
     * Iteratore interno per generare i numeri dell’intervallo.
     */
    private class IntegerIterator implements Iterator<Integer> {
        private int current;

        private IntegerIterator(int from, int to, int step) {
            this.current = from;
        }

        @Override
        public boolean hasNext() {
            // Se step > 0 → range crescente, se step < 0 → decrescente
            return step > 0 ? current < to : current > to;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            int value = current;
            current += step;
            return value;
        }
    }

    /** Inizio del range (incluso) */
    private int from;
    /** Fine del range (escluso) */
    private int to;
    /** Passo del range (può essere negativo) */
    private int step;

    /*
     * RI (Representation Invariant):
     *  - step != 0
     *  - se step > 0 → da from < to per avere valori
     *  - se step < 0 → da from > to per avere valori
     *
     * AF (Abstraction Function):
     *  rappresenta la sequenza di interi da 'from' (incluso)
     *  a 'to' (escluso) con incremento costante 'step'.
     */

    /** Costruttore di default */
    public IntRange() {
        this.from = Integer.MIN_VALUE;
        this.to = Integer.MAX_VALUE;
        this.step = 1;
    }

    /**
     * Costruttore completo.
     *
     * @param from inizio del range (incluso)
     * @param to fine del range (escluso)
     * @param step passo (non nullo)
     * @throws IllegalArgumentException se {@code step == 0}
     */
    public IntRange(int from, int to, int step) {
        if (step == 0)
            throw new IllegalArgumentException("Lo step non può essere zero");
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setStep(int step) {
        if (step == 0)
            throw new IllegalArgumentException("Lo step non può essere zero");
        this.step = step;
    }

    /** Restituisce un iteratore sui valori del range. */
    @Override
    public Iterator<Integer> iterator() {
        return new IntegerIterator(from, to, step);
    }
}
