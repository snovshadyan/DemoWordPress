package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();
    public static String baseURL = "http://demosite.center/wordpress/wp-login.php";


    public static String hubURL = "http://192.168.2.247:4444/wd/hub/";
    static String ChromeDriverPath = ".\\Resources\\WebDrivers\\chromedriver.exe";
    static String IEDriverPath = ".\\Resources\\WebDrivers\\IEDriverServer.exe";
    static String FFDriverPath = ".\\Resources\\WebDrivers\\geckodriver.exe";

    public static String Browser;
    public static Boolean Remote = false ;
    public static String PJ ;
    public static String CT,ST, FT, ET ;
    public static Properties prop;


    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/Config/config.properties");
            prop.load(ip);
        }	catch (FileNotFoundException e ) {
            e.printStackTrace();
        }  catch (IOException e){
            e.printStackTrace();
        }

    }

    private void setDriver(String browserType) throws Exception{

        if(browserType.equalsIgnoreCase("Chrome")) {
            Browser = "Chrome";
            driver = initChromeDriver();
        }else if (browserType.equalsIgnoreCase("Firefox")){
            Browser = "Firefox";
            driver = initFirefoxDriver();
        }
        System.out.println("Browser is " + Browser);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(baseURL);
        Thread.sleep(1000);

    }



    private static WebDriver initChromeDriver() throws Exception {
        System.out.println("Launching " + Browser + " browser..");
        System.setProperty("webdriver.chrome.driver", ChromeDriverPath );
        driver = new ChromeDriver();
        return driver;
    }

    private static WebDriver initFirefoxDriver() throws Exception{

        System.out.println("Launching " + Browser + " browser..");
        System.setProperty("webdriver.gecko.driver", FFDriverPath);
        driver = new FirefoxDriver();
        return driver;
    }




    protected static WebDriver getDriver() {
        return driver;
    }

    @Parameters({"browserType"})
    @BeforeClass
    public void initializeTestBaseSetup(@Optional("Chrome") String browserType) {

        try {
            setDriver(browserType);
        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
        CT = Calendar.getInstance().getTime().toString();

        System.out.println("Starting CRM test " + CT + "\n");
    }





    @AfterClass
    public void tearDown() {
        driver.quit();
    }








    public void sleep(int Mils) throws Exception {
        Thread.sleep(Mils);
    }




    public  void WFEV(By by) throws Exception {

        sleep(100);
        HEY(driver.findElement(by));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }


    public  void WFENV(By by) throws Exception {

        sleep(100);
        HEY(driver.findElement(by));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }




    public  void WFEC(By by) throws Exception {

        sleep(100);
        HEY(driver.findElement(by));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }



    public void HEY(WebElement element) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px groove red'", element);
        js.executeScript("arguments[0].style.backgroundColor='#FFFF00'", element);
        sleep(50);
        js.executeScript("arguments[0].style.border=''", element);
        js.executeScript("arguments[0].style.backgroundColor=''", element);
    }


    public void HEG(WebElement element) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px groove red'", element);
        js.executeScript("arguments[0].style.backgroundColor='#00FF00'", element);
        sleep(50);
        js.executeScript("arguments[0].style.border=''", element);
        js.executeScript("arguments[0].style.backgroundColor=''", element);
    }


    public void HoverOver(WebElement element) throws Exception {
        Actions builder = new Actions(driver);
        Actions hoverOverRegistrar = builder.moveToElement(element);
        hoverOverRegistrar.perform();
        HEY(element);

    }


    public void MoveTo(By by) throws Exception {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void Move2Top() throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
    }

    public boolean isElementPresent(By by) throws Exception {
        try {
            driver.findElement(by);
            sleep(100);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }





}
