/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/

package samina.fourup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements GlobalConstants{

    Button btn_AI;
    Button btn_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_AI = (Button) findViewById(R.id.btnAI);
        btn_AI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Play AI",
                        Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        btn_Pass = (Button) findViewById(R.id.btnPass);
        btn_Pass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast2 = Toast.makeText(getApplicationContext(), "Play Pass",
                        Toast.LENGTH_SHORT);
                toast2.show();
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
