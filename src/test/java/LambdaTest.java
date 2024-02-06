import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 84;


    @Test
    public void repositoryLambdaIssueCheckTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Открываем репозиторий " +REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issue ", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue " + ISSUE, () -> {
            $(withText("#"+ ISSUE)).should(Condition.exist);
        });

    }

}