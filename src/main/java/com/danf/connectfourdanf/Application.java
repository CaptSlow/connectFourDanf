package com.danf.connectfourdanf;

import java.util.Scanner;

public class Application {

  private ConnectFourGame cfg;

  public Application(){
    System.out.println("Starting Connect Four App");
  }

  public void run(){
    this.cfg = new ConnectFourGame();
    String[] inArr = this.getUserInput();
  }

  /**
   * scan user input
   * @return String array of command and parameter
   */
  public String[] getUserInput(){
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine().split(" ");
  }

}
