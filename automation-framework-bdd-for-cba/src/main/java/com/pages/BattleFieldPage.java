package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BattleFieldPage {

    private WebDriver driver;
    private WebDriverWait waitDriver;
    private WebDriverWait driverWait;
    By lnkTextHeading = By.cssSelector(".alpha-heading");
    By btnBus = By.cssSelector("#bus");
    By btnStartJourney = By.cssSelector("#bus_timer_start");


    public BattleFieldPage(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver,15);

    }

    public WebElement getLnkTextHeading() {
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(lnkTextHeading)));
        return driver.findElement(lnkTextHeading);
    }

    public WebElement getBtnBus() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnBus)));
        return driver.findElement( btnBus);
    }



    public void scrollWindow(int start, int end, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(start,end)");

    }

    public WebElement getBtnStartJourney() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnStartJourney)));
        return driver.findElement(btnStartJourney);
    }



}
