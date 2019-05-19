package com.danf.connectfourdanf;

import static com.danf.connectfourdanf.ConfigHandler.*;

import java.util.Arrays;

public class ConnectFourGrid {

  private char[][] gridArray = new char[GRID_HEIGHT][GRID_WIDTH];

  public ConnectFourGrid() {
    for (int ro = 0; ro < GRID_HEIGHT; ro++) {
      for (int co = 0; co < GRID_WIDTH; co++) {
        gridArray[ro][co] = EMPTY_CIRCLE_CHAR;
      }
    }
  }

  public ConnectFourGrid(char c) {
    for (int ro = 0; ro < GRID_HEIGHT; ro++) {
      for (int co = 0; co < GRID_WIDTH; co++) {
        gridArray[ro][co] = c;
      }
    }
  }

  public char[][] getGridArray() {
    return this.gridArray;
  }

  public void setGridArray(char[][] aGrid) {
    this.gridArray = aGrid;
  }

  public void printGrid() {
    for (int ro = 0; ro < GRID_HEIGHT; ro++) {
      char[] myRow = gridArray[ro];
      System.out.println(Arrays.toString(myRow));
    }
  }

  public void playPlayer(int playerNum, int col) {
    if (bottomEmptyCircle(col) == -1) {
      // todo check valid play and change the column
      System.out.println("Column is full.");
    } else if (playerNum == 1) {
      gridArray[bottomEmptyCircle(col)][col] = P1_CIRCLE_CHAR;
    } else if (playerNum == 2) {
      gridArray[bottomEmptyCircle(col)][col] = P2_CIRCLE_CHAR;
    } else if (playerNum == 0) {
      System.out.println("Game is over.");
    } else {
      System.out.println("No player to play.");
    }
  }

  public int bottomEmptyCircle(int co) {
    int bottomCircle = -1;
    int ro = 0;
    while (ro < GRID_HEIGHT) {
      if (gridArray[ro][co] == EMPTY_CIRCLE_CHAR) {
        bottomCircle = ro;
      }
      ro++;
    }
    return bottomCircle;
  }

  public char getTokenColour(int pl) {
    char pChar;
    if (pl == 1) {
      pChar = P1_CIRCLE_CHAR;
    } else if (pl == 2) {
      pChar = P2_CIRCLE_CHAR;
    } else {
      pChar = EMPTY_CIRCLE_CHAR;
    }
    return pChar;
  }


}
