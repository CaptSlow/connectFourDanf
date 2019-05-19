package com.danf.connectfourdanf;

import java.util.Arrays;

public class ConnectFourGrid {

  private int gridWidth = 7;
  private int gridHeight = 6;
  private char emptyCircleChar = 'O';
  private char p1CircleChar = 'Y';
  private char p2CircleChar = 'R';

  private char[][] gridArray = new char[gridHeight][gridWidth];

  public ConnectFourGrid() {
    for (int ro = 0; ro < gridHeight; ro++) {
      for (int co = 0; co < gridWidth; co++) {
        gridArray[ro][co] = emptyCircleChar;
      }
    }
  }

  public ConnectFourGrid(char c) {
    for (int ro = 0; ro < gridHeight; ro++) {
      for (int co = 0; co < gridWidth; co++) {
        gridArray[ro][co] = c;
      }
    }
  }

  // methods
  public char[][] getGridArray() {
    return this.gridArray;
  }

  public void setGridArray(char[][] aGrid) {
    this.gridArray = aGrid;
  }

  public void printGrid() {
    for (int ro = 0; ro < gridHeight; ro++) {
      char[] myRow = gridArray[ro];
      System.out.println(Arrays.toString(myRow));
    }
  }

  public void playPlayer(int player, int col) {
    if (bottomEmptyCircle(col) == -1) {
      // todo check valid play and change the column
      System.out.println("Column is full.");
    } else if (player == 1) {
      gridArray[bottomEmptyCircle(col)][col] = p1CircleChar;
    } else if (player == 2) {
      gridArray[bottomEmptyCircle(col)][col] = p2CircleChar;
    } else if (player == 0) {
      System.out.println("Game is over.");
    } else {
      System.out.println("No player to play.");
    }
  }

  public int bottomEmptyCircle(int co) {
    int bottomCircle = -1;
    int ro = 0;
    while (ro < gridHeight) {
      if (gridArray[ro][co] == emptyCircleChar) {
        bottomCircle = ro;
      }
      ro++;
    }
    return bottomCircle;
  }

  public void printCircle(int iRow, int iCol) {
    System.out.println(this.gridArray[iRow][iCol]);
  }

  public char getTokenColour(int pl) {
    char pChar;
    if (pl == 1) {
      pChar = p1CircleChar;
    } else if (pl == 2) {
      pChar = p2CircleChar;
    } else {
      pChar = emptyCircleChar;
    }
    return pChar;
  }
}