package model;

import constant.Direction;
import constant.Number;

import java.util.List;

/**
 * Created by aalokr on 4/7/18.
 */
public class Word {
    String str;
    Index from, to;

    public Word(String str, Index from, Index to) {
        this.str = str;
        this.from = from;
        this.to = to;
    }

    public String getStr() {
        return str;
    }

    public Index getFromIndex() {
        return from;
    }

    public Index getToIndex() {
        return to;
    }
}
