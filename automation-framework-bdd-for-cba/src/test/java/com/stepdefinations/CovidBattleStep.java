package com.stepdefinations;

import com.FrameworkHelpers.DriverHelper;
import com.pages.BattleBusTravelPage;
import com.pages.BattleFieldPage;
import com.pages.LandingPage;
import com.pages.LeaderBoardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class CovidBattleStep extends DriverHelper {

    public WebDriver driver;
    public Actions as;
    public WebDriverWait driverWait;
    public LandingPage landingPage;
    public BattleFieldPage battleFieldPage;
    public BattleBusTravelPage battleBusTravelPage;
    public LeaderBoardPage leaderBoardPage;
    public String userName;

   // private static Logger Log = (Logger) LogManager.getLogger(CovidBattleStep.class.getName());
    public CovidBattleStep() throws IOException {


    }

    @Given("^the user is on the home page$")
    public void the_user_is_on_the_home_page() {

    }
    @Given("^the user creates a warrior having name \"([^\"]*)\" using browser \"([^\"]*)\"$")
    public void the_user_creates_a_warrior_having_name_using_browser(String userName, String browser) throws IOException {
        driver=initializeDriver(browser);
        driverWait = new WebDriverWait(driver,15);
        //driverWait=getWebdriverWait(driver);
        landingPage = new LandingPage(driver);
        as = new Actions(driver);
        driverWait = new WebDriverWait(driver,20);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPage.getBtnWarrior()));
        landingPage.getTxtWarriorUsr().sendKeys(userName);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPage.getBtnWarrior()));
        landingPage.getBtnWarrior().click();
        this.userName = userName;


        Assert.assertTrue( driver.findElement(By.linkText("Start your journey "+ userName)).getText().equals("Start your journey "+ userName));
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPage.getBtnStart()));
        landingPage.getBtnStart().click();

    }
    @Given("^user selects his battlefield as \"([^\"]*)\"$")
    public void user_selects_his_battlefield_as(String string) {
        battleFieldPage = new BattleFieldPage(driver);
        Assert.assertTrue( battleFieldPage.getLnkTextHeading().getText().equals("COVID-19 THE GAME"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        battleFieldPage.getBtnBus().click();battleFieldPage.getBtnStartJourney().click();


    }
    @When("he is travelling by bus, he decides to \"([^\"]*)\"$")
    public void he_is_travelling_by_bus_he_decides_to(String string) {
        battleBusTravelPage = new BattleBusTravelPage(driver);
       // battleBusTravelPage.getBtnStartJourney().click();
        battleBusTravelPage.getLinkText().click();


    }

    @Then("^the user checks his final score$")
    public void the_user_checks_his_final_score() {
        leaderBoardPage = new LeaderBoardPage(driver);
        leaderBoardPage.getBtnLeaderBoard().click();
        Assert.assertTrue( leaderBoardPage.getLblHeading().getText().equals("COVID-19 THE GAME - LEADERBOARD"));
        Assert.assertTrue( leaderBoardPage.UserDetailsFromTable(leaderBoardPage.getTblLeader(),userName));
        driver.quit();

    }

}
