package service;

import data.GameData;
import data.PlayerData;
import model.Board;
import model.Player;
import model.Word;

/**
 * Created by aalokr on 4/7/18.
 */
public interface Scrabble {
    GameData start(GameData gameData);
    PlayerData move(Player player, Word word);
}
