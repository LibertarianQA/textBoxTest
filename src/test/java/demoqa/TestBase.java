package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import java.util.ArrayList;
import java.util.HashMap;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("BROWSER_SIZE","1920x1080");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote =System.getProperty("REMOTE_URL");
      //  Configuration.holdBrowserOpen = true;
        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability("browserVersion", "122.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
            /* Добавляем опцию для включения VNC */
            put("enableVNC", true);
        }});

        Configuration.browserCapabilities = options;
    }
@BeforeEach
    void addListener(){
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
}

@AfterEach

void addAttachment(){
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
}

}