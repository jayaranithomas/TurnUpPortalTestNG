package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.Thread;

import static java.lang.Thread.*;

public class LoginPage
{
    public void LoginActons(WebDriver driver) throws InterruptedException
    {
        //navigate to the turnup portal login page
        driver.navigate().to("http://horse.industryconnect.io/Account/Login");

        //maximize the window
        driver.manage().window().maximize();

        //identify the username field
       // Wait.WaitToBeVisible(driver, "Id", "UserName", 5);
        //Thread.sleep(2000);
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));

        //Enter the username
        userNameTextBox.sendKeys("hari");

        //identify the password field
        WebElement passwordTextBox = driver.findElement(By.id("Password"));

        //Enter the username
        passwordTextBox.sendKeys("123123");

        //Identify the login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));

        //click on the login button
        loginButton.click();
        //driver.SwitchTo().Alert().Accept();

       Thread.sleep(5000);
        if (Thread.interrupted()) {
            throw new InterruptedException();}

    }
}
