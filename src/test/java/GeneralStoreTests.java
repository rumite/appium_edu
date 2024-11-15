import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class GeneralStoreTests extends BaseTest {


    @Test
    public void fillForm() {
        clickElementById("com.androidsample.generalstore:id/spinnerCountry");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        sendKeysById("com.androidsample.generalstore:id/nameField", "Timur");
        driver.hideKeyboard();
        clickElementById("com.androidsample.generalstore:id/radioFemale");

    }
}
