package lesson3;

import java.util.Comparator;

public class RAMComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return Integer.compare(o1.ram, o2.ram);
    }
}
