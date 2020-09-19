
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SeleniumListLoadTest {
    private static final Logger logger = LogManager.getLogger(SeleniumListLoadTest.class);
    DriverManager driverManager;
    WebDriver driver;
    TaskListPage taskListPage;

    @BeforeClass
    public void setupClass() {
        driver = null;
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        String URL = "http://s3.amazonaws.com/istreet-assets/bHFRMn4JHQnwP7QcqCer7w/fortinet-qa-testsite.html";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        taskListPage = new TaskListPage(driver);
    }


    @Ignore
    @Test
    public void ListLoadTest() {
        taskListPage.getFortinetLink();
        taskListPage.getTitle();
        taskListPage.getTaskNameTextLabel();
        taskListPage.getCompleteCheckbox();
        taskListPage.getDeadLineSelectionField();
        taskListPage.getAddItemButton();
    }

    @Test
    public void ListLoadTest2() {
        try {
            taskListPage.creatTask("Expired", "01/01/2013", false);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Thread interrupted", e);
            }
            taskListPage.creatTask("Completed", "01/01/2013", true);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Thread interrupted", e);
            }
            taskListPage.creatTask("Pending", "01/01/2021", false);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Thread interrupted", e);
            }
            taskListPage.creatTask("Completed", "01/01/2021", true);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Thread interrupted", e);
            }
            //Check task created with correct Name, Name, DueDate and  is greydout or not.
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.stalenessOf(taskListPage.getCreatedTaskNumber(1).findElement(By.tagName("h3"))));
            Assert.assertTrue(taskListPage.checkCreatedTask(1, "Expired", "expired", "01/01/2013", false));
            Assert.assertTrue(taskListPage.checkCreatedTask(2, "Completed", "complete", "01/01/2013", false));
            Assert.assertTrue(taskListPage.checkCreatedTask(3, "Pending", "pending", "01/01/2021", true));
            Assert.assertTrue(taskListPage.checkCreatedTask(4, "Completed", "complete", "01/01/2021", false));

            taskListPage.getTaskButton(3).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.textToBePresentInElement(taskListPage.getTaskButton(1), "completed"));
            Assert.assertFalse(taskListPage.getTaskButton(1).isEnabled());
        } catch (WebDriverException e) {

            System.out.println("org.openqa.selenium.WebDriverException: browser not reachable");
        }
    }


    @AfterClass(enabled = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
