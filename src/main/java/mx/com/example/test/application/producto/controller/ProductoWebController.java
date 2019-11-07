package mx.com.example.test.application.producto.controller;


import mx.com.core.db.BaseResultado;
import mx.com.example.test.application.producto.dto.Producto;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by elver on 5/09/17.
 */
@Controller
@RequestMapping(value = "/Web/Producto")
public class ProductoWebController {

    final static Logger logger = Logger.getLogger("");

    @RequestMapping(value = {"/Index"}, method = RequestMethod.GET)
    public String index(ModelMap model) throws Exception {
        logger.info("index()>>>>>");
        return "index";
    }

    @RequestMapping(value = {"/Inventario"}, method = RequestMethod.GET)
    public String inventario(ModelMap model) throws Exception {
        logger.info("inventario()>>>>>>>>>>>>>>><");
        return "producto/inventario";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
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

    @RequestMapping(path = "/altaProducto", method = RequestMethod.POST)
    public @ResponseBody Producto altaProducto(@RequestBody Producto producto) {
        System.out.println(this.getClass().getSimpleName() + ".altaProducto");
        System.out.println("IDProducto" + producto.getIdProducto());
        System.out.println("producto" + producto.getProducto());

        return new Producto();
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
        System.out.println("accessDeniedPage()>>>>>>>>>>>>>>>>");
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


