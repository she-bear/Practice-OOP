package lesson7;

public class Main {
    public static void main(String[] args) {
        Employee employee_1 = new Employee("Андрей", "Востриков", "Научно-технический", 8200.00);
        Employee employee_2 = new Employee("Светлана", "Белозерова", "Разработки ИС", 9750.00);
        Employee employee_3 = new Employee("Андрей", "Востриков", "Разработки ИС", 9340.00);
        Employee employee_4 = new Employee("Ирина", "Ромашко", "Тестирования", 6320.00);
        Employee employee_5 = new Employee("андрей", "Востриков", "Клиентской поддержки", 9340.00);

        System.out.println(employee_2.equals(employee_4));
        System.out.println(employee_1.equals(employee_3));
        System.out.println(employee_3.equals(employee_5));

        System.out.println(employee_1.hashCode());
        System.out.println(employee_3.hashCode());
        // hashCode другой
        System.out.println(employee_5.hashCode());
    }
}
