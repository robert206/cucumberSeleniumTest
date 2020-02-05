package bindings;

import cucumberTest.DynamicPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DynamicControlsTest {

    WebDriver driver;
    WebDriverWait wait;
    Setup setup;
    String url = "http://the-internet.herokuapp.com/";
    DynamicPage dynamicPage;

    /** DI stuff**/
    public DynamicControlsTest(Setup setup) {
        this.setup = setup;
        driver = setup.getDriver();
    }


    @Given("page with dynamic Controls")
    public void  go_to_page_with_dynamic_controls () {
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


    /** Enabled disable section **/

    @Given("page with dynamic controls again")
    public void go_to_dynamic_controls_again () {
        driver.get(url);
        dynamicPage = new DynamicPage(driver);
        dynamicPage.dynamicControlsLink.click();
        assertTrue("You are not on dynamic controls page",driver.getCurrentUrl().matches("http://the-internet.herokuapp.com/dynamic_controls"));
    }

    @When("we click Enable btn")
    public void we_click_enable_btn () throws InterruptedException {
        if (dynamicPage.enableDisableBtn.getText().matches("Enable")) {
            dynamicPage.enableDisableBtn.click();
        }
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.textToBePresentInElement(dynamicPage.goneLabel,"It's enabled!"));
    }

    @Then ("text field should be enabled")
    public void text_field_should_be_enabled () {
        assertTrue("Text field is not enabled for input",dynamicPage.inputBox.isEnabled());
        assertTrue("Incorrect label is displayed or text field is not enabled",dynamicPage.goneLabel.getText().matches("It's enabled!"));
    }

    @When("we send some text to field and press Disable btn")
    public void send_some_text_and_disable() {
        if (dynamicPage.inputBox.isEnabled()) {
            dynamicPage.inputBox.sendKeys("Test #$");
            dynamicPage.enableDisableBtn.click();
        }
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicPage.goneLabel));
    }

    @Then("text field should be disabled again and btn disabled")
    public void textField_and_Button_should_have_correctStatus()
    {
        assertFalse("Text field is not disabled for input",dynamicPage.inputBox.isEnabled());
        assertTrue("Incorrect label displayed or text field was not disabled",dynamicPage.goneLabel.getText().matches("It's disabled!"));
    }



    /** Feature Dynamically loaded elements **/

    @Given("the page with link element that is hidden")
    public void navigate_page_with_hiddenElement () {
        driver.get(url);
        dynamicPage = new DynamicPage(driver);
        dynamicPage.dynamicLoadLink.click();
        assertTrue("Not on dynamic load page",driver.getCurrentUrl().matches("http://the-internet.herokuapp.com/dynamic_loading"));
        dynamicPage.dynamicLink1.click();
        assertTrue("Not on correct subpage with Example1",driver.getPageSource().contains("Example 1"));
    }

    @When("we click on Start btn on example 1")
    public void start_example () throws InterruptedException {
        dynamicPage.startBtn.click();
        TimeUnit.SECONDS.sleep(2);
    }

    @Then("Start btn should disappear and hidden element appears")
    public void start_btn_gone_helloworld () throws InterruptedException {
        assertFalse("Start btn not clicked or not disappeared",dynamicPage.startBtn.isDisplayed());
        TimeUnit.SECONDS.sleep(2);
        wait.until(ExpectedConditions.visibilityOf(dynamicPage.helloWorld));
        assertTrue("Hello world appears",dynamicPage.helloWorld.isDisplayed());
    }

    @When("We navigate back and this time select Example 2")
    public void we_navigate_back_to_link_page_and_select_link2 () {
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(dynamicPage.dynamicLink2));
        assertTrue("Dynamic page is not visible",dynamicPage.dynamicLink2.isDisplayed());
        dynamicPage.dynamicLink2.click();
    }

    @Then("We should be on Example2 page")
    public void we_should_be_on_page_2 () {
        assertTrue("You are not on dynamically loaded page",driver.getCurrentUrl().matches("http://the-internet.herokuapp.com/dynamic_loading/2"));
    }

    @When("We click Start btn on example2")
    public void start_btn_on_example2 () {
        dynamicPage.startBtn.click();
    }

    @Then("Start btn is gone again and element is rendered after the fact")
    public void start_btn_is_gone_again_rendered () {
        wait.until(ExpectedConditions.visibilityOf(dynamicPage.helloWorld));
        assertTrue("Hello world not present",driver.getPageSource().contains("Hello World!"));
    }





}
