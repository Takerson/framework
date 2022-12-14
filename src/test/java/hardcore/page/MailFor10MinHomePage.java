package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailFor10MinHomePage extends AbstractPage{
    private static final String MAIL_FOR_10_MIN_PAGE_URL = "https://yopmail.com/ ";

    @FindBy(xpath = "//*[contains(text(),'Случайный адрес электронной почты')]")
    private WebElement generateRandomMail;

    public MailFor10MinHomePage(WebDriver driver){
        super(driver);
    }

    public MailFor10MinHomePage openMailGeneratorPage(){
        driver.get(MAIL_FOR_10_MIN_PAGE_URL);
        return this;
    }

    public GeneratedEmailPage generateAnEmail(){
        generateRandomMail.click();
        return new GeneratedEmailPage(driver);
    }
}
