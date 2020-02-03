package bindings;

import cucumberTest.DynamicPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class DynamicControlsTest {

    WebDriver driver;
    WebDriverWait wait;
    Setup setup;
    DynamicPage dynamicPage;

    String url = "http://the-internet.herokuapp.com/";

    public DynamicControlsTest(Setup setup) {
        this.setup = setup;
    }

    @Given("page with dynamic Controls")
    public void  go_to_page_with_dynamic_controls () {
        driver = setup.getDriver();
        driver.get(url);
        dynamicPage = new DynamicPage(driver);
        dynamicPage.dynamicControlsLink.click();
        assertTrue("You are not on dynamic controls page",driver.getCurrentUrl().matches("http://the-internet.herokuapp.com/dynamic_controls"));
    }

    @When("we select checkbox")
    public void we_select_checkbox () {
        dynamicPage.dynamicCheckbox.click();
        assertTrue("Checkbox is not selected",dynamicPage.dynamicCheckbox.isSelected());
    }

    @And("click Remove btn")
    public void click_remove_btn () {
        dynamicPage.addRemoveBtn.click();
    }

    @Then("checkbox is removed and btn Add is visible")
    public void checkbox_removed_Add_visible () {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicPage.goneLabel));
        assertTrue("Invalid label or Removal failed",dynamicPage.goneLabel.getText().matches("It's gone!"));
    }

    @When("we click Add btn again")
    public void we_click_Add_btn_again () {
        dynamicPage.addRemoveBtn.click();
        wait.until(ExpectedConditions.textToBePresentInElement(dynamicPage.goneLabel,"It's back!"));
        assertTrue("CheckBox not removed", dynamicPage.goneLabel.getText().matches("It's back!"));
    }

    @Then("checkbox should be visible again along with btn Remove")
    public void checkbox_should_be_visible() {
        assertTrue("Checkbox is not visible",dynamicPage.dynamicCheckbox.isDisplayed());
        String btnText = dynamicPage.addRemoveBtn.getText();
        assertTrue("Button Remove is not displayed",btnText.matches("Remove"));
    }
}
