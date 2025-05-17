package com.sep.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPlanPage extends BasePage{
    @FindBy(xpath = "//*[text()='Choose a payment plan']")
    public WebElement chooseAPaymentPlanText;

    @FindBy(xpath = "//span[@class='payment-type'][contains(text(),'Upfront')]")
    public WebElement upfrontPaymentOption;


    @FindBy(xpath = "//span[@class='discount-price']")
    public WebElement upfrontPaymentAmount;

    @FindBy(xpath = "//span[@class='discount-price']/span")
    public WebElement payOnceTextUpFront;

    @FindBy(xpath = "(//mat-expansion-panel-header[@role='button'])[1]")
    public WebElement upfrontPaymentFrame;

    @FindBy(xpath = "//span[@class='chip-content']")
    public WebElement greenBadgeUpfrontDiscount;

    @FindBy(xpath = "//span[@class='chip-content']/span[@class='material-symbols-outlined light-icon']")
    public WebElement greenBadgeElectricBoltUpfrontDiscount;

    @FindBy(xpath = "//span[@class='chip-content']")
    public WebElement greenBadgeTextUpfrontDiscount;

    @FindBy(xpath = "//mat-chip[contains(@class, 'coupon-badge')]")
    public WebElement couponAvailableBadgeUpfrontDiscount;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Base price')]")
    public WebElement basePriceTextUnderUpfront;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Base price')]/following-sibling::span")
    public WebElement basePriceAmountUnderUpfront;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Upfront')]")
    public WebElement upfrontDiscountTextUnderUpfront;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Upfront')]/following-sibling::span")
    public WebElement upfrontDiscountAmountUnderUpfront;

    @FindBy(xpath = "//button[contains(text(), 'I have a promo code')]")
    public WebElement iHaveAPromoCodeButtonUnderUpfront;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/div/span[contains(text(), 'Subtotal')]")
    public WebElement subtotalTextUnderUpfront;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/div/span[contains(text(), 'Subtotal')]/following-sibling::span")
    public WebElement subtotalAmountUnderUpfront;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/i[contains(text(), 'excluding fees')]")
    public WebElement excludingFeesTextUnderUpfront;


    @FindBy(xpath = "//span[@class='payment-type'][contains(text(),'Installments')]")
    public WebElement installmentsPaymentOption;
    @FindBy(xpath = "(//mat-expansion-panel-header[@role='button'])[2]")
    public WebElement installmentsPaymentFrame;

    @FindBy(xpath = "//span[@class='discount-price ng-star-inserted']")
    public WebElement installmentsPaymentAmount;

    @FindBy(xpath = "//span[@class='discount-price ng-star-inserted']/span")
    public WebElement perMonthTextInstallments;

    @FindBy(xpath = "(//mat-chip[contains(@class, 'coupon-badge')])[2]")
    public WebElement couponAvailableBadgeInstallments;

    @FindBy(xpath = "//div[@class='content-panel-item coupon-section ng-star-inserted']/div/span[contains(text(), 'Base price')]")
    public WebElement basePriceTextUnderInstallments;

    @FindBy(xpath = "//div[@class='content-panel-item coupon-section ng-star-inserted']/div/span[contains(text(), 'Base price')]/following-sibling::span")
    public WebElement basePriceAmountUnderInstallments;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Installments')]")
    public WebElement installmentsTextUnderInstallments;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Installments')]/following-sibling::span")
    public WebElement installmentsNumberUnderInstallments;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Price per installment')]")
    public WebElement pricePerInstallmentsTextUnderInstallments;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Price per installment')]/following-sibling::span")
    public WebElement pricePerInstallmentsAmountUnderInstallments;

    @FindBy(xpath = "//span[@class='sub-item-panel ng-star-inserted' and contains(text(), 'Due Today')]")
    public WebElement dueTodayTextUnderInstallments;


    @FindBy(xpath = "//div[@class='fee-items-holder']/span[contains(text(), 'First month')]")
    public WebElement firstMonthPaymentTextUnderInstallments;

    @FindBy(xpath = "//div[@class='fee-items-holder']/span[contains(text(), 'First month')]/following-sibling::span")
    public WebElement firstMonthPaymentAmountUnderInstallments;

    @FindBy(xpath = "(//div[@class='content-panel-item ng-star-inserted']/i[contains(text(), 'excluding fees')])[2]")
    public WebElement excludingFeesTextUnderInstallments;


    @FindBy(xpath = "(//button[contains(text(), 'I have a promo code')])[2]")
    public WebElement iHaveAPromoCodeButtonUnderInstallments;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement inactiveNextButton;
    @FindBy(xpath = "//button[@class = 'next-button' and text()='Next']")
    public WebElement activeNextButton;

    @FindBy(xpath = "//span[@class='back-button']")
    public WebElement backButton;

    @FindBy(xpath = "(//p[@class = 'footer-text' and contains(text(), 'Need help?')])[2]")
    public WebElement footerText;

}
