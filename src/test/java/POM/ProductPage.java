package POM;

import org.openqa.selenium.By;

public class ProductPage {
    public void openTheFirstItem() {
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a")).click();
    }

    public boolean isProductNameVisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")).isDisplayed();
    }

    public boolean isCategoryVisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")).isDisplayed();
    }

    public boolean isPriceVisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")).isDisplayed();
    }

    public boolean isAvailabilityVisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]")).isDisplayed();
    }

    public boolean isConditionVisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]")).isDisplayed();
    }

    public boolean isBrandVisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]")).isDisplayed();
    }

    public void addingToCart() {
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")).click();
    }

    public void clickingContinueShopping() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();
    }

    public void clickingViewCart() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")).click();
    }
    public void enterNameInReview(String name)
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(name);
    }
    public void enterMailInReview(String mail)
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(mail);
    }
    public void enterMSGReview(String msg)
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"review\"]")).sendKeys(msg);
    }
    public void clickSubmitReview()
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"button-review\"]")).click();
    }

}
