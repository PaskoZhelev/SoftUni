
package javaoopadvanced.Mood3.interfaces;

public interface GameObject {
    
    String getUsername();
    int getLevel();
    String getCharacterType();
    String getHashedPassword();
    public < E > void generateHashedPassword(E charType);
    
    
    
    
}
