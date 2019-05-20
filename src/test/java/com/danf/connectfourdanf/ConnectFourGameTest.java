package com.danf.connectfourdanf;

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

    Assert.assertFalse(cfGame.checkCols());
    Assert.assertEquals(0,cfGame.getWinner());

    cfGame.getGameGrid().getGridArray()[0][colNum]='R';
    cfGame.getGameGrid().getGridArray()[1][colNum]='R';
    cfGame.getGameGrid().getGridArray()[2][colNum]='R';
    cfGame.getGameGrid().getGridArray()[3][colNum]='R';

    Assert.assertTrue(cfGame.checkCols());
    Assert.assertEquals(2,cfGame.getWinner());

  }

}