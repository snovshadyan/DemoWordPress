package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostsPage extends TestBase {


    @FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[3]")
    WebElement PostsTab;

    @FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[2]/a")
    WebElement AllPostsTab;

    @FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[3]/a")
    WebElement AddNewTab;

    @FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
    WebElement CategoriesTab;

    @FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[5]/a")
    WebElement TagsTab;

    @FindBy(xpath="//*[@id=\"bulk-action-selector-top\"]")
    WebElement BulkActionsBtn;

    @FindBy(xpath="//*[@id=\"doaction\"]")
    WebElement ApplyBtn;

    @FindBy(xpath="//*[@id=\"filter-by-date\"]")
    WebElement AllDatesBtn;

    @FindBy(xpath="//*[@id=\"cat\"]")
    WebElement AllCategoriesBtn;

    @FindBy(xpath="//*[@id=\"post-query-submit\"]")
    WebElement FilterBtn;

    public PostsPage(){
        PageFactory.initElements(driver, this);
    }



    public boolean verifyAllPostsTab() throws Exception{

        WFEV(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
        PostsTab.click();
        WFEV(By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a"));
        return AllPostsTab.isDisplayed();
    }


    public boolean verifyAddNewTab() throws Exception{
        HEY(AddNewTab);
        return AddNewTab.isDisplayed();
    }


    public boolean verifyCategoriesTab() throws Exception{
        HEY(CategoriesTab);
        return CategoriesTab.isDisplayed();
    }


    public boolean verifyTagsTab() throws Exception{
        HEY(TagsTab);
        return TagsTab.isDisplayed();
    }


    public boolean verifyBulkActionsBtn() throws Exception{
        HEY(BulkActionsBtn);
        return BulkActionsBtn.isDisplayed();
    }


    public boolean verifyApplyBtn() throws Exception{
        HEY(ApplyBtn);
        return ApplyBtn.isDisplayed();
    }


    public boolean verifyAllDatesBtn() throws Exception {
        HEY(AllDatesBtn);
        return AllDatesBtn.isDisplayed();
    }


    public boolean verifyAllCategoriesBtn() throws Exception{
        HEY(AllCategoriesBtn);
        return AllCategoriesBtn.isDisplayed();
    }


    public boolean verifyFilterBtn() throws Exception{
        HEY(FilterBtn);
        return FilterBtn.isDisplayed();
    }







}
