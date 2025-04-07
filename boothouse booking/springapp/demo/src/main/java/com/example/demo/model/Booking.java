package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("unused")
    private LocalDate startDate;

    @SuppressWarnings("unused")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boatHouse_id")
    private BoatHouse boatHouse;

    public Object getEndDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEndDate'");
    }

    public Object getStartDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStartDate'");
    }

    public void setEndDate(Object endDate2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEndDate'");
    }

    public void setStartDate(Object startDate2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStartDate'");
    }

    public Object getUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    public void setUser(Object user2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUser'");
    }

    public Object getBoatHouse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoatHouse'");
    }

    public void setBoatHouse(Object boatHouse2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBoatHouse'");
    }

    // Getters and Setters
}
