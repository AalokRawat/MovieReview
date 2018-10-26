package model;

import constant.CellType;

/**
 * Created by aalokr on 4/7/18.
 */
public class Cell {
    Character letter;
    CellType type;

    public Cell(CellType type) {
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public String getData() {
        if(letter!=null)
            return letter.toString();
        else
            return type.toString();
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }
}
