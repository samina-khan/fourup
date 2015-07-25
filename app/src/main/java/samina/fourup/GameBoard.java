/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/
package samina.fourup;

import android.widget.ImageView;

public class GameBoard implements GlobalConstants{

        Hole[][] holes;
        private GameBoard(){}

        GameBoard(int numrows, int numcols){
               holes = new Hole[numrows][numcols];
        }

}
