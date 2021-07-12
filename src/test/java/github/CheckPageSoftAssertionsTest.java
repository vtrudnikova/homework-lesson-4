package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CheckPageSoftAssertionsTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com";
        Configuration.startMaximized = true;
    }

    @Test
    void findSoftAssertionsPage() {
        openPage();
        clickWikiPage();
        checkPageSoftAssertions();
        checkExampleJUnit5();
    }

    void openPage() {
        open("/selenide/selenide");
    }

    void clickWikiPage() {
        $(".js-repo-nav").$(byText("Wiki")).click();
    }

    void checkPageSoftAssertions() {
        $("#wiki-pages-box ul").$(".js-wiki-more-pages-link").click();
        $(byText("SoftAssertions")).shouldBe(visible).click();
    }

    void checkExampleJUnit5() {
        $("#wiki-content").$(byText("Using JUnit5 extend test class:")).shouldHave(text("Using JUnit5 extend test class:"));
    }

}
