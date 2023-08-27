package tennismatch;

public class TennisGame {
    private int scorePlayer1;
    private int scorePlayer2;
    private Player player1;
    private Player player2;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    public void playerScores(Player player) {
        if (player.equals(player1)) {
            scorePlayer1++;
        } else if (player.equals(player2)) {
            scorePlayer2++;
        }
    }

    public String getScore() {
        String[] scores = {"Love", "15", "30", "40"};
        if (scorePlayer1 < 3 && scorePlayer2 < 3) {
            return scores[scorePlayer1] + "-" + scores[scorePlayer2];
        } else if (scorePlayer1 == scorePlayer2) {
            return "Deuce";
        } else if (Math.abs(scorePlayer1 - scorePlayer2) == 1) {
            return "Advantage " + (scorePlayer1 > scorePlayer2 ? player1.getName() : player2.getName());
        } else {
            return "Game won by " + (scorePlayer1 > scorePlayer2 ? player1.getName() : player2.getName());
        }
    }
    
    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public boolean isGameWon() {
        int minScoreToWin = 4;
        int scoreDifference = Math.abs(scorePlayer1 - scorePlayer2);

        return (scorePlayer1 >= minScoreToWin || scorePlayer2 >= minScoreToWin) && scoreDifference >= 2;
    }
}
