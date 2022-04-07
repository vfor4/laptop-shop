
package com.laptopshop.models;

import java.util.HashMap;
import java.util.List;
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
    "payment_type_id",
    "note",
    "required_note",
    "return_phone",
    "return_address",
    "return_district_id",
    "return_ward_code",
    "client_order_code",
    "to_name",
    "to_phone",
    "to_address",
    "to_ward_code",
    "to_district_id",
    "cod_amount",
    "content",
    "weight",
    "length",
    "width",
    "height",
    "pick_station_id",
    "deliver_station_id",
    "insurance_value",
    "service_id",
    "service_type_id",
    "coupon",
    "pick_shift",
    "items"
})
@Generated("jsonschema2pojo")
public class OrderRequest {

    @JsonProperty("payment_type_id")
    private Integer paymentTypeId;
    @JsonProperty("note")
    private String note;
    @JsonProperty("required_note")
    private String requiredNote;
    @JsonProperty("return_phone")
    private String returnPhone;
    @JsonProperty("return_address")
    private String returnAddress;
    @JsonProperty("return_district_id")
    private Object returnDistrictId;
    @JsonProperty("return_ward_code")
    private String returnWardCode;
    @JsonProperty("client_order_code")
    private String clientOrderCode;
    @JsonProperty("to_name")
    private String toName;
    @JsonProperty("to_phone")
    private String toPhone;
    @JsonProperty("to_address")
    private String toAddress;
    @JsonProperty("to_ward_code")
    private String toWardCode;
    @JsonProperty("to_district_id")
    private Integer toDistrictId;
    @JsonProperty("cod_amount")
    private Integer codAmount;
    @JsonProperty("content")
    private String content;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("length")
    private Integer length;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("pick_station_id")
    private Integer pickStationId;
    @JsonProperty("deliver_station_id")
    private Object deliverStationId;
    @JsonProperty("insurance_value")
    private Integer insuranceValue;
    @JsonProperty("service_id")
    private Integer serviceId;
    @JsonProperty("service_type_id")
    private Integer serviceTypeId;
    @JsonProperty("coupon")
    private Object coupon;
    @JsonProperty("pick_shift")
    private List<Integer> pickShift;
    @JsonProperty("items")
    private List<Item> items;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("payment_type_id")
    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    @JsonProperty("payment_type_id")
    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("required_note")
    public String getRequiredNote() {
        return requiredNote;
    }

    @JsonProperty("required_note")
    public void setRequiredNote(String requiredNote) {
        this.requiredNote = requiredNote;
    }

    @JsonProperty("return_phone")
    public String getReturnPhone() {
        return returnPhone;
    }

    @JsonProperty("return_phone")
    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone;
    }

    @JsonProperty("return_address")
    public String getReturnAddress() {
        return returnAddress;
    }

    @JsonProperty("return_address")
    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    @JsonProperty("return_district_id")
    public Object getReturnDistrictId() {
        return returnDistrictId;
    }

    @JsonProperty("return_district_id")
    public void setReturnDistrictId(Object returnDistrictId) {
        this.returnDistrictId = returnDistrictId;
    }

    @JsonProperty("return_ward_code")
    public String getReturnWardCode() {
        return returnWardCode;
    }

    @JsonProperty("return_ward_code")
    public void setReturnWardCode(String returnWardCode) {
        this.returnWardCode = returnWardCode;
    }

    @JsonProperty("client_order_code")
    public String getClientOrderCode() {
        return clientOrderCode;
    }

    @JsonProperty("client_order_code")
    public void setClientOrderCode(String clientOrderCode) {
        this.clientOrderCode = clientOrderCode;
    }

    @JsonProperty("to_name")
    public String getToName() {
        return toName;
    }

    @JsonProperty("to_name")
    public void setToName(String toName) {
        this.toName = toName;
    }

    @JsonProperty("to_phone")
    public String getToPhone() {
        return toPhone;
    }

    @JsonProperty("to_phone")
    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    @JsonProperty("to_address")
    public String getToAddress() {
        return toAddress;
    }

    @JsonProperty("to_address")
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    @JsonProperty("to_ward_code")
    public String getToWardCode() {
        return toWardCode;
    }

    @JsonProperty("to_ward_code")
    public void setToWardCode(String toWardCode) {
        this.toWardCode = toWardCode;
    }

    @JsonProperty("to_district_id")
    public Integer getToDistrictId() {
        return toDistrictId;
    }

    @JsonProperty("to_district_id")
    public void setToDistrictId(Integer toDistrictId) {
        this.toDistrictId = toDistrictId;
    }

    @JsonProperty("cod_amount")
    public Integer getCodAmount() {
        return codAmount;
    }

    @JsonProperty("cod_amount")
    public void setCodAmount(Integer codAmount) {
        this.codAmount = codAmount;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonProperty("length")
    public Integer getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(Integer length) {
        this.length = length;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("pick_station_id")
    public Integer getPickStationId() {
        return pickStationId;
    }

    @JsonProperty("pick_station_id")
    public void setPickStationId(Integer pickStationId) {
        this.pickStationId = pickStationId;
    }

    @JsonProperty("deliver_station_id")
    public Object getDeliverStationId() {
        return deliverStationId;
    }

    @JsonProperty("deliver_station_id")
    public void setDeliverStationId(Object deliverStationId) {
        this.deliverStationId = deliverStationId;
    }

    @JsonProperty("insurance_value")
    public Integer getInsuranceValue() {
        return insuranceValue;
    }

    @JsonProperty("insurance_value")
    public void setInsuranceValue(Integer insuranceValue) {
        this.insuranceValue = insuranceValue;
    }

    @JsonProperty("service_id")
    public Integer getServiceId() {
        return serviceId;
    }

    @JsonProperty("service_id")
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @JsonProperty("service_type_id")
    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    @JsonProperty("service_type_id")
    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    @JsonProperty("coupon")
    public Object getCoupon() {
        return coupon;
    }

    @JsonProperty("coupon")
    public void setCoupon(Object coupon) {
        this.coupon = coupon;
    }

    @JsonProperty("pick_shift")
    public List<Integer> getPickShift() {
        return pickShift;
    }

    @JsonProperty("pick_shift")
    public void setPickShift(List<Integer> pickShift) {
        this.pickShift = pickShift;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "OrderRequest [additionalProperties=" + additionalProperties + ", clientOrderCode=" + clientOrderCode
                + ", codAmount=" + codAmount + ", content=" + content + ", coupon=" + coupon + ", deliverStationId="
                + deliverStationId + ", height=" + height + ", insuranceValue=" + insuranceValue + ", items=" + items
                + ", length=" + length + ", note=" + note + ", paymentTypeId=" + paymentTypeId + ", pickShift="
                + pickShift + ", pickStationId=" + pickStationId + ", requiredNote=" + requiredNote + ", returnAddress="
                + returnAddress + ", returnDistrictId=" + returnDistrictId + ", returnPhone=" + returnPhone
                + ", returnWardCode=" + returnWardCode + ", serviceId=" + serviceId + ", serviceTypeId=" + serviceTypeId
                + ", toAddress=" + toAddress + ", toDistrictId=" + toDistrictId + ", toName=" + toName + ", toPhone="
                + toPhone + ", toWardCode=" + toWardCode + ", weight=" + weight + ", width=" + width + "]";
    }
    

}
