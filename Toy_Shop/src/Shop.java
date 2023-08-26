
import java.util.PriorityQueue;

public class Shop extends PriorityQueue<Toy> {
    private PriorityQueue<Toy> toys;
    private WriteFile fw = new WriteFile();

    /**
     *
     * Класс описывающий поведение и основной функционал магазина игрушек
     * 
     * @param toys
     */
    public Shop(PriorityQueue<Toy> toys) {
        this.toys = toys;
    }

    /**
     * Метод для добавления игрушки в список игрушек для дальнейшего розыгрыша
     * id присваивается автоматически по счетчику
     * 
     * @param name     Имя
     * @param quantity Количиство
     * @param freq     Частота выпадения
     */
    public void addToy(String name, int quantity, int freq) {
        Toy toy = new Toy(name, quantity, freq);
        toys.add(toy);
    }

    @Override
    public String toString() {
        return "Shop" + "\n" + toys;
    }
/**
 * Метод для получения игрушки из общей очереди
 */
    public void getToy() {
        if (!this.toys.isEmpty()) {
            Toy prize = toys.poll();
            if (prize.getQuantity() == 0) {
                getToy();
            }

            if (prize.getQuantity() >= 1) {
                prize.decreaseQuantity();
                this.toys.add(prize);
                fw.saveResultToFile(prize);

            }
            System.out.println("Ваш приз - " + prize.getName());

        } else {
            System.out.println("Очередь пустая. Добавьте элемент");
        }
    }
/**
 * Метод для вовывода основного интерфейса программы
 */
    public void view() {
        System.out.println("0.Выход");
        System.out.println("1.Ввести список игрушек");
        System.out.println("2.Достать приз");
        System.out.println("3.Показать список");
        System.out.println("\nВведите цифру: ");

    }

}
