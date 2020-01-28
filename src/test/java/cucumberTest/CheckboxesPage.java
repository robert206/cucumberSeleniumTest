package cucumberTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends Base {

    WebDriver driver;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Checkboxes")
    public WebElement checkBoxLink;

    @FindBy(xpath = "//*[@id='checkboxes']/input")
    public List<WebElement> checkboxes;


}
