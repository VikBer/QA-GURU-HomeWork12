import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo) {

        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Открываем репозиторий {repo}")
    public void openRepository(String repo) {

        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issue")
    public void openIssueTab() {

        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue {issue}")
    public void shouldSeeIssueWithNumber(int issue) {

        $(withText("#" + issue)).should(Condition.exist);

    }
}