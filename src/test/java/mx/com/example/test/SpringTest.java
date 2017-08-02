package mx.com.example.test;

/*
import mx.com.example.test.config.HelloController;
import mx.com.example.test.dto.Student;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-config.xml")
@WebAppConfiguration
public class SpringTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    Student estudiante;

    private MockMvc mvc;
    final static Logger logger = Logger.getLogger(SpringTest.class);

    @Test
    public void beanTest() {
        logger.info("beanTest() - estudiante:" + estudiante);
        Assert.notNull(estudiante);
    }

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }
}
*/