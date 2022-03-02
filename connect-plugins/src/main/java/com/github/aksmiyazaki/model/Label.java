package com.github.aksmiyazaki.model;

import java.util.HashMap;
import java.util.Map;

public class Label {

    private Integer id;
    private String url;
    private String name;
    private String color;
    private Boolean _default;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Label() {
    }

    public Label(Integer id, String url, String name, String color, Boolean _default) {
        super();
        this.id = id;
        this.url = url;
        this.name = name;
        this.color = color;
        this._default = _default;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Boolean getDefault() {
        return _default;
    }

    public void setDefault(Boolean _default) {
        this._default = _default;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
