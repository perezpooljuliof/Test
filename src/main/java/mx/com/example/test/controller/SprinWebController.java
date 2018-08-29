package mx.com.example.test.controller;


import mx.com.core.utilidades.EMailManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by elver on 5/09/17.
 */
@Controller
@RequestMapping(value = "/page")
public class SprinWebController {

    final static Logger logger = Logger.getLogger("");

    @RequestMapping(value = {"/hello"}, method = RequestMethod.GET)
    public String sayHello2(ModelMap model) throws Exception {
        logger.info("sayHello()>>>>>");
        return "hello";
    }

    @RequestMapping(value = {"/bazinger"}, method = RequestMethod.GET)
    public String bazinger(ModelMap model) throws Exception {
        logger.info("bazinger()>>>>>");
        return "bazinger";
    }


    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(ModelMap model) throws Exception {
        logger.info("index()>>>>>");
        return "index";
    }

    @RequestMapping(value = {"/inventario"}, method = RequestMethod.GET)
    public String inventario(ModelMap model) throws Exception {
        return "inventario";
    }

    @RequestMapping(value = {"/sendMail"}, method = RequestMethod.GET)
    public String sendMail(ModelMap model) throws Exception {
        logger.info("sayHello2()>>>>>");
        EMailManager.sendMail();
        return "hello2";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
        @RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "logout", required = false) String logout) {
        logger.info("login()>>>>>");
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }

        model.setViewName("login");

        return model;
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String admin(ModelMap model) throws Exception {
        logger.info("admin()>>>>>");
        return "admin";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/page/login?logout";
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


