package com.kaytec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {
    private final String name;
    private List<Seat> seats = new ArrayList<>();

    Theatre(String name, int numRows, int seatsPerRow) {
        this.name = name;

        int lastRow = 'A' + (numRows - 1);
        for(char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum < seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getName() {
        return name;
    }

    boolean reserveSeat(String seatNum) {
        Seat requestedSeat = new Seat(seatNum);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if(foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNum);
            return false;
        }
//        for(Seat seat: seats) {
//            if(seat.getNumber().equals(seatNum)) {
//                requestedSeat = seat;
//                break;
//            }
//        }

//        if(requestedSeat == null) {
//            System.out.println("There is no seat " + seatNum);
//            return false;
//        }

//        return requestedSeat.reserve();
    }

    // testing purposes
    void getSeats() {
        for(Seat seat: this.seats) {
            System.out.println(seat.getNumber());
        }
    }

    private class Seat implements Comparable<Seat>{
        private final String number;
        private boolean reserved = false;

        Seat(String number) {
            this.number = number;
        }

        String getNumber() {
            return number;
        }

        private boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + this.number + " reserved");
                return true;
            }
            return false;
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + this.number + " cancelled");
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.number.compareToIgnoreCase(seat.getNumber());
        }
    }
}
