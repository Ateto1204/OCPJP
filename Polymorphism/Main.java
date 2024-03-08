package build;

abstract class Employee {
    abstract protected int calculateStock();
}

class Manager extends Employee {
    protected int calculateStock() {
        return 30;
    }
}

class Director extends Manager {
    protected int calculateStock() {
        return 40;
    }
}

class EmployeeStockPlan {
    public int grantStock(Employee e) {
        return e.calculateStock();
    }

    public boolean isManager(Employee e) {
        if(e instanceof Manager) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeStockPlan plan = new EmployeeStockPlan();
        Manager m = new Manager();
        System.out.println(plan.isManager(m));
        System.out.println(plan.grantStock(m));
    }
}