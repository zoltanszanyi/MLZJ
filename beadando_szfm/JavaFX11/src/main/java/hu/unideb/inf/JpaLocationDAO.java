package hu.unideb.inf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaLocationDAO implements LocationDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveLocation(Location l) {
        entityManager.getTransaction().begin();
        entityManager.persist(l);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteLocation(Location l) {
        entityManager.getTransaction().begin();
        entityManager.remove(l);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateteLocation(Location l) {
        entityManager.getTransaction().begin();
        entityManager.persist(l);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Location> getLocations() {
        TypedQuery<Location> query = entityManager.createQuery("SELECT l FROM Location l", Location.class);
        List<Location> locations = query.getResultList();
        return locations;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
