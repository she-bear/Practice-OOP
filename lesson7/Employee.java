package lesson7;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        // если объекты равны по ссылке
        if (this == obj) return true;
        // если классы разные
        if (obj == null || getClass() != obj.getClass()) return false;

        // type casting к типу Point
        Employee employee = (Employee) obj;
        // сравнение по тем полям, по которым хотим сравнивать
        // это решение оказалось неверным, т.к. при реализации hashCode() выяснилось, что два одинаковых по equals сотрудника
        // будут иметь разный hashCode
        // return this.name.equalsIgnoreCase(employee.name) && this.surname.equalsIgnoreCase(employee.surname);
        // поэтому
        return this.name.equals(employee.name) && this.surname.equals(employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname);
    }

}
