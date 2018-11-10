package gamesRenting.persistence;


import java.util.List;

public interface gamesRepository {
    public void addGame(Game game);
    public List<Game> findAllGames();
    public Game getGameById(int id);
}
