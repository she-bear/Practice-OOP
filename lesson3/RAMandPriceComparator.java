package lesson3;

import java.util.Comparator;

public class RAMandPriceComparator implements Comparator<Notebook>{
    @Override
    public int compare(Notebook o1, Notebook o2) {
        if (o1.ram == o2.ram)
            return Double.compare(o1.price, o2.price);   
        else
            return Integer.compare(o1.ram, o2.ram);  
        
        
        // if (o1.ram > o2.ram)
        //     return 1;
        // else if (o1.ram < o2.ram)
        //     return -1;
        // else if (o1.price > o2.price)
        //     return 1;
        // else if (o1.price < o2.price)
        //     return -1;
        // else
        //     return 0;


        //return Integer.compare(o1.ram, o2.ram);
    }
}
