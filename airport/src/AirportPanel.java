import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AirportPanel {
    private Scanner scan;
    private Map<String, Plane> planes;
    private ArrayList<Flight> flights;

    public AirportPanel(){
        this.scan = new Scanner(System.in);
        this.planes = new HashMap<>();
        this.flights = new ArrayList<>();
    }

    //     choose operation command 1
    public void addPlane(String id, int capacity){
        Plane plane = new Plane(id, capacity);
        planes.put(id, plane);
    }


    //    choose operation command 2
    public void addFlight(String id, String departCode, String destCode){
        for(String i: planes.keySet()){
            if(i.equals(id)){
                Flight f = new Flight(planes.get(id), departCode, destCode);
                flights.add(f);
            }
        }
    }

    //      flight service command 1
    public void printPlanes(){
        for(String id: planes.keySet()){
            System.out.println(planes.get(id));
        }
    }

    //    flight service command 2
    public void printFlights(){
        for(Flight f: flights){
            System.out.println(f);
        }
    }


    //    flight service command 3
    public void printOnePlane(String id){
        if(planes.containsKey(id)){
            System.out.println(planes.get(id));
        }
    }


    public void airportService(){
        System.out.println("Airport panel\n"
                + "--------------------\n");

        while(true){
            System.out.print("Choose operation:\n"
                    + "[1] Add airplane\n"
                    + "[2] Add flight\n"
                    + "[x] Exit\n"
                    + "> ");
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
        System.out.println("\nFlight service\n"
                + "------------\n");

        while(true){
            System.out.print("Choose operation:\n"
                    + "[1] Print planes\n"
                    + "[2] Print flights\n"
                    + "[3] Print plane info\n"
                    + "[x] Quit\n"
                    + "> ");
            String fs = scan.nextLine();

            if(fs.equals("1")){
                printPlanes();
                System.out.println();

            } else if(fs.equals("2")){
                printFlights();
            } else if(fs.equals("3")){
                System.out.print("Give plane ID: ");
                printOnePlane(scan.nextLine());
            } else if(fs.equals("x")){
                break;
            }
        }
    }
}
