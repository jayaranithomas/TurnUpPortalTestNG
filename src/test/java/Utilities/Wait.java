package Utilities;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Wait
{
  public static void WaitToBeClickable(WebDriver driver, String locatortype, String locatorValue, int sec)
    {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(sec)); //webDriverWait(driver, new TimeSpan(0, 0, sec));
        if(locatortype == "xpath")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        }
        else if (locatortype == "id")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
        }
        else if (locatortype == "cssSelector")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
        }
        else if (locatortype == "name")
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
        }
    }
    public static void WaitToBeVisible(WebDriver driver, String locatortype, String locatorValue, int sec)
    {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        if (locatortype == "xpath")
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
        }
        else if (locatortype == "id")
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
        }
        else if (locatortype == "cssSelector")
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
        }
        else if (locatortype == "name")
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
        }
    }
}
