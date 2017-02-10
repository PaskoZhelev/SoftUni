
package javaoopadvanced.BorderControl;


public abstract class Society {
        
    private String id;
    
    public Society(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    protected void setId(String id) {
        this.id = id;
    }
    
    
}
