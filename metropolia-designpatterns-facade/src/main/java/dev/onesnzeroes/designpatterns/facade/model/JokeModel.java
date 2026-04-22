package dev.onesnzeroes.designpatterns.facade.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JokeModel {

    @JsonProperty("icon_url")
    private String iconUrl;
    private String id;
    private String url;
    private String value;

    public JokeModel(){}

    public JokeModel(String iconUrl, String id, String url, String value) {
        this.iconUrl = iconUrl;
        this.id = id;
        this.url = url;
        this.value = value;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JokeModel{" +
                "iconUrl='" + iconUrl + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

