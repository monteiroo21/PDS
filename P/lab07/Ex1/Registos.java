import java.util.ArrayList;
import java.util.List;

public class Registos {
    // Data elements 
    private ArrayList<Empregado> empregados; // Stores the employees 
    
    public Registos() { 
        empregados = new ArrayList<>(); 
    } 

    public void insere(Empregado emp) { 
        empregados.add(emp);
    } 

    public void remove(int codigo) { 
        Empregado empToRemove = null;
        for (Empregado emp: empregados) {
            if (emp.codigo() == codigo) {
                empToRemove = emp;
            }
        }
        empregados.remove(empToRemove);
    } 

    public boolean isEmpregado(int codigo) { 
        for (Empregado emp: empregados) {
            if (emp.codigo() == codigo) {
                return true;
            }
        }
        return false;        
    } 

    public List<Empregado> listaDeEmpregados() { 
        return empregados; 
    } 
}
