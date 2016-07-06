package com.dataart.dto;

import com.dataart.enums.HotelType;
import com.dataart.enums.RoomType;
import com.dataart.enums.RoomView;

public class RoomRequestDto {

    private HotelType hotelType;

    private RoomType roomType;

    private RoomView roomView;

    private String tv;

    private String conditioner;

    private String balcony;

    private String pool;

    private String slides;

    private String tennis;

    public RoomRequestDto(HotelType hotelType, RoomType roomType, RoomView roomView, String tv, String conditioner,
                          String balcony, String pool, String slides, String tennis) {
        this.hotelType = hotelType;
        this.roomType = roomType;
        this.roomView = roomView;
        this.tv = tv;
        this.conditioner = conditioner;
        this.balcony = balcony;
        this.pool = pool;
        this.slides = slides;
        this.tennis = tennis;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomView getRoomView() {
        return roomView;
    }

    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getConditioner() {
        return conditioner;
    }

    public void setConditioner(String conditioner) {
        this.conditioner = conditioner;
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
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
}
