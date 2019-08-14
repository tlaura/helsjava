package com.company;

public class PrintInfo {
    public static void printAP(){
        System.out.println("Airport Panel\n" +
                "--------------------");
        System.out.println();
    }

    public static void printFS(){
        System.out.println("Flight Service\n" +
                "--------------------");
        System.out.println();
    }

    public static void printOperationCommand(){
        System.out.println("Choose operation:\n" +
                "[1] Add airplane\n" +
                "[2] Add flight\n" +
                "[x] Exit");
    }

    public static void printFScommand(){
        System.out.println("Choose operation:\n" +
                "[1] Print planes\n" +
                "[2] Print flights\n" +
                "[3] Print plane info\n" +
                "[x] Quit");
    }

    public static void printPlaneInfo(){
        System.out.println("Give plane ID: ");
    }

}
