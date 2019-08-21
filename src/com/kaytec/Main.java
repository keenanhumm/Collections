package com.kaytec;

public class Main {

    public static void main(String[] args) {
        Theatre olympian = new Theatre("Olympian", 8 , 12);

//        olympian.getSeats();

        if(olympian.reserveSeat("H03")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, that seat is taken!");
        }
        if(olympian.reserveSeat("B11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, that seat is taken!");
        }
    }
}
