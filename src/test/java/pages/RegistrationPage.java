package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationComponentsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationComponentsModal registrationComponentsModal = new RegistrationComponentsModal();
    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userGender = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            uploadPicture = $("#uploadPicture"),
            stateLocator = $("#state"),
            cityLocator = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    public void openPage() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setEmail(String value) {
        emailInput.setValue(value);
    }

    public void setGender(String value) {
        userGender.$(byText(value)).click();
    }

    public void setPhone(String value) {
        phoneInput.setValue(value);
    }

    public void setBirthDate(String day, String month, String year) {
        $(dateOfBirthInput).click();
        calendarComponent.setDate(day, month, year);
    }

    public void verifyResultsModalAppers() {
        registrationComponentsModal.verifyModalAppers();
    }

    public void verifyResults(String key, String value) {
        registrationComponentsModal.verifyResalt(key, value);
    }

    public void setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
    }

    public void setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
    }

    public void setCurrentAddress(String value) {
        currentAddress.setValue(value);
    }

    public void setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
    }

    public void setStateCity(String state, String city) {
        stateLocator.click();
        stateCityWrapper.$(byText(state)).click();
        cityLocator.click();
        stateCityWrapper.$(byText(city)).click();
    }

    public void submit() {
        submit.click();
    }
}
