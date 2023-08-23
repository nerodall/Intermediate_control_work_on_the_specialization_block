import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Toy> queueToy = new PriorityQueue<>();
        Shop shop = new Shop(queueToy);
        shop.addToy("doll", 100, 100);
        shop.addToy("robot", 100, 90);
        shop.addToy("car", 100, 100);
        shop.addToy("red car", 100, 15);

        System.out.println(shop);
        shop.getToy();
        System.out.println(shop);

    }
}
