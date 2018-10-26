package service;

import constant.CellType;
import constant.Direction;
import data.GameData;
import data.PlayerData;
import model.Board;
import model.Cell;
import model.Chip;
import model.Index;
import model.Player;
import model.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aalokr on 4/7/18.
 */
public class ScrabbleBeginners implements Scrabble{
    private String str = "abcdefghijklmnopqrstuvwxyz";
    private Board board;

    private void setBoard(Board board) {
        this.board = board;
    }

    private int getPoint(Character letter){
        return ('z'-letter)/4;
    }

    private void initBoard(Board board){
        int len = board.getLength();
        int hight = board.getHeight();
        Cell[][] cells = new Cell[hight][len];

        for(int i=0; i<hight; i++){
            for(int j=0; j<len; j++){
                if(i==j){
                    cells[i][j] = new Cell(CellType.LS);
                } else if(i==len-j-1) {
                    cells[i][j] = new Cell(CellType.WS);
                } else{
                    cells[i][j] = new Cell(CellType.S);
                }
            }
        }
        cells[1][4] = new Cell(CellType.St);
        board.initCells(cells);
    }

    private void generateChipsScore(Player player) {
        generateChipsScore(player, str.length());
    }

    private void generateChipsScore(Player player, int len){
        List<Chip> chips = new ArrayList<Chip>();
        Character letter;
        int inc = str.length()/len;
        for(int i=0; i<len; i+=inc){
            letter = str.charAt(i);
            chips.add(new Chip(letter, getPoint(letter)));
        }
        player.setChips(chips);
    }

    private int countScore(String str, int s, int e){
        int score=0;
        for(int i=0; i<e-s; i++)
            score+=getPoint(str.charAt(i));

        return score;
    }

    private void fill(int si, int ei, int sj, int ej, String str){
        int count=0;
        for(int i=si; i<=ei; i++){
            for(int j=sj; j<=ej; j++)
                board.setCell(i, j, str.charAt(count++));
        }
    }

    private void updateBoard(Word word, Direction direction){
        Index from = word.getFromIndex();
        Index to = word.getToIndex();
        String str = word.getStr();

        if(direction.equals(Direction.RIGHT) || direction.equals(Direction.DOWN))
            fill(from.getI(), to.getI(), from.getJ(), to.getJ(), str);
        else{
            fill(to.getI(), from.getI(), to.getJ(), from.getJ(), str);
        }
    }

    private int updateBoard(Word word){
        Index from = word.getFromIndex();
        Index to = word.getToIndex();
        String str = word.getStr();
        int i, j;
        Direction direction;

        if(from.getI()==to.getI()) {
            if(from.getJ()<to.getJ()) {
                i = from.getJ(); j = to.getJ();
                direction = Direction.RIGHT;
            } else {
                i = to.getJ(); j = from.getJ();
                direction = Direction.LEFT;
            }
        } else{
            if(from.getI()<to.getI()){
                i = from.getI(); j = to.getI();
                direction = Direction.DOWN;
            } else {
                i = to.getI(); j = from.getI();
                direction = Direction.UP;
            }
        }
        updateBoard(word, direction);
        return countScore(str, i, j);
    }

    public GameData start(GameData gameData) {
        initBoard(gameData.getBoard());
        setBoard(gameData.getBoard());
        for(Player player : gameData.getPlayers())
            generateChipsScore(player);
        return new GameData(board, gameData.getPlayers());
    }

    public PlayerData move(Player player, Word word) {
        player.addScore(updateBoard(word));
        return new PlayerData( board, player);
    }
}
