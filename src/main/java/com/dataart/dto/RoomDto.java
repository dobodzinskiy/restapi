package com.dataart.dto;


public class RoomDto {

    private int id;

    private String number;

    private String HotelName;

    private String roomType;

    private Boolean tv;

    private Boolean balcony;

    private Boolean conditioner;

    private String roomView;

    private Boolean free;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getBalcony() {
        return balcony;
    }

    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;
    }

    public Boolean getConditioner() {
        return conditioner;
    }

    public void setConditioner(Boolean conditioner) {
        this.conditioner = conditioner;
    }

    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
}
