package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    public WebDriver driver;
    public WebDriverWait waitDriver;
    By btnWarrior = By.id("warrior");
    By txtWarriorUsr = By.cssSelector("#worrior_username");
    By btnStart = By.id("start");
    By linktxtStartJourney =By.linkText("Start your journey Gaj_usr001");

    public  LandingPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getBtnWarrior() {
        return driver.findElement(btnWarrior);
    }

    public WebElement getTxtWarriorUsr() {
        return driver.findElement(txtWarriorUsr) ;
    }

    public WebElement getBtnStart() {
        return driver.findElement(btnStart);
    }

    public WebElement getLinktxtStartJourney() {
        return driver.findElement( linktxtStartJourney);
    }

    public void setLinktxtStartJourney(By linktxtStartJourney) {
        this.linktxtStartJourney = linktxtStartJourney;
    }
}
