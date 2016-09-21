package ua.in.dris4ecoder.spring.mvc.model.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Order;
import ua.in.dris4ecoder.spring.mvc.model.dao.OrderDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:18.
 */
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @Transactional
    public List<Order> findAllOrders() {
        Query<Order> query = sessionFactory.getCurrentSession().createQuery("select o from ua.in.dris4ecoder.spring.mvc.model.businessObjects.Order o");
        return query.list();
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from ua.in.dris4ecoder.spring.mvc.model.businessObjects.Order").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
