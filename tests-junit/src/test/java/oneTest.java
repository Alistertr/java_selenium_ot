import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;



public class oneTest extends BaseTest{
    private static final Logger logger = LogManager.getLogger(oneTest.class);

    @Test
    public void GoogleTest() throws InterruptedException {
        driver.get("https://www.google.ru/");
        Thread.sleep(5000);
    }

}
