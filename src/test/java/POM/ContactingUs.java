package POM;

import org.openqa.selenium.By;

public class ContactingUs {
    public void enteringName(String name) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys(name);
    }

    public void enteringEmail(String email) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys(email);
    }

    public void enteringSubject(String subject) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys(subject);
    }

    public void enteringMessage(String msg) {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"message\"]")).sendKeys(msg);
    }

    public void clickingSubmitButton() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).click();
    }

    public void clickingHomeAfterCantactingUS() {
        BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"form-section\"]/a")).click();
    }
}
