package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

public class TicTaToe {
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;
    int[][] board = new int[3][3];
    int player;

    public TicTaToe() {
        clearBoard();
    }

    private void clearBoard() {
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j ++)
            {
                board[i][j] = EMPTY;
            }
        }
        player = X;
    }

    public void putMark(int i, int j) throws IllegalArgumentException {
        if (i < 0 || i > 2 || j < 0 || j > 2) throw new IllegalArgumentException("Invalid board position ... ");

        if (board[i][j] != EMPTY) throw new IllegalArgumentException("Board position occupied ... ");

        board[i][j] = player;
        player = - player;
    }

    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3) ||
                (board[1][0] + board[1][1] + board[1][2] == mark * 3) ||
                (board[2][0] + board[2][1] + board[2][2] == mark * 3) ||
                (board[0][0] + board[1][0] + board[2][0] == mark * 3) ||
                (board[0][1] + board[1][1] + board[2][1] == mark * 3) ||
                (board[0][2] + board[1][2] + board[2][2] == mark * 3) ||
                (board[0][0] + board[1][1] + board[2][2] == mark * 3) ||
                (board[0][2] + board[1][1] + board[2][0] == mark * 3));
    }

    public int winner() {
        if (isWin(X)) {
            return (X);
        } else if (isWin(O)) {
            return (O);
        }
        else return (0);
    }

    public String toString () {
        StringBuilder sb = new StringBuilder("");
        for ( int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                switch (board[i][j]) {
                    case X: sb.append(" X "); break;
                    case O: sb.append(" O "); break;
                    case EMPTY: sb.append(" "); break;
                }
                if (j < 2) sb.append("|");
            }
            if (i < 2) sb.append("\n-----------\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TicTaToe game = new TicTaToe();
        game.putMark(1,1);       game.putMark(0,2);
        game.putMark(2,2);       game.putMark(0,0);
        game.putMark(0,1);       game.putMark(2,1);
        game.putMark(1,2);       game.putMark(1,0);
        game.putMark(2,0);



        int winingPlayer = game.winner();
        System.out.println(game.toString());
        System.out.println(winingPlayer);

        String[] outcome = {"0 wins", "Tie", "1 Wins"};
        System.out.println(outcome[1 + winingPlayer]);
    }
}
