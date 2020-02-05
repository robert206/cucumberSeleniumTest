package bindings;

import static org.junit.Assert.*;

import bindings.Setup;
import cucumberTest.Configuration;
import cucumberTest.PageBtns;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddRemoveElements {


    WebDriver driver;
    PageBtns pageBtns;
    Setup setup;
    Configuration cfg;
    Scenario scenario;
    String environment  = "Test01";

    public AddRemoveElements(Setup setup) {
        this.setup = setup;
    }

    String url = "http://the-internet.herokuapp.com/";


    @Given("Add Remove elements page")
    public void add_Remove_elements_page()  {
        driver = setup.getDriver();
        driver.get(url);
        pageBtns = new PageBtns(driver);
        // go to add/remove page via link
        pageBtns.clickLink();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(pageBtns.addRemoveBtn));
        assertTrue(pageBtns.addRemoveBtn.isDisplayed());
    }

    @When("I click on Add element btn")
    public void i_click_on_Add_element_btn() {
        // click add btn 10 times
        for (int i=0;i < 10; i++) {
            pageBtns.addRemoveBtn.click();
        }
        // check that button appears 10 times -its stored into list via locator
        int size = pageBtns.deleteBtns.size();
        assertEquals(size,10);
    }

    @Then("Element should be added and Delete btn should be seen")
    public void element_should_be_added_and_Delete_btn_should_be_seen() {
        int size = pageBtns.deleteBtns.size();
        assertEquals(size,10);
    }

    @When("I click Delete btn 10 times")
    public void i_click_Delete_btn() {
        pageBtns.clickDeleteBtns();
    }

    @Then("Btns should be removed")
    public void btn_should_be_removed() {
        assertEquals(pageBtns.deleteBtns.size(),0);
    }


}
