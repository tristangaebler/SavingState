package ctec.savingstate.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import ctec.savingstate.model.AndroidSaveState;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class BackpageActivity extends AppCompatActivity {

    private AndroidSaveState saveState;
    private Button backButton;
    private TextView userText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpage);

        saveState = (AndroidSaveState) getApplication();
        backButton = (Button) findViewById(R.id.backButton);
        userText = (TextView) findViewById(R.id.backpageText);


        loadContent();

        setUpListeners();
    }



    private void loadContent() {
        userText.setText(saveState.getUserName() + "is" + saveState.getAge() + " years old and their status is " + saveState.getIsTired());
    }

    private void setUpListeners() {
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View buttonView){
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.S
        getMenuInflater().inflate(R.menu.menu_backpage, menu);
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
