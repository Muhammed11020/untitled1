package Testing;

import POM.BaseClass;
import POM.FirstPage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class FirstPageTesting extends BaseClass {
    @Test
    public void openLoginAndRigistrationPage() {
        POM.FirstPage p = new FirstPage();
        p.openLoginOrSignUpPage();
        assertEquals(BaseClass.getWebDriver().getCurrentUrl(), "https://automationexercise.com/login");
    }
    @Test(dependsOnMethods = {"Testing.NewUserSignUpTesting.enteringSignUpData"})
    public void scrollingDownTesting() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.getWebDriver();
        POM.FirstPage p = new FirstPage();
        p.scrollToTheBottom(BaseClass.getWebDriver());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollUp")));
        assertEquals("Subscribtion is Displayed in the bottom of the home page",true,p.isSubscribtionVisible());
        p.clickingOnTheUPArrow();
        wait.until((WebDriver d) -> (Boolean) js.executeScript("return window.scrollY == 0"));
    }
    @Test(dependsOnMethods = {"scrollingDownTesting"})

    public void scrollingDownAndUpWithoutArrowTesting()
    {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        POM.FirstPage p = new FirstPage();
        p.scrollToTheBottom(BaseClass.getWebDriver());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollUp")));
        p.scrollToTopOfThePageWithoutClickingArrow();
    }
    @Test(dependsOnMethods = {"scrollingDownAndUpWithoutArrowTesting"})
    public void loggingOut() {
        POM.FirstPage f = new FirstPage();
        f.logOut();
        assertEquals(BaseClass.getWebDriver().getCurrentUrl(), "https://automationexercise.com/login");
    }
    @Test(dependsOnMethods = {"Testing.LoginTesting.signinWithCorrectCredentials"})
    public void openContactingUsPage() {
        POM.FirstPage f = new FirstPage();
        f.clickingContactingUs();
    }

    @Test(dependsOnMethods = {"Testing.ContactUsTesting.ContactingUsTesting"})
    public void openTestCases() {
        POM.FirstPage f = new FirstPage();
        f.clickingOnTestCases();
        Assert.assertEquals("TEST CASES", BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b")).getText());
        f.openHomePage();
    }

    @Test(dependsOnMethods = {"openTestCases"})
    public void openProductsPageTesting() {
        POM.FirstPage f = new FirstPage();
        f.openProductsPage();
        assertEquals("ALL PRODUCTS", BaseClass.getWebDriver().findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2")).getText());
    }
    @Test(dependsOnMethods = "Testing.CartTesting.checkOutAndPaymentTesting")
    public void deletingAccount()
    {
        POM.FirstPage f = new FirstPage();
        f.deleteAccount();
        assertEquals("Account deleted successfully","ACCOUNT DELETED!",BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText());
        f.clickingContinueAfterDeletingAccount();
        assertEquals("Home Page opens after deleting the account","https://automationexercise.com/",BaseClass.getWebDriver().getCurrentUrl());
    }
}
