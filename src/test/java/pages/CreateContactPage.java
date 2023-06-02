package pages;

import elements.InputField;
import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.ContactTest;

public class CreateContactPage extends BasePage {
    private static final String ACCOUNT_NAME_XPATH = "//*[text() = 'Account Name']/ancestor::span[contains(@class, 'test-id')]//input";

    public CreateContactPage(WebDriver driver) {
        super(driver);
    }

    public CreateContactPage openPage() {
        driver.get("https://nanikare.lightning.force.com/lightning/o/Contact/new");
        return this;
    }

    public void createContact(Contact contact) {
        new InputField(driver, "First Name").writeText(contact.getFirstName());
        new InputField(driver, "Last Name").writeText(contact.getLastName());
        driver.findElement(By.xpath(ACCOUNT_NAME_XPATH)).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ACCOUNT_NAME_XPATH)))).click();
        driver.findElement(By.xpath("//span[contains(text(), 'ghjdhf')]")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    }

    public boolean isContactCreated() {
        boolean isContactCreated = driver.findElement(By.xpath("//*[@data-label='Details']")).isDisplayed();
        return isContactCreated;
    }
}
