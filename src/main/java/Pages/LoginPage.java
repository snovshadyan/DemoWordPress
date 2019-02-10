package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath="//a[@href='https://wordpress.org/']")
    WebElement Loginlogo;

    @FindBy(xpath="//input[@name='log']")
    WebElement Username;

    @FindBy(xpath="//input[@name='pwd']")
    WebElement Password;

    @FindBy(xpath="//input[@name='wp-submit']")
    WebElement LoginBtn;

    @FindBy(xpath = "//input[@name='rememberme']")
    WebElement RememberMe;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }



    public String verifyTitle(){

        return driver.getTitle();
    }


    public boolean  verifyLogo() throws Exception {
        WFEV(By.xpath("//a[@href='https://wordpress.org/']"));
        return Loginlogo.isDisplayed();
    }


    public boolean  verifyUsername() throws Exception {
        HEY(Username);
        return Username.isDisplayed();
    }


    public boolean  verifyPassword() throws Exception {
        HEY(Password);
        return Password.isDisplayed();
    }


    public boolean  verifyRememberMe() throws Exception {
        HEY(RememberMe);
        return RememberMe.isDisplayed();
    }


    public HomePage DoLogin(String un, String pwd) throws Exception{

        Username.sendKeys(un);
        Password.sendKeys(pwd);
        LoginBtn.click();
        return new HomePage();
    }




}
