package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindSolutionsEnterpriseTest {

    @Test
    void moveToEnterprisePage() {
        open("https://github.com/");
        // На главной странице GitHub выберите меню Solutions -> Enterprise с помощью команды hover для Solutions
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $("[aria-labelledby=\"solutions-for-heading\"]").$(byText("Enterprise")).click();

        // Убедитесь что загрузилась нужная страница
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}
