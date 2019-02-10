package TestCases;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage homepage;
    LoginPage loginpage;

    public HomePageTest(){

        super();
    }


    @BeforeMethod
    public void  setup(){
        homepage = new HomePage();
        loginpage = new LoginPage();
    }

    @Test(priority = 1)
    public void login() throws Exception{

        loginpage.DoLogin(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(priority=2)
    public void HomeLogoTest()  throws Exception{
        boolean flag = homepage.verifyLogo();
        Assert.assertTrue(flag);
    }


    @Test(priority = 3)
    public void HeaderTest() throws Exception{
        Assert.assertTrue(homepage.verifyHeader());
    }


    @Test(priority = 4)
    public void DashboardTabTest() throws Exception{
        Assert.assertTrue(homepage.verifyDashboardTab());
    }

    @Test(priority = 5)
    public void HomeTabTest() throws Exception{
        Assert.assertTrue(homepage.verifyHomeTab());
    }

    @Test(priority = 6)
    public void UpdatesTabTest() throws Exception{
        Assert.assertTrue(homepage.verifyUpdatesTab());
    }

    @Test(priority = 7)
    public void PostsTabTest() throws Exception{
        Assert.assertTrue(homepage.verifyPostsTab());
    }

    @Test(priority = 8)
    public void MediaTabTest() throws Exception{
        Assert.assertTrue(homepage.verifyMediaTab());
    }

    @Test(priority = 9)
    public void YouTubeTabTest() throws Exception{
        Assert.assertTrue(homepage.verifyYouTubeTab());
    }

    @Test(priority = 10)
    public void PagesTabTest() throws Exception{
        Assert.assertTrue(homepage.verifyPagesTab());
    }



}
