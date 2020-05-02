import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class FiresTest {
    private static final Logger logger = LogManager.getLogger(FiresTest.class);

    @Before
    public void setUp(){

    }

    @Test
    public void test1(){
        logger.info("INFO");
        logger.debug("Debug");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARN");
    }




}
