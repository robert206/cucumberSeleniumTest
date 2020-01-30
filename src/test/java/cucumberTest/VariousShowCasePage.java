package cucumberTest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class VariousShowCasePage extends Base {

    //constructor
    public VariousShowCasePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    /** Broken images elements **/
    @FindBy(linkText = "Broken Images")
    public WebElement brokenImageLink;
    @FindBy(xpath = "//*/div/img")
    public List<WebElement> imageList;

    /** ContextMenu elements **/
    @FindBy(xpath = "//*[@id='hot-spot']")
    public WebElement contextBox;
    @FindBy(linkText = "Context Menu")
    public WebElement contextPageLink;


    /**Disaapering elements **/
    @FindBy(linkText = "Disappearing Elements")
    public WebElement dissLinkPage;

    @FindBy(linkText = "Home")
    public WebElement homeLink;

    @FindBy(linkText = "About")
    public WebElement aboutLink;

    @FindBy(linkText = "Portfolio")
    public WebElement portfolioLink;

    @FindBy(linkText = "Contact Us")
    public WebElement contactLink;


    /** Drag and drop demo **/
    @FindBy(linkText = "Drag and Drop")
    public WebElement dragDropLink;

    @FindBy(xpath = "//*[@id='column-a']")
    public WebElement columnA;

    @FindBy(xpath = "//*[@id='column-b']")
    public WebElement columnB;


   //check for dead links/images using http request
    public boolean verifyImage (WebElement image) {
        HttpResponse response = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(image.getAttribute("src"));
            response = client.execute(request);
        } catch(Exception e) {
            e.printStackTrace();
        }
        assertTrue("Http response for images is null",response!=null);
        return response.getStatusLine().getStatusCode() == 200;
    }


    public boolean isAlertPresent(){
        boolean foundAlert;
        WebDriverWait wait = new WebDriverWait(driver, 0 );
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }







}
