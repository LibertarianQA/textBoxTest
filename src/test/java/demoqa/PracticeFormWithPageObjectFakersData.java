package demoqa;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.TestDataGenerator;

import static io.qameta.allure.Allure.step;

public class PracticeFormWithPageObjectFakersData extends TestBase {

    @Tag("simple")
    @Test
    void fillPracticeForm() {
        String firstName = TestDataGenerator.generateFirstName();
        String lastName = TestDataGenerator.lastName();
        String userEmail = TestDataGenerator.userEmail();
        String userGander = TestDataGenerator.userGander();
        String userPhone = TestDataGenerator.userPhone();
        String currentAddress = TestDataGenerator.currentAddress();
        String dayBirthDate = TestDataGenerator.dayBirthDate();
        String monthBirthDate = TestDataGenerator.monthBirthDate();
        String yearBirthDate = TestDataGenerator.yearBirthDate();
        String subjectsInput = TestDataGenerator.subjectsInput();
        String hobbiesWrapper = TestDataGenerator.hobbiesWrapper();
        String uploadFileFromClasspath = "img/1.png";
        String state = "NCR";
        String city = "Delhi";

        step("open page", () -> {
            registrationPage.openPage();
        });

        step("set form", () -> {
            registrationPage.setFirstName(firstName);
            registrationPage.setLastName(lastName);
            registrationPage.setEmail(userEmail);
            registrationPage.setGender(userGander);
            registrationPage.setPhone(userPhone);
            registrationPage.setBirthDate(dayBirthDate, monthBirthDate, yearBirthDate);
            registrationPage.setSubjectsInput(subjectsInput);
            registrationPage.setHobbiesWrapper(hobbiesWrapper);
            registrationPage.setCurrentAddress(currentAddress);
            registrationPage.setUploadPicture(uploadFileFromClasspath);
            registrationPage.setStateCity(state, city);
            registrationPage.submit();
        });


        step("verify results", () -> {
            registrationPage.verifyResultsModalAppers();
            registrationPage.verifyResults("Student Name", firstName + " " + lastName);
            registrationPage.verifyResults("Student Email", userEmail);
            registrationPage.verifyResults("Gender", userGander);
            registrationPage.verifyResults("Mobile", userPhone);
            registrationPage.verifyResults("Date of Birth", dayBirthDate + " " + monthBirthDate + "," + yearBirthDate);
        });


    }
}
