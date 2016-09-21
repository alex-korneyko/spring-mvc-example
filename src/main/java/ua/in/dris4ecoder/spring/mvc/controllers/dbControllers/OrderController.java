package ua.in.dris4ecoder.spring.mvc.controllers.dbControllers;

import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Dish;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.DishCategory;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Order;
import ua.in.dris4ecoder.spring.mvc.model.dao.DishDao;
import ua.in.dris4ecoder.spring.mvc.model.dao.EmployeeDao;
import ua.in.dris4ecoder.spring.mvc.model.dao.OrderDao;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Alex Korneyko on 14.08.2016 19:01.
 */
public class OrderController {

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;
    private List<Order> allOrders = new ArrayList<>();

    public void initOrders() {
        createOrder("John", Arrays.asList("Plov", "Salad"), 1);
        createOrder("Mary", Arrays.asList("Potato", "Salad"), 2);
        createOrder("John", Arrays.asList("Borsch", "Potato", "Salad"), 3);

        orderDao.save(createOrderWithIceCream());
    }

    private Order createOrderWithIceCream() {
        Dish iceCream = new Dish();
        iceCream.setName("Ice Cream");
        iceCream.setCategory(DishCategory.DESSERT);
        iceCream.setPrice(3.0F);
        iceCream.setWeight(300F);

//        dishDao.save(iceCream);

        Order order = new Order();
        order.setDishes(Collections.singletonList(iceCream));
        order.setTableNumber(2);
        order.setWaiter(employeeDao.findByName("Mary"));
        order.setOrderDate(new Date());
        return order;
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderDao.findAllOrders();
    }

    @Transactional
    public void removeAllOrders() {
        orderDao.removeAll();
    }

    @Transactional
    public void printOrders() {
        orderDao.findAllOrders().forEach(System.out::println);
    }

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {

        Order order = new Order();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());

        orderDao.save(order);
    }

    @Transactional
    private List<Dish> createDishes(List<String> dishName) {
        return dishName.stream().map(dName -> dishDao.findByName(dName)).collect(Collectors.toList());
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
