package mx.com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mx.com.example.test.dto.Student;


@RestController
@RequestMapping(value = "/student")
public class StudentFormController {
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("StudentRegistrationForm", "command", new Student());
		//return "studentRegitrationForm";
	   }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    protected String save(@ModelAttribute("student") Student student, ModelMap model) throws Exception {
    	System.out.println("save()>>>>>");
    	System.out.println(student);
    	
    	
    	model.addAttribute("studentName", student.getStudentName());
        model.addAttribute("studentId", student.getStudentId());
        
        return "result";
    }
}
