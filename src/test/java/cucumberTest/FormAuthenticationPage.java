package cucumberTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage extends Base {

    WebDriver driver;

    public FormAuthenticationPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(linkText = "Form Authentication")
    public WebElement formLinkText;
    @FindBy(id = "username")
    public WebElement usernameField;
    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@class='fa fa-2x fa-sign-in']")
    public WebElement signInBtn;
    @FindBy(xpath = "//i[@class='icon-2x icon-signout']")
    public WebElement logoutBtn;



}
