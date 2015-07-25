/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/
package samina.fourup;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView;


public class PlayPass extends Activity implements View.OnClickListener,GlobalConstants{
    GameBoard gameboard = new GameBoard(standardNumRows,standardNumCols);

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playpass);


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
        gameboard.holes[0][1].v = (ImageView) findViewById(R.id.hole01);
        gameboard.holes[0][2].v = (ImageView) findViewById(R.id.hole02);
        gameboard.holes[0][3].v = (ImageView) findViewById(R.id.hole03);
        gameboard.holes[0][4].v = (ImageView) findViewById(R.id.hole04);
        gameboard.holes[0][5].v = (ImageView) findViewById(R.id.hole05);
        gameboard.holes[0][6].v = (ImageView) findViewById(R.id.hole06);

        gameboard.holes[1][0].v = (ImageView) findViewById(R.id.hole10);
        gameboard.holes[1][1].v = (ImageView) findViewById(R.id.hole11);
        gameboard.holes[1][2].v = (ImageView) findViewById(R.id.hole12);
        gameboard.holes[1][3].v = (ImageView) findViewById(R.id.hole13);
        gameboard.holes[1][4].v = (ImageView) findViewById(R.id.hole14);
        gameboard.holes[1][5].v = (ImageView) findViewById(R.id.hole15);
        gameboard.holes[1][6].v = (ImageView) findViewById(R.id.hole16);

        gameboard.holes[2][0].v = (ImageView) findViewById(R.id.hole20);
        gameboard.holes[2][1].v = (ImageView) findViewById(R.id.hole21);
        gameboard.holes[2][2].v = (ImageView) findViewById(R.id.hole22);
        gameboard.holes[2][3].v = (ImageView) findViewById(R.id.hole23);
        gameboard.holes[2][4].v = (ImageView) findViewById(R.id.hole24);
        gameboard.holes[2][5].v = (ImageView) findViewById(R.id.hole25);
        gameboard.holes[2][6].v = (ImageView) findViewById(R.id.hole26);

        gameboard.holes[3][0].v = (ImageView) findViewById(R.id.hole30);
        gameboard.holes[3][1].v = (ImageView) findViewById(R.id.hole31);
        gameboard.holes[3][2].v = (ImageView) findViewById(R.id.hole32);
        gameboard.holes[3][3].v = (ImageView) findViewById(R.id.hole33);
        gameboard.holes[3][4].v = (ImageView) findViewById(R.id.hole34);
        gameboard.holes[3][5].v = (ImageView) findViewById(R.id.hole35);
        gameboard.holes[3][6].v = (ImageView) findViewById(R.id.hole36);

        gameboard.holes[4][0].v = (ImageView) findViewById(R.id.hole40);
        gameboard.holes[4][1].v = (ImageView) findViewById(R.id.hole41);
        gameboard.holes[4][2].v = (ImageView) findViewById(R.id.hole42);
        gameboard.holes[4][3].v = (ImageView) findViewById(R.id.hole43);
        gameboard.holes[4][4].v = (ImageView) findViewById(R.id.hole44);
        gameboard.holes[4][5].v = (ImageView) findViewById(R.id.hole45);
        gameboard.holes[4][6].v = (ImageView) findViewById(R.id.hole46);

        gameboard.holes[5][0].v = (ImageView) findViewById(R.id.hole50);
        gameboard.holes[5][1].v = (ImageView) findViewById(R.id.hole51);
        gameboard.holes[5][2].v = (ImageView) findViewById(R.id.hole52);
        gameboard.holes[5][3].v = (ImageView) findViewById(R.id.hole53);
        gameboard.holes[5][4].v = (ImageView) findViewById(R.id.hole54);
        gameboard.holes[5][5].v = (ImageView) findViewById(R.id.hole55);
        gameboard.holes[5][6].v = (ImageView) findViewById(R.id.hole56);

        for(int i = 0; i < standardNumRows; i++){
            for(int j = 0; j < standardNumCols; j++){
                gameboard.holes[i][j].v.setOnClickListener(this);

            }
        }
        //Drawable[] colors = new Drawable[]{getDrawable(R.drawable.red),getDrawable(R.drawable.yellow)};
        int[] colors = new int[]{R.drawable.red,R.drawable.yellow};
        gameboard.colors = colors;
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
                ImageView i = (ImageView) v;
                gameboard.onclick(i);
                //i.setImageResource(R.drawable.red);
    }
}
