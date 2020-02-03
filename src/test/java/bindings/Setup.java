package bindings;

import cucumberTest.Base;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Setup {

  private WebDriver driver;
  WebDriverWait wait;


    @Before
    public void startBrowser (Scenario scenario) {
        if (driver == null) {
            //System.setProperty("chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver,4);

        }
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() { return wait; }


    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

}
