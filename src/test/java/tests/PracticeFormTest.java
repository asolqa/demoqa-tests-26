package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        //Name, email, gender, number
        $("#firstName").setValue("Vlad");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("vlad@petrov.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9876543210");

        //Date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byText("2000")).click();
        $(".react-datepicker__month-select").click();
        $(byText("June")).click();
        $(".react-datepicker__day", 4).click();

        //Subjects
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();

        //Hobbies
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        //File
        $("#uploadPicture").uploadFromClasspath("avatar.png");

        //Address
        $("#currentAddress").setValue("Some street");

        //State
        $("#state").click();
        $(byText("Haryana")).click();

        //City
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        //Assertions
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$("tr").get(1).shouldHave(text("Vlad Petrov"));
        $$("tr").get(2).shouldHave(text("vlad@petrov.com"));
        $$("tr").get(3).shouldHave(text("Male"));
        $$("tr").get(4).shouldHave(text("9876543210"));
        $$("tr").get(5).shouldHave(text("01 June,2000"));
        $$("tr").get(6).shouldHave(text("Maths, History"));
        $$("tr").get(7).shouldHave(text("Sports, Reading, Music"));
        $$("tr").get(8).shouldHave(text("avatar.png"));
        $$("tr").get(9).shouldHave(text("Some street"));
        $$("tr").get(10).shouldHave(text("Haryana Karnal"));
        $("#closeLargeModal").shouldHave(text("Close"));

        $("#closeLargeModal").click();
    }
}
