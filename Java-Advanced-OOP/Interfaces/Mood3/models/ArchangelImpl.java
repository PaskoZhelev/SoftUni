
package javaoopadvanced.Mood3.models;

import javaoopadvanced.Mood3.interfaces.Archangel;


public class ArchangelImpl extends GameObjectImpl implements Archangel{
    
    private int mana;
    
    public ArchangelImpl(String username, int level, String characterType, int mana) {
        super(username, level, characterType);
        this.setMana(mana);
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    @Override
    public String toString() {
        return String.format("%s%n%d", super.toString(), this.getMana() * this.getLevel());
    }
}
