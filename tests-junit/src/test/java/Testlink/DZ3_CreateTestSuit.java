package Testlink;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DZ3_CreateTestSuit extends BaseTest{


    @Before
    public void setUp(){
        BasePage.Authorization("user", "nimda");

    }

    @Test
    public void createTestSuit() throws InterruptedException {
        HashMap<String, String> steps = new HashMap<String, String>();
        steps.put("Step 1","result 1");
        steps.put("Step 2","result 2");
        steps.put("Step 3","result 3");
        HashMap<String, String> stepTC = new HashMap<String, String>();
        stepTC.put("Step a","result a");
        stepTC.put("Step b","result b");
        stepTC.put("Step c","result c");

        BasePage.CreateTestSuit("New test Suit","Description for new test suite");
        BasePage.createTestCase(steps,"Otus 1 testcase", "This is summery testCase","This is precondition", "New test Suit");
        BasePage.createTestCase(stepTC,"Otus 2 testcase", "This is summery testCase","This is precondition", "New test Suit");

    }
}

