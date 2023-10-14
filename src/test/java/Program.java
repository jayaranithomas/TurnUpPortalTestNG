import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://horse.industryconnect.io/Account/Login");
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys("hari");
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("123123");
    }
}
