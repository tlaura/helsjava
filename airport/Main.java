package com.company;

public class Main {

    public static void main(String[] args) {
        AirportPanel ap = new AirportPanel();

        PrintInfo.printAP();
        ap.chooseOp();
        PrintInfo.printFS();
        ap.flightService();
    }
}
