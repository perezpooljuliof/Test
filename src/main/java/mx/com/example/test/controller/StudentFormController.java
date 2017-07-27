package mx.com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mx.com.example.test.dto.Student;


@RestController
@RequestMapping(value = "/student")
public class StudentFormController {
	
    
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    protected Student save(@ModelAttribute("student") Student student) throws Exception {
    	
        return student;
    }
}
