package org.cucumber.StepDefs.Common;

import com.microsoft.playwright.*;

public class OpenPage {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private String baseUrl;

    public OpenPage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void initializeBrowser() {
        try {
            Playwright playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            context = browser.newContext();
            page = context.newPage();
        } catch (PlaywrightException e) {
            e.printStackTrace();
        }
    }

    public Page openBasePage() {
        if (page != null) {
            page.navigate(baseUrl);
        } else {
            System.out.println("Page is not initialized.");
        }
        return page;
    }

    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
    }
}