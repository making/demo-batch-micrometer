package com.example.demobatchmicrometer.crime;

import org.springframework.batch.item.ItemCountAware;

public class Crime implements ItemCountAware {
    private String cdatetime;
    private String address;
    private int district;
    private String beat;
    private int grid;
    private String crimedescr;
    private int ucrNcicCode;
    private double latitude;
    private double longitude;
    private int itemCount;

    public String getCdatetime() {
        return cdatetime;
    }

    public void setCdatetime(String cdatetime) {
        this.cdatetime = cdatetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        this.beat = beat;
    }

    public int getGrid() {
        return grid;
    }

    public void setGrid(int grid) {
        this.grid = grid;
    }

    public String getCrimedescr() {
        return crimedescr;
    }

    public void setCrimedescr(String crimedescr) {
        this.crimedescr = crimedescr;
    }

    public int getUcrNcicCode() {
        return ucrNcicCode;
    }

    public void setUcrNcicCode(int ucrNcicCode) {
        this.ucrNcicCode = ucrNcicCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getItemCount() {
        return itemCount;
    }

    @Override
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public String toString() {
        return "Crime{" + "cdatetime='" + cdatetime + '\'' + ", address='" + address
            + '\'' + ", district=" + district + ", beat='" + beat + '\'' + ", grid="
            + grid + ", crimedescr='" + crimedescr + '\'' + ", ucrNcicCode="
            + ucrNcicCode + ", latitude=" + latitude + ", longitude=" + longitude
            + '}';
    }
}