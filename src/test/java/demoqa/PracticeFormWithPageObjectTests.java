package demoqa;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectTests extends TestBase{


@Test
void fillPracticeForm(){
        String firstName = "Mykola";
        String lastName = "McKlay";
        String userEmail = "123@gmail.com";
        String userPhone = "0123456789";
        String currentAddress = "na derevnu dedushke";

        new RegistrationPage().openPage();
        new RegistrationPage().setFirstName(firstName);
        new RegistrationPage().setLastName(lastName);
        new RegistrationPage().setEmail(userEmail);
        new RegistrationPage().setGender();
        new RegistrationPage().setPhone(userPhone);
        new RegistrationPage().setBirthDate("15","June","2005");







        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue(currentAddress);
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName),text(userEmail ) );


}
}
