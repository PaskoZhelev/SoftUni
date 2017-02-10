/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoopadvanced.MilitaryElite.models;

import javaoopadvanced.MilitaryElite.interfaces.SpecialisedSoldier;

/**
 *
 * @author Pasko
 */
public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private String corps;
    
    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    public void setCorps(String corps) {
        if(corps.equals("Airforces") || corps.equals("Marines")) {
            this.corps = corps;
        }
        else {
            throw new IllegalArgumentException("Illegal corps argument");
        }
        
    }
    
    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.getCorps());
    }
    
}
