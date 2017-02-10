
package javaoopadvanced.BorderControl;


public class Citizen extends Society {
    
    private String name;
    private int age;
    
    public Citizen(String id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    protected void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    protected void setAge(int age) {
        this.age = age;
    }
    
}
