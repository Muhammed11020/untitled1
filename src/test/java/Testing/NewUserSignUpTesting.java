package Testing;

import POM.BaseClass;
import POM.LoginAndSignUpPage;
import POM.SignUpDataPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class NewUserSignUpTesting extends BaseClass {
    @Test
    public void enteringNewUser() {

        POM.LoginAndSignUpPage si = new LoginAndSignUpPage();
        si.enterSignNewName("MuTesting");
        si.enterSignUpNewMail("0891c38d7a@emailaoa.pro");
        si.clickingSignUPButton();
    }

    @Test
    public void enteringSignUpData() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(5000));
        POM.SignUpDataPage s = new SignUpDataPage();
        s.selectSignUPGender(1);
        s.enterSignUpPassword("A123456");
        s.enterSignUpDateOfBirth(1, 1, "2000");
        s.enterFirstName("M");
        s.enterLastName("T");
        s.enterCompanyName("ASD");
        s.enterAddress1("Cairo");
        s.enterAddress2("Cairo2");
        s.selectCountry("India");
        s.enterState("Cairooo");
        s.enterCity("Tanta");
        s.enterZipCode("147852");
        s.enterMobilePhone("123456789");
        s.clickCreateAccount();
        wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/account_created"));
        assertEquals(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText(), "ACCOUNT CREATED!");
        s.clickingContinueAfterEnteringData();
        assertEquals(BaseClass.getWebDriver().getCurrentUrl(), "https://automationexercise.com/");
    }
}
