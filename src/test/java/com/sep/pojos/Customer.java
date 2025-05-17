package com.sep.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Customer {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("referral_source")
    private String referralSource;

    @JsonProperty("parent")
    private Parent parent;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public class Parent {

        @JsonProperty("parentFirstName")
        private String parentFirstName;

        @JsonProperty("parentLastName")
        private String parentLastName;

        @JsonProperty("parentEmail")
        private String parentEmail;

        @JsonProperty("parentPhoneNumber")
        private String parentPhoneNumber;

    }

}