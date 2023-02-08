import java.util.HashSet;

public class Game {

    private Player[] players = new Player[0];
    HashSet<String> playersList = new HashSet<>();

    public void register(Player player) {
        playersList.add(player.getName());
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];
        }
        tmp[tmp.length - 1] = player;
        players = tmp;
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

    public int getStrength(String name){
        int tmp = 0;
        for(Player player : players){
            if (player.getName() == name){
                tmp = player.strength;
            }
        }
        return tmp;
    }

}
