package bindings;

import cucumberTest.BasicAuthorizationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasicAuthorization {

    WebDriver driver;
    Setup setup;
    BasicAuthorizationPage basicPage;
    String url = "http://the-internet.herokuapp.com/";

    public BasicAuthorization (Setup setup) {
        this.setup = setup;
    }



    @Given ("authorization page \\/dialog")
    public void open_authorization_page () {
       driver = setup.getDriver();
       driver.get(url);
       basicPage = new BasicAuthorizationPage(driver);
       basicPage.basicAuthLink.click();
       Alert alertWnd = driver.switchTo().alert();
       String alertText = alertWnd.getText();
       assert alertText.equals("Sign in");
    }

    @When ("I enter Username and Password and click Sign in" )
    public void enter_Username_password () {

    }

    @Then("I should be logged in")
    public void should_be_logged_in () {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("greeted with Congratulations message")
    public void and_greeted_with_gz_message () {

    }

}
