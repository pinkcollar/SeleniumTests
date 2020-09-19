import org.openqa.selenium.firefox.FirefoxBinary;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager = null;
        switch(type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;

        }
        return driverManager;
    }
}
