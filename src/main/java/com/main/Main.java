/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.main;

import com.model.entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hallan
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        
        Scanner input = new Scanner(System.in);
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Room Number:");
        int roomNumber = input.nextInt();
        System.out.println("CheckIn Date (dd/MM/yyyy):");
        Date checkin = simpleDate.parse(input.next());
        System.out.println("CheckOut Date (dd/MM/yyyy):");
        Date checkOut = simpleDate.parse(input.next());
        
        if (!checkOut.after(checkin)){
            System.out.println("Error in reservation: The checkOut Date must be after checkIn Date.");
        }else{
            Reservation reservation = new Reservation(roomNumber,checkin,checkOut);
            System.out.println("Reservation: "+reservation.toString());
            input.next();
            
            System.out.println("Enter data fo update the reservation");
            System.out.println("CheckIn Date (dd/MM/yyyy):");
            checkin = simpleDate.parse(input.next());
            System.out.println("CheckOut Date (dd/MM/yyyy):");
            checkOut = simpleDate.parse(input.next());
            
            String error = reservation.updateDates(checkin, checkOut);
            if( error != null){
                System.out.println("error: " + error);
            }
            else{
                reservation.updateDates(checkin, checkOut);
            }
            
            System.out.println("Reservation: " + reservation.toString());
            
        }
        
        
    }
}
