package com.danf.connectfourdanf;

import static com.danf.connectfourdanf.ConfigHandler.EMPTY_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.GRID_HEIGHT;
import static com.danf.connectfourdanf.ConfigHandler.GRID_WIDTH;
import static com.danf.connectfourdanf.ConfigHandler.P1_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.P2_CIRCLE_CHAR;

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
    if (playerNum != 1 && playerNum != 2) {
      System.out.println("Invalid player number");
    } else if (bottomEmptyCircle(col) == -1) {
      System.out.println("Column is full.");
    } else {
      this.gridArray[bottomEmptyCircle(col)][col] = (playerNum == 1 ? P1_CIRCLE_CHAR
          : P2_CIRCLE_CHAR);
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

    if (pl == 1) {
      return P1_CIRCLE_CHAR;
    } else if (pl == 2) {
      return P2_CIRCLE_CHAR;
    } else {
      return EMPTY_CIRCLE_CHAR;
    }
  }

}
