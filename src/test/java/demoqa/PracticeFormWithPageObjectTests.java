package demoqa;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
public class PracticeFormWithPageObjectTests extends TestBase {
@Disabled  ("old version")

    @Test
    void fillPracticeForm() {
        String firstName = "Mykola";
        String lastName = "McKlay";
        String userEmail = "123@gmail.com";
        String userGander = "Male";
        String userPhone = "0123456789";
        String currentAddress = "na derevnu dedushke";
        String dayBirthDate = "15";
        String monthBirthDate = "June";
        String yearBirthDate = "2005";
        String subjectsInput = "Economics";
        String hobbiesWrapper = "Sports";
        String uploadFileFromClasspath = "img/1.png";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage();
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


        registrationPage.verifyResultsModalAppers();
        registrationPage.verifyResults("Student Name", firstName + " " + lastName);
        registrationPage.verifyResults("Student Email", userEmail);
        registrationPage.verifyResults("Gender", "Male");
        registrationPage.verifyResults("Mobile", userPhone);
        registrationPage.verifyResults("Date of Birth", "15 June,2005");


    }
}
