package com.bank.testsuite;
import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    AccountPage accountPage;

    @BeforeMethod(groups = { "sanity", "smoke","regression","regression1"})
    public void inIt(){
       homePage = new HomePage();
       addCustomerPage = new AddCustomerPage();
       openAccountPage = new OpenAccountPage();
       customersPage = new CustomersPage();
       customerLoginPage = new CustomerLoginPage();
       accountPage = new AccountPage();
    }

    @Test(groups = {"sanity"})
    public void bankManagerShouldAddCustomerSuccessfully() {

        homePage.clickOnBankManagerLoginTab();
        addCustomerPage.clickOnAddCustomerTab();
        addCustomerPage.fillAddCustomerForm();
        addCustomerPage.clickOnAddCustomerButton();
        String expectedAlertMessage = "Customer added successfully";
        String actualAlertMessage = getTextFromAlert();
        System.out.println("Alert Popup Notification : " + actualAlertMessage);
        Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage), "Customer added successfully message validation failed");
        acceptAlert();
    }

    @Test(groups = {"smoke"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLoginTab();
        openAccountPage.clickOnOpenAccountTab();
        openAccountPage.selectCustomerFromDropdown("Ron Weasly");
        openAccountPage.selectCurrencyFromDropdown("Pound");
        openAccountPage.clickOnProcessButton();
        String expectedAlertMessage = "Account created successfully";
        String actualAlertMessage = getTextFromAlert();
        System.out.println("Alert Popup Notification : " + actualAlertMessage);
        Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage), "Account created successfully message validation failed");
        acceptAlert();
    }

    @Test(groups = {"regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchCustomerName("Hermoine Granger");
        customerLoginPage.clickOnLoginButton();
        Thread.sleep(2000);
        String expectedText = "Logout";
        Assert.assertEquals(customerLoginPage.verifyLogoutButtonIsDisplayed(), expectedText, "Logout text is not displayed");
        customerLoginPage.clickOnLogOut();
        String expectedYourNameText = "Your Name :";
        Assert.assertEquals(customerLoginPage.verifyYourNameTextIsDisplayed(), expectedYourNameText, "Your Name text is not displayed");
    }

    @Test(groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchCustomerName("Hermoine Granger");
        customerLoginPage.clickOnLoginButton();
        customersPage.clickOnDepositBtn();
        customersPage.enterAmountToBeDeposit("1000");
        customersPage.clickOnDepositButton();
        String expectedAmountSubmitMessage = "Deposit Successful";
        String actualAmountSubmitMessage = customersPage.verifyDepositSuccessMessage();
        Assert.assertEquals(actualAmountSubmitMessage, expectedAmountSubmitMessage, "Deposit Successful message validation failed");
    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchCustomerName("Hermoine Granger");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawalTab();
        accountPage.enterAmountToBeWithdrawal("50");
        accountPage.clickOnWithdrawalButton();
        String expectedTransitionMessage = "Transaction successful";
        String actualTransitionMessage = accountPage.verifyTransactionSuccessMessage();
        Assert.assertEquals(actualTransitionMessage,expectedTransitionMessage,"Transaction Successful message verification failed");
    }
}
