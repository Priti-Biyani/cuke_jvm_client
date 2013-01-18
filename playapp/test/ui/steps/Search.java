package ui.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Search {
    WebDriver driver;

    public Search(WebDriver driver) {
        this.driver = driver;
    }

    @Given("I view an item status of requested order")
    public void visit() {
        String term = System.getProperty("order_id");
        driver.get("http://localhost:9000/getStatus/"+term);
    }

    @When("I update the status")
    public void searchForTerm() {
        driver.findElement(By.name("ChangeStatus")).submit();
    }

    @Then("I should see successful update message" )
    public void verifyTermResults() {
        String message = driver.findElement(By.tagName("h1")).getText();
        assertEquals(message,"Your order has been successfully updated.");
        System.out.print("<TaaS Response Start>{\"RESPONSE\":OK}<TaaS Response Complete>");
    }

}
