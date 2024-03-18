package demoqa;




import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
@BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//    Configuration.holdBrowserOpen = true;
//    Configuration.timeout = 10000;

    }
    @Tag("simple")
    @Test
    void fillFormTest(){

    String userName = "Mykola McKlay";
    String userEmail = "123@gmail.com";
    String currentAddress = "dido main str";
    String permanentAddress = "tot ze chto i byl";
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        //  $(".main-header").shouldHave(text("Text Box"));
        $(".text-center").shouldHave(text("Text Box"));
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}
