// util class for serialization needs of other classes
package sudoku;
import java.io.*;
import java.awt.*;

public class Serialization implements Serializable {

    static final long serialVersionUID =0Xabcdef;
    private int[][] grid;
    /*USER SETTINGS ATTRIBUTES*/
     Color CI;
     Color CB;
     Color CF;
     Color PB;
     int lookandfeel;
    
    Serialization(int[][] grid_){
        grid=grid_;
    }
    Serialization(){}
    
     int[][] getGrid(){
        return grid;
    }
    
}