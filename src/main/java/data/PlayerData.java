package data;

import model.Board;
import model.Chip;
import model.Player;

import java.util.List;

/**
 * Created by aalokr on 4/7/18.
 */
public class PlayerData {
    private Board board;
    private Player player;

    public PlayerData(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }
}
