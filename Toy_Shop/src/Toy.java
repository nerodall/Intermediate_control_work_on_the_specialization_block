/**
 * Класс описывающий поведение и свойства игрушки
 */
public class Toy implements Comparable<Toy> {
    private static int lastId = 0;
    private int id;
    private String name;
    private int quantity;
    private int freq;
/**
 * Коструктор для созания экземпляра объекта Toy
 * id присваивается автоматически
 * @param name Имя
 * @param quantity Количество
 * @param freq Частота выпадения
 */
    public Toy(String name, int quantity, int freq) {
        this.id = ++lastId;
        this.name = name;
        this.quantity = quantity;
        this.freq = freq;
    }
/**
 * Метод для получения id игрушки
 * @return id
 */
    public int getId() {
        return id;
    }
/**
 * Метод для изменения id игрушки
 * @param id
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Метод для получения имени игрушки
 * @return Name
 */
    public String getName() {
        return name;
    }
/**
 * Метод для установки имени игрушки
 * @param name
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * Метод для получения количества конкретной игрушки
 * @return Количество
 */
    public int getQuantity() {
        return quantity;
    }
/**
 * Метод для установки количества конкретной игрушки
 * @param quantity
 */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
/**
 * Метод для получения шанса выпадения конкретной игрушки
 * @return
 */
    public int getFreq() {
        return freq;
    }
/**
 * Метод для изменения шанса выпадения конкретной игрушки
 * @param freq
 */
    public void setFreq(int freq) {
        this.freq = freq;
    }
/**
 * Метод дл уменешния количества конкретной игрушки
 * Используется при извелении из очереди
 */
    public void decreaseQuantity() {
        this.quantity -= 1;
    }

    @Override
    public String toString() {
        return "Toy id=" + id + ", name=" + name + ", count=" + quantity + ", freq=" + freq + "]";
    }

    @Override
    public int compareTo(Toy o) {

        if (this.getFreq() == o.getFreq()) {
            return 0;
        }
        if (this.getFreq() > o.getFreq()) {
            return -1;
        }
        return 1;
    }

}
