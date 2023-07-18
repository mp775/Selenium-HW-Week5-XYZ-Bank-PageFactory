package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomerTab;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameTextField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameTextField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCodeTextField;

    @CacheLookup
    @FindBy(xpath = "//button[@type = 'submit' and contains(text(),'Add Customer')]")
    WebElement addCustomerBtn;

    String firstName;
    String lastName;
    String postCode;


    public void clickOnAddCustomerTab() {
        clickOnElement(addCustomerTab);
        CustomListeners.test.log(Status.PASS,"Click on customer tab");
    }

    public String getFirstName(int length) {
        firstName = getRandomString(length);
        return firstName;
    }

    public String getLastName(int length) {
        lastName = getRandomString(length);
        return lastName;
    }

    public String getPostCode(int length) {
        postCode = getRandomString(length);
        return postCode;
    }

    public void fillAddCustomerForm() {
        sendTextToElement(firstNameTextField, getFirstName(4));
        sendTextToElement(lastNameTextField, getLastName(8));
        sendTextToElement(postCodeTextField, getPostCode(6));
    }

    public void clickOnAddCustomerButton() {

        clickOnElement(addCustomerBtn);
        CustomListeners.test.log(Status.PASS,"Click on add customer button");

    }
}


