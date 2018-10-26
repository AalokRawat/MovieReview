package data;

import model.Board;
import model.Chip;
import model.Player;

import java.util.List;

/**
 * Created by aalokr on 4/7/18.
 */
public class GameData {
    private Board board;
    private List<Player> players;

    public GameData(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
