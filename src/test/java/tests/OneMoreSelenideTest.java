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
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions"))
                .shouldBe(visible);

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions"))
                .click();

        $("#wiki-body").shouldHave(text("""
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
                @Test
                void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                }
            }""")).shouldBe(visible);
    }
}
