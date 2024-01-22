package POM;

import org.openqa.selenium.By;

public class Cart {
    public int getQuantityFromTheCart() {
        int num = Integer.valueOf(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button")).getText());
        return num;
    }

    public boolean priceIsvisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p")).isDisplayed();
    }

    public boolean totalPriceIsvisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p")).isDisplayed();
    }

    public int numberOfElementsInTheCart() {
        return BaseClass.getWebDriver().findElements(By.className("cart_product")).size();
    }

    public void removeElementFromTheCart(String xPath) {
        BaseClass.getWebDriver().findElement(By.xpath(xPath)).click();
    }

    public void enterSubscribtionMail(String mail)
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"susbscribe_email\"]")).sendKeys(mail);
    }
    public void clickSubscribtionButton()
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"subscribe\"]/i")).click();
    }
    public void clickOnCheckout() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
    }

    public void enterMSGCheckOut(String msg) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea")).sendKeys(msg);
    }

    public void clickingOnPlaceOrder() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a")).click();
    }

    public void enterCardName(String name) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input")).sendKeys(name);
    }

    public void enterCardNumber(int num) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input")).sendKeys(String.valueOf(num));
    }

    public void enterCVC(String cvc) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input")).sendKeys(cvc);
    }

    public void enterEXPMM(int month) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input")).sendKeys(String.valueOf(month));
    }

    public void enterEXPYY(int year) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input")).sendKeys(String.valueOf(year));
    }

    public void clickingPayAndConfirm() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"submit\"]")).click();
    }
    public void clickDownloadInvoice()
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/a")).click();
    }

    public void clickContinueAfterPayments() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
    }
}
