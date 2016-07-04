package com.dataart.entity;

import com.dataart.enums.HotelType;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hotel_name")
    private String name;

    @Column(name = "hotel_type")
    @Enumerated(EnumType.STRING)
    private HotelType hotelType;

    @Column(name = "hotel_pool")
    private Boolean pool;

    @Column(name = "hotel_slides")
    private Boolean slides;

    @Column(name = "hotel_tennis")
    private Boolean tennis;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "check_in", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "check_in_date")
    private List<Date> dates;

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

    public HotelType getHotelType() {
        return hotelType;
    }

    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
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

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
