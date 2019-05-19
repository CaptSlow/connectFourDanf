package com.danf.connectfourdanf;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;

public class ConnectFourGridTest {

  private char emptyCircleChar = 'O';
  private int gridHeight = 6;

  @Test
  public void createConnectFourGrid() {
    char yChar = 'y';

    ConnectFourGrid connectFourGrid = new ConnectFourGrid();
    ConnectFourGrid connectFourGridY = new ConnectFourGrid(yChar);

    Assert.assertEquals(emptyCircleChar, connectFourGrid.getGridArray()[1][1]);
    Assert.assertEquals(yChar, connectFourGridY.getGridArray()[1][1]);

  }

  @Test
  public void gridPrintTest() {
    ConnectFourGrid connectFourGrid = new ConnectFourGrid();

    String aRow = "[O, O, O, O, O, O, O]";
    String expPrint =
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
    int colNum = 0;

    Assert.assertEquals(gridHeight - 1, cfg.bottomEmptyCircle(colNum));
    cfg.getGridArray()[gridHeight - 1][colNum] = 'R';

    Assert.assertEquals(gridHeight - 2, cfg.bottomEmptyCircle(colNum));
  }

}
