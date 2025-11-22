package it.unimi.di.prog2.e17;

import java.util.Objects;

/** Classe mutabile che rappresenta un {@code CelestialBody} pianeta. */
public class Planet extends CelestialBody{
   
    private Point velocity;
    
    /**
     * Inizializza il pianeta con il suo nome, le cordinate della posizione.
     * @param name nome
     * @param px cordinata x della posizione.
     * @param py cordinata y della posizione.
     * @param pz cordinata z della posizione.

     */
    public Planet(final String name, int x , int y ,int z){
        super(name, x, y, z);
        velocity = Point.ZERO;
    }
    
    @Override
    public long kineticEnergy() {
        return velocity.norm();
    }

    @Override
    public void gravitationalAttraction(CelestialBody c) {
        Objects.requireNonNull(c);
        final Point cv = c.getPosition().subtract(getPosition()).signum();
        velocity = velocity.sum(cv);
    }
  
    @Override
    public void modifyPosition(){
        setPosition(getPosition().sum(velocity));
    }
    
    @Override
    public Point getVelocity(){
        return velocity;
    }

    @Override
    public String toString() {
    return String.format("Planet, name: %s, pos: %s, vel: %s", getName(), getPosition(), getVelocity());
  }

}
