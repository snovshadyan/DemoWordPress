package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath="//*[@class='page-title-action' and text()='Add New']")
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

    @FindBy(xpath="//*[text()='Enter title here']")
    WebElement NewPostTitle;

    @FindBy(xpath="//*[@id=\"content\"]")
    WebElement NewPostContent;

    @FindBy(xpath="//*[@id='publish' and @value='Publish']")
    WebElement PublisgBtn1;

    @FindBy(xpath="//*[contains(text(),'TestTitle')]")
    WebElement NewPostField;

    @FindBy(xpath = "//*[text()='TestTitle']/parent::div/parent::td/parent::tr/th/input")
    WebElement NewPostCheckBox;

    @FindBy(xpath="//*[@id='bulk-action-selector-top']")
    WebElement bulk_action_selector_top;

    @FindBy(xpath="//*[@id=\"col-left\"]/div/div/h2")
    WebElement AddNewCategoryHeader;

    @FindBy(xpath="//*[@id=\"tag-name\"]")
    WebElement CategoryNameField;

    @FindBy(xpath="//*[@id=\"submit\"]")
    WebElement AddNewCategoryBtn;

    @FindBy(xpath="//*[@class='row-title' and text()='Test Category']")
    WebElement TestCategoryTitle;

    @FindBy(xpath="//*[@class='row-title' and text()='Test Category']/parent::strong/parent::td/parent::tr/th/input")
    WebElement NewCategoryCheckBox;

    @FindBy(xpath="//*[@id=\"bulk-action-selector-top\"]")
    WebElement CategoryBulkAction;

    @FindBy(xpath="//*[@id=\"doaction\"]")
    WebElement CategoryApplyBtn;

    @FindBy(xpath="//*[@id=\"tag-name\"]")
    WebElement AddNewTagField;

    @FindBy(xpath="//*[@id=\"submit\"]")
    WebElement AddNewTagBtn;

    @FindBy(xpath = "//a[text()='Test Tag']")
    WebElement NewTagField;

    @FindBy(xpath = "//a[text()='Test Tag']/parent::strong/parent::td/preceding-sibling::th/input")
    WebElement NewTagCHeckBox;

    @FindBy(xpath="//*[@id=\"bulk-action-selector-top\"]")
    WebElement TagBulkAction;

    @FindBy(xpath="//*[@id=\"doaction\"]")
    WebElement TagApplyBtn;




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



    public boolean AddNewPost() throws Exception{

        HEY(AddNewBtn);
        AddNewBtn.click();
        WFEC(By.xpath("//*[text()='Enter title here']"));

        HEY(NewPostTitle);
        Actions performAct = new Actions(driver);
        performAct.sendKeys(NewPostTitle, "TestTitle").build().perform();


        HEY(PublisgBtn1);
        PublisgBtn1.click();
        sleep(5000);
        HEY(AllPostsTab);
        AllPostsTab.click();
        WFEV(By.xpath("//*[contains(text(),'TestTitle')]"));
        HEY(NewPostField);
        return NewPostField.isDisplayed();
    }


    public boolean NewPostSelection() throws Exception{

        HEY(NewPostCheckBox);
        NewPostCheckBox.click();
        return NewPostCheckBox.isSelected();


    }

    public boolean DeleteNewPost() throws Exception{

        HEY(bulk_action_selector_top);
        Select dropdown= new Select(bulk_action_selector_top);
        dropdown.selectByVisibleText("Move to Bin");

        HEY(ApplyBtn);
        ApplyBtn.click();

        sleep(1000);


        try {
            driver.findElement(By.xpath("//*[contains(text(),'TestTitle')]"));
            return false;

        } catch (NoSuchElementException e) {
            return true;
        }
    }


    public boolean verifyCategoriesHeader() throws Exception{

        HEY(CategoriesTab);
        CategoriesTab.click();
        HEY(AddNewCategoryHeader);
        return AddNewCategoryHeader.isDisplayed();

    }


    public boolean verifyCategoryNameField() throws Exception{

        HEY(CategoryNameField);
        return CategoryNameField.isDisplayed();
    }


    public boolean AddNewCategory() throws Exception{

        CategoryNameField.sendKeys("Test Category");
        HEY(AddNewCategoryBtn);
        AddNewCategoryBtn.click();
        HEY(TestCategoryTitle);
        return TestCategoryTitle.isDisplayed();
    }


    public boolean DeleteNewCategory() throws Exception{

        HEY(NewCategoryCheckBox);
        NewCategoryCheckBox.click();

        HEY(CategoryBulkAction);
        Select dropdown= new Select(CategoryBulkAction);
        dropdown.selectByVisibleText("Delete");
        HEY(CategoryApplyBtn);
        CategoryApplyBtn.click();
        sleep(1000);

        try {
            driver.findElement(By.xpath("//*[@class='row-title' and text()='Test Category']"));
            return false;

        } catch (NoSuchElementException e) {
            return true;
        }

    }


    public boolean verifyNewTagField() throws Exception{
        HEY(TagsTab);
        TagsTab.click();
        WFEV(By.xpath("//*[@id=\"tag-name\"]"));
        HEY(AddNewTagField);
        return AddNewTagField.isDisplayed();

    }


    public boolean AddNewTag() throws Exception{

        AddNewTagField.sendKeys("Test Tag");
        HEY(AddNewTagBtn);
        AddNewTagBtn.click();
        WFEV(By.xpath("//a[text()='Test Tag']"));
        HEY(NewTagField);
        return NewTagField.isDisplayed();
    }


    public boolean DeleteNewTag() throws Exception{

        HEY(NewTagCHeckBox);
        NewTagCHeckBox.click();

        HEY(TagBulkAction);
        Select dropdown= new Select(TagBulkAction);
        dropdown.selectByVisibleText("Delete");
        HEY(TagApplyBtn);
        TagApplyBtn.click();

        try {
            driver.findElement(By.xpath("//a[text()='Test Tag']"));
            return false;

        } catch (NoSuchElementException e) {
            return true;
        }


    }




}
