import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        WebDriverManager.chromedriver().browserVersion("85.0.4183.83").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");

        this.driver = new ChromeDriver(options);
    }
}
