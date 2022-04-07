package com.laptopshop.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "order_code",
    "sort_code",
    "trans_type",
    "ward_encode",
    "district_encode",
    "fee",
    "total_fee",
    "expected_delivery_time"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("order_code")
    private String orderCode;
    @JsonProperty("sort_code")
    private String sortCode;
    @JsonProperty("trans_type")
    private String transType;
    @JsonProperty("ward_encode")
    private String wardEncode;
    @JsonProperty("district_encode")
    private String districtEncode;
    @JsonProperty("fee")
    private Fee fee;
    @JsonProperty("total_fee")
    private Integer totalFee;
    @JsonProperty("expected_delivery_time")
    private String expectedDeliveryTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("order_code")
    public String getOrderCode() {
        return orderCode;
    }

    @JsonProperty("order_code")
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @JsonProperty("sort_code")
    public String getSortCode() {
        return sortCode;
    }

    @JsonProperty("sort_code")
    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    @JsonProperty("trans_type")
    public String getTransType() {
        return transType;
    }

    @JsonProperty("trans_type")
    public void setTransType(String transType) {
        this.transType = transType;
    }

    @JsonProperty("ward_encode")
    public String getWardEncode() {
        return wardEncode;
    }

    @JsonProperty("ward_encode")
    public void setWardEncode(String wardEncode) {
        this.wardEncode = wardEncode;
    }

    @JsonProperty("district_encode")
    public String getDistrictEncode() {
        return districtEncode;
    }

    @JsonProperty("district_encode")
    public void setDistrictEncode(String districtEncode) {
        this.districtEncode = districtEncode;
    }

    @JsonProperty("fee")
    public Fee getFee() {
        return fee;
    }

    @JsonProperty("fee")
    public void setFee(Fee fee) {
        this.fee = fee;
    }

    @JsonProperty("total_fee")
    public Integer getTotalFee() {
        return totalFee;
    }

    @JsonProperty("total_fee")
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    @JsonProperty("expected_delivery_time")
    public String getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    @JsonProperty("expected_delivery_time")
    public void setExpectedDeliveryTime(String expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
