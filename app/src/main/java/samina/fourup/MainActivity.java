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
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements GlobalConstants{

    Button btn_AI;
    Button btn_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Pass = (Button) findViewById(R.id.btnPass);

        btn_Pass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout lila1= new LinearLayout(MainActivity.this);
                lila1.setOrientation(LinearLayout.VERTICAL);
                TextView name1 = new TextView(MainActivity.this);
                name1.setText("Enter name of Player 1");

                TextView name2 = new TextView(MainActivity.this);
                name2.setText("Enter name of Player 2");

                final EditText input1 = new EditText(MainActivity.this);
                final EditText input2 = new EditText(MainActivity.this);
                lila1.addView(name1);
                lila1.addView(input1);
                lila1.addView(name2);
                lila1.addView(input2);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(lila1);

                // Set up the buttons
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (input1.getText().toString().length() != 0) {
                            Arbitrator.Players[GCRed] = input1.getText().toString();
                        }
                        if (input2.getText().toString().length() != 0) {
                            Arbitrator.Players[GCYellow] = input2.getText().toString();
                        }
                        Intent passIntent = new Intent(MainActivity.this, PlayPass.class);
                        startActivity(passIntent);
                    }
                });
                    final AlertDialog alertdialog = builder.create();
                alertdialog.show();
                /*
                Intent passIntent = new Intent(v.getContext(), PlayAI.class);
                startActivity(passIntent);*/
            }
        });

        btn_AI = (Button) findViewById(R.id.btnAI);
        btn_AI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Enter your name:");

                // Set up the input
                final EditText input = new EditText(MainActivity.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (input.getText().toString().length() != 0) {
                            Arbitrator.Players[GCRed] = input.getText().toString();
                        }
                        Arbitrator.Players[GCYellow] = "Evil Genius";
                        Intent passIntent = new Intent(MainActivity.this, PlayAI.class);
                        startActivity(passIntent);
                    }
                });
                AlertDialog alertdialog = builder.create();
                alertdialog.setCanceledOnTouchOutside(false);
                alertdialog.show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}
