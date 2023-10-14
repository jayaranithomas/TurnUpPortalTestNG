package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.lang.Thread;

public class TMPage
{
    public void createTMrecord(WebDriver driver) throws InterruptedException
    {
        Wait.WaitToBeClickable(driver, "xpath", "//*[@id=\"container\"]/p/a", 5);

        //Click on the Create New Button

        WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
        createNewButton.click();

        // Click on the Typecode Dropdown
        WebElement tcDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[1]"));
        tcDropdown.click();

        // Select Time Option from the Material Dropdown
        WebElement timeOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        timeOption.click();

        //Enter the Code

        WebElement codeTextBox = driver.findElement(By.id("Code"));
        codeTextBox.sendKeys("NewRecord");

        //Enter the Description
        WebElement descriptionTextBox = driver.findElement(By.id("Description"));
        descriptionTextBox.sendKeys("Desc NewRecord");

        //Enter the Price
        WebElement priceTextBox = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTextBox.sendKeys("100.00");

        //Click on the Save Button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();

        Thread.sleep(5000);

        //Verify if the new record ha been created Successfully

        WebElement lastrRecordButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        lastrRecordButton.click();

        WebElement lastRecord = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
         /*if (lastRecord.Text == "NewRecord")
         {
             Assert.Pass("Record Creation Successfull");
         }
         else
         {
             Assert.Fail("Record Creation NOT Successfull");
         }*/
        //Assert.That(lastRecord.Text == "NewRecord", "Record Creation Not Successfull");
        Assert.assertEquals(lastRecord.getText(),"NewRecord", "New Record has not been Created Successfully");
        Thread.sleep(5000);
    }
    public void editTMRecord(WebDriver driver) throws InterruptedException
    {
        //Verify the Edit functionality of Time and Material Module
        //Click on the Edit Button of the last record
        Thread.sleep(5000);

        WebElement newLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        newLastPageButton.click();
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editButton.click();

       Thread.sleep(5000);

        // Click on the Dropdown
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[1]"));
        typeCodeDropdown.click();
       Thread.sleep(5000);

        // Select material Option from the typecode Dropdown

        WebElement materialOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[1]"));
        materialOption.click();
      //  Thread.sleep(5000);

        //Edit the Code
        WebElement codeEditTextBox = driver.findElement(By.id("Code"));
        codeEditTextBox.clear();
        codeEditTextBox.sendKeys("CodeEdited");
       // Thread.sleep(1000);

        //Edit the Description
        WebElement descriptionEditTextBox = driver.findElement(By.id("Description"));
        descriptionEditTextBox.clear();
        descriptionEditTextBox.sendKeys("Desc EditedRecord");

        Thread.sleep(1000);

        //Edit the Price
        WebElement editpriceoverlappingtag = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        WebElement editpricetextbox = driver.findElement(By.id("Price"));
        editpriceoverlappingtag.click();
        editpricetextbox.clear();
        editpriceoverlappingtag.click();
        editpricetextbox.sendKeys("300.50");

        //save the updates
       Thread.sleep(2000);
        WebElement newSaveButton = driver.findElement(By.xpath("//*[@id=\"SaveButton\"]"));
        newSaveButton.click();
        Thread.sleep(2000);

        //Verify if the edit has done
        WebElement newLPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        newLPageButton.click();
       Thread.sleep(1000);

        WebElement newLastRecord = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));

        /* if (newLastRecord.Text == "CodeEdited")
         {
             Console.WriteLine("Edit Successfull");
         }
         else
         {
             Console.WriteLine("Edit NOT Successfull");
         }*/
        //Assert.That(newLastRecord.Text == "CodeEdited", "Record Editing was Not Successfull");
        Assert.assertEquals(newLastRecord.getText(),"CodeEdited","Existing Record not edited Successfully");
    }
    public void deleteTMRecord(WebDriver driver) throws InterruptedException
    {
        //Verify the delete functionality of Time and Material Module
        //Click on the Delete Button of the last record
      //  Thread.sleep(5000);

        WebElement LPButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        LPButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        deleteButton.click();

        //For Accepting the deletion confirmation Alert
        driver.switchTo().alert().accept();

       Thread.sleep(5000);

        //Verify if the delete has done
        //IWebElement LastPButton = driver.FindElement(By.XPath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        //LastPButton.Click();


        WebElement newLastRec = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));

        /* if (newLastRec.Text != "CodeEdited")
         {
             Console.WriteLine("Delete Successfull");
         }
         else
         {
             Console.WriteLine("Delete NOT Successfull");
         }*/
        //Assert.That(newLastRec.Text != "CodeEdited", "Record Deletion was Not Successfull");
        Assert.assertNotEquals(newLastRec.getText(),"CodeEdited","Deletion not Successfull");
    }
}
