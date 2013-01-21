package test.stepdef;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 17/01/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = {"test/stepdef","test/order.feature"},format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"})

public class RunCukesTest {


}
