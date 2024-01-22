package POM;

import org.openqa.selenium.By;

public class LoginAndSignUpPage {
    public void enterSignNewName(String name) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(name);
    }

    public void enterSignUpNewMail(String mail) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys(mail);
    }

    public void clickingSignUPButton() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
    }

    public void enterSignInMail(String mail) {
        if (!(BaseClass.getWebDriver().findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")).getAttribute("value").isEmpty())) {
            BaseClass.getWebDriver().findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")).clear();
            BaseClass.getWebDriver().findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")).sendKeys(mail);
        } else
            BaseClass.getWebDriver().findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")).sendKeys(mail);
    }

    public void enterSignInPassword(String pass) {
        if (!(BaseClass.getWebDriver().findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)")).getAttribute("value").isEmpty()))
            BaseClass.getWebDriver().findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)")).clear();
        BaseClass.getWebDriver().findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)")).sendKeys(pass);
    }

    public void clickLoginButton() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
    }
}
