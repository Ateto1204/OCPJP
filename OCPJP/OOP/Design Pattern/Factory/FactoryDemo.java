package build;

import java.time.LocalDate;

interface EmployeeDao {
    void add();
    void update();
}

class Employee implements EmployeeDao {
    private String firstName;
    private String lastName;
    private int id;
    private float salary;
    private LocalDate birthDate;

    public Employee(String firstName, String lastName, int id, float salary, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public float getSalary() {
        return this.salary;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void add() {

    }
    @Override
    public void update() {

    }
}

public class FactoryDemo {

    public static Employee createEmployee(String firstName, String lastName, int id, float salary, LocalDate birthDate) {
        return new Employee(firstName, lastName, id, salary, birthDate);
    }

    public static void main(String[] args) {
        String firstName = "Ateto";
        String lastName = "Su";
        int id = 133;
        float salary = 100.6f;
        LocalDate birthDate = LocalDate.of(2004, 12, 2);

        EmployeeDao dao = FactoryDemo.createEmployee(firstName, lastName, id, salary, birthDate);

        Employee employee = (Employee)dao;
        System.out.println(employee.getFirstName());
    }
}
