public class Plane {
    private String id;
    private int capacity;

    public Plane(String id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }

    @Override
    public String toString(){
        return this.id + " (" + this.capacity + " ppl)";
    }
}