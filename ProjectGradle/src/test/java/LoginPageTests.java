import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pageObjects.BaseTests;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTests extends BaseTests {

    @ParameterizedTest
    @CsvSource({
            "admin$$,admin123",
            "Admin,admin123!!",
            "admin123,Admin",
            "%%%%%,$$$$$$"})
    public void invalidCredentials(String username, String password) {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(username, password);

        // Verify Error Message
        assertEquals("Invalid credentials",objLoginPage.getErrorMessage());

    }

    @Test
    public void validLogin() {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login("Admin", "admin123");

        HomePage objHomePage = new HomePage(driver);

        // Verify Home Page
        assertEquals("Employee Information",objHomePage.getHomePageText());

    }

    @Test @Disabled
    public void missingUsername() {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login("", "admin123");

        // Verify Error Message
        assertEquals("Invalid credentials",objLoginPage.getMissingUsernameText());

    }

    @Test @Disabled
    public void missingPassword() {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login("admin", "");

        // Verify Error Message
        assertEquals("Invalid credentials",objLoginPage.getMissingPasswordText());

    }

}