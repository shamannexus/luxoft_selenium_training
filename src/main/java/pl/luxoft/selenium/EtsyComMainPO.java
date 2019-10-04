package pl.luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsyComMainPO extends BasePO{


    PrivacyModelPO policyModal;


    public EtsyComMainPO(WebDriver driver){
        super(driver);
        policyModal = new PrivacyModelPO(driver);
    }

    public EtsyComMainPO goTo()
    {
        driver.get("https://www.etsy.com/");
        return this;
    }

    public EtsyComMainPO acceptPrivacyPolicy() {
        policyModal.acceptPolicy();
        return this;
    }


    protected WebElement findElementWithWait(By locator) {
        return super.findElementWithWait(locator);
    }

  //  public EtsyComMainPO searchFor(String query) {
    //    enterSearchQuery(query);
     //   return this;
  //  }


}
