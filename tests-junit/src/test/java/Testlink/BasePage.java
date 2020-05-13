package Testlink;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static Testlink.Prop.getProperty;
import java.util.HashMap;


public class BasePage extends BaseTest{

    public static void frameIsAvaliable(int name) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
    }

    public static void Authorization(String name, String pass){
        driver.get(getProperty("baseUrl"));
        driver.findElement(By.name("tl_login")).sendKeys(name);
        driver.findElement(By.name("tl_password")).sendKeys(pass);
        driver.findElement((By.id("tl_login_button"))).click();

    }


    public static void CreateTestSuit(String frameName, String frameDescription) throws InterruptedException {
        driver.get(getProperty("baseUrl"));
        driver.switchTo().frame("mainframe");
        driver.findElement(By.linkText("Test Specification")).click();
        driver.switchTo().frame("workframe");
        driver.findElement(By.cssSelector("img[title=Actions]")).click();
        driver.findElement(By.id("new_testsuite")).click();
        driver.findElement(By.cssSelector("input[id=name]")).sendKeys(frameName);
        driver.switchTo().frame(0);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String s = "document.querySelector(\"body[class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']\").innerHTML='" + frameDescription + "'";
        js.executeScript(s);
        driver.switchTo().parentFrame();
        driver.findElement(By.name("add_testsuite_button")).click();

    }
    public static void createTestCase(HashMap<String, String> steps, String testCaseName, String summeryTestCase, String precondition, String testSuit) throws InterruptedException {
        driver.get(getProperty("baseUrl"));
        driver.switchTo().frame("mainframe");
        driver.findElement(By.linkText("Test Specification")).click();
        driver.switchTo().frame("treeframe");
        driver.findElement(By.id("tree_div")).findElement(By.xpath("//span[contains(text(), '" + testSuit + "')]")).click();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("workframe");
        driver.findElement(By.cssSelector("img[title=Actions]")).click();
        driver.findElement(By.name("create_tc")).click();
        driver.findElement(By.name("testcase_name")).sendKeys(testCaseName);
        driver.switchTo().frame(0);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String s = "document.querySelector(\"body[class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']\").innerHTML='" + summeryTestCase + "'";
        js.executeScript(s);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        String ss = "document.querySelector(\"body[class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']\").innerHTML='" + precondition + "'";
        js.executeScript(ss);
        driver.switchTo().parentFrame();
        driver.findElement(By.id("do_create_button")).click();
        driver.findElement(By.name("create_step")).click();

        for (int i = 0; i < steps.size(); i++){
            frameIsAvaliable(0);
            String tcs = "document.querySelector(\"body[class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']\").innerHTML='" + steps.keySet().toArray()[i] + "'";
            js.executeScript(tcs);
            int c = i+1;
            driver.switchTo().parentFrame();
            frameIsAvaliable(1);
            String tcr = "document.querySelector(\"body[class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']\").innerHTML='" + steps.values().toArray()[i] + "'";
            js.executeScript(tcr);
            driver.switchTo().parentFrame();
            driver.findElement(By.name("do_update_step")).click();
            driver.findElement(By.id("step_row_"+ String.valueOf(c)));
        }







    }


}
