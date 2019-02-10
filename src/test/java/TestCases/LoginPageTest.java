package TestCases;

import Base.TestBase;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginpage ; //= new LoginPage();

    public LoginPageTest(){

        super();
    }


    @BeforeMethod
    public void  setup(){
        loginpage = new LoginPage();
    }


    @Test(priority=1, enabled=false)
    public void LoginPageTitleTest() throws InterruptedException{

        String title = loginpage.verifyTitle();
        Assert.assertEquals(title, "Log In ? Wordpress Demo Site at Demo.Center /&#8212 WordPress");
        Thread.sleep(2000);

    }

    @Test(priority=2)
    public void LogoTest()  throws Exception{
        boolean flag = loginpage.verifyLogo();
        Assert.assertTrue(flag);
    }


    @Test(priority = 3)
    public void UsernameFieldTest() throws Exception{

        boolean flag = loginpage.verifyUsername();
        Assert.assertTrue(flag);
    }


    @Test(priority = 4)
    public void PasswordFieldTest() throws Exception{

        boolean flag = loginpage.verifyPassword();
        Assert.assertTrue(flag);
    }


    @Test(priority = 5)
    public void RememberMeFieldTest() throws Exception{

        boolean flag = loginpage.verifyRememberMe();
        Assert.assertTrue(flag);
    }



    @Test(priority=6)
    public void LoginTest() throws Exception{
        loginpage.DoLogin(prop.getProperty("username"), prop.getProperty("password"));

    }




}
