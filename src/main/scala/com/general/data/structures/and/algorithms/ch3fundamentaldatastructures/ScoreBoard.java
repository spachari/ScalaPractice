package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

public class ScoreBoard {
    int numEntries = 0;
    public GameEntry[] board;

    ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    //One of the most common updates we might want to make to a Scoreboard is to add a new entry. Keep in mind that not every
    // entry will necessarily qualify as a high score. If the board is not yet full, any new entry will be retained. Once the
    // board is full, a new entry is only retained if it is strictly better than one of the other scores, in particular, the
    // last entry of the scoreboard, which is the lowest of the high scores.

    public int size() {
        int arraySize = 0;
        for (int i = 0; i < this.board.length; i ++) {
            if (this.board[i] != null )
                arraySize = arraySize + 1;
        }
        return arraySize;
    }

    public String getOrElseName(GameEntry gameEntry) {
        String output = "default";
        if (gameEntry == null) output = "default"; else output = gameEntry.name;
        return output;
    }

    public void add(GameEntry gameEntry) {
        System.out.println("adding game entry for " + gameEntry.getName() + " score " + gameEntry.getScore());
        int arraySize = this.size();
        //System.out.println(arraySize);



        if (numEntries < this.board.length || gameEntry.getScore() > this.board[arraySize - 1].getScore()) { //total number of items in array is less
                                                                                                               // than length and new score is greater than score that is there in last
            if (arraySize < board.length) {
                numEntries ++;
            }

            //shift any lower scores rightward to make room for the new entry
            //numEntries is a counter
            int j = numEntries - 1; //j is the number of items in the array, because length is just the capacity of the array

            int jminus1 = 0;
            if (j - 1 < 0)  {jminus1 = 0;} else jminus1 = j - 1;
            System.out.println("numEntries after incrementing " + numEntries + " j " + j + " board[j] " + getOrElseName(board[j]) + " board[j - 1] " + getOrElseName(board[jminus1]));


            //if any element in the array is less than the score in the new entry, we shift the entry to one right
            //Note: This loops through all entries of the array from reverse
            while(j > 0 && board[j - 1].score < gameEntry.getScore()) {
                System.out.println("Inside j ..." + j + "th time");
                board[j] = board[j - 1];
                j--; //then we decrease j
            }
            //In essence we will get the j whose score in board is > gameEntry.getScore()
            System.out.println(" j after while loop " + j );
            board[j] = gameEntry;
        }
    }


    public void remove(GameEntry gameEntry) {
        String nameToBeDeleted = gameEntry.getName();
        int scoreToBeDeleted = gameEntry.getScore();

        int j = numEntries - 1;
        int matchingIndex = 0;
        for (int i = j; i >= 0; i --) {
            if (board[i] != null && (board[i].getName() == nameToBeDeleted && board[i].getScore() == scoreToBeDeleted)) {
                matchingIndex = i;
            }
        }
        System.out.println("matching index " + matchingIndex);
        GameEntry[] temp = new GameEntry[j];

        /*
        for (int i = j; i > 0; i --) {
            if (i == matchingIndex) {
                board[i] = null;
            }
        }
        */


        for (int i = matchingIndex; i < numEntries - 1 ; i ++) {
            board[i] = board[i + 1];
        }
        board[numEntries - 1] = null;
    }

    public void printBoardElements () {
        int i = 0;
        for (GameEntry g : board) {
            if (g != null)
            {
                System.out.println(i + " " + g.name + " " + g.score);
                i++;
            }
        }
    }

}

class ScoreBoardTest{
    public static void main(String[] args) {

        ScoreBoard sc = new ScoreBoard(5);
        sc.add(new GameEntry("Srinivas", 1000));
        sc.printBoardElements();
        sc.add(new GameEntry("Kirthika", 10000));
        sc.printBoardElements();

        sc.add(new GameEntry("Sadhana", 5000));

        sc.printBoardElements();

        sc.add(new GameEntry("Sadhiv", 100));
        sc.printBoardElements();

        sc.add(new GameEntry("Sadhiv", 10000));
        sc.printBoardElements();

        sc.add(new GameEntry("Sadhiv", 100000));
        sc.printBoardElements();

        System.out.println("Removing an item ....");
        sc.remove(new GameEntry("Kirthika", 10000));
        sc.printBoardElements();

        sc.remove(new GameEntry("Sadhiv", 10000));
        sc.printBoardElements();
        sc.remove(new GameEntry("Srinivas", 1000));
        sc.printBoardElements();


    }
}
