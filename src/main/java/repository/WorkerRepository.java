package repository;

import java.util.List;
import java.util.Objects;

import entity.Worker;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.ConnectionManager;

public class WorkerRepository {

    public void insert(Worker worker) {
        Session session = ConnectionManager.getSession();
        session.getTransaction().begin();
        session.persist(worker);
        session.getTransaction().commit();
        session.close();
    }

    public List<Worker> findWorkersByFirstName(String firstName) {
        Session session = ConnectionManager.getSession();
        Query<Worker> query = session.createQuery("select w from Worker w where w.fullName like :name", Worker.class).setParameter("name", firstName + "%");
        List<Worker> workers = query.list();
        session.close();
        return workers;
    }

    public List<Object[]> findWorkersFirstNameAndExternalId() {
        Session session = ConnectionManager.getSession();
        Query query = session.createQuery("select w.fullName, w.externalId from Worker w");
        List<Object[]> result = query.list();
        session.close();
        return result;
    }
}