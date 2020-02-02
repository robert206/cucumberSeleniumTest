package cucumberTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    WebDriver driver;
    WebDriverWait wait;


   public Base (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);

    }


}
