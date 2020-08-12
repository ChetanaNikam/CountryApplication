package com.country.countryapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CountryModel implements Serializable {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("geonameid")
    @Expose
    private Integer geonameid;
    @SerializedName("independent")
    @Expose
    private Boolean independent;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("total_adm_divisions")
    @Expose
    private Integer totalAdmDivisions;
    @SerializedName("total_cities")
    @Expose
    private Integer totalCities;
    @SerializedName("total_iso_divisions")
    @Expose
    private Integer totalIsoDivisions;public String getCode() {
        return code;
    }

    public Integer getGeonameid() {
        return geonameid;
    }

    public void setGeonameid(Integer geonameid) {
        this.geonameid = geonameid;
    }

    public Integer getTotalAdmDivisions() {
        return totalAdmDivisions;
    }

    public void setTotalAdmDivisions(Integer totalAdmDivisions) {
        this.totalAdmDivisions = totalAdmDivisions;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIndependent() {
        return independent;
    }

    public void setIndependent(Boolean independent) {
        this.independent = independent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getTotalCities() {
        return totalCities;
    }

    public void setTotalCities(Integer totalCities) {
        this.totalCities = totalCities;
    }

    public Integer getTotalIsoDivisions() {
        return totalIsoDivisions;
    }

    public void setTotalIsoDivisions(Integer totalIsoDivisions) {
        this.totalIsoDivisions = totalIsoDivisions;
    }
}
