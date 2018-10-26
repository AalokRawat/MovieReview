package model;

/**
 * Created by aalokr on 4/7/18.
 */
public class Chip {
    char letter;
    int score;

    public Chip(char letter, int score) {
        this.letter = letter;
        this.score = score;
    }

    @Override
    public String toString() {
        return letter + ", " + score ;
    }
}
