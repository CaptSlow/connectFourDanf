package com.danf.connectfourdanf;

import java.util.Scanner;

public class ConnectFourGame {

  private int roundCount;
  private ConnectFourGrid gameGrid;
  private int winner;

  public ConnectFourGame() {
    this.roundCount = 0;
    this.gameGrid = new ConnectFourGrid();
    this.winner = 0;
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

  public int acceptUserColumn() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("Enter the column you wish to play in.");
    return myScanner.nextInt() - 1;
  }

  public void playGame() {
    while (this.winner == 0) {
      // 0th round is new game
      if (this.getRoundCount() == 0) {
        System.out.println("Welcome to Danf's Connect Four game.\nLet's get started.");
        this.roundCount++;
      }

      System.out.println("\n******************\nStarting round number " + this.getRoundCount());
      this.getGameGrid().printGrid();
      System.out.println("\nPlayer " + this.currentPlayer() + " to play using " + this.getGameGrid()
          .getTokenColour(this.currentPlayer()));
      this.getGameGrid().playPlayer(this.currentPlayer(), acceptUserColumn());
      // todo check if there is a winner

      this.roundCount++;
    }
  }
}
