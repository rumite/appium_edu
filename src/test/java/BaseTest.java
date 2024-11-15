import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws URISyntaxException, MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//Users//timur//.npm-global//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();


        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("AndroidEmu");
        //options.setApp("//Users//timur//Documents//projects//appium//src//test//java//resources//ApiDemos-debug.apk");
        options.setApp("//Users//timur//Documents//projects//appium//src//test//java//resources//General-Store.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //Actions

    public void longPressAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

    public void swipeAction(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.1
        ));
    }

    public void dragDropAction(WebElement element, int endX, int endY) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }

    public void startActivity(String intent) {
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", intent
        ));
    }


    // Click methods

    public void clickElementByAccessibilityId(String accessibilityId) {
        driver.findElement(AppiumBy.accessibilityId(accessibilityId)).click();
    }

    public void clickElementById(String id) {
        driver.findElement(AppiumBy.id(id)).click();
    }

    public void clickElementByXpath(String xpath) {
        driver.findElement(AppiumBy.xpath(xpath))
                .click();
    }

    // Send Keys methods

    public void sendKeysById(String id, String keys) {
        driver.findElement(AppiumBy.id(id))
                .sendKeys(keys);
    }

    //Assertions

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
