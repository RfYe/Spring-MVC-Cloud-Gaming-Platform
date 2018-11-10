package gamesRenting.persistence;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.util.List;

@Repository
public class jpaGameRepository implements gamesRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addGame(Game game) {
        em.persist(game);
    }

    @Override
    public List<Game> findAllGames() {
        Query q=em.createQuery("SELECT game FROM Game game");
        List<Game> gameList=q.getResultList();
        return gameList;
    }

    @Override
    @Cacheable(value="game",key="#id")
    public Game getGameById(int id) {
        return em.find(Game.class,id);
    }
}
