package com.sep.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown =true)
@JsonPropertyOrder({
        "available",
        "productName",
        "productId",
        "teen",
        "type",
        "programId",
        "program_code",
        "program_name",
        "start_date",
        "refund_date",
        "external_url",
        "terms",
        "prices"
})
public class Product {

    @JsonProperty("available")
    private String available;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("teen")
    private String teen;

    @JsonProperty("type")
    private String type;

    @JsonProperty("programId")
    private int programId;

    @JsonProperty("programCode")
    private String programCode;

    @JsonProperty("programName")
    private String programName;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("refundDate")
    private String refundDate;

    @JsonProperty("externalUrl")
    private String externalUrl;

    @JsonProperty("terms")
    private String terms;

    @JsonProperty("prices")
    private List<Price> prices;


    @JsonIgnoreProperties(ignoreUnknown =true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "active",
            "baseAmount",
            "type",
            "upfrontDiscount",
            "upfrontDiscountAmount",
            "allowCoupons",
            "couponDiscount",
            "numberOfInstallments"
    })
    @Data
    public static class Price {

        @JsonProperty("active")
        private boolean active;

        @JsonProperty("productName")
        private int baseAmount;

        @JsonProperty("type")
        private String type;

        @JsonProperty("upfrontDiscount")
        private boolean upfrontDiscount;

        @JsonProperty("upfrontDiscountAmount")
        private int upfrontDiscountAmount;

        @JsonProperty("allowCoupons")
        private Boolean allowCoupons;

        @JsonProperty("couponDiscount")
        private Integer couponDiscount;

        @JsonProperty("numberOfInstallments")
        private int numberOfInstallments;


    }


}
