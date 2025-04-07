package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class BoatHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("unused")
    private String name;

    @SuppressWarnings("unused")
    private String location;

    @SuppressWarnings("unused")
    private String amenities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "boatHouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    public Object getAmenities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAmenities'");
    }

    public void setAmenities(Object amenities2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAmenities'");
    }

    public Object getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public void setName(Object name2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public Object getOwner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOwner'");
    }

    public void setOwner(Object owner2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOwner'");
    }

    public Object getLocation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLocation'");
    }

    public void setLocation(Object location2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLocation'");
    }

    // Getters and Setters
}


