
package javaoopadvanced.MilitaryElite.models;

import javaoopadvanced.MilitaryElite.interfaces.Mission;


public class MissionImpl implements Mission {

    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }
    
    
    
    
    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void completeMission() {
        this.state = "Finished";
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setState(String state) {
        
        if (state.equals("inProgress") || state.equals("Finished")) {
            this.state = state;
        }
        else {
            throw new IllegalArgumentException("Illegal state argument");
        }
    }
    
    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
