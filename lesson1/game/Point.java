package lesson1.game;

import java.util.Objects;

// точка на карте
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        // если объекты равны по ссылке
        if (this == o) return true;
        // если классы разные
        if (o == null || getClass() != o.getClass()) return false;

        // type casting к типу Point
        Point point = (Point) o;
        // сравнение по тем полям, по которым хотим сравнивать
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // if o1.equals(o2) => o1.hashCode() == o2.hashCode()
    // if o1.hashCode() != o2.hashCode() => !o1.equals(o2)

}
