package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PLP {
    public void searchForItem(String search) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"search_product\"]")).sendKeys(search);
    }
    public boolean categoryIsVisible()
    {
        return BaseClass.getWebDriver().findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div/h2")).isDisplayed();
    }
    public void clickOnWomenCategory()
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")).click();
    }
    public void clickOnDress()
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a")).click();
    }
    public boolean brandIsVisible()
    {
        return BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/h2")).isDisplayed();
    }
    public void clickOnPoloBrand(){
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[1]/a")).click();
    }
    public void clickOnSearchButton() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"submit_search\"]/i")).click();
    }

    public void hoverOverOnItem(String xpathElement) {
        Actions action = new Actions(BaseClass.getWebDriver());
        WebElement we = BaseClass.getWebDriver().findElement(By.xpath(xpathElement));
        action.moveToElement(we).moveToElement(BaseClass.getWebDriver().findElement(By.xpath(xpathElement))).perform();
    }

    public void clickAddToTheCart(String xpathElement) {
        BaseClass.getWebDriver().findElement(By.xpath(xpathElement)).click();
    }

    public void clickingContinueShopping() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();
    }

    public void clickingViewCart() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")).click();
    }
}
