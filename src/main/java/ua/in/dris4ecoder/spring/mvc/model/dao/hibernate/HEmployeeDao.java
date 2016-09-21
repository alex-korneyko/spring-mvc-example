package ua.in.dris4ecoder.spring.mvc.model.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Employee;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Waiter;
import ua.in.dris4ecoder.spring.mvc.model.dao.EmployeeDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.08.2016 20:34.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Transactional
    public void save(Employee employee) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Transactional
    public Waiter load(Long id) {
        return sessionFactory.getCurrentSession().load(Waiter.class, id);
    }

    @Transactional
    public List<Waiter> findAll() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from ua.in.dris4ecoder.spring.mvc.model.businessObjects.Waiter e").list();
    }

    @Override
    @Transactional
    public Employee findByName(String name) {
        final Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from ua.in.dris4ecoder.spring.mvc.model.businessObjects.Employee e where e.name = :name");
        query.setParameter("name", name);
        final Object o = query.uniqueResult();
        return (Employee) o;
    }

    @Transactional
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    @Transactional
    public void removeAll() {
        final Query query = sessionFactory.getCurrentSession().createQuery("delete from ua.in.dris4ecoder.spring.mvc.model.businessObjects.Waiter");
        query.executeUpdate();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
