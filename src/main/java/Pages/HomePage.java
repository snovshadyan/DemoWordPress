package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath="//*[@id='wp-admin-bar-wp-logo']/a/span[1]")
    WebElement HomePageLogo;

    @FindBy(xpath = "//*[@id=\"wp-admin-bar-site-name\"]/a")
    WebElement Header;

    @FindBy(xpath = "//*[@id=\"menu-dashboard\"]/a/div[3]")
    WebElement DashboardTab;

    @FindBy(xpath = "//*[@id=\"menu-dashboard\"]/ul/li[2]/a")
    WebElement HomeTab;

    @FindBy(xpath = "//*[@id=\"menu-dashboard\"]/ul/li[3]/a")
    WebElement UpdatesTab;

    @FindBy(xpath = "//*[@id=\"menu-posts\"]/a/div[3]")
    WebElement PostsTab;

    @FindBy(xpath = "//*[@id=\"menu-media\"]/a/div[3]")
    WebElement MediaTab;

    @FindBy(xpath = "//*[@id=\"toplevel_page_ye-profile-options\"]/a/div[3]")
    WebElement YouTubeTab;

    @FindBy(xpath = "//div[@class='wp-menu-name' and contains(text(),'Pages')]")
    WebElement PagesTab;






    public HomePage(){
        PageFactory.initElements(driver, this);
    }


    public boolean  verifyLogo() throws Exception {
        WFEV(By.xpath("//*[@id='wp-admin-bar-wp-logo']/a/span[1]"));
        return HomePageLogo.isDisplayed();
    }


    public boolean verifyHeader() throws Exception{
        HEY(Header);
        return Header.isDisplayed();
    }


    public boolean verifyDashboardTab() throws Exception{
         HEY(DashboardTab);
        return DashboardTab.isDisplayed();
    }

    public boolean verifyHomeTab() throws Exception{
         HEY(HomeTab);
        return HomeTab.isDisplayed();
    }

    public boolean verifyUpdatesTab() throws Exception{
        HEY (UpdatesTab);
        return UpdatesTab.isDisplayed();
    }

    public boolean verifyPostsTab() throws Exception{
        HEY(PostsTab);
        return PostsTab.isDisplayed();
    }

    public boolean verifyMediaTab() throws Exception{
        HEY(MediaTab);
        return MediaTab.isDisplayed();
    }


    public boolean verifyYouTubeTab() throws Exception{
        HEY(YouTubeTab);
        return YouTubeTab.isDisplayed();
    }

    public boolean verifyPagesTab() throws Exception{
        HEY(PagesTab);
        return PagesTab.isDisplayed();
    }






}
