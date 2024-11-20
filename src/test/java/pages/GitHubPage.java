package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubPage {
    @Step("Открытие главной страницы")
    public static void openPage(){
        open("");
    }

    @Step("Поиск репозитория {name}")
    public static void repositorySearchName(String name){
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(name);
        $("#query-builder-test").submit();

    }

    @Step("Клик по {name} репозитория")
    public static void openRepositoryByName(String name) {
        $(byLinkText(name)).click();
    }

    @Step("Открытие вкладки Issues")
    public static void openIssuesPage() {
        $("#issues-tab").click();
    }
    @Step("Проверка issue {name} существует")
    public static void checkIssueExist(String name) {
        $(byText(name)).should(exist);
    }
}



