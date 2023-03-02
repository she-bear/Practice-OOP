package lesson4;

public class HomeWorkBoxes {
    public static void main(String[] args) {
        // работать не будет, т.к. String NOT extends Fruit
        // Box<String> stringBox = new Box<>();

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(3.0));
        appleBox.add(new Apple(2.0));
        // допустимо, т.к. Apple <- GoldenApple
        appleBox.add(new GoldenApple(1.0));
        // работать не будет, т.к. Orange NOT extends Apple
        // appleBox.add(new Orange(2.0)); 
        
        System.out.println(appleBox.getWeight()); // 6.0

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(2.0));
        // работать не будет, т.к. Apple NOT extends GoldenApple
        // goldenAppleBox.add(new Apple(2.0));

        // работать не будет, т.к. GoldenApple "выше" Apple
        // Object <- Fruit <- Apple <- Golden Apple
        // <? super Apple>
        // appleBox.moveTo(goldenAppleBox);
        
        goldenAppleBox.moveTo(appleBox);
        System.out.println(appleBox.getWeight()); // 0.0
        System.out.println(goldenAppleBox.getWeight()); // 8.0
    }
}
