public class Flight {
    private Plane plane;
    private String departure;
    private String destination;

    public Flight(Plane plane, String departure, String destination){
        this.plane = plane;
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return this.plane + " (" + this.departure + "-" + this.destination +")";
    }
}
