package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailBoxPage extends AbstractPage{

    @FindBy(id = "refresh")
    private WebElement refreshButton;
    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement estimatedMonthlyCost;
    @FindBy(id = "ifmail")
    private WebElement frame;


    public EmailBoxPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void refreshEmailBox(){
        webElementWaitToBeClickable(refreshButton);
        refreshButton.click();
    }

    public String getEstimatedCostPerMonthFromEmailBox(){
        refreshEmailBox();
        webElementWaitToBeVisible(frame);
        driver.switchTo().frame(frame);
        webElementWaitToBeVisible(estimatedMonthlyCost);
        return estimatedMonthlyCost.getText().replaceAll("[a-zA-Z\\s]","").trim();
    }
}