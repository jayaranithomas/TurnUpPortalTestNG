package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{
    public void GoToTMPage(WebDriver driver)
    {

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a")));

            //Click on the Administration dropdown
            WebElement administrationDropdown = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
            administrationDropdown.click();

               //select the Time and Material option
        WebElement tmOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
        tmOption.click();
    }
}
