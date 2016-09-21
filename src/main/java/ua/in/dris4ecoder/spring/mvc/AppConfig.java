package ua.in.dris4ecoder.spring.mvc;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ua.in.dris4ecoder.spring.mvc.controllers.dbControllers.DishController;
import ua.in.dris4ecoder.spring.mvc.controllers.dbControllers.EmployeeController;
import ua.in.dris4ecoder.spring.mvc.controllers.dbControllers.OrderController;
import ua.in.dris4ecoder.spring.mvc.model.dao.DishDao;
import ua.in.dris4ecoder.spring.mvc.model.dao.EmployeeDao;
import ua.in.dris4ecoder.spring.mvc.model.dao.OrderDao;
import ua.in.dris4ecoder.spring.mvc.model.dao.hibernate.HDishDao;
import ua.in.dris4ecoder.spring.mvc.model.dao.hibernate.HEmployeeDao;
import ua.in.dris4ecoder.spring.mvc.model.dao.hibernate.HOrderDao;
import ua.in.dris4ecoder.spring.mvc.model.services.EmployeeService;

/**
 * Created by Alex Korneyko on 13.08.2016 20:47.
 */
@Configuration
public class AppConfig {

    @Bean
    Main mainObject(EmployeeController controller, DishController dishController, OrderController orderController) {
        Main main = new Main();
        main.setEmployeeController(controller);
        main.setDishController(dishController);
        main.setOrderController(orderController);

        main.init(true);

        return main;
    }

    @Bean
    EmployeeController employeeController(EmployeeDao employeeDao) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.setEmployeeDao(employeeDao);
        return employeeController;
    }

    @Bean
    DishController dishController(DishDao dishDao) {
        DishController dishController = new DishController();
        dishController.setDishDao(dishDao);
        return dishController;
    }

    @Bean
    OrderController orderController(EmployeeDao employeeDao, DishDao dishDao, OrderDao orderDao) {
        OrderController controller = new OrderController();
        controller.setDishDao(dishDao);
        controller.setEmployeeDao(employeeDao);
        controller.setOrderDao(orderDao);
        return controller;
    }

    @Bean
    EmployeeDao hEmployeeDao(SessionFactory sessionFactoryBean) {
        HEmployeeDao hEmployeeDao = new HEmployeeDao();
        hEmployeeDao.setSessionFactory(sessionFactoryBean);
        return hEmployeeDao;
    }

    @Bean
    DishDao hDishDao(SessionFactory sessionFactory) {
        HDishDao hDishDao = new HDishDao();
        hDishDao.setSessionFactory(sessionFactory);
        return hDishDao;
    }

    @Bean
    OrderDao orderDao(SessionFactory sessionFactory) {
        HOrderDao orderDao = new HOrderDao();
        orderDao.setSessionFactory(sessionFactory);
        return orderDao;
    }

    @Bean
    EmployeeService employeeService(EmployeeDao employeeDao) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployeeDao(employeeDao);
        return employeeService;
    }

    @Bean
    ua.in.dris4ecoder.spring.mvc.controllers.webControllers.EmployeeController employeeController(EmployeeService employeeService) {
        ua.in.dris4ecoder.spring.mvc.controllers.webControllers.EmployeeController employeeController = new ua.in.dris4ecoder.spring.mvc.controllers.webControllers.EmployeeController();
        employeeController.setEmployeeService(employeeService);
        return employeeController;
    }

//    @Bean
//    InternalResourceViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setViewClass(JstlView.class);
//        internalResourceViewResolver.setPrefix("/WEB-INF/view/jsp/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        return internalResourceViewResolver;
//    }
}
