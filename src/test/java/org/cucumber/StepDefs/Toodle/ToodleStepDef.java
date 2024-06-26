package org.cucumber.StepDefs.Toodle;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cucumber.StepDefs.Common.OpenPage;
import org.cucumber.Utilities.Environments;

public class ToodleStepDef {

    private Page page;

    @Given("The user has been placed on the login page of the yedy application.")
    public void theUserHasBeenPlacedOnTheLoginPageOfTheYedyApplication() {
        OpenPage openPage = new OpenPage(Environments.YEDY);
        openPage.initializeBrowser();
        page = openPage.openBasePage();
    }

    @When("The user login  in to the yedy application")
    public void theUserLoginInToTheYedyApplication() {

            page.fill("//input[@name='username']", "jcandia");
            page.fill("//input[@name='password']", "sesame");
            page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    @Then("The login page will be displayed")
    public void theLoginPageWillBeDisplayed() {
        page.click("//button[@class='login-button btn btn-primary w-100']");

    }
}