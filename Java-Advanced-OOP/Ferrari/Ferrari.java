
package javaoopadvanced.Ferrari;

public class Ferrari implements Car{
    
    private String driverName;
    
    private static final String MODEL = "488-Spider";
    
    public Ferrari(String name) {
        this.driverName = name;
    }
    
    @Override
    public String brakes() {
        return "Brakes!";
    }
    
    @Override
    public String gasPedal() {
        return "Zadu6avam sa!";
    }
    
    @Override
    public String getMODEL() {
        return MODEL;
    }
  
    public String getDriverName() {
        return driverName;
    }
    
    public void setDriverName(String name) {
        this.driverName = name;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(getMODEL())
                .append("/")
                .append(this.brakes())
                .append("/")
                .append(this.gasPedal())
                .append("/")
                .append(this.getDriverName());
        
        return sb.toString();

    }

    
    
    
}
