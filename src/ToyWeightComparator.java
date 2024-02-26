import java.util.Comparator;

/**
 * Компаратор для сравнения игрушек по весу
 */
public class ToyWeightComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getToyWeight() - o2.getToyWeight();
    }
}