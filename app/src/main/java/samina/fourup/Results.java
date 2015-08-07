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
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Results extends Activity implements View.OnClickListener,GlobalConstants{
    GameBoard gameboard = new GameBoard(standardNumRows,standardNumCols, GCPlayAI);
    TextView playerRed;
    TextView playerYellow;
    AlertDialog.Builder builder;

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        String strscore1 = getIntent().getExtras().getString("Score1");
        String strscore2 = getIntent().getExtras().getString("Score2");
        String strname1 = getIntent().getExtras().getString("Player1");
        String strname2 = getIntent().getExtras().getString("Player2");

        TextView score1 = (TextView)findViewById(R.id.score1);
        TextView score2 = (TextView)findViewById(R.id.score2);
        TextView name1 = (TextView)findViewById(R.id.PlayerRed);
        TextView name2 = (TextView)findViewById(R.id.PlayerYellow);
        TextView congrats = (TextView)findViewById(R.id.congrats);

        score1.setText(strscore1);
        score2.setText(strscore2);
        name1.setText(strname1);
        name2.setText(strname2);
        if(Integer.parseInt(strscore1)>Integer.parseInt(strscore2)){
            congrats.setText("Congrats, "+strname1+"! \nYou beat "+strname2+", fair and square!");
        }
        else if((Integer.parseInt(strscore2)>Integer.parseInt(strscore1)) && !(strname2.equals("Evil Genius"))){
            congrats.setText("Congrats, "+strname2+"! \nYou beat "+strname1+", fair and square!");
        }
        else{
            congrats.setText("Muhahahahahha...\nI can't wait to beat you at this again!");
        }


        Button nextbtn = (Button) findViewById(R.id.next);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Results.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
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
    }

    @Override
    public void onBackPressed() {
    }
}
