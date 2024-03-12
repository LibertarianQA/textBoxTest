package demoqa;



import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectFakersData extends TestBase {


    @Test
    void fillPracticeForm() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userPhone = faker.phoneNumber().subscriberNumber(10);
        String currentAddress = faker.address().fullAddress();
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
        registrationPage.setGender();
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
