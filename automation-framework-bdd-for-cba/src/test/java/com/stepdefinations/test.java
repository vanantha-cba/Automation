package com.stepdefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import com.jayway.jsonpath.JsonPath;

//import io.restassured.RestAssured;
//mport io.restassured.http.ContentType;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
import com.FrameworkHelpers.DriverHelper;

import static io.restassured.RestAssured.*;

public class test extends DriverHelper {

    @Test
    public void test() throws IOException, InterruptedException {

       //get
        String uri;
        initializeProperties();
        uri = prop.getProperty("uri_get");
        RestAssured.baseURI =uri;
        String jsonResponse = given().when().get().asString();
        System.out.println(jsonResponse);
        List<HashMap<String,?>> rootElement = JsonPath.read(jsonResponse,"$");
        System.out.println(rootElement.toString());
        for(int i=0 ;i<rootElement.size(); i++){

            if(rootElement.get(i).containsValue("Gajusr_002")) {

                System.out.println(rootElement.get(i).containsValue("Gajusr_002"));
            }

        }
            String payLoad ="{\"username\":\"test_usr2\",\"score\":0}";
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .body(payLoad)
                    .post()
                    .then()
                    .log()
                    .status()
                    .statusCode(400);


        String payLoad1 ="{\"username\":\"test_usr2\",\"score\":40}";
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(payLoad1)
                .put()
                .then()
                .log()
                .status()
                .statusCode(204);

        given()
                .when()
                .delete()
                .then()
                .log()
                .status()
                .statusCode(401);
        String userName ="009_jhin";
        String payLoad3 ="{\"username\":\""+userName+"\",\"score\":0}";

        System.out.println( payLoad3);




       /* driver=initializeDriver("chrome");
        WebDriverWait d = new WebDriverWait(driver,20);
        d.until(ExpectedConditions.elementToBeClickable(By.id("warrior")));

        driver.findElement(By.cssSelector("#worrior_username")).sendKeys("Gaj_usr001");
        driver.findElement(By.id("warrior")).click();
        Assert.assertTrue( driver.findElement(By.linkText("Start your journey Gaj_usr001")).getText().equals("Start your journey Gaj_usr001"));
        driver.findElement(By.id("start")).click();
        d.until(ExpectedConditions.textToBe(By.cssSelector(".alpha-heading"),"COVID-19 THE GAME"));
        Assert.assertTrue( driver.findElement(By.cssSelector(".alpha-heading")).getText().equals("COVID-19 THE GAME"));
        //Actions as = new Actions(driver);
       // as.moveToElement(driver.findElement(By.cssSelector("#office"))).build().perform();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        d.until(ExpectedConditions.elementToBeClickable(By.id("bus")));

        driver.findElement(By.cssSelector("#bus")).click();
        d.until(ExpectedConditions.elementToBeClickable(By.id("bus_timer_start")));

        driver.findElement(By.cssSelector("#bus_timer_start")).click();
        driver.findElement(By.linkText("Use your superheroes Mask and sanitizer while traveling on public transport and clean your hands regularly.")).click();
        //System.out.println(driver.findElement(By.cssSelector("#staticBackdropLabel")).getText());
        //Assert.assertTrue( driver.findElement(By.cssSelector("#staticBackdropLabel")).getText().equals("That is correct!"));
        driver.findElement(By.cssSelector("#leaderboard_link")).click();
        //*[@id="showData"]/table/tbody/tr[83]/td[2]
        Assert.assertTrue( driver.findElement(By.cssSelector(".option-label")).getText().equals("COVID-19 THE GAME - LEADERBOARD"));


        //*[@id="showData"]/table/tbody/tr[93]/td[2]
       // Assert.assertTrue( driver.findElement(By.xpath("//*[@id='showData']/table/tbody/tr[93]/td[2]")).getText().equals("Gaj_usr001"));

        driver.findElement(By.xpath("//*[@id='showData']/table/tbody/tr[93]/td[2]")).getText();

       List<WebElement> cells = driver.findElements(By.xpath("//*[@id='showData']/table/tbody//td[2]"));
       for(int ctr = 0; ctr <cells.size();ctr++){
           String cellValue = cells.get(ctr).getText();
           if(cellValue.equals("Gaj_usr002"))
           {Assert.assertTrue(true);}else {Assert.assertTrue(false);}
       }
   */


        /*//driver.findElement(By.cssSelector(selector))
        Actions as = new Actions(driver);
        as.moveToElement(driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]"))).build().perform();
        Thread.sleep(3);
        //driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]//div[2]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//a[@data-id-product='1']")).click();
        WebDriverWait d = new WebDriverWait(driver,20);
        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title*='Continue shopping']")));
        //driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span")).click();


        driver.findElement(By.xpath("//span[contains(@title,'Continue shopping')]")).click();
        Thread.sleep(3);
        as.moveToElement(driver.findElement(By.xpath("//*[@id='homefeatured']/li[2]"))).build().perform();

        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-id-product='2']")));
        driver.findElement(By.xpath("//a[@data-id-product='2']")).click();

        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title*='Continue shopping']")));
        driver.findElement(By.xpath("//span[contains(@title,'Continue shopping')]")).click();

        //as.moveToElement(driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"))).build().perform();
        as.moveToElement(driver.findElement(By.xpath("//a[contains(@title,'View my shopping cart')]"))).build().perform();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='button_order_cart']")));

        driver.findElement(By.xpath("//a[@id='button_order_cart']")).click();
        driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium")).click();

        driver.findElement(By.id("email")).sendKeys("vg@gmail.com");
        //todo:password shuold be invisible.

        driver.findElement(By.id("passwd")).sendKeys("String12@");

        driver.findElement(By.id("SubmitLogin")).click();


        driver.findElement(By.cssSelector("button[name='processAddress']")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector("button[name='processCarrier']")).click();
        driver.findElement(By.cssSelector(".bankwire")).click();
        driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();



        driver.quit();
*/
    }

}
