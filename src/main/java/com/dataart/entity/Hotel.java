package com.dataart.entity;

import com.dataart.enums.HotelType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hotel")
@NamedQueries({
        @NamedQuery(name = "Hotel.findHotels", query = "select h from Hotel h")
})
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
    private String pool;

    @Column(name = "hotel_slides")
    private String slides;

    @Column(name = "hotel_tennis")
    private String tennis;

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

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
