public interface JGaloInterface {
	public abstract char getActualPlayer(); // usar um booleano onde o true representa um e o false representa outro
	// getActualPlayer() {
	// isPlayer1X = !isPlayerX;
	// return isPlayerX ? 'X' : 'O';
	// }

	public abstract boolean setJogada(int lin, int col); // retorna se é possível fazer a jogada no determinado local

	public abstract boolean isFinished(); // se há um vencedor ou se o jogo está empatado (nº de jogadas == nº de
											// jogadas máxima)

	public abstract char checkResult();
}