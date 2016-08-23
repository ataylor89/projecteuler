package problems.problem54;

/**
 *
 * @author ataylor
 */
public class Score {
    int player1wins = 0;
    int player2wins = 0;

    public void addResult(Result result) {
        player1wins += result.player1;
        player2wins += result.player2;
    }
    
    @Override
    public String toString() {
        return "Player 1: " + player1wins + "\tPlayer 2: " + player2wins;
    }
}
