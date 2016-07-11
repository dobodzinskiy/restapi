package com.dataart.dto;


import java.math.BigDecimal;
import java.util.List;

public class RoomDto {

    private int id;

    private Boolean free;

    private String number;

    private String roomType;

    private String tv;

    private String balcony;

    private String conditioner;

    private String roomView;

    private BigDecimal cost;

    private String HotelName;

    private int hotelId;

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

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public String getConditioner() {
        return conditioner;
    }

    public void setConditioner(String conditioner) {
        this.conditioner = conditioner;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public void setSlides(String slides) {
        this.slides = slides;
    }

    public void setTennis(String tennis) {
        this.tennis = tennis;
    }

    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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

    public String getSlides() {
        return slides;
    }

    public String getTennis() {
        return tennis;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }
}
