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
    "code",
    "code_message_value",
    "data",
    "message",
    "message_display"
})
@Generated("jsonschema2pojo")
public class OrderResponse {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("code_message_value")
    private String codeMessageValue;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("message")
    private String message;
    @JsonProperty("message_display")
    private String messageDisplay;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("code_message_value")
    public String getCodeMessageValue() {
        return codeMessageValue;
    }

    @JsonProperty("code_message_value")
    public void setCodeMessageValue(String codeMessageValue) {
        this.codeMessageValue = codeMessageValue;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("message_display")
    public String getMessageDisplay() {
        return messageDisplay;
    }

    @JsonProperty("message_display")
    public void setMessageDisplay(String messageDisplay) {
        this.messageDisplay = messageDisplay;
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
