package ua.in.dris4ecoder.spring.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.in.dris4ecoder.spring.mvc.controllers.dbControllers.DishController;
import ua.in.dris4ecoder.spring.mvc.controllers.dbControllers.EmployeeController;
import ua.in.dris4ecoder.spring.mvc.controllers.dbControllers.OrderController;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 13.08.2016 15:32.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    private List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {

        employeeController.getAllEmployees().forEach(System.out::println);
//        employeeController.printEmployeeById(1);

//        orderController.getAllOrders().forEach(System.out::println);
    }


    public void init(boolean reInit) {

        if(reInit) {
            orderController.removeAllOrders();
            dishController.removeAllDishes();
            employeeController.removeAllEmployees();

            employeeController.initEmployee();
            dishController.initDishes();
            orderController.initOrders();
        }
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
