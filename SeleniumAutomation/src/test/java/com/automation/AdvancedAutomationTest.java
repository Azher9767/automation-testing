package com.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Set;
import com.automation.utils.ChromeDriverUtil;

public class AdvancedAutomationTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = ChromeDriverUtil.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void runAdvancedAutomation() throws InterruptedException {

        // ==================================================
        // 1️⃣ DROPDOWN
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        System.out.println("Dropdown selected");

        // ==================================================
        // 2️⃣ CHECKBOX
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        System.out.println("Checkbox selected");

        // ==================================================
        // 3️⃣ RADIO BUTTON
        // ==================================================
        // driver.get("https://demoqa.com/radio-button");

        // WebElement yesRadio =
        //         driver.findElement(By.cssSelector("label[for='yesRadio']"));

        // wait.until(ExpectedConditions.elementToBeClickable(yesRadio));
        // yesRadio.click();

        // System.out.println("Radio button selected: Yes");

        // ==================================================
        // 4️⃣ ALERT HANDLING
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alertButton.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

        // ==================================================
        // 5️⃣ MULTIPLE WINDOWS / TABS
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
            }
        }
        System.out.println("New window title: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(parentWindow);

        // ==================================================
        // 6️⃣ EXPLICIT WAIT (DYNAMIC LOADING)
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();
        WebElement finishText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        System.out.println("Explicit wait text: " + finishText.getText());

        System.out.println("AdvancedAutomation TestNG completed successfully");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
