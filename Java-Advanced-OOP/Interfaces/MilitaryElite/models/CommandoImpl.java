
package javaoopadvanced.MilitaryElite.models;

import java.util.Collection;
import javaoopadvanced.MilitaryElite.interfaces.Commando;
import javaoopadvanced.MilitaryElite.interfaces.Mission;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Collection<Mission> missions;
    
    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps, Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
    }

    @Override
    public Collection<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Collection<Mission> missions) {
        this.missions = missions;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Missions:");
        
        for(Mission msn: missions) {
            builder.append(System.lineSeparator())
                    .append(msn.toString());
        }
        
        return builder.toString();
    }
    
}
