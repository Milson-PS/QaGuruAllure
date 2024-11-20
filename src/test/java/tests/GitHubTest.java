package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GitHubPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

    @Feature("Проверка Issue")
    @Story("Issue")
    @Owner("milyukov")
    @Link(value = "Testing", url = "https://github.com/")


            public class GitHubTest extends BaseTest{
    private final String repository = "eroshenkoam/allure-example";
    private final String issueName = "One piece";

    @Test
    @DisplayName("Тест Selenide с Listener")
    void pureGitHubIssueTest() {
        open("/");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("One piece")).should(Condition.exist);
    }

        @Test
        @DisplayName("Лямбда шаги через step")
        void stepLambdaTest() {
            step("Открытие главной страницы", GitHubPage::openPage);
            step("Поиск репозитория " + repository, () -> GitHubPage.repositorySearchName(repository));
            step("Клик по ссылке репозитория " + repository, () -> GitHubPage.openRepositoryByName(repository));
            step("Открытие вкладки Issues", GitHubPage::openIssuesPage);
            step("Проверка Issue с названием " + issueName, () -> GitHubPage.checkIssueExist(issueName));
        }

        @Test
        @DisplayName("Шаги с аннотацией @Step")
        void stepAnnotaitedTest() {
            GitHubPage.openPage();
            GitHubPage.repositorySearchName(repository);
            GitHubPage.openRepositoryByName(repository);
            GitHubPage.openIssuesPage();
            GitHubPage.checkIssueExist(issueName);
        }



}
