package model;

import constant.Number;
import data.PlayerData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aalokr on 4/7/18.
 */

public class Player {
    private String name;
    private int score;
    private Number number;
    private List<Chip> chips;

    static List<Player> players;

    private Player(String name, Number number){
        this.name = name;
        this.number = number;
    }

    public void setChips(List<Chip> chips) {
        if(this.chips==null)
            this.chips = chips;
    }

    private void addChips(List<Chip> chips) {
        this.chips.addAll(chips);
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void update(PlayerData data){
        this.addScore(data.getPlayer().getScore());
        //this.addChips(data.getChips());
    }

    public static List<Player> createPlayers(String[] names) {
        if(players == null){
            Number[] numbers=Number.values();
            int playerSize=names.length;

            if (playerSize<=numbers.length) {
                players = new ArrayList<Player>();
                for (int i=0; i<playerSize; i++) {
                    players.add(new Player(names[i], numbers[i]));
                }
            }

        }
        return players;
    }

    public void show(){
        System.out.println("name : "+name+", score : "+score);
        for(Chip chip : chips){
            System.out.print(chip.toString()+" ");
        }
        System.out.println();
    }

}
