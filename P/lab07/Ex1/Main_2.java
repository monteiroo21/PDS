public class Main_2 {
    public static void main(String[] args) {
        System.out.println("SWEETS:");
        Database db = new Database();
        Employee emp1 = new Employee("Jorge Domingues", 21, 1504.21);
        Employee emp2 = new Employee("João Monteiro", 25, 2213.47);
        Employee emp3 = new Employee("José", 7, 1192.01);
        db.addEmployee(emp1);
        db.addEmployee(emp2);
        db.addEmployee(emp3);

        for (Employee emp: db.getAllEmployees()) {
            System.out.println("Name: " + emp.getName() + ", Employee number: " + emp.getEmpNum() + ", Salary: " + emp.getSalary());
        }

        db.deleteEmployee(7);

        for (Employee emp: db.getAllEmployees()) {
            System.out.println("Name: " + emp.getName() + ", Employee number: " + emp.getEmpNum() + ", Salary: " + emp.getSalary());
        }

        System.out.println("---------------------------\nPETISCOS");

        Registos reg = new Registos();
        Empregado empr1 = new Empregado("Andre", "Rodrigues", 12, 3504.21);
        Empregado empr2 = new Empregado("Maria", "Lopes", 23, 3213.47);
        Empregado empr3 = new Empregado("José", "Gomes", 19, 4192.01);
        reg.insere(empr1);
        reg.insere(empr2);
        reg.insere(empr3);

        for (Empregado emp: reg.listaDeEmpregados()) {
            System.out.println("Name: " + emp.nome() + ", Apelido: " + emp.apelido() + ", Employee number: " + emp.codigo() + ", Salary: " + emp.salario());
        }

        System.out.println("Funcionário 19: " + reg.isEmpregado(19));
        reg.remove(19);
        System.out.println("Funcionário 19: " + reg.isEmpregado(19));

        for (Empregado emp: reg.listaDeEmpregados()) {
            System.out.println("Name: " + emp.nome() + ", Apelido: " + emp.apelido() + ", Employee number: " + emp.codigo() + ", Salary: " + emp.salario());
        }



        System.out.println("\n-------------------------------------------------------------\n");

        // Adapter

        Company company = new Company(db, reg);

        company.addEmployee(new EmployeeAdapter(new Empregado("Rui", "Miguel", 14, 3200.43)));
        company.addEmployee(new EmployeeAdapter(new Empregado("Mariana", "Alves", 16, 2200.43)));
        company.addEmployee(new EmployeeAdapter(new Empregado("Mariana", "Alves", 16, 2200.43)));
        System.out.println("Added employee 14");
        System.out.println("Added employee 16");

        System.out.println("Employee no.12 -> " + company.checkEmployee(12));
        System.out.println("Employee no.13 -> " + company.checkEmployee(13));
        System.out.println("Employee no.14 -> " + company.checkEmployee(14));

        company.deleteEmployee(14);
        System.out.println("Deleted employee 14");
        System.out.println("Employee no.14 -> " + company.checkEmployee(14));

        System.out.println("\nEmployees:");
        company.empInfo();
    }
}
