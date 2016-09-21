package ua.in.dris4ecoder.spring.mvc.controllers.dbControllers;

import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Employee;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Position;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Waiter;
import ua.in.dris4ecoder.spring.mvc.model.dao.EmployeeDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.08.2016 20:37.
 */
public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Waiter> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeesByName(String name) {
        return employeeDao.findByName(name);
    }

    @Transactional
    public Employee getEmployeeById(long id) {
        return employeeDao.load(id);
    }

    @Transactional
    public void printEmployeeById(long id) {
        System.out.println(employeeDao.load(id));
    }

    @Transactional
    public void removeAllEmployees() {
        employeeDao.removeAll();
    }

    @Transactional
    public void initEmployee() {
        createEmployee("John", "Smith", Position.WAITER, "555-55-55", 2500F, 10);
        createEmployee("Mary", "Smith", Position.WAITER, "555-33-22", 2500F, 15);

    }

    private void createEmployee(String name, String surname, Position position, String phoneNumber, float salary, int tip) {

        Waiter waiter = new Waiter();
        waiter.setName(name);
        waiter.setSurname(surname);
        waiter.setPosition(position);
        waiter.setPhoneNumber(phoneNumber);
        waiter.setSalary(salary);
        waiter.setTip(tip);

        employeeDao.save(waiter);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
