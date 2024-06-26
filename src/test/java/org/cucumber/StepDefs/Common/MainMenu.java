package org.cucumber.StepDefs.Common;

import org.cucumber.Utilities.Environments;

public class MainMenu {

    public static void main(String[] args) {
        OpenPage openPageYedy = new OpenPage(Environments.YEDY);
        openPageYedy.initializeBrowser();
        openPageYedy.openBasePage();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OpenPage openPageFramework = new OpenPage(Environments.FRAMEWORK);
        openPageFramework.initializeBrowser();
        openPageFramework.openBasePage();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        openPageYedy.closeBrowser();
        openPageFramework.closeBrowser();
    }
}