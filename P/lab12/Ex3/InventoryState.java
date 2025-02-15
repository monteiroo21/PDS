public class InventoryState implements State {

    @Override
    public void regista(Livro livro) {
        livro.setState(new AvailableState());
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
        System.out.println("Operação indisponível");
    }

    public String toString() {
        return "[Inventário]";
    }
    
}
