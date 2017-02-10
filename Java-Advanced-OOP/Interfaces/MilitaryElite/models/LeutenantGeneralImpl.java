
package javaoopadvanced.MilitaryElite.models;

import java.util.Collection;
import javaoopadvanced.MilitaryElite.interfaces.LeutenantGeneral;
import javaoopadvanced.MilitaryElite.interfaces.Private;


public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {

    private Collection<Private> privates;
    
    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary, Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

    public void setPrivates(Collection<Private> privates) {
        this.privates = privates;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:");
        
        for(Private prv: privates) {
            builder.append(System.lineSeparator())
                    .append(prv.toString());
        }
        
        return builder.toString();
    }
    
}
