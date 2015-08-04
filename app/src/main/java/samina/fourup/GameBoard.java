/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/
package samina.fourup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class GameBoard implements GlobalConstants{

    Hole[][] holes;
    int turn = GCRed;
    int winner = GCBlack;
    int[] colors = new int[2];
    int[] overlays = new int[2];
    public boolean gameover = false;
    AI ai;
    int mode = GCPlayPass;

    private GameBoard(){}

    GameBoard(int numrows, int numcols,int mode){
        holes = new Hole[numrows][numcols];
        this.mode = mode;
        if(mode == GCPlayAI) {
            ai = new AI(new AIBoard(standardNumRows, standardNumCols, numDisksToWin));
        }
    }

    //Similar to a mediator pattern, receives the click event from one hole
    // and colors the first available hole in that column
    public void onclick(ImageView imageview){
        int theColumn = 0;
        boolean gameWon = false;

        //Find the column clicked by user
        for(int i=0 ; i<standardNumRows ; i++){
            for (int j=0; j<standardNumCols ; j++){
                if((holes[i][j].v == imageview)){
                    theColumn = j;
                    break;
                }
            }
        }

        //Fill the bottom-most available slot in that column - i.e simulate disk drop to bottom
        for (int i = standardNumRows - 1; i >= 0 ; i--){

            if(holes[i][theColumn].filled == GCBlack){
                holes[i][theColumn].filled = turn;
                holes[i][theColumn].v.setImageResource(colors[turn]);
                holes[i][theColumn].overlay.setImageResource(overlays[turn]);
                if(mode == GCPlayAI) {
                    if(ai != null) {
                        ai.board.makeMovePlayer(theColumn);
                        toggleTurn();
                        int AIColumn = ai.makeTurn();
                        drawDiskFillForAI(AIColumn);
                    }
                    else{
                        System.out.println("Unexpected error: ai is null");
                    }
                }
                toggleTurn();

                break;
            }
        }

    }

    private void drawDiskFillForAI(int theColumn) {
        for (int i = standardNumRows - 1; i >= 0 ; i--){

            if(holes[i][theColumn].filled == GCBlack){
                holes[i][theColumn].filled = turn;
                holes[i][theColumn].v.setImageResource(colors[turn]);
                holes[i][theColumn].overlay.setImageResource(overlays[turn]);
                break;
            }
        }
        checkWin();
    }

    //checks if game has been won and by which player
    //Algorithm from code at http://www.javaprogrammingforums.com/whats-wrong-my-code/44811-making-counter-ai-connect-4-game.html
    public int checkWin() {

        //checking vertical win
        for(int i = 0; i < standardNumRows - 3 ; i++){
            for(int j = 0; j < standardNumCols ; j++){
                if(holes[i][j].filled != GCBlack &&
                        holes[i][j].filled == holes[i+1][j].filled &&
                        holes[i][j].filled == holes[i+2][j].filled &&
                        holes[i][j].filled == holes[i+3][j].filled){

                    winner = holes[i][j].filled;
                    gameover = true;

                    holes[i][j].overlay.setVisibility(View.VISIBLE);
                    holes[i+1][j].overlay.setVisibility(View.VISIBLE);
                    holes[i+2][j].overlay.setVisibility(View.VISIBLE);
                    holes[i+3][j].overlay.setVisibility(View.VISIBLE);

                    System.out.println("Won! "+winner);
                }
            }
        }

        //checking horizontal win
        for(int i = 0; i < standardNumRows ; i++){
            for(int j = 0; j < standardNumCols - 3; j++){
                if(holes[i][j].filled != GCBlack &&
                        holes[i][j].filled == holes[i][j+1].filled &&
                        holes[i][j].filled == holes[i][j+2].filled &&
                        holes[i][j].filled == holes[i][j+3].filled){

                    winner = holes[i][j].filled;
                    gameover = true;

                    holes[i][j].overlay.setVisibility(View.VISIBLE);
                    holes[i][j+1].overlay.setVisibility(View.VISIBLE);
                    holes[i][j+2].overlay.setVisibility(View.VISIBLE);
                    holes[i][j+3].overlay.setVisibility(View.VISIBLE);

                    System.out.println("Won! "+winner);
                }
            }
        }


        //checking diagonal
        for(int i = 0; i < standardNumRows - 3; i++){
            for(int j = 0; j < standardNumCols - 3; j++){
                if(holes[i][j].filled != GCBlack &&
                        holes[i][j].filled == holes[i+1][j+1].filled &&
                        holes[i][j].filled == holes[i+2][j+2].filled &&
                        holes[i][j].filled == holes[i+3][j+3].filled){

                    winner = holes[i][j].filled;
                    gameover = true;

                    holes[i][j].overlay.setVisibility(View.VISIBLE);
                    holes[i+1][j+1].overlay.setVisibility(View.VISIBLE);
                    holes[i+2][j+2].overlay.setVisibility(View.VISIBLE);
                    holes[i+3][j+3].overlay.setVisibility(View.VISIBLE);

                    System.out.println("Won! "+winner);
                }
            }
        }


        //checking anti-diagonal
        for(int i = standardNumRows - 1; i >= 3 ; i--){
            for(int j = 0; j < standardNumCols - 3; j++){
                if(holes[i][j].filled != GCBlack &&
                        holes[i][j].filled == holes[i-1][j+1].filled &&
                        holes[i][j].filled == holes[i-2][j+2].filled &&
                        holes[i][j].filled == holes[i-3][j+3].filled){

                    winner = holes[i][j].filled;
                    gameover = true;

                    holes[i][j].overlay.setVisibility(View.VISIBLE);
                    holes[i-1][j+1].overlay.setVisibility(View.VISIBLE);
                    holes[i-2][j+2].overlay.setVisibility(View.VISIBLE);
                    holes[i-3][j+3].overlay.setVisibility(View.VISIBLE);

                    System.out.println("Won! "+winner);
                }
            }
        }

        return winner;
    }

    private void toggleTurn(){
        turn = (turn == GCRed)?  GCYellow : GCRed;
    }

    public boolean checkBoardFull() {
        boolean boardfull = true;

        for(Hole[] array: holes){
            for(Hole h: array){
                if(h.filled == GCBlack){
                    boardfull = false;
                    break;
                }
            }
        }
        if(boardfull)
        {
            gameover = true;
        }

        return boardfull;
    }

    public int getTurn() {
        return turn;
    }



    public boolean hasWinner() {
        return (winner!=GCBlack);
    }
}

