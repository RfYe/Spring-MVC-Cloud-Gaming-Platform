package gamesRenting.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotNull(message = "Username should not be empty")
    public String userName;
    @NotNull(message = "Password should not be empty")
    @Size(min=5,max=12,message = "Password size must be between 5 and 12")
    public String password;
    public boolean enabled=true;
    public String role="ROLE_USER";
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Game> gameLibrary;
    public User() {
        this.gameLibrary=new ArrayList<>();
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setGameLibrary(List<Game> gameLibrary) {
        this.gameLibrary = gameLibrary;
    }
    public int getUserId() {
        return this.id;
    }
    public String getUserName() {
        return this.userName;
    }
    public String getPassword() {
        return this.password;
    }
    public List<Game> getGameLibrary() {
        return gameLibrary;
    }
}
