package demoqa;



import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectFakersData extends TestBase {


    @Test
    void fillPracticeForm() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userGander = faker.options().option("Male","Female","Other");
        String userPhone = faker.phoneNumber().subscriberNumber(10);
        String currentAddress = faker.address().fullAddress();
        String dayBirthDate =  String.format("%02d", faker.number().numberBetween(1, 28));
        String monthBirthDate =faker.options().option( "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String yearBirthDate = String.valueOf( faker.number().numberBetween(1950,2020));
        String subjectsInput = faker.options().option("Economics","English", "Arts", "History", "Hindi");
        String hobbiesWrapper = faker.options().option("Sports", "Reading", "Music");
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
        registrationPage.verifyResults("Gender", userGander);
        registrationPage.verifyResults("Mobile", userPhone);
        registrationPage.verifyResults("Date of Birth", dayBirthDate+" "+monthBirthDate+","+yearBirthDate);


    }
}
