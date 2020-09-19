import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TaskListPage {
    WebDriver driver;

    public TaskListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By fortinetLink = By.linkText("Fortinet");
    private By taskNameLabel = By.xpath("//label[contains(text(),'Task Name')]");
    private By taskNameTextField = By.xpath("//input[@name='name']");
    private By deadLineSelectionField = By.xpath("//input[@name='deadline']");
    private By deadLineLabel = By.xpath("//label[contains(text(),'Deadline')]");
    private By completeCheckLabel = By.xpath("//label[contains(text(),'Complete')]");
    private By completeCheckBox = By.xpath("//input[@name='complete']");
    private By addItemButton = By.id("add-item");
    private String taskAbsolutPass = "/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[";

    public String getTitle() {
        return driver.getTitle();
    }


    public WebElement getWebElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(locator + " element was not found", e);
        }
    }

    public WebElement getFortinetLink() {
        return getWebElement(fortinetLink);
    }

    public WebElement getTaskNameTextLabel() {
        return getWebElement(taskNameLabel);
    }

    public WebElement getTaskNameTextField() {
        return getWebElement(taskNameTextField);
    }

    public WebElement getDeadLineLabel() {
        return getWebElement(deadLineLabel);
    }

    public WebElement getDeadLineSelectionField() {
        return getWebElement(deadLineSelectionField);
    }

    public WebElement getCompleteCheckbox() {
        return getWebElement(completeCheckBox);
    }

    public WebElement getAddItemButton() {
        return getWebElement(addItemButton);
    }


    public void fillInTaskName(String taskName) {
        getTaskNameTextField().clear();
        getTaskNameTextField().sendKeys(taskName);
    }

    public void fillInDeadline(String date) {
        getDeadLineSelectionField().clear();
        getDeadLineSelectionField().sendKeys(date);
    }

    public void creatTask(String taskName, String date, boolean complete) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        fillInTaskName(taskName);
        fillInDeadline(date);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeToBe(deadLineSelectionField, "value", date));
        if (complete) {
            wait.until(ExpectedConditions.elementToBeClickable(getCompleteCheckbox()));

            js.executeScript("arguments[0].click();", getCompleteCheckbox());
            wait.until(ExpectedConditions.elementSelectionStateToBe(getCompleteCheckbox(), true));
        } else {
            if (getCompleteCheckbox().isSelected()) {
                js.executeScript("arguments[0].click();", getCompleteCheckbox());
            }
        }
        getAddItemButton().click();
    }

    public WebElement getCreatedTaskNumber(int number) {
        WebElement task = driver.findElement(By.xpath(taskAbsolutPass + number + "]" ));
        return task;
    }

    public boolean checkCreatedTask(int number, String createdName, String createdStatus, String date,  boolean isAnabled){
        boolean passed = true;
        WebElement nameOfWebElement = getCreatedTaskNumber(number).findElement(By.tagName("h3"));
        String Name = nameOfWebElement.getText();
        String actualDate = getCreatedTaskNumber(number).findElement(By.tagName("p")).getText().substring(8);
        String getStatus = getCreatedTaskNumber(number).findElement(By.tagName("button")).getText();
        boolean isGraydOut = nameOfWebElement.isEnabled();
        if(isGraydOut != isAnabled){
            passed = false;
            System.out.println("Is graydout: " + isGraydOut);
        }
        if(!Name.equals(createdName)){
            passed = false;
            System.out.println("Created name is wrong: " + Name);
        }
        if(!date.equals(actualDate)){
            passed = false;
            System.out.println("Date name is wrong: " + actualDate);
        }
        if(!createdStatus.equals(getStatus)){
            passed = false;
            System.out.println("Created status is wrong: " + getStatus);
        }

        return passed;
    }

    public WebElement getTaskButton(int taskNumber){
        WebElement button = getCreatedTaskNumber(taskNumber).findElement(By.tagName("button"));
        return button;
    }
    public List<WebElement> getAllCreatedTasks() {
        return driver.findElements(By.xpath("//ul/li"));
    }


}
