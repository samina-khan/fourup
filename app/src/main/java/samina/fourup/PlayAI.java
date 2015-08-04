/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/
package samina.fourup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class PlayAI extends Activity implements View.OnClickListener,GlobalConstants{
    GameBoard gameboard = new GameBoard(standardNumRows,standardNumCols, GCPlayAI);
    TextView playerRed;
    TextView playerYellow;
    AlertDialog.Builder builder;

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playai);
        builder = new AlertDialog.Builder(this);
        playerRed = (TextView) findViewById(R.id.PlayerRed);
        playerYellow = (TextView) findViewById(R.id.PlayerYellow);

        TextView playerRedWins = (TextView) findViewById(R.id.PlayerRedWins);
        TextView playerYellowWins = (TextView) findViewById(R.id.PlayerYellowWins);

        playerRedWins.setText(Integer.toString(Arbitrator.numRedWon));
        playerYellowWins.setText(Integer.toString(Arbitrator.numYellowWon));

        setUpGameBoard();


    }

    private void setUpGameBoard() {

        associateGameBoardWithLayout();
    }

    private void associateGameBoardWithLayout() {

        for(int i = 0; i < standardNumRows; i++){
            for(int j = 0; j < standardNumCols; j++){
                gameboard.holes[i][j] = new Hole();
                gameboard.holes[i][j].filled = GCBlack;
            }
        }

        gameboard.holes[0][0].v = (ImageView) findViewById(R.id.hole00);
        gameboard.holes[0][0].overlay = (ImageView) findViewById(R.id.overlay00);
        gameboard.holes[0][1].v = (ImageView) findViewById(R.id.hole01);
        gameboard.holes[0][1].overlay = (ImageView) findViewById(R.id.overlay01);
        gameboard.holes[0][2].v = (ImageView) findViewById(R.id.hole02);
        gameboard.holes[0][2].overlay = (ImageView) findViewById(R.id.overlay02);
        gameboard.holes[0][3].v = (ImageView) findViewById(R.id.hole03);
        gameboard.holes[0][3].overlay = (ImageView) findViewById(R.id.overlay03);
        gameboard.holes[0][4].v = (ImageView) findViewById(R.id.hole04);
        gameboard.holes[0][4].overlay = (ImageView) findViewById(R.id.overlay04);
        gameboard.holes[0][5].v = (ImageView) findViewById(R.id.hole05);
        gameboard.holes[0][5].overlay = (ImageView) findViewById(R.id.overlay05);
        gameboard.holes[0][6].v = (ImageView) findViewById(R.id.hole06);
        gameboard.holes[0][6].overlay = (ImageView) findViewById(R.id.overlay06);

        gameboard.holes[1][0].v = (ImageView) findViewById(R.id.hole10);
        gameboard.holes[1][0].overlay = (ImageView) findViewById(R.id.overlay10);
        gameboard.holes[1][1].v = (ImageView) findViewById(R.id.hole11);
        gameboard.holes[1][1].overlay = (ImageView) findViewById(R.id.overlay11);
        gameboard.holes[1][2].v = (ImageView) findViewById(R.id.hole12);
        gameboard.holes[1][2].overlay = (ImageView) findViewById(R.id.overlay12);
        gameboard.holes[1][3].v = (ImageView) findViewById(R.id.hole13);
        gameboard.holes[1][3].overlay = (ImageView) findViewById(R.id.overlay13);
        gameboard.holes[1][4].v = (ImageView) findViewById(R.id.hole14);
        gameboard.holes[1][4].overlay = (ImageView) findViewById(R.id.overlay14);
        gameboard.holes[1][5].v = (ImageView) findViewById(R.id.hole15);
        gameboard.holes[1][5].overlay = (ImageView) findViewById(R.id.overlay15);
        gameboard.holes[1][6].v = (ImageView) findViewById(R.id.hole16);
        gameboard.holes[1][6].overlay = (ImageView) findViewById(R.id.overlay16);

        gameboard.holes[2][0].v = (ImageView) findViewById(R.id.hole20);
        gameboard.holes[2][0].overlay = (ImageView) findViewById(R.id.overlay20);
        gameboard.holes[2][1].v = (ImageView) findViewById(R.id.hole21);
        gameboard.holes[2][1].overlay = (ImageView) findViewById(R.id.overlay21);
        gameboard.holes[2][2].v = (ImageView) findViewById(R.id.hole22);
        gameboard.holes[2][2].overlay = (ImageView) findViewById(R.id.overlay22);
        gameboard.holes[2][3].v = (ImageView) findViewById(R.id.hole23);
        gameboard.holes[2][3].overlay = (ImageView) findViewById(R.id.overlay23);
        gameboard.holes[2][4].v = (ImageView) findViewById(R.id.hole24);
        gameboard.holes[2][4].overlay = (ImageView) findViewById(R.id.overlay24);
        gameboard.holes[2][5].v = (ImageView) findViewById(R.id.hole25);
        gameboard.holes[2][5].overlay = (ImageView) findViewById(R.id.overlay25);
        gameboard.holes[2][6].v = (ImageView) findViewById(R.id.hole26);
        gameboard.holes[2][6].overlay = (ImageView) findViewById(R.id.overlay26);

        gameboard.holes[3][0].v = (ImageView) findViewById(R.id.hole30);
        gameboard.holes[3][0].overlay = (ImageView) findViewById(R.id.overlay30);
        gameboard.holes[3][1].v = (ImageView) findViewById(R.id.hole31);
        gameboard.holes[3][1].overlay = (ImageView) findViewById(R.id.overlay31);
        gameboard.holes[3][2].v = (ImageView) findViewById(R.id.hole32);
        gameboard.holes[3][2].overlay = (ImageView) findViewById(R.id.overlay32);
        gameboard.holes[3][3].v = (ImageView) findViewById(R.id.hole33);
        gameboard.holes[3][3].overlay = (ImageView) findViewById(R.id.overlay33);
        gameboard.holes[3][4].v = (ImageView) findViewById(R.id.hole34);
        gameboard.holes[3][4].overlay = (ImageView) findViewById(R.id.overlay34);
        gameboard.holes[3][5].v = (ImageView) findViewById(R.id.hole35);
        gameboard.holes[3][5].overlay = (ImageView) findViewById(R.id.overlay35);
        gameboard.holes[3][6].v = (ImageView) findViewById(R.id.hole36);
        gameboard.holes[3][6].overlay = (ImageView) findViewById(R.id.overlay36);

        gameboard.holes[4][0].v = (ImageView) findViewById(R.id.hole40);
        gameboard.holes[4][0].overlay = (ImageView) findViewById(R.id.overlay40);
        gameboard.holes[4][1].v = (ImageView) findViewById(R.id.hole41);
        gameboard.holes[4][1].overlay = (ImageView) findViewById(R.id.overlay41);
        gameboard.holes[4][2].v = (ImageView) findViewById(R.id.hole42);
        gameboard.holes[4][2].overlay = (ImageView) findViewById(R.id.overlay42);
        gameboard.holes[4][3].v = (ImageView) findViewById(R.id.hole43);
        gameboard.holes[4][3].overlay = (ImageView) findViewById(R.id.overlay43);
        gameboard.holes[4][4].v = (ImageView) findViewById(R.id.hole44);
        gameboard.holes[4][4].overlay = (ImageView) findViewById(R.id.overlay44);
        gameboard.holes[4][5].v = (ImageView) findViewById(R.id.hole45);
        gameboard.holes[4][5].overlay = (ImageView) findViewById(R.id.overlay45);
        gameboard.holes[4][6].v = (ImageView) findViewById(R.id.hole46);
        gameboard.holes[4][6].overlay = (ImageView) findViewById(R.id.overlay46);

        gameboard.holes[5][0].v = (ImageView) findViewById(R.id.hole50);
        gameboard.holes[5][0].overlay = (ImageView) findViewById(R.id.overlay50);
        gameboard.holes[5][1].v = (ImageView) findViewById(R.id.hole51);
        gameboard.holes[5][1].overlay = (ImageView) findViewById(R.id.overlay51);
        gameboard.holes[5][2].v = (ImageView) findViewById(R.id.hole52);
        gameboard.holes[5][2].overlay = (ImageView) findViewById(R.id.overlay52);
        gameboard.holes[5][3].v = (ImageView) findViewById(R.id.hole53);
        gameboard.holes[5][3].overlay = (ImageView) findViewById(R.id.overlay53);
        gameboard.holes[5][4].v = (ImageView) findViewById(R.id.hole54);
        gameboard.holes[5][4].overlay = (ImageView) findViewById(R.id.overlay54);
        gameboard.holes[5][5].v = (ImageView) findViewById(R.id.hole55);
        gameboard.holes[5][5].overlay = (ImageView) findViewById(R.id.overlay55);
        gameboard.holes[5][6].v = (ImageView) findViewById(R.id.hole56);
        gameboard.holes[5][6].overlay = (ImageView) findViewById(R.id.overlay56);

        for(int i = 0; i < standardNumRows; i++){
            for(int j = 0; j < standardNumCols; j++){
                gameboard.holes[i][j].v.setOnClickListener(this);

            }
        }
        //Drawable[] colors = new Drawable[]{getDrawable(R.drawable.red),getDrawable(R.drawable.yellow)};
        int[] colors = new int[]{R.drawable.red,R.drawable.yellow};
        int[] overlays = new int[]{R.drawable.redhighlight,R.drawable.yellowhighlight};
        gameboard.colors = colors;
        gameboard.overlays = overlays;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_pass, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(!gameboard.gameover){
            ImageView i = (ImageView) v;
            gameboard.onclick(i);
/*
            if(gameboard.getTurn() == GCRed){
                playerRed.setTextColor(this.getResources().getColor(R.color.red));
                playerYellow.setTextColor(Color.WHITE);
            }
            else{
                playerRed.setTextColor(Color.WHITE);
                playerYellow.setTextColor(this.getResources().getColor(R.color.yellow));
            }*/

            checkWin();

        }
    }

    public void checkWin(){
        if(gameboard.checkWin() != GCBlack || gameboard.checkBoardFull()){
            if(Arbitrator.onGameEnd(gameboard.winner)==KeepGoing) {
                builder.setPositiveButton("Play next round", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent passIntent = new Intent(PlayAI.this, PlayAI.class);
                        startActivity(passIntent);
                    }
                });
                AlertDialog alertDialog = builder.create();

                if(Players[gameboard.winner].equals("Player 1")){
                    alertDialog.setTitle("Good Job, You!");
                    //image from http://www.clker.com/cliparts/R/A/q/t/b/L/gold-medal-hi.png
                    alertDialog.setIcon(R.drawable.medal);
                    alertDialog.setMessage("Round "+ (Arbitrator.numMatches - 1) +" goes to you. Three rounds to declare a winner!");
                }
                else if (Players[gameboard.winner].equals("Player 2")){
                    alertDialog.setTitle("Aww, you lose!");
                    //http://pngimg.com/upload/tie_PNG8179.png
                    alertDialog.setIcon(R.drawable.tiesmall);
                    alertDialog.setMessage("Round "+ (Arbitrator.numMatches - 1) +" goes to the evil AI. Three rounds to declare a winner!");
                }
                else{
                    alertDialog.setTitle("Well, well, well... we have a tie.");
                    //http://pngimg.com/upload/tie_PNG8179.png
                    alertDialog.setIcon(R.drawable.tiesmall);
                    alertDialog.setMessage("Round "+ (Arbitrator.numMatches - 1) +" goes to "+Players[gameboard.winner]+". Three rounds to declare a winner!");
                }

                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();

            }
            else{
                    /*
                    Intent endIntent = new Intent(v.getContext(), PlayPass.class);
                    startActivity(endIntent);*/
            }
        }
    }
    @Override
    public void onBackPressed() {
    }
}
