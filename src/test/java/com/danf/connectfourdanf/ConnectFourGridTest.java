package com.danf.connectfourdanf;

import static com.danf.connectfourdanf.ConfigHandler.EMPTY_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.GRID_COLUMNS;
import static com.danf.connectfourdanf.ConfigHandler.GRID_HEIGHT;
import static com.danf.connectfourdanf.ConfigHandler.P1_CIRCLE_CHAR;
import static com.danf.connectfourdanf.ConfigHandler.P2_CIRCLE_CHAR;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;

public class ConnectFourGridTest {

  @Test
  public void createConnectFourGrid() {
    char yChar = 'y';

    ConnectFourGrid connectFourGrid = new ConnectFourGrid();
    ConnectFourGrid connectFourGridY = new ConnectFourGrid(yChar);

    Assert.assertEquals(EMPTY_CIRCLE_CHAR, connectFourGrid.getGridArray()[1][1]);
    Assert.assertEquals(yChar, connectFourGridY.getGridArray()[1][1]);

  }

  @Test
  public void gridPrintTest() {
    ConnectFourGrid connectFourGrid = new ConnectFourGrid();

    String aRow = "[_, _, _, _, _, _, _]";
    String expPrint = GRID_COLUMNS + "\r\n" +
        aRow + "\r\n" + aRow + "\r\n" + aRow + "\r\n" + aRow + "\r\n" + aRow + "\r\n" + aRow
            + "\r\n";

    ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
    System.setOut(new PrintStream(actualPrint));

    connectFourGrid.printGrid();

    Assert.assertEquals(expPrint, actualPrint.toString());
  }

  @Test
  public void bottomEmptyCircleTest() {
    ConnectFourGrid cfg = new ConnectFourGrid();
    char rChar = 'R';
    int colNum = 0;

    Assert.assertEquals(GRID_HEIGHT - 1, cfg.bottomEmptyCircle(colNum));
    cfg.getGridArray()[GRID_HEIGHT - 1][colNum] = rChar;

    Assert.assertEquals(GRID_HEIGHT - 2, cfg.bottomEmptyCircle(colNum));

    for (int i = 0; i < GRID_HEIGHT; i++) {
      cfg.getGridArray()[i][colNum] = rChar;
    }

    Assert.assertEquals(-1, cfg.bottomEmptyCircle(colNum));

  }

  @Test
  public void getTokenColourTest() {
    ConnectFourGrid cfg = new ConnectFourGrid();

    Assert.assertEquals(P1_CIRCLE_CHAR, cfg.getTokenColour(1));
    Assert.assertEquals(P2_CIRCLE_CHAR, cfg.getTokenColour(2));

    Assert.assertEquals(EMPTY_CIRCLE_CHAR, cfg.getTokenColour(-1));
    Assert.assertEquals(EMPTY_CIRCLE_CHAR, cfg.getTokenColour(0));
    Assert.assertEquals(EMPTY_CIRCLE_CHAR, cfg.getTokenColour(3));
  }

  @Test
  public void playPlayerTest(){
    ConnectFourGrid cfg = new ConnectFourGrid();
    int colNum=0;
    String colFullStr = "Column is full.\r\n";

    cfg.playPlayer(1,colNum);
    Assert.assertEquals(P1_CIRCLE_CHAR,cfg.getGridArray()[GRID_HEIGHT-1][colNum]);

    cfg.playPlayer(2,colNum);
    Assert.assertEquals(P2_CIRCLE_CHAR,cfg.getGridArray()[GRID_HEIGHT-2][colNum]);

    cfg.playPlayer(1,colNum);
    cfg.playPlayer(2,colNum);
    cfg.playPlayer(1,colNum);
    cfg.playPlayer(2,colNum);

    ByteArrayOutputStream actualPrint = new ByteArrayOutputStream();
    System.setOut(new PrintStream(actualPrint));
    cfg.playPlayer(1,colNum);

    Assert.assertEquals(colFullStr,actualPrint.toString());

  }

}
