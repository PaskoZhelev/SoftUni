
package javaoopadvanced.Mood3.models;

import javaoopadvanced.Mood3.interfaces.Demon;

public class DemonImpl extends GameObjectImpl implements Demon {
    
    private double energy;

    public DemonImpl(String username, int level, String characterType, double energy) {
        super(username, level, characterType);
        this.setEnergy(energy);
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
    
    @Override
    public String toString() {
        return String.format("%s%n%.1f", super.toString(), this.getEnergy() * this.getLevel());
    }
}
