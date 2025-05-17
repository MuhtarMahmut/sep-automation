package com.sep.pojos.program.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramData {

    @JsonProperty("productId")
    private int productId;

    @JsonProperty("productType")
    private String productType;

    @JsonProperty("productLink")
    private String productLink;

    @JsonProperty("lmsProgramId")
    private int lmsProgramId;

    @JsonProperty("lmsProgramName")
    private String lmsProgramName;

    @JsonProperty("lmsProgramCode")
    private String lmsProgramCode;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("refundDate")
    private String refundDate;

    @JsonProperty("fullPrice")
    private int fullPrice;

    @JsonProperty("discountAmount")
    private int discountAmount;

    @JsonProperty("discountedPrice")
    private int discountedPrice;

    @JsonProperty("isForTeens")
    private boolean isForTeens;

}
