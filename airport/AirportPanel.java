package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AirportPanel {
    private Scanner scan;
    private HashMap<String, Integer> planes;
    private ArrayList<Flight> flights;

    public AirportPanel(){
        this.scan = new Scanner(System.in);
        this.planes = new HashMap<>();
        this.flights = new ArrayList<>();
    }

//     choose operation command 1
    public void addPlane(String id, int capacity){
        planes.put(id, capacity);
    }


//    choose operation command 2
    public void addFlight(String id, String departCode, String destCode){
        if(planes.containsKey(id)){
            Plane p = new Plane(id, planes.get(id));
            String codes = "(" + departCode + "-" + destCode + ")";
            Flight f = new Flight(p, codes);
            flights.add(f);
        }
    }

//      flight service command 1
    public void printPlanes(){
        for(String id : planes.keySet()){
            System.out.print(id + " ");
            System.out.println("(" + planes.get(id) + " ppl)");
        }
    }

//    flight service command 2
    public void printFlights(){
        for(Flight f: flights){
            Plane plane = f.getP();
            System.out.print(plane.toString());
            System.out.println(f.getCodes());
        }
    }


//    flight service command 3
    public void printOnePlane(String id){
        if(planes.containsKey(id)){
            System.out.print(id + " ");
            System.out.println("(" + planes.get(id) + " ppl)");
        }
    }


    public void chooseOp(){
        while(true){
            PrintInfo.printOperationCommand();
            String op = scan.nextLine();

            if(op.equals("1")){
                System.out.print("Give plane ID: ");
                String id = scan.nextLine();
                System.out.print("Give plane capacity: ");
                int capacity = Integer.parseInt(scan.nextLine());
                addPlane(id, capacity);

            } else if(op.equals("2")){
                System.out.print("Give plane ID: ");
                String id = scan.nextLine();

                System.out.print("Give departure airport code: ");
                String departureCode = scan.nextLine();

                System.out.print("Give destination airport code: ");
                String destinationCode = scan.nextLine();

                addFlight(id, departureCode, destinationCode);

            } else if(op.equals("x")){
                break;
            }
        }
    }


    public void flightService(){
        while(true){
            PrintInfo.printFScommand();
            String fs = scan.nextLine();

            if(fs.equals("1")){
                printPlanes();
                System.out.println();

            } else if(fs.equals("2")){
                printFlights();
            } else if(fs.equals("3")){
                PrintInfo.printPlaneInfo();
                printOnePlane(scan.nextLine());
            } else if(fs.equals("x")){
                break;
            }
        }
    }
}
