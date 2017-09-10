package mx.com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by elver on 5/09/17.
 */
@Controller
@RequestMapping(value = "/page")
public class SprinWebController {

    @RequestMapping(value = {"/hello2"}, method = RequestMethod.GET)
    public String sayHello2(ModelMap model) throws Exception {
        return "hello2";
    }
}
