package ru.gb.lesson1.intro;

public class Animal {

    private String name;
    private int age;

    public Animal(String name, int age) {
        // this - ссылка на поле текущего объекта
        this.name = name;
        this.age = age;
    }

    public Animal(String name) {
        // здесь this - ссылка на другой конструктор ЭТОГО же класса
        this(name, 2);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
