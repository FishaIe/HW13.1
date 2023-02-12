import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> playersList = new ArrayList<>();

    public void register(Player player) {
        playersList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int i = 0;
        for (Player player : playersList) {
            if (player.getName().equals(playerName1) | player.getName().equals(playerName2)) {
                i = i + 1;
            }
        }
        if (i == 2) {
            for (Player player : playersList) {
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
        for (Player player : playersList) {
            if (player.getName().equals(name)) {
                tmp = player.strength;
            }
        }
        return tmp;
    }

}
