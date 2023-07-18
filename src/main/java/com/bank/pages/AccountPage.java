package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawalTab;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountTextField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawalBtn;

    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement transactionsText;


    public void clickOnWithdrawalTab() {
        clickOnElement(withdrawalTab);
        CustomListeners.test.log(Status.PASS,"Click on withdrawal tab");
    }

    public void enterAmountToBeWithdrawal(String amount) {
        clearTextFromField(amountTextField);
        sendTextToElement(amountTextField, amount);
        CustomListeners.test.log(Status.PASS,"Enter amount to be withdrawal");
    }

    public void clickOnWithdrawalButton() {
        clickOnElement(withdrawalBtn);
        CustomListeners.test.log(Status.PASS,"Click on withdrawal button");
    }

    public String verifyTransactionSuccessMessage() {
        String message =getTextFromElement(transactionsText);
        CustomListeners.test.log(Status.PASS,"Verify transaction success message");
        return message;

    }
}
