package com.dataart.dto;

public class RoomRequestDto {

    private String hotelType;

    private String roomType;

    private String roomView;

    private Boolean tv;

    private Boolean conditioner;

    private Boolean balcony;

    private Boolean pool;

    private Boolean slides;

    private Boolean tennis;

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getConditioner() {
        return conditioner;
    }

    public void setConditioner(Boolean conditioner) {
        this.conditioner = conditioner;
    }

    public Boolean getBalcony() {
        return balcony;
    }

    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;
    }

    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
    }

    public Boolean getSlides() {
        return slides;
    }

    public void setSlides(Boolean slides) {
        this.slides = slides;
    }

    public Boolean getTennis() {
        return tennis;
    }

    public void setTennis(Boolean tennis) {
        this.tennis = tennis;
    }
}
