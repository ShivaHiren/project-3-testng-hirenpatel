package herokuapp.testsuite;


import herokuapp.customlisteners.CustomListeners;
import herokuapp.pages.LoginPage;
import herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void UserSholdLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("Jhonwick");
        loginPage.enterPassword("Jhonwick");
        loginPage.clickOnLoginButton();
        Assert.assertEquals("Secure Area", "Secure Area");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage() {
        loginPage.enterUserName("Superman");
        loginPage.enterPassword("Jhonwick");
        loginPage.clickOnLoginButton();
        Assert.assertEquals("Your username is invalid!\\n\" +\n" +
                "                \"×", "Your username is invalid!\\n\" +\n" +
                "                \"×");

    }

    @Test(groups = {"regression"})
    public void verifyThePasswordErrorMessage() {
        loginPage.enterUserName("Jhonwick");
        loginPage.enterPassword("1234");
        loginPage.clickOnLoginButton();
        Assert.assertEquals("Your password is invalid!\\n\" +\n" +
                "                \"×", "Your password is invalid!\\n\" +\n" +
                "                \"×");

    }

}

