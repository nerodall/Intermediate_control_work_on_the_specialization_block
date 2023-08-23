
import java.util.PriorityQueue;

public class Shop extends PriorityQueue<Toy> {
    private PriorityQueue<Toy> toys;

    public Shop() {

    }

    public void addToy(int id, String name, int quantity, int freq) {
        Toy toy = new Toy(id, name, quantity, freq);
        toys.add(toy);
    }

    @Override
    public String toString() {
        return "Shop" + "\n" + toys;
    }

    public PriorityQueue<Toy> getToys() {
        return toys;
    }

    public void setToys(PriorityQueue<Toy> toys) {
        this.toys = toys;
    }

}
