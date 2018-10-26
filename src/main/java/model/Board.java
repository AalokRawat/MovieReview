package model;

import constant.CellType;
import data.PlayerData;

/**
 * Created by aalokr on 4/7/18.
 */
public class Board {
    private int length, height;
    private Cell[][] cells;
    private Index startIndex;

    public Board(int length, int height) {
        this.length = length;
        this.height = height;
        cells = new Cell[height][length];
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public void initCells(Cell[][] cells) {
        this.cells = cells;
        setStartIndex();
    }

    public void setCell(int i, int j, char letter) {
        this.cells[i][j].setLetter(letter);
    }

    public Index getStartIndex() {
        return startIndex;
    }

    public void update(PlayerData data){
        this.cells = data.getBoard().cells;
    }

    void setStartIndex(){
        for (int i=0; i<height; i++){
            for (int j=0; j<length; j++) {
                if(cells[i][j].type.equals(CellType.St)){
                    this.startIndex=new Index(i, j);
                }
            }
        }
    }

    public void show(){
        for (int i=0; i<height; i++){
            for (int j=0; j<length; j++){
                System.out.print(cells[i][j].getData()+" ");
            }
            System.out.println();
        }
    }

}
