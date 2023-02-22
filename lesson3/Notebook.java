package lesson3;

public class Notebook{
    public double price;
    public int ram;

    public Notebook(double price, int ram) {
        this.price = price;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return String.format("Price: %.2f, RAM: %d", price, ram);
    }
}
