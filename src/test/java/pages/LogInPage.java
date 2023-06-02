package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage{
    private static By USERNAME_FIELD = By.xpath("//input[@id='username");
    private static By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    private static By LOGIN_BUTTON = By.xpath("//input[@id='username']");

    public LogInPage(WebDriver driver) {
        super(driver);
    }
}
