package mx.com.example.test;


import org.apache.log4j.Logger;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class TestApp {

    final static Logger logger = Logger.getLogger(TestApp.class);
    /*
     * Rigourous Test :-)
     */
    @Test
    public void testApp()
    {
        logger.info(this.getClass().getName() + " testApp()>>>>>" );
        assertTrue( true );
    }
}
