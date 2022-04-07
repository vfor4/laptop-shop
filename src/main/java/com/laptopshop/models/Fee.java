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
    "main_service",
    "insurance",
    "station_do",
    "station_pu",
    "return",
    "r2s",
    "coupon"
})
@Generated("jsonschema2pojo")
public class Fee {

    @JsonProperty("main_service")
    private Integer mainService;
    @JsonProperty("insurance")
    private Integer insurance;
    @JsonProperty("station_do")
    private Integer stationDo;
    @JsonProperty("station_pu")
    private Integer stationPu;
    @JsonProperty("return")
    private Integer _return;
    @JsonProperty("r2s")
    private Integer r2s;
    @JsonProperty("coupon")
    private Integer coupon;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("main_service")
    public Integer getMainService() {
        return mainService;
    }

    @JsonProperty("main_service")
    public void setMainService(Integer mainService) {
        this.mainService = mainService;
    }

    @JsonProperty("insurance")
    public Integer getInsurance() {
        return insurance;
    }

    @JsonProperty("insurance")
    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    @JsonProperty("station_do")
    public Integer getStationDo() {
        return stationDo;
    }

    @JsonProperty("station_do")
    public void setStationDo(Integer stationDo) {
        this.stationDo = stationDo;
    }

    @JsonProperty("station_pu")
    public Integer getStationPu() {
        return stationPu;
    }

    @JsonProperty("station_pu")
    public void setStationPu(Integer stationPu) {
        this.stationPu = stationPu;
    }

    @JsonProperty("return")
    public Integer getReturn() {
        return _return;
    }

    @JsonProperty("return")
    public void setReturn(Integer _return) {
        this._return = _return;
    }

    @JsonProperty("r2s")
    public Integer getR2s() {
        return r2s;
    }

    @JsonProperty("r2s")
    public void setR2s(Integer r2s) {
        this.r2s = r2s;
    }

    @JsonProperty("coupon")
    public Integer getCoupon() {
        return coupon;
    }

    @JsonProperty("coupon")
    public void setCoupon(Integer coupon) {
        this.coupon = coupon;
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
