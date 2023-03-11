package lesson7;

public class Employee {
    String name;
    String surname;

    String department;
    Double salary;

    public Employee(String name, String surname, String department, Double salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s, отдел: %s, ставка: %.2f", surname, name, department, salary);
    }

}
