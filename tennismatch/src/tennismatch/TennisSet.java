package tennismatch;

import java.util.ArrayList;
import java.util.List;

class TennisSet {
    private List<TennisGame> games;
    private Player player1;
    private Player player2;
    private int player1GamesWon;
    private int player2GamesWon;

    public TennisSet(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.games = new ArrayList<>();
        this.player1GamesWon = 0;
        this.player2GamesWon = 0;
        // Initialize games and manage game sequence
    }

    public void playGame() {
        TennisGame game = new TennisGame(player1, player2);
        games.add(game);

        while (!game.isGameWon()) {
            Player servingPlayer = (games.size() % 2 == 1) ? player1 : player2;
            Player receivingPlayer = (servingPlayer == player1) ? player2 : player1;

            // Simulate the game and update scores
            if (Math.random() < 0.5) {
                game.playerScores(servingPlayer);
            } else {
                game.playerScores(receivingPlayer);
            }
        }

        if (game.isGameWon()) {
            if (game.getScorePlayer1() > game.getScorePlayer2()) {
                player1GamesWon++;
            } else {
                player2GamesWon++;
            }
        }
    }

    public String getScore() {
        // Return the set score
        StringBuilder scoreBuilder = new StringBuilder();
        for (TennisGame game : games) {
            scoreBuilder.append(game.getScore()).append(", ");
        }
        return scoreBuilder.toString();
    }

    public boolean isSetOver() {
        return player1GamesWon >= 6 || player2GamesWon >= 6 || (player1GamesWon == 5 && player2GamesWon == 5);
    }

    public Player getWinner() {
        if (player1GamesWon > player2GamesWon) {
            return player1;
        } else {
            return player2;
        }
    }

    private boolean isSetWon() {
        return (player1GamesWon >= 6 || player2GamesWon >= 6) && Math.abs(player1GamesWon - player2GamesWon) >= 2;
    }
}
