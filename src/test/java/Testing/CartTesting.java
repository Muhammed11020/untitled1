package Testing;


import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


import static junit.framework.Assert.assertEquals;

public class CartTesting extends BaseClass {

    @Test(priority = 1)
    public void quantityAndPriceVerification() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        Cart car = new Cart();
        assertEquals("Quantity in the cart", 3, car.getQuantityFromTheCart());
        assertEquals(true, car.priceIsvisible());
        assertEquals(true, car.totalPriceIsvisible());
        assertEquals(2, car.numberOfElementsInTheCart());
        car.removeElementFromTheCart("//*[@id=\"product-2\"]/td[6]/a");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"product-2\"]")));
        assertEquals(1, car.numberOfElementsInTheCart());
    }

    @Test(priority = 2)
    public void removeItemAndVerifyQuantity() {
        Cart car = new Cart();
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"product-2\"]")));
        assertEquals(1, car.numberOfElementsInTheCart());

    }

    @Test(priority = 3)
    public void verifySubscribtion() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        Cart car = new Cart();
        car.enterSubscribtionMail("0891c38d7a@emailaoa.pro");
        car.clickSubscribtionButton();
        assertEquals("Subscribtion Successed Message", "You have been successfully subscribed!", BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"success-subscribe\"]/div")).getText());
    }

    @Test(priority = 4)
    public void checkOutAndPaymentTesting() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        Cart ca = new Cart();
        ca.clickOnCheckout();
        ca.enterMSGCheckOut("Message");
        ca.clickingOnPlaceOrder();
        ca.enterCardName("Card Holder Name");
        ca.enterCardNumber(123456789);
        ca.enterCVC("123");
        ca.enterEXPMM(05);
        ca.enterEXPYY(26);
        ca.clickingPayAndConfirm();
        assertEquals("Congratulations! Your order has been confirmed!", BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p")).getText());
        wait.until(ExpectedConditions.urlContains("https://automationexercise.com/payment_done"));
        ca.clickDownloadInvoice();
        ca.clickContinueAfterPayments();
        assertEquals("https://automationexercise.com/", BaseClass.getWebDriver().getCurrentUrl());
    }

    @Test(dependsOnMethods = "Testing.FirstPageTesting.addingItesmsFromRecommendations")
    public void registerWhileChekingOut()
    {
        POM.SignUpDataPage s = new SignUpDataPage();
        POM.LoginAndSignUpPage si = new LoginAndSignUpPage();
        POM.FirstPage f = new FirstPage();
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        Cart c = new Cart();
        c.clickOnCheckout();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a")));
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a")).click();
        si.enterSignNewName("MuTesting");
        si.enterSignUpNewMail("0891c38d7a@emailaoa.pro");
        si.clickingSignUPButton();
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
        f.clickingCart();
        this.checkOutAndPaymentTesting();

    }
}
