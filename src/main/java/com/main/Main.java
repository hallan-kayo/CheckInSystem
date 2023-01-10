/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.main;

import com.model.entities.Reservation;
import com.model.exceptions.DomainException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hallan
 */
public class Main {

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            
            System.out.println("Room Number:");
            int roomNumber = input.nextInt();
            System.out.println("CheckIn Date (dd/MM/yyyy):");
            Date checkin = simpleDate.parse(input.next());
            System.out.println("CheckOut Date (dd/MM/yyyy):");
            Date checkOut = simpleDate.parse(input.next());
        
        
            Reservation reservation = new Reservation(roomNumber,checkin,checkOut);
            System.out.println("Reservation: "+reservation.toString());
            input.next();

            System.out.println("Enter data fo update the reservation");
            System.out.println("CheckIn Date (dd/MM/yyyy):");
            checkin = simpleDate.parse(input.next());
            System.out.println("CheckOut Date (dd/MM/yyyy):");
            checkOut = simpleDate.parse(input.next());


            reservation.updateDates(checkin, checkOut);
            System.out.println("reservation: " + reservation.toString());
            
        }catch(ParseException error){
            
            System.out.println("Invalid date format");
            
        }catch(DomainException error){
            
            System.out.println("error: " + error.getMessage());
        }catch(RuntimeException error){
            System.out.println("unexpected error!");
        }
        
        
    }
}
