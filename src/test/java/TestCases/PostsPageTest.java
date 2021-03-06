package TestCases;

import Base.TestBase;
import Pages.LoginPage;
import Pages.PostsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PostsPageTest extends TestBase {


    PostsPage postspage;
    LoginPage loginpage;

    public PostsPageTest(){
        super();
    }


    @BeforeMethod
    public void setup(){
        postspage = new PostsPage();
        loginpage = new LoginPage();
    }


    @Test(priority = 1)
    public void login() throws Exception{

        loginpage.DoLogin(prop.getProperty("username"), prop.getProperty("password"));

    }


    @Test(priority = 2)
    public void AllPostsTabTest() throws Exception{
        Assert.assertTrue(postspage.verifyAllPostsTab());
    }


    @Test(priority = 3)
    public void AddNewTabTest() throws Exception{
        Assert.assertTrue(postspage.verifyAddNewTab());
    }


    @Test(priority = 4)
    public void CategoriesTabTest() throws Exception{
        Assert.assertTrue(postspage.verifyCategoriesTab());
    }


    @Test(priority = 5)
    public void TagsTabTest() throws Exception{
        Assert.assertTrue(postspage.verifyTagsTab());
    }


    @Test(priority = 6)
    public void AddNewBtnTest() throws Exception{
        Assert.assertTrue(postspage.verifyAddNewBtn());
    }

    @Test(priority = 7)
    public void SearchFieldTest() throws Exception{
        Assert.assertTrue(postspage.verifySearchField());
    }

    @Test(priority = 8)
    public void SearchBtnTest() throws Exception{
        Assert.assertTrue(postspage.verifySearchBtn());
    }

    @Test(priority = 9)
    public void BulkActionsBtnTest() throws Exception{
        Assert.assertTrue(postspage.verifyBulkActionsBtn());
    }


    @Test(priority = 10)
    public void ApplyBtnTest() throws Exception {
        Assert.assertTrue(postspage.verifyApplyBtn());
    }


    @Test(priority = 11)
    public void AllDatesBtnTest() throws Exception{
        Assert.assertTrue(postspage.verifyAllDatesBtn());
    }


    @Test(priority = 12)
    public void AllCategoriesBtnTest() throws Exception{
        Assert.assertTrue(postspage.verifyAllCategoriesBtn());
    }


    @Test(priority = 13)
    public void FilterBtnTest() throws Exception{
        Assert.assertTrue(postspage.verifyFilterBtn());
    }

    @Test(priority = 14)
    public void AddNewPostTest() throws Exception{
        Assert.assertTrue(postspage.AddNewPost());
    }


    @Test(priority = 15)
    public void NewPostSelectionTest() throws Exception{
        Assert.assertTrue(postspage.NewPostSelection());
    }


    @Test(priority = 16)
    public void DeleteNewPost() throws Exception{

        Assert.assertTrue(postspage.DeleteNewPost());
    }

    @Test(priority = 17)
    public void CategoriesHeaderTest() throws Exception{

        Assert.assertTrue(postspage.verifyCategoriesHeader());
    }


    @Test(priority = 18)
    public void CategoryNameFieldTest() throws Exception{

        Assert.assertTrue(postspage.verifyCategoryNameField());
    }


    @Test(priority = 19)
    public void AddNewCategoryTest() throws Exception{

        Assert.assertTrue(postspage.AddNewCategory());
    }


    @Test(priority = 20)
    public void DeleteNewCategoryTest() throws Exception{

        Assert.assertTrue(postspage.DeleteNewCategory());
    }


    @Test(priority = 21)
    public void NewTagFieldTest() throws Exception{

        Assert.assertTrue(postspage.verifyNewTagField());
    }


    @Test(priority = 22 )
    public void AddNewTagTest() throws Exception{
        Assert.assertTrue(postspage.AddNewTag());
    }


    @Test(priority = 23)
    public void DeleteNewTagTest() throws Exception{

        Assert.assertTrue(postspage.DeleteNewTag());
    }





























}
