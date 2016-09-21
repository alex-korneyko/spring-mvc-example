package ua.in.dris4ecoder.spring.mvc.controllers.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

/**
 * Created by Alex Korneyko on 20.09.2016 21:34.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("currentTime", new Date().toString());
        return "index";
    }

}
