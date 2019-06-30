package com.danf.connectfourdanf;

import static com.danf.connectfourdanf.ConfigHandler.EMPTY_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.GRID_HEIGHT;
import static com.danf.connectfourdanf.ConfigHandler.GRID_WIDTH;
import static com.danf.connectfourdanf.ConfigHandler.P1_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.P2_CIRCLE_CHAR;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConnectFourGame {

  private int roundCount;
  private ConnectFourGrid gameGrid;
  private int winner;

  ConnectFourGame() {
    this.gameGrid = new ConnectFourGrid();
    this.roundCount = 0;
    this.winner = 0;
    System.out.println("Let's get started.");
  }

  ConnectFourGrid getGameGrid() {
    return gameGrid;
  }

  private int getRoundCount() {
    return this.roundCount;
  }

  void setRoundCount(int roundCount) {
    this.roundCount = roundCount;
  }

  int getWinner() {
    return winner;
  }

  public void setWinner(int win) {
    this.winner = win;
  }

  int currentPlayer() {
    return ((this.roundCount + 1) % 2) + 1;
  }

  private int playerFromToken(char token) {
    if (token == P1_CIRCLE_CHAR) {
      return 1;
    } else if (token == P2_CIRCLE_CHAR) {
      return 2;
    } else {
      System.out.println("No such token is in play");
      return 0;
    }
  }

  private int acceptUserColumn() {
    try {
      Scanner myScanner = new Scanner(System.in);
      System.out.println("Enter the column you wish to play in.");
      return myScanner.nextInt() - 1;
    } catch (InputMismatchException ime) {
      System.out.println("Please enter a number from 1 to 7");
      return -1;
    }
  }

  /**
   * method to play a game of connect 4 round 0 is not a real round - just the intro
   */
  void playGame() {
    while (!this.weHaveAWinner()) {
      this.roundCount++;

      printRound();

      int userCol = acceptUserColumn();

      if (userCol > -1 && userCol < GRID_HEIGHT + 1) {

        if (this.getGameGrid().playPlayer(this.currentPlayer(), userCol) != -1) {
          System.out.println("Well played");
        } else {
          System.out.println("No such column");
          this.roundCount = this.roundCount - 1;
        }
      }
    }
    this.getGameGrid().printGrid();
    System.out.println("Player " + this.winner + " wins.");
  }

  private void printRound() {
    System.out.println("\r\n\r\n");
    System.out.println("*****************\r\nRound " + this.getRoundCount() + "\r\n");
    this.getGameGrid().printGrid();
    System.out
        .println("\r\nPlayer " + this.currentPlayer() + " to play using " + this.getGameGrid()
            .getTokenColour(this.currentPlayer()));
  }

  private boolean weHaveAWinner() {
    return (this.checkRows() || this.checkCols() || this.checkDiagonal());
  }

  boolean checkCols() {
    int repeats;
    for (int co = 0; co < GRID_WIDTH; co++) {
      repeats = 1;
      for (int ro = 1; ro < GRID_HEIGHT; ro++) {

        char tokeni = this.getGameGrid().getGridArray()[ro - 1][co];
        char tokenii = this.getGameGrid().getGridArray()[ro][co];

        if ((tokeni == tokenii) && (tokeni != EMPTY_CIRCLE_CHAR)) {
          repeats++;
          if (repeats > 3) {
            this.winner = this.playerFromToken(this.getGameGrid().getGridArray()[ro][co]);
            return true;
          }
        }
      }
    }
    return false;
  }

  boolean checkRows() {
    int repeats;
    for (int ro = 0; ro < GRID_HEIGHT; ro++) {
      repeats = 1;
      for (int co = 1; co < GRID_WIDTH; co++) {

        char tokeni = this.getGameGrid().getGridArray()[ro][co - 1];
        char tokenii = this.getGameGrid().getGridArray()[ro][co];

        if ((tokeni == tokenii) && (tokeni != EMPTY_CIRCLE_CHAR)) {
          repeats++;
          if (repeats > 3) {
            this.winner = this.playerFromToken(this.getGameGrid().getGridArray()[ro][co]);
            return true;
          }
        }

      }
    }

    return false;
  }

  private boolean checkDiagonal() {
    return false;
  }

}
