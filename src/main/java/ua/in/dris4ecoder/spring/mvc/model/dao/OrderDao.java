package ua.in.dris4ecoder.spring.mvc.model.dao;

import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Order;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:17.
 */
public interface OrderDao {

    void save(Order order);

    List<Order> findAllOrders();

    void removeAll();
}