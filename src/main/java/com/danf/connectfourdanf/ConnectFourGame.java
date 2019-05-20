package com.danf.connectfourdanf;

import static com.danf.connectfourdanf.ConfigHandler.EMPTY_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.GRID_HEIGHT;
import static com.danf.connectfourdanf.ConfigHandler.GRID_WIDTH;
import static com.danf.connectfourdanf.ConfigHandler.P1_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.P2_CIRCLE_CHAR;

import java.util.Scanner;

public class ConnectFourGame {

  private int roundCount;
  private ConnectFourGrid gameGrid;
  private int winner;

  public ConnectFourGame() {
    this.gameGrid = new ConnectFourGrid();
    this.roundCount = 0;
    this.winner = 0;
    System.out.println("New Connect 4 game.\r\nLet's get started.");
  }

  public ConnectFourGrid getGameGrid() {
    return gameGrid;
  }

  public int getRoundCount() {
    return this.roundCount;
  }

  public void setRoundCount(int roundCount) {
    this.roundCount = roundCount;
  }

  public int getWinner() {
    return winner;
  }

  public void setWinner(int win) {
    this.winner = win;
  }

  public int currentPlayer() {
    return ((this.roundCount + 1) % 2) + 1;
  }

  public int playerFromToken(char token) {
    if (token == P1_CIRCLE_CHAR) {
      return 1;
    } else if (token == P2_CIRCLE_CHAR) {
      return 2;
    } else {
      System.out.println("No such token is in play");
      return 0;
    }
  }

  public int acceptUserColumn() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("Enter the column you wish to play in.");
    return myScanner.nextInt() - 1;
  }

  /**
   * method to play a game of connect 4 round 0 is not a real round - just the intro
   */
  public void playGame() {
    while (this.winner == 0) {
      this.roundCount++;

      System.out.println("\r\n*****************\r\nStarting round number " + this.getRoundCount());

      this.getGameGrid().printGrid();

      System.out
          .println("\r\nPlayer " + this.currentPlayer() + " to play using " + this.getGameGrid()
              .getTokenColour(this.currentPlayer()));

      this.getGameGrid().playPlayer(this.currentPlayer(), acceptUserColumn());

      this.weHaveAWinner();
    }

    this.getGameGrid().printGrid();
    System.out.println("Player " + this.winner + " wins.");
  }

  public boolean weHaveAWinner() {
    return (this.checkRows() || this.checkCols() || this.checkDiagonal());
  }

  public boolean checkCols() {
    int repeats;

    for (int co = 0; co < GRID_WIDTH; co++) {
      repeats = 1;
      for (int ro = 1; ro < GRID_HEIGHT; ro++) {

        char tokeni = this.getGameGrid().getGridArray()[ro-1][co];
        char tokenii = this.getGameGrid().getGridArray()[ro][co];

        if ((tokeni==tokenii) && (tokeni != EMPTY_CIRCLE_CHAR)) {
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

  public boolean checkRows() {
    return false;
  }

  public boolean checkDiagonal() {
    return false;
  }

}
