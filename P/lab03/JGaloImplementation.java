class JGaloImplementation implements JGaloInterface {
    private char[][] game;
    private boolean isPlayerX;
    private int moves;

    public JGaloImplementation() {
        game = new char[3][3];
        isPlayerX = true;
        moves = 0;
    }

    @Override
    public char getActualPlayer() {
        return isPlayerX ? 'X' : 'O';
    }

    @Override
    public boolean setJogada(int lin, int col) {
        if (game[lin - 1][col - 1] == 0) {
            game[lin - 1][col - 1] = getActualPlayer();
            isPlayerX = !isPlayerX;
            moves++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFinished() {
        if (checkResult() == 'X' || checkResult() == 'O' || checkResult() == ' ' && moves == 9) {
            return true;
        }
        return false;
    }

    public char WinnerForRows() {
        for (int i = 0; i < game.length; i++) {
            if (game[i][0] == 'X' && game[i][1] == 'X' && game[i][2] == 'X') {
                return 'X';
            }
            if (game[i][0] == 'O' && game[i][1] == 'O' && game[i][2] == 'O') {
                return 'O';
            }
        }
        return ' ';
    }

    public char WinnerForColumns() {
        for (int i = 0; i < game.length; i++) {
            if (game[0][i] == 'X' && game[1][i] == 'X' && game[2][i] == 'X') {
                return 'X';
            }
            if (game[0][i] == 'O' && game[1][i] == 'O' && game[2][i] == 'O') {
                return 'O';
            }
        }
        return ' ';
    }

    public char WinnerForDiagonals() {
        if (game[0][0] == 'X' && game[1][1] == 'X' && game[2][2] == 'X') {
            return 'X';
        }
        if (game[0][0] == 'O' && game[1][1] == 'O' && game[2][2] == 'O') {
            return 'O';
        }
        if (game[0][2] == 'X' && game[1][1] == 'X' && game[2][0] == 'X') {
            return 'X';
        }
        if (game[0][2] == 'O' && game[1][1] == 'O' && game[2][0] == 'O') {
            return 'O';
        }
        return ' ';
    }

    @Override
    public char checkResult() {
        char winner = ' ';
        if (WinnerForRows() == 'X' || WinnerForColumns() == 'X' || WinnerForDiagonals() == 'X') {
            winner = 'X';
        }
        if (WinnerForRows() == 'O' || WinnerForColumns() == 'O' || WinnerForDiagonals() == 'O') {
            winner = 'O';
        }

        if (winner == ' ' && moves == 9) {
            winner = ' ';
        }

        return winner;
    }
}
