package com.sep.step_definition.getting_started;

import com.sep.pages.StartApplicationPage;
import com.sep.utilities.BrowserUtils;
import com.sep.utilities.QaDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProgramStartAndRefundDates {

    private StartApplicationPage startApplicationPage = new StartApplicationPage();

    @Then("the start date for the program is displayed")
    public void theStartDateForTheProgramIsDisplayed() {
        BrowserUtils.waitForVisibility(startApplicationPage.programStartDate, 10);
        assert startApplicationPage.programStartDate.isDisplayed();
    }

    @And("the refund date for the program is displayed")
    public void theRefundDateForTheProgramIsDisplayed() {
        BrowserUtils.waitForVisibility(startApplicationPage.refundEndDate, 10);
        assert startApplicationPage.refundEndDate.isDisplayed();
    }

    @Then("the displayed program start date of {string}  is correct")
    public void theDisplayedProgramStartDateOfIsCorrect(String arg0) {
       String expectedStartDate = QaDataReader.getSingleProduct(arg0).getStartDate();
       BrowserUtils.waitForVisibility(startApplicationPage.programStartDate, 10);
       BrowserUtils.waitFor(1);
       String actualStartDate = startApplicationPage.programStartDate.getText();
       assert expectedStartDate.equals(actualStartDate);

    }

    @Then("the displayed program refund date of {string} is correct")
    public void theDisplayedProgramRefundDateOfIsCorrect(String arg0) {
        String expectedRefundDate = QaDataReader.getSingleProduct(arg0).getRefundDate();
        BrowserUtils.waitForVisibility(startApplicationPage.refundEndDate, 10);
        BrowserUtils.waitFor(1);
        String actualRefundDate = startApplicationPage.refundEndDate.getText();
        assert expectedRefundDate.equals(actualRefundDate);
    }

}
