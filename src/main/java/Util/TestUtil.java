package Util;

import Base.TestBase;

public class TestUtil extends TestBase {

    public void switchtoframe(String frameName){
        driver.switchTo().frame(frameName);
    }

    public void switchbackframe(){

        driver.switchTo().defaultContent();
    }

}
