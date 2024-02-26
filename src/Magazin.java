import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Магазин игрушек
 */
public class Magazin {

    private List<Toys> listOfToys;
    private PriorityQueue<Toy> toyPriorityQueue;

    /**
     * Конструктор
     */
    public Magazin() {
        this.listOfToys = new ArrayList<>();

    }

    /**
     * Количество наименований игрушек
     *
     * @return возвращает количество наименований игрушек
     */
    public int getTypeOfToysCount() {
        return listOfToys.size();
    }

    /**
     * Добавляет новую игрушку в магазин
     *
     * @param toy
     */
    public void addToy(Toys toy) {
        listOfToys.add(toy);
    }

    public boolean isEmpty() {
        return listOfToys.isEmpty();
    }


    /**
     * Изменяет вес игрушки в магазине по индексу
     *
     * @param index индекс игрушки у которой нужно изменить вес
     * @param w     строковое значение веса
     * @throws MyException ошибка преобразования строки в число
     */
    public void setNewWeight(int index, String w) throws MyException {
        try {
            listOfToys.get(index).getToy().setToyWeight(Integer.parseInt(w));
        } catch (Exception e) {
            throw new MyException(e.getMessage(), "weight");
        }
    }

    /**
     * Возвращает общий вес всех игрушек в магазине (количество * вес)
     *
     * @return общий вес всех игрушек в магазине (количество * вес)
     */
    private int getAllWeight() {
        int res = 0;
        for (Toys t : listOfToys) {
            res += t.getToy().getToyWeight() * t.getToyCount();
        }
        return res;
    }

    /**
     * Вывод в консоль игрушек магазина
     */
    public void printAllToys() {
        if (!listOfToys.isEmpty())
            for (Toys t : listOfToys) {
                System.out.println(t);
            }
        else {
            System.out.println("Магазин пуст!");
        }
    }

    /**
     * Розыгрыш игрушек в соответствии с их количеством в магазине и весом
     *
     * @param n количество розыгрышей
     * @return возвращает PriorityQueue с призовыми игрушками,в порядке, учитывающем вес от меньшего к большему
     */
    public PriorityQueue<Toy> getPrize(int n) {
        toyPriorityQueue = new PriorityQueue<Toy>(new ToyWeightComparator());

        Random rnd = new Random();
        if(allToyCount()==0){
            System.out.println("Все игрушки разыграны!");
            return null;
        }
        else if (n > allToyCount()) {
            System.out.printf("Игрушек хватит только на %d розыгрышей!\n", allToyCount());
            InputData.inputStr("Нажмите enter для продолжения.");
            n = allToyCount();
        }
        for (int c = 0; c < n; c++) {
            System.out.printf("Розыгрыш %d, ", c + 1);
            int x = rnd.nextInt(1, getAllWeight());
            for (int i = 0; i < getTypeOfToysCount(); i++) {
                x = x - listOfToys.get(i).getToy().getToyWeight() * listOfToys.get(i).getToyCount();
                if (x <= 0) {
                    System.out.print("приз: ");
                    System.out.println(listOfToys.get(i).getToy());
                    toyPriorityQueue.add(listOfToys.get(i).getToy());
                    listOfToys.get(i).reduceToyCount();
                    break;
                }
            }
        }
        return toyPriorityQueue;
    }

    public int allToyCount() {
        int res = 0;
        for (Toys t : listOfToys) res += t.getToyCount();
        return res;
    }

    /**
     * Очистка содержимого магазина
     */
    public void clear() {
        listOfToys.clear();
        printAllToys();
    }
}