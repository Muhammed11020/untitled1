package Testing;

import POM.BaseClass;
import POM.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class PDPTesting extends BaseClass {
    @Test(priority = 1)
    public void openPDPForTheFirstItem() {
        POM.ProductPage p = new ProductPage();
        p.openTheFirstItem();
        assertEquals("https://automationexercise.com/product_details/1", BaseClass.getWebDriver().getCurrentUrl());
    }
    @Test(priority = 2)
    public void addingReviewTesting()
    {
        ProductPage prod = new ProductPage();
        prod.enterNameInReview("MuTest");
        prod.enterMailInReview("0891c38d7a@emailaoa.pro");
        prod.enterMSGReview("It's a review for this product");
        prod.clickSubmitReview();
        assertEquals("Review sent correctly message","Thank you for your review.",BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"review-section\"]/div/div")).getText());
    }

    @Test(priority = 3)
    public void nameIsVisable() {
        POM.ProductPage p = new ProductPage();
        assertEquals(true, p.isProductNameVisible());
    }

    @Test(priority = 4)
    public void categoryIsVisable() {
        POM.ProductPage p = new ProductPage();
        assertEquals(true, p.isCategoryVisible());
    }

    @Test(priority = 5)
    public void priceIsVisable() {
        POM.ProductPage p = new ProductPage();
        assertEquals(true, p.isPriceVisible());
    }

    @Test(priority = 6)
    public void availabilityIsVisable() {
        POM.ProductPage p = new ProductPage();
        assertEquals(true, p.isAvailabilityVisible());
    }

    @Test(priority = 7)
    public void conditionIsVisable() {
        POM.ProductPage p = new ProductPage();
        assertEquals(true, p.isConditionVisible());
    }

    @Test(priority = 8)
    public void brandIsVisable() {
        POM.ProductPage p = new ProductPage();
        assertEquals(true, p.isBrandVisible());
    }

    @Test(priority = 9)
    public void addingItemToTheCart() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        ProductPage p = new ProductPage();
        p.addingToCart();
        wait.until(ExpectedConditions.visibilityOf(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"cartModal\"]/div/div"))));
        p.clickingContinueShopping();
    }

    @Test(priority = 10)
    public void addingToCartAndGoToCart() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        ProductPage p = new ProductPage();
        p.addingToCart();
        wait.until(ExpectedConditions.visibilityOf(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"cartModal\"]/div/div"))));
        p.clickingViewCart();
    }

}
