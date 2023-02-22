package lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NotebookCompare {
    public static void main(String[] args) {
        
        List<Notebook> notebooks = new ArrayList<Notebook>();
        List<Integer> ram_values = new ArrayList<>(List.of(2, 4, 8, 12, 16, 32, 64));

        for (int i = 0; i < 15; i++) {
            notebooks.add(new Notebook(ThreadLocalRandom.current().nextDouble(26000, 60000), ram_values.get(ThreadLocalRandom.current().nextInt(0,7))));
            System.out.println(notebooks.get(i));
        }
    }
}
