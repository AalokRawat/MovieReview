
import data.GameData;
import data.PlayerData;
import model.Board;
import model.Index;
import model.Player;
import model.Word;
import service.Scrabble;
import service.ScrabbleBeginners;

import java.util.List;

/**
 * Created by aalokr on 4/7/18.
 */
public class Main {
    public static void main(String[] args) {
        Scrabble scrabble = new ScrabbleBeginners();
        GameData gameData;
        gameData = new GameData(new Board(10, 10),
                Player.createPlayers(new String[]{"player1", "player2"}));
        gameData = scrabble.start(gameData);

        //load board and players data
        Board board = gameData.getBoard();
        Player player1 = gameData.getPlayers().get(0);
        Player player2 = gameData.getPlayers().get(1);
        board.show();

        Word word = new Word("game", new Index(1, 4), new Index(1, 1));
        PlayerData data = scrabble.move(player1, word);
        player1 = data.getPlayer();
        board.update(data);

        word = new Word("meet", new Index(1, 3), new Index(1, 6));
        data = scrabble.move(player2, word);
        player2 = data.getPlayer();
        board.update(data);

        player1.show();
        player2.show();
        board.show();
    }
}
