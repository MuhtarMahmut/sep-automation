package com.sep.step_definition.payment_plans;

import com.sep.pages.PaymentPlanPage;
import com.sep.pages.StartApplicationPage;
import com.sep.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ClickNextButtonPaymentPlanPage {
    private StartApplicationPage startApplicationPage = new StartApplicationPage();
    private PaymentPlanPage paymentPlanPage = new PaymentPlanPage();

    @Given("the user is on the enrollment page {string}")
    public void the_user_is_on_the_enrollment_page(String string) {
        startApplicationPage.logIn(string);

    }

    @Given("the user has completed step one with valid information")
    public void the_user_has_completed_step_one_with_valid_information() {

        BrowserUtils.waitForVisibility(startApplicationPage.firstNameInputBox, 10);
        startApplicationPage.firstNameInputBox.clear();
        startApplicationPage.firstNameInputBox.sendKeys("James");

        BrowserUtils.waitForVisibility(startApplicationPage.lastNameInputBox, 10);
        startApplicationPage.lastNameInputBox.clear();
        startApplicationPage.lastNameInputBox.sendKeys("Bond");

        BrowserUtils.waitForVisibility(startApplicationPage.emailInputBox, 10);
        startApplicationPage.emailInputBox.clear();
        startApplicationPage.emailInputBox.sendKeys("James_Bond@gmail.com");

        BrowserUtils.waitForVisibility(startApplicationPage.phoneNumberInputBox, 10);
        startApplicationPage.phoneNumberInputBox.clear();
        startApplicationPage.phoneNumberInputBox.sendKeys("1234567890");

        BrowserUtils.scrollToElement(startApplicationPage.nextButton);
        BrowserUtils.waitFor(1);

        BrowserUtils.waitForVisibility(startApplicationPage.howDidYouHearAboutUsDropDown, 10);
        startApplicationPage.howDidYouHearAboutUsDropDown.click();

        BrowserUtils.waitForVisibility(startApplicationPage.googleOption, 10);
        startApplicationPage.googleOption.click();

        BrowserUtils.scrollToElement(startApplicationPage.nextButton);
        BrowserUtils.waitFor(1);

        BrowserUtils.waitForClickablility(startApplicationPage.nextButton, 10);
        assert startApplicationPage.nextButton.isEnabled();
        startApplicationPage.nextButton.click();


    }

    @Given("the user is on step two of the enrollment process")
    public void the_user_is_on_step_two_of_the_enrollment_process() {
        BrowserUtils.waitForVisibility(paymentPlanPage.chooseAPaymentPlanText, 10);
        assert paymentPlanPage.chooseAPaymentPlanText.isDisplayed();
    }

    @Then("the next button should be displayed")
    public void the_next_button_should_be_displayed() {
        BrowserUtils.waitForVisibility(paymentPlanPage.inactiveNextButton, 10);
        assert paymentPlanPage.inactiveNextButton.isDisplayed();
    }

    @Then("the next button should be inactive by default")
    public void the_next_button_should_be_inactive_by_default() {
        assert !paymentPlanPage.inactiveNextButton.isEnabled();
    }


    @When("the user selects the Upfront payment plan")
    public void the_user_selects_the_upfront_payment_plan() {
        BrowserUtils.waitForVisibility(paymentPlanPage.upfrontPaymentOption, 10);
        paymentPlanPage.upfrontPaymentOption.click();
    }

    @Then("the next button becomes active")
    public void the_next_button_becomes_active() {
        BrowserUtils.waitForVisibility(paymentPlanPage.activeNextButton, 10);
        paymentPlanPage.activeNextButton.isDisplayed();
    }

}
