package com.sep.pojos;

import com.sep.pojos.prices.data.Receipt;

/**
 * This class represents a coupon that can be used to get a discount on a purchase.
 *
 * @author Sep
 */
public class Coupon {

    /**
     * The promo code that is used to validate the coupon.
     */
    private String promoCode;

    /**
     * A boolean indicating whether the coupon is valid or not.
     */
    private boolean isValid;

    /**
     * A message that explains the status of the coupon.
     */
    private String message;

    /**
     * The discount amount that is applied to the purchase if the coupon is valid.
     */
    private int couponDiscount;

    /**
     * The receipt that contains the details of the purchase for which the coupon is applied.
     */
    private Receipt receipt;

    /**
     * Returns the promo code of the coupon.
     *
     * @return the promo code
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the promo code of the coupon.
     *
     * @param promoCode the promo code
     */
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    /**
     * Returns a boolean indicating whether the coupon is valid or not.
     *
     * @return true if the coupon is valid, false otherwise
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Sets the validity of the coupon.
     *
     * @param valid true if the coupon is valid, false otherwise
     */
    public void setValid(boolean valid) {
        isValid = valid;
    }

    /**
     * Returns a message that explains the status of the coupon.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message that explains the status of the coupon.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the discount amount that is applied to the purchase if the coupon is valid.
     *
     * @return the discount amount
     */
    public int getCouponDiscount() {
        return couponDiscount;
    }

    /**
     * Sets the discount amount that is applied to the purchase if the coupon is valid.
     *
     * @param couponDiscount the discount amount
     */
    public void setCouponDiscount(int couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     * Returns the receipt that contains the details of the purchase for which the coupon is applied.
     *
     * @return the receipt
     */
    public Receipt getReceipt() {
        return receipt;
    }

    /**
     * Sets the receipt that contains the details of the purchase for which the coupon is applied.
     *
     * @param receipt the receipt
     */
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "promoCode='" + promoCode + '\'' +
                ", isValid=" + isValid +
                ", message='" + message + '\'' +
                ", couponDiscount=" + couponDiscount +
                ", receipt=" + receipt +
                '}';
    }
}
