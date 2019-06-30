package com.danf.connectfourdanf;

import java.util.Scanner;

public class Application {

  private ConnectFourGame cfGame;

  Application() {
    System.out.println("Starting Connect Four App");
  }

  /**
   * run the application
   */
  void run() {
    this.cfGame = new ConnectFourGame();
    cfGame.playGame();
  }

  /**
   * scan user input
   *
   * @return String array of command and parameter
   */
  public String[] getUserInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine().split(" ");
  }

}
