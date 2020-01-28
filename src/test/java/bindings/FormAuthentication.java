package bindings;

import cucumberTest.FormAuthenticationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class FormAuthentication {

    WebDriver driver;
    FormAuthenticationPage formAuth;
    Setup setup;
    String url = "http://the-internet.herokuapp.com/";

    public FormAuthentication(Setup setup) {
        this.setup = setup;
    }

    String loggedIn = "";


    @Given("That I go to form authentication")
    public void go_to_auth_form () {
        driver = setup.getDriver();
        driver.get(url);
        formAuth = new FormAuthenticationPage(driver);
        formAuth.formLinkText.click();
        assertTrue("You are not on Login page", driver.getPageSource().contains("Login Page"));
    }


    @When("I enter username {string} and {string} and press Submit")
    public void enter_invalid_username_password (String username,String password) {
        String currentUrl = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.urlMatches(currentUrl));

        formAuth.usernameField.sendKeys(username);
        formAuth.passwordField.sendKeys(password);
        formAuth.signInBtn.click();
    }

    @Then("I should get correct {string}")
    public void check_if_user_not_logged_in (String status) {
        if (driver.getPageSource().contains("Your username is invalid!")) {
            loggedIn = "false";
        }
        else loggedIn = "true";
        assertEquals("Invalid login status",loggedIn,status);

    }




}
