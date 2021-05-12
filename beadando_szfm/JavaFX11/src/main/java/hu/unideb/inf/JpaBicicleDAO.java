package hu.unideb.inf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaBicicleDAO implements BicicleDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveBicicle(Bicicle b) {    //bicikli hozzáadása az adatbázishoz
        entityManager.getTransaction().begin();
        entityManager.persist(b);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteBicicle(Bicicle b) {  //bicikli törlése az adatbázisból
        entityManager.getTransaction().begin();
        entityManager.remove(b);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateBicicle(Bicicle b) {    //biciklik frissítése az adatbázisban
        entityManager.getTransaction().begin();
        entityManager.persist(b);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Bicicle> getBicicles() {    //biciklik lekérdezése az adatbázisból
        TypedQuery<Bicicle> query = entityManager.createQuery("SELECT b FROM Bicicle b", Bicicle.class);
        List<Bicicle> bicicles = query.getResultList();
        return bicicles;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
