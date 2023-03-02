package Generics_test;

class Fruit  {
}

interface Price {
    int getPrice();
}

interface Weight {
    int getWeight();
}

class Car implements Price, Weight {

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public int getWeight() {
        return 3500;
    }
    
}

class Orange extends Fruit implements Price, Weight {
    

    @Override
    public int getPrice() {
        return 1;
    }

    @Override
    public int getWeight() {
        return 5;
    }
}

class Apple extends Fruit implements Price, Weight {
    

    @Override
    public int getPrice() {
       return 2;
    }

    @Override
    public int getWeight() {
        return 1;
    }
}

public class MainGenerics {
    
    public static void main(String[] args) {

        Apple apple = new Apple();
        Orange orange = new Orange();
        Car car = new Car();
        printInfo(orange);
        printInfo(apple);
        printInfo(car);
    }
    
    public static <T extends Price & Weight> void printInfo(T item) {
        System.out.println(item.getWeight());
        System.out.println(item.getPrice());
    }
    
}
