public class ReservedState implements State {
    @Override
    public void regista(Livro livro) {
        System.out.println("Operação indisponível");
    }

    @Override
    public void requisita(Livro livro) {
        System.out.println("Operação indisponível");
    }

    @Override
    public void devolve(Livro livro) {
        System.out.println("Operação indisponível");
    }

    @Override
    public void reserva(Livro livro) {
        System.out.println("Operação indisponível");
    }

    @Override
    public void cancelaReserva(Livro livro) {
        livro.setState(new AvailableState());
    }  
    
    public String toString() {
        return "[Reservado]";
    }
}
