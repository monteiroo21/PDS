public class AvailableState implements State {
    @Override
    public void regista(Livro livro) {
        System.out.println("Operação indisponível");
    }

    @Override
    public void requisita(Livro livro) {
        livro.setState(new BorrowedState());
    }

    @Override
    public void devolve(Livro livro) {
        System.out.println("Operação indisponível");
    }

    @Override
    public void reserva(Livro livro) {
        livro.setState(new ReservedState());
    }

    @Override
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação indisponível");
    }

    public String toString() {
        return "[Disponível]";
    }
}
