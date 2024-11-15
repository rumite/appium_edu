import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class ActionsDemo extends BaseTest {
    @Test
    @Ignore
    public void orientationDemo() throws InterruptedException {
        DeviceRotation deviceRotation = new DeviceRotation(0, 0, 0);
        driver.rotate(deviceRotation);
        Thread.sleep(3000);
    }

    @Test
    public void copyPasteDemo() throws  InterruptedException{
        clickElementByAccessibilityId("Preference");
        clickElementByXpath("//android.widget.TextView[@content-desc='3. Preference dependencies']");
        clickElementById("android:id/checkbox");
        clickElementByXpath("(//android.widget.RelativeLayout)[2]");
        driver.setClipboardText("Dai10Tetri");
        sendKeysById("android:id/edit", driver.getClipboardText());
        Thread.sleep(3000);
    }

    @Test
    public void pressHomeBtn() throws InterruptedException{
        clickElementByAccessibilityId("Preference");
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(1000);
    }
}
