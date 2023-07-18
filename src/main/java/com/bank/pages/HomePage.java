package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginTab;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginTab;


    public void clickOnBankManagerLoginTab()  {
        clickOnElement(bankManagerLoginTab);
        CustomListeners.test.log(Status.PASS,"Click onBankManager login tab");
    }

    public void clickOnCustomerLoginTab() {
        clickOnElement(customerLoginTab);
        CustomListeners.test.log(Status.PASS,"Click on Customer login tab");
    }
}