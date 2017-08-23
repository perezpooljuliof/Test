package mx.com.example.test.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import mx.com.example.test.dto.Book;
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
    
	@RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
        String csvFileName = "books.csv";
 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        Book book1 = new Book("Effective Java", "Java Best Practices",
                "Joshua Bloch", "Addision-Wesley", "0321356683", "05/08/2008",
                38);
 
        Book book2 = new Book("Head First Java", "Java for Beginners",
                "Kathy Sierra & Bert Bates", "O'Reilly Media", "0321356683",
                "02/09/2005", 30);
 
        Book book3 = new Book("Thinking in Java", "Java Core In-depth",
                "Bruce Eckel", "Prentice Hall", "0131872486", "02/26/2006", 45);
 
        Book book4 = new Book("Java Generics and Collections",
                "Comprehensive guide to generics and collections",
                "Naftalin & Philip Wadler", "O'Reilly Media", "0596527756",
                "10/24/2006", 27);
 
        List<Book> listBooks = Arrays.asList(book1, book2, book3, book4);
 
        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "Title", "Description", "Author", "Publisher",
                "isbn", "PublishedDate", "Price" };
 
        csvWriter.writeHeader(header);
 
        for (Book aBook : listBooks) {
            csvWriter.write(aBook, header);
        }
 
        csvWriter.close();
    }
	
	@RequestMapping(value="/viewCSV")
	public ModelAndView viewCSV(HttpServletResponse response) throws IOException {
	 
	    Book book1 = new Book("Effective Java", "Java Best Practices",
	            "Joshua Bloch", "Addision-Wesley", "0321356683", "05/08/2008",
	            38);
	 
	    Book book2 = new Book("Head First Java", "Java for Beginners",
	            "Kathy Sierra & Bert Bates", "O'Reilly Media", "0321356683",
	            "02/09/2005", 30);
	 
	    Book book3 = new Book("Thinking in Java", "Java Core In-depth",
	            "Bruce Eckel", "Prentice Hall", "0131872486", "02/26/2006", 45);
	 
	    Book book4 = new Book("Java Generics and Collections",
	            "Comprehensive guide to generics and collections",
	            "Naftalin & Philip Wadler", "O'Reilly Media", "0596527756",
	            "10/24/2006", 27);
	 
	    List<Book> listBooks = Arrays.asList(book1, book2, book3, book4);
	 
	    String[] header = { "Title", "Description", "Author", "Publisher",
	            "isbn", "PublishedDate", "Price" };
	 
	    ModelAndView model = new ModelAndView("ViewCSV");
	    model.addObject("csvData", listBooks);
	    model.addObject("csvHeader", header);
	 
	    return model;
	}
}
