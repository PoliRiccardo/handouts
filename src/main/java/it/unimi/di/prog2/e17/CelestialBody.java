package it.unimi.di.prog2.e17;

import java.util.Objects;

/**
 * Classe astratta che rappresenta un corpo celeste.
 *
 * <p>Ogni corpo celeste ha un nome e una posizione nello spazio tridimensionale. 
 * La mutabilità del corpo dipende dal tipo concreto:
 * <ul>
 *   <li>Stelle: immutabili, la loro posizione non cambia nel tempo.</li>
 *   <li>Pianeti: mutabili, la loro posizione e velocità vengono aggiornate durante le simulazioni.</li>
 * </ul>
 *
 * <p>Le energie potenziale e cinetica vengono calcolate a partire dalla posizione
 * e, se presenti, dalla velocità.
 */
public abstract class CelestialBody implements Comparable<CelestialBody> {
   
    /** Nome del corpo celeste. */
    private final String name;
    /** Posizione tridimensionale del corpo celeste. */
    private Point position;


  /*-
   * RI: 
   * name != null , name != empty()
   * 
   * AF:
   * Le istanze concrete avranno il nome corrispondente al nome del corpo celeste e la posizione corrispondente alla posizione tridimensionale del corpoceleste.
   */


    /**
     * Inizializza questo per essere un corpo celeste avente nome e posizione tridimensionale.
     * Il nome deve essere non vuoto e non nullo 
     * @param name il nome.
     * @param x la cordinata x.
     * @param y la cordinata y.
     * @param z la cordinata z.
     * @throws IllegalArgumentException se {@code name} è null o vuoto. 
     */
    protected CelestialBody(final String name ,final int x ,final int y ,final int z){
        if (Objects.requireNonNull(name).isEmpty()) {
            throw new IllegalArgumentException("Name must be non null and non empty");
        }
        this.name = name;
        position = new Point(x, y, z);
    }

    /**
     * Restituisce l'energia potenziale del corpo celeste. 
     * 
     * @return energia potenziale.
     */
    public long potentialEnergy(){
        return position.norm();
    }
    /**
     * Restituisce l'energia cinetica del corpo celeste.
     * @return energia cinetica.
     */
    abstract public long kineticEnergy();

    /**
     *  Restituisce l'energia del corpo celeste.
     * @return energia corpo celeste.
     */
    public long energy(){
        return potentialEnergy() * kineticEnergy();
    }
    
    /**
     * Restituisce il nome del corpo celeste.
     * @return nome corpo celeste.
     */
    public String getName(){
        return name;
    }


    /**
     * Restituisce la posizione del corpo celeste.
     * @return nome corpo celeste.
     */
    public Point getPosition(){
        return position;
    }
     /**
     * Imposta la nuova posizione del corpo celeste.
     * @return nome corpo celeste.
     * @throws NullPointerException se {@code position} è nullo
     */
    protected void setPosition(Point position){
        this.position = Objects.requireNonNull(position);
    }

    
    /**
     * Aggiorna la velocità di questo corpo celeste in base all'attrazione
     * gravitazionale esercitata dal corpo celeste c.
     *
     * @param c un corpo celeste qualsiasi (stella o pianeta)
     * @throws NullPointerException se {@code c} è null
     */
    abstract public void gravitationalAttraction(CelestialBody c);
    
    /**
     * Aggiorna la posizione del corpo celeste aggiungendo alle cordinate della posizione 
     * le corrispettive cordinate della velocità.
     */
    abstract public void modifyPosition();

     /**
     * Restituisce la velocità del corpo celeste.
     * @return nome corpo celeste.
     */
    abstract public Point getVelocity();

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CelestialBody)) return false;
        return name.equals(((CelestialBody) obj).name);
    }

    @Override
    public int compareTo(CelestialBody o) {
        return name.compareTo(o.name);
    } 

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
