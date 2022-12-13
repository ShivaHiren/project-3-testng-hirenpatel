package herokuapp.pages;


import com.aventstack.extentreports.Status;
import herokuapp.customlisteners.CustomListeners;
import herokuapp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "username")
    WebElement userName;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),' Secure Area')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='flash']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='flash error']")
    WebElement invalidPassword;


    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public void enterUserName(String name) {
        Reporter.log(" Enter username " + userName.toString());
        sendTextToElement(userName, name);
        CustomListeners.test.log(Status.PASS, " Enter username  ");
    }

    public void enterPassword(String password) {
        Reporter.log(" Enter password " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, " Enter password  ");
    }

    public void clickOnLoginButton() {
        Reporter.log(" Click on login button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, " Click on login button ");
    }
}
