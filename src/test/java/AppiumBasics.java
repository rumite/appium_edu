import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest{

    @Test
    public void wifiSettingsName() {
        driver.findElement(AppiumBy.accessibilityId("Preference"))
                .click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"))
                .click();
        driver.findElement(AppiumBy.id("android:id/checkbox"))
                .click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]"))
                .click();

        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(AppiumBy.id("android:id/edit"))
                .sendKeys("Dai10Tetri");
        driver.findElement(AppiumBy.id("android:id/button1"))
                .click();
    }

    @Test
    public void longPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views"))
                .click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists"))
                .click();

        WebElement customAdapterBtn = driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"));
        customAdapterBtn.click();
        WebElement peopleNamesBtn = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(peopleNamesBtn);
        WebElement sampleMenuText = driver.findElement(AppiumBy.id("android:id/title"));

        Assert.assertTrue(sampleMenuText.isDisplayed());

    }

    @Test
    public void scrollTest() {
        driver.findElement(AppiumBy.accessibilityId("Views"))
                .click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }

    @Test
    public void swipeTest() {
        driver.findElement(AppiumBy.accessibilityId("Views"))
                .click();
        driver.findElement(AppiumBy.accessibilityId("Gallery"))
                .click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos"))
                .click();
        WebElement firstImage = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]"));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");

        //Swipe
        swipeAction(firstImage, "left");
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "false");
    }

    @Test
    public void dragAndDropTest() {
        driver.findElement(AppiumBy.accessibilityId("Views"))
                .click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop"))
                .click();
        WebElement dragElement = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //Drag'n'Drop
        dragDropAction(dragElement, 628, 560);

        String droppedText = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(droppedText, "Dropped!");
    }
}
