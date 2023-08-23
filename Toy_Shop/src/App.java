

public class App {
    public static void main(String[] args) throws Exception {
        Shop shop = new Shop();
        shop.addToy(3, "doll", 1, 50);
        shop.addToy(1, "robot", 2, 90);
        shop.addToy(2, "car", 2, 100);
        shop.addToy(5, "red car", 1, 90);
        
        System.out.println(shop.toString());
        

    }
}
