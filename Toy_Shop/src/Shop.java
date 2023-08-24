
import java.util.PriorityQueue;
import java.util.Scanner;

public class Shop extends PriorityQueue<Toy> {
    private PriorityQueue<Toy> toys;

    public Shop(PriorityQueue<Toy> toys) {
        this.toys = toys;
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
            System.out.println("Ваш приз - " + prize.getName());
        } else {
            System.out.println("Очередь пустая. Добавьте элемент");
        }
    }



    public void view(){
        System.out.println("0.Выход");
        System.out.println("1.Ввести список игрушек");
        System.out.println("2.Достать приз");
        System.out.println("3.Показать список");
        System.out.println("\nВведите цифру: ");
        
    }

}
