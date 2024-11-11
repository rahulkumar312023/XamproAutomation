package testcases;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import utilities.DriverSetup;

public class TestLogin extends DriverSetup {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();




   @Test
   public void testLoginWithValidCredentials(){
       getBrowser().get(homePage.homePageUrl);
       homePage.clickOnElement(homePage.closeButton);
       homePage.clickOnElement(homePage.signInButton);
       signInPage.writeOnElement(signInPage.emailField, signInPage.email);
       signInPage.writeOnElement(signInPage.passField, signInPage.password);
       signInPage.clickOnElement(signInPage.logInButton);
   }
}
