
package randomgrid;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Runnan Dong
 * pawprint:rdyz6
 * date:Jan 27th
 */
public class buildCheckerBoard {
    private int numRows;
    private int numCols;
    private Color lightColor;
    private Color darkColor;
    private double boardHeight;
    private double boardWidth;
    private double rectHeight;
    private double rectWidth;
    private AnchorPane board;
    private int x;
    
    public buildCheckerBoard(int numRows, int numCols, double boardHeight, double boardWidth)
    {
        this(numRows, numCols, boardHeight, boardWidth, Color.RED, Color.BLACK);
    }
    
    public buildCheckerBoard(int numRows, int numCols, double boardHeight, double boardWidth, Color lightColor, Color darkColor)
    {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        this.rectWidth = calRectWidth();
        this.rectHeight = calRectHeight();

    }
    public int printX(int x){
        
        return x;
    }
    public double calRectWidth(){
        double rectWidth =Math.ceil(boardWidth / numCols);
        return rectWidth;
    }
    public double calRectHeight(){
        double rectHeight = Math.ceil(boardHeight / numRows);
        return rectHeight;
    }
    public int getNumRows()
    {
        return numRows;
    }

    public int getNumCols()
    {
        return numCols;
    }

    public double getWidth(double num)
    {
        boardWidth = num;
        return boardWidth;
    }

    public double getHeight(double num)
    {
        boardHeight = num;
        return boardHeight;
    }

    public double getRectangleWidth()
    {
        return rectWidth;
    }

    public double getRectangleHeight()
    {
        return rectHeight;
    }
    
    public Color getLightColor()
    {
        return lightColor;
    }

    public Color getDarkColor()
    {
        return darkColor;
    }
    
    public AnchorPane getBoard()
    {
        return board;
    }
    
    public AnchorPane build()
    {
        AnchorPane checkerBoard = new AnchorPane();
        for (int col = 0; col < numCols; col++)
        {
            for (int row = 0; row < numRows; row++)
            {
                Rectangle rect = null;
                if(col%2 == 0){
                    if(row%2 == 0){
                        rect = new Rectangle(rectWidth, rectHeight, lightColor);
                    }
                    else{
                        rect = new Rectangle(rectWidth, rectHeight, darkColor);
                    }
                }
                else if(col%2!=0){
                    if(row%2 != 0){
                        rect = new Rectangle(rectWidth, rectHeight, lightColor);
                    }
                    else{
                        rect = new Rectangle(rectWidth, rectHeight, darkColor);
                    }
                    
                }
                AnchorPane.setTopAnchor(rect, col * rectHeight);
                AnchorPane.setLeftAnchor(rect, row * rectWidth);
                checkerBoard.getChildren().add(rect);
            }
            
        }
        
        this.board = checkerBoard;
        
        return checkerBoard;
    }
    
    
}
