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

    @FindBy(xpath="//*[text()=': Invalid username. ']")
    WebElement InvalidUsernameMsg;

    @FindBy(xpath="//*[text()=': The password you entered for the username ']")
    WebElement InvalidPasswordMsg;

    @FindBy(xpath = "//*[@id=\"menu-dashboard\"]/a/div[3]")
    WebElement DashboardTab;


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


    public boolean InvalidUsername(String un, String pwd) throws Exception{

        HEY(Username);
        Username.sendKeys(un);
        HEY(Password);
        Password.sendKeys(pwd);
        HEY(LoginBtn);
        LoginBtn.click();
        WFEV(By.xpath("//*[text()=': Invalid username. ']"));
        HEY(InvalidUsernameMsg);
        return InvalidUsernameMsg.isDisplayed();

    }


    public boolean InvalidPassword(String un, String pwd) throws Exception {

        HEY(Username);
        Username.sendKeys(un);
        HEY(Password);
        Password.sendKeys(pwd);
        HEY(LoginBtn);
        LoginBtn.click();
        WFEV(By.xpath("//*[text()=': The password you entered for the username ']"));
        HEY(InvalidPasswordMsg);
        return InvalidPasswordMsg.isDisplayed();

    }

    public boolean DoLogin(String un, String pwd) throws Exception{

        driver.get(driver.getCurrentUrl());
        sleep(2000);
        Username.sendKeys(un);
        Password.sendKeys(pwd);
        LoginBtn.click();
        return DashboardTab.isDisplayed();
    }




}
