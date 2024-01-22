package Testing;

import POM.BaseClass;
import POM.LoginAndSignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class LoginTesting extends BaseClass {
    @Test(priority = 1)
    public void signUpWithExistingMail(){
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        POM.LoginAndSignUpPage si = new LoginAndSignUpPage();
        wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/login"));
        si.enterSignNewName("MuTesting");
        si.enterSignUpNewMail("0891c38d7a@emailaoa.pro");
        si.clickingSignUPButton();
        assertEquals("This mail is already existing","Email Address already exist!",BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p")).getText());

    }
    @Test(priority = 2)
    public void signinWithWrongCredentials() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        POM.LoginAndSignUpPage log = new LoginAndSignUpPage();
        log.enterSignInMail("0891c38d7a@emailaoa.pro");
        log.enterSignInPassword("A12345");
        log.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"))));
        assertEquals(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText(), "Your email or password is incorrect!");
    }

    @Test(priority = 3)
    public void signinWithCorrectCredentials() {
        POM.LoginAndSignUpPage log = new LoginAndSignUpPage();
        log.enterSignInMail("0891c38d7a@emailaoa.pro");
        log.enterSignInPassword("A123456");
        log.clickLoginButton();
        assertEquals(BaseClass.getWebDriver().getCurrentUrl(), "https://automationexercise.com/");
    }

}
