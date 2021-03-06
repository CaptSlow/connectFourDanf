package com.danf.connectfourdanf;

import static com.danf.connectfourdanf.ConfigHandler.EMPTY_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.GRID_COLUMNS;
import static com.danf.connectfourdanf.ConfigHandler.GRID_HEIGHT;
import static com.danf.connectfourdanf.ConfigHandler.GRID_WIDTH;
import static com.danf.connectfourdanf.ConfigHandler.P1_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.P2_CIRCLE_CHAR;

import java.util.Arrays;

public class ConnectFourGrid {

  private char[][] gridArray = new char[GRID_HEIGHT][GRID_WIDTH];

  ConnectFourGrid() {
    for (int ro = 0; ro < GRID_HEIGHT; ro++) {
      for (int co = 0; co < GRID_WIDTH; co++) {
        gridArray[ro][co] = EMPTY_CIRCLE_CHAR;
      }
    }
  }

  ConnectFourGrid(char c) {
    for (int ro = 0; ro < GRID_HEIGHT; ro++) {
      for (int co = 0; co < GRID_WIDTH; co++) {
        gridArray[ro][co] = c;
      }
    }
  }

  char[][] getGridArray() {
    return this.gridArray;
  }

  public void setGridArray(char[][] aGrid) {
    this.gridArray = aGrid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ConnectFourGrid)) {
      return false;
    }
    ConnectFourGrid that = (ConnectFourGrid) o;
    return Arrays.equals(gridArray, that.gridArray);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(gridArray);
  }

  void printGrid() {
    System.out.println(GRID_COLUMNS);
    for (int ro = 0; ro < GRID_HEIGHT; ro++) {
      char[] myRow = gridArray[ro];
      for (int co = 0; co < GRID_WIDTH; co++) {
        if (co == 0) {
          System.out.print("| ");
        }
        System.out.print(myRow[co] + " ");
        if (co == GRID_WIDTH - 1) {
          System.out.println("|");
        }
      }
    }
  }

  int playPlayer(int playerNum, int col) {
    if (playerNum != 1 && playerNum != 2) {
      System.out.println("Invalid player number");
      return -1;
    } else if (bottomEmptyCircle(col) == -1) {
      System.out.println("Column is full.");
      return -1;
    } else {
      this.gridArray[bottomEmptyCircle(col)][col] = (playerNum == 1 ? P1_CIRCLE_CHAR
          : P2_CIRCLE_CHAR);
      return playerNum;
    }

  }

  int bottomEmptyCircle(int co) {
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

  char getTokenColour(int pl) {

    if (pl == 1) {
      return P1_CIRCLE_CHAR;
    } else if (pl == 2) {
      return P2_CIRCLE_CHAR;
    } else {
      return EMPTY_CIRCLE_CHAR;
    }
  }

}
