package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

import static org.apache.poi.hssf.usermodel.HSSFShapeTypes.TextBox;

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

    @FindBy(xpath="//*[@id=\"wpbody-content\"]/div[4]/a")
    WebElement AddNewBtn;

    @FindBy(xpath="//*[@id=\"post-search-input\"]")
    WebElement SearchField;

    @FindBy(xpath="//*[@id=\"search-submit\"]")
    WebElement SearchBtn;

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

    @FindBy(xpath="//*[@id=\"title-prompt-text\"]")
    WebElement NewPostTitle;

    @FindBy(xpath="//*[@id=\"content\"]")
    WebElement NewPostContent;

    @FindBy(xpath="//*[@id=\"publish\"]")
    WebElement PublisgBtn;

    @FindBy(xpath="//*[contains(text(),'TestTitle')]")
    WebElement NewPostField;



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

    public boolean verifyAddNewBtn() throws Exception{
        HEY(AddNewBtn);
        return AddNewBtn.isDisplayed();
    }

    public boolean verifySearchField() throws Exception{
        HEY(SearchField);
        return SearchField.isDisplayed();
    }

    public boolean verifySearchBtn() throws Exception{
        HEY(SearchBtn);
        return SearchBtn.isDisplayed();
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



    public boolean verifyNewPost() throws Exception{

        AddNewBtn.click();
        WFEC(By.xpath("//*[@id=\"title-prompt-text\"]"));
        NewPostTitle.click();


        Actions performAct = new Actions(driver);
        performAct.sendKeys(NewPostTitle, "TestTitle").build().perform();


        NewPostContent.sendKeys("Test Content");
        PublisgBtn.click();
        sleep(2000);
        AllPostsTab.click();
        WFEV(By.xpath("//*[contains(text(),'TestTitle')]"));
        return NewPostField.isDisplayed();
    }



}
