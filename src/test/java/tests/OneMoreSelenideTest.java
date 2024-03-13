package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OneMoreSelenideTest {

    @Test
    void softAssertionsShouldHaveJUnit5() {

        // Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".markdown-body").$$("li").get(8).shouldHave(text("Soft assertions"));
        $("a[href$=\"SoftAssertions\"]").shouldHave(text("Soft assertions"));

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").
                parent().shouldHave(text("3. Using JUnit5 extend test class:"));

    }
}
