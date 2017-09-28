package mx.com.example.test.controller;

import mx.com.example.test.utilidades.EMailManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}


