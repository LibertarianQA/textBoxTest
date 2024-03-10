package demoqa;




import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
@BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//     Configuration.holdBrowserOpen = true;
//    Configuration.timeout = 10000;

    }
    @Test
    void fillFormTest(){

        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        //  $(".main-header").shouldHave(text("Text Box"));
        $(".text-center").shouldHave(text("Text Box"));

        $("#userName").setValue("Mykola McKlay");
        $("#userEmail").setValue("123@gmail.com");
        $("#currentAddress").setValue("dido main str");
        $("#permanentAddress").setValue("tot ze");

        $("#submit").click();

        $("#output").shouldBe(visible);
    }
}
