/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author hallan
 */
public class Reservation {
    
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long difference = this.checkOut.getTime() - this.checkIn.getTime(); //pegando a duração em mili segundos.
        return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS); //transformando de milissegundos em dias.
    }
    
    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation{" + 
                "roomNumber = " + roomNumber + 
                ", checkIn = " + simpleDate.format(checkIn) + 
                ", checkOut = " + simpleDate.format(checkOut) + 
                ", duration = " + this.duration() +
                " nights.'";
    }
    
    
}
