
package javaoopadvanced.BorderControl;


public class Robot extends Society {
    
    private String model;
    
    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }
    
    public String getModel() {
      return model;
    }
    
    protected void setModel(String model) {
        this.model = model;
    }
}
