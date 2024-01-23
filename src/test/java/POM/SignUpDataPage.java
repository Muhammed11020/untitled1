package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SignUpDataPage {
    public void selectSignUPGender(int ge) {
        if (ge == 1)
            BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
        else if (ge == 2)
            BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
    }

    public void enterSignUpPassword(String pass) {
        BaseClass.getWebDriver().findElement(By.id("password")).sendKeys(pass);
    }

    public void enterSignUpDateOfBirth(int day, int month, String year) {
        Select dropdown = new Select(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"days\"]")));
        dropdown.selectByIndex(day);
        dropdown = new Select(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"months\"]")));
        dropdown.selectByIndex(month);
        dropdown = new Select(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"years\"]")));
        dropdown.selectByValue(year);
    }

    public void checkNewsletter() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[6]/label")).click();
    }

    public void checkReceiveOffers() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]/label")).click();
    }

    public void enterFirstName(String name) {
        BaseClass.getWebDriver().findElement(By.id("first_name")).sendKeys(name);
    }

    public void enterLastName(String lName) {
        BaseClass.getWebDriver().findElement(By.id("last_name")).sendKeys(lName);
    }

    public void enterCompanyName(String comp) {
        BaseClass.getWebDriver().findElement(By.id("company")).sendKeys(comp);
    }

    public void enterAddress1(String address) {
        BaseClass.getWebDriver().findElement(By.id("address1")).sendKeys(address);
    }

    public void enterAddress2(String address) {
        BaseClass.getWebDriver().findElement(By.id("address2")).sendKeys(address);
    }

    public void selectCountry(String country) {
        Select dropdown = new Select(BaseClass.getWebDriver().findElement(By.id("country")));
        dropdown.selectByVisibleText(country);
    }

    public void enterState(String state) {
        BaseClass.getWebDriver().findElement(By.id("state")).sendKeys(state);
    }

    public void enterCity(String city) {
        BaseClass.getWebDriver().findElement(By.id("city")).sendKeys(city);
    }

    public void enterZipCode(String zipCode) {
        BaseClass.getWebDriver().findElement(By.id("zipcode")).sendKeys(zipCode);
    }

    public void enterMobilePhone(String mobile) {
        BaseClass.getWebDriver().findElement(By.id("mobile_number")).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
    }

    public void  clickingContinueAfterEnteringData() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
    }
}
