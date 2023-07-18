package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement depositTab;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount'][1]")
    WebElement amountTextField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositBtn;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessText;


    public void clickOnDepositBtn() {
        clickOnElement(depositTab);
        CustomListeners.test.log(Status.PASS,"Click on deposit button");
    }

    public void enterAmountToBeDeposit(String amount) {
        clearTextFromField(amountTextField);
        sendTextToElement(amountTextField, amount);
        CustomListeners.test.log(Status.PASS,"Enter Amount to be Deposit");
    }

    public void clickOnDepositButton() {
        clickOnElement(depositBtn);
        CustomListeners.test.log(Status.PASS,"Click on Deposit button");

    }

    public String verifyDepositSuccessMessage() {
        String message = getTextFromElement(depositSuccessText);
        CustomListeners.test.log(Status.PASS,"Verify deposit success message");
        return message;

    }
}
