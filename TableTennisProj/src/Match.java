import java.util.Random;

class Match
{
    private Player player1;
    private Player player2;
    private Random random = new Random();

    public Match(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }

    // Simulates playing a match and randomly selects a winner
    public Player playMatch()
    {
        // Randomly decide the winner
        return random.nextBoolean() ? player1 : player2;
    }
}
