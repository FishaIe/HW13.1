import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<String> playersList = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        playersList.add(player.getName());
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (playersList.contains(playerName1) & playersList.contains(playerName2)) {
            for (Player player : players) {
                if (getStrength(playerName1) > getStrength(playerName2)) {
                    return 1;
                } else if (getStrength(playerName1) < getStrength(playerName2)) {
                    return 2;
                }
            }
        } else {
            throw new NotRegisteredException(
                    "Один из игроков не зарегистрирован!"
            );
        }
        return 0;
    }

    public int getStrength(String name) {
        int tmp = 0;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                tmp = player.strength;
            }
        }
        return tmp;
    }

}
