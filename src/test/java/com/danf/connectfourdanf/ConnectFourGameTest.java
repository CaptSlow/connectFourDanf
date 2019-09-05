package com.danf.connectfourdanf;

import static com.danf.connectfourdanf.ConfigHandler.GRID_HEIGHT;

import org.junit.Assert;
import org.junit.Test;

public class ConnectFourGameTest {

  @Test
  public void currentPlayerTest(){
    ConnectFourGame cfGame = new ConnectFourGame();

    cfGame.setRoundCount(1);
    Assert.assertEquals(1,cfGame.currentPlayer());

    cfGame.setRoundCount(6);
    Assert.assertEquals(2,cfGame.currentPlayer());

    cfGame.setRoundCount(7);
    Assert.assertEquals(1,cfGame.currentPlayer());

  }

  @Test
  public void checkColsTest(){

    ConnectFourGame cfGame = new ConnectFourGame();
    int colNum = 0;

    Assert.assertFalse(cfGame.checkCols(cfGame.getGameGrid()));
    Assert.assertEquals(0,cfGame.getWinner());

    cfGame.getGameGrid().getGridArray()[0][colNum]='R';
    cfGame.getGameGrid().getGridArray()[1][colNum]='R';
    cfGame.getGameGrid().getGridArray()[2][colNum]='R';
    cfGame.getGameGrid().getGridArray()[3][colNum]='R';

    Assert.assertTrue(cfGame.checkCols(cfGame.getGameGrid()));
    Assert.assertEquals(2,cfGame.getWinner());

  }

  @Test
  public void checkRowsRWinner() {
    ConnectFourGame cfGame = new ConnectFourGame();
    int rowNum = 0;

    Assert.assertFalse(cfGame.checkRows(cfGame.getGameGrid()));
    Assert.assertEquals(0,cfGame.getWinner());

    cfGame.getGameGrid().getGridArray()[rowNum][0]='R';
    cfGame.getGameGrid().getGridArray()[rowNum][1]='R';
    cfGame.getGameGrid().getGridArray()[rowNum][2]='R';
    cfGame.getGameGrid().getGridArray()[rowNum][3]='R';

    Assert.assertTrue(cfGame.checkRows(cfGame.getGameGrid()));
    Assert.assertEquals(2,cfGame.getWinner());

  }

  @Test
  public void checkRowsNoWinner() {
    ConnectFourGame cfGame = new ConnectFourGame();
    int rowNum = 0;

    Assert.assertFalse(cfGame.checkRows(cfGame.getGameGrid()));
    Assert.assertEquals(0,cfGame.getWinner());

    cfGame.getGameGrid().getGridArray()[rowNum][0]='R';
    cfGame.getGameGrid().getGridArray()[rowNum][1]='R';
    cfGame.getGameGrid().getGridArray()[rowNum][2]='R';

    cfGame.getGameGrid().printGrid();

    Assert.assertFalse(cfGame.checkRows(cfGame.getGameGrid()));
    Assert.assertEquals(0,cfGame.getWinner());

  }

  @Test
  public void checkRowsNoWinner2() {
    ConnectFourGame cfGame = new ConnectFourGame();

    Assert.assertFalse(cfGame.checkRows(cfGame.getGameGrid()));
    Assert.assertEquals(0,cfGame.getWinner());

    cfGame.getGameGrid().getGridArray()[GRID_HEIGHT-1][0]='R';
    cfGame.getGameGrid().getGridArray()[GRID_HEIGHT-1][1]='R';
    cfGame.getGameGrid().getGridArray()[GRID_HEIGHT-1][2]='R';

    cfGame.getGameGrid().printGrid();

    Assert.assertFalse(cfGame.checkRows(cfGame.getGameGrid()));
    Assert.assertEquals(0,cfGame.getWinner());

  }
}
