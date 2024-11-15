import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ActivityOpen extends BaseTest {

    @Test
    public void activityTest() throws InterruptedException {
        startActivity("io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies");
        Thread.sleep(3000);
    }
}
