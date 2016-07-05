package com.dataart.entity;

import com.dataart.enums.RoomType;
import com.dataart.enums.RoomView;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "room")
@NamedQueries({
        @NamedQuery(name = "Room.FindAllRooms", query = "select r from Room r"),
        @NamedQuery(name = "Room.FindRooms",
                query = "select r from Room r where r.free = true and " +
                        "r.hotel.hotelType = :hotelType and " +
                        "r.roomType = :roomType and " +
                        "r.roomView = :roomView and " +
                        "r.tv = :tv and " +
                        "r.balcony = :balcony and " +
                        "r.conditioner = :conditioner and " +
                        "r.hotel.pool = :pool and " +
                        "r.hotel.slides = :slides and " +
                        "r.hotel.tennis = :tennis")
})
public class Room {

    @Id
    @Column(name = "room_id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(name = "room_number")
    private String number;

    @Column(name = "room_tv")
    private Boolean tv;

    @Column(name = "room_balcony")
    private Boolean balcony;

    @Column(name = "room_conditioner")
    private Boolean conditioner;

    @Column(name = "room_view")
    @Enumerated(EnumType.STRING)
    private RoomView roomView;

    @Column(name = "room_free")
    private Boolean free;

    @Column(name = "room_cost")
    private BigDecimal cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public RoomView getRoomView() {
        return roomView;
    }

    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
