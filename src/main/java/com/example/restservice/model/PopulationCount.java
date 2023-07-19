package com.example.restservice.model;

public class PopulationCount {
    private String year;
    private String value;
    private String sex;
    private String reliability;

    public PopulationCount() {
    }

    public PopulationCount(String year, String value, String sex, String reliability) {
        this.year = year;
        this.value = value;
        this.sex = sex;
        this.reliability = reliability;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }
}