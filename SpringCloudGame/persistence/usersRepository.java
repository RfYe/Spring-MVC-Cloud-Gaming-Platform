package gamesRenting.persistence;

import java.util.List;

public interface usersRepository {
    public void addUser(User user);
    public User getUserById(int id);
    public List<Game> getUserLibraryById(int id);
    public int getUserIdByUserName(String username);
    public void updateUser(User user);
}
