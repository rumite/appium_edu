import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentTests extends BaseTest {

    @Test
    public void DialogOkTest() {
        clickElementByAccessibilityId("App");
        clickElementByAccessibilityId("Alert Dialogs");
        clickElementByAccessibilityId("OK Cancel dialog with a message");

        driver.findElement(By.id("android:id/button1")).isDisplayed();
    }
}
