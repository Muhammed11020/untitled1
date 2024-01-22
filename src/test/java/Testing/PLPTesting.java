package Testing;

import POM.BaseClass;
import POM.FirstPage;
import POM.PLP;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class PLPTesting extends BaseClass {
    FirstPage first = new FirstPage();
    @Test(priority = 1)
    public void categoryTesting()
    {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(2000));
        first.openProductsPage();
        PLP p = new PLP();
        assertEquals("Category Is displayed",true,p.categoryIsVisible());
        p.clickOnWomenCategory();
        wait.until(ExpectedConditions.visibilityOf(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a"))));
        p.clickOnDress();
        assertEquals("",BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a")).getText());
    }
    @Test(priority = 2)
    public void brandTesting()
    {
        PLP p = new PLP();
        assertEquals("Brand is displayed",true,p.brandIsVisible());
        p.clickOnPoloBrand();
        assertEquals("BRAND - POLO PRODUCTS",BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2")).getText());
    }
    @Test(priority = 3)
    public void searchTesting() {
        String search = "Winter Top";
        first.openProductsPage();
        PLP p = new PLP();
        p.searchForItem(search);
        p.clickOnSearchButton();
        assertEquals(search, BaseClass.getWebDriver().findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/p")).getText());
    }

    @Test(priority = 4)
    public void addingElementsToTheCart() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofMillis(5000));
        first.openProductsPage();
        PLP p = new PLP();
        p.hoverOverOnItem("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]");
        wait.until(ExpectedConditions.visibilityOf(BaseClass.getWebDriver().findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]"))));
        p.clickAddToTheCart("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")));
        p.clickingContinueShopping();
        p.hoverOverOnItem("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]");
        wait.until(ExpectedConditions.visibilityOf(BaseClass.getWebDriver().findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]"))));
        p.clickAddToTheCart("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")));
        p.clickingViewCart();
        assertEquals("https://automationexercise.com/view_cart", BaseClass.getWebDriver().getCurrentUrl());
    }
}
