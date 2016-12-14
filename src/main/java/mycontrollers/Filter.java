/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycontrollers;

/**
 *
 * @author fred
 */
public class Filter {

    private int mileageFrom;
    private int mileageTo;
    private int year;
    private String make;
    private String model;
    private int sellingPriceFrom;
    private int sellingPriceTo;
    
    public Filter() {
    }

    /**
     * @return the mileageTo
     */
    public int getMileageTo() {
        return mileageTo;
    }

    /**
     * @param mileageTo the mileageTo to set
     */
    public void setMileageTo(int mileageTo) {
        this.mileageTo = mileageTo;
    }

    /**
     * @return the mileageFrom
     */
    public int getMileageFrom() {
        return mileageFrom;
    }

    /**
     * @param mileageFrom the mileageFrom to set
     */
    public void setMileageFrom(int mileageFrom) {
        this.mileageFrom = mileageFrom;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the sellingPriceFrom
     */
    public int getSellingPriceFrom() {
        return sellingPriceFrom;
    }

    /**
     * @param sellingPriceFrom the sellingPriceFrom to set
     */
    public void setSellingPriceFrom(int sellingPriceFrom) {
        this.sellingPriceFrom = sellingPriceFrom;
    }

    /**
     * @return the sellingPriceTo
     */
    public int getSellingPriceTo() {
        return sellingPriceTo;
    }

    /**
     * @param sellingPriceTo the sellingPriceTo to set
     */
    public void setSellingPriceTo(int sellingPriceTo) {
        this.sellingPriceTo = sellingPriceTo;
    }

}
