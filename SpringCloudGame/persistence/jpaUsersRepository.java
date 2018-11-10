package gamesRenting.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
@Transactional
@Repository
public class jpaUsersRepository implements  usersRepository{
    @PersistenceContext
    private EntityManager em;
//    @Autowired
//    EntityManagerFactory factory;
    @Override

    public void addUser(User user) {
        //em=factory.createEntityManager();
        //em.getTransaction().begin();
        em.persist(user);
        //em.getTransaction().commit();
    }
    @Override
    public List<Game> getUserLibraryById(int id) {
        return em.find(User.class,id).gameLibrary;
    }
    @Override
    public int getUserIdByUserName(String username){
        Query query=em.createQuery("SELECT u.id FROM User u where u.userName=: username");
        query.setParameter("username",username);
        try {
            Object result=query.getSingleResult();
            return (Integer)result;
        }catch(NoResultException e) {
            return -1;
        }
    }
    @Override
    public User getUserById(int id){
        return em.find(User.class,id);
    }
    @Override
    public void updateUser(User user) {
        em.persist(em.merge(user));
    }
}
