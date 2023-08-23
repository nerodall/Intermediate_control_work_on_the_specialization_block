
import java.util.PriorityQueue;

public class Shop extends PriorityQueue<Toy> {
    private PriorityQueue<Toy> toys;

    public Shop(PriorityQueue<Toy> toys) {
        this.toys =toys;
    }

    public void addToy(String name, int quantity, int freq) {
        Toy toy = new Toy(name, quantity, freq);
        toys.add(toy);
    }

    @Override
    public String toString() {
        return "Shop" + "\n" + toys;
    }

    public void getToy() {
        if (!this.toys.isEmpty()) {
            Toy prize = toys.poll();
            if (prize.getQuantity() > 1) {
                prize.decreaseQuantity();
                this.toys.add(prize);
            }
        } else {
            System.out.println("Очередь пустая. Добавьте элемент");
        }
    }
}
