package ua.in.dris4ecoder.spring.mvc.model.services;

import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Waiter;
import ua.in.dris4ecoder.spring.mvc.model.dao.EmployeeDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 21.09.2016 20:05.
 */
public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Waiter> getEmployees() {

        return employeeDao.findAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
