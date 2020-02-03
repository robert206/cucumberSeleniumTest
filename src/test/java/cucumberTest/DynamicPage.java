package cucumberTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPage extends Base {

    WebDriver driver;

    public DynamicPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    /** Dynamic controls page elements **/
    @FindBy(linkText = "Dynamic Controls")
    public WebElement dynamicControlsLink;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement dynamicCheckbox;

    @FindBy(xpath = "//*[@id='checkbox-example']/button")
    public WebElement addRemoveBtn;

    @FindBy(xpath ="//input[@type='text']")
    public WebElement inputBox;

    @FindBy(xpath = "//*[@id='input-example']/button")
    public WebElement enableDisableBtn;

    @FindBy(xpath ="//p[@id='message']")
    public WebElement goneLabel;






}
