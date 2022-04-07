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
"message",
"data",
"code_message"
})
@Generated("jsonschema2pojo")
public class ErrorResponse {

@JsonProperty("code")
private Integer code;
@JsonProperty("message")
private String message;
@JsonProperty("data")
private Object data;
@JsonProperty("code_message")
private String codeMessage;
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

@JsonProperty("message")
public String getMessage() {
return message;
}

@JsonProperty("message")
public void setMessage(String message) {
this.message = message;
}

@JsonProperty("data")
public Object getData() {
return data;
}

@JsonProperty("data")
public void setData(Object data) {
this.data = data;
}

@JsonProperty("code_message")
public String getCodeMessage() {
return codeMessage;
}

@JsonProperty("code_message")
public void setCodeMessage(String codeMessage) {
this.codeMessage = codeMessage;
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