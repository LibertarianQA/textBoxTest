package demoqa.practiceForme.negative;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.components.TestBase;
import pages.components.TestDataGenerator;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("positivePF"),@Tag("simple")})

public class EmptyDayBirthDate extends TestBase {


    @Test
    void fillPracticeForm() {
        String firstName = TestDataGenerator.generateFirstName();
        String lastName = TestDataGenerator.lastName();
        String userEmail = TestDataGenerator.userEmail();
        String userGander = TestDataGenerator.userGander();
        String userPhone = TestDataGenerator.userPhone();
        String currentAddress = TestDataGenerator.currentAddress();

        String subjectsInput = TestDataGenerator.subjectsInput();
        String hobbiesWrapper = TestDataGenerator.hobbiesWrapper();
        String uploadFileFromClasspath = TestDataGenerator.uploadFileFromClasspath();
        String state = TestDataGenerator.state();
        String city = TestDataGenerator.setRandomCity(state);

        step("open page", () -> {
            registrationPage.openPage();
        });

        step("set form", () -> {
            registrationPage.setFirstName(firstName);
            registrationPage.setLastName(lastName);
            registrationPage.setEmail(userEmail);
            registrationPage.setGender(userGander);
            registrationPage.setPhone(userPhone);

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
         
            registrationPage.verifyResults("Subjects",subjectsInput);
            registrationPage.verifyResults("Hobbies",hobbiesWrapper);
            registrationPage.verifyResults("Picture",uploadFileFromClasspath.substring(uploadFileFromClasspath.lastIndexOf("/") + 1));
            registrationPage.verifyResults("Address",currentAddress);
            registrationPage.verifyResults("State and City",state+" "+city);
        });


    }
}
