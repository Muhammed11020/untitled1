package Testing;

import POM.BaseClass;
import POM.ContactingUs;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class ContactUsTesting extends BaseClass {
    @Test
    public void ContactingUsTesting() {
        POM.ContactingUs c = new ContactingUs();
        assertEquals("https://automationexercise.com/contact_us", BaseClass.getWebDriver().getCurrentUrl());
        c.enteringName("MuTesting");
        c.enteringEmail("0891c38d7a@emailaoa.pro");
        c.enteringSubject("ContactingUs Subject");
        c.enteringMessage("Message for Contacting Us");
        c.clickingSubmitButton();
        Alert al = BaseClass.getWebDriver().switchTo().alert();
        al.accept();
        assertEquals(BaseClass.getWebDriver().findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")).getText(), "Success! Your details have been submitted successfully.");
        c.clickingHomeAfterCantactingUS();
    }
}
