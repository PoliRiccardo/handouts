package it.unimi.di.prog2.e17;

public class Star extends CelestialBody {

    protected Star(String name, int x, int y, int z) {
        super(name, x, y, z);
    }

    @Override
    public long kineticEnergy() {
        return 0;
    }

    @Override
    public Point getVelocity(){
        return Point.ZERO;
    }

    @Override
    public void gravitationalAttraction(CelestialBody c) {
    }

    @Override
    public void modifyPosition() {
    }

     @Override
    public String toString() {
    return String.format("Star, name: %s, pos: %s", getName(), getPosition());
    }

    

}
