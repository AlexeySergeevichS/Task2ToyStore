import java.util.Comparator;
import java.util.Random;

public class ToyComparator<T extends Toy> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int oT1 = 0;
        int oT2 = 0;
        int[] w = new int[]{o1.getToyWeight(), o2.getToyWeight()};
        Random rnd = new Random();
        int id = rnd.nextInt(1, o1.getToyWeight() + o2.getToyWeight());
        for (int i = 0; i < w.length; i++) {
            id -= w[i];
            if (id < 0) {
                oT1 = i;
                break;
            }
        }
        id = rnd.nextInt(1, o1.getToyWeight() + o2.getToyWeight());
        for (int i = 0; i < w.length; i++) {
            id -= w[i];
            if (id < 0) {
                oT2 = i;
                break;
            }
        }
        if (oT1 == 0 && oT2 == 0) {
            return -1;
        }
        if (oT1 == 1 && oT2 == 1) {
            return 1;
        }
        return 0;
//        return o1.getId().compareTo(o2.getId());
    }
}
