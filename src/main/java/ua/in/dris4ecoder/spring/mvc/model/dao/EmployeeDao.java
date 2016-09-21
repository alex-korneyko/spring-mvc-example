package ua.in.dris4ecoder.spring.mvc.model.dao;

import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Employee;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Waiter;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.08.2016 20:31.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Waiter> findAll();

    Employee findByName(String name);

    void remove(Employee employee);

    void removeAll();
}
