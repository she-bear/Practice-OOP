package lesson4;

import java.util.ArrayList;
import java.util.List;

// Object <- Fruit <- Apple
// Object <- Fruit <- Orange
// Object <- Fruit <- Apple <- Golden Apple

//             Super <- -> Extends
// Object <- Fruit <- Apple <- Golden Apple
public class Box <T extends Fruit> { // сюда м.б. помещен любой наследник класса Fruit

    List<T> fruits = new ArrayList<T>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double weight = 0;
        
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        
        return weight;
    }

    // если T = Apple, то запись <? super T> означает, что пройдут Object <- Fruit <- Apple
    public void moveTo(Box<? super T> anotherBox) { // параметризуем принимаемый аргумент
        for (T fruit : fruits) {
            // T = Apple : fruit
            // anotherbox     fruit
            // Apple < Apple +
            // Fruit < Apple +
            // Object < Apple +
            anotherBox.add(fruit);
        }
        fruits = new ArrayList<T>();
    }

    // расмотрим случай, если мы захотим GoldenApple переложить в Box<Apple>
    // если T = Apple, то запись <? extends T> означает, что пройдут Apple <- GoldenApple
    // public void moveTo_2(Box<? extends T> anotherBox) {
    //     for (T fruit : fruits) {
    //         // T = Apple : fruit
    //         // Apple < Apple
    //         // GoldenApple < Apple не работает для метода add!!!
    //         anotherBox.add(fruit);
    //     }
    //     fruits = new ArrayList<T>();
    // }

    // ВЫВОД: такой метод реализовать в данном контексе нельзя
}
