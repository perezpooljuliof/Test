package mx.com.example.test.controller;

import mx.com.example.test.utilidades.EMailManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by elver on 5/09/17.
 */
@Controller
@RequestMapping(value = "/page")
public class SprinWebController {

    final static Logger logger = Logger.getLogger("");

    @RequestMapping(value = {"/hello2"}, method = RequestMethod.GET)
    public String sayHello2(ModelMap model) throws Exception {
        logger.info("sayHello2()>>>>>");
        return "hello2";
    }

    @RequestMapping(value = {"/sendMail"}, method = RequestMethod.GET)
    public String sendMail(ModelMap model) throws Exception {
        logger.info("sayHello2()>>>>>");
        EMailManager.sendMail();
        return "hello2";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(ModelMap model) throws Exception {
        logger.info("login()>>>>>");
        return "login";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String admin(ModelMap model) throws Exception {
        logger.info("admin()>>>>>");
        return "admin";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}


