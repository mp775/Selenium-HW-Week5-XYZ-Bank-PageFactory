package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccountTab;

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerDropdown;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processBtn;


    public void clickOnOpenAccountTab() {
        clickOnElement(openAccountTab);
        CustomListeners.test.log(Status.PASS,"Click on open account tab");

    }

    public void selectCustomerFromDropdown(String customerName) {
        selectByVisibleTextFromDropDown(customerDropdown, customerName);
        CustomListeners.test.log(Status.PASS,"Select customer from dropdown");

    }

    public void selectCurrencyFromDropdown(String currency) {
        selectByVisibleTextFromDropDown(currencyDropdown, currency);
        CustomListeners.test.log(Status.PASS,"Select currency from dropdown");
    }

    public void clickOnProcessButton() {
        clickOnElement(processBtn);
        CustomListeners.test.log(Status.PASS,"Click on process button");
    }
}
