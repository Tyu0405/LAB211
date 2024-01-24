/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Country;

/**
 *
 * @author ROG
 */
public class EastAsiaCountries extends Country{
    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String getCountryName() {
        return countryName;
    }

    @Override
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public float getTotalArea() {
        return totalArea;
    }

    @Override
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    
    
    @Override
    public void display(){
        System.out.format("%10s%30s%30s%10s\n", this.countryCode,this.countryName,this.totalArea,this.countryTerrain);
    }
}
