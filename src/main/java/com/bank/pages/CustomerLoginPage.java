package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement yourNameDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutBtn;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameLabel;


    public void searchCustomerName(String customerName) {
        selectByVisibleTextFromDropDown(yourNameDropdown, customerName);
        CustomListeners.test.log(Status.PASS,"Search customer name" +customerName);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"Click on login Button");
    }

    public String verifyLogoutButtonIsDisplayed() {
        String text = getTextFromElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"Verify logo button is displayed");
        return  text;

    }

    public void clickOnLogOut() {
        clickOnElement(logoutBtn);
        CustomListeners.test.log(Status.PASS,"Click on Logout");

    }

    public String verifyYourNameTextIsDisplayed() {
        String name =getTextFromElement(yourNameLabel);
        CustomListeners.test.log(Status.PASS,"Verify your name is displayed");
        return name;
    }

}
