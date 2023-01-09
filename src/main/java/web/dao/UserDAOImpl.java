package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("delete from User u where u.id =:id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id =:id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
