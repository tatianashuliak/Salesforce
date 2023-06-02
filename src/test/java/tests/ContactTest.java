package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.Account;
import model.Contact;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateContactPage;
import pages.NewAccountPage;

import java.util.concurrent.TimeUnit;

public class ContactTest {

    @Test
    public void createContactTest() {
        User user = new User("https://nanikare.lightning.force.com", "wopag92699-1wjg@force.com", "23041997nik");
        Contact contact = new Contact("Shuliak", "account", "Tatiana");
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
        CreateContactPage createContactPage = new CreateContactPage(driver);
        createContactPage.openPage()
                .createContact(contact);
        Assert.assertTrue(createContactPage.isContactCreated(), "Contact wasn't created");
    }
}
