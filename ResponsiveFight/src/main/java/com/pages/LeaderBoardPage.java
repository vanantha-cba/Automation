package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class LeaderBoardPage {
    private WebDriver driver;
    private WebDriverWait waitDriver;
    private WebDriverWait driverWait;

    By btnLeaderBoard = By.cssSelector("#leaderboard_link");
    By lblHeading = By.cssSelector(".option-label");
    By tblLeader = By.xpath("//*[@id='showData']/table/tbody//td[2]");

    public LeaderBoardPage(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver,15);
    }

    public WebElement getBtnLeaderBoard() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnLeaderBoard)));
        return driver.findElement( btnLeaderBoard);
    }

    public WebElement getLblHeading() {

        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(lblHeading)));
        return driver.findElement( lblHeading);
    }

    public List<WebElement> getTblLeader() {
        return driver.findElements(tblLeader);

    }

    public boolean UserDetailsFromTable(List<WebElement> cells,String userName){
        boolean flag = false;
        for(int ctr = 0; ctr <cells.size();ctr++){
            String cellValue = cells.get(ctr).getText();
            if(cellValue.equals(userName))
            {
                flag = true;

            } else
                {flag = false;}
        }
        return flag;
    }
}
