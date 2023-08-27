package tennismatch;

public class Main {
    public static void main(String[] args) {
        Player federer = new Player("Federer");
        Player nadal = new Player("Nadal");
        TennisMatch match = new TennisMatch(federer, nadal, 3); // 3 sets to win the match

        match.playSet();
        match.playSet();
        match.playSet();

        System.out.println(match.getCurrentScore());
        System.out.println(match.getDetailedScoreboard());
    }
}
