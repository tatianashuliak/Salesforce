package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {
    private static final String DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::span[contains(@class,'test')]//button";
    private static final String SELECT_OPTION_XPATH = "//*[@role='listbox']//span[contains(text(), 'Apparel')]";
    private WebDriver driver;
    private String label;

    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(DROPDOWN_XPATH, label))))).click();
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }
}
