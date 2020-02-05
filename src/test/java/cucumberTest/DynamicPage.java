package cucumberTest;

import com.codeborne.selenide.SelenideElement;
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


    /** Dynamic loading **/
    @FindBy(linkText = "Dynamic Loading")
    public WebElement dynamicLoadLink;

    @FindBy(xpath = "//a[@href ='/dynamic_loading/1']")
    public WebElement dynamicLink1;

    @FindBy(xpath = "//a[@href ='/dynamic_loading/2']")
    public WebElement dynamicLink2;

    @FindBy(xpath ="//*[@id='start']/button")
    public WebElement startBtn;

    @FindBy(xpath = "//*[@id='finish']/h4")
    public WebElement helloWorld;









}
