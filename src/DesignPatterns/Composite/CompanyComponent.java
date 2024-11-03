package DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

// Component Interface
public interface CompanyComponent {
    void showDetails();
    double calculateTotalSalaries();
    void addComponent(CompanyComponent component);
    void removeComponent(CompanyComponent component);
    void evaluatePerformance(); // Added for performance evaluation
}

// Role Enum
enum Role {
    MANAGER(100000),
    SOFTWARE_ENGINEER(70000),
    QA_ENGINEER(60000),
    HR_MANAGER(80000);

    private final double baseSalary;

    Role(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

// Leaf Class
class Employee implements CompanyComponent {
    String name;
    Role role;
    Employee manager; // A reference to the employee's manager
    double performanceRating; // Performance rating (0 to 1)

    public Employee(String name, Role role, Employee manager, double performanceRating) {
        this.name = name;
        this.role = role;
        this.manager = manager;
        this.performanceRating = performanceRating;
    }

    @Override
    public void showDetails() {
        String managerName = (manager != null) ? manager.name : "None";
        double adjustedSalary = role.getBaseSalary() * (1 + performanceRating); // Adjust salary based on performance
        System.out.printf("Employee: %s, Role: %s, Manager: %s, Salary: %.2f, Performance Rating: %.2f%n",
                name, role, managerName, adjustedSalary, performanceRating);
    }

    @Override
    public double calculateTotalSalaries() {
        return role.getBaseSalary() * (1 + performanceRating); // Return adjusted salary
    }

    @Override
    public void addComponent(CompanyComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf");
    }

    @Override
    public void removeComponent(CompanyComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf");
    }

    @Override
    public void evaluatePerformance() {
        // Example performance evaluation logic (could be enhanced further)
        performanceRating = Math.random(); // Randomly assign performance rating for demo
    }
}

// Composite Class for Department
class Department implements CompanyComponent {
    private List<CompanyComponent> components;
    String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        components = new ArrayList<>();
    }

    @Override
    public void addComponent(CompanyComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(CompanyComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + departmentName);
        for (CompanyComponent component : components) {
            component.showDetails();
        }
    }

    @Override
    public double calculateTotalSalaries() {
        double totalSalary = 0;
        for (CompanyComponent component : components) {
            totalSalary += component.calculateTotalSalaries();
        }
        return totalSalary;
    }

    @Override
    public void evaluatePerformance() {
        for (CompanyComponent component : components) {
            component.evaluatePerformance();
        }
    }
}

// Composite Class for Team
class Team implements CompanyComponent {
    private List<CompanyComponent> members;
    String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
        members = new ArrayList<>();
    }

    @Override
    public void addComponent(CompanyComponent component) {
        members.add(component);
    }

    @Override
    public void removeComponent(CompanyComponent component) {
        members.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Team: " + teamName);
        for (CompanyComponent member : members) {
            member.showDetails();
        }
    }

    @Override
    public double calculateTotalSalaries() {
        double totalSalary = 0;
        for (CompanyComponent member : members) {
            totalSalary += member.calculateTotalSalaries();
        }
        return totalSalary;
    }

    @Override
    public void evaluatePerformance() {
        for (CompanyComponent member : members) {
            member.evaluatePerformance();
        }
    }
}

// Composite Class for Project
class Project implements CompanyComponent {
    private List<CompanyComponent> teams;
    String projectName;

    public Project(String projectName) {
        this.projectName = projectName;
        teams = new ArrayList<>();
    }

    @Override
    public void addComponent(CompanyComponent component) {
        teams.add(component);
    }

    @Override
    public void removeComponent(CompanyComponent component) {
        teams.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Project: " + projectName);
        for (CompanyComponent team : teams) {
            team.showDetails();
        }
    }

    @Override
    public double calculateTotalSalaries() {
        double totalSalary = 0;
        for (CompanyComponent team : teams) {
            totalSalary += team.calculateTotalSalaries();
        }
        return totalSalary;
    }

    @Override
    public void evaluatePerformance() {
        for (CompanyComponent team : teams) {
            team.evaluatePerformance();
        }
    }
}

// Client Class
class CompanyManager {
    public static void main(String[] args) {
        // Create employees
        Employee emp1 = new Employee("Alice", Role.SOFTWARE_ENGINEER, null, 0.2);
        Employee emp2 = new Employee("Bob", Role.QA_ENGINEER, emp1, 0.15);
        Employee emp3 = new Employee("Charlie", Role.MANAGER, null, 0.3);
        Employee emp4 = new Employee("David", Role.HR_MANAGER, null, 0.1);
        Employee emp5 = new Employee("Eve", Role.SOFTWARE_ENGINEER, emp3, 0.25);
        Employee emp6 = new Employee("Frank", Role.SOFTWARE_ENGINEER, emp3, 0.05);

        // Create teams
        Team devTeam = new Team("Development Team");
        devTeam.addComponent(emp1);
        devTeam.addComponent(emp2);
        devTeam.addComponent(emp5);
        devTeam.addComponent(emp6);

        Team qaTeam = new Team("QA Team");
        qaTeam.addComponent(emp2);

        // Create projects
        Project projectA = new Project("Project A");
        projectA.addComponent(devTeam);
        projectA.addComponent(qaTeam);

        // Create departments
        Department devDepartment = new Department("Development Department");
        devDepartment.addComponent(projectA);
        devDepartment.addComponent(emp3); // Charlie is also part of the development department

        Department hrDepartment = new Department("HR Department");
        hrDepartment.addComponent(emp4);

        // Create a main company department
        Department company = new Department("Tech Corp");
        company.addComponent(devDepartment);
        company.addComponent(hrDepartment);

        // Show details of the company structure
        company.showDetails();

        // Evaluate performance for all components
        company.evaluatePerformance();

        // Show details after performance evaluation
        System.out.println("\nAfter Performance Evaluation:");
        company.showDetails();

        // Calculate and display total salaries in each department
        System.out.printf("Total Salaries in Development Department: %.2f%n", devDepartment.calculateTotalSalaries());
        System.out.printf("Total Salaries in HR Department: %.2f%n", hrDepartment.calculateTotalSalaries());
        System.out.printf("Total Salaries in Tech Corp: %.2f%n", company.calculateTotalSalaries());
    }
}
