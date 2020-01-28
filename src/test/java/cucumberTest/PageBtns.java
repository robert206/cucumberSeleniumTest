package cucumberTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageBtns extends Base {


    @FindBy(xpath = "//*[@id='content']/ul/li[2]/a")
   public WebElement addRemoveLink ;

    @FindBy(xpath = "//button[@onclick='addElement()']")
    public WebElement addRemoveBtn;

    @FindBy(xpath = "//div[@id='elements']/button")
    public List<WebElement> deleteBtns;


    public PageBtns (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    //public WebDriverWait wait;

    public void clickLink() {
        addRemoveLink.click();
    }

    public void clickDeleteBtns () {
        for (WebElement btn : deleteBtns) {
            btn.click();
        }
    }

}
