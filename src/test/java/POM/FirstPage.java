package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstPage {
    public void openLoginOrSignUpPage() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }

    public void logOut() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }

    public void scrollToTheBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public void scrollToTopOfThePageWithoutClickingArrow()
    {
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.getWebDriver();
        js.executeScript("window.scrollTo(0, 0);");
        WebDriverWait wait = new WebDriverWait(BaseClass.getWebDriver(), Duration.ofSeconds(10));
        wait.until((WebDriver d) -> (Boolean) js.executeScript("return window.scrollY == 0"));
    }

    public boolean isSubscribtionVisible() {
        return BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).isDisplayed();
    }

    public void clickingOnTheUPArrow()
    {
        BaseClass.getWebDriver().findElement(By.id("scrollUp")).click();
    }
    public void clickingContactingUs() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a")).click();
    }

    public void clickingOnTestCases() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a")).click();
    }

    public void openHomePage() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img")).click();
    }

    public void openProductsPage() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
    }
    public void deleteAccount()
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
    }
    public void clickingContinueAfterDeletingAccount()
    {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
    }
}