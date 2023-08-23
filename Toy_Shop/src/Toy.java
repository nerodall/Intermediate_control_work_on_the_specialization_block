
public class Toy implements Comparable<Toy> {

    private int id;
    private String name;
    private int quantity;
    private int freq;

    public Toy(int id, String name, int quantity, int freq) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.freq = freq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

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
