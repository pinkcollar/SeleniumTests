import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createWebDriver();

    public void quitWebDriver(){
        if(null != driver){
            driver.quit();
            driver =  null;
        }
    }

    public WebDriver getWebDriver(){
        if(driver == null){
            createWebDriver();
        }
        return driver;
    }


}
