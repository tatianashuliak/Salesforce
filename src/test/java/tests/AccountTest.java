package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.Account;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewAccountPage;

import java.util.concurrent.TimeUnit;


public class AccountTest {

    @Test
    public void createAccountTest() {
        User user = new User("https://nanikare.lightning.force.com", "wopag92699-1wjg@force.com", "23041997nik");
        Account account = new Account("AccountAQA", "www.onliner.by");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(user.getUrl());
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user.getLogin());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.openPage()
                .create(account);
        Assert.assertTrue(newAccountPage.isAccountCreated(), "Account wasn't created");
    }
}
