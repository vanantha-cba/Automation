package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BattleBusTravelPage {

    private WebDriver driver;
    private WebDriverWait waitDriver;
    private WebDriverWait driverWait;

    //By btnStartJourney = By.cssSelector("#bus_timer_start");
    By linkText = By.linkText("Use your superheroes Mask and sanitizer while traveling on public transport and clean your hands regularly.");

    public BattleBusTravelPage(WebDriver driver){

        this.driver = driver;
        driverWait = new WebDriverWait(driver,15);
    }

    public WebElement getLinkText() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(linkText)));
        return driver.findElement( linkText);
    }
}
