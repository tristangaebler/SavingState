package ctec.savingstate.controller;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Application;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import ctec.savingstate.model.AndroidSaveState;
import android.content.Intent;

public class FrontActivity extends Activity {

    private AndroidSaveState saveState;
    private Button sendToOtherScreenButton;
    private EditText nameText;
    private EditText ageText;
    private CheckBox tiredBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        saveState = (AndroidSaveState) getApplication();
        sendToOtherScreenButton = (Button) findViewById(R.id.submitButton);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = (EditText) findViewById(R.id.ageText);
        tiredBox = (CheckBox) findViewById(R.id.tiredBox);

        setUpListeners();
    }

    private void setUpListeners() {

        sendToOtherScreenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View clickView) {

                //Grab user input
                String name = nameText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                boolean tired = tiredBox.isChecked();

                //Save user input to the saveState
                saveState.setAge(age);
                saveState.setUserName(name);
                saveState.setIsTired(tired);

                //Open new screen
                Intent newScreenIntent = new Intent(clickView.getContext(), BackpageActivity.class);
                startActivityForResult(newScreenIntent, 0);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front, menu);
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
