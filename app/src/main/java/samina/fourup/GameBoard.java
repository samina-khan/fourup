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

    //Similar to a mediator pattern, receives the click event from one hole
    // and colors the first available hole in that column
    public void onclick(ImageView imageview){
        int theColumn = 0;
        for(int i=0 ; i<standardNumRows ; i++){
            for (int j=0; j<standardNumCols ; j++){
                if((holes[i][j].v == imageview)){
                    theColumn = j;
                    break;
                }
            }
        }
        for (int i = standardNumRows - 1; i >= 0 ; i--){
            System.out.println("[i][theColumn]: ["+i+"]["+theColumn+"]");
            if(holes[i][theColumn].filled == GCBlack){
                System.out.println("i:"+i);
                holes[i][theColumn].filled = turn;
                holes[i][theColumn].v.setImageResource(colors[turn]);
                toggleTurn();
                break;
            }
        }
        /*
        for(Hole[] array : holes){
            for(Hole h : array){
                if((h.v == i) && (h.filled == GCBlack)){
                    h.filled = turn;
                    i.setImageResource(colors[turn]);
                    toggleTurn();
                }
            }
        }*/

    }

    private void toggleTurn(){
        turn = (turn == GCRed)?  GCYellow : GCRed;
    }
}
