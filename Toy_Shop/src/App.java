
import java.util.PriorityQueue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Toy> queueToy = new PriorityQueue<>();
        Shop shop = new Shop(queueToy);
        WriteFile wf = new WriteFile();
        wf.clearFile();
        /// Если не хочется каждый раз вносить список

        shop.addToy("doll", 3, 60);
        shop.addToy("robot", 2, 20);
        shop.addToy("car", 1, 20);

        Scanner in = new Scanner(System.in);
        Integer input;
        while (true) {
            shop.view();

            switch (input = in.nextInt()) {
                case 0:
                    System.out.println("Программа завершена!");
                    in.close();
                    System.exit(500);
                    break;
                case 1:
                    Integer freqAll = 100;
                    if (!queueToy.isEmpty()) {
                        queueToy.clear();
                        wf.clearFile();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Введите название игрушки");
                        String name = in.nextLine();
                        String name2 = in.nextLine();
                        System.out.println("Введите количество игрушек ");
                        Integer quantity = in.nextInt();
                        System.out.println("Введите шанс выпадения. Доступное значние от 1 до " + freqAll);
                        Integer freq = in.nextInt();
                        shop.addToy(name2, quantity, freq);
                        freqAll -= freq;
                    }
                    break;
                case 2:
                    shop.getToy();
                    break;

                case 3:
                    System.out.println("\nСписок игрушек: \n");
                    if (!queueToy.isEmpty()) {
                        for (Toy toy : queueToy) {
                            System.out.println(toy);
                        }
                        System.out.println();
                    }
                    break;
            }
        }

    }
}
/// to do

/**
 * создать класс реализации интерфейса программы, завернуть все в while. Сделать
 * java doc
 * ограничение по вводу процентов от 1 до 100
 * 
 */