package hu.unideb.inf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaUsersDAO implements UsersDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveUser(Users u) { //felhasználó mentése
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(Users u) {   //felhasználó törlése
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateteUser(Users u) { //felhasználó frissítése == felhasználó mentése
        saveUser(u);
    }

    @Override
    public List<Users> getUsers() { //felhasználók lekérdezése az adatbázisból
        TypedQuery<Users> query = entityManager.createQuery("SELECT u FROM Users u", Users.class);
        List<Users> users = query.getResultList();
        return users;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
