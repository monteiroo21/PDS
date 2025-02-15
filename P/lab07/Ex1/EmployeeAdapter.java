public class EmployeeAdapter implements EmployeeInterface {
    private Empregado emp;

    public EmployeeAdapter(Empregado emp) {
        this.emp = emp;
    }

    @Override
    public String getName() {
        return emp.nome() + " " + emp.apelido();
    }

    @Override
    public long getCodigo() {
        return emp.codigo();
    }

    @Override
    public double getSalary() {
        return emp.salario();
    }
}
