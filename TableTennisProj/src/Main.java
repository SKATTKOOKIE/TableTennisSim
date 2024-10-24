import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);

        // Enter player names
        System.out.println("Enter first name of a new player:");
        String firstName = myObj.nextLine();
        System.out.println("Enter last name of a new player:");
        String lastName = myObj.nextLine();

        List<Player> players = new ArrayList<>();

        // Add the new player
        players.add(new Player(firstName, lastName));

        // Add predefined players
        players.add(new Player("Alice", "Jones"));
        players.add(new Player("Bob", "Smith"));
        players.add(new Player("Charlie", "Brown"));
        players.add(new Player("Diana", "Davis"));
        players.add(new Player("Bobby", "Smithy"));
        players.add(new Player("Chuck", "Bronson"));
        players.add(new Player("Donald", "Duck"));
        players.add(new Player("Alison", "Hickman"));
        players.add(new Player("Roberta", "Cupcake"));
        players.add(new Player("Mike", "Scott"));
        players.add(new Player("Dian", "Davison"));
        players.add(new Player("Freya", "Jamison"));
        players.add(new Player("Brian", "Johnson"));
        players.add(new Player("Keith", "Richards"));

        Random random = new Random();

        // Continue the tournament until only one player remains
        int roundNumber = 1;

        while (players.size() > 1)
        {
            System.out.println("\n--- Round " + roundNumber + " ---");

            // New list to store winners of the current round
            List<Player> roundWinners = new ArrayList<>();

            // Shuffle players list to randomize matchups
            Collections.shuffle(players);

            // Loop through players in pairs
            for (int i = 0; i < players.size(); i += 2)
            {
                if (i + 1 < players.size())
                {
                    // Create a new match between two players
                    Player player1 = players.get(i);
                    Player player2 = players.get(i + 1);

                    Match match = new Match(player1, player2);
                    Player winner = match.playMatch();

                    // Winner advances to the next round
                    roundWinners.add(winner);

                    // Print match result
                    System.out.println("Match: " + player1 + " vs " + player2 + " - Winner: " + winner);
                }
                else
                {
                    // If there's an odd number of players, the last one advances automatically
                    Player autoWinner = players.get(i);
                    roundWinners.add(autoWinner);
                    System.out.println("Automatic advancement: " + autoWinner);
                }
            }

            // Update players list with winners for the next round
            players = roundWinners;
            roundNumber++;
        }

        // Print the final winner
        System.out.println("\nWinner of the tournament: " + players.get(0));
    }
}