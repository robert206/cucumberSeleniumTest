package bindings;

import cucumberTest.CheckboxesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class Checkboxes {

    WebDriver driver;
    Setup setup;
    CheckboxesPage chkPage;
    String url = "http://the-internet.herokuapp.com/";

    public Checkboxes(Setup setup) {
        this.setup = setup;
    }

    @Given("The checkboxes page")
    public void go_to_checkbox_page() {
        driver= setup.getDriver();
        driver.get(url);
        chkPage = new CheckboxesPage(driver);
        chkPage.checkBoxLink.click();
    }

    @When("I click checkbox1")
    public void and_click_checkbox1 () {
        chkPage.checkboxes.get(0).click();
    }

    @Then("it should be selected")
    public void it_should_be_selected () {
        assertTrue("Checkbox was not selected",chkPage.checkboxes.get(0).isSelected());
    }

    @When("I click checkbox2")
    public void i_click_checkbox_2 () {
        chkPage.checkboxes.get(1).click();
    }

    @Then("It should be deselected")
    public void it_should_be_deselected () {
        assertFalse("Checkbox was not deselected",chkPage.checkboxes.get(1).isSelected());
    }
}
