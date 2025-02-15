public class Jogo implements JGaloInterface{

    private char[][] grid = new char[3][3];
    private int turn;  
    
    
    public Jogo(){
        this.turn = 0;
    }

    public Jogo(char initialPlayer){
        if (initialPlayer == 'X') {
            this.turn = 0;
        }else if (initialPlayer == 'O'){
            this.turn = 1;
        }else{
            System.err.println("Argumento inválido.");
            System.exit(1);
        }
    }

   


    public char getActualPlayer(){
        if (this.turn % 2 == 0){
            return 'X';
        } else{
            return 'O';
        }
    }
	public boolean setJogada(int lin, int col){
        if(this.grid[lin - 1][col - 1] != 'X' && this.grid[lin - 1][col - 1] != 'O'){
            if (this.turn % 2 == 0){
                this.grid[lin - 1][col - 1] = 'X';
            } else{
                this.grid[lin - 1][col - 1] = 'O';
            }
            turn++;
            
            return true;
        }else{
            return false;
        }
    }
	public boolean isFinished(){
        if (this.turn > 8){
            return true;
        }

        char winner = checkWin();
        if(winner == 'X' || winner == 'O'){
            return true;
        }
       
        return false;
    }

    public char checkWin(){
        for (int i = 0; i < 3; i++) {
            // Verificar linhas
            if (this.grid[i][0] == this.grid[i][1] && this.grid[i][1] == this.grid[i][2] && this.grid[i][0] != ' ') {
                return this.grid[i][0];
            }
            // Verificar colunas
            if (this.grid[0][i] == this.grid[1][i] && this.grid[1][i] == this.grid[2][i] && this.grid[0][i] != ' ') {
                return this.grid[0][i];
            }
        }

        // Verificar diagonais
        if ((grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ') ||
            (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ')) {
            return grid[1][1];
        }

        return ' ';

    }
	public char checkResult(){    
        return checkWin();        
    }
    
}