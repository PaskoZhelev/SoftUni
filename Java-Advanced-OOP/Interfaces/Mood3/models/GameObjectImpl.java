
package javaoopadvanced.Mood3.models;

import com.sun.xml.internal.ws.util.StringUtils;
import javaoopadvanced.Mood3.interfaces.GameObject;

public abstract class GameObjectImpl implements GameObject {
    
    private String username;
    private int level;
    private String hashedPassword;
    private String characterType;
    
    public GameObjectImpl(String username, int level, String characterType) {
        this.setUsername(username);
        this.setCharacterType(characterType);
        this.setLevel(level);
    }
    
    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String password) {
        this.hashedPassword = password;
    }
   
    @Override
    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }
    
    @Override
    public < E > void generateHashedPassword(E charType) {
        if(charType instanceof DemonImpl) {
            int usernameLength = this.getUsername().length();
            String password = String.valueOf(usernameLength * 217);
            
            this.setHashedPassword(password);
        }
        else if (charType instanceof ArchangelImpl) {
            String reversedUsername = new StringBuilder(this.getUsername()).reverse().toString();
            int usernameLength = this.getUsername().length();
            String password = reversedUsername + String.valueOf(usernameLength * 21);
            
            this.setHashedPassword(password);
        }
        else {
            throw new IllegalArgumentException("Illegal Character Type");
        }
    }
    
    @Override
    public String toString(){
        return String.format("\"%s\" | \"%s\" -> %s", this.getUsername(), this.getHashedPassword(), this.getCharacterType());
    }
    
    
}
