package Testing;


import POM.BaseClass;
import POM.Cart;
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
        assertEquals("Quantity in the cart",3, car.getQuantityFromTheCart());
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
    public void verifySubscribtion()
    {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        Cart car = new Cart();
        car.enterSubscribtionMail("0891c38d7a@emailaoa.pro");
        car.clickSubscribtionButton();
        assertEquals("Subscribtion Successed Message","You have been successfully subscribed!",BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"success-subscribe\"]/div")).getText());
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
}
