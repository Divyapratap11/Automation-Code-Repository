package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By userIdInput = By.xpath("//input[@placeholder='User ID']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//button[text()='Log In']");
    private By eyeIcon = By.xpath("//button[contains(@class,'eye')]");
    private By errorMsg = By.xpath("//*[contains(text(),'Invalid Credentials')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String userId) {
        driver.findElement(userIdInput).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isPasswordMasked() {
        WebElement pwd = driver.findElement(passwordInput);
        return pwd.getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIcon).click();
    }
}
