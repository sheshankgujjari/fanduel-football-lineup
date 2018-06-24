package process.util;

import com.google.common.base.Strings;
import process.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Player> getListofPlayers(List<Player> players, String position) {
        List<Player> filteredPlayer = new ArrayList<>();
        for (Player player: players) {
            if(player.getPosition().equals(position)) {
                filteredPlayer.add(player);
            }
        }
        return filteredPlayer;
    }

    public static List<Player> buildPlayers(String message) {
        System.out.println("Identifying Message Type");
        List<Player> players = new ArrayList<Player>();
        if (Strings.isNullOrEmpty(message)) {
            System.out.println("Message is null or empty");
            return null;
        }
        for (String line : message.split("\n")) {
            String[] person = line.split(",");

            Player player = new Player();
            player.setId(person[0]);
            player.setPosition(person[1]);
            player.setFirstName(person[2]);
            player.setLastName(person[3]);
            player.setSalary(person[4]);
            player.setTeam(person[5]);
            players.add(player);
        }
        return players;
    }

    public static String constructLineUp(String position, String team, String firstName, String lastName,
                                         String salary) {
        String result = "Position: " + position + " Team: " + team + " Name: " +firstName +"," +lastName + " Salary: "
                +salary;
        return result;
    }
}
