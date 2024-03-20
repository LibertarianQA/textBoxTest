package demoqa;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;

public class EmptyPracticForm extends TestBase {
    @Tag("simple")

    @Test
    void fillPracticeForm() {



        step("open page", () -> {
            registrationPage.openPage();
        });

        step("submit", () -> {

            registrationPage.submit();
        });

        step("expected: be visible", () -> {
            registrationPage.verifyResultsModalAppers();

        });


    }
}
