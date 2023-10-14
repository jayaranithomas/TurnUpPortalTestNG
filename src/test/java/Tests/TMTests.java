package Tests;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import Utilities.CommonDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TMTests extends CommonDriver {
    @BeforeTest
    public void SetupTM() throws InterruptedException {

        // open the chrome browser
        driver = new ChromeDriver();
        LoginPage logObj = new LoginPage();
        logObj.LoginActons(driver);
        HomePage homeObj = new HomePage();
        homeObj.GoToTMPage(driver);

    }

    @Test(priority = 0, description = "This test creates a new TM record")
    public void TestCreateTMRecord() throws InterruptedException {
        TMPage tMPageObj = new TMPage();
        tMPageObj.createTMrecord(driver);
    }
    @Test(priority = 1, description = "This test edits an existing TM record")
    public void TestEditTMRecord() throws InterruptedException {
        TMPage tMPageObj = new TMPage();
        tMPageObj.editTMRecord(driver);
    }
    @Test(priority = 2, description = "This test deletes a TM record")
    public void TestDeleteTMRecord() throws InterruptedException {
        TMPage tMPageObj = new TMPage();
        tMPageObj.deleteTMRecord(driver);
    }
    @AfterTest
    public void CloseTestRun()
    {
        driver.quit();
    }







}

