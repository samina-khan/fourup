/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/
package samina.fourup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class GameBoard implements GlobalConstants{

    Hole[][] holes;
    int turn = GCRed;
    int[] colors = new int[2];

    private GameBoard(){}

    GameBoard(int numrows, int numcols){
           holes = new Hole[numrows][numcols];
    }

    public void onclick(ImageView i){
        i.setImageResource(colors[turn]);
        toggleTurn();
        for(Hole[] array : holes){
            for(Hole h : array){
                if(h.v == i) h.filled = turn;
            }
        }

    }

    private void toggleTurn(){
        turn = (turn == GCRed)?  GCYellow : GCRed;
    }
}
