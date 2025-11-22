package it.unimi.di.prog2.e17;

import java.util.Objects;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeSet;

/** Classe mutabile che rappresenta un sistema astronomico */
public class AstronomicalSystem {
    /** lista di corpi celesti */
    private SortedSet<CelestialBody> state;

    /*-
    * RI: 
    * state != null
    * AF:
    * state rappresenta l'insieme dei corpi celesti presenti in questo sistema astronomico.
    */


    /**
     * Inizializza il sistema astronomico
     */
    public AstronomicalSystem(){
        state = new TreeSet<CelestialBody>();
    }

    public void add(CelestialBody c){
        state.add(Objects.requireNonNull(c));
    }
    
    /**
     * Restituisce l'energia totale del sistema astronomico.
     * @return energia totale del sistema astronomico.
     */

    public long totalEnergy(){
        long energy = 0;
        for (CelestialBody celestialBody : state) {
            energy+= celestialBody.energy();
        }
        return energy;
    }

     /**
     * Simulates the evolution of the system for a given number of steps.
     *
     * @param num the number of steps to simulate.
     * @throws IllegalArgumentException if num is not positive.
     */
    public void simulateSteps(final int num) {
        if (num <= 0) throw new IllegalArgumentException();
        for (int i = 0; i < num; i++) step();
    }
    
    /**
     * Performs a simulation step.
     *
     * <p>For details see the <em>overview</em> of this package.
     */
    private void step() {
        for (final CelestialBody p : state)
        for (final CelestialBody c : state) {
            if (p == c) continue;
            p.gravitationalAttraction(c);
        }
        for (final CelestialBody c : state ) c.modifyPosition();
    }

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner("\n");
        for (CelestialBody c : state) sj.add(c.toString());
        return sj.toString();
    }

    

}
