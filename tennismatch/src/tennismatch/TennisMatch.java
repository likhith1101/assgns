package tennismatch;

import java.util.ArrayList;
import java.util.List;

class TennisMatch {
    private Player player1;
    private Player player2;
    private List<TennisSet> sets;
    private int currentSet;
    private int player1SetsWon;
    private int player2SetsWon;

    public TennisMatch(Player player1, Player player2, int numSetsToWin) {
        this.player1 = player1;
        this.player2 = player2;
        this.sets = new ArrayList<>();
        this.currentSet = 0;
        this.player1SetsWon = 0;
        this.player2SetsWon = 0;
        // Initialize sets and manage set sequence
    }

   public void playSet() {
        TennisSet tennisSet = new TennisSet(player1, player2);
        sets.add(tennisSet);

        while (!tennisSet.isSetOver()) {
            tennisSet.playGame();
        }

        if (tennisSet.getWinner() == player1) {
            player1SetsWon++;
        } else {
            player2SetsWon++;
        }
    }

    public String getCurrentScore() {
        int setsWonPlayer1 = player1SetsWon;
        int setsWonPlayer2 = player2SetsWon;

        StringBuilder scoreBuilder = new StringBuilder();
        for (TennisSet set : sets) {
            scoreBuilder.append(set.getScore()).append(", ");
        }

        String matchScore = scoreBuilder.toString();
        return "Match Score: " + matchScore + player1.getName() + " " + setsWonPlayer1 + " sets, " +
               player2.getName() + " " + setsWonPlayer2 + " sets";
    }

    public Player getMatchWinner() {
        if (player1SetsWon >= 2) {
            return player1;
        } else if (player2SetsWon >= 2) {
            return player2;
        } else {
            return null;
        }
    }
    
    public String getDetailedScoreboard() {
        StringBuilder scoreboard = new StringBuilder();

        for (int setIndex = 0; setIndex < sets.size(); setIndex++) {
            TennisSet set = sets.get(setIndex);
            scoreboard.append("Set ").append(setIndex + 1).append(": ").append(set.getScore()).append("\n");
        }

        return scoreboard.toString();
    }
}