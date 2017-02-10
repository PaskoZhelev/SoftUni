/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoopadvanced.MilitaryElite.models;

import java.util.Collection;
import javaoopadvanced.MilitaryElite.interfaces.Engineer;
import javaoopadvanced.MilitaryElite.interfaces.Repair;

/**
 *
 * @author Pasko
 */
public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{

    private Collection<Repair> repairs;
    
    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps, Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    public void setRepairs(Collection<Repair> repairs) {
        this.repairs = repairs;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Repairs:");
        
        for(Repair rpr: repairs) {
            builder.append(System.lineSeparator())
                    .append(rpr.toString());
            
        }
          return builder.toString();
    }
}
