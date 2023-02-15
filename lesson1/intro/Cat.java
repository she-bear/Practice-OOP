package ru.gb.lesson1.intro;

public class Cat extends Animal {

    public Cat(String name) {
        // super - делегирование к родительскому конструктору класса Animal
        // у родителя два конструктора, нужно понимать, какой вызывать
        super(name);
    }

    // здесь м.б. описан и второй конструктор

}
