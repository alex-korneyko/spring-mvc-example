package ua.in.dris4ecoder.spring.mvc.controllers.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.in.dris4ecoder.spring.mvc.model.services.EmployeeService;

import java.util.Map;

/**
 * Created by Alex Korneyko on 21.09.2016 20:01.
 */
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {

        model.put("employees", employeeService.getEmployees());

        return "employees";
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
