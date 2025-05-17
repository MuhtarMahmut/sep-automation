package com.sep.step_definition.submitting_payments;

import com.sep.pages.PaymentPlanPage;
import com.sep.pages.ReviewPlanPage;
import com.sep.utilities.BrowserUtils;
import com.sep.utilities.DriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FailedPaymentsErrorMessages {

    private PaymentPlanPage paymentPlanPage = new PaymentPlanPage();
    private ReviewPlanPage reviewPlanPage = new ReviewPlanPage();

    @Given("the user already completed step one and selected Upfront payment option")
    public void the_user_already_completed_step_one_and_selected_upfront_payment_option() {
       // new ClickOnNextButtonStep2().the_user_has_completed_step_one_with_valid_information();

        BrowserUtils.waitForVisibility(paymentPlanPage.upfrontPaymentOption, 10);
        paymentPlanPage.upfrontPaymentOption.click();

        BrowserUtils.waitForVisibility(paymentPlanPage.basePriceAmountUnderUpfront, 10);
        BrowserUtils.waitFor(1);

        BrowserUtils.scrollToElement(paymentPlanPage.activeNextButton);
        BrowserUtils.waitFor(1);

        BrowserUtils.waitForClickablility(paymentPlanPage.activeNextButton, 10);
        paymentPlanPage.activeNextButton.click();
    }

    @When("the user enters invalid card number {string}")
    public void the_user_enters_invalid_card_number(String string) {
        BrowserUtils.waitForVisibility(reviewPlanPage.paymentFrame, 10);
        DriverUtils.getDriver().switchTo().frame(reviewPlanPage.paymentFrame);
        reviewPlanPage.cardNumberInput.sendKeys(string);

    }

    @Then("the user should see an error message saying {string}")
    public void the_user_should_see_an_error_message_saying(String string) {
        reviewPlanPage.expiryDateInput.click();
        BrowserUtils.waitForVisibility(reviewPlanPage.cardNumberErrorMessage, 10);
        System.out.println(reviewPlanPage.cardNumberErrorMessage.getText());
        assert reviewPlanPage.cardNumberErrorMessage.getText().equalsIgnoreCase(string);
    }

    @When("the user enters an incomplete card number {string}")
    public void the_user_enters_an_incomplete_card_number(String string) {
        BrowserUtils.waitForVisibility(reviewPlanPage.paymentFrame, 10);
        DriverUtils.getDriver().switchTo().frame(reviewPlanPage.paymentFrame);
        reviewPlanPage.cardNumberInput.sendKeys(string);
    }


}
