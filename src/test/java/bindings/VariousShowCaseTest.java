package bindings;

import cucumberTest.VariousShowCasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VariousShowCaseTest {

    WebDriver driver;
    WebDriverWait wait;
    Setup setup;
    VariousShowCasePage showCasePage;

    String url = "http://the-internet.herokuapp.com/";

    public VariousShowCaseTest(Setup setup) {
        this.setup = setup;
    }


    @Given("subpage for broken images and list of all images on page")
    public void go_to_brokenImagesPage(){
       driver = setup.getDriver();
       driver.get(url);
       showCasePage = new VariousShowCasePage(driver);
       showCasePage.brokenImageLink.click();
       assertTrue("Not on broken image page",driver.getPageSource().contains("Broken Images"));
    }

    @Then("we check all images for Http response code")
    public void check_images() {
        for (WebElement img : showCasePage.imageList) {
            if (!showCasePage.verifyImage(img)) {
                System.out.println ("Image broken:" + img.getAttribute("src"));
            }
        }
    }


    /** Context click which triggers alert**/
    @Given("the subpage for context click")
    public void go_on_subpage_context_click () {
        driver = setup.getDriver();
        wait = setup.getWait();
        driver.get(url);
        showCasePage = new VariousShowCasePage(driver);
        showCasePage.contextPageLink.click();
        assertTrue("Not on context menu page",driver.getCurrentUrl().matches("http://the-internet.herokuapp.com/context_menu"));
    }

    @When("clicking inside context box")
    public void right_click_on_page () {
        Actions action = new Actions(driver);
        action.contextClick(showCasePage.contextBox).perform();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("alert window is displayed")
    public void alert_window_should_display () {
        Alert alert = driver.switchTo().alert();
        assertTrue("Alert window is not triggered or incorrect description of window",alert.getText().contains("You selected a context menu"));
        alert.accept();
        assertFalse("Alert window was not closed",showCasePage.isAlertPresent());
    }

    /** Disapearing elements **/
    @Given("opening elements page")
    public void open_dis_page () {
        driver = setup.getDriver();
        wait = setup.wait;
        driver.get(url);
        showCasePage  = new VariousShowCasePage(driver);
        showCasePage.dissLinkPage.click();
        assertTrue("Not on disappearing elements page",driver.getCurrentUrl().matches("http://the-internet.herokuapp.com/disappearing_elements"));
    }

    @When("we click Home btn")
    public void click_home () {
        showCasePage.homeLink.click();
    }

    @Then("we should land on Home page")
    public void land_home_page () {
        assertTrue("Not redirected to Home page",driver.getCurrentUrl().matches("http://the-internet.herokuapp.com/"));
        driver.navigate().back();
    }

    @When("we click About btn")
    public void click_about () {
        showCasePage.aboutLink.click();
    }

    @Then("we should land on about page")
    public void land_about_page () {
        String currentUrl = driver.getCurrentUrl();
        assertTrue("Not redirected to About page",currentUrl.matches("http://the-internet.herokuapp.com/about/"));
    }

    /** Drag and drop elements **/
    @Given("drag and drop page")
    public void go_to_drag_drop_page () {
        driver = setup.getDriver();
        driver.get(url);
        showCasePage = new VariousShowCasePage(driver);
        showCasePage.dragDropLink.click();
    }

    @When("we drag element A into element B")
    public void drag_A_to_B () {
        assertTrue("Not on drag/drop page",driver.getCurrentUrl().matches("http://the-internet.herokuapp.com/drag_and_drop"));
        Actions action = new Actions(driver);
        //action.clickAndHold(showCasePage.columnA);
        //action.moveToElement(showCasePage.columnB).release().build().perform();
        action.clickAndHold(showCasePage.columnA).moveToElement(showCasePage.columnB).release().build().perform(); //none works in Chrome ,HTML 5 hell
        //action.dragAndDropBy(showCasePage.columnA, 250, 150).build().perform();
    }

    @Then("elements A and B should swap places")
    public void elements_swapped_AB_BA () throws InterruptedException {
        String A = showCasePage.columnA.getText();
        String B = showCasePage.columnB.getText();
        System.out.println("A ="+ A + "B="+ B);
        assertTrue("Columns were not swapped",A.matches("A"));
        assertTrue("Columns were not swapped",B.matches("B"));
        TimeUnit.SECONDS.sleep(1);//test
    }


    @Given("dropdown page")
    public void go_to_dropdown_page() {
        driver = setup.getDriver();
        driver.get(url);
        showCasePage = new VariousShowCasePage(driver);
        showCasePage.dropDownLink.click();
        //wait.until(ExpectedConditions.urlMatches(url + "/dropdown"));
        assertTrue("Not on dropdown page",driver.getPageSource().contains("Dropdown List"));
        WebElement option2 = showCasePage.dropDownMenu.get(2);
    }

    @When("we select Option1")
    public void select_option1() throws InterruptedException {
        WebElement option1 = showCasePage.dropDownMenu.get(1);
        option1.click();
    }

    @Then("Option1 should be selected")
    public void option1_should_be_selected () {
        WebElement option1 = showCasePage.dropDownMenu.get(1);
        assertTrue("Option 1 is not selected",option1.isSelected());
        assertTrue("Incorrect option text displayed",option1.getText().matches("Option 1"));
    }

    @When("we select Option2")
    public void select_option2 () {
        WebElement option2 = showCasePage.dropDownMenu.get(2);
        option2.click();
    }

    @Then("Option2 should be selected")
    public void option2_should_be_selected () {
        WebElement option2 = showCasePage.dropDownMenu.get(2);
        assertTrue("Option2 is not selected",option2.isSelected());
        assertTrue("Incorrect option text displayed",option2.getText().matches("Option 2"));
    }


}
