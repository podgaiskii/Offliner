package by.bsuir.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractDao<T> {

    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(T entity) {
        getCurrentSession().persist(entity);
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public void delete(int id) {
        T entity = loadEntity(id);
        if (entity != null) {
            getCurrentSession().delete(entity);
        }
    }

    public T getById(int id) {
        return loadEntity(id);
    }

    public List<T> getAll() {
        return (List<T>) getCurrentSession().createQuery(" from " + getEntityClass().getSimpleName()).list();
    }

    private T loadEntity(int id) {
        return (T) getCurrentSession().load(getEntityClass(), id);
    }

    protected abstract Class getEntityClass();

}
