package com.dataart.dto;

import java.util.List;

public class HotelDto {

    private int id;

    private String name;

    private String hotelType;

    private String pool;

    private String slides;

    private String tennis;

    private List<String> dates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getSlides() {
        return slides;
    }

    public void setSlides(String slides) {
        this.slides = slides;
    }

    public String getTennis() {
        return tennis;
    }

    public void setTennis(String tennis) {
        this.tennis = tennis;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }
}
