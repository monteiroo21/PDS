public class JGaloSolver implements JGaloInterface{
    private char[][] board;
    private int num_moves;
    private char current_player;

    public JGaloSolver(){
        this.board = new char[3][3];
        this.num_moves = 0;
        this.current_player = 'X';        
    }

    public char getActualPlayer() {
        return current_player;
    }
    
    public boolean setJogada(int lin, int col) {
        if (lin < 1 || lin > 3 || col < 1 || col > 3) return false;
        board[lin-1][col-1] = current_player;
        num_moves++;
        current_player = (current_player == 'X') ? 'O' : 'X';
        return true;
    }

    public boolean isFinished() {
        return num_moves == 9 || checkResult() == 'X' || checkResult() == 'O';
    }

    public char checkResult() {
        for (int i = 0; i < 3 ; i++ ){
            if (board[i][0] == board[i][1] &&  board[i][2] == board[i][1]) {
                return board[i][0];   
            }
            if (board[0][i] == board[1][i] &&  board[2][i] == board[1][i]) {
                return board[0][i];   
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return  board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2]){
            return  board[2][0];
        }
        return ' ';
    }
}
